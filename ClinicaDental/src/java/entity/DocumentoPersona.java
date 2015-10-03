/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "DOCUMENTO_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoPersona.findAll", query = "SELECT d FROM DocumentoPersona d"),
    @NamedQuery(name = "DocumentoPersona.findByPersona", query = "SELECT d FROM DocumentoPersona d WHERE d.documentoPersonaPK.persona = :persona"),
    @NamedQuery(name = "DocumentoPersona.findByTipoDocumento", query = "SELECT d FROM DocumentoPersona d WHERE d.documentoPersonaPK.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "DocumentoPersona.findByNumero", query = "SELECT d FROM DocumentoPersona d WHERE d.numero = :numero")})
public class DocumentoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPersonaPK documentoPersonaPK;
    @Size(max = 100)
    @Column(name = "NUMERO")
    private String numero;
    @JoinColumn(name = "PERSONA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;

    public DocumentoPersona() {
    }

    public DocumentoPersona(DocumentoPersonaPK documentoPersonaPK) {
        this.documentoPersonaPK = documentoPersonaPK;
    }

    public DocumentoPersona(BigInteger persona, BigInteger tipoDocumento) {
        this.documentoPersonaPK = new DocumentoPersonaPK(persona, tipoDocumento);
    }

    public DocumentoPersonaPK getDocumentoPersonaPK() {
        return documentoPersonaPK;
    }

    public void setDocumentoPersonaPK(DocumentoPersonaPK documentoPersonaPK) {
        this.documentoPersonaPK = documentoPersonaPK;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPersonaPK != null ? documentoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPersona)) {
            return false;
        }
        DocumentoPersona other = (DocumentoPersona) object;
        if ((this.documentoPersonaPK == null && other.documentoPersonaPK != null) || (this.documentoPersonaPK != null && !this.documentoPersonaPK.equals(other.documentoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DocumentoPersona[ documentoPersonaPK=" + documentoPersonaPK + " ]";
    }
    
}

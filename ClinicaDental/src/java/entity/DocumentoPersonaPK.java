/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario1
 */
@Embeddable
public class DocumentoPersonaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA")
    private BigInteger persona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_DOCUMENTO")
    private BigInteger tipoDocumento;

    public DocumentoPersonaPK() {
    }

    public DocumentoPersonaPK(BigInteger persona, BigInteger tipoDocumento) {
        this.persona = persona;
        this.tipoDocumento = tipoDocumento;
    }

    public BigInteger getPersona() {
        return persona;
    }

    public void setPersona(BigInteger persona) {
        this.persona = persona;
    }

    public BigInteger getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(BigInteger tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persona != null ? persona.hashCode() : 0);
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPersonaPK)) {
            return false;
        }
        DocumentoPersonaPK other = (DocumentoPersonaPK) object;
        if ((this.persona == null && other.persona != null) || (this.persona != null && !this.persona.equals(other.persona))) {
            return false;
        }
        if ((this.tipoDocumento == null && other.tipoDocumento != null) || (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DocumentoPersonaPK[ persona=" + persona + ", tipoDocumento=" + tipoDocumento + " ]";
    }
    
}

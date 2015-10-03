/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "TIPO_PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaciente.findAll", query = "SELECT t FROM TipoPaciente t"),
    @NamedQuery(name = "TipoPaciente.findById", query = "SELECT t FROM TipoPaciente t WHERE t.id = :id"),
    @NamedQuery(name = "TipoPaciente.findByTipo", query = "SELECT t FROM TipoPaciente t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TipoPaciente.findByActivo", query = "SELECT t FROM TipoPaciente t WHERE t.activo = :activo")})
public class TipoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private Character activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPaciente")
    private Collection<Paciente> pacienteCollection;

    public TipoPaciente() {
    }

    public TipoPaciente(BigDecimal id) {
        this.id = id;
    }

    public TipoPaciente(BigDecimal id, String tipo, Character activo) {
        this.id = id;
        this.tipo = tipo;
        this.activo = activo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaciente)) {
            return false;
        }
        TipoPaciente other = (TipoPaciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoPaciente[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRABAJO_CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajoCita.findAll", query = "SELECT t FROM TrabajoCita t"),
    @NamedQuery(name = "TrabajoCita.findById", query = "SELECT t FROM TrabajoCita t WHERE t.id = :id"),
    @NamedQuery(name = "TrabajoCita.findByObservacion", query = "SELECT t FROM TrabajoCita t WHERE t.observacion = :observacion"),
    @NamedQuery(name = "TrabajoCita.findByEstado", query = "SELECT t FROM TrabajoCita t WHERE t.estado = :estado")})
public class TrabajoCita implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 500)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ESTADO")
    private Character estado;
    @JoinColumn(name = "CITA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cita cita;
    @JoinColumn(name = "TRABAJO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Trabajo trabajo;
    @OneToMany(mappedBy = "trabajoCita")
    private Collection<TrabajoCita> trabajoCitaCollection;
    @JoinColumn(name = "TRABAJO_CITA", referencedColumnName = "ID")
    @ManyToOne
    private TrabajoCita trabajoCita;

    public TrabajoCita() {
    }

    public TrabajoCita(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    @XmlTransient
    public Collection<TrabajoCita> getTrabajoCitaCollection() {
        return trabajoCitaCollection;
    }

    public void setTrabajoCitaCollection(Collection<TrabajoCita> trabajoCitaCollection) {
        this.trabajoCitaCollection = trabajoCitaCollection;
    }

    public TrabajoCita getTrabajoCita() {
        return trabajoCita;
    }

    public void setTrabajoCita(TrabajoCita trabajoCita) {
        this.trabajoCita = trabajoCita;
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
        if (!(object instanceof TrabajoCita)) {
            return false;
        }
        TrabajoCita other = (TrabajoCita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TrabajoCita[ id=" + id + " ]";
    }
    
}

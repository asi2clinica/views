/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "TRABAJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajo.findAll", query = "SELECT t FROM Trabajo t"),
    @NamedQuery(name = "Trabajo.findById", query = "SELECT t FROM Trabajo t WHERE t.id = :id"),
    @NamedQuery(name = "Trabajo.findByNombre", query = "SELECT t FROM Trabajo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Trabajo.findByDescripcion", query = "SELECT t FROM Trabajo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Trabajo.findByTipo", query = "SELECT t FROM Trabajo t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Trabajo.findByCosto", query = "SELECT t FROM Trabajo t WHERE t.costo = :costo"),
    @NamedQuery(name = "Trabajo.findByObservacion", query = "SELECT t FROM Trabajo t WHERE t.observacion = :observacion")})
public class Trabajo implements Serializable {
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
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO")
    private Character tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigInteger costo;
    @Size(max = 500)
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajo")
    private Collection<TrabajoCita> trabajoCitaCollection;

    public Trabajo() {
    }

    public Trabajo(BigDecimal id) {
        this.id = id;
    }

    public Trabajo(BigDecimal id, String nombre, Character tipo, BigInteger costo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.costo = costo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<TrabajoCita> getTrabajoCitaCollection() {
        return trabajoCitaCollection;
    }

    public void setTrabajoCitaCollection(Collection<TrabajoCita> trabajoCitaCollection) {
        this.trabajoCitaCollection = trabajoCitaCollection;
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
        if (!(object instanceof Trabajo)) {
            return false;
        }
        Trabajo other = (Trabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Trabajo[ id=" + id + " ]";
    }
    
}

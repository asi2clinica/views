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
@Table(name = "PIEZAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piezas.findAll", query = "SELECT p FROM Piezas p"),
    @NamedQuery(name = "Piezas.findById", query = "SELECT p FROM Piezas p WHERE p.id = :id"),
    @NamedQuery(name = "Piezas.findByCodigo", query = "SELECT p FROM Piezas p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Piezas.findByDescripcion", query = "SELECT p FROM Piezas p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Piezas.findByActivo", query = "SELECT p FROM Piezas p WHERE p.activo = :activo")})
public class Piezas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ACTIVO")
    private Character activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piezas")
    private Collection<Odontograma> odontogramaCollection;

    public Piezas() {
    }

    public Piezas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Odontograma> getOdontogramaCollection() {
        return odontogramaCollection;
    }

    public void setOdontogramaCollection(Collection<Odontograma> odontogramaCollection) {
        this.odontogramaCollection = odontogramaCollection;
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
        if (!(object instanceof Piezas)) {
            return false;
        }
        Piezas other = (Piezas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Piezas[ id=" + id + " ]";
    }
    
}

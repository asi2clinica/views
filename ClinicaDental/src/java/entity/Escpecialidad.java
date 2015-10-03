/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "ESCPECIALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escpecialidad.findAll", query = "SELECT e FROM Escpecialidad e"),
    @NamedQuery(name = "Escpecialidad.findById", query = "SELECT e FROM Escpecialidad e WHERE e.id = :id"),
    @NamedQuery(name = "Escpecialidad.findByNombre", query = "SELECT e FROM Escpecialidad e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Escpecialidad.findByActivo", query = "SELECT e FROM Escpecialidad e WHERE e.activo = :activo")})
public class Escpecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 180)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private Character activo;

    public Escpecialidad() {
    }

    public Escpecialidad(BigDecimal id) {
        this.id = id;
    }

    public Escpecialidad(BigDecimal id, String nombre, Character activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
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

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
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
        if (!(object instanceof Escpecialidad)) {
            return false;
        }
        Escpecialidad other = (Escpecialidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Escpecialidad[ id=" + id + " ]";
    }
    
}

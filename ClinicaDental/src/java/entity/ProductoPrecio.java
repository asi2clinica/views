/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "PRODUCTO_PRECIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPrecio.findAll", query = "SELECT p FROM ProductoPrecio p"),
    @NamedQuery(name = "ProductoPrecio.findById", query = "SELECT p FROM ProductoPrecio p WHERE p.id = :id"),
    @NamedQuery(name = "ProductoPrecio.findByPrecio", query = "SELECT p FROM ProductoPrecio p WHERE p.precio = :precio"),
    @NamedQuery(name = "ProductoPrecio.findByActivo", query = "SELECT p FROM ProductoPrecio p WHERE p.activo = :activo"),
    @NamedQuery(name = "ProductoPrecio.findByFecha", query = "SELECT p FROM ProductoPrecio p WHERE p.fecha = :fecha")})
public class ProductoPrecio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PRECIO")
    private BigInteger precio;
    @Column(name = "ACTIVO")
    private Character activo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto productoId;

    public ProductoPrecio() {
    }

    public ProductoPrecio(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
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
        if (!(object instanceof ProductoPrecio)) {
            return false;
        }
        ProductoPrecio other = (ProductoPrecio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductoPrecio[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "PRODUCTO_CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoCita.findAll", query = "SELECT p FROM ProductoCita p"),
    @NamedQuery(name = "ProductoCita.findByProducto", query = "SELECT p FROM ProductoCita p WHERE p.productoCitaPK.producto = :producto"),
    @NamedQuery(name = "ProductoCita.findByCita", query = "SELECT p FROM ProductoCita p WHERE p.productoCitaPK.cita = :cita"),
    @NamedQuery(name = "ProductoCita.findByCantidad", query = "SELECT p FROM ProductoCita p WHERE p.cantidad = :cantidad")})
public class ProductoCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoCitaPK productoCitaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "CITA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cita cita1;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto1;

    public ProductoCita() {
    }

    public ProductoCita(ProductoCitaPK productoCitaPK) {
        this.productoCitaPK = productoCitaPK;
    }

    public ProductoCita(ProductoCitaPK productoCitaPK, BigInteger cantidad) {
        this.productoCitaPK = productoCitaPK;
        this.cantidad = cantidad;
    }

    public ProductoCita(BigInteger producto, BigInteger cita) {
        this.productoCitaPK = new ProductoCitaPK(producto, cita);
    }

    public ProductoCitaPK getProductoCitaPK() {
        return productoCitaPK;
    }

    public void setProductoCitaPK(ProductoCitaPK productoCitaPK) {
        this.productoCitaPK = productoCitaPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Cita getCita1() {
        return cita1;
    }

    public void setCita1(Cita cita1) {
        this.cita1 = cita1;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoCitaPK != null ? productoCitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCita)) {
            return false;
        }
        ProductoCita other = (ProductoCita) object;
        if ((this.productoCitaPK == null && other.productoCitaPK != null) || (this.productoCitaPK != null && !this.productoCitaPK.equals(other.productoCitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductoCita[ productoCitaPK=" + productoCitaPK + " ]";
    }
    
}

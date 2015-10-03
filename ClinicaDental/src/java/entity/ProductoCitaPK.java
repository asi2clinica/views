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
public class ProductoCitaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO")
    private BigInteger producto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CITA")
    private BigInteger cita;

    public ProductoCitaPK() {
    }

    public ProductoCitaPK(BigInteger producto, BigInteger cita) {
        this.producto = producto;
        this.cita = cita;
    }

    public BigInteger getProducto() {
        return producto;
    }

    public void setProducto(BigInteger producto) {
        this.producto = producto;
    }

    public BigInteger getCita() {
        return cita;
    }

    public void setCita(BigInteger cita) {
        this.cita = cita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producto != null ? producto.hashCode() : 0);
        hash += (cita != null ? cita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCitaPK)) {
            return false;
        }
        ProductoCitaPK other = (ProductoCitaPK) object;
        if ((this.producto == null && other.producto != null) || (this.producto != null && !this.producto.equals(other.producto))) {
            return false;
        }
        if ((this.cita == null && other.cita != null) || (this.cita != null && !this.cita.equals(other.cita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductoCitaPK[ producto=" + producto + ", cita=" + cita + " ]";
    }
    
}

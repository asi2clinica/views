/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
 * @author Developer
 */
@Entity
@Table(name = "ROL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r"),
    @NamedQuery(name = "RolUsuario.findById", query = "SELECT r FROM RolUsuario r WHERE r.id = :id"),
    @NamedQuery(name = "RolUsuario.findByNombre", query = "SELECT r FROM RolUsuario r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RolUsuario.findByEstado", query = "SELECT r FROM RolUsuario r WHERE r.estado = :estado"),
    @NamedQuery(name = "RolUsuario.findByDescripcion", query = "SELECT r FROM RolUsuario r WHERE r.descripcion = :descripcion")})
public class RolUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ESTADO")
    private Character estado;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "IDPERMISO", referencedColumnName = "ID")
    @ManyToOne
    private CatPermiso idpermiso;
    @JoinColumn(name = "IDTIPOROL", referencedColumnName = "ID")
    @ManyToOne
    private CatTiposRol idtiporol;
    @OneToMany(mappedBy = "idrolusuario")
    private List<Usuario> usuarioList;

    public RolUsuario() {
    }

    public RolUsuario(BigDecimal id) {
        this.id = id;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CatPermiso getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(CatPermiso idpermiso) {
        this.idpermiso = idpermiso;
    }

    public CatTiposRol getIdtiporol() {
        return idtiporol;
    }

    public void setIdtiporol(CatTiposRol idtiporol) {
        this.idtiporol = idtiporol;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof RolUsuario)) {
            return false;
        }
        RolUsuario other = (RolUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RolUsuario[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "DOCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByEmpleado", query = "SELECT d FROM Doctor d WHERE d.empleado = :empleado"),
    @NamedQuery(name = "Doctor.findByNJvpm", query = "SELECT d FROM Doctor d WHERE d.nJvpm = :nJvpm"),
    @NamedQuery(name = "Doctor.findByFoto", query = "SELECT d FROM Doctor d WHERE d.foto = :foto"),
    @NamedQuery(name = "Doctor.findByActivo", query = "SELECT d FROM Doctor d WHERE d.activo = :activo")})
public class Doctor implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor1")
    private Collection<DoctorEspecialidad> doctorEspecialidadCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLEADO")
    private BigDecimal empleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "N_JVPM")
    private String nJvpm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FOTO")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private Character activo;
    @JoinColumn(name = "EMPLEADO", referencedColumnName = "PERSONA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado1;

    public Doctor() {
    }

    public Doctor(BigDecimal empleado) {
        this.empleado = empleado;
    }

    public Doctor(BigDecimal empleado, String nJvpm, String foto, Character activo) {
        this.empleado = empleado;
        this.nJvpm = nJvpm;
        this.foto = foto;
        this.activo = activo;
    }

    public BigDecimal getEmpleado() {
        return empleado;
    }

    public void setEmpleado(BigDecimal empleado) {
        this.empleado = empleado;
    }

    public String getNJvpm() {
        return nJvpm;
    }

    public void setNJvpm(String nJvpm) {
        this.nJvpm = nJvpm;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public Empleado getEmpleado1() {
        return empleado1;
    }

    public void setEmpleado1(Empleado empleado1) {
        this.empleado1 = empleado1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleado != null ? empleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.empleado == null && other.empleado != null) || (this.empleado != null && !this.empleado.equals(other.empleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Doctor[ empleado=" + empleado + " ]";
    }

    @XmlTransient
    public Collection<DoctorEspecialidad> getDoctorEspecialidadCollection() {
        return doctorEspecialidadCollection;
    }

    public void setDoctorEspecialidadCollection(Collection<DoctorEspecialidad> doctorEspecialidadCollection) {
        this.doctorEspecialidadCollection = doctorEspecialidadCollection;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "DOCTOR_ESPECIALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoctorEspecialidad.findAll", query = "SELECT d FROM DoctorEspecialidad d"),
    @NamedQuery(name = "DoctorEspecialidad.findByDoctor", query = "SELECT d FROM DoctorEspecialidad d WHERE d.doctorEspecialidadPK.doctor = :doctor"),
    @NamedQuery(name = "DoctorEspecialidad.findByEscpecialidad", query = "SELECT d FROM DoctorEspecialidad d WHERE d.doctorEspecialidadPK.escpecialidad = :escpecialidad")})
public class DoctorEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DoctorEspecialidadPK doctorEspecialidadPK;
    @JoinColumn(name = "DOCTOR", referencedColumnName = "EMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Doctor doctor1;

    public DoctorEspecialidad() {
    }

    public DoctorEspecialidad(DoctorEspecialidadPK doctorEspecialidadPK) {
        this.doctorEspecialidadPK = doctorEspecialidadPK;
    }

    public DoctorEspecialidad(BigInteger doctor, BigInteger escpecialidad) {
        this.doctorEspecialidadPK = new DoctorEspecialidadPK(doctor, escpecialidad);
    }

    public DoctorEspecialidadPK getDoctorEspecialidadPK() {
        return doctorEspecialidadPK;
    }

    public void setDoctorEspecialidadPK(DoctorEspecialidadPK doctorEspecialidadPK) {
        this.doctorEspecialidadPK = doctorEspecialidadPK;
    }

    public Doctor getDoctor1() {
        return doctor1;
    }

    public void setDoctor1(Doctor doctor1) {
        this.doctor1 = doctor1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorEspecialidadPK != null ? doctorEspecialidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorEspecialidad)) {
            return false;
        }
        DoctorEspecialidad other = (DoctorEspecialidad) object;
        if ((this.doctorEspecialidadPK == null && other.doctorEspecialidadPK != null) || (this.doctorEspecialidadPK != null && !this.doctorEspecialidadPK.equals(other.doctorEspecialidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DoctorEspecialidad[ doctorEspecialidadPK=" + doctorEspecialidadPK + " ]";
    }
    
}

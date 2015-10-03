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
public class DoctorEspecialidadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCTOR")
    private BigInteger doctor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESCPECIALIDAD")
    private BigInteger escpecialidad;

    public DoctorEspecialidadPK() {
    }

    public DoctorEspecialidadPK(BigInteger doctor, BigInteger escpecialidad) {
        this.doctor = doctor;
        this.escpecialidad = escpecialidad;
    }

    public BigInteger getDoctor() {
        return doctor;
    }

    public void setDoctor(BigInteger doctor) {
        this.doctor = doctor;
    }

    public BigInteger getEscpecialidad() {
        return escpecialidad;
    }

    public void setEscpecialidad(BigInteger escpecialidad) {
        this.escpecialidad = escpecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctor != null ? doctor.hashCode() : 0);
        hash += (escpecialidad != null ? escpecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorEspecialidadPK)) {
            return false;
        }
        DoctorEspecialidadPK other = (DoctorEspecialidadPK) object;
        if ((this.doctor == null && other.doctor != null) || (this.doctor != null && !this.doctor.equals(other.doctor))) {
            return false;
        }
        if ((this.escpecialidad == null && other.escpecialidad != null) || (this.escpecialidad != null && !this.escpecialidad.equals(other.escpecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DoctorEspecialidadPK[ doctor=" + doctor + ", escpecialidad=" + escpecialidad + " ]";
    }
    
}

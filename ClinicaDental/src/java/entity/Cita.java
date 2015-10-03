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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findById", query = "SELECT c FROM Cita c WHERE c.id = :id"),
    @NamedQuery(name = "Cita.findByPrimera", query = "SELECT c FROM Cita c WHERE c.primera = :primera"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByDoctor", query = "SELECT c FROM Cita c WHERE c.doctor = :doctor")})
public class Cita implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cita1")
    private Collection<ProductoCita> productoCitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citaId")
    private Collection<Venta> ventaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citaId")
    private Collection<Respuesta> respuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cita")
    private Collection<TrabajoCita> trabajoCitaCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PRIMERA")
    private BigInteger primera;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Lob
    @Column(name = "OBSERVACION")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCTOR")
    private BigInteger doctor;
    @JoinColumn(name = "ESTADO_CITA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoCita estadoCita;
    @JoinColumn(name = "PACIENTE_PERSONA", referencedColumnName = "PERSONA")
    @ManyToOne(optional = false)
    private Paciente pacientePersona;
    @JoinColumn(name = "SUCURSAL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursal;

    public Cita() {
    }

    public Cita(BigDecimal id) {
        this.id = id;
    }

    public Cita(BigDecimal id, BigInteger doctor) {
        this.id = id;
        this.doctor = doctor;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPrimera() {
        return primera;
    }

    public void setPrimera(BigInteger primera) {
        this.primera = primera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigInteger getDoctor() {
        return doctor;
    }

    public void setDoctor(BigInteger doctor) {
        this.doctor = doctor;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Paciente getPacientePersona() {
        return pacientePersona;
    }

    public void setPacientePersona(Paciente pacientePersona) {
        this.pacientePersona = pacientePersona;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cita[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ProductoCita> getProductoCitaCollection() {
        return productoCitaCollection;
    }

    public void setProductoCitaCollection(Collection<ProductoCita> productoCitaCollection) {
        this.productoCitaCollection = productoCitaCollection;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    @XmlTransient
    public Collection<TrabajoCita> getTrabajoCitaCollection() {
        return trabajoCitaCollection;
    }

    public void setTrabajoCitaCollection(Collection<TrabajoCita> trabajoCitaCollection) {
        this.trabajoCitaCollection = trabajoCitaCollection;
    }
    
}

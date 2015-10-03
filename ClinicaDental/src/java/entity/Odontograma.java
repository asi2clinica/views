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
@Table(name = "ODONTOGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odontograma.findAll", query = "SELECT o FROM Odontograma o"),
    @NamedQuery(name = "Odontograma.findById", query = "SELECT o FROM Odontograma o WHERE o.id = :id"),
    @NamedQuery(name = "Odontograma.findByPaciente", query = "SELECT o FROM Odontograma o WHERE o.paciente = :paciente"),
    @NamedQuery(name = "Odontograma.findByFecha", query = "SELECT o FROM Odontograma o WHERE o.fecha = :fecha")})
public class Odontograma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PACIENTE")
    private BigInteger paciente;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ESTADO_PIEZA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoPieza estadoPieza;
    @JoinColumn(name = "PACIENTE_PERSONA", referencedColumnName = "PERSONA")
    @ManyToOne(optional = false)
    private Paciente pacientePersona;
    @JoinColumn(name = "PIEZAS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Piezas piezas;

    public Odontograma() {
    }

    public Odontograma(BigDecimal id) {
        this.id = id;
    }

    public Odontograma(BigDecimal id, BigInteger paciente) {
        this.id = id;
        this.paciente = paciente;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPaciente() {
        return paciente;
    }

    public void setPaciente(BigInteger paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoPieza getEstadoPieza() {
        return estadoPieza;
    }

    public void setEstadoPieza(EstadoPieza estadoPieza) {
        this.estadoPieza = estadoPieza;
    }

    public Paciente getPacientePersona() {
        return pacientePersona;
    }

    public void setPacientePersona(Paciente pacientePersona) {
        this.pacientePersona = pacientePersona;
    }

    public Piezas getPiezas() {
        return piezas;
    }

    public void setPiezas(Piezas piezas) {
        this.piezas = piezas;
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
        if (!(object instanceof Odontograma)) {
            return false;
        }
        Odontograma other = (Odontograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Odontograma[ id=" + id + " ]";
    }
    
}

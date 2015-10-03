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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "RESPUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findById", query = "SELECT r FROM Respuesta r WHERE r.id = :id"),
    @NamedQuery(name = "Respuesta.findBySino", query = "SELECT r FROM Respuesta r WHERE r.sino = :sino"),
    @NamedQuery(name = "Respuesta.findByRespuestaAbierta", query = "SELECT r FROM Respuesta r WHERE r.respuestaAbierta = :respuestaAbierta")})
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SINO")
    private Character sino;
    @Size(max = 500)
    @Column(name = "RESPUESTA_ABIERTA")
    private String respuestaAbierta;
    @JoinColumn(name = "CITA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cita citaId;
    @JoinColumn(name = "PREGUNTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public Respuesta() {
    }

    public Respuesta(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getSino() {
        return sino;
    }

    public void setSino(Character sino) {
        this.sino = sino;
    }

    public String getRespuestaAbierta() {
        return respuestaAbierta;
    }

    public void setRespuestaAbierta(String respuestaAbierta) {
        this.respuestaAbierta = respuestaAbierta;
    }

    public Cita getCitaId() {
        return citaId;
    }

    public void setCitaId(Cita citaId) {
        this.citaId = citaId;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
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
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Respuesta[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByPersona", query = "SELECT p FROM Paciente p WHERE p.persona = :persona"),
    @NamedQuery(name = "Paciente.findByFoto", query = "SELECT p FROM Paciente p WHERE p.foto = :foto"),
    @NamedQuery(name = "Paciente.findByRefiere", query = "SELECT p FROM Paciente p WHERE p.refiere = :refiere"),
    @NamedQuery(name = "Paciente.findByActivo", query = "SELECT p FROM Paciente p WHERE p.activo = :activo"),
    @NamedQuery(name = "Paciente.findByEncargado", query = "SELECT p FROM Paciente p WHERE p.encargado = :encargado")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA")
    private BigDecimal persona;
    @Size(max = 255)
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 200)
    @Column(name = "REFIERE")
    private String refiere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private Character activo;
    @Size(max = 180)
    @Column(name = "ENCARGADO")
    private String encargado;
    @JoinColumn(name = "PERSONA", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona1;
    @JoinColumn(name = "TIPO_PACIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoPaciente tipoPaciente;

    public Paciente() {
    }

    public Paciente(BigDecimal persona) {
        this.persona = persona;
    }

    public Paciente(BigDecimal persona, Character activo) {
        this.persona = persona;
        this.activo = activo;
    }

    public BigDecimal getPersona() {
        return persona;
    }

    public void setPersona(BigDecimal persona) {
        this.persona = persona;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRefiere() {
        return refiere;
    }

    public void setRefiere(String refiere) {
        this.refiere = refiere;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public TipoPaciente getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(TipoPaciente tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persona != null ? persona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.persona == null && other.persona != null) || (this.persona != null && !this.persona.equals(other.persona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paciente[ persona=" + persona + " ]";
    }
    
}

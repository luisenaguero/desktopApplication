/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eddie Master
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByDetactiv", query = "SELECT a FROM Actividad a WHERE a.detactiv = :detactiv"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.findByCodactiv", query = "SELECT a FROM Actividad a WHERE a.codactiv = :codactiv")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "detactiv")
    private String detactiv;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Column(name = "codactiv")
    private Short codactiv;
    @JoinColumn(name = "codsector", referencedColumnName = "codsector")
    @ManyToOne
    private Sector codsector;
    @JoinColumn(name = "codprogr", referencedColumnName = "codprogr")
    @ManyToOne
    private Programa codprogr;
    @OneToMany(mappedBy = "codactiv")
    private Collection<Obra> obraCollection;
    @OneToMany(mappedBy = "codactiv")
    private Collection<Proyecto> proyectoCollection;

    public Actividad() {
    }

    public Actividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getDetactiv() {
        return detactiv;
    }

    public void setDetactiv(String detactiv) {
        this.detactiv = detactiv;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Short getCodactiv() {
        return codactiv;
    }

    public void setCodactiv(Short codactiv) {
        this.codactiv = codactiv;
    }

    public Sector getCodsector() {
        return codsector;
    }

    public void setCodsector(Sector codsector) {
        this.codsector = codsector;
    }

    public Programa getCodprogr() {
        return codprogr;
    }

    public void setCodprogr(Programa codprogr) {
        this.codprogr = codprogr;
    }

    @XmlTransient
    public Collection<Obra> getObraCollection() {
        return obraCollection;
    }

    public void setObraCollection(Collection<Obra> obraCollection) {
        this.obraCollection = obraCollection;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

  
}

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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByDetproye", query = "SELECT p FROM Proyecto p WHERE p.detproye = :detproye"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByCodproye", query = "SELECT p FROM Proyecto p WHERE p.codproye = :codproye")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "detproye")
    private String detproye;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Column(name = "codproye")
    private Short codproye;
    @OneToMany(mappedBy = "codproye")
    private Collection<Obra> obraCollection;
    @JoinColumn(name = "codsector", referencedColumnName = "codsector")
    @ManyToOne
    private Sector codsector;
    @JoinColumn(name = "codprogr", referencedColumnName = "codprogr")
    @ManyToOne
    private Programa codprogr;
    @JoinColumn(name = "codactiv", referencedColumnName = "codactiv")
    @ManyToOne
    private Actividad codactiv;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDetproye() {
        return detproye;
    }

    public void setDetproye(String detproye) {
        this.detproye = detproye;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Short getCodproye() {
        return codproye;
    }

    public void setCodproye(Short codproye) {
        this.codproye = codproye;
    }

    @XmlTransient
    public Collection<Obra> getObraCollection() {
        return obraCollection;
    }

    public void setObraCollection(Collection<Obra> obraCollection) {
        this.obraCollection = obraCollection;
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

    public Actividad getCodactiv() {
        return codactiv;
    }

    public void setCodactiv(Actividad codactiv) {
        this.codactiv = codactiv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.entities.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}

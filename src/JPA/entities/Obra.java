/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddie Master
 */
@Entity
@Table(name = "obra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o"),
    @NamedQuery(name = "Obra.findByObra", query = "SELECT o FROM Obra o WHERE o.obra = :obra"),
    @NamedQuery(name = "Obra.findByDetobra", query = "SELECT o FROM Obra o WHERE o.detobra = :detobra"),
    @NamedQuery(name = "Obra.findByIdObra", query = "SELECT o FROM Obra o WHERE o.idObra = :idObra")})
public class Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "obra")
    private String obra;
    @Column(name = "detobra")
    private String detobra;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_obra")
    private Integer idObra;
    @JoinColumn(name = "codsector", referencedColumnName = "codsector")
    @ManyToOne
    private Sector codsector;
    @JoinColumn(name = "codproye", referencedColumnName = "codproye")
    @ManyToOne
    private Proyecto codproye;
    @JoinColumn(name = "codprogr", referencedColumnName = "codprogr")
    @ManyToOne
    private Programa codprogr;
    @JoinColumn(name = "codactiv", referencedColumnName = "codactiv")
    @ManyToOne
    private Actividad codactiv;

    public Obra() {
    }

    public Obra(Integer idObra) {
        this.idObra = idObra;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getDetobra() {
        return detobra;
    }

    public void setDetobra(String detobra) {
        this.detobra = detobra;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }

    public Sector getCodsector() {
        return codsector;
    }

    public void setCodsector(Sector codsector) {
        this.codsector = codsector;
    }

    public Proyecto getCodproye() {
        return codproye;
    }

    public void setCodproye(Proyecto codproye) {
        this.codproye = codproye;
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
        hash += (idObra != null ? idObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.idObra == null && other.idObra != null) || (this.idObra != null && !this.idObra.equals(other.idObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.entities.Obra[ idObra=" + idObra + " ]";
    }
    
}

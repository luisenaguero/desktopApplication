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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddie Master
 */
@Entity
@Table(name = "tipdocum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipdocum.findAll", query = "SELECT t FROM Tipdocum t"),
    @NamedQuery(name = "Tipdocum.findByIdTipdocum", query = "SELECT t FROM Tipdocum t WHERE t.idTipdocum = :idTipdocum"),
    @NamedQuery(name = "Tipdocum.findByNombtipo", query = "SELECT t FROM Tipdocum t WHERE t.nombtipo = :nombtipo"),
    @NamedQuery(name = "Tipdocum.findByConsecu", query = "SELECT t FROM Tipdocum t WHERE t.consecu = :consecu"),
    @NamedQuery(name = "Tipdocum.findByCoditipo", query = "SELECT t FROM Tipdocum t WHERE t.coditipo = :coditipo")})
public class Tipdocum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipdocum")
    private Integer idTipdocum;
    @Column(name = "nombtipo")
    private String nombtipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "consecu")
    private Double consecu;
    @Column(name = "coditipo")
    private Short coditipo;

    public Tipdocum() {
    }

    public Tipdocum(Integer idTipdocum) {
        this.idTipdocum = idTipdocum;
    }

    public Integer getIdTipdocum() {
        return idTipdocum;
    }

    public void setIdTipdocum(Integer idTipdocum) {
        this.idTipdocum = idTipdocum;
    }

    public String getNombtipo() {
        return nombtipo;
    }

    public void setNombtipo(String nombtipo) {
        this.nombtipo = nombtipo;
    }

    public Double getConsecu() {
        return consecu;
    }

    public void setConsecu(Double consecu) {
        this.consecu = consecu;
    }

    public Short getCoditipo() {
        return coditipo;
    }

    public void setCoditipo(Short coditipo) {
        this.coditipo = coditipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipdocum != null ? idTipdocum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipdocum)) {
            return false;
        }
        Tipdocum other = (Tipdocum) object;
        if ((this.idTipdocum == null && other.idTipdocum != null) || (this.idTipdocum != null && !this.idTipdocum.equals(other.idTipdocum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.entities.Tipdocum[ idTipdocum=" + idTipdocum + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddie Master
 */
@Entity
@Table(name = "presupue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupue.findAll", query = "SELECT p FROM Presupue p"),
    @NamedQuery(name = "Presupue.findByPresup", query = "SELECT p FROM Presupue p WHERE p.presup = :presup"),
    @NamedQuery(name = "Presupue.findByDescri", query = "SELECT p FROM Presupue p WHERE p.descri = :descri"),
    @NamedQuery(name = "Presupue.findByCorrsoli", query = "SELECT p FROM Presupue p WHERE p.corrsoli = :corrsoli"),
    @NamedQuery(name = "Presupue.findByCorrpago", query = "SELECT p FROM Presupue p WHERE p.corrpago = :corrpago"),
    @NamedQuery(name = "Presupue.findByIdPresupue", query = "SELECT p FROM Presupue p WHERE p.idPresupue = :idPresupue")})
public class Presupue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "presup")
    private String presup;
    @Column(name = "descri")
    private String descri;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "corrsoli")
    private Double corrsoli;
    @Column(name = "corrpago")
    private Double corrpago;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presupue")
    private Integer idPresupue;

    public Presupue() {
    }

    public Presupue(Integer idPresupue) {
        this.idPresupue = idPresupue;
    }

    public String getPresup() {
        return presup;
    }

    public void setPresup(String presup) {
        this.presup = presup;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public Double getCorrsoli() {
        return corrsoli;
    }

    public void setCorrsoli(Double corrsoli) {
        this.corrsoli = corrsoli;
    }

    public Double getCorrpago() {
        return corrpago;
    }

    public void setCorrpago(Double corrpago) {
        this.corrpago = corrpago;
    }

    public Integer getIdPresupue() {
        return idPresupue;
    }

    public void setIdPresupue(Integer idPresupue) {
        this.idPresupue = idPresupue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupue != null ? idPresupue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupue)) {
            return false;
        }
        Presupue other = (Presupue) object;
        if ((this.idPresupue == null && other.idPresupue != null) || (this.idPresupue != null && !this.idPresupue.equals(other.idPresupue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.entities.Presupue[ idPresupue=" + idPresupue + " ]";
    }
    
}

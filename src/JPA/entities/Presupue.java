/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.entities;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
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
    @NamedQuery(name = Presupue.FIND_ALL, query = "SELECT p FROM Presupue p"),
    @NamedQuery(name = Presupue.CODE_EXISTS, query = "SELECT COUNT(p) FROM Presupue p WHERE p.codpresup = :codpresup"),
    @NamedQuery(name = "Presupue.findByPresup", query = "SELECT p FROM Presupue p WHERE p.codpresup = :presup"),
    @NamedQuery(name = "Presupue.findByDescri", query = "SELECT p FROM Presupue p WHERE p.descri = :descri"),
    @NamedQuery(name = "Presupue.findByCorrsoli", query = "SELECT p FROM Presupue p WHERE p.corrsoli = :corrsoli"),
    @NamedQuery(name = "Presupue.findByCorrpago", query = "SELECT p FROM Presupue p WHERE p.corrpago = :corrpago")})
@AttributeOverride(name = "id", column = @Column(name = "id_presupue"))
public class Presupue extends Entidad {

    // CONSTANTES
    public static final String FIND_ALL = "Presupue.findAll";
    public static final String CODE_EXISTS = "Presupue.codeExists";

    // VARIABLES
    @Column(name = "codpresup")
    private int codpresup;
    @Column(name = "descri")
    private String descri;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "corrsoli")
    private Double corrsoli;
    @Column(name = "corrpago")
    private Double corrpago;
    @Column(name = "emprcons")
    private String emprcons;

    public String getEmprcons() {
        return emprcons;
    }

    public void setEmprcons(String emprcons) {
        this.emprcons = emprcons;
    }

    public int getCodpresup() {
        return codpresup;
    }

    public void setCodpresup(int codpresup) {
        this.codpresup = codpresup;
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

    @Override
    public String toString() {
        return "JPA.entities.Presupue[ idPresupue=" + super.getId() + " ]";
    }

}

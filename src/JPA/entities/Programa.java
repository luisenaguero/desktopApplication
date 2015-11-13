/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.AttributeOverride;
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
 * @author luisenaguero
 */
@Entity
@Table(name = "programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Programa.FIND_ALL, query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByDetprogr", query = "SELECT p FROM Programa p WHERE p.detprogr = :detprogr"),
    @NamedQuery(name = "Programa.findByCodprogr", query = "SELECT p FROM Programa p WHERE p.codprogr = :codprogr")})
@AttributeOverride(name = "id", column = @Column(name = "id_programa"))
public class Programa extends Entidad {
   
    // CONSTANTES
    public static final String FIND_ALL = "Programa.findAll";

    // VARIABLES
    private static final long serialVersionUID = 1L;
    @Column(name = "detprogr")
    private String detprogr;
    @Column(name = "codprogr")
    private Short codprogr;

    // RELACIONES
    @JoinColumn(name = "codsector", referencedColumnName = "codsector")
    @ManyToOne
    private Sector codsector;

    // GETTERS Y SETTERS
    public Programa() {
    }

    public String getDetprogr() {
        return detprogr;
    }

    public void setDetprogr(String detprogr) {
        this.detprogr = detprogr;
    }

    public Short getCodprogr() {
        return codprogr;
    }

    public void setCodprogr(Short codprogr) {
        this.codprogr = codprogr;
    }

    public Sector getCodsector() {
        return codsector;
    }

    public void setCodsector(Sector codsector) {
        this.codsector = codsector;
    }

    @Override
    public String toString() {
        return "JPA.entities.Programa[ idPrograma=" + super.getId() + " ]";
    }
}

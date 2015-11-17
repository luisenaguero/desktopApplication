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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Sector.FIND_ALL, query = "SELECT s FROM Sector s"),
    @NamedQuery(name = Sector.DIF_CODE, query = "SELECT COUNT(s) FROM Sector s WHERE s.codsector = :codsector AND s.id != :idsector"),
    @NamedQuery(name = Sector.CODE_EXISTS, query = "SELECT COUNT(s) FROM Sector s WHERE s.codsector = :codsector"),
    @NamedQuery(name = "Sector.findByDetsector", query = "SELECT s FROM Sector s WHERE s.detsector = :detsector"),
    @NamedQuery(name = Sector.FIND_BY_CODE, query = "SELECT s FROM Sector s WHERE s.codsector = :codsector")})
@AttributeOverride(name = "id", column = @Column(name = "id_sector"))
public class Sector extends Entidad {

    //CONSTANTES
    public static final String FIND_ALL = "Sector.findAll";
    public static final String FIND_BY_CODE = "Sector.findByCode";
    public static final String CODE_EXISTS = "Sector.codeExits";
    public static final String DIF_CODE = "Sector.difCode";

    //VARIABLES
    @Column(name = "detsector")
    private String detsector;
    @Column(name = "codsector")
    private Short codsector;

    //RELACIONES
    @OneToMany(mappedBy = "codsector", fetch = FetchType.LAZY)
    private Collection<Programa> programaCollection;

    //GETTERS Y SETTERS
    public Sector() {
    }

    public String getDetsector() {
        return detsector;
    }

    public void setDetsector(String detsector) {
        this.detsector = detsector;
    }

    public Short getCodsector() {
        return codsector;
    }

    public void setCodsector(Short codsector) {
        this.codsector = codsector;
    }

    @XmlTransient
    public Collection<Programa> getProgramaCollection() {
        return programaCollection;
    }

    public void setProgramaCollection(Collection<Programa> programaCollection) {
        this.programaCollection = programaCollection;
    }

    @Override
    public String toString() {
        return "JPA.entities.Sector[ idSector=" + super.getId() + " ]";
    }
}

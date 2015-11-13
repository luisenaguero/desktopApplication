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
@Table(name = "departa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departa.findAll", query = "SELECT d FROM Departa d"),
    @NamedQuery(name = "Departa.findByCodigo", query = "SELECT d FROM Departa d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Departa.findByDescri", query = "SELECT d FROM Departa d WHERE d.descri = :descri"),
    @NamedQuery(name = "Departa.findByIdDeparta", query = "SELECT d FROM Departa d WHERE d.idDeparta = :idDeparta")})
public class Departa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descri")
    private String descri;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_departa")
    private Integer idDeparta;

    public Departa() {
    }

    public Departa(Integer idDeparta) {
        this.idDeparta = idDeparta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public Integer getIdDeparta() {
        return idDeparta;
    }

    public void setIdDeparta(Integer idDeparta) {
        this.idDeparta = idDeparta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeparta != null ? idDeparta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departa)) {
            return false;
        }
        Departa other = (Departa) object;
        if ((this.idDeparta == null && other.idDeparta != null) || (this.idDeparta != null && !this.idDeparta.equals(other.idDeparta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.entities.Departa[ idDeparta=" + idDeparta + " ]";
    }
    
}

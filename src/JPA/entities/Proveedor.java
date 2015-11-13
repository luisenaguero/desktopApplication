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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByCodiprov", query = "SELECT p FROM Proveedor p WHERE p.codiprov = :codiprov"),
    @NamedQuery(name = "Proveedor.findByNombprov", query = "SELECT p FROM Proveedor p WHERE p.nombprov = :nombprov"),
    @NamedQuery(name = "Proveedor.findByCodcont", query = "SELECT p FROM Proveedor p WHERE p.codcont = :codcont"),
    @NamedQuery(name = "Proveedor.findByCedula", query = "SELECT p FROM Proveedor p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Proveedor.findByBenefici", query = "SELECT p FROM Proveedor p WHERE p.benefici = :benefici"),
    @NamedQuery(name = "Proveedor.findByMontpres", query = "SELECT p FROM Proveedor p WHERE p.montpres = :montpres"),
    @NamedQuery(name = "Proveedor.findByRif", query = "SELECT p FROM Proveedor p WHERE p.rif = :rif"),
    @NamedQuery(name = "Proveedor.findByNit", query = "SELECT p FROM Proveedor p WHERE p.nit = :nit"),
    @NamedQuery(name = "Proveedor.findByTipo", query = "SELECT p FROM Proveedor p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "codiprov")
    private String codiprov;
    @Column(name = "nombprov")
    private String nombprov;
    @Column(name = "codcont")
    private String codcont;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "benefici")
    private String benefici;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montpres")
    private Double montpres;
    @Column(name = "rif")
    private String rif;
    @Column(name = "nit")
    private String nit;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCodiprov() {
        return codiprov;
    }

    public void setCodiprov(String codiprov) {
        this.codiprov = codiprov;
    }

    public String getNombprov() {
        return nombprov;
    }

    public void setNombprov(String nombprov) {
        this.nombprov = nombprov;
    }

    public String getCodcont() {
        return codcont;
    }

    public void setCodcont(String codcont) {
        this.codcont = codcont;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getBenefici() {
        return benefici;
    }

    public void setBenefici(String benefici) {
        this.benefici = benefici;
    }

    public Double getMontpres() {
        return montpres;
    }

    public void setMontpres(Double montpres) {
        this.montpres = montpres;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.entities.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}

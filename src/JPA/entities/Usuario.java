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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisenaguero
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Usuario.FIND_ALL, query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = Usuario.LOG, query = "SELECT u FROM Usuario u WHERE u.nomusub = :nomusub AND u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByNomusub", query = "SELECT u FROM Usuario u WHERE u.nomusub = :nomusub"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")})
@AttributeOverride(name = "id", column = @Column(name = "id_usuario"))

public class Usuario extends Entidad {
 
    // CONSTANTES
    public static final String FIND_ALL = "Usuario.findAll";
    public static final String LOG = "Usuario.log";

    // VARIABLES
    @Column(name = "nomusub")
    private String nomusub;
    @Lob
    @Column(name = "clave")
    private String clave;

    // GETTERS Y SETTERS
    public String getNomusub() {
        return nomusub;
    }

    public void setNomusub(String nomusub) {
        this.nomusub = nomusub;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}

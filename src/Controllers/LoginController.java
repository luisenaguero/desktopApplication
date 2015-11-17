/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import JPA.entities.Usuario;
import JPA.utilities.JPAManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import views.Login;

/**
 *
 * @author Eddie Master
 */
public class LoginController {

    JPAManager jpam = new JPAManager(Usuario.class);
    Usuario usuario = new Usuario();

    public boolean Login(String user, String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.reset();
        String sha = new String(md.digest(pass.getBytes("UTF-8")));
        if (user != null && pass != null) {
            usuario = (Usuario) jpam.singleResultNQ(Usuario.LOG, new HashMap<String, Object>() {
                {
                    put("nomusub", user);
                    put("clave", sha);
                }
            });
            try {

                if (usuario.getId() != null) {
                    return true;
                }

            } catch (Exception e) {
                return false;
            }

        } else {
            Login.LoginError.setText("Error En algun Campo");
        }
        return false;
    }

}

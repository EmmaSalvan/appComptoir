/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

/**
 *
 * @author marisolcanavy
 */
import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;

@SessionScoped
@Named("client")
public class ClientConnecte implements Serializable {

    private String Code = null;
    private String Nom;
    
    public ClientConnecte() {
    }

    public void login(String Code, String Nom) {
        this.Code = Code;
        this.Nom = Nom;
    }

    public String getNom() {
        return Nom;
    }

    public void logout() {
        this.Code = null;
        this.Nom = null;
    }

    public String getCode() {
        return Code;
    }
}

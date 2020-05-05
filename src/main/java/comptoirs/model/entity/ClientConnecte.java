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



@SessionScoped
@Named("client")
public class ClientConnecte extends Client implements Serializable {

    private Client c;
    
    public void login(Client c) {
        this.c = c;
    }
    
    public void logout() {
         this.c = null;
    }

    public String getNom() {
        return c.getContact();
    }

    public Client getC() {
        return c;
    }
    
}

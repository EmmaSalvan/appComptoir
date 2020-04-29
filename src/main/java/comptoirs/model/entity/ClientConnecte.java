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

    private String Code;

    public void login(String Code) {
        this.Code = Code;
    }

    public void logout() {
        this.Code = null;
    }

    public String getCode() {
        return Code;
    }
}

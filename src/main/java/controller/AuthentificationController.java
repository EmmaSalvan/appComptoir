/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Client;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.servlet.http.HttpServlet;
import javax.validation.executable.ExecutableType;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author marisolcanavy
 */

@Controller
@Path("authentification")
@View("authentification.jsp")

public class AuthentificationController{
    
    @Inject // Le DAO généré par netBeans
	ClientFacade dao;

	@Inject
	Models models;

        @Inject
        SessionClientController client;
        
	@GET
	public void show() {
		models.put("client", dao.findAll());
	}
        
        @POST
        @ValidationOnExecution(type = ExecutableType.ALL)
        public String login(@FormParam("nom") String nom, @FormParam("email") String email){
            if (nom.equals("admin") && email.equals("mdp")){
                return "Coucou je suis un admin";
            } else {
                try {
                    Client p = dao.find(nom);
                    if (p.getContact().equals(nom)) {
                        client.setCode(email);
                    } else {
                        models.put("databaseErrorMessage", "Ce conctat ne correspond pas au client");
                    }
                } catch (Exception e){
                    models.put("databaseErrorMessage","Ce code n'existe pas.");
                }
            }
            return null;
        }
}

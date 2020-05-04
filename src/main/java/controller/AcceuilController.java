
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.ClientConnecte;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author marisolcanavy
 */

@Controller
@Path("acceuil")
@View("acceuil.jsp")

public class AcceuilController {
    
    @Inject //recupère les infos de la db
    ClientFacade dao;
        
    @Inject
    Models models;
    
    @Inject // Les infos du joueur, Session scoped
    private ClientConnecte client;
    
    @GET
    public void show() {
        //String p = dao.find(client.getCode()).getContact();
	models.put("client", "Coucou");
    }
}
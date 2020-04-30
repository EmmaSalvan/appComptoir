/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.ClientConnecte;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author marisolcanavy
 */

@Controller
@Path("admin")
@View("admin.jsp")

public class AdminController {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.AbstractFacade;
import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Client;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author marisolcanavy
 */

@Controller
@Path("sessionClientController")
@View("sessionClientController.jsp")
public class SessionClientController extends AbstractFacade<Client> {
    
    @Inject // Le DAO généré par netBeans
	ClientFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		List<Client> tousLesClients = dao.findAll();
		models.put("Clients", tousLesClients);
	}
        
}

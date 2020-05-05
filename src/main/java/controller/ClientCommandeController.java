/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.ClientConnecte;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Collection;
/**
 *
 * @author M_Can
 */

@Controller
@Path("commandes")
@View("commandes.jsp")
public class ClientCommandeController {
    
    @Inject
    ClientFacade dao;

    @Inject
    Models models;

    @Inject // Les infos du joueur, Session scoped
    ClientConnecte client;

    
    @GET
    public void afficheCommandesPourLeClient() {
    Client c = dao.find(client.getCode()); 
    models.put("clientCo", c);
    Collection<Commande> mesCommandes = c.getCommandeCollection();
    models.put("mesCommandes", mesCommandes);
 }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.ClientConnecte;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
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

public class AuthentificationController {

    @Inject //recupère les infos de la db
    ClientFacade dao;

    @Inject
    Models models;

    @Inject // Les infos du joueur, Session scoped
    ClientConnecte client;
    
    @GET
     public void show() {
         models.put("client", dao.findAll());
    }


    @POST
    public String login(@FormParam("contact") String contact, @FormParam("motDePasse") String code) {
        if (contact.equals("admin") && code.equals("mdp")) {
            models.put("errorMessage", "Tout est bon pour l'admin");
        } else {
            try {
                Client p = dao.find(code);
                if (p.getCode().equals(code)) {
                    if (p.getContact().equals(contact)) {
                        client.setCode(code);
                        client.login(p);
                        return "redirect:acceuil";
                    } else {
                        models.put("errorMessage", "Les informations de connexion sont érronnées.");
                    }
                } else {
                    models.put("errorMessage", "Ce contact n'existe pas.");
                }
            } catch (Exception e) {
                models.put("errorMessage", "Le mot de passe est incorrect.");
            }
        }
        return null;
    }
    
}

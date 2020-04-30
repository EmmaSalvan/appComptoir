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
import comptoirs.model.entity.ClientConnecte;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

public class AuthentificationController {

    @Inject //recupère les infos de la db
    ClientFacade dao;

    @Inject
    Models models;

    @Inject // Les infos du joueur, Session scoped
    ClientConnecte client;

//    @GET
//    public String show() {
//        models.put("client", dao.findAll());
//        if (client.getCode() == null) { // Pas de code donc pas authentifier Partie client
//            return "authentification.jsp";
//        } //else { // Code donc authentifier Partie client
//            //return "acceuil.jsp";
//        //}
//        return "acceuil.jsp";
//    }
    
    @GET
     public void show() {
         models.put("client", dao.findAll());
    }
//    @GET
//    @Path("deconnecter")
//    public String logout() {
//        client.logout();
//        return "redirect:/";
//    }

    @POST
    public String login(@FormParam("contact") String nom, @FormParam("motDePasse") String code) {
        if (nom.equals("admin") && code.equals("mdp")) {
            models.put("errorMessage", "Tout est bon pour l'admin");
        } else {
            try {
                Client p = dao.find(code);
                if (p.getCode().equals(code)) {
                    if (p.getContact().equals(nom)) {
                        client.login(code,nom);
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
//    
//    @GET @Path("acceuil")
//    public String getNom() {
//        models.put("client", client.getCode());
//        return null;
//    }
}

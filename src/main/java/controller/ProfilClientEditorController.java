/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.ClientConnecte;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.BeanParam;

/**
 *
 * @author emmasalvan
 */
@Controller
@Path("editProfilClient")
@View("editProfilClient.jsp")

public class ProfilClientEditorController {

    @Inject //recupère les infos de la db
    ClientFacade dao;

    @Inject
    Models models;

    @Inject // Les infos du joueur, Session scoped
    ClientConnecte client;

    @GET
    public void show() {
        models.put("client", dao.find(client.getCode()));
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)	
    public void editProfil(@FormParam("societe") String societe, @FormParam("fonction") String fonction, @FormParam("adresse") String adresse, @FormParam("ville") String ville, @FormParam("region") String region, @FormParam("codepostal") String codePostal, @FormParam("pays") String pays, @FormParam("telephone") String telephone, @FormParam("fax") String fax) {
        models.put("changement", "Voici le changement de societe souhaité :" + societe + "et" + fonction+ "et" + adresse+ "et" + ville+ "et" + codePostal+ "et" + region+ "et" + pays+ "et" + telephone+ "et" + fax);
       
        Client profilConnecte = dao.find(client.getCode());
        
        profilConnecte.setSociete(societe);
        profilConnecte.setFonction(fonction);
        profilConnecte.setAdresse(adresse);
        profilConnecte.setVille(ville);
        profilConnecte.setCodePostal(codePostal);
        profilConnecte.setRegion(region);
        profilConnecte.setPays(pays);
        profilConnecte.setTelephone(telephone);
        profilConnecte.setFax(fax);
        
        
        dao.edit(profilConnecte);
        profilConnecte = dao.find(client.getCode());
        models.put("client.c", profilConnecte);
    }

}

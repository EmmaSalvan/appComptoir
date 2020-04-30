/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
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

    @Inject
    ClientFacade dao;
    
    @Inject
    Models models;

    @GET
    public void show() { 
            models.put("clients", dao.find("BOTTM"));
           }
    

    @POST

    public void edit( 
                @FormParam("societe") String societe,  
		@FormParam("contact") String contact,
		@FormParam("fonction") String fonction, 
                @FormParam("adresse") String adresse,
                @FormParam("ville") String ville,
                @FormParam("region") String region,
                @FormParam("codepostal") String codepostal,
                @FormParam("pays") String pays,
                @FormParam("telephone") String telephone,
                @FormParam("fax") String fax) {

    
            Client nouvelle = dao.find("BOTTM");
            nouvelle.setSociete(societe);
            nouvelle.setContact(contact);
            nouvelle.setFonction(fonction);
            nouvelle.setAdresse(adresse);
            nouvelle.setVille(ville);
            nouvelle.setRegion(region);
            nouvelle.setCodePostal(codepostal);
            nouvelle.setPays(pays);
            nouvelle.setTelephone(telephone);
            nouvelle.setFax(fax);

            dao.edit(nouvelle);
            models.put("clients", dao.find("BOTTM"));
    }
}
 
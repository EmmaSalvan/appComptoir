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
import javax.ejb.EJBException;
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
import form.ClientForm;

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
    BindingResult formValidationErrors;

    @Inject
    Models models;


    @GET
    public void show() {
            models.put("clients", dao.find("ALFKI"));
    }
    

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)

    public void modifyClient( 
                @Valid @BeanParam ClientForm formData,
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
        if (!formValidationErrors.isFailed()) { // Pas d'erreurs de saisie dans le formulaire
            // On modifie le profil client
            Client nouvelle = dao.find("ALFKI");
            nouvelle.setSociete(formData.getSociete());
            nouvelle.setContact(formData.getContact());
            nouvelle.setFonction(formData.getFonction());
            nouvelle.setAdresse(formData.getAdresse());
            nouvelle.setVille(formData.getVille());
            nouvelle.setRegion(formData.getRegion());
            nouvelle.setCodePostal(formData.getCodePostal());
            nouvelle.setPays(formData.getPays());
            nouvelle.setTelephone(formData.getTelephone());
            nouvelle.setFax(formData.getFax());

            dao.edit(nouvelle);
}
}
}
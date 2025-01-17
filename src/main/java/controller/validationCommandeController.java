/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LigneCommande;
import comptoirs.model.entity.BonCommande;

import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import javax.mvc.Models;
import javax.ws.rs.FormParam;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.core.Response;

import comptoirs.model.entity.ClientConnecte;


@Controller
@Path("validationCommande")
@View("validationCommande.jsp")

/**
 *
 * @author Marie
 */
public class validationCommandeController {

	@Inject
	Models model;
	
	@Inject
	ClientFacade dao;	
	
	@Inject
	CommandeFacade facadeC;
		
	@Inject
	
	LigneFacade facadeL;
	
	@Inject // Le panier, Session scoped
	BonCommande boncommande;

        @Inject // Les infos du joueur, Session scoped
        ClientConnecte client;
 
        @GET
        public void show() {
        model.put("boncommande", boncommande);
        }


        @POST
        public void validationCommande(
                @FormParam("destinataire") String destinataire,
                @FormParam("adresse") String adresse,
                @FormParam("codePostal") String codePostal,
                @FormParam("ville") String ville,
                @FormParam("region") String region,
                @FormParam("pays") String pays){

                Commande commande = new Commande();
                for (LigneCommande ligne : boncommande.getLignesCommandes()) {
                Ligne newLigne = new Ligne(commande.getNumero(), ligne.getProduit().getReference());
                newLigne.setQuantite(ligne.getQuantite());
            }

                commande.setClient(client);
                commande.setDestinataire(destinataire);
                commande.setAdresseLivraison(adresse);
                commande.setCodePostalLivrais(codePostal);
                commande.setVilleLivraison(ville);
                commande.setRegionLivraison(region);
                commande.setPaysLivraison(pays);
                commande.setSaisieLe(new Date());

                model.put("commande", commande);
      
            }
        }
  

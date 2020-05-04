/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package controller;

import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.BonCommande;
import comptoirs.model.entity.Produit;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.LigneCommande;

import java.net.URI;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;
import javax.mvc.Models;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.Response;

import comptoirs.model.entity.ClientConnecte;

/**
*
* @author Marie
*/

@Controller
@Path("commandeEditor")
@View("commandeEditor.jsp")

public class commandeEditorController {

        @Inject
	Models model;
	
	@Inject
	BonCommande boncommande;
        
        @Inject
        ProduitFacade facadeP;
        
        @Inject // Les infos du joueur, Session scoped
        private ClientConnecte client;

        @GET
            public void show(){
                model.put("boncommande", boncommande);
        }

        @POST
        public Response choix( @FormParam("action") String action,
                               @FormParam("produit") Integer numeroProduit,
                               @FormParam("quantite") short quantite,
                               @FormParam("produitsupp") Integer numeroProduitSupp){

                switch(action){
                    case "Valider le panier":
                        return validerLePanier();
                    case "Supprimer le produit du panier":
                        return supprimerProduit(numeroProduitSupp);
                    case "Modifier la quantite du produit":
                        return modifierQuantite(numeroProduit, quantite);
                }
            return Response.ok().build();
        }

        //Dans le cas où l'utilisateur valide le panier
        private Response validerLePanier(){
           return Response.seeOther(URI.create("/Comptoirs_MVC/app/ValidationCommande")).build();
        }

        // Dans le cas où l'utilisateur veut supprimer un produit du panier
        private Response supprimerProduit(Integer numeroProduitSupp){
            Produit p = facadeP.findByReference(numeroProduitSupp);
                for(LigneCommande ligne : boncommande.getLignesCommandes()){
                    if(ligne.getProduit().getReference().equals(p.getReference())){
                        boncommande.getLignesCommandes().remove(ligne);
                    }       
                }
            model.put("boncommande", boncommande);
                return Response.ok().build();
        }

        //Dans le cas où l'utilisateur veut modifier la quantite du produit
        private Response modifierQuantite(Integer numeroProduit, short quantite){
            Produit p = facadeP.findByReference(numeroProduit);
                if (p.getUnitesEnStock() >= quantite){
                    for (LigneCommande ligne : boncommande.getLignesCommandes()){
                        if(ligne.getProduit().getReference().equals(p.getReference())){
                                ligne.setQuantite(quantite);
                        }                           
                    }
                }
            model.put("boncommande", boncommande);
            return Response.ok().build();
        }
}
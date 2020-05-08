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
import javax.ws.rs.core.Response;

import comptoirs.model.entity.ClientConnecte;
import javax.enterprise.context.SessionScoped;


/**
*
* @author Marie
*/

@Controller
@Path("commandeEditor")
@View("commandeEditor.jsp")

public class commandeEditorController {

        @Inject // Les infos du joueur, Session scoped
        ClientConnecte client;
	
	@Inject // Le Panier, Session scoped
	BonCommande boncommande;
        
        @Inject
        ProduitFacade facadeP;
        
        @Inject
        Models model;

        // Affichage des produits placés dans le panier
        @GET
        public void show(){
                model.put("boncommande", boncommande);
        }

        // Post pour réaliser différentes actions dans le panier
        @POST
        private void choix(@FormParam("action") String action,
                     @FormParam("produit") Integer numeroProduit,
                     @FormParam("quantite") short newquantite,
                     @FormParam("produitsupp") Integer numeroProduitSupp){

                switch(action){

                    case "Valider le panier": 
                        validerLePanier();
                        break;


                    case "Supprimer le produit du panier": 
                        supprimerProduit(numeroProduitSupp);
                        break;

                    case "Modifier la quantite du produit": 
                        modifierQuantite(numeroProduit, newquantite);
                        break;
                          
           }     
}
       @POST
        //Dans le cas où l'utilisateur valide le panier
        public String validerLePanier(){
        // On envoie sur la page de validation de la commande
           return("redirect:validationCommande");
        }

        @POST
        // Dans le cas où l'utilisateur veut supprimer un produit du panier
        private String supprimerProduit(Integer numeroProduitSupp){
            Produit p = facadeP.findByReference(numeroProduitSupp);
                for(LigneCommande ligne : boncommande.getLignesCommandes()){
                    if(ligne.getProduit().getReference().equals(p.getReference())){
                        boncommande.getLignesCommandes().remove(ligne);
                    }       
                }
            model.put("boncommande", boncommande);
            // On met à jour le panier
            return("redirect:commandeEditor");
        }
        
        @POST
        //Dans le cas où l'utilisateur veut modifier la quantite du produit
        private String modifierQuantite(Integer numeroProduit, short newquantite){
            Produit p = facadeP.findByReference(numeroProduit);
                if (p.getUnitesEnStock() >= newquantite){
                    for (LigneCommande ligne : boncommande.getLignesCommandes()){
                        if(ligne.getProduit().getReference().equals(p.getReference())){
                                ligne.setQuantite((short)(newquantite));
                        }                           
                    }
                }
            model.put("boncommande", boncommande);
            // On met à jour le panier
            return("redirect:commandeEditor");
        }
}

package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ProduitFacade;
import java.util.List;


import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import comptoirs.model.entity.LigneCommande;
import comptoirs.model.entity.BonCommande;
import comptoirs.model.entity.Produit;
import comptoirs.model.entity.ClientConnecte;



@Controller
@Path("categorieProduits")
@View("categorieProduits.jsp")
public class CategorieProduitController {
	@Inject
	CategorieFacade facade;

        @Inject
        ProduitFacade facadeP;

	@Inject
	Models models;

        @Inject
	BonCommande boncommande;
        
        @Inject // Les infos du joueur, Session scoped
        private ClientConnecte client;

	@GET
	public void produitsParCategorie( @QueryParam("code") Integer codeCategorie ) {
		// On cherche la liste des catégories pour l'afficher dans la liste de choix
		final List<Categorie> touteslesCategories = facade.findAll();

		// On cherche la catégorie à partir de son code passé en paramètre
		Categorie categorieChoisie;
		if (codeCategorie != null) // Est-ce qu'on a un paramètre ?
			// On va chercher la catégorie 
			categorieChoisie = facade.find(codeCategorie); // Et si on ne trouve pas ?
		else
			// On prend la première de la liste (encore faut-il qu'il y en ait une !)
			categorieChoisie = touteslesCategories.get(0);

		// On transmet les informations à la vue
		models.put("categories", touteslesCategories);
		models.put("selected", categorieChoisie);
	}

    @POST
        public void ajouter(
                @QueryParam("code") Integer codeCategorie, 
                @FormParam("produit") Integer numeroProduit, 
                @FormParam("quantite") short quantite){
            if(boncommande==null) boncommande=new BonCommande();
            Produit p = facadeP.findByReference(numeroProduit);
            if(p!=null){
                if(p.getUnitesEnStock() >= quantite){
                    if (!boncommande.getLignesCommandes().isEmpty() ){
                        int compteur = 0;
                        for (LigneCommande ligne : boncommande.getLignesCommandes()) {
                            if (ligne.getProduit().getReference().equals(p.getReference())) {
                                ligne.setQuantite((short)(ligne.getQuantite() + Math.abs(quantite)));
                                compteur++;
                            }
                        }
                        if (compteur == 0) {
                            boncommande.addLigne(new LigneCommande(p,quantite));
                        }
                    }else{ 
                        boncommande.addLigne(new LigneCommande(p,quantite));
                    }
                }
            }  
			final List<Categorie> touteslesCategories = facade.findAll();

			Categorie categorieChoisie;
			if (codeCategorie != null)
				categorieChoisie = facade.find(codeCategorie);
			else
				categorieChoisie = touteslesCategories.get(0);
			models.put("selected", categorieChoisie);
			models.put("Client", client);
                        models.put("boncommande", boncommande);
        }
        
}

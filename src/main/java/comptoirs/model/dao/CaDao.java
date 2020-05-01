/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marisolcanavy
 */


@Stateless
public class CaDao {
    
    @PersistenceContext(unitName = "comptoirs")
	private EntityManager em;
    
    public List getFirstAndLastOrderDate() {
		LinkedList<Long> timeResult = new LinkedList<>();
		Query query = em.createNamedQuery("Commande.findFirstDate");
		timeResult.add(((Date) (query.getResultList().get(0))).getTime());
		query = em.createNamedQuery("Commande.findLastDate");
		timeResult.add(((Date) (query.getResultList().get(0))).getTime());
		return timeResult;
	}
	
	public List caParCategorie() {
		Query query = em.createNamedQuery("Categorie.CAParCategorie");
		List results = query.getResultList();
		return results;
	}

	public List caParCategorie(Date from,Date to) {
		Query query = em.createNamedQuery("Categorie.CAParCategorieParTemps");
		query = query.setParameter("from", from);
		query = query.setParameter("to", to);
		List results = query.getResultList();
		return results;
	}	
	public List caParPays() {
		Query query = em.createNamedQuery("Commande.CAParPays");
		List results = query.getResultList();
		return results;
	}

	public List caParPays(Date from,Date to) {
		Query query = em.createNamedQuery("Commande.CAParPaysParTemps");
		query = query.setParameter("from", from);
		query = query.setParameter("to", to);
		List results = query.getResultList();
		return results;
	}	
	public List caParClient() {
		Query query = em.createNamedQuery("Commande.CAParClient");
		List results = query.getResultList();
		return results;
	}

	public List caParClient(Date from,Date to) {
		Query query = em.createNamedQuery("Commande.CAParClientParTemps");
		query = query.setParameter("from", from);
		query = query.setParameter("to", to);
		List results = query.getResultList();
		return results;
	}	
        
//     //CA par catégorie
//	private static final String CA_UNITS_SOLD = 
//                "SELECT cat.libelle, SUM(p.prixUnitaire) " +
//		"FROM Categorie cat " + 
//		"JOIN cat.produitCollection p " + //Lien de catégorie à produit
//		"JOIN p.ligneCollection li " + //Lien de produit à quantité
//		"GROUP BY cat.libelle";
////                "SELECT Categorie.libelle, SUM(Produit.Quantite_par_unite)*Produit.Prix_unitaire " +
////		"FROM Categorie " + 
////		"JOIN Produit " + 
////		"WHERE Categorie.code = Produit.categorie" + 
////		"GROUP BY Categorie.libelle";
////    
//        //DTO CA  par catégorie
//	private static final String CA_UNITS_SOLD_DTO =
//                "SELECT new comptoirs.model.dto.StatsResult" +
//				        "(cat.libelle, SUM(p.prixUnitaire)) " + 
//		"FROM Categorie cat " + 
//		"JOIN cat.produitCollection p " + 
//		"JOIN p.ligneCollection li " + 
//		"GROUP BY cat.libelle";
////		"SELECT new comptoirs.model.dto.StatsResult" +
////				        "(Categorie.libelle, SUM(Produit.Quantite_par_unite)*Produit.Prix_unitaire) " + 
////		"FROM Categorie " + 
////		"JOIN Produit " + 
////		"WHERE Categorie.code = Produit.categorie" + 
////		"GROUP BY Categorie.libelle";
//        
//        @PersistenceContext(unitName = "comptoirs")
//	private EntityManager em;
//        
//        //CA par catégorie
//        public List CAParCategorie() {
//		Query query = em.createQuery(CA_UNITS_SOLD);
//		List results = query.getResultList();
//		return results;
//	}
//        //CA  par catégorie DTO : résultats de la requette
//	public List<StatsResult> CaParCategorieDTO() {
//		Query query = em.createQuery(CA_UNITS_SOLD_DTO, CaResult.class);
//		List<StatsResult> results = query.getResultList();
//		return results;
//	}
        
}

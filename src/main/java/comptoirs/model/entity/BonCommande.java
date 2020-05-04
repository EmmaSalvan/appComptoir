/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comptoirs.model.entity;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Marie
 */

@SessionScoped
@Named("BonCommande")

    public class BonCommande implements Serializable{
        private List<LigneCommande> lignesCommande;

    public BonCommande(){
        super();
        this.lignesCommande = new LinkedList<LigneCommande>();
    }
    public void addLigne(LigneCommande ligne){
        lignesCommande.add(ligne);
    }

    public String tostring(){
        String res="";
    for(LigneCommande lc : lignesCommande){
        res += "Produit : " + lc.getProduit().getNom();
    }
        return res;
    }

    public List<LigneCommande> getLignesCommandes(){
        return lignesCommande;
    }

    public void setLignesCommandes(List<LigneCommande> lignesCommande){
        this.lignesCommande = lignesCommande;
    }
}

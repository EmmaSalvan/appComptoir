/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;
import javax.mvc.binding.MvcBinding;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 *
 * @author emmasalvan
 */
public class ClientForm implements Serializable {

	private static final long serialVersionUID = -3523783484400524581L;

	@MvcBinding @FormParam("societe")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String societe;

	@MvcBinding @FormParam("contact")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String contact;

	@MvcBinding @FormParam("fonction")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String fonction;

	@MvcBinding @FormParam("adresse")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String adresse;

	@MvcBinding @FormParam("ville")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String ville;

	@MvcBinding @FormParam("region")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String region;

	@MvcBinding @FormParam("codepostal")
	//@NotEmpty
	@Size(min = 1, max = 5)
	private int codepostal;

	@MvcBinding @FormParam("pays")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private String pays;

	@MvcBinding @FormParam("telephone")
	//@NotEmpty
	@Size(min = 1, max = 10)
	private int telephone;

	@MvcBinding @FormParam("fax")
	//@NotEmpty
	@Size(min = 1, max = 255)
	private int fax;


	// Getters, setters
	
	public String getSociete() {
		return societe;
	}

	public void setSociete(final String societe) {
		this.societe = societe;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(final String contact) {
		this.contact = contact;
	}

        public String getFonction() {
		return fonction;
	}

	public void setFonction(final String fonction) {
		this.fonction = fonction;
	}

        public String getAdresse() {
		return adresse;
	}

	public void setAdresse(final String adresse) {
		this.adresse = adresse;
	}

        public String getVille() {
		return ville;
	}

	public void setVille(final String ville) {
		this.ville = ville;
	}

        public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}

        public int getCodePostal() {
		return codepostal;
	}

	public void setCodePostal(final int codepostal) {
		this.codepostal = codepostal;
	}

        public String getPays() {
		return pays;
	}

	public void setPays(final String pays) {
		this.pays = pays;
	}

        public int getTelephone() {
		return telephone;
	}

	public void setTelephone(final int telephone) {
		this.telephone = telephone;
	}

        public int getFax() {
		return fax;
	}

	public void setFax(final int fax) {
		this.fax = fax;
	}
}

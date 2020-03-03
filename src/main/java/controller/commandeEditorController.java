/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Marie
 */
@Controller
@Path("commandeEditor")
@View("commandeEditor.jsp")

public class commandeEditorController {
        @Inject
	CategorieFacade dao;

	@Inject
	BindingResult formValidationErrors;
	
	@Inject
	Models models;

        @GET
	public void show() {
		models.put("commande", dao.findAll());
	}

        @POST
        @ValidateOnExecution(type = ExecutableType.ALL)	
	public void create(@Valid @BeanParam CategorieForm formData) {
		if ( ! formValidationErrors.isFailed()) { // Pas d'erreurs de saisie dans le formulaire
			// On crée la nouvelle catégorie
			Commande nouvelle = new Commande();
			nouvelle.setLibelle(formData.getLibelle());
			nouvelle.setDescription(formData.getDescription());
			// On l'enregistre dans la base
			try {
				dao.create(nouvelle);
			} catch (EJBException e) {
				// Erreur possible : il existe déjà une catégorie avec ce libellé
				Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
				// On pourrait examiner l'exception pour vérifier sa cause exacte
				models.put("databaseErrorMessage", "La commande '" + formData.getLibelle() + "' existe déjà");
			}
		}
		models.put("validationErrors", formValidationErrors);
		models.put("commande", dao.findAll());
}

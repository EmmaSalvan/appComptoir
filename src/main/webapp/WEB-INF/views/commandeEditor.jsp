 <%-- 
    Document   : commandeEditor
    Created on : 14 févr. 2020, 17:02:51
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

 <body>
   	<h1>Votre panier</h1>

		<c:forEach var="ligne" items="${panier.lignesCommande}">
			<div class="productLine">
				<div>${ligne.produit.reference}</div>
				<div>${ligne.produit.nom}</div>
				<div><form method="POST" action=""><input type="hidden" name="action" value="${ligne.produit.reference}"><input type="hidden" name="produit" value="${ligne.produit.reference}"><input type="hidden" name="produit" value="${ligne.produit.reference}"><label>Quantité </label><input type="number" class="number-input" value="${ligne.quantite}" name="quantite"><input type="submit" class="primary-button" name="choix" value="Modifier la quantite du produit"></form></div>
				<div><form method="POST" action=""><input type="hidden" name="produitsupp" value="${ligne.produit.reference}"><input type="submit" class="cancel-button" name="choix" value="Supprimer le produit du panier"></form></div>
			</div>
		</c:forEach>
		<form method="POST" action=""><input type="hidden" name="valider" value="1"><input type="submit" class="primary-button" name="choix" value="Valider le panier"></form>
		<span class="error">${erreur}</span>
	</div>
    </body>
</html>

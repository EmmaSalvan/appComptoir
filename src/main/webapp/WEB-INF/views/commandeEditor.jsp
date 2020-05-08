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
		<c:forEach var="ligne" items="${boncommande.lignesCommandes}">
                    <table border='1'> <tr><th>Référence</th><th>Nom</th><th>Quantité</th><th></th></tr>
                        <tr>
                                <td>${ligne.produit.reference}</td>
				<td>${ligne.produit.nom}</td>
				<td><form><input name="produit" type="hidden" value="${ligne.produit.reference}"><input name="produit" type="hidden" value="${ligne.produit.reference}"><input type="number" min='1' value="${ligne.quantite}" name="quantite"><input type="submit" name="action" value="Modifier la quantite"></form></td>
				<td><form><input name="produitsupp" type="hidden" value="${ligne.produit.reference}"><input type="submit" name="action" value="Supprimer"></form></td>
                        </tr>
                    </table>
                </c:forEach>
		<form method="POST" action=""><input type="hidden" name="valider" value="1"><input type="submit" name="action" value="Valider le panier"></form><br/>
                <a href="acceuil">Retour au menu</a>
	</div>
    </body>
</html>

<%-- 
    Document   : validationPanier
    Created on : 1 mai 2020, 11:08:59
    Author     : Marie
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Validation de la commande </title>
    </head>
    <body class="ValidationCommande">
        <h1> Information sur la livraison </h1>
        <div class="content">
            <h2> Récapitulatif de la commande: </h2>
            <c:forEach var="ligne" items="${boncommande.lignesCommandes}">
                <table border='1'> <tr><th>Référence</th><th>Nom</th><th>Quantité</th></tr>
                    <tr>
                                <td>${ligne.produit.reference}</td>
				<td>${ligne.produit.nom}</td>
                                <td><form><input name="produit" type="hidden" value="${ligne.produit.reference}"><input name="produit" type="hidden" value="${ligne.produit.reference}">
                                        <div>${ligne.quantite}</div></td>
                    </tr>
                </table>
            </c:forEach>
            
        <h3>Livraison:</h3>                       
        <form method="POST">
            <label> Nom du destinataire: </label><input type="input" id='destinataire' name="destinataire" value = "${client.c.contact}" required><br/>
            <label> Adresse: </label><input type="input" name="adresse" id='adresse' value = "${client.c.adresse}" required><br/>
            <label> Code Postal: </label><input type="input" name="codepostal" id='codepostal' value = "${client.c.codePostal}" required><br/>
            <label> Ville: </label><input type="input" name="ville" id='ville' value = "${client.c.ville}" required><br/>
            <label> Région: </label><input type="input" name="region" id='region' value = "${client.c.region}" required><br/>
            <label> Pays: </label><input type="input" name="pays" id ='pays' value = "${client.c.pays}" required=""><br/>
            <input type="submit" name="valider" value = "Valider la commande"><br/>
        </form>
        </div>
    </body>
</html>

<%-- 
    Document   : validationPanier
    Created on : 1 mai 2020, 11:08:59
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Validation de la commande </title>
    </head>
    <body>
        <h1>Information sur la livraison</h1>
        <form method='POST' action="" class="simple-form">
            <label> Nom du destinataire: </label><input type="text" name="destinataire" value = "${client.contact}">
            <label> Adresse: </label><input type="text" name="adresse" value = "${client.adresse}">
            <label> Code Postal: </label><input type="text" name="codepostal" value = "${client.codePostal}">
            <label> Ville: </label><input type="text" name="ville" value = "${client.ville}">
            <label> Région: </label><input type="text" name="region" value = "${client.region}">
            <label> Pays: </label><input type="text" name="pays" value = "${client.pays}">
         
            <input type="submit" name="valider" value = "Valider la commande">
        </form>
    </body>
</html>

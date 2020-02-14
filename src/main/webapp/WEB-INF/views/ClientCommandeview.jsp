<%-- 
    Document   : ClientCommandeview
    Created on : 14 févr. 2020, 14:51:56
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Commande pour le Client ${client.societe}</h1>
        <table border = '1'>
            <tr><th>Numéro</th><th> Saisie le </th><th>nb. lignes</th></tr>
            <c:forEach var='commande' items =' ${client.commandeCollection}'>
                <tr>
                    <td>${commande.numero}</td>
                    <td>${commande.saisieLe}</td>
                    <td>${commandeligneCollection.size()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

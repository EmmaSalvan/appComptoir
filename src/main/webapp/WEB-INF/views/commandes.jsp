<%-- 
    Document   : ClientCommandeview
    Created on : 14 févr. 2020, 14:51:56
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mes commandes</title>
    </head>
    <body>
       <h1>Commandes pour le client ${clientCo.societe}</h1>
<table border='1'>
  <tr><th>Numéro</th><th>Saisie le</th><th>Nombre d'articles</th></tr>
  <%-- Pour chaque commande, une ligne dans la table HTML --%>
  <c:forEach var="commande" items="${mesCommandes}">
      <tr>
          <td>${commande.numero}</td>
          <td> <fmt:formatDate value="${commande.saisieLe}" pattern="dd/MM/yyyy à HH:mm:ss" /></td>
          <td>${commande.ligneCollection.size()}</td>
      </tr>
    </c:forEach>
</table>
    </body>
</html>

<%-- 
    Document   : ClientCommandeview
    Created on : 14 févr. 2020, 14:51:56
    Author     : Marie
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Marisol Canavy">
        <title> Mes commandes</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/4cd26dbae1.js" crossorigin="anonymous"></script>
    </head>
    <body class="d-flex flex-column h-100">
        <header>
            <nav class="navbar navbar-expand-md navbar-light bgMr fixed-top">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/mvc/acceuil">Acceuil</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                        aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="#">Créer un bon de commande</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="commandes">Voir ses bons de commandes</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ">
                        <li class="nav-item ">
                            <a class="nav-link" href="editProfilClient">Voir mon compte</a>
                        </li>
                        <li>
                            <a class="navbar-brand" href="${pageContext.request.contextPath}/mvc/authentification"><i class="fas fa-sign-out-alt"></i></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <main role="main" class="my-auto">
            <div class="container"> 
                <h1 class="mt-5">Commandes pour le client ${client.c.contact}</h1>
                <table border='1' style="responsive-table">
                    <tr style="table-header"><th class="col col-1">Numéro</th><th class="col col-1">Saisie le</th><th class="col col-1">Nombre d'articles</th></tr>
                            <%-- Pour chaque commande, une ligne dans la table HTML --%>
                    <c:forEach var="commande" items="${client.c.commandeCollection}">
                        <tr style="table-row">
                            <td class="col col-1">${commande.numero}</td>
                            <td class="col col-1"><fmt:formatDate value="${commande.saisieLe}" pattern="dd/MM/yyyy" /></td>
                            <td class="col col-1">${commande.ligneCollection.size()}</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </main>
        <footer class="footer mt-auto py-3">
            <div class="container">
                <span class="text-muted">© Projet Technologies Web - Canavy Nourrisson Salvan</span>
            </div>
        </footer>
    </body>
</html>

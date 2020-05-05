<%-- 
    Document   : editProfilClient
    Created on : 3 mars 2020, 15:06:34
    Author     : emmasalvan
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="fr">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Marisol Canavy">
        <title>Acceuil</title>
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

                <h1 class="mt-5">Edition de votre profil client</h1>
                <h2 class="lead">Si vous souhaitiez modifier vos coordonnées, vous êtes au bon endroit! </h2>
                <p class="lead"> Les changements se feront lors de votre reconnexion.</p>
                <form method="POST">
                    <div class="form__group field container">
                        <div class="row">
                            <div class="col">
                                <input type="input" class="form__field" name="societe" id='societe' value="${client.c.societe}" required />
                                <label for="societe" class="form__label">Societe</label>
                            </div>
                        </div>
                    </div>
                    <div class="form__group field container">
                        <div class="row">
                            <div class="col">
                                <input type="input" class="form__field" name="fonction" id='fonction' value="${client.c.fonction}" required />
                                <label for="fonction" class="form__label">Fonction</label>
                            </div>

                        </div>
                    </div>
                    <div class="form__group field container"> 
                        <div class="row">
                            <div class="col">
                                <input type="input" class="form__field" name="adresse" id='adresse' value="${client.c.adresse}" required />
                                <label for="adresse" class="form__label">Adresse</label>
                            </div>
                        </div>
                    </div>            
                    <div class="form__group field container">
                        <div class="row">
                            <div class="col">
                                <input type="input" class="form__field" name="adresse" id='adresse' value="${client.c.adresse}" required />
                                <label for="adresse" class="form__label">Adresse</label>
                            </div>
                            <div class="col-2">
                                <input type="input" class="form__field" name="codepostal" id='fonction' value="${client.c.codePostal}" required />
                                <label for="codepostal" class="form__label">Code Postal</label>
                            </div>
                            <div class="col-2">
                                <input type="input" class="form__field" name="ville" id='ville' value="${client.c.ville}" required />
                                <label for="ville" class="form__label">Ville</label>
                            </div>
                            <div class="col">
                                <input type="input" class="form__field" name="region" id='region' value="${client.c.region}" required />
                                <label for="region" class="form__label">Region</label>
                            </div>

                            <div class="col">
                                <input type="input" class="form__field" name="pays" id='pays' value="${client.c.pays}" required />
                                <label for="pays" class="form__label">Pays</label>
                            </div>
                        </div>
                    </div>
                    <div class="form__group field container">
                        <div class="row">
                            <div class="col">
                                <input type="input" class="form__field" name="telephone" id='telephone' value="${client.c.telephone}" required />
                                <label for="telephone" class="form__label">Telephone</label>
                            </div>
                            <div class="col">
                                <input type="input" class="form__field" name="fax" id='fax' value="${client.c.fax}" required />
                                <label for="fax" class="form__label">Fax</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 mt-5"  style="margin: auto;">
                        <input class="btn btn-lg btn-connexion btn-block" type="submit" placeholder="Mettre à jour">
                    </div>
                </form>

            </div>
            <h1>Commandes pour le client ${client.c.societe}</h1>
<table border='1'>
  <tr><th>Numéro</th><th>Saisie le</th><th>Nombre d'articles</th></tr>
  <%-- Pour chaque commande, une ligne dans la table HTML --%>
  <c:forEach var="commande" items="${client.c.commandeCollection}">
      <tr>
          <td>${commande.numero}</td>
          <td><fmt:formatDate value="${commande.saisieLe}" pattern="dd/MM/yyyy" /></td>
          <td>${commande.ligneCollection.size()}</td>
      </tr>
    </c:forEach>
</table>
        </main>
        <footer class="footer mt-auto py-3">
            <div class="container">
                <span class="text-muted">© Projet Technologies Web - Canavy Nourrisson Salvan</span>
            </div>
        </footer>

    </body>
</html>

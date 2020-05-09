<%-- 
    Document   : acceuil
    Created on : 29 avr. 2020, 20:15:08
    Author     : marisolcanavy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
                <a class="navbar-brand" href="#">Acceuil</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                        aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="commandes">Voir ses bons de commandes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="categorieProduits">Voir les produits</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="commandeEditor">Mon panier</a>
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
                <div class="starter-template text-center">
                    <h1 class="mt-5">Bienvenue ${client.nom} sur RoseMarket !</h1>
                    <p class="lead">A partir de cette page, vous pouvez :</p>
                    <ul class="liste">
                        <li>
                            <a class="r" href="">Créer un bon de commmande</a>
                        </li>
                        <li>
                            <a class="r" href="commandes">Consulter vos bons de commandes</a>
                        </li>
                        <li>
                            <a class="r" href="editProfilClient">Acceder à votre profil</a>
                        </li>
                    </ul>
                    <p class="lead mt-4">Bon shopping !</p>
                </div>
            </div>
        </main>
        <footer class="footer mt-auto py-3">
            <div class="container">
                <span class="text-muted">© Projet Technologies Web - Canavy Nourrisson Salvan</span>
            </div>
        </footer>

    </body>

</html>
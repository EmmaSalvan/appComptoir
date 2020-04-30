<%-- 
    Document   : admin
    Created on : 30 avr. 2020, 19:31:19
    Author     : marisolcanavy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="fr">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Connexion</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <!-- On charge JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- On charge l'API Google -->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">

            google.charts.load('current', {'packages': ['corechart']});
            // On fait l'appel AJAX dès le chargement de la page
            google.charts.setOnLoadCallback(doAjax);

            function drawPiechart(result) {
                // On met le résultat au format attendu par google
                var data = [['Produit', 'Unités vendues']];
                result.forEach(ligne => data.push([ligne.libelle, ligne.unites]));
                var dataTable = google.visualization.arrayToDataTable(data);
                var options = {
                    titlePosition: 'none',
                    pieHole: 0.4,
                    colors: ['#d4dcdc', '#e7d8c9', '#b2967d', '#f9c6c9', '#e29578'],
                    pieSliceTextStyle: {color: 'black'},
                    legend: {position: 'bottom', textStyle: {color: 'black'}},
                    backgroundColor: {fill: '#eee4e1'},
                    width: 340,
                    height: 300,
                };

                var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                chart.draw(data, options);

                //var chart = new google.visualization.PieChart(document.getElementById('donutchart1'));
                //chart.draw(data, options);
                //var chart = new google.visualization.PieChart(document.getElementById('donutchart2'));
                //chart.draw(data, options);

            }

            // Afficher les ventes par catégorie
            function doAjax() {
                $.ajax({
                    url: "mvc/service/unitesVendues/categories",
                    dataType: "json",
                    success: drawPiechart, // La fonction qui traite les résultats
                    error: showError
                });
            }

            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert("Erreur: " + status + " : " + message);
            }

        </script>
    </head>

    <body class="d-flex flex-column h-100">
        <header>
            <nav class="navbar navbar-expand-md navbar-light bgMr fixed-top">
                <a class="navbar-brand ml-auto mr-auto" href="#">DashBoard Admin</a>
            </nav>
        </header>
        <main role="main" class="my-auto">
            <div class="container">
                <div class="row align-items-center">
                    <div class="starter-template text-center" style="margin: auto;">
                        <h1 class="mt-5">Bienvenue sur RoseMarket cher Administrateur!</h1>
                        <p class="lead">A partir de cette page, vous pouvez visualiser le chiffre d'affaire
                            pour :</p>
                        <ul class="liste" style="width: 230px;">
                            <li>
                                <a class="r" href="#">Les catégories d'articles</a>
                            </li>
                            <li>
                                <a class="r" href="#">Les pays</a>
                            </li>
                            <li>
                                <a class="r" href="#">Les clients</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col text-right">
                        <p class="lead">En spécifiant la période ci-après :</p>
                    </div>
                    <div class="col text-left">
                        <div>
                            <form
                                style="max-width: 250px; background-color: rgb(238, 228, 225); padding-left: 30px; padding-right: 30px; padding-top: 0px; padding-bottom: 10px;">
                                <label for="dateDeb" class="sr-only">Date de début</label>
                                <input type="date" id="dateDeb" class="form-control" placeholder="01/01/2010" required=""
                                       autofocus="">
                                <label for="dateFin" class="sr-only">Date de fin</label>
                                <input type="date" id="dateFin" class="form-control" placeholder="01/01/2012" required="">
                                <div id="messageErreur">
                                    <p>${errorMessage}</p>
                                </div>
                                <button class="btn btn-lg btn-connexion btn-block" type="submit">Se connecter</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <p class="lead text-center" style="background-color: #e29578; padding: 5px;">Voici les résultats sur la
                    période de Juin à Juillet 2020.</p>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="text-center lead" style="transform: translateY(20px);">CA par catégorie de produits</p>
                        <div id="donutchart"></div>
                    </div>
                    <div class="col">
                        <p class="text-center lead " style="transform: translateY(20px);">CA par pays</p>
                        <div id="donutchart1"></div>
                    </div>
                    <div class="col">
                        <p class="text-center lead" style="transform: translateY(20px);">CA par client</p>
                        <div id="donutchart2"></div>
                    </div>
                </div>
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
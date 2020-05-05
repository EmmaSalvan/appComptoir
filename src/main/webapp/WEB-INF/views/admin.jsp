<%-- 
    Document   : admin
    Created on : 1 mai 2020, 01:22:25
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
        <title>DashBoard Administrateur</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <!-- On charge JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- On charge l'API Google-->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            function drawGraph() {
           
            var data = await fetch("${pageContext.request.contextPath}/mvc/service/unitesVendues/CAcategories").then(data => {
            return data.json();
            }).then(json => {
            json.unshift(['Catégories', "Chiffre d\'affaire", ]);
            console.log(json);
            return google.visualization.arrayToDataTable(json);
            });
            var options = {
            colors: ['#b2967d'],
                    legend: {position: 'none'},
                    backgroundColor: {
                    fill: '#eee4e1',
                            fillOpacity: 0.8
                    },
                    width: 1140,
                    height: 600
            };
            var chart = new google.charts.Bar(document.getElementById('donutchart'));
            chart.draw(data, options);
           
            //suite
            data = await fetch("${pageContext.request.contextPath}/mvc/service/unitesVendues/CApays").then(data => {
            return data.json();
            }).then(json => {
            json.unshift(['Pays', "Chiffre d\'affaire", ]);
            console.log(json);
            return google.visualization.arrayToDataTable(json);
            });
            var chart = new google.charts.Bar(document.getElementById('donutchart1'));
            chart.draw(data, options);
            data = await fetch("${pageContext.request.contextPath}/mvc/service/unitesVendues/CAclient").then(data => {
            return data.json();
            }).then(json => {
            json.unshift(['Clients', "Chiffre d\'affaire", ]);
            console.log(json);
            return google.visualization.arrayToDataTable(json);
            });
            var chart = new google.charts.Bar(document.getElementById('donutchart2'));
            chart.draw(data, options);
            }
        </script>
        <!--<script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            // On fait l'appel AJAX dès le chargement de la page
            google.charts.setOnLoadCallback(doAjax);

            function drawPiechart(result) {
                // On met le résultat au format attendu par google
                var data = [['Catégorie', 'Chiffre d\'affaire']];
                result.forEach(ligne => data.push([ligne.libelle, ligne.prix]));
                var dataTable = google.visualization.arrayToDataTable(data);

                var options = {
                    colors: ['#b2967d'],
                    legend: {position: 'none'},
                    backgroundColor: {
                        fill: '#eee4e1',
                        fillOpacity: 0.8
                    },
                    width: 1140,
                    height: 600
                };

                var chart = new google.charts.Bar(document.getElementById('donutchart'));
                chart.draw(dataTable, options);

                var chart = new google.charts.Bar(document.getElementById('donutchart1'));
                chart.draw(dataTable, options);
                var chart = new google.charts.Bar(document.getElementById('donutchart2'));
                chart.draw(dataTable, options);

            }

            // Afficher les ventes par catégorie
            function doAjax() {
                $.ajax({
                    url: "mvc/service/unitesVendues/CAcategories",
                    dataType: "json",
                    success: drawPiechart, // La fonction qui traite les résultats
                    error: showError
                });
            }

            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert("Erreur: " + status + " : " + message);
            }

        </script>-->
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
                    <div class="col text-left set-option">
                        <div class="date-range-tool" style="max-width: 250px; background-color: rgb(238, 228, 225); padding-left: 30px; padding-right: 30px; padding-top: 0px; padding-bottom: 10px;">
                            <div class="date-picker-group"> 
                                <!--<label for="from" class="sr-only">Date de début</label>-->
                                <input type="date" id="from" name="from" class="form-control" >
                                <!--<label for="to" class="sr-only">Date de fin</label>-->
                                <input type="date" id="to" name="to" class="form-control"></div>
                            <div id="slider-range"></div>
                            <div id="messageErreur"><p id="messageErreur"></p>

                            </div>
                            <!--<button class="btn btn-lg btn-connexion btn-block">Afficher</button>-->

                        </div>
                    </div>
                </div>
            </div>
            <div>
                <p class="lead text-center" style="background-color: #e29578; padding: 5px;">Voici les résultats sur la
                    période demandé : </p>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="text-center lead">CA par catégorie de produits</p>
                        <div id="donutchart"></div>
                    </div>
                    <div class="col">
                        <p class="text-center lead">CA par pays</p>
                        <div id="donutchart1"></div>
                    </div>
                    <div class="col">
                        <p class="text-center lead">CA par client</p>
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
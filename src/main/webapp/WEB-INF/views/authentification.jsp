<%-- 
    Document   : authentification
    Created on : 3 mars 2020, 14:42:02
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
</head>
<body class="text-center">

    <form class="form-signin"  method="POST">
        <h1 class="h3 mb-3 font-weight-normal">Connectez-vous</h1>
        <label for="inputEmail" class="sr-only">Login</label>
        <input type="string" name="contact" id="inputEmail" class="form-control" placeholder="Contact" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Mot de passe</label>
        <input type="password" name="motDePasse" id="inputPassword" class="form-control" placeholder="Mot de passe" required="">
        <div id="messageErreur">
            <p>${errorMessage}</p>
        </div>
        <input class="btn btn-lg btn-connexion btn-block" type="submit" placeholder="Se Connecter">
        <p class="mt-4 mb-3 text-muted">© Projet Technologies Web</p>
    </form>
        
</body>

</html>
<%-- 
    Document   : authentification
    Created on : 3 mars 2020, 14:42:02
    Author     : marisolcanavy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
<!--        <script type="text/javascript">
            function handleClick(clickedId)
            {
                if (clickedId == "administrateur"){
                    document.getElementById('adm1').style.display = "block";
                    document.getElementById('cl1').style.display = "none";
                } else {
                    document.getElementById('cl1').style.display = "block";
                    document.getElementById('adm1').style.display = "none";
                }
            }
        </script>-->

    </head>
    <body>
        <h1>Veuillez vous authentifier.</h1>
        <form method='POST' action="Connect?."> 
            Statut : <br>
            <input type="radio" name="Type" onclick="handleClick(this.id);" id="administrateur" />
            <label for="administrateur"> Administateur</label></br>
            <input type="radio" name="Type" onclick="handleClick(this.id);" id="client" />
            <label for="client"> Client</label> </br>

            <div id="adm1" style="display: none;"><p> Nom : <input name="nom"><br> Mail : <input name="email" type="email"><br></p></div>
            <div id="cl1" style="display: none;" ><p> Login : <input name="nom"><br> Mot de passe : <input name="email" type="password"><br></p></div>

            <input type='submit'>

            </div>
        </form>

        <a href="${pageContext.request.contextPath}/">Retour au menu</a>
    </body>

</html>

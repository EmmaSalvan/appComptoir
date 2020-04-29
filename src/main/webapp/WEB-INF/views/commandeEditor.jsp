<%-- 
    Document   : commandeEditor
    Created on : 14 févr. 2020, 17:02:51
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Edition des commandes </title>
    </head>
    <body>
        <h1> Edition des commandes </h1>
        
        <form method="POST">
            
            <input name=" " placeholder=" "><br>
                <ul> 
                        <c:forEach var="error" items="${validationErrors.getErrors('libelle')}">
                                <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                        </c:forEach>
                </ul>

                <input name=" " placeholder=" "><br>
                <ul> 
                        <c:forEach var="error" items="${validationErrors.getErrors('description')}">
                                <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                        </c:forEach>
                </ul>
                <input type="submit" value="ajouter une nouvelle commande">
        </form>
    </body>
</html>

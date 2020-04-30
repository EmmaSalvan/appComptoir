<%-- 
    Document   : editProfilClient
    Created on : 3 mars 2020, 15:06:34
    Author     : emmasalvan
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edition du profil client</title>
    </head>
    <body>
        <h1>Edition du profil client</h1>
        
        <table border='1'>
		<tr><th>Code</th><th>Societe</th><th>Contact</th><th>Fonction</th><th>Adresse</th><th>Ville</th><th>Region</th><th>CodePostal</th><th>Pays</th><th>Telephone</th><th>Fax</th></tr>
			<tr>
				<td>${clients.code}</td>
				<td>${mvc.encoders.html(clients.societe)}</td>
				<td>${mvc.encoders.html(clients.contact)}</td>
                                <td>${mvc.encoders.html(clients.fonction)}</td>
                                <td>${mvc.encoders.html(clients.adresse)}</td>
                                <td>${mvc.encoders.html(clients.ville)}</td>
                                <td>${mvc.encoders.html(clients.region)}</td>
                                <td>${mvc.encoders.html(clients.codepostal)}</td>
                                <td>${mvc.encoders.html(clients.pays)}</td>
                                <td>${mvc.encoders.html(clients.telephone)}</td>
                                <td>${mvc.encoders.html(clients.fax)}</td>
			</tr>
	</table>
        
        <form method="POST"> <%-- L'action par défaut est de revenir à l'URL du contrôleur --%>

            <input name="societe" placeholder="Société"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('societe')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
               
            <input name="contact" placeholder="Contact"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('contact')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="fonction" placeholder="Fonction"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('fonction')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="adresse" placeholder="Adresse"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('adresse')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="ville" placeholder="Ville"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('ville')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="region" placeholder="Région"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('region')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
            
            <input name="code_postal" placeholder="Code Postal"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('codepostal')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="pays" placeholder="Pays"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('pays')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="telephone" placeholder="Téléphone"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('telephone')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input name="fax" placeholder="Fax"><br>
            <ul> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('fax')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </ul>
                
            <input type="submit" value="Modifier le profil">
        </form>
                
        <a href="${pageContext.request.contextPath}/">Retour au menu</a>
    </body>
</html>

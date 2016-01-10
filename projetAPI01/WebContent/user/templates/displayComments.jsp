<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Commentaires</h2>
<c:choose>
	<c:when test="${not empty comments}">
		<c:forEach var="comment" items="${comments}">
		  <h3>Posté par ${comment.utilisateur.prenom} ${comment.utilisateur.nom} le <fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${comment.commentDate}"/> </h3>
		  <p>${comment.description}</p>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>Aucun commentaire n'a été posté</p>
	</c:otherwise> 
</c:choose>	
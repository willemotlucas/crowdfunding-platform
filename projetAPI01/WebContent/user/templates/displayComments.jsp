<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Commentaires</h2>
<c:choose>
	<c:when test="${not empty comments}">
		<c:forEach var="comment" items="${comments}">
		  <h3>Post� par ${comment.utilisateur.prenom} ${comment.utilisateur.nom} le ${comment.commentDate}</h3>
		  <p>${comment.description}</p>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>Aucun commentaire n'a �t� post�</p>
	</c:otherwise> 
</c:choose>	
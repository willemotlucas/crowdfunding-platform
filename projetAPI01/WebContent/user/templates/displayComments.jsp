<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
	<h2>Commentaires</h2>
</div>
<c:choose>
	<c:when test="${not empty comments}">
		<c:forEach var="comment" items="${comments}">
			<div class="row">
				<div class="col-md-1">
					<img class="img-circle" src="http://placehold.it/80x80">
				</div>
				<div class="col-md-11">
					<h3 style="margin-top:0px;">${comment.utilisateur.prenom} ${comment.utilisateur.nom} le <fmt:formatDate type="date" dateStyle="long" value="${comment.commentDate}"/> à <fmt:formatDate type="time" timeStyle="short" value="${comment.commentDate}"/></h3>
		  			<p>${comment.description}</p>
		  			<hr>
				</div>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<h4>Aucun commentaire n'a été posté</h4>
		<hr>
	</c:otherwise> 
</c:choose>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
	<h2>Commentaires</h2>
</div>
	
	<div class="row">	
		<div class="container">
			<div class="page-header">
		 		<h3>Management des commentaires</h3>
		 	</div>
			<c:choose>
					<c:when test="${not empty comments}">
						<table id="manageComments" class="table table-striped ">
							<thead>
								<tr>
					                <th>Id</th>
					                <th>Description</th>
					                <th>Date</th>
					                <th>Utilisateur</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="comment" items="${comments}">
									<tr>
					                    <td>${comment.id}</td>
					                    <td>${comment.description}</td>
					                    <td>${comment.commentDate}</td>
					                    <td>${comment.utilisateur.email}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
							
					<c:otherwise>
					<p>Il n'y a pas de commentaires</p>
					</c:otherwise> 
				</c:choose>
		</div>
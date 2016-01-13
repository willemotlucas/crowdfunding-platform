<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Homepage for normal user</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="/projetAPI01/public/bootstrap/css/sidebar-menu.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">
    
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>

</head>
<body>
	<script>$(document).ready(function() {$('#commentsPosted').DataTable();});</script>
	<jsp:include page="templates/menu.jsp"/>
				
		 <div class="container">
		 	<div class="page-header">
		 		<h1>Liste des commentaires postés</h1>
		 	</div>
		 	<c:choose>
				<c:when test="${not empty comments}">
					<table id="commentsPosted" class="table table-striped ">
						<thead>
							<tr>
								<th>Idée commentée</th>
								<th>Proposée par </th>
								<th>Date du commentaire</th>
								<th>Message</th>
								<th>Voir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="comment" items="${comments}">
								<tr>
									<td>${comment.idea.name}</td>
									<td>${comment.idea.madeBy.prenom} ${comment.idea.madeBy.nom}</td>
									<td>${comment.commentDate}</td>
									<td>${comment.description}</td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${comment.idea.id}" class="btn btn-success" role="button">Voir</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				
				<c:otherwise>
				<p>Vous n'avez proposé aucune idée !</p>
				</c:otherwise> 
			</c:choose>
		 </div>
</body>
</html>
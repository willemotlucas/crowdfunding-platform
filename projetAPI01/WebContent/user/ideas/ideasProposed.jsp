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
	<script src="/projetAPI01/public/js/deleteIdea.js"></script>

</head>
<body>
	<script>$(document).ready(function() {$('#proposedIdeas').DataTable();});</script>
	<jsp:include page="../templates/menu.jsp"/>
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="nav nav-pills nav-stacked">
			  <li role="presentation" class="active"><a href="/projetAPI01/user/ideas/proposed">Idées proposées</a></li>
			  <li role="presentation"><a href="/projetAPI01/user/ideas/evaluated">Idées evaluées</a></li>
			  <li role="presentation"><a href="/projetAPI01/user/ideas/pledged">Idées financées</a></li>
			  <li role="presentation"><a href="/projetAPI01/user/comments/posted">Commentaires postés</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->
				
		 <div id="page-content-wrapper">
		 	<div class="page-header">
		 		<h1>Liste des idées proposées</h1>
		 	</div>
		 	<c:choose>
				<c:when test="${not empty ideas}">
					<table id="proposedIdeas" class="table table-striped ">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Phase</th>
								<th>Date de création</th>
								<th>Montant demandé</th>
								<th>Voir</th>
								<th>Modifier</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="entry" items="${ideas}">
								<tr id="${entry.key.id}">
									<td>${entry.key.name}</td>
									<td>${entry.value.currentPhase}</td>
									<td>${entry.key.proposedDate}</td>
									<td>${entry.key.fundingRequested} euros</td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${entry.key.id}" class="btn btn-success" role="button">Voir</a></td>
									<td><a href="/projetAPI01/user/idea/edit?id=${entry.key.id}" class="btn btn-primary" role="button">Modifier</a></td>
									<td><a id="${entry.key.id}" class="btn btn-danger deleteIdea" role="button">Supprimer</a></td>
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
	</div>
</body>
</html>
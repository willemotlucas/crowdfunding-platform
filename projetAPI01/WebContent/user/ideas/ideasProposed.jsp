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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<link rel="stylesheet" href="/projetAPI01/public/bootstrap/css/sidebar-menu.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../templates/menu.jsp"/>
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="nav nav-pills nav-stacked">
			  <li role="presentation" class="active"><a href="#">Idées proposées</a></li>
			  <li role="presentation"><a href="#">Idées evaluées</a></li>
			  <li role="presentation"><a href="#">Idées commentées</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->
				
		 <div id="page-content-wrapper">
		 	<div class="page-header">
		 		<h1>Liste des idées proposées</h1>
		 	</div>
		 	<c:choose>
				<c:when test="${not empty ideas}">
					<table class="table table-striped table-hover">
						<tr>
							<th>Nom</th>
							<th>Phase</th>
							<th>Date de création</th>
							<th>Montant demandé</th>
							<th>Voir</th>
							<th>Modifier</th>
							<th>Supprimer</th>
						</tr>
							<c:forEach var="entry" items="${ideas}">
								<tr>
									<td>${entry.key.name}</td>
									<td>${entry.value.currentPhase}</td>
									<td>${entry.key.proposedDate}</td>
									<td>${entry.key.fundingRequested} euros</td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${entry.key.id}" class="btn btn-success" role="button">Voir</a></td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${entry.key.id}" class="btn btn-primary" role="button">Modifier</a></td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${entry.key.id}" class="btn btn-danger" role="button">Supprimer</a></td>
								</tr>
							</c:forEach>
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
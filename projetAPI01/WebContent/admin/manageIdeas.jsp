<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container">
	<jsp:include page="templates/menu.jsp"/>
		<div class="page-header">
		   <h1>Gestion des idées</h1>
		</div>
		
		<script>$(document).ready(function() {
		    $('#manageIdeas').DataTable();
		} );</script>
	
	 	<div class="page-header">
	 		<h2>Liste des idées de Launch-My-Idea</h2>
	 	</div>
		<a href="/projetAPI01/admin/idea/addIdea.jsp" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i>&nbsp;Ajouter une idée</a>
		<c:choose>
			<c:when test="${not empty sessionScope.allIdeas}">
				<table id="manageIdeas" class="table table-striped ">
					<thead>
						<tr>
			                <th>Id</th>
			                <th>Nom</th>
			                <th>Marché</th>
			                <th>Fonds demandés</th>
			                <th>Date</th>
			                <th>Utilisateur</th>
			                <th>Phase</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="idea" items="${sessionScope.allIdeas}">
							<tr>
			                    <td>${idea.id}</td>
			                    <td>${idea.name}</td>
			                    <td>${idea.targetedMarket}</td>
			                    <td>${idea.fundingRequested}</td>
			                    <td>${idea.proposedDate}</td>
			                    <td>${idea.madeBy.email}</td>
			                    <td>${idea.phaseContext.currentPhase}
								<td><a href="/projetAPI01/admin/ideaDetails?id=${idea.id}" class="btn btn-success" role="button">Voir</a></td>
								<td><a href="/projetAPI01/admin/idea/edit?id=${idea.id}" class="btn btn-primary" role="button">Modifier</a></td>
								<td><a href="/projetAPI01/admin/ideaPhase/edit?id=${idea.id}" class="btn btn-primary" role="button">Modifier la phase</a></td>
								<td><a href="/projetAPI01/admin/idea/delete?idIdea=${idea.id}" class="btn btn-danger" role="button">Supprimer</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
					
			<c:otherwise>
			<p>Il n'y a pas d'idées</p>
			</c:otherwise> 
		</c:choose>
	</div>

</body>
</html>

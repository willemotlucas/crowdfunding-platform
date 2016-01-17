<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Management des commentaires</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    
    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="templates/menu.jsp"/>
	<div class="container">
	
		<div class="page-header">
		   <h1>Gestion des commentaires</h1>
		</div>
		
		<script>$(document).ready(function() {
		    $('#manageComments').DataTable();
		} );</script>
	
	 	<div class="page-header">
	 		<h2>Liste des commentaires Launch-My-Idea</h2>
	 	</div>
		<a href="/projetAPI01/admin/addCommentsAdmin" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i>&nbsp;Ajouter un commentaire</a>
		<c:choose>
			<c:when test="${not empty requestScope.allComments}">
				<table id="manageComments" class="table table-striped ">
					<thead>
						<tr>
			                <th>Id</th>
			                <th>Description</th>
			                <th>Date</th>
			                <th>Utilisateur</th>
			                <th>Idée</th>
			                <th>Modifier</th>
			                <th>Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="comment" items="${requestScope.allComments}">
							<tr>
			                    <td>${comment.id}</td>
			                    <td>${comment.description}</td>
			                    <td>${comment.commentDate}</td>
			                    <td>${comment.utilisateur.email}</td>
			                    <td>${comment.idea.name}</td>
								<td><a href="/projetAPI01/admin/comments/edit?id=${comment.id}" class="btn btn-primary" role="button">Modifier</a></td>
								<td><a href="/projetAPI01/admin/comments/delete?id=${comment.id}" class="btn btn-danger" role="button">Supprimer</a></td>
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

</body>
</html>

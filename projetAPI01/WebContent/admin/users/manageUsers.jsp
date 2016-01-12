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
	<jsp:include page="/admin/templates/menu.jsp"/>
	<div class="container">
		<div class="row">
		   <h1 class="page-header">Gestion des utilisateurs</h1>
		</div>
	
		<script>$(document).ready(function() {
		    $('#manageUsers').DataTable();
		} );</script>
	
	 	<div class="page-header">
	 		<h2>Liste des utilisateurs de l'application</h2>
	 	</div>
	 	<div class="row">
			<a href="/projetAPI01/admin/users/addUserForm.jsp" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i>&nbsp;Ajouter un utilisateur</a>
	    </div>
	    <div class="row">
			<c:choose>
				<c:when test="${not empty sessionScope.allUsers}">
					<table id="manageUsers" class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Nom</th>
				                <th>Prenom</th>
				                <th>Email</th>
				                <th>Mot de passe</th>
				                <th>Telephone</th>
				                <th>Date de creation</th>
				                <th>Statut</th>
				                <th>Type</th>
				                <th>Adresse</th>
								<th>Voir</th>
								<th>Modifier</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${sessionScope.allUsers}">
								<tr>
				                    <td>${user.id}</td>
				                    <td>${user.nom}</td>
				                    <td>${user.prenom}</td>
				                    <td>${user.email}</td>
				                    <td>${user.password}</td>
				                    <td>${user.telephone}</td>
				                    <td>${user.dateCreation}</td>
				                    <td>${user.accountStatus}</td>
				                    <td>${user.accountType}</td>
				                    <td>${user.adress.num} ${user.adress.rue} ${user.adress.codePostale} ${user.adress.ville}</td>
									<td><a href="/projetAPI01/admin/editUser?id=${user.id}" class="btn btn-success" role="button">Voir</a></td>
									<td><a href="/projetAPI01/admin/editUser?id=${user.id}" class="btn btn-primary" role="button">Modifier</a></td>
									<td><a href="/projetAPI01/admin/removeUser?id=${user.id}" class="btn btn-danger" role="button">Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
						
				<c:otherwise>
				<p>Il n'y a aucun utilisateur</p>
				</c:otherwise> 
			</c:choose>
		</div>
	</div>

</body>
</html>
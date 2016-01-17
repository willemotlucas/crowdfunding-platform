<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des financements</title>

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
		   <h1 class="page-header">Gestion des financements</h1>
		</div>
	
		<script>$(document).ready(function() {
		    $('#manageFunds').DataTable();
		} );</script>
	
	 	<div class="page-header">
	 		<h2>Liste des financements de l'application</h2>
	 	</div>
	 	<div class="row">
			<a href="/projetAPI01/admin/addFund?id=${sessionScope.userSession.id}" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i>&nbsp;Ajouter un financement</a>
	    </div>
	    <div class="row">
			<c:choose>
				<c:when test="${not empty sessionScope.allMakeFunds}">
					<table id="manageFunds" class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Utilisateur</th>
				                <th>Idee</th>
				                <th>Montant</th>
								<th>Voir</th>
								<th>Modifier</th>
								<th>Supprimer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="Fund" items="${sessionScope.allMakeFunds}">
								<tr>
				                    <td>${Fund.id}</td>
				                    <td>${Fund.utilisateur.email}</td>
				                    <td>${Fund.fund.context.idea.name}</td>
				                    <td>${Fund.amount}</td>
									<td><a href="/projetAPI01/admin/seeFund?id=${Fund.id}" class="btn btn-success" role="button">Voir</a></td>
									<td><a href="/projetAPI01/admin/editFund?id=${Fund.id}" class="btn btn-primary" role="button">Modifier</a></td>
									<td><a href="/projetAPI01/admin/removeFund?id=${Fund.id}" class="btn btn-danger" role="button">Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
						
				<c:otherwise>
				<p>Il n'y a aucun financement</p>
				</c:otherwise> 
			</c:choose>
		</div>
	</div>

</body>
</html>
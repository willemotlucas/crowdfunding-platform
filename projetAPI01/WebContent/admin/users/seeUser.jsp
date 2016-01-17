<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualisation de l'utilisateur</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="adressBean" class="com.utc.projetAPI01.beans.Adress" scope="session" />
    
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/admin/templates/menu.jsp"/>
	<div class="container">
		<div class="row">
		   <h1 class="page-header">Visualisation de l'utilisateur</h1>
		</div>
		<div class="page-header">
			<h3> Voici l'utilisateur ayant l'id : <jsp:getProperty name="userBean" property="id" /></h3>
		</div>
	 	<div class="row">
			Nom : <span class="marge"></span> <jsp:getProperty name="userBean" property="nom" /></br>
			Prenom : <span class="marge"></span> <jsp:getProperty name="userBean" property="prenom" /></br>
			Email : <span class="marge"></span> <jsp:getProperty name="userBean" property="email" /></br>
			Mot de passe : <span class="marge"></span> <jsp:getProperty name="userBean" property="password" /></br>
			Telephone : <span class="marge"></span> <jsp:getProperty name="userBean" property="telephone" /></br>
			Adresse : <span class="marge"></span> <jsp:getProperty name="adressBean" property="num" /> &nbsp; <jsp:getProperty name="adressBean" property="rue" /> &nbsp; </br>
			 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<jsp:getProperty name="adressBean" property="codePostale" /> &nbsp; <jsp:getProperty name="adressBean" property="ville" /></br>
			Statut : <span class="marge"></span> <jsp:getProperty name="userBean" property="accountStatus" /></br>
			Type : <span class="marge"></span> <jsp:getProperty name="userBean" property="accountType" /></br>
			Date de création : <span class="marge"></span> <jsp:getProperty name="userBean" property="dateCreation" /></br>
		</div>
		<div class="page-header">
			<h3> Voici ses idées</h3>
		</div>
	 	<div class="row">
			<script>$(document).ready(function() {
			    $('#ideas').DataTable();
			} );</script>
			<c:choose>
				<c:when test="${not empty userIdeas}">
					<table id=ideas class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Nom</th>
				                <th>Marché</th>
				                <th>Fonds demandés</th>
				                <th>Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="idea" items="${userIdeas}">
								<tr>
				                    <td>${idea.id}</td>
				                    <td>${idea.name}</td>
				                    <td>${idea.targetedMarket}</td>
				                    <td>${idea.fundingRequested}</td>
				                    <td>${idea.proposedDate}</td>
				                </tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>						
				<c:otherwise>
				<p>Cet utilisateur n'a pas créé d'idée</p>
				</c:otherwise> 
			</c:choose>
		</div>
		<div class="page-header">
			<h3> Voici ses commentaires</h3>
		</div>
	 	<div class="row">
			<script>$(document).ready(function() {
			    $('#comments').DataTable();
			} );</script>
			<c:choose>
				<c:when test="${not empty userComments}">
					<table id=comments class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Commentaire</th>
				                <th>Idee</th>
				                <th>Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="comment" items="${userComments}">
								<tr>
				                    <td>${comment.id}</td>
				                    <td>${comment.description}</td>
				                    <td>${comment.idea.name}</td>
				                    <td>${comment.commentDate}</td>
				                </tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>						
				<c:otherwise>
				<p>Cet utilisateur n'a pas créé de commentaire</p>
				</c:otherwise> 
			</c:choose>
		</div>
		<div class="page-header">
			<h3> Voici ses thumbs</h3>
		</div>
	 	<div class="row">
			<script>$(document).ready(function() {
			    $('#thumbs').DataTable();
			} );</script>
			<c:choose>
				<c:when test="${not empty userThumbs}">
					<table id=thumbs class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Idee</th>
				                <th>Score</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="thumb" items="${userThumbs}">
								<tr>
				                    <td>${thumb.id}</td>
				                    <td>${thumb.discussion.context.idea.name}</td>
				                    <td>${thumb.score}</td>
				                </tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>						
				<c:otherwise>
				<p>Cet utilisateur n'a pas créé de thumb</p>
				</c:otherwise> 
			</c:choose>
		</div>
		<div class="page-header">
			<h3> Voici ses evaluations</h3>
		</div>
	 	<div class="row">
			<script>$(document).ready(function() {
			    $('#evals').DataTable();
			} );</script>
			<c:choose>
				<c:when test="${not empty userEvals}">
					<table id=evals class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Idee</th>
				                <th>Faisabilité</th>
				                <th>Interet du marche</th>
				                <th>Impact</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="eval" items="${userEvals}">
								<tr>
				                    <td>${eval.id}</td>
				                    <td>${eval.evaluation.context.idea.name}</td>
				                    <td>${eval.feasibility}</td>
				                    <td>${eval.marketInterest}</td>
				                    <td>${eval.impact}</td>
				                </tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>						
				<c:otherwise>
				<p>Cet utilisateur n'a pas créé d'evaluation</p>
				</c:otherwise> 
			</c:choose>
		</div>
		<div class="page-header">
			<h3> Voici ses financements</h3>
		</div>
	 	<div class="row">
			<script>$(document).ready(function() {
			    $('#funds').DataTable();
			} );</script>
			<c:choose>
				<c:when test="${not empty userFunds}">
					<table id=funds class="table table-striped ">
						<thead>
							<tr>
				                <th>Id</th>
				                <th>Idee</th>
				                <th>Montant</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fund" items="${userFunds}">
								<tr>
				                    <td>${fund.id}</td>
				                    <td>${fund.fund.context.idea.name}</td>
				                    <td>${fund.amount}</td>
				                </tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>						
				<c:otherwise>
				<p>Cet utilisateur n'a pas créé de financement</p>
				</c:otherwise> 
			</c:choose>
		</div>
	</div>
</body>
</html>
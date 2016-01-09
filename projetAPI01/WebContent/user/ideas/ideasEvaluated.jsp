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
	<script>$(document).ready(function() {$('#ideasEvaluated1').DataTable();$('#ideasEvaluated2').DataTable();});</script>
	<jsp:include page="../templates/menu.jsp"/>
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="nav nav-pills nav-stacked">
			  <li role="presentation"><a href="/projetAPI01/user/ideas/proposed">Idées proposées</a></li>
			  <li role="presentation" class="active"><a href="/projetAPI01/user/ideas/evaluated">Idées evaluées</a></li>
			  <li role="presentation"><a href="/projetAPI01/user/ideas/pledged">Idées financées</a></li>
			  <li role="presentation"><a href="/projetAPI01/user/comments/posted">Commentaires postés</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->
				
		 <div id="page-content-wrapper">
		 	<div class="page-header">
		 		<h1>Liste des idées notées <small>en phase de discussion</small></h1>
		 	</div>
		 	<c:choose>
				<c:when test="${not empty thumbs}">
					<table id="ideasEvaluated1" class="table table-striped ">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Description</th>
								<th>Score donné</th>
								<th>Proposée par</th>
								<th>Date de création</th>								
								<th>Montant demandé</th>
								<th>Voir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="thumb" items="${thumbs}">
								<tr>
									<td>${thumb.discussion.context.idea.name}</td>
									<td>${thumb.discussion.context.idea.shortDescription}</td>
									<td>${thumb.score}</td>
									<td>${thumb.discussion.context.idea.madeBy.prenom} ${thumb.discussion.context.idea.madeBy.nom}</td>
									<td>${thumb.discussion.context.idea.proposedDate}</td>
									<td>${thumb.discussion.context.idea.fundingRequested} euros</td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${thumb.discussion.context.idea.id}" class="btn btn-success" role="button">Voir</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				
				<c:otherwise>
				<h3>Vous n'avez évalué aucune idée !</h3>
				</c:otherwise> 
			</c:choose>

		 
		 
		 <div class="page-header">
		 		<h1>Liste des idées évaluées <small>en phase d'évaluation</small></h1>
		 	</div>
		 	<c:choose>
				<c:when test="${not empty evaluations}">
					<table id="ideasEvaluated2" class="table table-striped ">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Description</th>
								<th>Proposée par</th>
								<th>Note faisabilité</th>
								<th>Note intérêt du marché</th>
								<th>Note impact</th>
								<th>Date de création</th>								
								<th>Montant demandé</th>
								<th>Voir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="evaluation" items="${evaluations}">
								<tr>
									<td>${evaluation.evaluation.context.idea.name}</td>
									<td>${evaluation.evaluation.context.idea.shortDescription}</td>
									<td>${evaluation.evaluation.context.idea.madeBy.prenom} ${evaluation.evaluation.context.idea.madeBy.nom}</td>									
									<td>${evaluation.feasibility}</td>
									<td>${evaluation.marketInterest}</td>
									<td>${evaluation.impact}</td>
									<td>${evaluation.evaluation.context.idea.proposedDate}</td>
									<td>${evaluation.evaluation.context.idea.fundingRequested} euros</td>
									<td><a href="/projetAPI01/user/ideaDetails?id=${evaluation.evaluation.context.idea.id}" class="btn btn-success" role="button">Voir</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				
				<c:otherwise>
				<h3>Vous n'avez évalué aucune idée !</h3>
				</c:otherwise> 
			</c:choose>
		 </div>
		</div>
</body>
</html>
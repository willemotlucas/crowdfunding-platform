<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Homepage for administrator</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<script>$(document).ready(function() {
		    $('#manageEvaluations').DataTable();
	} );</script>
	<script>$(document).ready(function() {
		    $('#manageRedactions').DataTable();
		} );</script>
	<jsp:include page="templates/menu.jsp"/>
	<div class="container">
		<div class="page-header">
		   <h1>Bienvenue sur le site d'administration</h1>
		</div>
		<div class="page-header">
		   <h2>Dashboard</h2>
		</div>
		<div class="page-header">
		   <h3>Evaluations à passer en financement</h3>
		</div>
		<c:choose>
			<c:when test="${not empty requestScope.evaluations}">
				<table id="manageEvaluations" class="table table-striped ">
					<thead>
						<tr>
			                <th>Id</th>
			                <th>Nom</th>
			                <th>Catégorie</th>
			                <th>Fonds demandés</th>
			                <th>Date</th>
			                <th>Utilisateur</th>
			                <th>Phase</th>
			                <th>Jours restant</th>
			                <th>Modifier Phase</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="evaluation" items="${requestScope.evaluations}">
								<tr>
				                    <td>${evaluation.value.id}</td>
				                    <td>${evaluation.key.name}</td>
				                    <td>${evaluation.key.applicationField}</td>
				                    <td>${evaluation.key.fundingRequested}</td>
				                    <td><fmt:formatDate type="date" dateStyle="long" value="${evaluation.value.datePhase}"/></td>
				                    <td>${evaluation.key.madeBy.email}</td>
				                    <td>${evaluation.key.phaseContext.currentPhase}</td>
				                    <td>${requestScope.joursRestant[evaluation.key.id] }</td>
									<td>
										<c:if test="${requestScope.joursRestant[evaluation.key.id] == 0}">
											<a href="/projetAPI01/admin/changePhase?id=${evaluation.value.id}" class="btn btn-primary" role="button">Passer en fund</a>
										</c:if>
									</td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
					
			<c:otherwise>
				<p>Il n'y a pas d'idées en phase d'évaluation</p>
			</c:otherwise> 
		</c:choose>
		
		<div class="page-header">
		   <h3>Redactions à passer en évaluation</h3>
		</div>
		<c:choose>
			<c:when test="${not empty redactions}">
				<table id="manageRedactions" class="table table-striped ">
					<thead>
						<tr>
			                <th>Id</th>
			                <th>Nom</th>
			                <th>Catégorie</th>
			                <th>Fonds demandés</th>
			                <th>Date</th>
			                <th>Utilisateur</th>
			                <th>Phase</th>
			                <th>Jours restant</th>
			                <th>Modifier Phase</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="redaction" items="${redactions}">
								<tr>
				                    <td>${redaction.value.id}</td>
				                    <td>${redaction.key.name}</td>
				                    <td>${redaction.key.applicationField}</td>
				                    <td>${redaction.key.fundingRequested}</td>
				                    <td><fmt:formatDate type="date" dateStyle="long" value="${redaction.value.datePhase}"/></td>
				                    <td>${redaction.key.madeBy.email}</td>
				                    <td>${redaction.key.phaseContext.currentPhase}</td>
				                    <td>${requestScope.joursRestant[redaction.value.id] }</td>
									<td>
										<c:if test="${requestScope.joursRestant[redaction.value.id] == 0}">
											<a href="/projetAPI01/admin/changePhase?id=${redaction.value.id}" class="btn btn-primary" role="button">Passer en evaluation</a>
										</c:if>
									</td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
					
			<c:otherwise>
				<p>Il n'y a pas d'idées en phase de redaction</p>
			</c:otherwise> 
		</c:choose>
	</div>
</body>
</html>
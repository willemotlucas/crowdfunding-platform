<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Homepage for normal user</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	<link rel="stylesheet" href="/projetAPI01/public/css/ideaDetails.css">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script>
	<script src="/projetAPI01/public/js/evaluateIdea.js"></script>
	
	</head>
<body>

	<jsp:include page="../templates/menu.jsp"/>
	
	<div class="row ideaDetails">
		<div class="container">
			<div class="row">
				<div class="page-header text-center">
				   <h1>${idea.name}</h1>
				   <h4><small>par ${creator.prenom} ${creator.nom}</small></h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<img src="http://placehold.it/500x300">
					<h4>
					<a href="/projetAPI01/search?method=applicationField&applicationField=${idea.applicationField}"><span class="glyphicon glyphicon-tags"></span> ${idea.applicationField}</a>  
					<a href="/projetAPI01/search?method=phase&currentPhase=${context.currentPhase}"><span class="glyphicon glyphicon-bookmark"></span>${context.currentPhase}</a>					
					</h4>
					<h3>${idea.shortDescription}</h3><br>
					<h3>Notes obtenues</h3>
					<c:choose>
						<c:when test="${not empty feasibility}">
							<div class="row">
								<div class="col-md-3 col-lg-3">
									<h2 id="meanFeasibility" class="bar-details">${feasibility}</h2>
									<p class="sub-details">faisabilité</p>					
								</div>
								<div class="col-md-3 col-lg-3">
									<h2 id="meanMarketInterest" class="bar-details">${marketInterest}</h2>
									<p class="sub-details">intérêt du marché</p>
								</div>
								<div class="col-md-3 col-lg-3	">
									<h2 id="meanImpact" class="bar-details">${impact}</h2>
									<p class="sub-details">impact</p>	
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<h4>Aucune évaluation n'a été donnée</h4>
						</c:otherwise>
					</c:choose>

					<h3>Votre évaluation</h3>
					<c:choose>
						<c:when test="${nbDaysRemains > 0 && empty evaluationScoreGiven}">
							<div class="row">
								<form data-toggle="validator">
									<div class="col-md-3 col-lg-3">
										<div class="input-group">
									      <input id="feasibility" type="number" class="form-control" min="0" max="10">
									    </div>
									    <div class="help-block with-errors"></div>					
									</div>
									<div class="col-md-3 col-lg-3">
										<div class="input-group">
									      <input id="marketInterest" type="number" class="form-control" min="0" max="10">
									    </div>
									    <div class="help-block with-errors"></div>
									</div>
									<div class="col-md-3 col-lg-3">
										<div class="input-group">
									      <input id="impact" type="number" class="form-control" min="0" max="10">
									    </div>
									    <div class="help-block with-errors"></div>	
									</div>
									<div class="col-md-3">
								    	<div class="input-group">
									      <button id="vote" type="button" class="btn btn-success">Voter</button>
									    </div>
								    </div>
								</form>
							</div>
						</c:when>
						
						<c:when test="${(nbDaysRemains > 0 && not empty evaluationScoreGiven) || (nbDaysRemains == 0 && not empty evaluationScoreGiven)}">
							<div class="row">
								<div class="col-md-3 col-lg-3">
									<h2 class="bar-details">${evaluationScoreGiven.feasibility}</h2>
									<p class="sub-details">faisabilité</p>					
								</div>
								<div class="col-md-3 col-lg-3">
									<h2 class="bar-details">${evaluationScoreGiven.marketInterest}</h2>
									<p class="sub-details">intérêt du marché</p>
								</div>
								<div class="col-md-3 col-lg-3	">
									<h2 class="bar-details">${evaluationScoreGiven.impact}</h2>
									<p class="sub-details">impact</p>	
								</div>
							</div>
						</c:when>
						
						<c:otherwise>
							<h4>Vous n'avez pas évalué cette idée</h4>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="col-md-2">
					<h2 class="bar-details">${idea.fundingRequested}<span class="glyphicon glyphicon-eur"></span></h2>
					<p class="sub-details">demandés</p>
					<h2 class="bar-details">${nbDaysRemains}
						<small style="font-size:52%;">
						<c:if test="${nbDaysRemains < 2}">
							jour restant
			        	</c:if>
			        	<c:if test="${nbDaysRemains >= 2}">
							jours restants
			        	</c:if>	
						</small>			
					</h2>
					<p class="sub-details">pour voter</p>
					<c:choose>
						<c:when test="${not empty mean}">
							<h2 id="mean" class="bar-details">${mean}</h2>
							<p class="sub-details">moyenne</p>
						</c:when>
						<c:otherwise>
							<h2>N/A</h2>
							<p class="sub-details">moyenne</p>
						</c:otherwise>
					</c:choose>
					


				</div>
				<div class="col-md-3 col-md-offset-1">
					<div class="thumbnail">
				    	<img class="img-circle" src="http://placehold.it/150x150">
				      <div class="caption">
				        	<h2 class="text-center">${idea.madeBy.prenom} ${idea.madeBy.nom }</h2>
				        	<h3 class="text-center">${idea.madeBy.adress.ville}</h3>
				        	<c:if test="${nbIdeasProposed < 2}">
				        		<h2 class="text-center">${nbIdeasProposed} <small>idée proposée</small></h2>
				        	</c:if>
				        	<c:if test="${nbIdeasProposed >= 2}">
				        		<h2 class="text-center">${nbIdeasProposed} <small>idées proposées</small></h2>
				        	</c:if>				        	
				        	<c:if test="${nbMakeFund < 2}">
				        		<h2 class="text-center">${nbMakeFund} <small>idée financée</small></h2>
				        	</c:if>
				        	<c:if test="${nbMakeFund >= 2}">
				        		<h2 class="text-center">${nbMakeFund} <small>idées financées</small></h2>
				        	</c:if>
				      </div>
				    </div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">	
		<div class="container">
			<%request.setAttribute("comments", request.getAttribute("comments")); %>
			<jsp:include page="../templates/displayComments.jsp"/>
			<jsp:include page="../templates/addComment.jsp"/>
		</div>
	</div>
	
	<div class="row">	
		<div class="container">
			<div class="page-header">
		 		<h3>Management des évaluations</h3>
		 	</div>
			<c:choose>
					<c:when test="${not empty requestScope.evaluationScores}">
						<table id="manageEvaluations" class="table table-striped ">
							<thead>
								<tr>
					                <th>Id</th>
					                <th>Feasibility</th>
					                <th>Market Interest</th>
					                <th>Impact</th>
					                <th>Utilisateur</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="eval" items="${requestScope.evaluationScores}">
									<tr>
					                    <td>${eval.id}</td>
					                    <td>${eval.feasibility}</td>
					                    <td>${eval.marketInterest}</td>
					                    <td>${eval.impact }</td>
					                    <td>${eval.utilisateur.email}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
							
					<c:otherwise>
					<p>Il n'y a pas d'évaluations</p>
					</c:otherwise> 
				</c:choose>
		</div>
		
</body>
</html>
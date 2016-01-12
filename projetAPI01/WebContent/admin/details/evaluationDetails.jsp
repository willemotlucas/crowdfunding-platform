<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${idea.name}</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script>
	<script src="/projetAPI01/public/js/evaluateIdea.js"></script>
	
	</head>
<body>
	<jsp:include page="../templates/menu.jsp"/>
	
	<div class="container">
		<div class="page-header">
		   <h1>${idea.name} <small>proposée par ${creator.prenom} ${creator.nom} le <fmt:formatDate type="date" dateStyle="long" value="${idea.proposedDate}"/></small></h1>
		</div>
		<h2>Description</h2>
		<p>Phase : ${context.currentPhase}</p>
		<p>${idea.shortDescription}</p>
		
		<h4>Montant demandé : ${idea.fundingRequested} euros</h4>
		
		<h2>Notes</h2>
		
		<c:choose>
			<c:when test="${not empty evaluationScoreGiven}">
			<form class="form-horizontal">
			  <div class="form-group">
			 	<label class="col-sm-3 col-sm-offset-2 control-label" style="text-align:left;">Votre évaluation</label>
			 </div>   
			  <div class="form-group">
			    <label class="col-sm-1 control-label">Faisabilité</label>
			    <div class="col-sm-1">
			      <p id="meanFeasibility" class="form-control-static">${feasibility}</p>
			    </div>
			    <div class="col-sm-1">
			      <p class="form-control-static">${evaluationScoreGiven.feasibility}</p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-1 control-label">Intérêt du marché</label>
			    <div class="col-sm-1">
			      <p id="meanMarketInterest" class="form-control-static">${marketInterest}</p>
			    </div>
			    <div class="col-sm-1">
			      <p class="form-control-static">${evaluationScoreGiven.marketInterest}</p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-1 control-label">Impact</label>
			    <div class="col-sm-1">
			      <p id="meanImpact" class="form-control-static">${impact}</p>
			    </div>
			    <div class="col-sm-1">
			      <p class="form-control-static">${evaluationScoreGiven.impact}</p>
			    </div>
			  </div>
			  <div class="form-group">
			   <label class="col-sm-1 control-label">Moyenne</label>
			    <div class="col-sm-1">
			      <p id="mean" class="form-control-static">${mean}</p>
			    </div>
			  </div>
			</form>
			
			
			</c:when>
			<c:otherwise>
				<form class="form-horizontal" data-toggle="validator">
				  <div class="form-group">
				 	<label class="col-sm-3 col-sm-offset-2 control-label" style="text-align:left;">Votre évaluation</label>
				 </div>   
				  <div class="form-group">
				    <label class="col-sm-1 control-label">Faisabilité</label>
				    <div class="col-sm-1">
				      <p id="meanFeasibility" class="form-control-static">${feasibility}</p>
				    </div>
				    <div class="col-sm-4">
				    	<div class="input-group">
					      <input id="feasibility" type="number" class="form-control" placeholder="Voter pour la faisabilité" min="0" max="10">
					    </div>
					    <div class="help-block with-errors"></div>		 
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="col-sm-1 control-label">Intérêt du marché</label>
				    <div class="col-sm-1">
				      <p id="meanMarketInterest" class="form-control-static">${marketInterest}</p>
				    </div>
				    <div class="col-sm-4">
				    	<div class="input-group">
					      <input id="marketInterest" type="number" class="form-control" placeholder="Voter pour l'intérêt" min="0" max="10">
					    </div>
					    <div class="help-block with-errors"></div>		 
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="col-sm-1 control-label">Impact</label>
				    <div class="col-sm-1">
				      <p id="meanImpact" class="form-control-static">${impact}</p>
				    </div>
				    <div class="col-sm-4">
				    	<div class="input-group">
					      <input id="impact" type="number" class="form-control" placeholder="Voter pour l'impact" min="0" max="10">
					    </div>
					    <div class="help-block with-errors"></div>		 
				    </div>
				  </div>
				  <div class="form-group">
				   <label class="col-sm-1 control-label">Moyenne</label>
				    <div class="col-sm-1">
				      <p id="mean" class="form-control-static">${mean}</p>
				    </div>
				    <div class="col-sm-4">
				    	<div class="input-group">
					      <button id="vote" type="button" class="btn btn-success">Voter</button>
					    </div>
				    </div>
				  </div>
				</form>
			</c:otherwise>
		</c:choose>
		
		<%request.setAttribute("comments", request.getAttribute("comments")); %>
		<jsp:include page="../templates/displayComments.jsp"/>
	</div>
</body>
</html>
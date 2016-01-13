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
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script>
	<script src="/projetAPI01/public/js/pledgeIdea.js"></script>
	<link rel="stylesheet" href="/projetAPI01/public/css/ideaDetails.css">
	
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
						<h3>${idea.shortDescription}</h3>
					</div>
					<div class="col-md-2">
						<h2 class="bar-details">${idea.fundingRequested}<span class="glyphicon glyphicon-eur"></span></h2>
						<p class="sub-details">demandés</p>
						<h2 id="totalAmount" class="bar-details">${amountCollected}<span class="glyphicon glyphicon-eur"></span></h2>
						<p class="sub-details">collectés</p>
						<h2 id="nbPledge" class="bar-details">${nbPledge}</span></h2>
						<p class="sub-details">contributeurs</p>
						<h2 class="bar-details">${nbDaysRemains}
							<small style="font-size:45%;">
							<c:if test="${nbDaysRemains < 2}">
								jour restant
				        	</c:if>
				        	<c:if test="${nbDaysRemains >= 2}">
								jours restants
				        	</c:if>	
							</small>			
						</h2>
						<p class="sub-details">avant la fin du financement</p>
	
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
				<div class="row">
					<div class="col-md-6 col-lg-6">
						<c:choose>
							<c:when test="${not empty makeFund}">
								<h3>Vous avez soutenu cette idée à hauteur de <br> <strong>${makeFund.amount} euros</strong>, merci :) !</h3>
							</c:when>
							<c:when test="${nbDaysRemains > 0}">
								<h3 id="labelPledge" for="amountPledged">Vous aussi, soutenez cette idée !</h3>
								<form id="formPledgeIdea" class="form-inline" data-toggle="validator">
								  <div class="form-group">
								    <div class="input-group">
								      <div class="input-group-addon"><span class="glyphicon glyphicon-eur"></span></div>
								      <input type="number" class="form-control" name="amountPledged" id="amountPledged" placeholder="Montant" min="0" max="5000">		    
								    </div>
								 <button id="pledge" type="button" class="btn btn-success">Soutenir !</button>
								  <div class="help-block with-errors"></div>		 
								  </div>
								</form>
							</c:when>
							<c:otherwise>
								<h3>Vous n'avez pas soutenu cette idée :(</h3>
							</c:otherwise>
						</c:choose>
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
</body>
</html>
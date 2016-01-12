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
	<script src="/projetAPI01/public/js/pledgeIdea.js"></script>
	
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
		<h4>Montant collecté : <span id="totalAmount">${amountCollected}</span> euros</h4>
		
		<c:choose>
			<c:when test="${not empty makeFund}">
				<p>Vous avez soutenu cette idée à hauteur de ${makeFund.amount} euros, merci :) !</p>
			</c:when>
			<c:otherwise>
				<label id="labelPledge" for="amountPledged">Vous aussi, soutenez cette idée !</label>
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
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="entry" items="${score}">
		  ${entry.key} : ${entry.value} <br>
		</c:forEach>
		
		<%request.setAttribute("comments", request.getAttribute("comments")); %>
		<jsp:include page="../templates/displayComments.jsp"/>
	</div>
</body>
</html>
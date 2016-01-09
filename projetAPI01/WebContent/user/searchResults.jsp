<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="templates/menu.jsp"/>
	
	<div class="container">
		<div class="page-header">
		   <h1>Résultats de la recherche</h1>
		</div>
		
		<div class="row">
			<c:forEach items="${results}" var="idea">
				<div class="col-lg-4 col-sm-4 col-md-4">
			    <div class="thumbnail">
			    	<img src="http://placehold.it/500x300">
			      <div class="caption">
			      	<div class="page-header">
			        	<h3>${idea.name} - <small>proposée par ${idea.madeBy.prenom} ${idea.madeBy.nom}</small></h3>
					</div>
			        <p>${idea.shortDescription }</p>
			        <h4>Montant demandé : ${idea.fundingRequested} euros</h4>
			        <p><a href="/projetAPI01/user/ideaDetails?id=${idea.id}" class="btn btn-success" role="button">Plus de détails</a></p>
			      </div>
			    </div>
			  </div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
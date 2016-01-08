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
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Launch my idea!</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Accueil <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">Mes idées</a></li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search" method="POST" action="searchIdea">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Rechercher une idée">
	        </div>
	        <button type="submit" class="btn btn-default">Rechercher</button>
	      </form>
	      <form class="navbar-form navbar-right" method="GET" action="/user/addIdea">
	      <div class="form-group">
	      	<button type="submit" class="btn btn-success">Proposer mon idée</button>
	      </div>
	      </form>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="page-header">
	   <h1>Les 3 dernières idées proposées</h1>
	</div>
	<div class="row">
		<c:forEach items="${sessionScope.last3ideas}" var="idea">
			<div class="col-lg-4 col-sm-4 col-md-4">
		    <div class="thumbnail">
		    	<img src="http://placehold.it/500x300">
		      <div class="caption">
		      	<div class="page-header">
		        	<h3>${idea.name} - <small>proposée le ${idea.proposedDate}</small></h3>
				</div>
		        <p>${idea.shortDescription }</p>
		        <h4>Montant demandé : ${idea.fundingRequested} euros</h4>
		        <p><a href="/projetAPI01/user/ideaDetails?id=${idea.id}" class="btn btn-success" role="button">Plus de détails</a></p>
		      </div>
		    </div>
		  </div>
		</c:forEach>
	</div>
</body>
</html>
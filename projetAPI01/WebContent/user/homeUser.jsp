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
	<link rel="stylesheet" href="/projetAPI01/public/css/style.css">
	
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="templates/menu.jsp"/>
		
		<div class="row home-most-popular">
			<div class="container">
				<div class="page-header">
				   <h1>L'idée la plus populaire</h1>
				</div>
		
				<div class="col-lg-10 col-sm-10 col-md-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
				    <div class="thumbnail thumbnail-most-popular" onclick="window.location='/projetAPI01/user/ideaDetails?id=${mostPopular.id}';">
				    	<img src="http://placehold.it/900x300">
					    <div class="caption">
						      	<div class="page-header">
						        	<h2 class="text-center">${mostPopular.name}</h2>
						        	<h4 class="text-center"><small>par ${mostPopular.madeBy.prenom} ${mostPopular.madeBy.nom}</small></h4>
								</div>
								<div>
									<div class="span">
										<h2 class="bar-details">${mostPopular.fundingRequested}<span class="glyphicon glyphicon-eur"></span></h2>
										<p class="sub-details">demandés</p>
									</div>
									<div class="span">
										<h2 class="bar-details">${nbCommentsMostPopular}</h2>
										<p class="sub-details">commentaires</p>
									</div>
									<div class="span">
										<h2 class="bar-details">${mostPopular.applicationField}</h2>
										<p class="sub-details">Catégorie</p>
									</div>
									<div class="span">
										<h2 class="bar-details">${mostPopularContext.currentPhase}</h2>
										<p class="sub-details">Phase actuel</p>
									</div>
									<h3 class="text-center">${mostPopular.shortDescription }</h3>
								</div>
						</div>
				    </div>
			  	</div>
			</div>
		</div>
		
		
		<div class="row">	
			<div class="container">
				<div class="page-header">
				   <h1>Les dernières idées proposées</h1>
				</div>
			
	
				<c:forEach items="${last3ideasProposed}" var="idea">
					<div class="col-lg-4 col-sm-4 col-md-4">
					    <div class="thumbnail">
					    	<img src="http://placehold.it/500x300">
					      <div class="caption">
					      	<div class="page-header">
					        	<h3>${idea.name}</h3>
					        	<h3><small>par ${idea.madeBy.prenom} ${idea.madeBy.nom}</small></h3>
							</div>
					        <p>${idea.shortDescription }</p>
							<h2 class="bar-details">${idea.fundingRequested}<span class="glyphicon glyphicon-eur"></span></h2>
							<p class="sub-details">demandés</p>
							<p><a href="/projetAPI01/user/ideaDetails?id=${idea.id}" class="btn btn-success" role="button">Plus de détails</a></p>
					      </div>
					    </div>
				  </div>
				</c:forEach>
			</div>
		</div>

		<div class="row lastFund">
			<div class="container">
				
				<div class="page-header">
				   <h1>Les dernières idées passées en phase de financement</h1>
				</div>
				
				<c:forEach items="${last3IdeasInFunding}" var="entry">
					<div class="col-lg-4 col-sm-4 col-md-4">
				    <div class="thumbnail">
				    	<img src="http://placehold.it/500x300">
				      <div class="caption">
				      	<div class="page-header">
				        	<h3>${entry.key.context.idea.name}</h3>
				        	<h3><small>proposée par ${entry.key.context.idea.madeBy.prenom} ${entry.key.context.idea.madeBy.nom}</small></h3>
						</div>
				        <p>${entry.key.context.idea.shortDescription }</p>
				        <h2 class="bar-details">${entry.key.context.idea.fundingRequested}<span class="glyphicon glyphicon-eur"></span></h2>
						<p class="sub-details">demandés</p>
						 <div class="progress">
						  <div class="progress-bar progress-bar-success progress-bar-striped active	" role="progressbar" aria-valuenow="${entry.value}"
						  	aria-valuemin="0" aria-valuemax="100" style="width:${entry.value}%;">
						    ${entry.value}%
						  </div>
						</div>
				        <p><a href="/projetAPI01/user/ideaDetails?id=${entry.key.context.idea.id}" class="btn btn-success" role="button">Plus de détails</a></p>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</div>
		</div>
		
		<div class="row">
			<div class="container">
				<div class="page-header">
				   <h1>Découvrir par catégorie</h1>
				</div>
		
				<div class="row" style="margin-left:10%;">
					<div class="col-lg-2 col-md-2">
						<a href="/projetAPI01/search?method=applicationField&applicationField=art" class="thumbnail thumbnail-category">
					      <h4>Art</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=mode" class="thumbnail thumbnail-category">
					      <h4>Mode</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=musique" class="thumbnail thumbnail-category">
					      <h4>Musique</h4>
					    </a>
					</div>
					<div class="col-lg-2 col-md-2">
						<a href="/projetAPI01/search?method=applicationField&applicationField=bd" class="thumbnail thumbnail-category">
					      <h4>BD</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=cinema" class="thumbnail thumbnail-category">
					      <h4>Cinéma et vidéo</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=photographie" class="thumbnail thumbnail-category">
					      <h4>Photographie</h4>
					    </a>
					</div>
					<div class="col-lg-2 col-md-2">
						<a href="/projetAPI01/search?method=applicationField&applicationField=artisanat" class="thumbnail thumbnail-category">
					      <h4>Artisanat</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=gastronomie" class="thumbnail thumbnail-category">
					      <h4>Gastronomie</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=edition" class="thumbnail thumbnail-category">
					      <h4>Edition</h4>
					    </a>
					</div>
					<div class="col-lg-2 col-md-2">
						<a href="/projetAPI01/search?method=applicationField&applicationField=danse" class="thumbnail thumbnail-category">
					      <h4>Danse</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=jeux" class="thumbnail thumbnail-category">
					      <h4>Jeux</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=technologie" class="thumbnail thumbnail-category">
					      <h4>Technologie</h4>
					    </a>
					</div>
					<div class="col-lg-2 col-md-2">
						<a href="/projetAPI01/search?method=applicationField&applicationField=design" class="thumbnail thumbnail-category">
					      <h4>Design</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=journalisme" class="thumbnail thumbnail-category">
					      <h4>Journalisme</h4>
					    </a>
					    <a href="/projetAPI01/search?method=applicationField&applicationField=tourisme" class="thumbnail thumbnail-category">
					      <h4>Tourisme</h4>
					    </a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
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
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script></head>
<body>
	<jsp:include page="../templates/menu.jsp"></jsp:include>
	
	<div class="container">
		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="edit">
		  <input type="hidden" name="id" value="${idea.id}"/>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="name">Nom de l'idée :</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="name" id="name" maxLength="50" data-minlength="3" value="${idea.name}" required>
		      <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="shortDescription">Courte description de l'idée :</label>
		    <div class="col-sm-10">
		    	<textarea class="form-control" id="shortDescription" name="shortDescription" rows="3" cols="10" maxLength="255" data-minlength="5" required>${idea.shortDescription}</textarea>
			    <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  <c:if test="${not empty redaction}">
		  	<div class="form-group">
			    <label class="control-label col-sm-2" for="longDescription">Longue description de l'idée :</label>
			    <div class="col-sm-10">
			    	<textarea class="form-control" id="longDescription" name="longDescription" rows="3" cols="10" maxLength="255" data-minlength="5" required>${redaction.longDescription}</textarea>
				    <div class="help-block with-errors"></div>
			    </div>
			  </div>
		  </c:if>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="applicationField">Catégorie de votre idée :</label>
		    <div class="col-sm-10">
		      <select name="applicationField" id="applicationField" required>
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Art'}">
				      	<option selected="true">Art</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Art</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'BD'}">
				      	<option selected="true">BD</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>BD</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Artisanat'}">
				      	<option selected="true">Artisanat</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Artisanat</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Danse'}">
				      	<option selected="true">Danse</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Danse</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Design'}">
				      	<option selected="true">Design</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Design</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Mode'}">
				      	<option selected="true">Mode</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Mode</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      			      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Cinema'}">
				      	<option selected="true">Cinéma</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Cinéma et vidéo</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Gastronomie'}">
				      	<option selected="true">Gastronomie</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Gastronomie</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Jeux'}">
				      	<option selected="true">Jeux</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Jeux</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Journalisme'}">
				      	<option selected="true">Journalisme</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Journalisme</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Musique'}">
				      	<option selected="true">Musique</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Musique</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Photographie'}">
				      	<option selected="true">Photographie</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Photographie</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Edition'}">
				      	<option selected="true">Edition</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Edition</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Technologie'}">
				      	<option selected="true">Technologie</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Technologie</option>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<c:choose>
		      		<c:when test="${idea.applicationField == 'Theatre'}">
				      	<option selected="true">Theatre</option>      		
		      		</c:when>
		      		<c:otherwise>
		      			<option>Theatre</option>
		      		</c:otherwise>
		      	</c:choose>
		      </select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="fundingRequested">Montant demandé :</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="fundingRequested" name="fundingRequested" min="0" value="${idea.fundingRequested}" required>
			  <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  
		  <div class="form-group">
		  	<div class="col-sm-offset-2 col-sm-1">
		      <button type="reset" class="btn btn-primary">Annuler</button>
		    </div>
		    <div class="col-sm-1">
		      <button type="submit" class="btn btn-success">Sauvegarder</button>
		    </div>
		  </div>
		</form>
	</div>
</body>
</html>
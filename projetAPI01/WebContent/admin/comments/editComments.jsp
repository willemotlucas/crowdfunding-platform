<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
          uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edition d'un commentaire</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script></head>
<body>
	<jsp:include page="../templates/menu.jsp"></jsp:include>
	
	<div class="container">
		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="edit">
		  <input type="hidden" name="id" value="${comments.id}"/>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="name">Description :</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="description" id="description" maxLength="255" data-minlength="3" value="${comments.description}" required>
		      <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="shortDescription">Utilisateur :</label>
		    <div class="col-sm-10">
		      <select name="utilisateur" id="utilisateur" required>
		      	<c:forEach var="user" items="${requestScope.allUsers}">
		      		<c:choose>
					    <c:when test="${user.email == comments.utilisateur.email }">
					    	<option selected="true">${user.email}</option>
					    </c:when>
					    <c:otherwise>
					    	<option>${user.email}</option>
					    </c:otherwise>
					</c:choose>
		      	</c:forEach>
		      </select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="shortDescription">Idée :</label>
		    <div class="col-sm-10">
		      <select name="idea" id="idea" required>
		      	<c:forEach var="idea" items="${requestScope.allIdeas}">
		      		<c:choose>
					    <c:when test="${idea.name == comments.idea.name }">
					    	<option selected="true">${idea.name}</option>
					    </c:when>
					    <c:otherwise>
					    	<option>${idea.name}</option>
					    </c:otherwise>
					</c:choose>
		      	</c:forEach>
		      </select>
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
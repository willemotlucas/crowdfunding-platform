<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Creation d'un nouveau score</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    
    <!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script>
	<script src="/projetAPI01/public/js/thumb.js"></script>
</head>
<body>
    <div class="container">
        <div id="header" class="jumbotron">
            <h1>Creation d'un nouveau score</h1>
        </div>
        <c:if test="${not empty error}">
	        <div class="alert alert-warning">
	            ${error}
	        </div> 
        </c:if>

		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="/projetAPI01/admin/addScore">
        	<input type="hidden" name="id" value="<jsp:getProperty name="userBean" property="id" />">
			<div class="form-group">
		        <label for="utilisateur">Utilisateur</label>
                <div class="input-group">
                	<span class="input-group-addon">@</span>
					<input type="text" class="form-control" name="utilisateur" id="utilisateur" maxLength="40" data-minlength="2" required  value="<jsp:getProperty name="userBean" property="email" />" placeholder="Entrez le login de l'utilisateur">
				</div>
				<div class="help-block with-errors"></div>
			</div>
            <div class="form-group">
                <label for="idea">Idée</label>
                <select name="idea" id="idea" required class="form-control">
					<option selected disabled>Sélectionnez l'idee</option>
					<c:forEach var="Idea" items="${sessionScope.allIdeas}">
	                    <option value="${Idea.id}">${Idea.name}</option>
	                </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="score">Score</label>
                <select name="score" id="score" required class="form-control">
					<option selected disabled>Sélectionnez le score</option>
	                    <option value="1">1</option>
	                    <option value="-1">-1</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Sauvegarder</button>
        </form>    
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inscription � Launch my idea!</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script>
</head>
<body>
    <div class="container">
        <div id="header" class="jumbotron">
            <h1>Inscription</h1>
        </div>
        <c:if test="${not empty error}">
	        <div class="alert alert-warning">
	            ${error}
	        </div> 
        </c:if>

		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="inscription">
			<div class="form-group">
		        <label for="nom">Nom</label>
				<input type="text" class="form-control" name="nom" id="nom" maxLength="40" data-minlength="2" required  placeholder="Entrez le nom">
				<div class="help-block with-errors"></div>
			</div>
            <div class="form-group">
                <label for="name">Pr�nom</label>
                <input type="text" name="prenom" class="form-control" id="prenom" maxLength="40" data-minlength="2" required placeholder="Entrez le pr�nom">
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <div class="input-group">
                	<span class="input-group-addon">@</span>
	                <input type="text" name="email" class="form-control" id="email" placeholder="Entrez l'email">
                </div>
	            <div class="help-block with-errors"></div>   
            </div>
            <div class="form-group">
                <label for="password">Mot De Passe</label>
                <input type="password" name="password" class="form-control" id="password" maxLength="40" data-minlength="6" required placeholder="Entrez le mot de passe (6 caract�res min)">
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label for="confPass">Confirmation</label>
                <input type="password" name="confPass" class="form-control" id="confPass" maxLength="40" data-minlength="6" required placeholder="Confirmez le mot de passe">
                <div class="help-block with-errors"></div>
            </div>
			<div class="form-group">
				<label for="telephone">T�l�phone</label>
				<input type="text" name="telephone" class="form-control" id="telephone" maxLength="15" data-minlength="5" placeholder="Entrez le t�l�phone">
			</div>
            <div class="form-group">
                <label for="numRue">Num�ro de rue</label>
                <input type="number" name="numRue" class="form-control" id="numRue"  min="0" required placeholder="Entrez le num�ro de le rue">
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label for="rue">Rue</label>
                <input type="text" name="rue" class="form-control" id="rue" placeholder="Entrez la rue">
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label for="codePostale">Code Postal</label>
                <input type="text" name="codePostale" class="form-control" id="codePostale" placeholder="Entrez le code postal">
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label for="ville">Ville</label>
                <input type="text" name="ville" class="form-control" id="ville" placeholder="Entrez la ville">
                <div class="help-block with-errors"></div>
            </div>
            <button type="submit" class="btn btn-default">Sauvegarder</button>
        </form>    
    </div>
</body>
</html>

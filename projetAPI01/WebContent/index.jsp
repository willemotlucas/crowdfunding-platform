<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Connection à Lunch-My-Idea</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div id="header" class="jumbotron">
			<h1>Bienvenue à Lunch-My-Idea</h1>
		</div>
		<form method="POST" action="connexion">
			<div class="form-group">
				<label for="email">Login</label>
				<input type="text" name="email" class="form-control" id="login" placeholder="Entrez votre email">
			</div>
			<div class="form-group">
				<label for="password">Mot de Passe</label>
				<input type="password" name="password" class="form-control" id="password" placeholder="Entrez votre mot de passe">
			</div>
			<button type="submit" class="btn btn-default">Se connecter</button>
		</form>	
		<p>Pas encore de compte utilisateur ? <a href="inscription.jsp">Inscrivez-vous !</a></p>
		</div>
</body>
</html>
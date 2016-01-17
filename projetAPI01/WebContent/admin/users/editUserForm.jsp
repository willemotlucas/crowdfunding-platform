<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edition de l'utilisateur</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="adressBean" class="com.utc.projetAPI01.beans.Adress" scope="session" />
    
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
            <h1>Edition de l'utilisateur ayant l'ID : <jsp:getProperty name="userBean" property="id" /></h1>
        </div>
        <c:if test="${not empty error}">
	        <div class="alert alert-warning">
	            ${error}
	        </div> 
        </c:if>
		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="editUser">
        	<input type="hidden" name="id" value="<jsp:getProperty name="userBean" property="id" />">
            <div>
                <label for="name">Nom</label>                
                <input type="text" name="nom" class="form-control" id="nom" value="<jsp:getProperty name="userBean" property="nom" />" placeholder="Entrez le nom">
            </div>
            <div class="form-group">
                <label for="surname">Prénom</label>
                <input type="text" name="prenom" class="form-control" id="prenom" value="<jsp:getProperty name="userBean" property="prenom" />" placeholder="Entrez le prénom">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <div class="input-group">
                	<span class="input-group-addon">@</span>
	                <input type="text" name="email" class="form-control" id="email" value="<jsp:getProperty name="userBean" property="email" />" placeholder="Entrez l'email">
	            </div>
	           	<div class="help-block with-errors"></div>                   
            </div>
            <div class="form-group">
                <label for="password">Mot De Passe</label>
                <input type="password" name="password" class="form-control" id="password" value="<jsp:getProperty name="userBean" property="password" />" placeholder="Entrez le mot de passe (6 caractères min)">
            </div>
            <div class="form-group">
                <label for="confPass">Confirmation</label>
                <input type="password" name="confPass" class="form-control" id="confPass" value="<jsp:getProperty name="userBean" property="password" />" placeholder="Confirmez le mot de passe">
            </div>
			<div class="form-group">
				<label for="telephone">Téléphone</label>
				<input type="text" name="telephone" class="form-control" id="telephone" value="<jsp:getProperty name="userBean" property="telephone" />" placeholder="Entrez le téléphone">
			</div>
            <div class="form-group">	
                <label for="numRue">Numéro de rue</label>
                <input type="number" name="numRue" class="form-control" id="numRue" value="<jsp:getProperty name="adressBean" property="num" />" placeholder="Entrez le numéro de rue">
            </div>
            <div class="form-group">
                <label for="rue">Rue</label>
                <input type="text" name="rue" class="form-control" id="rue" value="<jsp:getProperty name="adressBean" property="rue" />" placeholder="Entrez la rue">
            </div>
            <div class="form-group">
                <label for="codePostale">Code Postal</label>
                <input type="text" name="codePostale" class="form-control" id="codePostale" value="<jsp:getProperty name="adressBean" property="codePostale" />" placeholder="Entrez le code postal">
            </div>
            <div class="form-group">
                <label for="ville">Ville</label>
                <input type="text" name="ville" class="form-control" id="ville" value="<jsp:getProperty name="adressBean" property="ville" />" placeholder="Entrez la ville">
            </div>
            <div class="form-group">
                <label for="statut">Statut</label>
                <select name="statut" class="form-control">
					<option selected disabled>Sélectionnez le statut</option>
                    <option value="active">Actif</option>
                    <option value="inactive">Inactif</option>
                </select>
            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <select name="type" class="form-control">
					<option selected disabled>Sélectionnez le type</option>
                    <option value="normalUser">Normal</option>
                    <option value="admin">Admin</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Valider les modifications</button>
        </form>    
    </div>
</body>
</html>
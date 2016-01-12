<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation de modification de l'utilisateur</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	<link href="/projetAPI01/public/bootstrap/css/sb-admin.css" rel="stylesheet">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="adressBean" class="com.utc.projetAPI01.beans.Adress" scope="session" />
</head>
<body>
	<jsp:include page="templates/menu.jsp"/>
	<div class="container">
		<div class="page-header">
		   <h1>Modification d'un utilisateur</h1>
		</div>
	</div>
	<div class="row">
		<h3> Vous avez bien modifié l'utilisateur <jsp:getProperty name="userBean" property="email" /> de la maniere suivante :</h3>
		Nom : <span class="marge"></span> <jsp:getProperty name="userBean" property="nom" /></br>
		Prenom : <span class="marge"></span> <jsp:getProperty name="userBean" property="prenom" /></br>
		Email : <span class="marge"></span> <jsp:getProperty name="userBean" property="email" /></br>
		Mdp : <span class="marge"></span> <jsp:getProperty name="userBean" property="password" /></br>
		Telephone : <span class="marge"></span> <jsp:getProperty name="userBean" property="telephone" /></br>
		Adresse : <span class="marge"></span> <jsp:getProperty name="adressBean" property="num" /> &nbsp; <jsp:getProperty name="adressBean" property="rue" /> &nbsp; <jsp:getProperty name="adressBean" property="codePostale" /> &nbsp; <jsp:getProperty name="adressBean" property="ville" /></br>
		Statut : <span class="marge"></span> <jsp:getProperty name="userBean" property="accountStatus" /></br>
		Type : <span class="marge"></span> <jsp:getProperty name="userBean" property="accountType" /></br>
		Date de création : <span class="marge"></span> <jsp:getProperty name="userBean" property="dateCreation" /></br>
	</div>
</body>
</html>
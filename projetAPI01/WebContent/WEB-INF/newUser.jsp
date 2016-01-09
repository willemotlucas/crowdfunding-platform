<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation de creation de l'utilisateur</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="adressBean" class="com.utc.projetAPI01.beans.Adress" scope="session" />
</head>
<body>
	<div class="container">
		<div class="page-header">
		   <h1>Creation d'un utilisateur</h1>
		</div>
	</div>
	<div class="row">
		<h3> Vous avez bien créé l'utilisateur suivant :</h3>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation de creation de l'utilisateur</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
</head>
<body>
	<h1> Vous avez bien créé l'utilisateur suivant :</h1>
	Nom : <jsp:getProperty name="userBean" property="nom" />
	Prenom : <jsp:getProperty name="userBean" property="prenom" />
	Email : <jsp:getProperty name="userBean" property="email" />
	Mdp : <jsp:getProperty name="userBean" property="password" />
	Telephone : <jsp:getProperty name="userBean" property="telephone" />
	Adresse : <jsp:getProperty name="userBean" property="adress.getNum()" /> <jsp:getProperty name="userBean" property="adress.getRue()" /> <jsp:getProperty name="userBean" property="adress.getCodePostale()" /> <jsp:getProperty name="userBean" property="adress.getVille()" />
	Statut : <jsp:getProperty name="userBean" property="accountStatus" />
	Type : <jsp:getProperty name="userBean" property="accountType" />
	Date de création : <jsp:getProperty name="userBean" property="dateCreation" />
</body>
</html>
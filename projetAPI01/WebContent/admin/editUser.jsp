<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation de modification de l'utilisateur</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="adressBean" class="com.utc.projetAPI01.beans.Adress" scope="session" />
</head>
<body>
	<h1> Vous avez bien modifié l'utilisateur de la maniere suivante :</h1>
	Nom : <jsp:getProperty name="userBean" property="nom" />
	Prenom : <jsp:getProperty name="userBean" property="prenom" />
	Email : <jsp:getProperty name="userBean" property="email" />
	Mdp : <jsp:getProperty name="userBean" property="password" />
	Telephone : <jsp:getProperty name="userBean" property="telephone" />
	Adresse : <jsp:getProperty name="adressBean" property="num" /> <jsp:getProperty name="adressBean" property="rue" /> <jsp:getProperty name="adressBean" property="codePostale" /> <jsp:getProperty name="adressBean" property="ville" />
	Statut : <jsp:getProperty name="userBean" property="accountStatus" />
	Type : <jsp:getProperty name="userBean" property="accountType" />
</body>
</html>
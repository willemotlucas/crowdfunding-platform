<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation de suppression du score</title>
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="scoreBean" class="com.utc.projetAPI01.beans.Thumb" scope="session" />
    <jsp:useBean id="ideaBean" class="com.utc.projetAPI01.beans.Idea" scope="session" />
    
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/admin/templates/menu.jsp"/>
	<div class="container">
		<div class="row">
		   <h1 class="page-header">Suppression du score</h1>
		</div>
		<div class="page-header">
			<h3> Vous avez bien supprimé le score ayant l'ID <jsp:getProperty name="scoreBean" property="id" /> avec les caractéristiques suivantes :</h3>
			Utilisateur : <span class="marge"></span> <jsp:getProperty name="userBean" property="prenom" /> <jsp:getProperty name="userBean" property="nom" /></br>
			Idee : <span class="marge"></span> <jsp:getProperty name="ideaBean" property="name" /></br>
			Score : <span class="marge"></span> <jsp:getProperty name="scoreBean" property="score" /></br>
		</div>
	</div>
</body>
</html>
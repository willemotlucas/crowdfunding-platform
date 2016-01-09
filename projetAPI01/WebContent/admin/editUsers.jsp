<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>    
    <div class="container">
        <div id="header" class="jumbotron">
            <h1>Edition de l'utilisateur ayant l'email : <jsp:getProperty name="userBean" property="email" /></h1>
        </div>
        <form method="POST" action="editUser">
            <div>
                <label for="name">Nom</label>                
                <input type="text" name="nom" class="form-control" id="nom" required="false" placeholder="<jsp:getProperty name="userBean" property="nom" />">
            </div>
            <div class="form-group">
                <label for="surname">Prenom</label>
                <input type="text" name="prenom" class="form-control" id="prenom" required="false" placeholder="<jsp:getProperty name="userBean" property="prenom" />">
            </div>
            <div class="form-group">
                <label for="password">Mot De Passe</label>
                <input type="password" name="password" class="form-control" id="password" required="false" placeholder="<jsp:getProperty name="userBean" property="password" />">
            </div>
            <div class="form-group">
                <label for="confPass">Confirmation</label>
                <input type="password" name="confPass" class="form-control" id="confPass" placeholder="<jsp:getProperty name="userBean" property="password" />">
            </div>
            <div class="form-group">	
                <label for="numRue">Numero de rue</label>
                <input type="text" name="numRue" class="form-control" id="numRue" required="false"placeholder="<jsp:getProperty name="adressBean" property="num" />">
            </div>
            <div class="form-group">
                <label for="rue">Rue</label>
                <input type="text" name="rue" class="form-control" id="rue" required="false" placeholder="<jsp:getProperty name="adressBean" property="rue" />">
            </div>
            <div class="form-group">
                <label for="codePostale">Code Postale</label>
                <input type="text" name="codePostale" class="form-control" id="codePostale" required="false" placeholder="<jsp:getProperty name="adressBean" property="codePostale" />">
            </div>
            <div class="form-group">
                <label for="ville">Ville</label>
                <input type="text" name="ville" class="form-control" id="ville" required="false" placeholder="<jsp:getProperty name="adressBean" property="ville" />">
            </div>
            <div class="form-group">
                <label for="statut" required="false">Statut</label>
                <label class="radio-inline"><input type="radio" name="optradio">Actif</label>
                <label class="radio-inline"><input type="radio" name="optradio">Inactif</label>
            </div>
            <div class="form-group">
                <label for="type" required="false">Type</label>
                <label class="radio-inline"><input type="radio" name="optradio">Admin</label>
                <label class="radio-inline"><input type="radio" name="optradio">Normal</label>
            </div>
            <button type="submit" class="btn btn-default">Valider les modifications</button>
        </form>    
    </div>
</body>
</html>
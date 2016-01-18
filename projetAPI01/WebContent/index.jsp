<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="public/css/index.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
	
    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body style="background-image: url(public/img/bg2.jpg); width: 100%;">		
		<% 		com.utc.projetAPI01.beans.Utilisateur currentUser = (com.utc.projetAPI01.beans.Utilisateur) request.getSession().getAttribute("userSession");
				if(currentUser != null)
				{
					if(currentUser.getAccountType().equals("admin"))
					{
						response.sendRedirect(request.getContextPath() + "/admin/homepage");
					}
					else if(currentUser.getAccountType().equals("normalUser"))
					{
						response.sendRedirect(request.getContextPath() + "/user/homepage");
					}
				}
		%>
		<div class="row">
			<div class="container">
				<h1>Launch my idea</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="container">
				<div class="col-md-4 col-md-offset-4">
	                        <form role="form" method="POST" action="login">
	                            <fieldset>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Email" name="email" type="email" autofocus>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Mot de passe" name="password" type="password" value="">
	                                </div>
	                                <div class="col-md-offset-4">
										<button type="submit" class="btn btn-success">Se connecter</button>	                                
	                                </div>
	                            </fieldset>
	                        </form>
	                        <br>
							<p>Pas encore de compte utilisateur ? <a href="inscription.jsp">Inscrivez-vous !</a></p>
	            </div>
			</div>
		</div>
</body>
</html>
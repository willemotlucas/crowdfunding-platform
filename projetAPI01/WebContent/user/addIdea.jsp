<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Homepage for normal user</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script></head>
<body>
	<jsp:include page="templates/menu.jsp"></jsp:include>
	
	<div class="container">
		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="idea/add">
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="name">Nom de l'id�e :</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="name" id="name" maxLength="50" data-minlength="3" required>
		      <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="shortDescription">Courte description de l'id�e :</label>
		    <div class="col-sm-10">
		    	<textarea class="form-control" id="shortDescription" name="shortDescription" rows="3" cols="10" maxLength="255" data-minlength="5" required></textarea>
			    <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="applicationField">Cat�gorie de votre id�e :</label>
		    <div class="col-sm-10">
		      <select name="applicationField" id="applicationField" required>
		      	<option>Art</option>
		      	<option>BD</option>
		     	<option>Artisanat</option>
		      	<option>Danse</option>
		      	<option>Design</option>
		      	<option>Mode</option>
		      	<option>Cin�ma & Vid�o</option>
		      	<option>Gastronomie</option>
		      	<option>Jeux</option>
		      	<option>Journalisme</option>
		      	<option>Musique</option>
		      	<option>Photographie</option>
		      	<option>Edition</option>
		      	<option>Technologie</option>
		      	<option>Th��tre</option>
		      </select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="fundingRequested">Montant demand� :</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="fundingRequested" name="fundingRequested" min="0" required>
			  <div class="help-block with-errors"></div>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-success">Proposer mon id�e !</button>
		    </div>
		  </div>
		</form>
	</div>
</body>
</html>
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
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Brand</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">My ideas</a></li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search" method="POST" action="searchIdea">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search an idea">
	        </div>
	        <button type="submit" class="btn btn-default">Search</button>
	      </form>
	      <button type="button" class="btn btn-success"><a href="/user/addIdea.jsp">Create a new idea</a></button>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	 <form class="form-horizontal" role="form">
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="email">Name of your idea :</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="name" placeholder="Enter name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="pwd">Short description of your idea :</label>
	    <div class="col-sm-10">
	    	<textarea class="form-control" id="shortDescription" name="shortDescription" rows="3" cols="10" placeholder="Enter a short description"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="email">Application field of your idea :</label>
	    <div class="col-sm-10">
	      <select>
	      	<option>Art</option>
	      	<option>Comics</option>
	     	<option>Crafts</option>
	      	<option>Dance</option>
	      	<option>Design</option>
	      	<option>Fashion</option>
	      	<option>Film & Video</option>
	      	<option>Food</option>
	      	<option>Games</option>
	      	<option>Journalism</option>
	      	<option>Music</option>
	      	<option>Photography</option>
	      	<option>Publishing</option>
	      	<option>Technology</option>
	      	<option>Theater</option>
	      </select>
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="email">Fund requested :</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" id="name" placeholder="Enter a funding request">
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-success">Create my idea !</button>
	    </div>
	  </div>
	</form>
</body>
</html>
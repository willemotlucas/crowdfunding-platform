<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
          uri="http://java.sun.com/jsp/jstl/core" %>
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
	<jsp:include page="../templates/menu.jsp"></jsp:include>
	
	<div class="container">
		<div class="page-header">
	 		<h2>Modification de la phase de l'idée ${requestScope.idea.name}</h2>
	 	</div>
		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="edit">
		  <input type="hidden" name="id" value="${idea.id}"/>

		   <div class="form-group">
		    <label class="control-label col-sm-2" for="phase">Phase de l'idée :</label>
		    <div class="col-sm-10">
		    <c:choose>
				<c:when test="${requestScope.context.currentPhase == 'fund'}">
					<select name="phase" id="phase" required>
				      	<option>Discussion</option>
				      	<option>Redaction</option>
				     	<option>Evaluation</option>
				      	<option selected="true">Fund</option>
				     </select>
				</c:when>
				<c:when test="${requestScope.context.currentPhase == 'evaluation'}">
					<select name="phase" id="phase" required>
				      	<option>Discussion</option>
				      	<option>Redaction</option>
				     	<option selected="true">Evaluation</option>
				      	<option>Fund</option>
				     </select>
				</c:when>
				<c:when test="${requestScope.context.currentPhase == 'redaction'}">
					<select name="phase" id="phase" required>
				      	<option>Discussion</option>
				      	<option selected="true">Redaction</option>
				     	<option>Evaluation</option>
				      	<option>Fund</option>
				     </select>
				</c:when>
				<c:when test="${requestScope.context.currentPhase == 'discussion'}">
					<select name="phase" id="phase" required>
				      	<option selected="true">Discussion</option>
				      	<option>Redaction</option>
				     	<option>Evaluation</option>
				      	<option>Fund</option>
				     </select>
				</c:when>		
			</c:choose>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-1">
		      <button type="submit" class="btn btn-success">Sauvegarder</button>
		    </div>
		  </div>

		</form>
	</div>
</body>
</html>
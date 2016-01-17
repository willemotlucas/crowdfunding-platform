<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edition de l'evaluation</title>
    <jsp:useBean id="evalScoreBean" class="com.utc.projetAPI01.beans.EvaluationScore" scope="session" />
    <jsp:useBean id="userBean" class="com.utc.projetAPI01.beans.Utilisateur" scope="session" />
    <jsp:useBean id="ideaBean" class="com.utc.projetAPI01.beans.Idea" scope="session" />
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    
    <!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="/projetAPI01/public/js/validator-min.js"></script>
</head>
<body>    
	<jsp:include page="../templates/menu.jsp"></jsp:include>
    <div class="container">
        <div class="page-header">
		   <h1>Edition de l'evaluation ayant l'ID : <jsp:getProperty name="evalScoreBean" property="id" /></h1>
		</div>
        <c:if test="${not empty error}">
	        <div class="alert alert-warning">
	            ${error}
	        </div> 
        </c:if>
        
		<form data-toggle="validator" class="form-horizontal" role="form" method="POST" action="/projetAPI01/admin/editEval">
        	<input type="hidden" name="id" value="<jsp:getProperty name="evalScoreBean" property="id" />">
        	<input type="hidden" name="idIdea" value="<jsp:getProperty name="ideaBean" property="id" />">
			<div class="form-group">
		        <label for="utilisateur">Utilisateur</label>
                <div class="input-group">
                	<span class="input-group-addon">@</span>
					<input type="text" class="form-control" name="utilisateur" id="utilisateur" maxLength="40" data-minlength="2" required  value="<jsp:getProperty name="userBean" property="email" />" placeholder="Entrez le login de l'utilisateur">
				</div>
				<div class="help-block with-errors"></div>
			</div>
            <div class="form-group">
                <label for="idea">Idee</label>
                <input type="text" class="form-control" name="idea" id="idea" maxLength="40" data-minlength="2" required  value="<jsp:getProperty name="ideaBean" property="name" />" placeholder="Entrez l'id�e">
				<!-- select name="idea" id="idea" required class="form-control">
					<option selected disabled>Selectionnez l'idee</option>
					<c:forEach var="Idea" items="${sessionScope.allIdeas}">
	                    <option value="${Idea.id}">${Idea.name}</option>
	                </c:forEach>
                </select -->
            </div>
            <div class="form-group">
                <label for="feasibility">Faisabilit�</label>
                <input type="number" name="feasibility" class="form-control" id="feasibility" required value="<jsp:getProperty name="evalScoreBean" property="feasibility" />" placeholder="Entrez le score pour la faisabilit�">
                <div class="help-block with-errors"></div>   
            </div>
            <div class="form-group">
                <label for="marketInterest">Interet du marche</label>
                <input type="number" name="marketInterest" class="form-control" id="marketInterest" required value="<jsp:getProperty name="evalScoreBean" property="marketInterest" />" placeholder="Entrez le score pour l'interet du marche">
                <div class="help-block with-errors"></div>   
            </div>
            <div class="form-group">
                <label for="impact">Impact</label>
                <input type="number" name="impact" class="form-control" id="impact" required value="<jsp:getProperty name="evalScoreBean" property="impact" />" placeholder="Entrez le score pour l'impact">
                <div class="help-block with-errors"></div>   
            </div>
            <button type="submit" class="btn btn-default">Sauvegarder</button>
        </form>    
    </div>
</body>
</html>
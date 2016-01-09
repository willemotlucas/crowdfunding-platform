<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
</head>
<body>

<a href="/projetAPI01/admin/addUsers.jsp" class="btn btn-add"><i class="glyphicon glyphicon-plus"></i>Add a user</a>
               
<script>$(document).ready(function() {
    $('#example').DataTable();
} );</script>

    <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Email</th>
                <th>Password</th>
                <th>Telephone</th>
                <th>Start date</th>
                <th>Account status</th>
                <th>Account type</th>
                <th>Adresse</th>
                <th><i>Options</i></th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Email</th>
                <th>Password</th>
                <th>Telephone</th>
                <th>Start date</th>
                <th>Account status</th>
                <th>Account type</th>
                <th>Adresse</th>   
                <th><i>Options</i></th>         
            </tr>
        </tfoot>
        <tbody>
            <c:forEach var="user" items="${sessionScope.allUsers}" >
            
                <tr>
                    <td>${user.id}</td>
                    <td>${user.nom}</td>
                    <td>${user.prenom}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.telephone}</td>
                    <td>${user.dateCreation}</td>
                    <td>${user.accountStatus}</td>
                    <td>${user.accountType}</td>
                    <td>${user.adress.num} ${user.adress.rue} ${user.adress.codePostale} ${user.adress.ville}</td>
                    <td>
                        <a href="/projetAPI01/admin/editUsers?id=${user.id}" class="btn btn-info btn-lg"><i class="glyphicon glyphicon-pencil"></i>Edit</a>
                        <a href="/projetAPI01/admin/removeUsers?id=${user.id}" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>    
</body>
</html>
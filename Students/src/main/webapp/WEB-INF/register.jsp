<%@page import="com.app.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body class="text-center">
<h1> Name   : ${student.name}</h1>
<h1> Marks  : ${student.marks}</h1>
<h1> School : ${student.school}</h1>
<h1> Email : ${student.email}</h1>
<h5 class="text-danger"> registered succesfully</h5>
<a class="btn btn-primary" href="home">Go back</a>
</body>
</html>
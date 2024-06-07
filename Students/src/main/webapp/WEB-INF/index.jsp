<%@page import="com.app.entity.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>
    <div class="container text-center">
    <h1 class="display-3">Student Management System</h1>
    <hr>
        <form class="section mx-5" action="login" method="get">

            <div class="row">

                <div class="col-6 display-6">
                  
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter roll" name="roll" style="display: none;">
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Name :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter name" name="name">
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Marks :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter marks" name="marks">
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Email :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter email" name="email">
                </div>
            </div>
            <div class="row">
                <div class="col-6 display-6">
                    School :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter school" name="school">
                    <button type="submit" class="btn btn-success m-3">Submit</button>
                </div>
            </div>
            
        </form>
         <hr>
        <table border="1" class="w-100 table">
        
            <thead>
                <td>Roll num </td>
                <td>Name </td>
                <td>Marks</td>
                <td>School </td>
                <td>Email </td>
                <td> </td>
            </thead>
            <tbody>
            <%
        StudentDao sdao=new StudentDao();
        ArrayList<Student> arr=sdao.getAll();
        for(Student std:arr){
        %>
               <tr>
                <td>
                    <%=std.getRoll() %>
                </td>
                <td>
                    <%=std.getName() %>
                    
                </td>
                <td>
                    <%=std.getMarks() %>
                </td>
                <td>
                    <%=std.getSchool() %>
                </td>
                <td>
                    <%=std.getEmail()  %>
                </td>
                <td>
                    <a class="btn btn-danger" href="delete/<%=std.getRoll()%>">Delete</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="edit/<%=std.getRoll()%>">Edit</a>
                </td>
               </tr>
               <%} %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>

</html>
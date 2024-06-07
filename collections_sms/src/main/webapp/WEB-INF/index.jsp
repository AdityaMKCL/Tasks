<%@page import="com.app.entity.Student"%>
<%@page import="java.util.ArrayList"%>
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
                    <input class="form-control" type="text" placeholder="Enter roll" name="rollNum" style="display: none;"/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    First Name :
                </div>
                <div class="col-6">
                    <input class="form-control" placeholder="Enter First name" name="firstName"/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Last Name :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter Last name" name="lastName"/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Mobile :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter Mobile no." name="mobileNo"/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Email :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter email" name="email"/>
                </div>
            </div>
            <div class="row">
                <div class="col-6 display-6">
                    Marks :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter marks" name="marks"/>
                    <button type="submit" value="submit" class="btn btn-success m-3">Submit</button>
                </div>
            </div>
            
        </form>
         <hr>
        <table border="1" class="w-100 table">
        
            <thead>
                <td>Roll num </td>
                <td>First Name </td>
                <td>Last Name </td>
                <td>Marks</td>
                <td>Mobile no </td>
                <td>Email </td>
                <td> </td>
                <td> </td>
            </thead>
            <tbody>
            <%
        ArrayList<Student> arr=(ArrayList<Student>)request.getAttribute("array");
        for(Student std:arr){
        %>
               <tr>
                <td>
                    <%=std.getRollNum() %>
                </td>
                <td>
                    <%=std.getfirstName() %>
                    
                </td>
                <td>
                    <%=std.getLastName() %>
                    
                </td>
                <td>
                    <%=std.getMarks() %>
                </td>
                <td>
                    <%=std.getMobileNo() %>
                </td>
                <td>
                    <%=std.getEmail()  %>
                </td>
                <td>
                    <a class="btn btn-danger" href="delete/<%=std.getRollNum()%>">Delete</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="edit/<%=std.getRollNum() %>">Edit</a>
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
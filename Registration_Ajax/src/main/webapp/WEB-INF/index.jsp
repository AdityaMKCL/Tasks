<%@page import="com.app.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.dao.UserDao"%>
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

<body onload="startup()">
    <div class="container text-center">
    <h1 class="display-4">User Management System</h1>
    <hr>
        <div class="section mx-5">

            <div class="row">

                <div class="col-6 display-6">
                  
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter roll" name="uid" style="display: none;">
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    First Name :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter First name" name="fname" id="fname">
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Last Name :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter Last name" name="lname" id="lname">
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    State :
                </div>
                <div class="col-6">
                    <select class="form-control" name="state" onchange="loadDoc(this)" id="state">
            <optgroup label="Select City" placeholder="Select City" id="addoptions" >

            </optgroup>
        </select>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    City :
                </div>
                <div class="col-6">
                    <select class="form-control" name="city" id="city" >
            <optgroup label="Select City" placeholder="Select City" id="putoptions" >

            </optgroup>
        </select>
                 <button  class="btn btn-success m-4" onclick="submitit()">Submit</button>
                </div>
            </div>
            
            
        </div>
         <hr>
        <table border="1" class="w-100 table">
        
            <thead>
                <td>First name </td>
                <td>Last name</td>
                <td>State </td>
                <td>City </td>
                <td> </td>
            </thead>
            <tbody>
            <%
            
            
        UserDao sdao=new UserDao(); 
        ArrayList<User> arr=sdao.getAll();
        for(User std:arr){
        %>
               <tr>
                <td>
                    <%=std.getFname()%>
                </td>
                <td>
                    <%=std.getLname() %>
                    
                </td>
                <td>
                    <%=std.getState() %>
                </td>
                <td>
                    <%=std.getCity() %>
                </td>
                <td>
                    <a class="btn btn-danger" href="delete/<%=std.getUid()%>">Delete</a>
                </td>
               </tr>
               <%} %>
            </tbody>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <script>

        function startup() {
            console.log("clicked");
            var name = 'India'
            $.ajax({
                method: 'GET',
                url: 'http://localhost:8081/Registration_Ajax/getstates',
                contentType: 'application/json',
                success: function (result) {
                    console.log(result);
                    let string = `<option value="" disabled selected hidden>Select your option</option>`;
                    document.getElementById("addoptions").innerHTML = string;
                    result = result.substring(1, result.length - 1);
                    const arr = result.split(",");
                    console.log("Clicked");
                    console.log(arr);
                    for (let i = 0; i < arr.length; i++) {
                        var element = arr[i];

                        string += "<option value=" + element + ">" + element + "</option>"

                    }

                    console.log(string);
                    document.getElementById("addoptions").innerHTML = string;
                },
                error: function ajaxError(jqXHR) {
                    console.error('Error: ', jqXHR.responseText);
                }
            });

        }
        function loadDoc(hello) {
            console.log("helloload");
            console.log(hello.value);


            $.ajax({
                method: 'GET',
                url: 'http://localhost:8081/Registration_Ajax/getcities/' + hello.value,
                contentType: 'application/json',
                success: function (result) {
                    console.log(result);
                    let string = `<option value="" disabled selected hidden>Select your option</option>`;
                    document.getElementById("putoptions").innerHTML = string;
                    result = result.substring(1, result.length - 1);
                    const arr = result.split(",");
                    console.log("Clicked");
                    console.log(arr);
                    for (let i = 0; i < arr.length; i++) {
                        var element = arr[i];

                        string += "<option value=" + element + ">" + element + "</option>"

                    }

                    console.log(string);
                    document.getElementById("putoptions").innerHTML = string;
                },
                error: function ajaxError(jqXHR) {
                    console.error('Error: ', jqXHR.responseText);
                }

            });
        }
        function submitit() {
            console.log(document.getElementById("fname").value);
            var stud = {
                uid: 0,
                fname: document.getElementById("fname").value,
                lname: document.getElementById("lname").value,
                state: document.getElementById("state").value,
                city: document.getElementById("city").value
            }

            $.ajax({
                method: 'GET',
                url: 'http://localhost:8081/Registration_Ajax/login',
                contentType: 'application/json',
                data : stud,
                success: function (result) {
                    console.log(result);
                    window.location.href = "http://localhost:8081/Registration_Ajax/";

                	                },
                error: function ajaxError(jqXHR) {
                    console.error('Error: ', jqXHR.responseText);
                }

            });


            
            console.log(stud);
        }
    </script>
</body>

</html>
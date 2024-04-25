<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>

    <body>
        <div class="container mt-3">
            <div class="row p-4 border shadow-sm">

                <h1 class="display-6">Exam Event Details</h1>
                <div class="alert alert-success my-2" role="alert">
                    <div class="row my-2">
                        <div class="col-md-3 col-12 ">
                            Licence End Date
                        </div>
                        <div class="col-md-9 col-12 ">
                            20/06/2024 00:00
                        </div>
                    </div>
                </div>

                <form action="examevent/save">
                    <div class="row my-2 text-start">
                        <div class="col-md-4 col-12">Exam Event Name*</div>
                        <div class="col-md-8 col-12">
                            <input type="text" class="form-control" name="name">
                        </div>
                    </div>

                    <div class="row my-2 text-start">
                        <div class="col-md-4 col-12 text-success">Exam Event Code*</div>
                        <div class="col-md-8 col-12">
                            <input type="text" class="form-control" name="examEventCode">
                        </div>
                    </div>

                    <div class="row my-2 text-start">
                        <div class="col-md-4 col-12 text-success">Default Language*</div>
                        <div class="col-md-8 col-12">
                            <select class="form-select" name="defaultLanguageID" id="city">
                                <optgroup id="addoptions">

                                </optgroup>
                            </select>
                        </div>
                    </div>

                    <div class="row my-2 text-start">
                        <div class="col-md-4 col-12 ">Start Date*</div>
                        <div class="col-md-8 col-12">
                            <input type="datetime-local" class="form-control w-50" name="startDate">
                        </div>
                    </div>
                    <div class="row my-2 text-start">
                        <div class="col-md-4 col-12 ">End Date*</div>
                        <div class="col-md-8 col-12">
                            <input type="datetime-local" class="form-control w-50" name="endDate">

                        </div>
                    </div>
                    <div class="row text-center mt-3">
                        <div class="col">
                            <input type="submit" value="Save" class="btn btn-success rounded-pill px-4">

                            <a  class="btn btn-success rounded-pill" onclick="procees()">Proceed</a>
                        </div>
                    </div>
                </form>
                <jsp:useBean id= "eventservice" class= "com.app.services.ExamEventService" >  
 					<c:set var="events" value="${eventservice.allEvents}"></c:set>
				</jsp:useBean> 
               
               
                <select class="form-select my-3" name="Paper" id="addoptions2">
							<optgroup  >
                			<c:forEach var="event" items="${events}">
                			
                			<option value="${event.examEventID}" id="" >${event.name} </option>
                			
							</c:forEach>
							</optgroup>
							
						</select>
             </div>
        </div>
        <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
					getList();
            })
            
            function getList(){

                $.ajax({
                    method: 'GET',
                    url: 'http://localhost:8081/MKCL_Assignment_1/langlist',
                    contentType: 'application/json',
                    success: function (result) {
                        console.log(result);
                        let string = ``;
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
            
            function procees(){

				var value =document.getElementById("addoptions2");
				//console.log(value);
				var selected=value.options[value.selectedIndex].value;

				$.ajax({
                    method: 'GET',
                    url: 'http://localhost:8081/MKCL_Assignment_1/examevent/getone/'+selected,
                    contentType: 'application/json',
                    success: function (result) {
                        console.log(result);
                      	getList();
                        window.location.replace("http://localhost:8081/MKCL_Assignment_1/papers/addpaper");
                    },
                    error: function ajaxError(jqXHR) {
                        console.error('Error: ', jqXHR.responseText);
                    }
                });
				
                
                }
        </script>
    </body>

    </html>
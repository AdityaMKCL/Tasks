<%@page import="com.app.models.ScheduleMaster"%>
<%@page import="com.app.services.ScheduleService"%>
<%@page import="com.app.models.Paper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.models.ExamEvent"%>
<%@page import="java.net.http.HttpRequest"%>
<%@page import="com.app.services.PaperService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body>
    <div class="container shadow-sm p-4">
        <div class="row  text-center">
            <div class="col-md-6 col-12 text-start display-6">
                Activate Exam Event
            </div>
            <div class="col-md-6 col-12">
            <div class="row">
            	<div class="col-6 text-end p-0 m-0">
                <button  value="Expand All"
                    class="btn btn-success rounded-end rounded-pill text-center px-4 m-0">Expand All</button>
            	</div>
            	<div class="col-6 text-start p-0 m-0">
                <button  value="Colapse All"
                    class="btn btn-success rounded-start rounded-pill text-center px-4 m-0">Colapse All</button>
            	</div>
            </div>
            </div>
        </div>
        <div class="row mt-5">
            <a class="btn btn-secondary text-start rounded-0 border-0 fw-bold border-0 fw-bold" data-bs-toggle="collapse" href="#collapseExample" role="button"
                aria-expanded="false" aria-controls="collapseExample" style="background-color: rgb(220, 220, 220)!important;color: black;">
                Exam Event Details  <i class="fa fa-angle-double-down" style="font-size:30px"></i>
            </a>
            <div class="collapse" id="collapseExample">
                <div class="card card-body">
                    <div class="row my-2">
                        <div class="row my-2">
                            <div class="col-md-4 col-12 fw-bold text-start">Exam Event Code</div>
                            <div class="col-md-8 col-12  text-start">${examEvent.examEventCode}</div>
                        </div>
                        <div class="row my-2">
                            <div class="col-md-4 col-12 fw-bold text-start">Exam Event Name</div>
                            <div class="col-md-8 col-12  text-start">${examEvent.name}</div>
                        </div>
                        <div class="row my-2">
                            <div class="col-md-4 col-12 fw-bold text-start">Default Language</div>
                            <div class="col-md-8 col-12  text-start">${examEvent.defaultLanguageID}</div>
                        </div>
                        <div class="row my-2">
                            <div class="col-md-6 col-12">
                                <div class="row my-2">
                                    <div class="col-md-6 col-12 fw-bold text-start">Start Date</div>
                                    <div class="col-md-6 col-12  text-start">${examEvent.startDate}</div>
                                </div>
                            </div>
                            <div class="col-md-6 col-12">
                                <div class="row my-2">
                                    <div class="col-md-6 col-12 fw-bold text-start">End Date</div>
                                    <div class="col-md-6 col-12  text-start">${examEvent.endDate}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="row ">
            <a class="btn btn-secondary text-start rounded-0 border-0 fw-bold" data-bs-toggle="collapse" href="#collapseExample2" role="button"
                aria-expanded="false" aria-controls="collapseExample" style="background-color: rgb(220, 220, 220)!important;color: black;">
                Papers Details <i class="fa fa-angle-double-down" style="font-size:30px"></i>
            </a>
            <div class="collapse" id="collapseExample2">
                <div class="card card-body text-center">

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <th>Sr no</th>
                                <th>Paper Id</th>
                                <th>Paper Code</th>
                                <th>Paper Name</th>
                                <th>Paper Total Marks</th>
                                <th>Maximum Time during which paper continues</th>
                            </thead>
                            <tbody>
                            <jsp:useBean id= "paperservice" class= "com.app.services.PaperService" />  
 					<c:set var="papers" value="${paperservice.getAllPapersList(examEvent.examEventID)}"></c:set>

                           
                            <c:set var="i" value="1"/>
                            <c:forEach var="paper" items="${papers}">
                            <tr>
                                <td>${i}</td>
                                <td>${paper.paperID}</td>
                                <td>${paper.code}</td>
                                <td>${paper.name}</td>
                                <td>000</td>
                                <td>000</td>
                            </tr>
                            
                            <c:set var="i" value="${i+1}"/>
                        </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
        <div class="row ">
            <a class="btn btn-secondary text-start rounded-0 border-0 fw-bold" data-bs-toggle="collapse" href="#collapseExample3" role="button"
                aria-expanded="false" aria-controls="collapseExample" style="background-color: rgb(220, 220, 220)!important;color: black;">
                Schedule <i class="fa fa-angle-double-down" style="font-size:30px"></i>
            </a>
            <div class="collapse" id="collapseExample3">
                <div class="card card-body text-center">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <th>Schedule Type</th>
                                <th>Starting From</th>
                                <th>Ending On</th>
                                <th>No of Schedules Created</th>
                            </thead>
                            <tbody>
                            <jsp:useBean id= "scheduleservice" class= "com.app.services.ScheduleService" />  
 					<c:set var="schedulee" value="${scheduleservice.getallforEvent(examEvent.examEventID)}"></c:set>
							
                         <c:set var="i" value="1"/>
                            <c:forEach var="schedule" items="${schedulee}">
							<tr>
								<td>${schedule.scheduleType}</td>
								<td>${schedule.scheduleStart}</td>
								<td>${schedule.scheduleEnd}</td>
								<td>${i}</td>
								</tr>
							<tr style="font-weight: 400; font-size: smaller;">
								<td colspan="2"><span class="text-start pe-3">Allow
										Schedule Extension</span> <span class="text-end ps-5">No</span></td>
								<td colspan="2" class="text-start">Max No of Papers that
									can be Scheduled</td>
								<td class="text-end">${schedule.maxNumberOfPapers}</td>
							</tr>
							
                            <c:set var="i" value="${i+1}"/>
                        </c:forEach>

						</tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
        <div class="row text-center mt-4">
            <div class="col">
                <input type="button" value="Back" class="btn btn-secondary rounded-pill px-5">
                <a type="button" href="http://localhost:8081/MKCL_Assignment_1/examevent/config" class="btn btn-success rounded-pill px-3" >Activate Exam Event</a>
                <input type="button" value="Proceed" class="btn btn-success rounded-pill px-5" disabled>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
            <script src="https://use.fontawesome.com/releases/vVERSION/js/all.js" data-mutate-approach="sync"></script>
        
</body>

</html>
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
    <div class="container border border-dark my-4">
        <div class="row  text-center my-4">
            <div class="col-md-6 col-12 text-start display-6">
                Manage Exam Event
            </div>
            <div class="col-md-6 col-12">
                <a class="btn btn-success rounded-pill text-center px-5 m-0" href="http://localhost:8081/MKCL_Assignment_1/">Add Exam Event</a>
            </div>
        </div>
        <div class="row">
            <div class="table-responsive">

				<table class="table table-striped table-bordered text-center"
					style="overflow-y: scroll !important; height: 200px !important;">
					<jsp:useBean id= "eventservice" class= "com.app.services.ExamEventService" >  
 					<c:set var="events" value="${eventservice.allEvents}"></c:set>
</jsp:useBean> 
					<thead>
						<th>Exam Event ID</th>
						<th>Exam Event Name</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Completion Status</th>
                        <th>Update</th>
					</thead>
					<tbody id="newdata">
					<c:forEach var="event" items="${events}">
                        <tr>
                            <td>${event.examEventID}</td>
                            <td>${event.name}</td>
                            <td>${event.startDate}</td>
                            <td>${event.endDate}</td>
                            <td><i class="fa fa-check-circle text-success" style="font-size:20px"></i></td>
                            <td><button class="btn btn-success p-2 px-4 rounded-pill" value="Update">Update</button></td>
                        </tr>
					</c:forEach>
                    </tbody>
					<thead>
                        <th>Exam Event ID</th>
						<th>Exam Event Name</th>
						<th>Start Date</th>
						<th>End Date</th>
                        <th>Complition Status</th>
                        <th>Update</th>
					</thead>
				</table>
			</div>
        </div>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
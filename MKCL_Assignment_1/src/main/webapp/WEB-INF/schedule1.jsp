<%@page import="java.net.http.HttpRequest"%>
<%@page import="com.app.models.ScheduleMaster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.services.ScheduleService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body>
	<div class="container mt-3">
		<div class="row p-4 border shadow-sm">
			<h1 class="display-6">Schedule</h1>
			<div class="alert alert-primary my-2" role="alert">
				<div class="row my-2">
					<div class="col-md-3 col-12 fw-bold">Exam event</div>
					<div class="col-md-9 col-12 ">${examEvent.name}
						${examEvent.startDate}</div>
				</div>
				<div class="row my-2">
					<div class="col-md-6 col-12 ">
						<div class="row">
							<div class="col-6 fw-bold">Event Start Date</div>
							<div class="col-6">${examEvent.startDate}</div>
						</div>
					</div>
					<div class="col-md-6 col-12 ">
						<div class="row">
							<div class="col-6 fw-bold">Event End Date</div>
							<div class="col-6">${examEvent.endDate}</div>
						</div>
					</div>
				</div>
			</div>

			<!-- alert ended  -->
			<%
			ScheduleMaster eve =  (ScheduleMaster)  request.getSession().getAttribute("schedule");
        	if(eve==null){
			%>
			<form action="/MKCL_Assignment_1/schedule/save" method="GET">
				<input type="text" value="-1" name="scheduleId" class="d-none">
			<%
			}else {%>
			<form action="/MKCL_Assignment_1/schedule/update" method="GET">
				<input type="text" value="${schedule.scheduleID}" name="scheduleId" class="d-none">
				<% }%>			
				<div class="row">
					<div class="col-md-4 col-12">Schedule Type *</div>
					<div class="col-md-8 col-12">
					
						<select class="form-select" name="scheduleType" id="city" value="${schedule.scheduleType}">
							<optgroup id="addoptions" >
								<option value="DAY">DAY</option>
								<option value="WEEK">WEEK</option>
								<option value="CUSTOME">CUSTOM</option>
							</optgroup>
						</select>
					</div>
				</div>
				<div class="row my-2">
					<div class="col-md-4 col-12">Max No of Papers that can be
						Scheduled*</div>
					<div class="col-md-4 col-12">
						<input type="text" class="form-control" name="maxNoOfPapers"
							value="${schedule.maxNumberOfPapers}">
					</div>
					<div class="col-md-4 col-12">
						<p class="blockquote-footer m-1 pb-1">
							<span class="fw-bold">NOTE:</span> If kept 0 then unlimited
							papers will be allowed
						</p>
					</div>
				</div>

				<div class="row my-2 text-start">
					<div class="col-md-4 col-12 ">Start Date*</div>
					<div class="col-md-8 col-12">
						<input type="datetime-local" class="form-control w-50"
							name="startDate" value="${schedule.scheduleStart}">
					</div>
				</div>
				<div class="row my-2 text-start">
					<div class="col-md-4 col-12 ">End Date*</div>
					<div class="col-md-8 col-12">
						<input type="datetime-local" class="form-control w-50"
							name="endDate" value="${schedule.scheduleEnd}">

					</div>
				</div>

				<div class="row text-center my-3">
					<div class="col">
						<input type="button" value="Back"
							class="btn btn-secondary rounded-pill px-5">
							<%
        	if(eve==null){
			%>
							 <input
							type="submit" value="Save Schedule"
							class="btn btn-success rounded-pill px-4">
							<%}else { %>
							 <input
							type="submit" value="Update Schedule"
							class="btn btn-success rounded-pill px-4">
							<%} %>
							<a
							href="http://localhost:8081/MKCL_Assignment_1/schedule/redirect1"
							class="btn btn-success rounded-pill mx-2">Proceed</a>
					</div>
				</div>
			</form>
			<hr>
			<div class="row">
				<h5>Already Attached Schedule Types</h5>
			</div>
			<hr>
			<div class="row text-center">
				<div class="table-responsive">
					<table class="table table-striped table-bordered" style="font-weight: 400; font-size: small;">
						<thead>
							<th>Schedule Type</th>
							<th>Starting From</th>
							<th>Ending On</th>
							<th>No of Schedules Created</th>
							<th>Update</th>
							<th>Delete</th>
						</thead>
						<tbody>
							<%
                    ScheduleService service = new ScheduleService();
                    ArrayList<ScheduleMaster> arr = service.getall();
                    int count = 1;
                    for (ScheduleMaster schedule : arr) {
                    	//System.out.println(schedule.getFkExamEventID() + "  "+schedule.getMaxNumberOfPapers())
                %>
							<tr>
								<td><%=schedule.getScheduleType()%></td>
								<td><%=schedule.getScheduleStart()%></td>
								<td><%=schedule.getScheduleEnd()%></td>
								<td><%=count%></td>
								<td><input type="text"
									class="btn btn-success w-50 rounded-pill" value="Update" name="<%=schedule.getScheduleID() %>" onclick="updatethis(this)"></td>
								<td><input type="text"
									class="btn btn-danger w-50 rounded-pill" value="Delete" id="<%=schedule.getScheduleID() %>" onclick="deletethis(this)"></td>
							</tr>
							<tr style="font-weight: 400; font-size: smaller;">
								<td></td>
								<td colspan="2"><span class="text-start pe-3">Allow
										Schedule Extension</span> <span class="text-end ps-5">No</span></td>
								<td colspan="2" class="text-start">Max No of Papers that
									can be Scheduled</td>
								<td class="text-end"><%=schedule.getMaxNumberOfPapers()%></td>
							</tr>
							<%count++; %>
							<%}%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
	function deletethis(param){
	 $.ajax({
         method: 'GET',
         url: 'http://localhost:8081/MKCL_Assignment_1/schedule/delete/'+param.id,
         contentType: 'application/json',
         success: function (result) {
             window.location.replace("http://localhost:8081/MKCL_Assignment_1/schedule/redirect");

         },
         error: function ajaxError(jqXHR) {
             console.error('Error: ', jqXHR.responseText);
         }
     });
		}
	function updatethis(param){
		console.log(param);
	 $.ajax({
         method: 'GET',
         url: 'http://localhost:8081/MKCL_Assignment_1/schedule/get/'+param.name,
         contentType: 'application/json',
         success: function (result) {
             window.location.replace("http://localhost:8081/MKCL_Assignment_1/schedule/redirect");

         },
         error: function ajaxError(jqXHR) {
             console.error('Error: ', jqXHR.responseText);
         }
     });
			
		}
	</script>
</body>

</html>
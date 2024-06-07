<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONVERTER</title>
</head>
<body>
	<div class="container">
		<form action="http://localhost:8081/ExelSheetPractice/upload"
			enctype="multipart/form-data" method="post">
			<div class="display-4 m-5">Enter the file you want</div>
			<div class="border shadow-sm">
				<div class="row m-5">
					<div class="col-md-6 col-12 text-center lead">Select the
						files you want to zip and submit</div>
					<div class="col-md-6 col-12 text-center">
						<input class="form-control" type="file" name="file" />
					</div>
				</div>
				<div class="row m-5">
					<div class="col"></div>
					<div class="col"></div>
					<div class="col">
						<button class="col-12 btn btn-info" type="submit">Upload</button>
					</div>
					<div class="col"></div>
					<div class="col"></div>
				</div>
			</div>
		</form>
		<hr>
		<div class="table-responsive mb-4">
			<table class="table table-striped mb-5">
				<thead>
					<th>Sr No</th>
					<th>File Name</th>

				</thead>
				<tbody>
					<c:set var="count" value="${ 1 }"></c:set>
					<c:forEach var="event" items="${Lst}">
						<tr>
							<td>${count}</td>
							<td>${event }</td>
							<c:set var="count" value="${ count+1 }"></c:set>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<form class="mb-5" action="http://localhost:8081/ExelSheetPractice/getZip" method="get">
			<button class="btn btn-success" type="submit">Get Zip</button>
			</form>
			</form>
		</div>
	</div>
</body>
</html>
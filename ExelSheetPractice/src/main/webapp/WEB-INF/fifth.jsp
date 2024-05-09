<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Converter</title>
</head>
<body >
	<div class="container d-flex">
	<jsp:useBean id="eventservice" class="com.app.services.ExcelService">
		<c:set var="events" value="${eventservice.getZipList()}"></c:set>
	</jsp:useBean>

	<c:forEach var="event" items="${events}">
	<a href="http://localhost:8081/ExelSheetPractice//download/${event}">
		<div class="card m-3"  style="width: 8rem;">
			<img
				src="https://img.freepik.com/free-vector/blue-computer-folder-flat-style_78370-1029.jpg?t=st=1715235943~exp=1715239543~hmac=cbec11358094783e476b27a84225ac4c066ff7305913f7b03e8dc3a4b11b0491&w=740"
				class="card-img-top" alt="..." style="width: 3rem;">
			<div class="card-body">
				<p >${event}</p>

			</div>
		</div>

	</a>
	</c:forEach>
	</div>
</body>
</html>
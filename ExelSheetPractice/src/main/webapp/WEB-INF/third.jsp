<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>CONVERTER</title>
</head>
<body>
			

	<div class="container mb-5 text-center">
		<form method="POST" enctype="multipart/form-data"
			action="http://localhost:8081/ExelSheetPractice/form">
			<div class="text-center shadow-sm mt-5 rounded-pill border">
			<div class="display-4 m-5">Convert Excel to Pdf</div>
			<div class="row mt-5">
				<div class="col ">
					<p class="lead">Enter the form data</p>
				</div>
				<div class="col ">
					<input class="form-control" type="file" name="file" />
				</div>
				<div class="col">
					<input class="btn btn-primary" type="submit" value="Upload file" />
				</div>
			</div>
				<div class="row text-center">
					<p class="text-success">${message}</p>
					<div class="col"></div>
				</div>
		</form>
	</div>
	</div>
	</div>
</body>
</html>
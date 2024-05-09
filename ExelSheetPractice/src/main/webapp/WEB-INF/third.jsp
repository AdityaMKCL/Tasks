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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<div class="container text-center mb-5">
		<form method="POST" enctype="multipart/form-data"
			action="http://localhost:8081/ExelSheetPractice/form">
			<div class="row mt-5">
				<div class="col-md-6 col-12">
					<p class="lead">Enter the form data</p>
				</div>
				<div class="col-md-6 col-12">
					<input class="form-control" type="file" name="file" />
				</div>
			</div>
			<div class="row text-center m-5">
				<p class="text-success">${message}</p>
				<div class="col">
					<input class="btn btn-primary" type="submit" value="Upload file" />
				</div>
				<div class="col">
					<a class="btn btn-primary"
						href="http://localhost:8081/ExelSheetPractice/">Next Page</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>CONVERTER</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body>
	<div class="container my-5">
		<form action="http://localhost:8081/ExelSheetPractice/zip" enctype="multipart/form-data" method="post">
			<div class="display-4 m-5">Files to zip page </div>
			<div class="border shadow-sm rounded-pill">
			<div class="row m-5">
				<div class="col-md-6 col-12 text-center lead">Select the
					files you want to zip and submit</div>
				<div class="col-md-6 col-12 text-center">
					<input type="file" class="form-control" name="file" WebKitDirectory>
				</div>
			</div>
			<div class="row m-5">
			<div class="col"></div>
			<div class="col"></div>
				<div class="col">
					<button class="col-12 btn btn-info" type="submit">Submit</button>
				</div>
			<div class="col"></div>
			<div class="col"></div>
			</div>
			</div>
	</form>

	</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONVERTER</title>
</head>
<body>

	<div class="container mb-5 text-center">
		<form method="POST" enctype="multipart/form-data"
			action="http://localhost:8081/ExelSheetPractice/uploadExcelFile">
			<div class="text-center shadow-sm mt-5 rounded-pill border">
			<div class="display-4 m-5">Save Your File To Database</div>
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
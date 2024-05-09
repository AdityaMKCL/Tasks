<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONVERTER</title>
</head>
<body>

	<div class="container mb-5">
		<form method="POST" enctype="multipart/form-data"
			action="http://localhost:8081/ExelSheetPractice/uploadExcelFile">
			<div class="row mt-5">
				<div class="col-md-6 col-12">
					<p class="lead">Enter the form data</p>
				</div>
				<div class="col-md-6 col-12">
					<input class="form-control" type="file" name="file"
						 />
				</div>
				<div class="row text-center">
					<p class="text-success">${message}</p>
					<div class="col">
						<input class="btn btn-primary" type="submit" value="Upload file" />
					</div>
					<div class="col">
						<a class="btn btn-primary" href="http://localhost:8081/ExelSheetPractice/two" >Next Page</a>
					</div>
		</form>
	</div>
	</div>
	</div>


</body>
</html>
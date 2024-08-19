<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COMPARATOR</title>
</head>
<body>
	
	<div class="container">
		<form action="http://localhost:8081/ExelSheetPractice/Compare2"
			enctype="multipart/form-data" method="post">
			<div class="display-4 m-5">Enter the file you want</div>
			<div class="border shadow-sm">
				<div class="row m-5">
					<div class="col-md-6 col-12 text-center lead">Select the
						files you want as the main file</div>
					<div class="col-md-6 col-12 text-center">
						<input class="form-control" type="file" name="file1" />
					</div>
				</div>
				<div class="row m-5">
					<div class="col-md-6 col-12 text-center lead">Select the
						files you want to compare to main file</div>
					<div class="col-md-6 col-12 text-center">
						<input class="form-control" type="file" name="file2" />
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
					<th class="display-4">Difference in images is </th>

				</thead>
				<tbody>
						<tr>
							<td class="lead">${message}  <img th:src="@{/${outputImage}}" alt="Difference Image" style="width: 300px ;height:300px;" /></td>
					</c:forEach>
				</tbody>
			</table>
			<hr>
		</div>
	</div>
	
</body>
</html>
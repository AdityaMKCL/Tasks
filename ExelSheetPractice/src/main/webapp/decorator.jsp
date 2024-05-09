<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>SiteMesh example: <sitemesh:write property='title' /></title>

<sitemesh:write property='head' />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>
<body>
		<nav class="navbar navbar-expand-lg sticky" style="background-color: lightgray;">
			<div class="container-fluid">
				<a class="navbar-brand display-3 bg-primary rounded-pill p-2 text-light" href="http://localhost:8081/ExelSheetPractice/" style="font-size:30px!important;"><sitemesh:write
						property='title' /></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav " style="font-weight:350;font-size:18px;">
						<a class="nav-link active" aria-current="page" href="http://localhost:8081/ExelSheetPractice/">ExcelToDB</a> 
						<a class="nav-link active" aria-current="page" href="http://localhost:8081/ExelSheetPractice/two">TextToExcel</a> 
						<a class="nav-link active" aria-current="page" href="http://localhost:8081/ExelSheetPractice/three">ExcelToPdf</a> 
						<a class="nav-link active" aria-current="page" href="http://localhost:8081/ExelSheetPractice/four">ZipUpload</a> 
						<a class="nav-link active" aria-current="page" href="http://localhost:8081/ExelSheetPractice/six">AnyFileToZip</a> 
						<a class="nav-link active" aria-current="page" href="http://localhost:8081/ExelSheetPractice/five">DownloadZip</a> 
					</div>
				</div>
			</div>
		</nav>
	<div class="container">

		<div class='mainBody'>
			<sitemesh:write property='body' />
		</div>

	</div>
		<div class="row fw-bold mt-5 w-100" style="background-color: lightgray;position: fixed;
            padding: 10px 10px 0px 10px;
            bottom: 0;">
			<p class="lead  text-center">@Copyrights reserved for all
				other usages</p>
		</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
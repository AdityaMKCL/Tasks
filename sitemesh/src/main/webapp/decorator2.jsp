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
	<div class="container">

		
		<!-- As a heading -->
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<span class="navbar-brand mb-0 h1"><sitemesh:write
						property='title' /></span>
			</div>
		</nav>
		<div class='mainBody'>
			<sitemesh:write property='body' />
		</div>

		<div class="row bg-info fw-bold">
			<p class="lead  text-center">@Copyrights reserved for all
				other usages</p>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
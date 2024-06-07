<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONVERTER</title>
</head>
<body>
	<spring:eval expression="@environment.getProperty('ImagesPath')"
		var="frontendUrl" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">globalRecords</div>
			<div class="col-md-6">${globalRecords }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">QuestionPaperPath</div>
			<div class="col-md-6">${QuestionPaperPath }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">CandidateStatisticsReportPath</div>
			<div class="col-md-6">${CandidateStatisticsReportPath }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">ImagesPath</div>
			<div class="col-md-6">${ImagesPath }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">zipImagesPath</div>
			<div class="col-md-6">${zipImagesPath }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">UserDefaultImagePath</div>
			<div class="col-md-6">${UserDefaultImagePath }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">globalDateFormat</div>
			<div class="col-md-6">${globalDateFormat }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">globalDateFormatWithoutTime</div>
			<div class="col-md-6">${globalDateFormatWithoutTime }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">examClientVersion</div>
			<div class="col-md-6">${examClientVersion }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">wkhtmltopdfPath</div>
			<div class="col-md-6">${wkhtmltopdfPath }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">isCopyRightEnabled</div>
			<div class="col-md-6">${isCopyRightEnabled }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">MaxCandidatesPerProctor</div>
			<div class="col-md-6">${MaxCandidatesPerProctor }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">isLoggingEnabled</div>
			<div class="col-md-6">${isLoggingEnabled }</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-6">isReportItemEnabled</div>
			<div class="col-md-6">${isReportItemEnabled }</div>
		</div>
		<hr>
		
	</div>
</body>
</html>
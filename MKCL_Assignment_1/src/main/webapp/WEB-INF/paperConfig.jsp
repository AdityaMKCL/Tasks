<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body>
	<div class="container mt-3">
		<div class="row p-4 border shadow-sm">
			<h1 class="display-6">Exam Event - Paper Configuration details</h1>
			<div class="alert alert-primary my-2" role="alert">
				<div class="row my-2">
					<div class="col-md-3 col-12 fw-bold">Exam event</div>
					<div class="col-md-9 col-12 ">${examEvent.name}
						${examEvent.startDate}</div>
				</div>
				<div class="row my-2">
					<div class="col-md-6 col-12 ">
						<div class="row">
							<div class="col-6 fw-bold">Event Start Date</div>
							<div class="col-6">${examEvent.startDate}</div>
						</div>
					</div>
					<div class="col-md-6 col-12 ">
						<div class="row">
							<div class="col-6 fw-bold">Event End Date</div>
							<div class="col-6">${examEvent.endDate}</div>
						</div>
					</div>
				</div>
			</div>

			<!-- alert ended  -->
			<form action="/MKCL_Assignment_1/exameventpaper/finalPaper">

				<div class="row">
					<div class="col-md-3 col-12">Select Paper *</div>
					<div class="col-md-9 col-12">
						<!-- <div> -->
						<select class="form-select" name="Paper" id="city">
							<optgroup id="addoptions">

							</optgroup>
						</select>
						<!-- </div> -->
						<figcaption class="blockquote-footer m-1 p-0">papers
							which has no access to you are in disable state</figcaption>
					</div>
				</div>
				<div class="row my-2">
					<div class="col-12 lead fs-3 p-1 px-2 rounded"
						style="background-color: rgb(160, 160, 160);">General
						Setting</div>
				</div>
				<div class="row">
					<div class="col-md-5 col-12">
						Exam Type <i class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<select class="form-select" name="examType" id="city">
							<optgroup id="">
								<option value="1">PRACTICE</option>
								<option value="2">MAIN</option>
							</optgroup>
						</select>
					</div>
				</div>
				<div class="row my-2">
					<div class="col-md-5 col-12">
						No.of Attempts <i class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<input type="text" class="w-50 form-control" name="NoOfAttempts">
					</div>
				</div>
				<div class="row my-2 text-success">
					<div class="col-md-5 col-12">
						Identical Question Papers to all candidate <i
							class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline IdenticalOptions">
							<input class="form-check-input" type="radio"
								name="IdenticalOptions" id="inlineRadio1" value="Yes"> <label
								class="form-check-label " for="inlineRadio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="IdenticalOptions" id="inlineRadio2" value="No"> <label
								class="form-check-label " for="inlineRadio1">No</label>
						</div>
					</div>
				</div>
				<div class="row my-2 text-success">
					<div class="col-md-5 col-12">
						Identical items sequence to all candidate <i
							class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline ">
							<input class="form-check-input" type="radio"
								name="identicalItems" id="inlineRadio1" value="Yes"> <label
								class="form-check-label " for="inlineRadio1">Yes (No
								randomization)</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="identicalItems" id="inlineRadio2" value="No"> <label
								class="form-check-label " for="inlineRadio1">No
								(randomization)</label>
						</div>
					</div>
				</div>
				<div class="row my-2">
					<div class="col-12 lead fs-3 p-1 px-2 rounded"
						style="background-color: rgb(160, 160, 160);">Exam Screen
						Setting</div>
				</div>
				<div class="row my-2">
					<div class="col-md-5 col-12">
						Option Randomization <i class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline ">
							<input class="form-check-input" type="radio"
								name="optionRandomization" id="inlineRadio1" value="Yes">
							<label class="form-check-label " for="inlineRadio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="optionRandomization" id="inlineRadio2" value="No">
							<label class="form-check-label " for="inlineRadio1">No</label>
						</div>
					</div>
				</div>
				<div class="row my-2">
					<div class="col-12 lead fs-3 p-1 px-2 rounded"
						style="background-color: rgb(160, 160, 160);">Exam Interface
						Control Settings</div>
				</div>
				<div class="row my-2 text-success">
					<div class="col-md-5 col-12">
						Double pallet naviation <i class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline ">
							<input class="form-check-input" type="radio"
								name="doublePalletNavigation" id="inlineRadio1" value="Yes">
							<label class="form-check-label " for="inlineRadio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="doublePalletNavigation" id="inlineRadio2" value="No">
							<label class="form-check-label " for="inlineRadio1">No</label>
						</div>
					</div>
				</div>
				<div class="row my-2 text-success">
					<div class="col-md-5 col-12">
						Skip Question <i class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline ">
							<input class="form-check-input" type="radio" name="skipQuestion"
								id="inlineRadio1" value="Yes"> <label
								class="form-check-label " for="inlineRadio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="skipQuestion"
								id="inlineRadio2" value="No"> <label
								class="form-check-label " for="inlineRadio1">No</label>
						</div>
					</div>
				</div>
				<div class="row my-2 text-success">
					<div class="col-md-5 col-12">
						Answer question can be chnged After Attempt <i
							class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline ">
							<input class="form-check-input" type="radio" name="answerChange"
								id="inlineRadio1" value="Yes"> <label
								class="form-check-label " for="inlineRadio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="answerChange"
								id="inlineRadio2" value="No"> <label
								class="form-check-label " for="inlineRadio1">No</label>
						</div>
					</div>
				</div>
				<div class="row my-2 text-success">
					<div class="col-md-5 col-12">
						Show Notepad <i class="fa fa-question-circle"></i>
					</div>
					<div class="col-md-7 col-12">
						<div class="form-check form-check-inline ">
							<input class="form-check-input" type="radio" name="showNotepad"
								id="inlineRadio1" value="Yes"> <label
								class="form-check-label " for="inlineRadio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="showNotepad"
								id="inlineRadio2" value="No"> <label
								class="form-check-label " for="inlineRadio1">No</label>
						</div>
					</div>
				</div>
				<div class="row text-center my-2">
					<div class="col">
					
						<a href="http://localhost:8081/MKCL_Assignment_1/papers/addpaper" 
						class="btn btn-secondary rounded-pill px-4">Back</a> <input
							type="submit" value="Save"
							class="btn btn-success rounded-pill px-4"> <a
							href="http://localhost:8081/MKCL_Assignment_1/schedule/redirect"
							class="btn btn-success rounded-pill">Proceed</a>

					</div>
				</div>

			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
	 $(document).ready(function () {
         $.ajax({
             method: 'GET',
             url: 'http://localhost:8081/MKCL_Assignment_1/papers/list',
             contentType: 'application/json',
             success: function (result) {
                 console.log(result);
                 result = result.replaceAll("]", "");
                 result = result.replaceAll("[", "");
                 let string = ``;
                 document.getElementById("addoptions").innerHTML = string;
                 const arr = result.split(",");
                 for (let i = 2; i < arr.length; i+=3) {

                     string += "<option value=" + arr[i-2] + " id=" + arr[i-2] + " class='d-none' disabled>" + arr[i-1] + "</option>"

                 }
                 console.log(string);
                 document.getElementById("addoptions").innerHTML = string;

                /*  new ajax start */

                 $.ajax({
             method: 'GET',
             url: 'http://localhost:8081/MKCL_Assignment_1/exameventpaper/getpapers/'+${examEvent.getExamEventID()},
             contentType: 'application/json',
             success: function (result) {
                 console.log(result);
                 result = result.substring(1, result.length - 1);
                 const arr = result.split(",");
					 for (let i = 0; i < arr.length; i++) {
                	 $('#'+arr[i].trim()).removeClass("d-none");
                	 $('#'+arr[i].trim()).removeAttr("disabled");
                    
                 }  
             },
             error: function ajaxError(jqXHR) {
                 console.error('Error: ', jqXHR.responseText);
             }
         });

                 },
             error: function ajaxError(jqXHR) {
                 console.error('Error: ', jqXHR.responseText);
             }
         });
        

         console.log(${examEvent.getExamEventID()});
         

     })
	</script>
</body>

</html>
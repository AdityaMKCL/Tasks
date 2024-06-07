<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>
<form>
    <div class="container text-md-center text-start lead">
        <h1 class="display-4 m-3">
            Candidate Registration Center
        </h1>
        <hr>
        <div class="row m-2">
            <div class="col-12 col-md-6">
                Candidate ID :
            </div>
            <div class="col-12 col-md-6">
                <input type="text" class="form-control" name="cid" id="validationserver1"
                    placeholder="Enter Candidate Id" >
            </div>
        </div>
        <div class="row m-2">
            <div class="col-12 col-md-6">
                Name :
            </div>
            <div class="col-12 col-md-6">
                <input type="text" class="form-control" name="name" id="validationserver2"
                    placeholder="Enter Candidate Name(eg Testing test)">
            </div>
        </div>
        <div class="row m-2">
            <div class="col-12 col-md-6">
                Username :
            </div>
            <div class="col-12 col-md-6">
                <input type="text" class="form-control" name="uname" id="validationserver3"
                    placeholder="Enter Username">
            </div>
        </div>
        <div class="row m-2">
            <div class="col-12 col-md-6">
                Password :
            </div>
            <div class="col-12 col-md-6">
                <input type="text" class="form-control" name="password" id="validationserver4"
                    placeholder="Enter Password">
                </div>
            </div>
            <div class="row m-2">
<div class="col-12 col-md-6"></div>
                <div class="col-12 col-md-6">
                    <p class="blockquote-footer">(password should be at least 8 charater long and should have atleas 1 alphabet 1 special character 1 digit)</p>
                </div>
            </div>
        <div class="row m-2">
            <div class="col-12 col-md-6">
                Description :
            </div>
            <div class="col-12 col-md-6">
                <textarea class="form-control" id="validationserver5" rows="4"></textarea>
            </div>
        </div>
        <div class="row m-2">
            <div class="col-12 col-md-6">
                Gender :
            </div>
            <div class="col-12 col-md-6 text-start ">
                <div class="form-check form-check-inline gender" >
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                        value="MALE">
                    <label class="form-check-label " for="inlineRadio1">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                        value="FEMALE">
                    <label class="form-check-label " for="inlineRadio1">Female</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3"
                        value="OTHER">
                    <label class="form-check-label " for="inlineRadio1">Other</label>
                </div>
            </div>
        </div>
        <div class="row m-1">
            <div class="col-12 col-md-6">
                Skills :
            </div>
            <div class="col-12 col-md-6 text-start ">
                <div class="form-check-inline" >
                    <input class="form-check-input" type="checkbox" value="Programming" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        Programming
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="Database Designing" id="defaultCheck2">
                    <label class="form-check-label" for="defaultCheck1">
                        Database Designing
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="Communication" id="defaultCheck3">
                    <label class="form-check-label" for="defaultCheck1">
                        Communication
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="Presentation" id="defaultCheck4">
                    <label class="form-check-label" for="defaultCheck1">
                        Presentation
                    </label>
                </div>
            </div>
        </div>
        <div class="row m-2">
           
            <div class="col-12 col-md-6">
                Standard :
            </div>
            <div class="col-12 col-md-6 text-start ">
                <select class="form-select btn btn-secondary" aria-label="Default select example" id="Standard">
                    <option selected disabled value="0">Select Standard</option>
                        <option value="2" >2nd</option>
                        <option value="3" >3rd</option>
                        <option value="4" >4th</option>
                        <option value="5" >5th</option>
                        <option value="6" >6th</option>
                        <option value="7" >7th</option>
                        <option value="8" >8th</option>
                        <option value="9" >9th</option>
                        <option value="10" >10th</option>
                  </select>
                
            </div>
        </div>
        
        <div class="row m-1">
            <div class="col-12 col-md-6">
                Preffered Programming language :
            </div>
            <div class="col-12 col-md-6 text-start ">
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="Java" id="defaultCheck11">
                    <label class="form-check-label" for="defaultCheck11">
                        Java
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="Python" id="defaultCheck22">
                    <label class="form-check-label" for="defaultCheck22">
                        Python
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="GoLang" id="defaultCheck33">
                    <label class="form-check-label" for="defaultCheck33">
                        GoLang
                    </label>
                </div>
                <div class="form-check-inline">
                    <input class="form-check-input" type="checkbox" value="C++" id="defaultCheck44" >
                    <label class="form-check-label" for="defaultCheck44">
                        C++
                    </label>
                </div>
            </div>
        </div>
        <div class="row m-3">
            <div class="col-12 col-md-6">
               Upload last year marksheet :
            </div>
            <div class="col-12 col-md-6 text-start ">
                <input type="file" class="form-control" name="file" id="file"
                    placeholder="Upload document">
            </div>
        </div>
        <div class="row m-4">
           
            <div class="col-12 text-center text-danger d-none" id="msg" >
                <p>Please provide all the information</p>
            </div>
        </div>
        <div class="row m-4">
           
            <div class="col-6 text-center ">
                <input type="reset" class="btn btn-warning" name="reset" 
                    ></input>
            </div>
            <div class="col-6 text-center ">
                <input  class="btn btn-success" name="submit" id="submit" value="Submit"></input>
            </div>
        </div>

    </div>
</form>



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
        <script>
        /* const element = document.querySelector('form');
        element.addEventListener('submit', event => {
          event.preventDefault();
          // actual logic, e.g. validate the form
          console.log('Form submission cancelled.');
        }); */
        $("form").submit(function (e){
            e.preventDefault();
        })
        
            $("#validationserver1").change(function (){
                console.log(this.value);
                var str=/^[a-zA-Z0-9]+$/;
                var found =str.test(this.value);
                console.log(found);
                if(found===false){
                    console.log("in false");
                    $("#validationserver1").addClass("is-invalid")
                }else{
                    $("#validationserver1").removeClass("is-invalid")
                    $("#validationserver1").addClass("is-valid")
                    
                }
            });
            $("#validationserver2").change(function (){
                console.log(this.value);
                var str=/^[a-zA-Z]+ ?([a-zA-Z]+$){1}/;
                var found =str.test(this.value);
                console.log(found);
                if(found===false){
                    console.log("in false");
                    $("#validationserver2").addClass("is-invalid")
                }else{
                    $("#validationserver2").removeClass("is-invalid")
                    $("#validationserver2").addClass("is-valid")
                    
                }
            });
            $("#validationserver3").change(function (){
                console.log(this.value);
                var str=/^[a-zA-Z0-9]+$/;
                var found =str.test(this.value);
                console.log(found);
                if(found===false){
                    console.log("in false");
                    $("#validationserver3").addClass("is-invalid")
                }else{
                    $("#validationserver3").removeClass("is-invalid")
                    $("#validationserver3").addClass("is-valid")
                    
                }
            });
            $("#validationserver4").change(function (){
                console.log(this.value);
                var str=/^(?=.*?[a-zA-Z0-9#?!@$%^&*-])(?=.*?[a-zA-Z0-9#?!@$%^&*-])(?=.*?[a-zA-Z0-9#?!@$%^&*-]).{8,}$/;
                var found =str.test(this.value);
                console.log(found);
                if(found===false){
                    console.log("in false");
                    $("#validationserver4").addClass("is-invalid")
                }else{
                    $("#validationserver4").removeClass("is-invalid")
                    $("#validationserver4").addClass("is-valid")
                    
                }
            });
            $("#submit").click(function(){
                var arr= new Array();
                if($("#defaultCheck1").is(":checked"))arr.push($("#defaultCheck1").val());
                if($("#defaultCheck2").is(":checked"))arr.push($("#defaultCheck2").val());
                if($("#defaultCheck3").is(":checked"))arr.push($("#defaultCheck3").val());
                if($("#defaultCheck4").is(":checked"))arr.push($("#defaultCheck4").val());
                console.log(arr);
                var gender = new Array();
                if($("#inlineRadio1").is(":checked"))gender.push($("#inlineRadio1").val());
                if($("#inlineRadio2").is(":checked"))gender.push($("#inlineRadio2").val());
                if($("#inlineRadio3").is(":checked"))gender.push($("#inlineRadio3").val());
                console.log(gender);
                var language = new Array();
                if($("#defaultCheck11").is(":checked"))language.push($("#defaultCheck11").val());
                if($("#defaultCheck22").is(":checked"))language.push($("#defaultCheck22").val());
                if($("#defaultCheck33").is(":checked"))language.push($("#defaultCheck33").val());
                if($("#defaultCheck44").is(":checked"))language.push($("#defaultCheck44").val());
                console.log(language);

                var Standard = $("#Standard option:checked").val();
                console.log(Standard);

                var file = $("#file").val();
                console.log(file);
                if(gender.length===0 || arr.length===0 || language.length === 0 || Standard==0 || file=="")$("#msg").removeClass("d-none");
                else {
                    $("#msg").addClass("d-none");
                    var candidateId=$("#validationserver1").val();
                    var candidateName=$("#validationserver2").val();
                    var userName=$("#validationserver3").val();
                    var password=$("#validationserver4").val();
                    var description=$("#validationserver5").val();
                
                    var data = {
                        candidateId : candidateId,
                        candidateName : candidateName,
                        userName : userName,
                        password : password,
                        description : description.toString(),
                        skills : arr.toString(),
                        gender : gender.toString(),
                        standard : Standard,
                        languages : language.toString()
                    }
                    console.log(data);
                    $.ajax({
                        method: 'GET',
                        url: 'http://localhost:8081/Candidate_task_XML/login',
                        contentType: 'application/json',
                        data : data,
                        success: function (result) {
                           console.log(result);
                           if(result=="Candidate Succesfully added")
                           window.location.replace("http://localhost:8081/Candidate_task_XML/");
                           else {
                        	   window.sessionStorage.setItem("candidate",candidate);
                        	   window.location.replace("http://localhost:8081/Candidate_task_XML/error.jsp")
                               }
                        },
                        error: function ajaxError(jqXHR) {
                            console.error('Error: ', jqXHR.responseText);
                        }
                    });
                }
                
            })
        </script>
</body>

</html>
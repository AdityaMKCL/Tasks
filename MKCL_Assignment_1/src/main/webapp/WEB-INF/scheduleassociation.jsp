<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body>
    <div class="container border border-dark my-4">
        <div class="row p-4">

            <div class="row  text-center my-4">
                <div class="col-12 text-start display-6">
                    Schedule Test
                </div>
            </div>
            <form action="/MKCL_Assignment_1/scheduleassoci/save" method="GET" onSubmit="return Validate()">
            <div class="row  text-start my-4">
                <div class="col-md-4 col-12">
                    Exam Event*
                </div>
                <div class="col-md-8 col-12">
                
                <jsp:useBean id="eventservice"
								class="com.app.services.ExamEventService" />
                <c:set var="eventi"
								value="${eventservice.getAllEvents()}"></c:set>
                
                    <select class="form-select" name="examEvent" id="city" onchange="loadDoc(this)">
                        <optgroup id="addoptions">
                        <c:forEach var="trav" items="${eventi}">
                            <option value="${trav.examEventID}" name="${trav.name}">${trav.name}</option>
                            </c:forEach>
                        </optgroup>
                    </select>
                </div>
            </div>
            <div class="row  text-start my-1">
                <div class="col-md-4 col-12">
                    Schedules
                </div>
                <div class="col-md-8 col-12">
                    <select class="form-select" name="scheduleId" id="city1" onchange="setDate(this)">
                        <optgroup id="putoptions">
                        </optgroup>
                    </select>
                </div>
            </div>
            <div class="row  text-start my-1">
                <div class="col-md-4 col-12">
                    Papers
                </div>
                <div class="col-md-8 col-12">
                    <select class="form-select" name="paperId" id="papers">
                        <optgroup id="getoptions">
                        </optgroup>
                    </select>
                </div>
            </div>
            		<p class="text-danger fw-bold" id="Message"></p>
            
            <div class="row  text-start my-3">
                <div class="col-md-4 col-12">

                </div>
                <div class="col-md-8 col-12 text-center">
                    <button class="btn btn-success rounded-pill px-4 py-1">Schedule</button>
                </div>
            </div>
            </form>
            <div class="row  text-start">
                <div class="col text-start">
                    Date : <span id="putDate"></span>
                </div>

            </div>
            
            
            
             <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <th>Sr no</th>
                                <th>Event</th>
                                <th>Paper Name</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                            </thead>
                            <tbody>
                            <jsp:useBean id= "paperservice" class= "com.app.services.ScheduleAssociationService" />  
 					<c:set var="schedule" value="${paperservice.getEventPaperSchedule()}"></c:set>

                           
                            <c:set var="i" value="1"/>
                            <c:forEach var="paper" items="${schedule}">
                            <tr>
                                <td>${i}</td>
                                <td>${paper.event}</td>
                                <td>${paper.paper}</td>
                                <td>${paper.startDate}</td>
                                <td>${paper.endDate}</td>
                            </tr>
                            
                            <c:set var="i" value="${i+1}"/>
                        </c:forEach>
                            </tbody>
                        </table>
                    </div>
  
    </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script >
			
			var list="";
           function loadDoc(hello) {

            $.ajax({
                method: 'GET',
                url: 'http://localhost:8081/MKCL_Assignment_1/schedule/getlist/' + hello.value,
                contentType: 'application/json',
                success: function (result) {
                    let string = `<option value="" disabled selected hidden>Select your option</option>`;
                    document.getElementById("putoptions").innerHTML = string;
                    const arr = result.split(",");
                    for (let i = 0; i < arr.length; i+=3) {
                        var element = arr[i];
                        string += "<option value=" + element + "> Start Date :" + arr[i+1] + "   End Date : "+arr[i+2]+ "</option>"

                    }

                    document.getElementById("putoptions").innerHTML = string;
                },
                error: function ajaxError(jqXHR) {
                    console.error('Error: ', jqXHR.responseText);
                }

            });

			getPaperList(hello.value);
           }
function getPaperList(id){
	$.ajax({
        method: 'GET',
        url: 'http://localhost:8081/MKCL_Assignment_1/papers/listForEventWithFullName/'+ id,
        contentType: 'application/json',
        success: function (result) {
           console.log(result);
            
            result = result.replaceAll("]", "").replaceAll("[", ""); // Removing square brackets
            var arr = result.split(",");

            let string = `<option value="" disabled selected hidden>Select your option</option>`;
            document.getElementById("getoptions").innerHTML = string;
            result = result.substring(0, result.length - 1);
            const arr2 = result.split(",");
            for (let i = 0; i < arr2.length; i+=3) {
                var element = arr2[i];
                string += "<option value=" + element + " id="+element+">" + arr2[i+1] + "</option>"

            }

            document.getElementById("getoptions").innerHTML = string;
            list= string;
        },
        error: function ajaxError(jqXHR) {
            console.error('Error: ', jqXHR.responseText);
        }
    });
}
        
        async function setDate(param){
            
        	document.getElementById("getoptions").innerHTML = list;
            document.getElementById("putDate").innerText =param.options[param.selectedIndex].text;
    		console.log(param.value);
			console.log(document.getElementById("city").value);

			var data={eventId:document.getElementById("city").value,scheduleId:param.value};
			$.ajax({
                method: 'GET',
                url: 'http://localhost:8081/MKCL_Assignment_1/scheduleassoci/getalreadyList',
                contentType: 'application/json',
                data:data,
                success: function (result) {
                   console.log(result);
                   var teavere=result.split(",");
                   for(var m=0;m<teavere.length;m++){
						const element=document.getElementById(teavere[m]);
                	  if(element !=null) element.remove(element.selectedIndex);
                       }
                },
                error: function ajaxError(jqXHR) {
                    console.error('Error: ', jqXHR.responseText);
                }
            });
            }


        function Validate() {
			var accommodationSelect = $("#city");
			const examEvent = accommodationSelect.val();
			var accommodationSelect = $("#city1");
			const schedule = accommodationSelect.val();
			var accommodationSelect = $("#papers");
			const papers = accommodationSelect.val();
			if (examEvent == "" || examEvent == undefined) {
				$("#Message").text("please select the exam event");
				return false;
			} else if (schedule == "" || schedule == undefined) {
				$("#Message").text( "please select the schedule");
				return false;
			} else if (papers == ""
					|| papers == undefined) {
				$("#Message").text("please select papers") ;
				return false;
			} 
			return true;
		}
        </script>
</body>

</html>
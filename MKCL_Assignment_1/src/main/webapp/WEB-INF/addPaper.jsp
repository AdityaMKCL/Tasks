<%@page import="org.hibernate.Session"%>
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

</head>

<body>
	<div class="container mt-3">
		<div class="row p-4 border shadow-sm">
			<h1 class="display-6">Exam Event - Add Paper</h1>
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

			<div class="row text-end">
				<div class="col-12 col-md-6 text-start">
					<button class="btn btn-primary" data-bs-toggle="modal"
						data-bs-target="#exampleModal">
						View Paper <span class="bg-white text-black rounded px-1 fw-bold"
							id="count">0</span>
					</button>
				</div>

				<div class="col-12 col-md-6 ">
					<div class="row text-end">
						<div class="col-md-10 text-end m-0 p-0 w-50">
							<input type="text" class=" form-control rounded-end rounded-pill">
						</div>
						<div class="col-md-2 p-0 m-0 text-start">
							<input type="text"
								class="btn btn-success rounded-start rounded-pill  px-0"
								value="GO!">
						</div>
						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title fs-3" id="exampleModalLabel">Paper
											List</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body text-center">

										<div class="table-responsive">

											<table class="table">
												<thead>
													<th>Sr No</th>
													<th>Paper Name</th>
													<th>Remove Paper</th>
												</thead>

												<tbody id="modelload">

												</tbody>

											</table>
										</div>



									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						<!-- model end  -->
					</div>
				</div>
			</div>

			<div class="row">
				<div class="alert alert-success text-primary fw-bold my-3 "
					style="border: 1px solid rgb(2, 2, 96); color: rgb(2, 2, 96) !important;">Latest
					Published Paper List</div>
			</div>
			<div class="table-responsive">

				<table class="table table-striped"
					style="overflow-y: scroll !important; height: 200px !important;">
					<thead>
						<th>Paper Code</th>
						<th>Paper Name</th>
						<th>Paper Abbrevation</th>
						<th>Add</th>
					</thead>

					<tbody id="newdata">

					</tbody>
					<thead>
						<th>Paper Code</th>
						<th>Paper Name</th>
						<th>Paper Abbrevation</th>
						<th>Add</th>
					</thead>
				</table>
			</div>
			<div class="row text-center">
				<div class="col">
					<a href="http://localhost:8081/MKCL_Assignment_1/"  class="btn btn-secondary rounded-pill px-4">Back</a>
					<input type="button" value="Save" class="btn btn-success rounded-pill px-4" onclick="savepapers()">
					<a href="http://localhost:8081/MKCL_Assignment_1/paperconfig/" class="btn btn-success rounded-pill">Proceed</a>
				</div>
			</div>
		</div>



	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		 	 const map1 = new Map();
         $(document).ready(function () {
                $.ajax({
                    method: 'GET',
                    url: 'http://localhost:8081/MKCL_Assignment_1/papers/list',
                    contentType: 'application/json',
                    success: function (result) {
                       //console.log(result);
                        let string = ``;
                        document.getElementById("newdata").innerHTML = string;
                         result = result.replaceAll("]", "");
                        result = result.replaceAll("[", "");
                            
                        //console.log(result);
                        var arr = result.split(",");
                        var html=``;
                        for (let i = 2; i < arr.length; i+=3) {
                           arr[i-1]=arr[i-1].trim();
                           map1.set(arr[i-1], arr[i-2]);
                             html+=`<tr id="`+arr[i-1]+`">`;
                                html+=`<td>`+arr[i] + `</td>`;
                                html+=`<td>`+arr[i-1] + `</td>`;
                                html+=`<td>`+arr[i] + `</td>`;
                                html+=`<td><input type="checkbox" class="form-check-input" name="`+arr[i-1]+`" id="`+arr[i-1]+`1" onclick="loaddoc(this)"></td>`;
                           html+= `</tr>`;
                        }
                        console.log(html);
                        document.getElementById("newdata").innerHTML += html;
                    },
                    error: function ajaxError(jqXHR) {
                        console.error('Error: ', jqXHR.responseText);
                    }
                });

            })
            
			 var cart= new Set();
            function loaddoc(param){
             cart.add(param.name);
             param.name=param.name.trim();
             console.log(cart);
             $('#'+param.name+'').addClass("d-none");
             console.log('#'+param.name+'')
             const parent=document.getElementById(param.name);
             console.log(parent);
             //data.replace(document.getElementById(param.name),"");
             //console.log(parent.removeChild(child));
             const child=document.getElementById(param.name);
				console.log(child)
             document.getElementById("count").innerText=cart.size;
             //document.getElementById("newdata").innerHTML=data;
				cartModelLoad();
				
             }
			
		 function cartModelLoad(){
			 var html=``;
			 var count=1;
         cart.forEach(function (value) {
        	 html+=`<tr id="`+value+`">`;
             html+=`<td>`+count + `</td>`;
             html+=`<td>`+value + `</td>`;
             html+=`<td><input type="button" class="btn btn-danger" name="`+value+`" id="" onclick="deletedoc(this)" value="Remove"></td>`;
        html+= `</tr>`;
        count++;
        	});
         document.getElementById("modelload").innerHTML=html;
		}
		 function deletedoc( param){			 console.log(param.name);

					const parent = document.getElementById("modelload");
					const child =document.getElementById(param.name);
					console.log(parent.removeChild(child));
		             //document.getElementById("newdata").innerHTML=data;
		             const parent2=document.getElementById("newdata");
		             $('#'+param.name+'').removeClass("d-none");
		             console.log('#'+param.name+'1')
		             cart.delete(param.name);
					cartModelLoad();
					document.getElementById("count").innerText=cart.size;
		            document.getElementById(param.name+"1").checked = false;
			}

		function savepapers(){
			console.log(cart);
			var mySet =new Array();
			cart.forEach((ele)=>{
			    mySet.push(map1.get(ele));
			});
			console.log(mySet);
			var data={papers: mySet.toString(),
					 };
			 $.ajax({
                 method: 'GET',
                 url: 'http://localhost:8081/MKCL_Assignment_1/exameventpaper/savepapers',
                 contentType: 'application/json',
                 data : data,
                 success: function (result) {
                    console.log(result);
                 },
                 error: function ajaxError(jqXHR) {
                     console.error('Error: ', jqXHR.responseText);
                 }
             });
			}
	        
    </script>

</body>

</html>
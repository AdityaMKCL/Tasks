<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>CONVERTER</title>
</head>

<body>
    <div class="container text-center" style="margin-bottom:70px">
<div class="display-5 ">Save Your File To Database</div>
<hr>
        <div class="row d-none m-3">
            <div class="col-6">UserId : </div>
            <div class="col-6"><input name="userId" class="form-control" value="0" /></div>
        </div>
        <div class="row m-3">
            <div class="col-6">NAME : </div>
            <div class="col-6"><input name="name" class="form-control" id="name" /></div>
        </div>
        <div class="row m-3">
            <div class="col-6">CITY : </div>
            <div class="col-6"><input name="city" class="form-control" id="city" /></div>
        </div>
        <div class="row m-3">

            <div class="col-6"><input   class="btn btn-warning" onclick="Addtable()" value="ADD" /></div>
        </div>
        <hr />
        <div class="row">

            <div class=" table-responsive">
                <table class="table table-striped">
                    <thead>
                        
                        <th>NAME</th>
                        <th>CITY</th>
                    </thead>
                    <tbody id="table_body">
                        
                    </tbody>
                </table>
                
            </div>
        </div>
        <div class="row ">
        <div class="col">
            <button class="btn btn-success" onclick="Submit()">SUBMIT</button>
        </div>
        </div>

    </div>
    <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        var arr = new Array();
        function Addtable() {
            var innerhtml = document.getElementById("table_body").innerHTML;
            var name = document.getElementById("name").value;
            var city = document.getElementById("city").value;
            arr.push(name);
            arr.push(city);
            innerhtml += ` <tr>
                            <td>`+ name + `</td>
                            <td>`+ city + `</td>
                        </tr>`;
            document.getElementById("table_body").innerHTML = innerhtml;
        }
        function Submit(){
        const data={data:arr.toString()}
        console.log(data);
            $.ajax({
                method: 'GET',
                data:data,
                url: 'http://localhost:8081/ExelSheetPractice/submit',
                //contentType: 'application/json',
                xhrFields:{
                    responseType: 'blob'
                },
                success: function (result) {
                   console.log(result);
                   var blob = new Blob([result], { type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" });

                   var a = document.createElement('a');
                   a.href = window.URL.createObjectURL(blob);
                   a.download = 'test.xlsx';

                   document.body.appendChild(a);

                   a.click();

                   document.body.removeChild(a);
                   
                },
                error: function ajaxError(jqXHR) {
                    console.error('Error: ', jqXHR.responseText);
                }

            });
        }
    </script>
</body>

</html>
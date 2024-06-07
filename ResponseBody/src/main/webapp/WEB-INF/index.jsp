<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>
<body>
	<div class="container my-5">
        <form action="http://localhost:8081/ResponseBody/submit" method="post">

              <div class="row m-3">
                <div class="col-6 text-center">Name : </div>
                <div class="col-6"><input name="name" class="form-control" value="0" /></div>
            </div>
            <div class="row m-3">
                <div class="col-6 text-center">CITY : </div>
                <div class="col-6"><input name="city" class="form-control" id="city" /></div>
            </div>
            <div class="row m-3">
                <div class="col-6 text-center">AGE : </div>
                <div class="col-6"><input type="number" name="age" class="form-control" id="name" /></div>
            </div>

            <div class="row m-3">
                <div class="col-6 text-center">DEPARTMENT : </div>
                <div class="col-6"><input  name="department" class="form-control" id="name" /></div>
            </div>
            <div class="row m-3 text-center">
                <div class="col"><button type="submit" class="btn btn-success rounded-pill" >Submit</button>
                </div>
            </div>
        </form>

    </div>
</body>
</html>
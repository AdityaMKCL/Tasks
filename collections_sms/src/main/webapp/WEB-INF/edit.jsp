<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>
    <div class="container">
        <form class="section mx-5 " action="/collections_sms/editstudent" method="get">

             <div class="row">

                <div class="col-6 display-6">
                    First Name :
                </div>
                <div class="col-6">
                    <input class="form-control" placeholder="Enter First name" name="firstName" value='${student.firstName}'/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Last Name :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter Last name" name="lastName" value='${student.lastName}'/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Mobile :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter Mobile no." name="mobileNo" value='${student.mobileNo}'/>
                </div>
            </div>
            <div class="row">

                <div class="col-6 display-6">
                    Email :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter email" name="email" value='${student.email}'/>
                </div>
            </div>
            <div class="row">
                <div class="col-6 display-6">
                    Marks :
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Enter marks" name="marks" value='${student.marks}'/>
                    <button type="submit" value="submit" class="btn btn-success m-3">Submit</button>
                </div>
            </div>
            

        </form>
      
    </div>
    <script src="httpstudent://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>

</html>
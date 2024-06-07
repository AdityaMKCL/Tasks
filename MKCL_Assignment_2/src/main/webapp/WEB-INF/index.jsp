<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    <div class="container">

        <h1 class="display-6">Testing form</h1>
        <form action="see"  method="POST" modelattr="candidate" class="form-control">
            <div class="row m-3">
                <div class="col-md-6 col-12">
                    NAME :
                </div>
                <div class="col-md-6 col-12">
                    <input type="text" class="form-control" name="name">
                </div>
            </div>
            <div class="row m-3">
                <div class="col-md-6 col-12">
                    GOOD NAME :
                </div>
                <div class="col-md-6 col-12">
                    <input type="text" class="form-control" name="goodName">
                </div>
            </div>
          
               <input type="submit" class="btn btn-danger" value="SUBMIT"></button>
          
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>
</html>


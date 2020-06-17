<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Excel取込</title>
    <style type="text/css">
        .container {
            width: 750px;
            max-width: none !important;
        }
    </style>
    <script type="text/javascript">
        function CloseWindow() {
          window.close();
        }
    </script>
  </head>
  <body style="background-color: gainsboro;">
    <br>
    <div class="container panel panel-default" style="background-color: white;">
    <div class="form-group container">
    <br><h5>商品マスタExcel取込</h5>
    <hr>
    <form name="excelInput" method="POST" action="SalesCube2020/SalesCube?action="productexcelinput">
        <label for="file1"></label>
        <input type="file" id="file1" class="form-control-file"><br>
        <input type="submit" name="excelinput" value="取込" class="btn btn-outline-secondary" onClick="CloseWindow()">
        <input type="button" value="閉じる" class="btn btn-outline-secondary" onClick="CloseWindow()">       
    </form>
    </div><br>
    </div>
  </body>
</html>
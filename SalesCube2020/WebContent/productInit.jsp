<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>SalesCube 初期値</title>
    <style type="text/css">
      .menuGroup {
          -moz-border-bottom-colors: none;
          -moz-border-left-colors: none;
          -moz-border-right-colors: none;
          -moz-border-top-colors: none;
          background-color: #FFFFFF;
          border-color: #FFFFFF -moz-use-text-color #DDDDDD;
          border-image: none;
          border-left: medium none;
          border-radius: 5px;
          border-right: medium none;
          color: #BBBBBB;
          cursor: pointer;
          margin: 5px;
          padding: 5px;
      }
	  
 		.container {
			 width: 480px;
			 max-width: none !important;
		}
    </style>
  </head>
  <br>
  <body style="background-color: gainsboro;">
		<br>
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<br>
			<div class="panel-heading row mb-2 col-6">
				<h5>マスタ初期値設定</h5>
			</div>
			<hr>
			<div class="panel-body center-block" >
				< <form action="/SalesCube2020/SalesCube?action=productinit">  method="post">
					<div class="row">
						<div class="col-12">
							<label class="sr-only" for="inlineFormInputGroup">unitCategory</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">単位</div>
								</div>
					<select class="custom-select" name="useFlag">
                        <option selected></option>                        
                        <option value="1">本</option>
                        <option value="2">個</option>
                        <option value="3">箱</option>
                    </select>
							</div>
						</div>
					</div>
					<br>
				</form>
			</div>
			<div align="right">
				<input type="submit" value="初期化" class="btn btn-outline-secondary">&emsp;
				<input type="submit" value="更新" class="btn btn-outline-secondary">&emsp;
				<input type="submit" value="閉じる" class="btn btn-outline-secondary">&emsp;
			</div>
			<br>
		</div>
	</body>
</html>
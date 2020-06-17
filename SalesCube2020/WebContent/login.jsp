<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script>
        function initForm() {
    	   if(!confirm("入力内容を初期化してよろしいですか？")){
           	   return;
    	   }
      	$("[name='userId']").val("");
        $("[name='password']").val("");
        }
    </script>
  </head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>SalesCube　ログイン</title>
    <style type="text/css">
       .loginGroup{
          -moz-border-bottom-colors: none;
          -moz-border-left-colors: none;
          -moz-border-right-colors: none;
          -moz-border-top-colors: none;
          background-color: white;
          border-color: #FFFFFF -moz-use-text-color #DDDDDD;
          border-image: none;
          border-left: medium none;
          border-radius: 5px;
          border-right: medium none;
          color: rgb(1, 201, 78);
          cursor: pointer;
          margin: 5px;
          padding: 5px;
       }

       .container {
	   width: 1120px;
	   max-width: none !important;
	   }
	   
    </style>
    <body style="background-color: gainsboro;">
       <!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       <br><br>
       
       <!-- <div style="padding-left: 20px"> -->
       <!-- エラーメッセージを表示 -->
       <div style="width:100%; text-align:center; margin-bottom:20px;">
				 <span class="action_errors" style="color: red">${loginError}<br></span>
       </div>
       
	  <div class="container">
      <div class="loginGroup" style="margin-left: auto; margin-right: auto; width: 65%;">
            <div class="loginGroup" style="margin-left: auto; margin-right: auto; text-align: center;">
                <h2>Welcome to SalesCube</h2>
            </div>
            <hr>
            <br>
          <form name="loginData" method="POST" action="login">
              <table class="forms" style="width: 250px;margin-left: auto; margin-right: auto;text-align: left;" summary="login_form">
                <colgroup>
                   <col span="1" style="width: 40%">
                   <col span="1" style="width: 40%">
                </colgroup>
                <tr>
                    <th><div class="col_title_right">ユーザーID</div></th><!-- ユーザーID -->
                    <td><input type="text" name="userId" tabindex="100" value="" style="width: 120%; ime-mode: disabled; background-color: #FFFFFF;"class="form-control" required></td>
                </tr>
                <tr>
                    <th><div class="col_title_right">パスワード</div></th><!-- パスワード -->
                    <td><input type="password" name="password" tabindex="101" value="" id="password" style="width: 120%; ime-mode: disabled; background-color: #FFFFFF;"class="form-control" required></td>
                </tr>
              </table>
              <br>
              <div style="text-align: center; width: 200px;margin-left : auto ; margin-right : auto ;">
                 <input type="button" name="resetButton" tabindex="150" value="初期化" onclick="initForm();" class="btn btn-outline-success">&emsp;
				 <input type="submit" name="login" tabindex="151" value="ログイン" id="login" class="btn btn-outline-success">
			  </div>
              
          </form>
        <br>
      </div>
	  </div>

    </body> 
</html>
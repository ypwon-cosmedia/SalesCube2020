<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!doctype html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>セット商品情報</title>
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
	   width: 1120px;
	   max-width: none !important;
	   }
    </style>
  </head>
  <body style="background-color: gainsboro;">
  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/SalesCube2020/SalesCube?action=menu">SalesCube2020</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              	マスター
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=product">商品</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=setProduct">セット商品</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=customer">顧客</a>
            </div>
          </li>
        </ul>
        <span class="navbar-text">
          <svg class="bi bi-person-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
          </svg>
        	${userInfo.nameKNJ} &nbsp;     	
        </span>
        <form class="form-inline" action="/SalesCube2020/SalesCube?action=logout" method="post">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
    </nav>
	<br>
    <div class="container" id="main_function">
      <h3 class="float-left">セット商品</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm();">F1<br>リセット</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="window.history.back();">F2<br>戻る</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="doSubmit();">F3<br>更新</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F4<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F5<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F6<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F7<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F8<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F9<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F10<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F11<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F12<br></button>
        </div>
      </div>
      <br><br><br>
      </div>
      <form action="/SalesCube2020/SalesCube?action=modifySetProduct" name="mainform" method="post">
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<div class="panel-heading row mb-2 col-4">
				<h5><br>セット商品情報</h5>
			</div>
			<hr>
			<div class="panel-body">
				
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">セット商品コード</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup" name="productCode" value="${productCode}" readonly>
							</div>
						</div>
						<div class="col-8">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">セット商品名</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup" name="productName" value="${productName}" readonly>
							</div>
						</div>
					</div>

					</div>
			
		</div><br></div>
		<br>
		<br>
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<div class="panel-heading row mb-2 col-4">
				<h5><br>セット内容</h5>
			</div>
			<hr>
			
				<table id="mytable" class="table table-bordered">
					<thead class="thead-dark">
						<tr>
						<th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('customerCode');">No</th>
						<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('customerName');">商品コード</th>
		
						<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('customerTel');">商品名</th>
						<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('customerPcName');">数量</th>
						<th scope="col" class="rd_top_right th_back_black" style="cursor: pointer; height: 30px;">&nbsp;</th>
						</tr>
					</thead>
						
							<tbody>
								<c:forEach var="res" items="${result}" varStatus="status">   
									<tr>
										<td scope="row" id="t${status.count}">${status.count}</td>
										<td style="white-space: normal; text-align: left;" nowrap> 
											<div class="input-group mb-3">
												<input type="text" class="form-control" value="${res.productCode}" name="code" id="input${status.count}" required readonly>
												<button type="button" class="btn btn-outline-secondary" value="${res.productCode + 1000}" id="button${status.count}" name="codeButton" onclick="disp(this);">検索</button>
											  </div>
										</td>
										<td style="white-space: normal; text-align: left;"><input type="text"  class="form-control" id="inputs${status.count}" name="name" value="${res.productName}" required readonly></td>
										<td style="white-space: normal; text-align: left;"><input type="text"  class="form-control" id="inlineFormInputGroup" name="quantity" value="${res.quantity}" required></td>
										<td style="text-align: center">
												<button type="button" class="btn btn-outline-secondary" onclick="deleteLine(this);">削除</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						
					</table>
				
				<button type="button" class="btn btn-outline-secondary float-right" id='btn-add-row'>行追加</button>
				<br>
				<br>

				
				<div align="right">
					<input type="submit" value="リセット" class="btn btn-outline-secondary" onclick="initForm();">
					<input type="submit" value="更新" class="btn btn-outline-secondary">
				</div>
			
		</div><br></div><br>
		</form>
	<input type="hidden" value="" id="tmphidden">
	</body>
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
		  $('#btn-add-row').click(function() {
			  var tableNo = $("#mytable tr").length
			  var tmpNo = tableNo + 1000;
		    $('#mytable > tbody:last').append('<tr><td scope="row">' + tableNo + '</td><td style="white-space: normal; text-align: left;" nowrap> <div class="input-group mb-3"><input type="text" class="form-control" value="" name="code" id="input'+tableNo+'" required readonly><button type="button" class="btn btn-outline-secondary" id="button' + tableNo + '" value="button' + tableNo + '" name="codeButton" onclick="disp(this);">検索</button></div></td><td style="white-space: normal; text-align: left;"><input type="text"  class="form-control" id="inputs' + tableNo + '" name="name" value="${res.productName}" required readonly></td><td style="white-space: normal; text-align: left;"><input type="text"  class="form-control" id="inlineFormInputGroup" name="quantity" value="${res.quantity}" required></td><td style="text-align: center"><button type="button" class="btn btn-outline-secondary" onclick="deleteLine(this);">削除</button></td></tr>');});
		</script>
		<script type="text/javascript">
		var data;
		function deleteLine(obj){
			if(!confirm("この行を削除してよろしいですか？")){
				return;
			}
			var tr = $(obj).parent().parent();
			var table = document.getElementById("mytable").rows.length;
			
			tr.remove();
			
			for(var i = 1; i <= table; i++){
				$("#mytable tr:eq("+ i + ") td:eq(0)").html(i);
			}
			
			
		}
		function initForm() {
			var test = confirm("入力内容を初期化してよろしいですか？");
			test;
			if(test == false){
				return;
			} else
				history.go(0);
		}
		function doSubmit(){
			var form = document.mainform;
			
			form.submit();
		}
		function disp(element){			
			var openWin;
			var pData = element.id;
			document.getElementById("tmphidden").value=document.getElementById(pData).id;
			openWin = window.open("http://localhost:8080/SalesCube2020/SalesCube?action=searchforset&pData="+pData , "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=1180,height=480");
		}
		
		function setValue(status){
			data = status;
			alert(data);
		}
		</script>
		
</html>
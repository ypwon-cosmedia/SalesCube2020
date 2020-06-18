<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
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
	   <script>
	   function initForm() {
   	   	if(!confirm("入力内容を初期化してよろしいですか？")){
          	   	return;
   	  	}
   	   	document.sampleform.reset();
       	}
   
	   </script>
  </head>
  <body style="background-color: gainsboro;">
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">SalesCube2020</a>
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
              <a class="dropdown-item" href="#">商品</a>
              <a class="dropdown-item" href="#">セット商品</a>
              <a class="dropdown-item" href="#">顧客</a>
            </div>
          </li>
        </ul>
        <span class="navbar-text">
          <svg class="bi bi-person-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
          </svg>
          システム管理者　
        </span>
        <form class="form-inline">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
	</nav>
	<br>
    <div class="container" id="main_function">
      <h3 class="float-left">顧客検索</h3>
    
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">

		  <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F2<br>戻る</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F3<br>登録</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F4<br>削除</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F5<br>初期値</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F6<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F7<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F8<br>履歴出力</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F9<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F10<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F11<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F12<br></button>
        </div>
      </div>
      <br><br><br>
      </div>
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<div class="panel-heading row mb-2 col-4">
				<h5><br>顧客情報</h5>
			</div>
			<hr>
			<div class="panel-body">
				<form action="" name="sampleform" method="post">
				<form action="/SalesCube2020/SalesCube?action=searchProduct" name="sampleform" method="post">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客コード</div>
								</div>
							<input type="text" name="customerCode" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客名</div>
								</div>
                            <input type="text" name="customerName" class="form-control" id="inlineFormInputGroup">
                            </div>
						</div>

                        <div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客名カナ</div>
								</div>
							<input type="text" name="customerKana" class="form-control" id="inlineFormInputGroup">
							</div>    
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">事業所名</div>
								</div>
							<input type="text" name="officeName" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">事業所名カナ</div>
								</div>
                            <input type="text" name="officeNameKana" class="form-control" id="inlineFormInputGroup">
                            </div>
						</div>

                        <div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">TEL</div>
								</div>
							<input type="text" name="tel" class="form-control" id="inlineFormInputGroup">
							</div>    
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">担当者</div>
								</div>
							<input type="text" name="PCName" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">担当者カナ</div>
								</div>
                            <input type="text" name="PCNameKana" class="form-control" id="inlineFormInputGroup">
                            </div>
						</div>

                        <div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">FAX</div>
								</div>
							<input type="text" name="fax" class="form-control" id="inlineFormInputGroup">
							</div>    
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客ランク</div>
								</div>
								<select class="custom-select" name="rankCategory">
									<option selected></option>
									<c:forEach items="${rank}" var="rank">
										<option value="0">${rank.rankName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-6">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">支払条件</div>
								</div>
								<select class="custom-select" name="cutoffGroup">
									<option value="null"></option>
									<option value="1">10日締め翌月10日</option>
									<option value="2">20日締め翌月20日</option>
									<option value="3">25日締め翌月末</option>
									<option value="4">月末締め翌月末日</option>
									<option value="5">月末締め翌々月5日</option>
									<option value="6">その他</option>
								</select>
                            </div>
						</div>
					</div>
						
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">振込名義</div>
								</div>
								<input type="text" name="paymentName" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">備考</div>
								</div>
								<input type="text" name="remarks" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
				</form>	
			</div>
		
		<br>
		<br>
		<!-- <div class="container" style="background-color: white;"><div class="panel panel-default" > -->
			
			
			<div class="panel-body">

					<div align="right">
						<button type="button" class="btn btn-outline-secondary" onclick="initForm()">初期化</button>
						<input type="hidden" value="10" id="rowCount">
						<input type="submit" value="検索" class="btn btn-outline-secondary">
					</div>
			</div>
		<!-- </div><br></div><br> --><br><br>
		<div class="container">
            <div class="float-left" style="position:static; left: 0px;">検索結果件数： ${fn:length(customerList)}件</div>
  
         	<div class="rounded float-right">
                ページあたりの表示件数
                <select id="rowCount" name="rowCount" onchange="moveRowCount(this)">
                    <option value="10">10</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>
			</div>
		</div>
    </div></div><br><br>
    

    </div></div>
<br><br>

		<div class="container" style="background-color: rgb(255, 255, 255);">
  			<table id="order_detail_info" class="table table-bordered">
				<thead class="thead-dark">
    				<tr>
						<th style="cursor: pointer; height: 30px;" onclick="sort('customerCode');">顧客コード</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('customerName');">顧客名</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('tel');">TEL</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('PCName');">担当者</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('salesCMCategory');">取引区分</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('cutoffGroup');">支払条件</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('officeName');">事業所名</th>
						<th style="cursor: pointer; height: 30px;" onclick="sort('deptName');">部署名</th>
						<th style="cursor: pointer; height: 30px;">&nbsp;</th>
					</tr>
				</thead>
				<c:forEach items="${customerList}" var="customer">
    				<tr>
						<th scope="row">${customer.customerCode}</th>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.customerName}&nbsp;</td>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.tel}&nbsp;</td>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.PCName}&nbsp;</td>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.salesCMCategory}&nbsp;</td>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.cutoffGroup}&nbsp;</td>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.officeName}&nbsp;</td>
						<td style="white-space: normal; text-align: left;">&nbsp;${customer.deptName}&nbsp;</td>
						<td style="text-align: center">
							<div style="display:inline-flex">
								<form action="/SalesCube2020/SalesCube?action=moveModifyCustomer">
									<input type="hidden" name="customer" value="${customer.cutomerCode}">	
									<input type="submit" class="btn btn-outline-secondary" value="編集">
								</form>
								<form action="/SalesCube2020/SalesCube?action=deleteCustomer">
									<input type="hidden" name="customer" value="${customer.cutomerCode}">	
									<input type="submit" class="btn btn-outline-secondary" value="削除">
								</form>
							</div>
						</td>
   					</tr>
   				</c:forEach> 
			</table>
		</div>
<script type="text/javascript">
function moveRowCount(rowCount) {
	const rowCount = rowCount.value;
	document.getElementById("rowCount").value = rowCount;
}

function initForm() {
	if(!confirm("入力内容を初期化してもよろしいですか？")){
		return;
	}
	document.sampleform.reset();
}
</script>
	</body>
</html>

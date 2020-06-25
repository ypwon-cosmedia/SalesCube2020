<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="master.product.beans.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

		<title>商品検索</title>

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
			<h3 class="float-left">商品</h3>
		
			<!--FNボタン-->
			<div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
			
				<div class="btn-group mr-2 " role="group" aria-label="First group">
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" onClick="initForm();">F1<br>初期化</button>
					<button type="submit" class="btn btn-secondary" style="font-size: 12px;" onClick="searchForm()">F2<br>検索</button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" onClick="addForm()">F3<br>追加</button>
					<button type="submit" class="btn btn-secondary" style="font-size: 12px;" onClick="excelForm()">F4<br>Excel出力</button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F5<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F6<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F7<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F8<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F9<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F10<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F11<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F12<br></button>
				</div>
			</div>
			<br><br><br>
		</div>
		<!-- エラーメッセージを表示 -->
       	<div style="width:100%; text-align:center; margin-bottom:20px;">
				 <span class="action_errors" style="color: red">${addmodifyError}</span>
				 <span class="action_errors" style="color: red">${addmodifysuccsess}</span>
				 <span class="action_errors" style="color: red">${addmodifyinterror}</span>
		</div>
		<!--商品検索-->
		<br><br>
		<div class="container panel panel-default" style="background-color: white;">
			<div class="panel-heading row mb-2 col-4">
				<h5><br>商品情報</h5>
			</div>
			<hr>
			<div class="panel-body">
				<form name="main" method="post" id="main">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productCode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
										<div class="input-group-text">商品コード</div>
								</div>
								<input type="text"  class="form-control" id="inlineFormInputGroup" name="productCode">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productName</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">商品名</div>
								</div>
								<input type="text"  class="form-control" id="inlineFormInputGroup" name="productName">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">商品カナ</div>
								</div>
								<input type="text" class="form-control" id="inlineFormInputGroup" name="productKana">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierCode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入先コード</div>
								</div>
								<input type="text" class="form-control" id="inlineFormInputGroup" name="supplierCode">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierName</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入先名</div>
								</div>
								<input type="text" class="form-control" id="inlineFormInputGroup" name="supplierName">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productStandardCategory</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">標準化分類</div>
								</div>
								<select class="custom-select" name="productStandardCategory">
									<option selected></option>
									<c:forEach items="${productStandardCategory}" var="prdct">
										<option value="${prdct.productStandardCategoryCode}">${prdct.productStandardCategoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productStatusCategory</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">状況</div>
								</div>
								<select class="custom-select" name="productStatusCategory">
									<option selected></option>
									<c:forEach items="${productStatusCategory}" var="prdct">
										<option value="${prdct.productStatusCategoryCode}">${prdct.productStatusCategoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">保管</div>
								</div>
								<select class="custom-select" name="productStockCategory">
									<option selected></option>
									<c:forEach items="${prosearch}" var="prdct">
										<option value="${prdct.productStockCategoryCode}">${prdct.productStockCategoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">setTypeCategory</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">セット分類</div>
								</div>
								<select class="custom-select" name="setTypeCategory">
									<option selected></option>
									<c:forEach items="${setTypeCategory}" var="prdct">
										<option value="${prdct.setTypeCategoryCode}">${prdct.setTypeCategoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label class="sr-only" for="inlineFormInputGroup">remarks</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">備考</div>
								</div>
								<input type="text" class="form-control" id="inlineFormInputGroup" name="remarks">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label class="sr-only" for="inlineFormInputGroup">product1</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">分類（大）</div>
								</div>
								<select class="custom-select" name="product1" id="product1" onchange="selectPro1();">
									<option selected></option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label class="sr-only" for="inlineFormInputGroup">product2</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">分類（中）</div>
								</div>
								<select class="custom-select" name="product2" id="product2" onchange="selectPro2();">
									<option selected></option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label class="sr-only" for="inlineFormInputGroup">product3</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">分類（小）</div>
								</div>
								<select class="custom-select" name="product3" id="product3">
									<option selected></option>
								</select>
							</div>
						</div>
					</div>
					<div class="rounded float-right">
						<button type="button" class="btn btn-outline-secondary" onClick="initForm();">初期化</button>
						<input type="submit" value="検索" class="btn btn-outline-secondary" onclick="form.action='/SalesCube2020/SalesCube?action=searchProduct';">
					</div><br>
				</form><br>
			</div><br>
		</div><br>

		<!--商品検索結果-->
		<div class="container">
			<div class="float-left" style="position:static; left: 0px;">
				検索結果件数：${fn:length(search)}件
			</div>
			<div class="rounded float-right">
				ページあたりの表示件数
				<select id="rowCount" name="rowCount">
					<option value="10">10</option>
					<option value="50">50</option>
					<option value="100" selected=" ">100</option>
				</select>
			</div>
		</div>

		<!--商品検索結果テーブル-->
		<br><br>
		<div class="container" style="background-color: rgb(255, 255, 255);" id="prosort">
			<table id="order_detail_info" class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col" class="rd_top_left th_back_black sort" style="cursor: pointer; height: 30px;" data-sort="productCode">商品コード</th>
						<th scope="col" class="th_back_black sort" style="cursor: pointer; height: 30px;" data-sort="productName">商品名</th>
						<th scope="col" class="th_back_black sort" style="cursor: pointer; height: 30px;" data-sort="supplierName">仕入先</th>
						<th scope="col" class="th_back_black sort" style="cursor: pointer; height: 30px;" data-sort="product1">分類（大）</th>
						<th scope="col" class="th_back_black sort" style="height: 30px;">備考</th>
						<th scope="col" class="rd_top_right th_back_black sort" style="cursor: pointer; height: 30px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody class="list">
				 <c:forEach items="${search}" var="prdct">
					<tr>
						<td class="productCode" style="white-space: normal; text-align: left;">${prdct.productCode}</td>
						<td class="productName" style="white-space: normal; text-align: left;">${prdct.productName}</td>
						<td class="supplierName" style="white-space: normal; text-align: left;">${prdct.supplierName}</td>
						<td class="product1" style="white-space: normal; text-align: left;">${prdct.product1}</td>
						<td style="white-space: normal; text-align: left;">${prdct.remarks}</td>
						<td style="text-align: center">
							<div style="display:inline-flex">
								<form action="/SalesCube2020/SalesCube?action=moveModifyProduct" method="post">
									<input type="submit" value="編集" class="btn btn-outline-secondary">
									<input type="hidden" id="productCode" name="productCode">
								</form>
								<form action="/SalesCube2020/SalesCube?action=deleteProduct" method="post">
									<input type="submit" value="削除" class="btn btn-outline-secondary">
									<input type="hidden" id="productCode" name="productCode">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

	</body>
	
	<script>
	var mylist = [];
	window.onload = function(){
		var loop=0;
		
		<c:forEach var="test" items="${all}" >
		  mylist[loop] = {
				    cat1:"${test.classCode1}",
				    cat2:"${test.classCode2}",
				    cat3:"${test.classCode3}",
				    catName:"${test.classCodeName}",	
				  };
		  		loop++;  	 
		</c:forEach>
		var list = mylist
		var objSel = document.getElementById("product1");
					
		for(var i in list) {
			if(list[i].cat1 != "" && list[i].cat2 == ""){
				var objOption = document.createElement("option");
				objOption.text = list[i].catName;
				objOption.value = list[i].cat1;
				
				objSel.add(objOption);
			}
		}
	}
		//カテゴリー
		function selectPro1(){
	
			var list = mylist
			var objSel = document.getElementById("product2");
			var objSel2 = document.getElementById("product3");
			var sel1 = document.getElementById("product1").value;
			
			for(i=objSel.length; i > 0; i--){
				objSel.options[i]=null;
			}
			
			for(i=objSel2.length; i > 0; i--){
				objSel2.options[i]=null;
			}
			
			for(var i in list) {
				if(list[i].cat1 == sel1 && list[i].cat2 != "" && list[i].cat3 == ""){
					var objOption = document.createElement("option");
					objOption.text = list[i].catName;
					objOption.value = list[i].cat2;					
					objSel.add(objOption);
				}
			}

		}	
		function selectPro2(){
			var list = mylist
			
			var objSel = document.getElementById("product3");
			var sel1 = document.getElementById("product1").value;
			var sel2 = document.getElementById("product2").value;
			
			for(i=objSel.length; i > 0; i--){
				objSel.options[i]=null;
			}
			
			for(var i in list) {
				if(list[i].cat1 == sel1 && list[i].cat2 == sel2 && list[i].cat3 != ""){
					var objOption = document.createElement("option");
					objOption.text = list[i].catName;
					objOption.value = list[i].cat3;
					
					objSel.add(objOption);
				}
			}
		}			
		//入力値の初期化
		function initForm() {
			var test = confirm("入力内容を初期化してよろしいですか？");
			test;
			if(test == false){
				return;
			} else
			window.location.href = '/SalesCube2020/SalesCube?action=product';
		}
		
		//検索
		function searchForm(){
			window.location.href = '/SalesCube2020/SalesCube?action=searchProduct';
		}
		
		 //追加
		function addForm() {
			window.location.href = '/SalesCube2020/SalesCube?action=moveAddProduct';
		}
		 
		 //Excel出力
		 function excelForm(){
			 if(!confirm("この検索条件で商品をCSV出力しますか？")){
				 return;
			 }
			//window.location.href = '/SalesCube2020/SalesCube?action=productExcelOutput';
			var form = document.getElementById("main");
			
			form.action="/SalesCube2020/SalesCube?action=productExcelOutput";
			form.method="post";
			
			form.submit();
		 }
		 
		
	$(function() {
	    var temp = "${Category1}"; 
	    $("#product1").val(temp);
	})
	$(function() {
	    var temp = "${Category2}"; 
	    $("#product2").val(temp);
	});
	</script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"></script>
	<script>
	//ソート
	var options = {
			 valueNames: [ 'productCode', 'productName' , 'supplierName' , 'product1' ]
		};
		var prosort = new List('prosort', options);
	</script>
		
</html>
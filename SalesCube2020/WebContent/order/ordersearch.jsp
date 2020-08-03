<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link rel="import" href="C:/Users/cosmedia/Desktop/bootstrap-4.0.0-dist/menu.html">
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
	   .sort.desc:after {
		  content:"▼";
		}
		.sort.asc:after {
		  content:"▲";
		}
    </style>
    
<title>受注検索</title>
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
			<li class="nav-item dropdown">
			  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				受注
			  </a>
			  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="C:\Users\cosmedia\Desktop\共有\LINE WORKS Drive\. Shared_folder\2020年共有fileserver\SalesCube\SalesCube\受注\HTML\orderinput.html">受注入力</a>
				<a class="dropdown-item" href="C:\Users\cosmedia\Desktop\共有\LINE WORKS Drive\. Shared_folder\2020年共有fileserver\SalesCube\SalesCube\受注\HTML\ordersearch.html">受注検索</a>
				<a class="dropdown-item" href="C:\Users\cosmedia\Desktop\共有\LINE WORKS Drive\. Shared_folder\2020年共有fileserver\SalesCube\SalesCube\受注\HTML\onlineorderdataimport.html">オンライン受注データ取込</a>
			  </div>
			</li>
			<li class="nav-item dropdown">
			  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				見積
			  </a>
			  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="#">見積入力</a>
				<a class="dropdown-item" href="#">見積検索</a>
				<a class="dropdown-item" href="#">単価照会</a>
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
      <h3 class="float-left">受注検索</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initPage();">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="submitForm();">F2<br>検索</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="excelOut();">F3<br>Excel出力<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" data-toggle="modal" data-target="#setSlipConfiguration">F4<br>設定<br></button>
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
      <form action="#" method="post" name="mainform" id="mainform">
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<div class="panel-heading row mb-2 col-4">
				<h5><br>検索条件</h5>
			</div>
			<hr>
			<div class="panel-body">
				<div class="row">
                       <div class="col-2">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                   <div class="input-group-text">検索対象</div>
                                   <select id="select_view">
                                       <option value="伝票">伝票</option>
                                       <option value="明細">明細</option>
                                   </select>
						    </div>
					    </div>
					</div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">受注番号</div>
							</div>
						<input type="number" class="form-control" id="inlineFormInputGroup" name="data1" pattern="[]{0,10}"maxlength="10">
						</div>
					</div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">受付番号</div>
							</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup" name="data1" maxlength="30">
						</div>
                    </div>
				</div>	
            </div>
            <div class="panel-body">
				<div class="row">
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">受注日</div>
							</div>
						<input type="date"  class="form-control" id="inlineFormInputGroup" name="data1" max="9999-12-31">
						</div>
                    </div>
                    ~
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">

						<input type="date"  class="form-control" id="inlineFormInputGroup" name="data1" max="9999-12-31">
						</div>
                    </div>
				</div>	
            </div>
            <div class="panel-body">
				<div class="row">
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">出荷日</div>
							</div>
						<input type="date"  class="form-control" id="inlineFormInputGroup" name="data1" max="9999-12-31">
						</div>
                    </div>
                    ~
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">

						<input type="date"  class="form-control" id="inlineFormInputGroup" name="data1" max="9999-12-31"> 
						</div>
                    </div>
				</div>	
            </div>
            <div class="panel-body">
				<div class="row">
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">納期指定日</div>
							</div>
						<input type="date"  class="form-control" id="inlineFormInputGroup" name="data1" max="9999-12-31">
						</div>
                    </div>
                    ~
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">

						<input type="date"  class="form-control" id="inlineFormInputGroup" name="data1" max="9999-12-31">
						</div>
                    </div>
				</div>	
            </div>
            <div class="panel-body">
				<div class="row">
                    <div class="col-4">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                   <div class="input-group-text">顧客コード</div>
                            </div>
                            <input type="text" class="form-control" id="customerCodeInput" name="data1" maxlength="15">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setQuotationCondition" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px">
							</button>
					    </div>
					</div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">顧客名</div>
							</div>
                            <input type="text"  class="form-control" id="customerNameInput" name="data1" maxlength="60">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setQuotationCondition" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px">
							</button>
						</div>
					</div>                  
				</div>	
			</div>
			<div class="panel-body">
				<div class="row">
                    <div class="col-12">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">取引区分</div>
							</div>
							&nbsp;&nbsp;&nbsp;
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">掛売</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">現金</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">サンプル</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">代引き</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">クレジット</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">先入金</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								<label class="form-check-label" for="inlineCheckbox1">通販サイト1経由</label>
							</div>
                        </div>                        
                    </div>                  
				</div>	
			</div>
			<div class="panel-body">
				<div class="row">
                    <div class="col-4">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                   <div class="input-group-text">商品コード</div>
                            </div>
                            <input type="text"  class="form-control" id="productCodeInput" name="data1" maxlength="20">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px"></button>
					    </div>
					</div>
					<div class="col-2"></div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">商品名</div>
							</div>
                            <input type="text"  class="form-control" id="productNameInput" name="data1" maxlength="60">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px"></button>
						</div>
					</div>                  
				</div>	
			</div>
			<div class="panel-body">
				<div class="row">
                       <div class="col-6">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                <div class="input-group-text">分類(大)</div>
                                <select>
									<option></option>
								    <option>サンプル大分類</option>
                                </select>
						    </div>
					    </div>
					</div>
				</div>	
			</div>
			<div class="panel-body">
				<div class="row">
                       <div class="col-6">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                <div class="input-group-text">分類(中)</div>
                                <select>
									<option></option>
									<option>サンプル中分類</option>
								</select>
						    </div>
					    </div>
					</div>
				</div>	
			</div>
			<div class="panel-body">
				<div class="row">
                       <div class="col-6">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                <div class="input-group-text">分類(小)</div>
                                <select>
									<option></option>
									<option>サンプル小分類</option>
								</select>
						    </div>
					    </div>
					</div>
				</div>	
			</div>
			<div class="panel-body">
				<div class="row">
                       <div class="col-4">
						<label class="sr-only" for="inlineFormI4putGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
                                   <div class="input-group-text">仕入先コード</div>
                            </div>
                            <input type="text"  class="form-control" id="supplierCodeInput" name="data1" maxlength="10">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchSupplier" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px"></button>
					    </div>
					</div>
					<div class="col-2"></div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">仕入先名</div>
							</div>
                            <input type="text"  class="form-control" id="supplierNameInput" name="data1" maxlength="60">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchSupplier" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px"></button>
						</div>
					</div>                
				</div>	
			</div><br>
			<div align="right">
				<input type="button" value="初期化" class="btn btn-outline-secondary" onclick="initForm();">
				<input type="submit" value="検索" class="btn btn-outline-secondary">
			</div>
			<br>
		</div>
		</div>

		<br>
		<br>	
		
		<div class="container">
			<div class="row">
				<div class="col-5" style="position:static; left: 0px;">検索結果件数：0件</div>
				<div class="col-4">
					<a href="#">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
				</div>			
				<div class="col-3 float-left">
					ページあたりの表示件数
					<select id="rowCount" name="rowCount">
						<option value="10">10</option>
						<option value="50">50</option>
						<option value="100" selected>100</option>
					</select>
				</div>
			</div>
		</div>
    </form>
    
<br>

<br>

<div class="container" style="background-color: rgb(255, 255, 255);" id="outputtable">
    <table id="order_detail_info" class="table table-bordered">
		<thead class="thead-dark" id="AddHead">
		</thead>
		<tbody class="list" id="AddOption">
		</tbody>
	</table>
</div>

<!-- modal page (customersearch)-->
<div class="modal fade" id="setQuotationCondition" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			
			<div class="modal-header">
				<h5 class="modal-title" id="label1">顧客検索</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
			</div>
			 
			<form action="" method="post">
				<div class="modal-body">
				  <div class="row">
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup">UserId</label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">顧客コード</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
				  </div>
				

			   
				  <div class="row">
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup">UserName</label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">顧客名</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
				  

					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup">UserKana</label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">顧客名カナ</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
				  </div>
				
				  
			   
				  <div class="row">
					<div class="col-6">
					  <label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
						<div class="input-group mb-2">
						  <div class="input-group-prepend">
							<div class="input-group-text">支払条件</div>
						  </div>
						  <select class="custom-select" name="productStockCategory">
							<option selected></option>
							<c:forEach items="${}" value="">
							  <option value="${}">${}</option>
							</c:forEach>
						  </select>
						</div>
					</div>
				  </div>
				</div>
				<br>

				<div class="rounded float-right">
				  <button type="button" class="btn btn-outline-secondary" onclick="">初期化</button>&ensp;
				  <input type="submit" value="検索" class="btn btn-outline-secondary">&ensp;
				</div><br>
			  </form><br>

			  <div class="modal-body">
				<div class="float-left" style="position:static; left: 0px;">
				  検索結果件数：3件
				</div>
			  </div>

			  <div class="modal-body" style="background-color: rgb(255, 255, 255);">
				<table id="order_detail_info" class="table table-bordered">
				  <thead class="thead-dark">
					<tr>
					  <th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productCode');">顧客コード</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productName');">顧客名</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">TEL</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">担当者</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">取引区分</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">支払条件</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">事務所名</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">部署名</th>
					  
					</tr>
				  </thead>
				  <c:forEach items="${}" var="">
					<tr>
					  <td style="white-space: normal; text-align: left;" onclick="selectCustomerCode();" data-dismiss="modal" id="customerCode1"><a href="">顧客コード1</a></td>
					  <td style="white-space: normal; text-align: left;" onclick="selectCustomerCode();" data-dismiss="modal" id="customerName1"><a href="">顧客名1</a></td>
					  <td style="white-space: normal; text-align: left;">TEL1</td>
					  <td style="white-space: normal; text-align: left;">担当者1</td>
					  <td style="white-space: normal; text-align: left;">取引区分1</td>
					  <td style="white-space: normal; text-align: left;">支払条件1</td>
					  <td style="white-space: normal; text-align: left;">事務所名1</td>
					  <td style="white-space: normal; text-align: left;">部署名1</td>
					</tr>
					<tr>
						<td style="white-space: normal; text-align: left;">顧客コード2</td>
						<td style="white-space: normal; text-align: left;">顧客名2</td>
						<td style="white-space: normal; text-align: left;">TEL2</td>
						<td style="white-space: normal; text-align: left;">担当者2</td>
						<td style="white-space: normal; text-align: left;">取引区分2</td>
						<td style="white-space: normal; text-align: left;">支払条件2</td>
						<td style="white-space: normal; text-align: left;">事務所名2</td>
						<td style="white-space: normal; text-align: left;">部署名2</td>
					  </tr>
					  <tr>
						<td style="white-space: normal; text-align: left;">顧客コード3</td>
						<td style="white-space: normal; text-align: left;">顧客名3</td>
						<td style="white-space: normal; text-align: left;">TEL3</td>
						<td style="white-space: normal; text-align: left;">担当者3</td>
						<td style="white-space: normal; text-align: left;">取引区分3</td>
						<td style="white-space: normal; text-align: left;">支払条件3</td>
						<td style="white-space: normal; text-align: left;">事務所名3</td>
						<td style="white-space: normal; text-align: left;">部署名3</td>
					  </tr>
				  </c:forEach>
				</table>
				<br>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

			</div>
		</div>
	</div>
</div>

<!-- modal page (productsearch)-->
<div class="modal fade" id="setproductsearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			
			<div class="modal-header">
				<h5 class="modal-title" id="label1">商品検索</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
			</div>
			 
			<form action="" method="post">
				<div class="modal-body">
				  <div class="row">
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">商品コード</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">仕入先商品コード</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">JANコード</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
				  </div>

				  <div class="row">
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
						  <div class="input-group-prepend">
							<div class="input-group-text">セット分類</div>
						  </div>
						  <select class="custom-select" name="productStatusCategory">
							<option selected></option>
							<c:forEach items="${}" value="">
							  <option value="${}">${}</option>
							</c:forEach>
						  </select>
						</div>
					</div>

					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
						<div class="input-group mb-2">
						  <div class="input-group-prepend">
							<div class="input-group-text">標準化分類</div>
						  </div>
						  <select class="custom-select" name="productStockCategory">
							<option selected></option>
							<c:forEach items="${}" value="">
							  <option value="${}">${}</option>
							</c:forEach>
						  </select>
						</div>
					</div>

					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
						  <div class="input-group mb-2">
							<div class="input-group-prepend">
							  <div class="input-group-text">分類状況</div>
							</div>
							<select class="custom-select" name="productStockCategory">
							  <option selected></option>
							  <c:forEach items="${}" value="">
								<option value="${}">${}</option>
							  </c:forEach>
							</select>
						  </div>
						</div>
				  </div>

				  <div class="row">
					<div class="col-6">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">商品名</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
					<div class="col-6">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">商品名カナ</div>
						</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup">
					  </div>
					</div>
				  </div>
				</div>
				<br>

				<div class="rounded float-right">
				  <button type="button" class="btn btn-outline-secondary" onclick="">初期化</button>&ensp;
				  <input type="submit" value="検索" class="btn btn-outline-secondary">&ensp;
				</div>
			  </form>

			  <div class="modal-body">
				<div class="float-left" style="position:static; left: 0px;">
				  検索結果件数：3件
				</div>
			  </div>

			  <div class="modal-body" style="background-color: rgb(255, 255, 255);">
				<table id="order_detail_info" class="table table-bordered">
				  <thead class="thead-dark">
					<tr>
					  <th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productCode');">商品コード</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productName');">商品名</th>
					  <th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">仕入先名</th> 
					</tr>
				  </thead>
				  <c:forEach items="${}" var="">
					<tr>
					  <td style="white-space: normal; text-align: left;" onclick="selectProductCode()" data-dismiss="modal" id="productCode1"><a href="">商品コード1</a></td>
					  <td style="white-space: normal; text-align: left;" onclick="selectProductCode()" data-dismiss="modal" id="productName1"><a href="">商品名1</a></td>
					  <td style="white-space: normal; text-align: left;">仕入先名1</td>
					</tr>
					<tr>
						<td style="white-space: normal; text-align: left;">商品コード2</td>
						<td style="white-space: normal; text-align: left;">商品名2</td>
						<td style="white-space: normal; text-align: left;">仕入先名2</td>
					</tr>
					<tr>
						<td style="white-space: normal; text-align: left;">商品コード3</td>
						<td style="white-space: normal; text-align: left;">商品名3</td>
						<td style="white-space: normal; text-align: left;">仕入先名3</td>
					</tr>
				  </c:forEach>
				</table>
				<br>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>
</div>

<!-- modal page (suppliersearch)-->
<div class="modal fade" id="openSearchSupplier" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="label1">仕入れ先検索</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
			</div>

			<div class="modal-body">
				<!-- 検索部 -->

					<div class="row">
						<div class="col-5">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入れ先コード</div>
								</div>
							<input type="text" class="form-control" id="">
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-5">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入れ先名</div>
								</div>
							<input type="text"  class="form-control" id="">
							</div>
						</div>
						<div class="col-6">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入れ先カナ</div>
								</div>
							<input type="text"  class="form-control" id="">
							</div>
						</div>
					</div>
					
					<div class="row float-right">
						<button class="btn btn-secondary">初期化</button>&emsp;
						<button class="btn btn-secondary">検索</button>&emsp;
					</div>
					<br><br>
					<!-- テーブル部（検索結果） -->
					検索結果件数：2件<br>

					<table class="table table-bordered">
						<!-- ヘッダ部 -->
						<thead class="thead-dark">
						<tr>
							<th>仕入れ先コード</th>
							<th>仕入れ先名</th>
							<th>担当者</th>
							<th>取引区分</th>
							<th>備考</th>
						</tr>
						</thead>
						<!-- 内部 -->
						<tr>
							<td class="cursor-pointer" id="supplierCode1" onclick="selectSupplierCode()" data-dismiss="modal"><a href="">1</a></td>
							<td id="supplierName1" onclick="selectSupplierCode()" data-dismiss="modal"><a href="">アンパンマン食品</a></td>
							<td>ジャムおじさん</td>
							<td>現金</td>
							<td>アンパンマンのことならお任せしたかったよ</td>
						</tr>
						<tr>
							<td class="cursor-pointer">10</td>
							<td>とことこ寝具</td>
							<td>寝巻</td>
							<td>サンプル</td>
							<td>ふかふかお布団</td>
						</tr>
					</table>

			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>

<!-- modal page(configuration)-->
<div class="modal fade" id="setSlipConfiguration" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			
			<div class="modal-header">
				<h5 class="modal-title" id="label1">検索結果設定</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
			</div>

			<div class="modal-body">
				検索対象：<span id="select_view_text">伝票</span><br><br>
				&emsp;非表示リスト&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;表示リスト
				<br>
				<div class="row container">
				&emsp;
				<select size="7" id="notShowSearchResult" name="notShowSearchResult" style="width: 160px;">
					<!--
					<option value="見積番号">見積番号</option>
					<option value="見積日">見積日</option>
					<option value="有効期限">有効期限</option>
					<option value="伝票合計">伝票合計</option>
					<option value="件名">件名</option>
					<option value="提出先名">提出先名</option>
					<option value="提出先敬称">提出先敬称</option>
					<option value="顧客コード">顧客コード</option>
					<option value="顧客名">顧客名</option>
					
					<option value="10">粗利益</option>
					<option value="11">粗利益率</option>
					<option value="12">金額合計</option>
					<option value="13">消費税</option>
					<option value="14">納期または出荷日</option>
					<option value="15">入力担当者名</option>
					<option value="16">入力担当者コード</option>
					<option value="17">摘要</option>
					<option value="18">納入先</option>
					<option value="19">見積条件</option>
					-->

				</select>
				&emsp;

					<table>
					<tr><td>&ensp;</td></tr>
					<tr><td>&ensp;</td></tr>
					<tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" onclick="moveSelected()">→</button></td></tr>
					<tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" onclick="moveUnselected()">←</button></td></tr>
					</table>
				
				&emsp;
				<select size="7" id="showSearchResult" name="showSearchResult" style="width: 160px;">
					<!--
					<option value="粗利益">粗利益</option>
					<option value="粗利益率">粗利益率</option>
					<option value="金額合計">金額合計</option>
					<option value="消費税">消費税</option>
					<option value="納期または出荷日">納期または出荷日</option>
					<option value="入力担当者名">入力担当者名</option>
					<option value="入力担当者コード">入力担当者コード</option>
					<option value="摘要">摘要</option>
					<option value="納入先">納入先</option>
					<option value="見積条件">見積条件</option>
					-->
				</select>
					&emsp;
					<table>
						<tr><td>&ensp;</td></tr>
						<tr><td>&ensp;</td></tr>
						<tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" id="sel_up">↑</button></td></tr>
						<tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" id="sel_down">↓</button></td></tr>
						</table>

				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="initConfig();">初期化</button>                            
				<button type="button" class="btn btn-primary" onclick="modifyConfig();" data-dismiss="modal">更新</button>                            
				<button type="button" class="btn btn-primary" data-dismiss="modal">閉じる</button>
			</div>

		</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
	var unselectedArr = [];
	var selectedArr = [];
	var detailUnselectedArr = [];
	var detailSelectedArr = [];

	function initPage(){
		if(!confirm("入力内容を初期化してよろしいですか？")){
           	return;
    	}
        location.reload();
	}

	function excelOut(){
		if(!confirm("検索結果をExcelファイルでダウンロードしますか？")){
           	return;
    	}

	}
	
	function submitForm(){
		document.getElementById('mainform').submit();
	}

	$(document).ready(function(){
		unselectedArr = ["見積番号", "見積日", "有効期限", "伝票合計", "件名", "提出先名", "提出先敬称", "顧客コード", "顧客名"];
		selectedArr = ["粗利益", "粗利益率", "金額合計", "消費税", "納期または出荷日", "入力担当者名", "入力担当者コード", "摘要", "納入先", "見積条件"];
		detailUnselectedArr = ["出荷日","納期指定日","受付番号","入力担当者コード","入力担当者名","摘要","[明細]顧客コード","[明細]完納区分","[明細]売上単価","[明細]仕入金額","[明細]売価金額","粗利益","粗利益率","金額合計","消費税","伝票合計","受注残数"];
		detailSelectedArr = ["受注番号-行","受注日","顧客名","[明細]商品名","[明細]数量","[明細]仕入単価","[明細]備考"];

		var headcontents= '';

		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		if(sel_view == "伝票"){
			for(var i = 0; i < selectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + i+1 + ">" + selectedArr[i] + "</option>")
			}

			for(var i = 0; i < unselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + i+1 + ">" + unselectedArr[i] + "</option>")
			}
		}
		else{
			for(var i = 0; i < detailSelectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + i+1 + ">" + selectedArr[i] + "</option>")
			}

			for(var i = 0; i < detailUnselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + i+1 + ">" + unselectedArr[i] + "</option>")
			}
		}

		headcontents += '<tr>';
		for(var i = 0; i < selectedArr.length; i++){
			headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">'+ selectedArr[i] +'</th>';
		}               
		headcontents += '</tr>';

		$('#AddHead').append(headcontents);

    });

	function moveSelected(){
		$('#notShowSearchResult option:selected').appendTo('#showSearchResult');
		$('#notShowSearchResult option:selected').remove();
	}

	function moveUnselected(){
		$('#showSearchResult option:selected').appendTo('#notShowSearchResult');
		$('#showSearchResult option:selected').remove();
	}
	
	function selectCustomerCode(){
		var customerCode = document.getElementById("customerCode1").innerText;
		var customerName = document.getElementById("customerName1").innerText;

		document.getElementById("customerCodeInput").value = customerCode;
		document.getElementById("customerNameInput").value = customerName;
		
	}

	function selectProductCode(){
		var productCode = document.getElementById("productCode1").innerText;
		var productName = document.getElementById("productName1").innerText;

		document.getElementById("productCodeInput").value = productCode;
		document.getElementById("productNameInput").value = productName;
	}

	function selectSupplierCode(){
		var supplierCode = document.getElementById("supplierCode1").innerText;
		var supplierName = document.getElementById("supplierName1").innerText;

		document.getElementById("supplierCodeInput").value = supplierCode;
		document.getElementById("supplierNameInput").value = supplierName;
	}



	$("#sel_up").click(function() {
		var opt = $("#showSearchResult option:selected");
		if(opt.size() > 0) {
			opt.insertBefore(opt.prev());
		}
	});

	$("#sel_down").click(function() {
		var opt = $("#showSearchResult option:selected");
		if(opt.size() > 0) {
			opt.insertAfter(opt.next());
		}
	});

	function initConfig(){

		$("select#showSearchResult option").remove();
		$("select#notShowSearchResult option").remove();

		for(var i = 0; i < selectedArr.length; i++){
			$("#showSearchResult").append("<option value = " + i+1 + ">" + selectedArr[i] + "</option>")
		}

		for(var i = 0; i < unselectedArr.length; i++){
			$("#notShowSearchResult").append("<option value = " + i+1 + ">" + unselectedArr[i] + "</option>")
		}
	}

	function modifyConfig(){
		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		if(sel_view == "伝票"){
			selectedArr = [];
			unselectedArr = [];
			selectedArr = $("#showSearchResult>option").map(function() { return $(this).text(); });
			unselectedArr = $("#notShowSearchResult>option").map(function() { return $(this).text(); });

			$("#AddHead > tr").remove();

			var headcontents= '';
			
			headcontents += '<tr>';
			for(var i = 0; i < selectedArr.length; i++){
				headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">'+ selectedArr[i] +'</th>';
			}               
			headcontents += '</tr>';

			$('#AddHead').append(headcontents);
		} 
		else {
			detailSelectedArr = [];
			detailUnselectedArr = [];
			detailSelectedArr = $("#showSearchResult>option").map(function() { return $(this).text(); });
			detailUnselectedArr = $("#notShowSearchResult>option").map(function() { return $(this).text(); });

			$("#AddHead > tr").remove();

			var headcontents= '';
			
			headcontents += '<tr>';
			for(var i = 0; i < detailSelectedArr.length; i++){
				headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">'+ detailSelectedArr[i] +'</th>';
			}               
			headcontents += '</tr>';

			$('#AddHead').append(headcontents);
		}	
	}

	$("#select_view").focusout(function(){
		$("select#showSearchResult option").remove();
		$("select#notShowSearchResult option").remove();

		var opt = $("#select_view option:selected");

		document.getElementById("select_view_text").innerHTML = opt.text();

		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		if(sel_view == "伝票"){
			for(var i = 0; i < selectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + i+1 + ">" + selectedArr[i] + "</option>")
			}

			for(var i = 0; i < unselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + i+1 + ">" + unselectedArr[i] + "</option>")
			}
		}
		else{
			for(var i = 0; i < detailSelectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + i+1 + ">" + detailSelectedArr[i] + "</option>")
			}

			for(var i = 0; i < detailUnselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + i+1 + ">" + detailUnselectedArr[i] + "</option>")
			}
		}
	});
</script>
</body>
</html>

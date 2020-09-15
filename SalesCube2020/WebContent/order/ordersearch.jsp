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
	<div id = "test">
		<input type="hidden" id="hiddenSort">
		<input type="hidden" id="hiddenPaging" value="1">
	</div>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script type="text/javascript" src="common/shotcuts.js"></script>   
    <%@ include file= "../common/menubar.jsp" %>
	<br>

    <div class="container" id="main_function">
      <h3 class="float-left">受注検索</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initPage();">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="search();">F2<br>検索</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="csvOutput();" id="csvDownloadButton">F3<br>Excel出力<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" id="openConfigModal" data-toggle="modal" data-target="#setSlipConfiguration">F4<br>設定<br></button>
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
                                   <select id="select_view" onchange="changeSearch()" name="select_view">
                                       <option value="伝票" selected>伝票</option>
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
						<input type="text" class="form-control" id="orderNumber" name="orderNo" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" maxlength=10>
						</div>
					</div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">受付番号</div>
							</div>
						<input type="text"  class="form-control" id="repNo" name="repNo" maxlength="30">
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
						<input type="date"  class="form-control" id="orderDayStart" name="orderDayStart" max="9999-12-31">
						</div>
                    </div>
                    ~
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">

						<input type="date"  class="form-control" id="orderDayEnd" name="orderDayEnd" max="9999-12-31">
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
						<input type="date"  class="form-control" id="shipDayStart" name="shipDayStart" max="9999-12-31">
						</div>
                    </div>
                    ~
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">

						<input type="date"  class="form-control" id="shipDayEnd" name="shipDayEnd" max="9999-12-31"> 
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
						<input type="date"  class="form-control" id="deliveryDayStart" name="deliveryDayStart" max="9999-12-31">
						</div>
                    </div>
                    ~
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">

						<input type="date"  class="form-control" id="deliveryDayEnd" name="deliveryDayEnd" max="9999-12-31">
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
                            <input type="text" class="form-control" id="customerCodeInput" name="customerCodeInput" maxlength="15">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#customerSearch" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px" onclick="moveCustomerModal();getCutoffGroup()">
							</button>
					    </div>
					</div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">顧客名</div>
							</div>
                            <input type="text"  class="form-control" id="customerNameInput" name="customerNameInput" maxlength="60">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#customerSearch" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px" onclick="moveCustomerModal();getCutoffGroup()">
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
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="0" name="withdrawl">
								<label class="form-check-label" for="inlineCheckbox1">掛売</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="1" name="withdrawl">
								<label class="form-check-label" for="inlineCheckbox1">現金</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="2" name="withdrawl">
								<label class="form-check-label" for="inlineCheckbox1">サンプル</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="3" name="withdrawl">
								<label class="form-check-label" for="inlineCheckbox1">代引き</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="4" name="withdrawl">
								<label class="form-check-label" for="inlineCheckbox1">クレジット</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="5" name="withdrawl">
								<label class="form-check-label" for="inlineCheckbox1">先入金</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="6" name="withdrawl">
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
                            <input type="text"  class="form-control" id="productCodeInput" name="productCodeInput" maxlength="20">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px" onclick="initProductModal();moveProductModal();"></button>
					    </div>
					</div>
					<div class="col-2"></div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">商品名</div>
							</div>
                            <input type="text"  class="form-control" id="productNameInput" name="productNameInput" maxlength="60">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px" onclick="initProductModal();moveProductModal();"></button>
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
								<div class="input-group-text">分類（大）</div>
							</div>
							<select class="custom-select" name="product1" id="product1" onchange="selectPro1();">
								<option selected></option>
							</select>
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
								<div class="input-group-text">分類（中）</div>
							</div>
							<select class="custom-select" name="product2" id="product2" onchange="selectPro2();">
								<option selected></option>
							</select>
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
								<div class="input-group-text">分類（小）</div>
							</div>
							<select class="custom-select" name="product3" id="product3">
								<option selected></option>
							</select>
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
                            <input type="text"  class="form-control" id="supplierCodeInput" name="supplierCodeInput" maxlength="10">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchSupplier" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px" onclick="initSupplier();moveDeliveryModal();"></button>
					    </div>
					</div>
					<div class="col-2"></div>
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">仕入先名</div>
							</div>
                            <input type="text"  class="form-control" id="supplierNameInput" name="supplierNameInput" maxlength="60">
                            <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchSupplier" style="background-image: url(btn_search.png); border: 0px; outline: 0px; padding: 15px; margin: 0; height: 16px" onclick="initSupplier();moveDeliveryModal();"></button>
						</div>
					</div>                
				</div>	
			</div><br>
			<div align="right">
				<input type="button" value="初期化" class="btn btn-outline-secondary" onclick="initPage();">
				<input type="button" value="検索" class="btn btn-outline-secondary" onclick="search();">
			</div>
			<br>
		</div>
		</div>

		<br>
		<br>	
		
		<div class="container">
			<div class="row">
				<div class="col-5" style="position:static; left: 0px;">
					検索結果件数：<span id="resultCount">0</span>件
				</div>
				<div class="col-4" id="paging">
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
    <table id="order_detail_info" class="table table-bordered" style="background-color: white; table-layout:fixed;"> 
		<thead class="thead-dark" id="AddHead">
		</thead>
		<tbody class="list" id="AddOption">
		</tbody>
	</table>
</div>
<%@ include file= "../common/productSearch.jsp" %>
<!-- modal page (customersearch)-->
<%@ include file= "../common/_customerSearch.jsp" %>
<!-- modal page (suppliersearch)-->
<%@ include file= "../common/_supplierSearch.jsp" %>
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
				<button type="button" class="btn btn-primary" onclick="modifyConfig();" data-dismiss="modal" id="configModalConfirm">更新</button>                            
				<button type="button" class="btn btn-primary" data-dismiss="modal">閉じる</button>
			</div>

		</div>
	</div>
</div>
</body>
<script>
	var unselectedArr = [];
	var selectedArr = [];
	var detailUnselectedArr = [];
	var detailSelectedArr = [];
	var mylist = [];
	var orderBy = "ASC";
	var startPage;

	function initPage(){
		if(!confirm("入力内容を初期化してよろしいですか？")){
           	return;
    	}
        location.reload();
	}

	$(document).ready(function(){
	
		var loop=0;
				
		<c:forEach var="test" items="${configDetailShow}">
		detailSelectedArr[loop] = {
				    value:"${test.categoryCode}",
				    name:"${test.categoryCodeName}",	
				  };
		  		loop++;  	 
		</c:forEach>

		loop=0;
		<c:forEach var="test" items="${configDetailNotShow}">
		detailUnselectedArr[loop] = {
			   value:"${test.categoryCode}",
		 	   name:"${test.categoryCodeName}",	
			  };
  		loop++;
		</c:forEach>
		
		loop=0;
		<c:forEach var="test" items="${configBillShow}">
		selectedArr[loop] = {
			   value:"${test.categoryCode}",
		 	   name:"${test.categoryCodeName}",	
			  };
  		loop++;
		</c:forEach>
		
		loop=0;
		<c:forEach var="test" items="${configBillNotShow}">
		unselectedArr[loop] = {
			   value:"${test.categoryCode}",
		 	   name:"${test.categoryCodeName}",	
			  };
  		loop++;
		</c:forEach>

		var headcontents= '';

		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		if(sel_view == "伝票"){
			for(var i = 0; i < selectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + selectedArr[i].value + ">" + selectedArr[i].name + "</option>")
			}

			for(var i = 0; i < unselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + unselectedArr[i].value + ">" + unselectedArr[i].name + "</option>")
			}
		}
		else{
			for(var i in detailSelectedArr){
				$("#showSearchResult").append("<option value = " + detailSelectedArr[i].value + ">" + detailSelectedArr[i].name + "</option>")
			}

			for(var i in detailUnselectedArr){
				$("#notShowSearchResult").append("<option value = " + detailUnselectedArr[i].value + ">" + detailUnselectedArr[i].name + "</option>")
			}
		}

		headcontents += '<tr>';
		for(var i = 0; i < selectedArr.length; i++){
			headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px; width: 135px; font-size: 10pt;"><a onclick="searchandsort(this)">'+ selectedArr[i].name +'</a></th>';
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
		
	function selectCustomerCode(code, name){
		document.getElementById("customerCodeInput").value = code;
		document.getElementById("customerNameInput").value = name;		
	}

	function selectProductModal(code, name){
		document.getElementById("productCodeInput").value = code;
		document.getElementById("productNameInput").value = name;
	}
	
	function selectSupplierCode(code, name){
		document.getElementById("supplierCodeInput").value = code;
		document.getElementById("supplierNameInput").value = name;
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

		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		$("select#showSearchResult option").remove();
		$("select#notShowSearchResult option").remove();
		
		if(sel_view == "伝票"){
			for(var i = 0; i < selectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + selectedArr[i].value + ">" + selectedArr[i].name + "</option>")
			}
	
			for(var i = 0; i < unselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + unselectedArr[i].value + ">" + unselectedArr[i].name + "</option>")
			}
		} else {
			for(var i = 0; i < selectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + detailSelectedArr[i].value + ">" + selectedArr[i].name + "</option>")
			}
	
			for(var i = 0; i < unselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + detailUnselectedArr[i].value + ">" + unselectedArr[i].name + "</option>")
			}
			
		}
	}

	function modifyConfig(){
		document.getElementById("configModalConfirm").setAttribute("data-dismiss","modal");
		var exists = false; 
		$('#showSearchResult option').each(function(){ if (this.value == 'roSlipId') { exists = true; return false; } });

		var checkID = document.getElementById("showSearchResult");
		var isemplty = checkID.length;
		if(isemplty == 0){
			initConfig();
			alert("表示リストには必ず1項目以上必要です。");
			document.getElementById("configModalConfirm").removeAttribute("data-dismiss");
		}
		
		var indexID = checkID[0].value;
		
		if(exists == false){
			initConfig();
			alert("受注番号は必須項目です。");
			document.getElementById("configModalConfirm").removeAttribute("data-dismiss");
		}
		
		if(indexID != 'roSlipId'){
			initConfig();
			alert("受注番号は一番最初の項目にする必要があります。");
			document.getElementById("configModalConfirm").removeAttribute("data-dismiss");		
		}
			
		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		if(sel_view == "伝票"){
			selectedArr = [];
			unselectedArr = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				selectedArr[i] = {
						value:document.getElementById('showSearchResult')[i].value,
						name:document.getElementById('showSearchResult')[i].innerText,
				};
			}
			for(var i = 0; i<document.getElementById('notShowSearchResult').length; i++){
				unselectedArr[i] = {
						value:document.getElementById('notShowSearchResult')[i].value,
						name:document.getElementById('notShowSearchResult')[i].innerText,
				};
			}
			$("#AddHead > tr").remove();

			var headcontents= '';
			
			headcontents += '<tr>';
			for(var i = 0; i < selectedArr.length; i++){
				headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px; width: 135px; font-size: 10pt;"><a onclick="searchandsort(this)">'+ selectedArr[i].name +'</a></th>';
			}               
			headcontents += '</tr>';

			$('#AddHead').append(headcontents);
		} 
		else {
			detailSelectedArr = [];
			detailUnselectedArr = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				detailSelectedArr[i] = {
						value:document.getElementById('showSearchResult')[i].value,
						name:document.getElementById('showSearchResult')[i].innerText,
				};
			}
			for(var i = 0; i<document.getElementById('notShowSearchResult').length; i++){
				detailUnselectedArr[i] = {
						value:document.getElementById('notShowSearchResult')[i].value,
						name:document.getElementById('notShowSearchResult')[i].innerText,
				};
			}
			$("#AddHead > tr").remove();

			var headcontents= '';
			
			headcontents += '<tr>';
			for(var i = 0; i < detailSelectedArr.length; i++){
				headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px; width: 135px; font-size: 10pt;"><a onclick="searchandsort(this)">'+ detailSelectedArr[i].name +'</a></th>';
			}               
			headcontents += '</tr>';

			$('#AddHead').append(headcontents);
		}
		
		var showlistvalue = $("#showSearchResult option").map(function() {return $(this).val();}).get();

		jQuery.ajaxSettings.traditional = true;
		
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=configModalUpdate',
			type:'post',
			data:{
				"showlistvalue": showlistvalue,
				"searchsubject" : sel_view
			},
			dataType:'text',
			success:function(data){	
				$("#AddOption > tr").remove();								
			}
		});
		$('#resultCount').text("0");
	}

	$("#select_view").focusout();
	
	function changeSearch(){
		$("select#showSearchResult option").remove();
		$("select#notShowSearchResult option").remove();
		$("#AddOption > tr").remove();
		var opt = $("#select_view option:selected");

		document.getElementById("select_view_text").innerHTML = opt.text();

		var e = document.getElementById("select_view");
		var sel_view = e.options[e.selectedIndex].value;

		if(sel_view == "伝票"){
			for(var i = 0; i < selectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + selectedArr[i].value + ">" + selectedArr[i].name + "</option>")
			}

			for(var i = 0; i < unselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + unselectedArr[i].value + ">" + unselectedArr[i].name + "</option>")
			}
		}
		else{
			for(var i = 0; i < detailSelectedArr.length; i++){
				$("#showSearchResult").append("<option value = " + detailSelectedArr[i].value + ">" + detailSelectedArr[i].name + "</option>")
			}

			for(var i = 0; i < detailUnselectedArr.length; i++){
				$("#notShowSearchResult").append("<option value = " + detailUnselectedArr[i].value + ">" + detailUnselectedArr[i].name + "</option>")
			}
		}
		
		if(sel_view == "伝票"){
			selectedArr = [];
			unselectedArr = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				selectedArr[i] = {
						value:document.getElementById('showSearchResult')[i].value,
						name:document.getElementById('showSearchResult')[i].innerText,
				};
			}
			for(var i = 0; i<document.getElementById('notShowSearchResult').length; i++){
				unselectedArr[i] = {
						value:document.getElementById('notShowSearchResult')[i].value,
						name:document.getElementById('notShowSearchResult')[i].innerText,
				};
			}
			$("#AddHead > tr").remove();

			var headcontents= '';
			
			headcontents += '<tr>';
			for(var i = 0; i < selectedArr.length; i++){
				headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px; width: 135px; font-size: 10pt;" ><a onclick="searchandsort(this)">'+ selectedArr[i].name +'</a></th>';
			}               
			headcontents += '</tr>';

			$('#AddHead').append(headcontents);
		} 
		else {
			detailSelectedArr = [];
			detailUnselectedArr = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				detailSelectedArr[i] = {
						value:document.getElementById('showSearchResult')[i].value,
						name:document.getElementById('showSearchResult')[i].innerText,
				};
			}
			for(var i = 0; i<document.getElementById('notShowSearchResult').length; i++){
				detailUnselectedArr[i] = {
						value:document.getElementById('notShowSearchResult')[i].value,
						name:document.getElementById('notShowSearchResult')[i].innerText,
				};
			}
			$("#AddHead > tr").remove();

			var headcontents= '';
			
			headcontents += '<tr>';
			for(var i = 0; i < detailSelectedArr.length; i++){
				headcontents += '<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px; width: 135px; font-size: 10pt;"><a onclick="searchandsort(this)">'+ detailSelectedArr[i].name +'</a></th>';
			}               
			headcontents += '</tr>';

			$('#AddHead').append(headcontents);
			$('#resultCount').text("0");
		}
	}
	
	window.onload = function(){

		var loop=0;
		
		<c:forEach var="test" items="${category}" >
		  mylist[loop] = {
				    cat1:"${test.classCode1}",
				    cat2:"${test.classCode2}",
				    cat3:"${test.classCode3}",
				    catName:"${test.className}",	
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
		$(function() {
		    var temp = "${Category1}"; 
		    $("#product1").val(temp);
		})
		$(function() {
		    var temp = "${Category2}"; 
		    $("#product2").val(temp);
		});
				
		
		
		function search(){
			var selArr = [];
			var checkedData = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				selArr[i] = document.getElementById('showSearchResult')[i].value
			}

			$("input[name='withdrawl']:checked").each(function() {
				var test = $(this).val();
				checkedData.push(test);
			});

			jQuery.ajaxSettings.traditional = true;
			
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=orderSearch',
				type:'post',
				data:{
					"selectView": $("#select_view option:selected").val(),
					"orderNo": $("#orderNumber").val(),
					"repNo": $("#repNo").val(),
					"orderDayStart": $("#orderDayStart").val(),
					"orderDayEnd": $("#orderDayEnd").val(),
					"shipDayStart": $("#shipDayStart").val(),
					"shipDayEnd": $("#shipDayStart").val(),
					"deliveryDayStart": $("#shipDayStart").val(),
					"deliveryDayEnd": $("#shipDayStart").val(),
					"customerCode": $("#customerCodeInput").val(),
					"customerName": $("#customerNameInput").val(),
					"withdrawl": checkedData,
					"productCode": $("#productCodeInput").val(),
					"productName": $("#productNameInput").val(),
					"product1": $("#product1").val(),
					"product2": $("#product2").val(),
					"product3": $("#product3").val(),
					"supplierCode": $("#supplierCodeInput").val(),
					"supplierName": $("#supplierNameInput").val(),
					"rowCount": $("#rowCount option:selected").val(),
					"list":selArr,
					"orderBy": orderBy
				},
				dataType:'json',
				success:function(data){	
					var roSlipId;
					var count = data[Object.keys(data).length-2]["totalCount"];
					if(count != "0"){
						$("#AddOption > tr").remove();
						for(var i = 0; i<Object.keys(data).length - 3; i++){
							var headcontents= '';
							headcontents += '<tr>';
							for(var j = 0; j < selArr.length; j++){
								var tmp;
								if(data[i][j] == null)
									tmp = "";
								else if(isNaN(data[i][j]) == false)
									tmp = Math.floor(data[i][j]);
								else
									tmp = data[i][j];
									
								if($("#select_view option:selected").val() == "明細"){
									var str = tmp + '';
									var splittmp = str.split('-');
									roSlipId = splittmp[0];
								} else {
									roSlipId = tmp;
								}
									
								
								if(j == 0){
									headcontents += '<td><a href="/SalesCube2020/SalesCube?action=orderupdate&roSlipId='+roSlipId+'">' + tmp + '</a></td>';
								} else {
									headcontents += '<td>' + tmp + '</td>';
								}
							}
							
							headcontents += '</tr>';
							$('#AddOption').append(headcontents);						
						}

						$('#resultCount').text(count);
						$("#paging > a").remove();
						
						var lastCount = data[Object.keys(data).length-1]["totalPage"];
						var pagingNo;
						var num = 1;
						num *= 1;
						
						if(lastCount > (num+5)){
							pagingNo = num+5;
						} else {
							pagingNo = lastCount;
						}

						if(lastCount > 6 && num != 1)
							$("#paging").append('<a href="javascript:void(0);" onclick="paging(1)">'+'<<'+'</a> ');
						for(var i = num ; i<=pagingNo ; i++){
							$("#paging").append('<a href="javascript:void(0);" onclick="paging('+(i)+')">'+(i)+'</a> ');
						}
						if(lastCount > 6 && (num+2) != lastCount)
							$("#paging").append('<a href="javascript:void(0);" onclick="paging('+(lastCount)+')">'+'>>'+'</a> ');
					} else {
						alert("検索結果がありません。");
					}
					
				}
			});
		}
		
		function searchandsort(obj){
			var selArr = [];
			var checkedData = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				selArr[i] = document.getElementById('showSearchResult')[i].value
			}

			$("input[name='withdrawl']:checked").each(function() {
				var test = $(this).val();
				checkedData.push(test);
			});
			var sorting = $(obj).text();
			document.getElementById("hiddenSort").value = sorting;
			var num = document.getElementById("hiddenPaging").value;
			jQuery.ajaxSettings.traditional = true;
			
			if(orderBy == "ASC")
				orderBy = "DESC"
			else
				orderBy = "ASC"
			
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=orderSearch',
				type:'post',
				data:{
					"selectView": $("#select_view option:selected").val(),
					"orderNo": $("#orderNumber").val(),
					"repNo": $("#repNo").val(),
					"orderDayStart": $("#orderDayStart").val(),
					"orderDayEnd": $("#orderDayEnd").val(),
					"shipDayStart": $("#shipDayStart").val(),
					"shipDayEnd": $("#shipDayStart").val(),
					"deliveryDayStart": $("#shipDayStart").val(),
					"deliveryDayEnd": $("#shipDayStart").val(),
					"customerCode": $("#customerCodeInput").val(),
					"customerName": $("#customerNameInput").val(),
					"withdrawl": checkedData,
					"productCodeInput": $("#productCodeInput").val(),
					"productNameInput": $("#productNameInput").val(),
					"product1": $("#product1").val(),
					"product2": $("#product2").val(),
					"product3": $("#product3").val(),
					"supplierCodeInput": $("#supplierCodeInput").val(),
					"supplierNameInput": $("#supplierNameInput").val(),
					"rowCount": $("#rowCount option:selected").val(),
					"list": selArr, 
					"sorting": sorting,
					"paging": num,
					"orderBy": orderBy
				},
				dataType:'json',
				success:function(data){	
					$("#AddOption > tr").remove();
					for(var i = 0; i<Object.keys(data).length - 3; i++){
						var headcontents= '';
						headcontents += '<tr>';
						for(var j = 0; j < selArr.length; j++){
								var tmp;
								if(data[i][j] == null)
									tmp = "";
								else if(isNaN(data[i][j]) == false)
									tmp = Math.floor(data[i][j]);
								else
									tmp = data[i][j];
									
								if($("#select_view option:selected").val() == "明細"){
									var str = tmp + '';
									var splittmp = str.split('-');
									roSlipId = splittmp[0];
								} else {
									roSlipId = tmp;
								}
									
								
								if(j == 0){
									headcontents += '<td><a href="/SalesCube2020/SalesCube?action=orderupdate&roSlipId='+roSlipId+'">' + tmp + '</a></td>';
								} else {
									headcontents += '<td>' + tmp + '</td>';
								}
							}
						headcontents += '</tr>';
						$('#AddOption').append(headcontents);						
					}
					
					$('#resultCount').text(data[Object.keys(data).length-2]["totalCount"]);
					$("#paging > a").remove();
					
					var lastCount = data[Object.keys(data).length-1]["totalPage"];
					var pagingNo;
					
					num *= 1;

					if(num == 1 && lastCount > 5){
						pagingNo = num+5;
					} else if(lastCount > (num+3)){
						pagingNo = num+3;
					} else {
						pagingNo = lastCount;
					}

					var tmpnum;
					
					if(num-3 <= 0){
						tmpnum = 1;
					} else if ( num == lastCount) {
						tmpnum = num - 5;
					} else if ( num + 1 == lastCount) {
						tmpnum = num - 4;
					} else if ( num + 2 == lastCount) {
						tmpnum = num - 3;
					} else {
						tmpnum = num - 2;
					}

					if(lastCount > 6 && tmpnum != 1)
						$("#paging").append('<a href="javascript:void(0);" onclick="paging(1)">'+'<<'+'</a> ');
					for(var i = tmpnum ; i<=pagingNo ; i++){
						$("#paging").append('<a href="javascript:void(0);" onclick="paging('+(i)+')">'+(i)+'</a> ');
					}
					if(lastCount > 6 && num != lastCount)
						$("#paging").append('<a href="javascript:void(0);" onclick="paging('+(lastCount)+')">'+'>>'+'</a> ');
				}
			});
		}
		
		function paging(num){
			var selArr = [];
			var checkedData = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				selArr[i] = document.getElementById('showSearchResult')[i].value
			}

			$("input[name='withdrawl']:checked").each(function() {
				var test = $(this).val();
				checkedData.push(test);
			});
			var sorting = document.getElementById("hiddenSort").value;

			document.getElementById("hiddenPaging").value = num;
			
			
			jQuery.ajaxSettings.traditional = true;
			
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=orderSearch',
				type:'post',
				data:{
					"selectView": $("#select_view option:selected").val(),
					"orderNo": $("#orderNumber").val(),
					"repNo": $("#repNo").val(),
					"orderDayStart": $("#orderDayStart").val(),
					"orderDayEnd": $("#orderDayEnd").val(),
					"shipDayStart": $("#shipDayStart").val(),
					"shipDayEnd": $("#shipDayStart").val(),
					"deliveryDayStart": $("#shipDayStart").val(),
					"deliveryDayEnd": $("#shipDayStart").val(),
					"customerCode": $("#customerCodeInput").val(),
					"customerName": $("#customerNameInput").val(),
					"withdrawl": checkedData,
					"productCodeInput": $("#productCodeInput").val(),
					"productNameInput": $("#productNameInput").val(),
					"product1": $("#product1").val(),
					"product2": $("#product2").val(),
					"product3": $("#product3").val(),
					"supplierCodeInput": $("#supplierCodeInput").val(),
					"supplierNameInput": $("#supplierNameInput").val(),
					"rowCount": $("#rowCount option:selected").val(),
					"list": selArr, 
					"sorting": sorting,
					"paging": num,
					"orderBy": orderBy
				},
				dataType:'json',
				success:function(data){	
					$("#AddOption > tr").remove();
					for(var i = 0; i<Object.keys(data).length - 3; i++){
						var headcontents= '';
						headcontents += '<tr>';
						for(var j = 0; j < selArr.length; j++){
								var tmp;
								if(data[i][j] == null)
									tmp = "";
								else if(isNaN(data[i][j]) == false)
									tmp = Math.floor(data[i][j]);
								else
									tmp = data[i][j];
									
								if($("#select_view option:selected").val() == "明細"){
									var str = tmp + '';
									var splittmp = str.split('-');
									roSlipId = splittmp[0];
								} else {
									roSlipId = tmp;
								}
									
								
								if(j == 0){
									headcontents += '<td><a href="/SalesCube2020/SalesCube?action=orderupdate&roSlipId='+roSlipId+'">' + tmp + '</a></td>';
								} else {
									headcontents += '<td>' + tmp + '</td>';
								}
							}
						headcontents += '</tr>';
						$('#AddOption').append(headcontents);						
					}
					
					$('#resultCount').text(data[Object.keys(data).length-2]["totalCount"]);
					$("#paging > a").remove();
					
					var lastCount = data[Object.keys(data).length-1]["totalPage"];
					var pagingNo;

					if(num == 1 && lastCount > 5){
						pagingNo = num+5;
					} else if(num == 2 && lastCount > 5){
						pagingNo = num+4;
					} else if(lastCount > (num+3)){
						pagingNo = num+3;
					} else {
						pagingNo = lastCount;
					}

					var tmpnum;
					
					if(num-3 <= 0){
						tmpnum = 1;
					} else if ( num == lastCount) {
						tmpnum = num - 5;
					} else if ( num + 1 == lastCount) {
						tmpnum = num - 4;
					} else if ( num + 2 == lastCount) {
						tmpnum = num - 3;
					} else {
						tmpnum = num - 2;
					}

					if(lastCount > 6 && tmpnum != 1)
						$("#paging").append('<a href="javascript:void(0);" onclick="paging(1)">'+'<<'+'</a> ');
					for(var i = tmpnum ; i<=pagingNo ; i++){
						$("#paging").append('<a href="javascript:void(0);" onclick="paging('+(i)+')">'+(i)+'</a> ');
					}
					if(lastCount > 6 && num != lastCount)
						$("#paging").append('<a href="javascript:void(0);" onclick="paging('+(lastCount)+')">'+'>>'+'</a> ');
					
				}
			});
		}
		
		shortcut.add("F1", function() {
			initPage();
		});
		shortcut.add("F2", function() {
		    search();
		});
		shortcut.add("F3", function() {
			csvOutput();
		});
		shortcut.add("F4", function() {
			document.getElementById("openConfigModal").click();
		});
		
		function getTimeStamp() {
		  var d = new Date();
		  var s =
		    leadingZeros(d.getFullYear(), 4) + '-' +
		    leadingZeros(d.getMonth() + 1, 2) + '-' +
		    leadingZeros(d.getDate(), 2) + ' ' +

		    leadingZeros(d.getHours(), 2) + "-" +
		    leadingZeros(d.getMinutes(), 2) + "-" +
		    leadingZeros(d.getSeconds(), 2);

		  return s;
		}

		function leadingZeros(n, digits) {
		  var zero = '';
		  n = n.toString();

		  if (n.length < digits) {
		    for (i = 0; i < digits - n.length; i++)
		      zero += '0';
		  }
		  return zero + n;
		}
		
		function csvOutput(){
			if(!confirm("検索内容をCSVファイルで出力しますか？")){
	           	return;
	    	}
			var selArr = [];
			var checkedData = [];
			for(var i = 0; i<document.getElementById('showSearchResult').length; i++){
				selArr[i] = document.getElementById('showSearchResult')[i].value
			}

			$("input[name='withdrawl']:checked").each(function() {
				var test = $(this).val();
				checkedData.push(test);
			});
			var sorting = document.getElementById("hiddenSort").value;
		
			jQuery.ajaxSettings.traditional = true;
			
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=csvOutput',
				type:'post',
				data:{
					"selectView": $("#select_view option:selected").val(),
					"orderNo": $("#orderNumber").val(),
					"repNo": $("#repNo").val(),
					"orderDayStart": $("#orderDayStart").val(),
					"orderDayEnd": $("#orderDayEnd").val(),
					"shipDayStart": $("#shipDayStart").val(),
					"shipDayEnd": $("#shipDayStart").val(),
					"deliveryDayStart": $("#shipDayStart").val(),
					"deliveryDayEnd": $("#shipDayStart").val(),
					"withdrawl": checkedData,
					"productCodeInput": $("#productCodeInput").val(),
					"productNameInput": $("#productNameInput").val(),
					"product1": $("#product1").val(),
					"product2": $("#product2").val(),
					"product3": $("#product3").val(),
					"supplierCodeInput": $("#supplierCodeInput").val(),
					"supplierNameInput": $("#supplierNameInput").val(),
					"rowCount": $("#rowCount option:selected").val(),
					"list": selArr, 
					"sorting": sorting,
					"orderBy": orderBy
				},
				dataType:'json',
				success:function(data){	
					
					var csv = [];
			        var rows = document.querySelectorAll("#AddHead > tr");

			        for (let i = 0; i < rows.length; i++) {
			            const row = [], cols = rows[i].querySelectorAll("td, th");
			            for (let j = 0; j < cols.length; j++)
			                row.push(cols[j].innerText)

			            csv.push(row.join(","));
			        }
					
					for(let i = 0; i < Object.keys(data).length; i++){
						const row = [];
						for(var j = 0; j < selArr.length; j++){
							row.push(data[i][j]);
						}
						csv.push(row.join(","));
					}
					
					
					downloadCSV(csv.join("\n"), '受注検索('+ getTimeStamp() +').csv');
				}
			});
		}
		
		function downloadCSV(csv, filename) {
	        let csvFile;
	        let downloadLink;
	        
	        const BOM = "\uFEFF";
	        csv = BOM + csv

	        csvFile = new Blob([csv], {type: "text/csv"})

	        downloadLink = document.createElement("a")
	        downloadLink.download = filename;
	        downloadLink.href = window.URL.createObjectURL(csvFile)
	        downloadLink.style.display = "none"
	        document.body.appendChild(downloadLink)
	        downloadLink.click()
	    }
		
		function moveCustomerModal(){
			if(document.getElementById("customerCodeInput").value != "")
				document.getElementById("customerCode").value = document.getElementById("customerCodeInput").value;
			if(document.getElementById("customerNameInput").value != "")
				document.getElementById("customerName").value = document.getElementById("customerNameInput").value;
		}
		
		function moveProductModal(){
			if(document.getElementById("productCodeInput").value != "")
				document.getElementById("productCode").value = document.getElementById("productCodeInput").value;
			if(document.getElementById("productNameInput").value != "")
				document.getElementById("productName").value = document.getElementById("productNameInput").value;
		}
		
		function moveDeliveryModal(){
			if(document.getElementById("supplierCodeInput").value != null)
				document.getElementById("supplierCode").value = document.getElementById("supplierCodeInput").value;
			if(document.getElementById("supplierNameInput").value != null)
				document.getElementById("supplierName").value = document.getElementById("supplierNameInput").value;
		}
</script>
</html>
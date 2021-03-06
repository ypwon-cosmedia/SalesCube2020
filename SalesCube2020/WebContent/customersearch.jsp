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

    <title>SalesCube　顧客マスタ（検索）</title>
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
	    .red {color:#FF0000;}
	    
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
    
    <!-- メニューバー -->
    <%@ include file= "/common/menubar.jsp" %>
    
	<br>
    <div class="container" id="main_function">
      <h3 class="float-left">顧客検索</h3>
    
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()" >F1<br>初期化</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="doSubmit()">F2<br>検索</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="moveAddCustomerForm()" >F3<br>追加</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F4 <br></button>
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
      <p class="red">${message}</p>
      <p class="red">${message2}</p>
      <p class="red">${message3}</p>
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<form action="/SalesCube2020/SalesCube?action=searchCustomer" name="mainform" method="post">
			<div class="panel-heading row mb-2 col-4">
				<h5><br>顧客情報</h5>
			</div>
			<hr>
			<div class="panel-body">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客コード</div>
								</div>
							<input type="number" name="customerCode" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客名</div>
								</div>
                            <input type="text" name="customerName" class="form-control" id="inlineFormInputGroup">
                            </div>
						</div>

                        <div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
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
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">事業所名カナ</div>
								</div>
                            <input type="text" name="officeNameKana" class="form-control" id="inlineFormInputGroup">
                            </div>
						</div>

                        <div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
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
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">担当者カナ</div>
								</div>
                            <input type="text" name="PCNameKana" class="form-control" id="inlineFormInputGroup">
                            </div>
						</div>

                        <div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
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
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">支払条件</div>
								</div>
								<select class="custom-select" name="cutoffGroup">
									<option value=""></option>
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
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">備考</div>
								</div>
								<input type="text" name="remarks" class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
			</div>
		
		<br>
		<br>
		
			
			
			<div class="panel-body">

					<div align="right">
						<button type="button" class="btn btn-outline-secondary" onclick="initForm()">初期化</button>
						<input type="hidden" value="10" id="rowCount">
						<input type="submit" value="検索" class="btn btn-outline-secondary">
					</div>
			</div>
<br><br>
		<div class="container">
            <div class="float-left" style="position:static; left: 0px;">検索結果件数： ${fn:length(customerList)}件</div>
  
         	<div class="rounded float-right">
                ページあたりの表示件数
                <select id="rowCount" name="rowCount" onclick="moveRowCount(this)">
                    <option value="10">10</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>
			</div>
		</div>
		</form>	
    </div></div><br><br>
    
<br><br>

		<div class="container" style="background-color: rgb(255, 255, 255);" id="customerList">
  			<table id="order_detail_info" class="table table-bordered tablewidth">
				<thead class="thead-dark">
    				<tr>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="customerCode">顧客コード</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="customerName">顧客名</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="tel">TEL</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="PCName">担当者</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="salesCMCategory">取引区分</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="cutoffGroup">支払条件</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="officeName">事業所名</th>
						<th style="cursor: pointer; height: 30px;" class="sort" data-sort="deptName">部署名</th>
						<th style="cursor: pointer; height: 30px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody class="list">
				<c:forEach var="customer" items="${customerList}">
    				<tr>
						<th class="customerCode" scope="row">${customer.customerCode}</th>
						<td class="customerName" style="white-space: normal; text-align: left;">&nbsp;${customer.customerName}&nbsp;</td>
						<td class="tel" style="white-space: normal; text-align: left;">&nbsp;${customer.tel}&nbsp;</td>
						<td class="PCName" style="white-space: normal; text-align: left;">&nbsp;${customer.PCName}&nbsp;</td>
						<td class="salesCMCategory" style="white-space: normal; text-align: left;">&nbsp;${customer.salesCMCategory}&nbsp;</td>
						<td class="cutoffGroup" style="white-space: normal; text-align: left;">&nbsp;${customer.cutoffGroup}&nbsp;</td>
						<td class="officeName" style="white-space: normal; text-align: left;">&nbsp;${customer.officeName}&nbsp;</td>
						<td class="deptName" style="white-space: normal; text-align: left;">&nbsp;${customer.deptName}&nbsp;</td>
						<td style="text-align: center">
							<div style="display:inline-flex">
								<form action="/SalesCube2020/SalesCube?action=moveModifyCustomer" method="post">
									<input type="hidden" name="customerCode" value="${customer.customerCode}">	
									<input type="submit" class="btn btn-outline-secondary" value="編集">
								</form>
								<form action="/SalesCube2020/SalesCube?action=deleteCustomer" method="post">
									<input type="hidden" name="customerCode" value="${customer.customerCode}">	
									<input type="button" class="btn btn-outline-secondary" value="削除" onclick="deleteForm(this)" id="${customer.customerCode}">
								</form>
							</div>
						</td>
   					</tr>
   				</c:forEach></tbody>
			</table>
		</div>
		
		<form action="/SalesCube2020/SalesCube?action=deleteCustomer" method="post" name="deleteform">
			<input type="hidden" name="customerCode">
		</form>
		
<script src="//cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"></script>
<script>
var options = {
  valueNames: [ 'customerCode', 'customerName' , 'tel' , 'PCName' , 'salesCMCategory' , 'cutoffGroup' , 'officeName' , 'deptName' ]
};
var customerList = new List('customerList', options);
</script>


<script>
<%--function moveRowCount(rowCount) {
	const rowCount = rowCount.value;
	document.getElementById("rowCount").value = rowCount;
} --%>

function initForm() {
	if(!confirm("入力内容を初期化してよろしいですか？")){
		return;
	}
	window.location.href = '/SalesCube2020/SalesCube?action=customer';
}
   	
function backForm() {
	if(!confirm("メニュー画面に戻ります。よろしいですか？")) {
		return;
	}
	window.location.href = '/SalesCube2020/SalesCube?action=menu';
}
   		
function moveAddCustomerForm() {
   	window.location.href = '/SalesCube2020/SalesCube?action=moveAddCustomer';
}
   		
function deleteForm(elm) {
	if(!confirm("このデータを削除しますか？")) {
		return;
	}
	
	var check = elm.id;
	
	var form = document.deleteform;
	
	form.customerCode.value = check;
	
	form.submit();
   			
}
   		
function customerHistoryOutPut() {
	if(!confirm("履歴をExcel出力しますか？")) {
		return;
	}		
}


function doSubmit(){
	var form = document.mainform;
	
	form.submit();
}
</script>
	</body>
</html>

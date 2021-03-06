<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    
<% int rowCount;

	if((String) request.getParameter("rowCount")==null){
		rowCount = 100;
	} else{
		rowCount =Integer.parseInt((String) request.getParameter("rowCount"));
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<title>セット商品</title>
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
      <h3 class="float-left">セット商品</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm();">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="doSubmit();">F2<br>検索</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F3<br></button>
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
      <form action="/SalesCube2020/SalesCube?action=searchSetProduct" method="post" name="mainform">
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
							<input type="text"  class="form-control" id="inlineFormInputGroup" name="data1">
							</div>
						</div>
						<div class="col-8">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">セット商品名</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup" name="data2">
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

				<div class="panel-body">	
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup"></label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">商品コード</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup" name="data3">
							</div>
						</div>
						
					</div>
					<div class="row">
					<div class="col-8">
						<label class="sr-only" for="inlineFormInputGroup">productKana</label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">商品名</div>
							</div>
						<input type="text"  class="form-control" id="inlineFormInputGroup" name="data4">
						</div>
					</div>
				</div>
			</div>
				
				<div align="right">
					<input type="button" value="初期化" class="btn btn-outline-secondary" onclick="initForm();">
					<input type="submit" value="検索" class="btn btn-outline-secondary">
				</div>
			
			
		</div><br></div><br>
		
		
		<div class="container">
            <div class="float-left" style="position:static; left: 0px;">検索結果件数：${fn:length(searchData)} 件
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		  		<c:forEach var="pageCount" items="${totalPage}">
					<a id='MySelect' href="http://localhost:8080/SalesCube2020/SalesCube?action=searchSetProduct&rowCount=${rowCount}&currentPage=${pageCount}" >${pageCount}</a>
				</c:forEach>
			</div>
			
         	<div class="rounded float-right">
                ページあたりの表示件数
                <select id="rowCount" name="rowCount">
                    <option value="10">10</option>
                    <option value="50">50</option>
                    <option value="100" selected>100</option>
                </select>
			</div>
		</div>
    </form>
    
<br>

<br>

<div class="container" style="background-color: rgb(255, 255, 255);" id="setProductList">
    <table id="order_detail_info" class="table table-bordered">
		<thead class="thead-dark">
    		<tr>
				<th scope="col" class="sort rd_top_left th_back_black" style="cursor: pointer; height: 30px;" data-sort="productCode">セット商品コード</th>
				<th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;" data-sort="productName">セット商品名</th>
				<th scope="col" class="rd_top_right th_back_black" style="cursor: pointer; height: 30px;">&nbsp;</th>
			</tr>
		</thead>
		<tbody class="list">
			<c:forEach var="product" items="${searchData}" varStatus="status">   
			    <tr>	      
					<th class="productCode" scope="row">${product.productCode}</th>
					<td class="productName" style="white-space: normal; text-align: left;">&nbsp;${product.productName}&nbsp;</td>	
					<td style="text-align: center">
					  <form action="/SalesCube2020/SalesCube?action=moveModifySetProduct" method="post" accept-charset="UTF-8">
					  	<input type="hidden" name="productCode" value="${product.productCode}">
						<input type="hidden" name="productName" value="${product.productName}">
						<input type="submit" class="btn btn-outline-secondary" value="編集">
					  </form>
					</td>		  
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="//cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"></script>
<script>
var options = {
  valueNames: [ 'productCode', 'productName' ]
};
var setProductList = new List('setProductList', options);
</script>
<script>
$(function() {
    var temp = "<%= rowCount %>"; 
    $("#rowCount").val(temp);
});
function initForm() {
	if(!confirm("入力内容を初期化してよろしいですか？")){
		return;
	} 
	window.location.href = '/SalesCube2020/SalesCube?action=setProduct';
}
function doSubmit(){
	var form = document.mainform;
	
	form.submit();
}

</script>
</body>
</html>
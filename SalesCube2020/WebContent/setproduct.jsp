<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    
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
<title>Insert title here</title>
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
      <h3 class="float-left">セット商品</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F1<br>初期化</button>
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
      <form action="/SalesCube2020/SalesCube?action=searchSetProduct" method="post">
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
							<!-- <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;"> -->
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
							<input type="text"  class="form-control" id="inlineFormInputGroup" name="data3">				<!--<input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;"> -->
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
					<input type="button" value="初期化" class="btn btn-outline-secondary">
					<input type="submit" value="検索" class="btn btn-outline-secondary">
				</div>
			
			
		</div><br></div><br>
		</form>
		
		<div class="container">
            <div class="float-left" style="position:static; left: 0px;">検索結果件数：${fn:length(searchData)} 件</div>
  
         	<div class="rounded float-right">
                ページあたりの表示件数
                <select id="rowCount" name="rowCount">
                    <option value="10">10</option>
                    <option value="50">50</option>
                    <option value="100" selected>100</option>
                </select>
			</div>
		</div>
    
    </div>
<br><br>
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
</body>
</html>
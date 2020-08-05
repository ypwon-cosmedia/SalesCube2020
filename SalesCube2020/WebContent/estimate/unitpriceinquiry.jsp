<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>単価照会</title>
    <style type="text/css">  
      .table {
        color: #0a0a0a;
        /* 隣接するセルの境界線を間隔をあけて表示 */
        border-collapse: separate;
        /* 隣接するセルの線と線の間隔を0に */
        border-spacing: 0;
        border: 1px solid rgb(157, 158, 160);
        border-radius: 4px;
        background-color: #fff;
      }
      .table thead th {
        padding: .5em .6em;
        border-bottom: 1px solid rgb(157, 158, 160);
      }
      .table tbody tr td {
        padding: .5em .9em;
      }
      /* 2列目以降のセルの左だけ線を表示 */
      .table tbody tr td + td {
        border-left: 1px solid rgb(157, 158, 160);
      }
      /* 2行目以降のセルの上だけ線を表示 */
      .table tbody tr + tr td {
        border-top: 1px solid rgb(157, 158, 160);
      }

      .ModalButton {
            padding: 0;
            border: none;
            background: transparent;
      }
    
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

     .table_item {
      width: 120px;
      color: rgb(27, 27, 27);
      background-color: rgb(194, 197, 201);
     }

     .td_width180 {
      width: 180px;
     }

     .tr_line-height10 {
      line-height: 10px;
     }

     .back_black {
       color: rgb(27, 27, 27);
       background-color: rgb(194, 197, 201);
     }

     .table_width{
       width: 600px;
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
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              受注
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">受注入力</a>
              <a class="dropdown-item" href="#">受注検索</a>
              <a class="dropdown-item" href="#">オンライン受注データ取込</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              見積
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="estimateadd.html">見積入力</a>
              <a class="dropdown-item" href="estimateSearch.html">見積検索</a>
              <a class="dropdown-item" href="unitpriceinquiry.html">単価照会</a>
            </div>
          </li>
        </ul>
        
        <span class="navbar-text">
          <svg class="bi bi-person-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
          </svg>
        	<!-- ${userInfo.nameKNJ} --> 管理者&nbsp;     	
        </span>
        <form class="form-inline" action="/SalesCube2020/SalesCube?action=logout" method="post">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
    </nav>

    <br>

    <div class="container" id="main_function">
      <h3 class="float-left">単価照会</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm();">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="doSubmit();">F2<br>検索</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F3<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F4<br></button>
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

    <form action="/SalesCube2020/SalesCube?action=unitPriceInquirySearch" method="post" name="mainform">
      <div class="container" style="background-color: white;">
        <div class="panel panel-default" >
			    <div class="panel-heading row mb-2 col-4">
				     <h5><br>検索条件</h5>
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
                    <input type="text" value="" class="form-control" id="inlineFormInputGroup" name="productCode">
                    <button type="button" class="ModalButton"  data-toggle="modal" data-target="#setShipDate">
                      <img src="btn_search.png" style="vertical-align: middle; cursor: pointer; width: 32px; height: 32px;">
                    </button>
					  		</div>
              </div>
            </div>
          </div>

          <div align="right">
            <input type="button" value="初期化" class="btn btn-primary" onclick="initForm();">
            <input type="submit" value="検索" class="btn btn-primary">
          </div>
        </div>
          <br>
      </div>
		  <br>
      <br>
    </form>
      
      <div id="resultHidden" hidden>

        <div class="container" style="background-color: white;">
          <div class="panel panel-default" >
            <div class="panel-heading row mb-2 col-4">
              <h5><br>商品情報</h5>
            </div>
            <hr>
            <table id="order_detail_info" class="table table-bordered">
              <tr class="tr_line-height10">
                <td class="table_item">商品名</td>
                <td>${searchResult.productName}</td>
                <td class="table_item">売単価</td>
                <td class="td_width180"><fmt:parseNumber value="${searchResult.retailPrice}" integerOnly="true" /></td>
              </tr>
              <tr class="tr_line-height10">
                <td class="table_item">備考</td>
                <td colspan="3">${searchResult.productRemarks}</td>
              </tr>
            </table>
          </div><p>&nbsp;</p>
        </div><br>

        <div class="container" style="background-color: white;">
          <div class="panel panel-default" >
            <div class="panel-heading row mb-2 col-4">
              <h5><br>割引情報</h5>
            </div>
            <hr>
            <table id="order_detail_info" class="table table-bordered">
              <tr class="tr_line-height10">
                <td class="table_item">割引コード</td>
                <td class="td_width180">${searchResult.discountId}</td>
                <td class="table_item">割引名</td>
                <td>${searchResult.discountName}</td>
              </tr>
              <tr class="tr_line-height10">
                <td class="table_item">備考</td>
                <td colspan="3">${searchResult.discountRemarks}</td>
              </tr>
            </table>
          </div><p>&nbsp;</p>
        </div><br>

        <div class="container" style="background-color: white;">
          <div class="panel panel-default" >
            <div class="panel-heading row mb-2 col-4">
              <h5><br>数量スライド設定</h5>
            </div>
            <hr>
            <table id="order_detail_info" class="table table-bordered">
              <thead class="back_black">
                <tr class="tr_line-height10">
                  <th scope="col" style="font-weight: 500;">no</th>
                  <th scope="col" style="font-weight: 500;">数量割引</th>
                  <th scope="col" style="font-weight: 500;">割引率</th>
                  <th scope="col" style="font-weight: 500;">単価</th>
                </tr>
              </thead>
              <tbody class="">
                <c:forEach var="slide" items="${quantitySlideSettingList}">   
                    <tr class="tr_line-height10">	      
                      <td>${slide.lineNo}</td>
                      <td>${slide.dataFromTo}</td>	
                      <td>${slide.discountRate}<span>%</span></td>
                      <td><fmt:parseNumber value="${searchResult.retailPrice * (1- (slide.discountRate / 100 ))}" integerOnly="true" /></td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
          </div><p>&nbsp;</p>
        </div><br>

        <div class="container" style="background-color: white;">
          <div class="panel panel-default">
            <div class="panel-heading row mb-2 col-4">
              <h5><br>商品在庫情報</h5>
            </div>
            <hr>			

            <table class="table table-bordered">
              <tr class="tr_line-height10">
                <td class="table_item" style="width:160px">仕入先商品コード</td>
                <td>${searchResult.supplierPCode}</td>
                <td class="table_item">セット分類</td>
                <td>${searchResult.setTypeCategory}</td>
                <td class="table_item">倉庫名</td>
                <td>${searchResult.warehouseName}</td>
              </tr>
              <tr class="tr_line-height10">
                <td class="table_item">棚番</td>
                <td>${searchResult.rackCode}</td>
                <td class="table_item">分類-状態</td>
                <td>${searchResult.productStatus}</td>
                <td class="table_item">分類-保管</td>
                <td>${searchResult.productStock}</td>
              </tr>
            </table>
            <br>           
            <table class="table table-bordered">
              <tr class="tr_line-height10">
                <td class="table_item">現在庫総数</td>
                <td class="table_item">受注残数</td>
              </tr>
              <tr class="tr_line-height10">
                <td><fmt:parseNumber value="${searchResult.stockQuantity}" integerOnly="true" /></td>
                <td><fmt:parseNumber value="${searchResult.quantityTotal}" integerOnly="true" /></td>
              </tr>
            </table>       
            
            受注残明細
            <table class="table table-bordered">
              <tr class="tr_line-height10">
                <th class="table_item" style="font-weight: 500;">受注番号-行</th>
                <th class="table_item" style="font-weight: 500;">出荷日</th>
                <th class="table_item" style="font-weight: 500;">受注残数</th>
              </tr>
              
              <c:forEach var="order" items="${orderStatementList}"> 
	              <tr class="tr_line-height10">
	                <td><a href="#">${order.orderNoLine}</a></td>
	                <td>${order.shipDate}</td>
	                <td>${order.quantity}</td>
	              </tr>
	          </c:forEach>

            </table>
          </div><p>&nbsp;</p>
        </div><br><br>

      </div>
  </body>

  <script>
	  /* 画面読み込み時、リクエストスコープに"status"に"result"が保存されている場合、結果画面を表示する */
	  window.onload = function () {
		  if("${status}" == "result"){
		      document.getElementById("resultHidden").removeAttribute("hidden");
		  } else if("${status}" == "err") {
			  alert("該当データが存在しませんでした。");
		  } else{}
	  };
      
    /* 入力値の初期化 */
    function initForm() {
      if(!confirm("入力内容を初期化してよろしいですか？")){
        return;
      }
      location.href = '/SalesCube2020/SalesCube?action=moveUnitPriceInquiry';
    }
    
    /* 単価計算 */
    function unitPriceCalculation(obj){
    	
    }

  </script>
</html>
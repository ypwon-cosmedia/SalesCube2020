<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>見積編集</title>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
        text-align: center;
        vertical-align:middle;
      }
      /* 2列目以降のセルの左だけ線を表示 */
      .table tbody tr td + td {
        border-left: 1px solid rgb(157, 158, 160);
      }
      /* 2行目以降のセルの上だけ線を表示 */
      .table tbody tr + tr td {
        border-top: 1px solid rgb(157, 158, 160);
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

     .table-button{
      width:80px;
      height:28px;
      font-size: 12px;
     }

     .backpink{
       background-color: pink;
     }

    .ModalButton {
      padding: 0;
      border: none;
      background: transparent;
    }

    </style>
</head>
  <body style="background-color: gainsboro;">
    <!-- モーダル -->
  	<%@ include file="/estimate/_shipdate.jsp" %>
	<%@ include file="/estimate/_quotationCondition.jsp" %>
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
        	${userInfo.nameKNJ}&nbsp;     	
        </span>
        <form class="form-inline" action="/SalesCube2020/SalesCube?action=logout" method="post">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
    </nav>

    <br>

    <div class="container" id="main_function">
      <h3 class="float-left">見積編集</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="moveEstimateAdd()">F1<br>戻る</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="estimateDelete();">F2<br>削除</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="modifyForm();">F3<br>更新</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="outputPdf();">F4<br>PDF</button>
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
    
    <div class="container">
    	<div><h5 id="message" style="color:#ff0000;"></h5></div>
    </div>

    <form action="/SalesCube2020/SalesCube?action=estimateModify" method="post" name="modifyform">
      <div class="container" style="background-color: white;">
        <div class="panel panel-default" >
			    <div class="panel-heading row mb-2 col-4">
				     <h5><br>見積伝票情報</h5>
			    </div>
			    <hr>
		
			  	<div class="panel-body">
				    <div class="row">
					    <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text"  style="background-color: pink;">見積番号</div>
						  		</div>
						   	  <input type="text" name="estimateSheetId" value="${estimate.estimateSheetId}" class="form-control" id="inlineFormInputGroup" name="estimateSheetId" pattern="^[0-9A-Za-z]+$" readonly>
					  		</div>
              </div>

              <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text" style="background-color: pink;">見積日</div>
						  		</div>
                  <input type="date" name="estimateDate" value="${estimate.estimateDate}" required>
					  		</div>
              </div>

              <div class="col-6">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">納期または出荷日</div>
						  		</div>
                   <input type="text" value="${estimate.deliveryInfo}" class="form-control" id="deliveryInfo" name="deliveryInfo">
                   <button type="button" class="ModalButton"  data-toggle="modal" data-target="#setShipDate" onclick="deliveryInfoShow()">
                    <img src="btn_search.png" style="vertical-align: middle; cursor: pointer; width: 32px; height: 32px;">
                  </button>
					  		</div>
				  		</div>
            </div>

            <div class="row">
					    <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">有効期限</div>
						  		</div>
                  <input type="date" name="validDate" value="${estimate.validDate}">
					  		</div>
              </div>

              <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">入力担当者</div>
						  		</div>
						   	  <input type="text" value="${estimate.userName}" class="form-control" id="inlineFormInputGroup" name="userName" readonly>
					  		</div>
              </div>

              <div class="col-5">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">件名</div>
						  		</div>
						   	  <input type="text" value="${estimate.title}" class="form-control" id="inlineFormInputGroup" name="title">
					  		</div>
				  		</div>
            </div>

            <div class="row">
					    <div class="col-10">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">納入先</div>
						  		</div>
						   	  <input type="text" value="${estimate.deliveryName}" class="form-control" id="inlineFormInputGroup" name="deliveryName">
					  		</div>
              </div>
            </div>

            <div class="row">
					    <div class="col-10">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">見積条件</div>
						  		</div>
                  <textarea cols="3" style="width: 750px;" id="estimateCondition" name="estimateCondition" value="${estimate.estimateCondition}">${estimate.estimateCondition}</textarea>
                  <button type="button" class="ModalButton"  data-toggle="modal" data-target="#setQuotationCondition" onclick="conditionShow()">
                    <img src="btn_search.png" style="vertical-align: middle; cursor: pointer; width: 32px; height: 32px;">
                  </button>
					  		</div>
              </div>
            </div>

            <div class="row">
					    <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">消費税率</div>
						  		</div>
                  <select class="custom-select" name="ctaxRate" id="taxRate" onchange="totalCalculation()">
                    <option value="0">消費税なし</option>
                    <c:forEach var="taxRateList" items="${taxRateList}">
						<option value="${taxRateList.taxRate}">${taxRateList.taxRate}</option>
                    </c:forEach>
                  </select>
                  <div style="margin-top: 7px;">%</div>
					  		</div>
              </div>
            </div>
          </div>
        </div>
        <br>
      </div>
		  <br>
      <br>

      <div class="container" style="background-color: white;">
        <div class="panel panel-default" >
          <div class="panel-heading row mb-2 col-4">
             <h5><br>顧客情報</h5>
          </div>
          <hr>  
  
          <div class="panel-body">
            <div class="row">
              <div class="col-7">
                <label class="sr-only" for="inlineFormInputGroup"></label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text" style="background-color: pink;">提出先名</div>
                  </div>
                  <input type="text" value="${estimate.submitName}" class="form-control" id="submitName" name="submitName" required>&emsp;&emsp;
                </div>
              </div>

              <div class="col-3">
                <label class="sr-only" for="inlineFormInputGroup"></label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">提出先敬称</div>
                  </div>
                  <select class="custom-select" name="submitPre" id="submitPre">
                    <option></option>
                    <c:forEach var="submitPre" items="${submitPreList}">
						<option value="${submitPre.categoryCode}">${submitPre.categoryCodeName}</option>
                    </c:forEach>

                  </select>
                </div>
              </div>

            </div><br>

            <div class="container" style="width: auto" >
              <div class="panel-heading row mb-2 col-4" >
                <h6><br>既存顧客情報</h6>
              </div><hr width="1015">
            

              <div class="row">
                <div class="col-4">
                  <label class="sr-only" for="inlineFormInputGroup"></label>
                  <div class="input-group mb-2">&emsp;&emsp;&emsp;&emsp;
                    <div class="input-group-prepend">
                      <div class="input-group-text">顧客コード</div>
                    </div>
                      <input type="text" value="${estimate.customerCode}" class="form-control" name="customerCode" id="customerCode" onchange="getCustomer(this)">
                      <button type="button" class="ModalButton"  data-toggle="modal" data-target="#customerSearch">
                        <img src="btn_search.png" style="vertical-align: middle; cursor: pointer; width: 32px; height: 32px;">
                      </button>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-6">
                <label class="sr-only" for="inlineFormInputGroup"></label>
                  <div class="input-group mb-2">&emsp;&emsp;&emsp;&emsp;
                    <div class="input-group-prepend">
                      <div class="input-group-text">顧客名</div>
                    </div>
                    <input type="text" value="${estimate.customerName}" class="form-control" name="customerName" id="customerName" readonly>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-9">
                  <label class="sr-only" for="inlineFormInputGroup"></label>
                  <div class="input-group mb-2">&emsp;&emsp;&emsp;&emsp;
                    <div class="input-group-prepend">
                      <div class="input-group-text">備考</div>
                    </div>
                      <input type="text" value="${estimate.customerRemarks}" class="form-control" name="customerRemarks"  id="customerRemarks" readonly>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-9">
                  <label class="sr-only" for="inlineFormInputGroup"></label>
                  <div class="input-group mb-2">&emsp;&emsp;&emsp;&emsp;
                    <div class="input-group-prepend">
                      <div class="input-group-text">コメント</div>
                    </div>
                      <input type="text" value="${estimate.customerComment}" class="form-control" name="customerComment"  id="customerComment" readonly>
                  </div>
                </div>
              </div>
            </div>
            
          </div>
        </div><p>&nbsp;</p>
      </div><br>

      <div class="container" style="background-color: white;">
        <div class="panel panel-default" >
          <div class="panel-heading row mb-2 col-4">
            <h5><br>摘要</h5>
          </div>
          <hr>
  
          <div class="panel-body">
            <div class="row">
              <div class="col-9">
                <label class="sr-only" for="inlineFormInputGroup"></label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">摘要</div>
                  </div>
                  <textarea name="remarks" value="${estimate.remarks}" cols="100">${estimate.remarks}</textarea>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-9">
                <label class="sr-only" for="inlineFormInputGroup"></label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">メモ</div>
                  </div>
                  <textarea name="memo" value="${estimate.memo}" cols="100">${estimate.memo}</textarea>
                </div>
              </div>
            </div>
          </div>
        </div><p>&nbsp;</p>
      </div><br>
    
      <!-- 見積商品一覧のテーブル -->
      <div class="container" style="background-color: rgb(255, 255, 255);">
        <table id="estimate" class="table table-bordered" style="font-size:8pt; width: 1120px;  position:relative;right:15px">
          <thead class="thead-dark">
            <tr>
              <th style="height: 30px; width: 5%; ">No</th>
              <th style="height: 30px; text-align: center; width: 15%;">商品コード※</th>
              <th style="height: 30px; text-align: center; width: 20%;">商品名・摘要</th>
              <th style="height: 30px; text-align: center; width: 10%;">数量※</th>
              <th style="height: 30px; text-align: center; width: 10%;">仕入れ単価<br>仕入れ金額</th>
              <th style="height: 30px; text-align: center; width: 10%;">売上単価※<br>売価金額※</th>
              <th style="height: 30px; text-align: center; width: 20%;">備考</th>
              <th style="height: 30px; text-align: center; width: 10%;">&nbsp;</th>
            </tr>
        </thead>

        <tbody>
        	<c:forEach var="product" items="${estimateProductList}" varStatus="status">
		  		<tr id="tr${status.count}">
		            <td rowspan="2">${status.count}</td>
		            <td rowspan="2" class="backpink"><input type="text" name="productCode" id="productCode${status.count}" value="${product.productCode}" style="width: 110px;" onchange="getProduct(this)" required>
		              <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 22px;"></td>
		            <td rowspan="2"><textarea name="productAbstract" rows="3" style="width: 200px;" id="productAbstract${status.count}" value="${product.productAbstract}">${product.productAbstract}</textarea></td>
		            <td class="backpink"><input type="number" name="quantity" value="${product.quantity}" id="quantity${status.count}" style="width: 75px;" onchange="quantityChange(this)" required></td>
		            <td><input type="text" name="unitCost" value="${product.unitCost}" id="unitCost${status.count}" style="background-color:rgb(177, 177, 177); width: 75px;" readonly></td>
		            <td class="backpink"><input type="number" name="unitRetailPrice" value="${product.unitRetailPrice}" id="unitRetailPrice${status.count}" style="width: 75px;" onchange="unitRetailPriceChange(this)" required></td>
		            <td rowspan="2"><textarea name="productRemarks" value="${product.productRemarks}" rows="3" style="width: 200px;" id="remarks${status.count}">${product.productRemarks}</textarea></td>
		            <td><button type="button" class="btn btn-primary table-button"  onclick="deleteLineForm(this)" id="delete${status.count}">削除</button></td>
		          </tr>
		
		          <tr>
		            <td class="backpink"><button type="button" class="btn btn-primary table-button">在庫</button></td>
		            <td><input type="text" name="cost" value="${product.cost}" style="background-color:rgb(177, 177, 177); width: 75px;" id="cost${status.count}" readonly></td>
		            <td class="backpink"><input type="text" name="retailPrice" value="${product.retailPrice}" id="retailPrice${status.count}" style="width: 75px; background-color:rgb(177, 177, 177);" readonly></td>
		            <td><button type="button" class="btn btn-primary table-button" onclick="previousCopy(this)"  id="previousCopy${status.count}" disabled>前行複写</button></td>
          		</tr>
        	</c:forEach>
        </tbody>

      </table>
    </div>

    <div align="center">
			<button type="button" class="btn btn-primary" id="addLine">行追加</button>
		</div><br>

	<!-- 金額合計等のテーブル -->
    <div class="container" style="background-color: rgb(255, 255, 255);">
      <table id="sum" class="table table-bordered" style="font-size:15pt ; width: 1120px;  position:relative;right:15px">
        <thead class="thead-dark">
          <tr style="height: 15px;">
            <th style="height: 30px; text-align: center;">粗利益</th>
            <th style="height: 30px; text-align: center;">粗利益率</th>
            <th style="height: 30px; text-align: center;">金額合計</th>
            <th style="height: 30px; text-align: center;">消費税</th>
            <th style="height: 30px; text-align: center;">伝票合計</th>
          </tr>
        </thead>
        <tbody>
        <tr>
          <td>￥<span id="grossProfit">0</span></td>
          <td><span id="grossProfitMargin">0.00</span> %</td>
          <td>￥<span id="retailPriceTotal">0</span></td>
          	<input type="hidden" value="0" id="inputRetailPriceTotal" name="retailPriceTotal">
          <td>￥<span id="taxPriceTotal">0</span></td>
          	<input type="hidden" value="0" id="inputTaxPriceTotal" name="taxPriceTotal">
          <td>￥<span id="estimateTotal">0</span></td>
          	<input type="hidden" value="0" id="inputEstimateTotal" name="estimateTotal">
          	<input type="hidden" value="0" id="inputCostTotal" name="costTotal">
        </tr>
        </tbody>
      </table>
    </div>

    <div class="container" style="text-align:center">
      <input type="submit" class="btn btn-primary" value="更新" style="width:200px; height:50px;">
    </div>
    <br><br>
  </form>
  
  <!-- 削除用form -->
  <form action="/SalesCube2020/SalesCube?action=estimateDelete" method="post" name="deleteform">
	<input type="hidden" name="estimateSheetId" value="${estimate.estimateSheetId}">
  </form>
  
    <!-- PDF出力用form -->
  <form action="/SalesCube2020/SalesCube?action=estimatePdfOutput" method="post" name="pdfform">
	<input type="hidden" name="estimateSheetId" value="${estimate.estimateSheetId}">
  </form>
	

  </body>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script>
    /* 戻る */
	function moveEstimateAdd() {
		if(!confirm("登録画面に戻りますか？")){
			return;
		}
		location.href = '/SalesCube2020/SalesCube?action=moveEstimateAdd';
	}

	/* 更新 */
	function modifyForm() {
		if(!confirm("入力内容で更新します。よろしいですか？")){
			return;
		}
		var form = document.modifyform;
		form.submit();
	}
	
	/* 見積削除 */
	function estimateDelete() {
		 if(!confirm("このデータを削除しますか？")){
				return;
		 }
		 var form = document.deleteform;
		 form.submit();
	}
	

      /* 行追加 */
	$('#addLine').click(function() {
		var tableNo = ($("#estimate tr").length + 1) / 2; //新しく追加するNo、( (テーブルの行数(見出し1行+ データ行*2n) + 1(新しい行数にするための補完))/2) = 新規に追加する見出しNoになる)
        $('#estimate > tbody:last').append(
          '<tr>' +
            '<td rowspan="2">' + tableNo + '</td>' +
            '<td rowspan="2" class="backpink"><input type="text" name="productCode" id="productCode' + tableNo + '" value="" style="width: 110px;" onchange="getProduct(this)" required>' +
              '<input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 22px;"></td>' +
            '<td rowspan="2"><textarea name="productAbstract" rows="3" style="width: 200px;" id="productAbstract' + tableNo + '"></textarea></td>' +
            '<td class="backpink"><input type="number" name="quantity" value="" id="quantity' + tableNo + '" style="width: 75px;" onchange="quantityChange(this)" required></td>' +
            '<td><input type="text" name="unitCost" value="" id="unitCost' + tableNo + '" style="background-color:rgb(177, 177, 177); width: 75px;" readonly></td>' +
            '<td class="backpink"><input type="number" name="unitRetailPrice" id="unitRetailPrice' + tableNo + '" style="width: 75px;" onchange="unitRetailPriceChange(this)" required></td>' +
            '<td rowspan="2"><textarea name="productRemarks" value="" rows="3" style="width: 200px;" id="remarks' + tableNo + '"></textarea></td>' +
            '<td><button type="button" class="btn btn-primary table-button"  onclick="deleteLineForm(this)"  id="delete' + tableNo + '">削除</button></td>' +
          '</tr>' +

          '<tr>' +
            '<td class="backpink"><button type="button" class="btn btn-primary table-button">在庫</button></td>' +
            '<td><input type="text" name="cost" value="" style="background-color:rgb(177, 177, 177); width: 75px;" id="cost' + tableNo + '" readonly></td>' +
            '<td class="backpink"><input type="text" name="retailPrice" value="" id="retailPrice' + tableNo + '" style="width: 75px; background-color:rgb(177, 177, 177);" readonly></td>' +
            '<td><button type="button" class="btn btn-primary table-button" onclick="previousCopy(this)" id="previousCopy' + tableNo + '">前行複写</button></td>' +
          '</tr>' );
			});


      /* 削除 */
      function deleteLineForm(obj){
        var row_num = document.getElementById('estimate').getElementsByTagName('tr').length;    //表の行数を取得
        //表に二行以上あるとき末尾行を削除（見出し行は削除しない）
        if (row_num > 3) { //(見出し1行+最前列2行)より大きい場合実施
          var tableNo_id = obj.id;
          var tableNo = tableNo_id.substr(6); //対象のtableNo：ボタンをクリックした列のtableNoを取得
          var lastTableNo = ((document.getElementById('estimate').getElementsByTagName('tr').length) -1 ) / 2;//最後のtableNo：(全行(見出し1行 + 各商品行2n行)-1(見出し行)) /2 (商品行だけ取得)

          iTableNo = Number(tableNo);

          /* 後行複写(対象の行まで) */
          for(var i = iTableNo; i < lastTableNo; i++)  {
            var nextTableNo = i + 1; //後行のtableNo：対象のtableNo+1

            var productCode_id = document.getElementById('productCode' + i); //対象のproductCodeのid
            var trailingProductCode_id = document.getElementById('productCode' + nextTableNo); //後行のproductCodeのid
            var trailingProductCode = trailingProductCode_id.value; //後行のproductCodeのvalueを取得
            productCode_id.value = trailingProductCode; //後行の商品コードを対象の列に移行

            /* 商品名・摘要複写 */
            var productAbstract_id = document.getElementById('productAbstract' + i);//対象のproductAbstractのid
            var trailingProductAbstract_id = document.getElementById('productAbstract' + nextTableNo);//後行のproductAbstractのid
            var trailingProductAbstract = trailingProductAbstract_id.value; //後行のproductAbstractのvalueを取得
            productAbstract_id.value = trailingProductAbstract; //後行の商品名・摘要を対象の列に移行

            /* 数量複写 */
            var quantity_id = document.getElementById('quantity' + i);//対象のquantityのid
            var trailingQuantity_id = document.getElementById('quantity' + nextTableNo);//後行のquantityのid
            var trailingQuantity = trailingQuantity_id.value; //後行のquantityのvalueを取得
            quantity_id.value = trailingQuantity; //後行の数量複写を対象の列に移行

            /* 仕入単価複写 */
            var unitCost_id = document.getElementById('unitCost' + i);//対象のunitCostのid
            var trailingUnitCost_id = document.getElementById('unitCost' + nextTableNo);//後行のunitCostのid
            var trailingUnitCost = trailingUnitCost_id.value; //後行のunitCostのvalueを取得
            unitCost_id.value = trailingUnitCost; //後行の仕入単価を対象の列に移行

            /* 売上単価複写 */
            var unitRetailPrice_id = document.getElementById('unitRetailPrice' + i);//対象のunitRetailPriceのid
            var trailingUnitRetailPrice_id = document.getElementById('unitRetailPrice' + nextTableNo);//後行のunitRetailPriceのid
            var trailingUnitRetailPrice = trailingUnitRetailPrice_id.value; //後行のunitRetailPriceのvalueを取得
            unitRetailPrice_id.value = trailingUnitRetailPrice; //後行の売上単価を対象の列に移行
            
            /* 備考複写 */
            var remarks_id = document.getElementById('remarks' + i);//対象のremarksのid
            var trailingRemarks_id = document.getElementById('remarks' + nextTableNo);//後行のremarksのid
            var trailingRemarks = trailingRemarks_id.value; //後行のremarksのvalueを取得
            remarks_id.value = trailingRemarks; //後行の備考を対象の列に移行
            
            /* 仕入金額(仕入単価*数量)複写 */
            var cost_id = document.getElementById('cost' + i);//対象のcostのid
            var trailingCost_id = document.getElementById('cost' + nextTableNo);//後行のcostのid
            var trailingCost = trailingCost_id.value; //後行のcostのvalueを取得
            cost_id.value = trailingCost; //後行の仕入金額を対象の列に移行

            /* 売上金額(売上単価×数量)複写 */
            var retailPrice_id = document.getElementById('retailPrice' + i);//対象のretailPriceのid
            var trailingRetailPrice_id = document.getElementById('retailPrice' + nextTableNo);//後行のretailPriceのid
            var trailingRetailPrice = trailingRetailPrice_id.value; //後行のretailPriceのvalueを取得
            retailPrice_id.value = trailingRetailPrice; //後行の売上金額を対象の列に移行

          }
          $( '#estimate tr:last' ).remove();
          $( '#estimate tr:last' ).remove();
        } else {
          alert("最前列は削除できません。")
        }
        totalCalculation()
      }


      /* 前行複写 */
      function previousCopy(obj){

        var tableNo_id = obj.id;
        var tableNo = tableNo_id.substr(12); //対象のtableNo：ボタンをクリックした列のtableNoを取得
        var acquisitionTableNo = tableNo -1; //前行のtableNo：対象のtableNo-1

        /* 商品コード複写 */
        var productCode_id = document.getElementById('productCode' + tableNo);//対象のproductCodeのid
        var acquisitionProductCode_id = document.getElementById('productCode' + acquisitionTableNo);//前行のproductCodeのid
        var acquisitionProductCode = acquisitionProductCode_id.value; //前行のproductCodeのvalueを取得
        productCode_id.value = acquisitionProductCode; //前行の商品コードを対象の列に移行

        /* 商品名・摘要複写 */
        var productAbstract_id = document.getElementById('productAbstract' + tableNo);//対象のproductAbstractのid
        var acquisitionProductAbstract_id = document.getElementById('productAbstract' + acquisitionTableNo);//前行のproductAbstractのid
        var acquisitionProductAbstract = acquisitionProductAbstract_id.value; //前行のproductAbstractのvalueを取得
        productAbstract_id.value = acquisitionProductAbstract; //前行の商品名・摘要を対象の列に移行

        /* 数量複写 */
        var quantity_id = document.getElementById('quantity' + tableNo);//対象のquantityのid
        var acquisitionQuantity_id = document.getElementById('quantity' + acquisitionTableNo);//前行のquantityのid
        var acquisitionQuantity = acquisitionQuantity_id.value; //前行のquantityのvalueを取得
        quantity_id.value = acquisitionQuantity; //前行の数量複写を対象の列に移行

        /* 仕入単価複写 */
        var unitCost_id = document.getElementById('unitCost' + tableNo);//対象のunitCostのid
        var acquisitionUnitCost_id = document.getElementById('unitCost' + acquisitionTableNo);//前行のunitCostのid
        var acquisitionUnitCost = acquisitionUnitCost_id.value; //前行のunitCostのvalueを取得
        unitCost_id.value = acquisitionUnitCost; //前行の仕入単価を対象の列に移行

        /* 売上単価複写 */
        var unitRetailPrice_id = document.getElementById('unitRetailPrice' + tableNo);//対象のunitRetailPriceのid
        var acquisitionUnitRetailPrice_id = document.getElementById('unitRetailPrice' + acquisitionTableNo);//前行のunitRetailPriceのid
        var acquisitionUnitRetailPrice = acquisitionUnitRetailPrice_id.value; //前行のunitRetailPriceのvalueを取得
        unitRetailPrice_id.value = acquisitionUnitRetailPrice; //前行の売上単価を対象の列に移行
        
        /* 備考複写 */
        var remarks_id = document.getElementById('remarks' + tableNo);//対象のremarksのid
        var acquisitionRemarks_id = document.getElementById('remarks' + acquisitionTableNo);//前行のremarksのid
        var acquisitionRemarks = acquisitionRemarks_id.value; //前行のremarksのvalueを取得
        remarks_id.value = acquisitionRemarks; //前行の備考を対象の列に移行
        
        /* 仕入金額(仕入単価*数量)複写 */
        var cost_id = document.getElementById('cost' + tableNo);//対象のcostのid
        var acquisitionCost_id = document.getElementById('cost' + acquisitionTableNo);//前行のcostのid
        var acquisitionCost = acquisitionCost_id.value; //前行のcostのvalueを取得
        cost_id.value = acquisitionCost; //前行の仕入金額を対象の列に移行

        /* 売上金額(売上単価×数量)複写 */
        var retailPrice_id = document.getElementById('retailPrice' + tableNo);//対象のretailPriceのid
        var acquisitionRetailPrice_id = document.getElementById('retailPrice' + acquisitionTableNo);//前行のretailPriceのid
        var acquisitionRetailPrice = acquisitionRetailPrice_id.value; //前行のretailPriceのvalueを取得
        retailPrice_id.value = acquisitionRetailPrice; //前行の売上金額を対象の列に移行

        totalCalculation()
      }
  
      /* 数量変化 */
      function quantityChange(obj){
        var tableNo_id = obj.id;
        var tableNo = tableNo_id.substr(8); //対象のtableNo：数量が変化した列のtableNoを取得
        
        setPrice(tableNo);
      }
      
      /* 金額セット */
      function setPrice(tableNo){

        var quantity = document.getElementById('quantity' + tableNo).value; //対象の数量取得

        if(quantity != null && quantity != ""){
          var unitCost = document.getElementById('unitCost' + tableNo).value; //対象の仕入れ単価取得
          var cost = quantity * unitCost; //仕入金額計算(取得)

          var unitRetailPrice = document.getElementById('unitRetailPrice' + tableNo).value; //対象の売上単価取得
          var retailPrice = quantity * unitRetailPrice; //売価金額計算(取得)

          //仕入金額入力
          if(unitCost != null && unitCost != "") {
            var cost_id = document.getElementById('cost' + tableNo);//対象のcostのidがあるタグ
            cost_id.value = cost; //対象のcostに仕入金額を入力
          }

          //売価金額入力
          if(unitRetailPrice != null && unitRetailPrice != ""){
	          var retailPrice_id = document.getElementById('retailPrice' + tableNo);//対象のretailPriceのidがあるタグ
	          retailPrice_id.value = retailPrice; //対象のretailPriceに仕入金額を入力
          } else {
           	  retailPrice_id.value = 0; //対象のretailPriceに0を入力
          }

          totalCalculation();
        }
      }

      /* 売上単価変化 */
      function unitRetailPriceChange(obj) {
        var tableNo_id = obj.id;
        var tableNo = tableNo_id.substr(15); //対象のtableNo：売上単価が変化した列のtableNoを取得

        var quantity = document.getElementById('quantity' + tableNo).value; //対象の数量取得

        var unitRetailPrice = obj.value; //対象の売上単価取得
        var retailPrice = quantity * unitRetailPrice; //売価金額計算(取得)

        if(unitRetailPrice != null && unitRetailPrice != ""){
          //売価金額入力
          var retailPrice_id = document.getElementById('retailPrice' + tableNo);//対象のretailPriceのidがあるタグ
          retailPrice_id.value = retailPrice; //対象のretailPriceに仕入金額を入力
        } else {
          retailPrice_id.value = 0; //対象のretailPriceに0を入力
        }

        totalCalculation();
      }

      /* 合計金額計算 */
      function totalCalculation(){
        //金額合計計算 + 値入力
        var retailPriceArray = document.getElementsByName("retailPrice"); //各売上金額の配列を取得
        var retailPriceTotal = 0; 
        retailPriceTotal = parseInt(retailPriceTotal); 
          for(var i in retailPriceArray){
            if(retailPriceArray[i].value != null && retailPriceArray[i].value != ""){
              retailPriceTotal += parseInt(retailPriceArray[i].value);
            }
          }
        document.getElementById("retailPriceTotal").innerHTML = retailPriceTotal; //金額合計に入力
        document.getElementById("inputRetailPriceTotal").value = retailPriceTotal;
        
        //仕入金額合計計算
        var costArray = document.getElementsByName("cost"); //各売上金額の配列を取得
        var costTotal = 0;
        costTotal = parseInt(costTotal);
          for(var i in costArray){
            if(costArray[i].value != null && costArray[i].value != ""){
              costTotal += parseInt(costArray[i].value);
            }
          }
        document.getElementById("inputCostTotal").value = costTotal; //仕入れ金額を入力(hidden)
        
        //粗利益計算 (金額合計 - 仕入金額合計) + 値入力
        var grossProfit = retailPriceTotal - costTotal;
        document.getElementById("grossProfit").innerHTML = grossProfit; //粗利益に入力

        //粗利益率計算 ( (粗利益/金額合計) * 100 ) ※小数第三位を四捨五入 + 値入力
        var grossProfitMargin = Math.round( ( grossProfit / retailPriceTotal )*100*100 )/100;
        if(retailPriceTotal == 0){
          grossProfitMargin = 0;
        }
        document.getElementById("grossProfitMargin").innerHTML = grossProfitMargin; //粗利益率に入力

        //消費税計算 (金額合計 * 消費税) + 値入力
        var taxRate = document.getElementById('taxRate').value;
        var taxPriceTotal = Math.floor( (retailPriceTotal * taxRate ) /100 );//小数点以下切り捨て
        document.getElementById("taxPriceTotal").innerHTML = taxPriceTotal; //消費税に入力
        document.getElementById("inputTaxPriceTotal").value = taxPriceTotal;

        //伝票合計 (金額合計 + 消費税) + 値入力
        var estimateTotal = retailPriceTotal + taxPriceTotal;
        document.getElementById("estimateTotal").innerHTML = estimateTotal; //伝票合計に入力
        document.getElementById("inputEstimateTotal").value = estimateTotal;
        } 

      
	  /* 画面読み込み時、リクエストスコープに"status"に値が保存されている場合、各メッセージを表示する */
	  window.onload = function () {
		  if("${status}" == "addSuccess"){
			  document.getElementById("message").innerHTML = "登録が完了しました";
		  } else if("${status}" == "modifySuccess") {
			  document.getElementById("message").innerHTML = "更新が完了しました";
		  } else if("${status}" == "modifyErr") {
			  document.getElementById("message").innerHTML = "更新に失敗しました";
		  } else if("${status}" == "deleteErr") {
			  document.getElementById("message").innerHTML = "削除に失敗しました";
		  } else{}
		  
		  /* 画面読み込み時、消費税率のコンボボックスに登録されている値を選択する */
		  var ctaxRate = ${estimate.ctaxRate} + 0;  //登録されている消費税率を取得
		  //消費税コンボボックスの要素及び長さを取得
		  var taxRateList = document.getElementById("taxRate"); //コンボボックスの要素を取得
		  var taxRateLength = taxRateList.length; //コンボボックスの長さを取得
		  for ( i=0; i < taxRateLength; i++ ) {				//コンボボックスの要素数分繰り返す
				if ( ctaxRate == taxRateList[i].value) {    //登録されている値と一致したら
					taxRateList[i].selected = true;			//対象の消費税率を選択する
					break ;
				}
		  }
		  
		  /* 画面読み込み時、提出先敬称のコンボボックスに登録されている値を選択する */
		  var submitPre = ${estimate.submitPre} + 0;  //登録されている消費税率を取得
		  //提出先敬称コンボボックスの要素及び長さを取得
		  var submitPreList = document.getElementById("submitPre"); //コンボボックスの要素を取得
		  var submitPreLength = submitPreList.length; //コンボボックスの長さを取得
		  for ( i=0; i < submitPreLength; i++ ) {				//コンボボックスの要素数分繰り返す
				if ( submitPre == submitPreList[i].value) {     //登録されている値と一致したら
					submitPreList[i].selected = true;			//対象の消費税率を選択する
					break ;
				}
		  }
		  totalCalculation();
	  };
	  
	  /* ajaxで入力した顧客コードに対応する顧客情報取得 */
	  function getCustomer(obj) {
		  var inputCustomerCode = obj.value;
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateCustomerSearch',
				type:'post',
				data:{"customerCode": inputCustomerCode },
				dataType:'json',
				success:function(data){
					if(data.customerName == null || data.customerName == ""){
						alert("該当する顧客情報は存在しません");
					} else {
					document.getElementById('submitName').value = data.customerName;
					document.getElementById('customerName').value = data.customerName;
					document.getElementById('customerRemarks').value = data.customerRemarks;
					document.getElementById('customerComment').value = data.customerComment;
					}
       		    }
			});
		}
	  
	  /* ajaxで入力した商品コードに対応する商品情報取得 */
	  function getProduct(obj) {
		  var inputProductCode = obj.value;
          var tableNo = obj.id.substr(11); //対象のtableNo：商品コードを入力したtableNo取得
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateProductSearch',
				type:'post',
				data:{"productCode": inputProductCode },
				dataType:'json',
				success:function(data){
					if(data.productAbstract == null || data.productAbstract == ""){
						alert("該当する商品情報は存在しません");
					} else {
						document.getElementById('productAbstract' + tableNo).value = data.productAbstract;
						document.getElementById('unitCost' + tableNo).value = data.unitCost;
						document.getElementById('unitRetailPrice' + tableNo).value = data.unitRetailPrice;
						setPrice(tableNo);
					}
       		    }
			});
		}
	  
	  function outputPdf() {
			if(!confirm("見積書をPDF形式で出力します。よろしいですか？\n※更新していない場合は入力内容が破棄されます。")){
				return;
			}
			var form = document.pdfform;
			form.submit();
	  }
  </script>
</html>
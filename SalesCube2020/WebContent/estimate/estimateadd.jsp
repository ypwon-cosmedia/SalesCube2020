<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
int[] taxRate = {3, 5};
request.setAttribute("taxRates", taxRate);
%>

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

    <title>見積登録</title>
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
      <h3 class="float-left">見積登録</h3>
   
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="" disabled>F2<br>登録</button>
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

    <form action="/SalesCube2020/SalesCube?action=searchSetProduct" method="post" name="mainform">
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
						   	  <input type="text" value="" class="form-control" id="inlineFormInputGroup" name="productCode" pattern="^[0-9A-Za-z]+$" onchange="test3()">
					  		</div>
              </div>

              <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text" style="background-color: pink;">見積日</div>
						  		</div>
                  <input type="date">
					  		</div>
              </div>

              <div class="col-5">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">納期または出荷日</div>
						  		</div>
                   <input type="text" value="" class="form-control" id="inlineFormInputGroup" name="productCode">
                   <button type="button" class="ModalButton"  data-toggle="modal" data-target="#setShipDate">
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
                  <input type="date">
					  		</div>
              </div>

              <div class="col-3">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">入力担当者</div>
						  		</div>
						   	  <input type="text" value="管理者" class="form-control" id="inlineFormInputGroup" name="productCode" readonly>
					  		</div>
              </div>

              <div class="col-5">
						    <label class="sr-only" for="inlineFormInputGroup"></label>
						    <div class="input-group mb-2">
						    	<div class="input-group-prepend">
						    		<div class="input-group-text">件名</div>
						  		</div>
						   	  <input type="text" value="" class="form-control" id="inlineFormInputGroup" name="productCode">
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
						   	  <input type="text" value="貴社指定場所" class="form-control" id="inlineFormInputGroup" name="productCode">
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
                  <textarea cols="3" style="width: 750px;"></textarea>
                  <button type="button" class="ModalButton"  data-toggle="modal" data-target="#setQuotationCondition">
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
                  <select class="custom-select" name="" id="taxRate" onchange="totalCalculation()">
                    <option value="0">消費税なし</option>
                    <c:forEach var="taxRate" items="${taxRates}">
						<option value="${taxRate}">${taxRate}</option>
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
                  <input type="text" value="" class="form-control" id="submitName" name="productCode">&emsp;&emsp;
                </div>
              </div>

              <div class="col-3">
                <label class="sr-only" for="inlineFormInputGroup"></label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">提出先敬称</div>
                  </div>
                  <select class="custom-select" name="">
                    <option></option>
                    <c:forEach var="submitPre" items="${submitPre}">
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
                      <input type="text" value="" class="form-control" name="customerCode" id="customerCode" onchange="test2()">
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
                    <input type="text" value="" class="form-control" name="productCode" id="customerName" readonly>
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
                      <input type="text" value="" class="form-control" name="productCode"  id="customerRemarks" readonly>
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
                      <input type="text" value="" class="form-control" name="productCode"  id="customerComment" readonly>
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
                  <textarea name="" cols="100"></textarea>
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
                  <textarea name="" cols="100"></textarea>
                </div>
              </div>
            </div>
          </div>
        </div><p>&nbsp;</p>
      </div><br>
    
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
          <tr id="tr1">
            <td rowspan="2"><div id="tableNo1"></div></td>
            <td rowspan="2" class="backpink"><input type="text" name="" id="productCode1" value="" style="width: 110px;" onchange="test(this)">
              <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 22px;"></td>
            <td rowspan="2"><textarea name="" rows="3" style="width: 200px;" id="productAbstract1"></textarea></td>
            <td class="backpink"><input type="text" name="" value="" id="quantity1" style="width: 75px;" onchange="quantityChange(this)"></td>
            <td><input type="text" name="" value="" id="unitCost1" style="background-color:rgb(177, 177, 177); width: 75px;" readonly></td>
            <td class="backpink"><input type="text" name="" id="unitRetailPrice1" style="width: 75px;" onchange="unitRetailPriceChange(this)"></td>
            <td rowspan="2"><textarea name="" rows="3" style="width: 200px;" id="remarks1"></textarea></td>
            <td><button type="button" class="btn btn-primary table-button"  onclick="deleteLineForm(this)" id="delete1">削除</button></td>
          </tr>

          <tr>
            <td class="backpink"><button type="button" class="btn btn-primary table-button">在庫</button></td>
            <td><input type="text" name="cost" value="" style="background-color:rgb(177, 177, 177); width: 75px;" id="cost1" readonly></td>
            <td class="backpink"><input type="text" name="retailPrice" value="" id="retailPrice1" style="width: 75px; background-color:rgb(177, 177, 177);" readonly></td>
            <td><button type="button" class="btn btn-primary table-button" onclick="previousCopy(this)"  id="previousCopy1" disabled>前行複写</button></td>
          </tr>
        </tbody>

      </table>
    </div>

    <div align="center">
			<button type="button" class="btn btn-primary" id="addLine">行追加</button>
		</div><br>


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
          <td>￥<span id="taxTotal">0</span></td>
          <td>￥<span id="estimateTotal">0</span></td>
        </tr>
        </tbody>
      </table>
    </div>

    <div class="container" style="text-align:center">
      <button type="button" class="btn btn-primary" style="width:200px; height:50px;">登録</button>
    </div>
    <br><br>

  </body>

  <script>
    window.onload = function onLoad() {
            target = document.getElementById("tableNo1");
            target.innerHTML = "1";
            //target = document.getElementById("tableNo2");
            //target.innerHTML = "2";
    }



    /* 入力値の初期化 */
			function initForm() {
				if(!confirm("入力内容を初期化してよろしいですか？")){
					return;
				}
				location.reload();
			}

			/* 登録 */
			function addForm() {
				var test = confirm("入力内容を登録します。よろしいですか？");
				test;
				if(test == false){
					return;
				} /* else
				window.location.href = '/SalesCube2020/SalesCube?action=orderinput'; */
				location.reload();
			}
	

      /* 行追加 */
			$('#addLine').click(function() {
				var tableNo = ($("#estimate tr").length + 1) / 2; //新しく追加するNo、( (テーブルの行数(見出し1行+ データ行*2n) + 1(新しい行数にするための補完))/2) = 新規に追加する見出しNoになる)
        $('#estimate > tbody:last').append(
          '<tr>' +
            '<td rowspan="2"><div id="tableNo' + tableNo + '"></div></td>' +
            '<td rowspan="2" class="backpink"><input type="text" name="" id="productCode' + tableNo + '" value="" style="width: 110px;" onchange="test(this)">' +
              '<input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 22px;"></td>' +
            '<td rowspan="2"><textarea name="" rows="3" style="width: 200px;" id="productAbstract' + tableNo + '"></textarea></td>' +
            '<td class="backpink"><input type="text" name="" value="" id="quantity' + tableNo + '" style="width: 75px;" onchange="quantityChange(this)"></td>' +
            '<td><input type="text" name="" value="" id="unitCost' + tableNo + '" style="background-color:rgb(177, 177, 177); width: 75px;" readonly></td>' +
            '<td class="backpink"><input type="text" name="" id="unitRetailPrice' + tableNo + '" style="width: 75px;" onchange="unitRetailPriceChange(this)"></td>' +
            '<td rowspan="2"><textarea name="" rows="3" style="width: 200px;" id="remarks' + tableNo + '"></textarea></td>' +
            '<td><button type="button" class="btn btn-primary table-button"  onclick="deleteLineForm(this)"  id="delete' + tableNo + '">削除</button></td>' +
          '</tr>' +

          '<tr>' +
            '<td class="backpink"><button type="button" class="btn btn-primary table-button">在庫</button></td>' +
            '<td><input type="text" name="cost" value="" style="background-color:rgb(177, 177, 177); width: 75px;" id="cost' + tableNo + '" readonly></td>' +
            '<td class="backpink"><input type="text" name="retailPrice" value="" id="retailPrice' + tableNo + '" style="width: 75px; background-color:rgb(177, 177, 177);" readonly></td>' +
            '<td><button type="button" class="btn btn-primary table-button" onclick="previousCopy(this)" id="previousCopy' + tableNo + '">前行複写</button></td>' +
          '</tr>' );

          target = document.getElementById("tableNo" + tableNo);
            target.innerHTML = tableNo;
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

        var quantity = obj.value; //対象の数量取得

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

          if(unitRetailPrice != null && unitRetailPrice != ""){
          //売価金額入力
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

        //仕入金額合計計算
        var costArray = document.getElementsByName("cost"); //各売上金額の配列を取得
        var costTotal = 0;
        costTotal = parseInt(costTotal);
          for(var i in costArray){
            if(costArray[i].value != null && costArray[i].value != ""){
              costTotal += parseInt(costArray[i].value);
            }
          }
        
        //粗利益計算 (金額合計 - 仕入金額合計) + 値入力
        var grossProfit = retailPriceTotal - costTotal;
        document.getElementById("grossProfit").innerHTML = grossProfit; //粗利益に入力

        //粗利益率計算 ( (粗利益/金額合計) * 100 ) ※小数第三位を四捨五入 + 値入力
        var grossProfitMargin = Math.round( (grossProfit/retailPriceTotal)*100*100 )/100;
        if(retailPriceTotal == 0){
          grossProfitMargin = 0;
        }
        document.getElementById("grossProfitMargin").innerHTML = grossProfitMargin; //粗利益率に入力

        //消費税計算 (金額合計 * 消費税) + 値入力
        var taxRate = document.getElementById('taxRate').value;
        var taxTotal = Math.floor( (retailPriceTotal * taxRate) /100 );//小数点以下切り捨て
        document.getElementById("taxTotal").innerHTML = taxTotal; //消費税に入力

        //伝票合計 (金額合計 + 消費税) + 値入力
        var estimateTotal = retailPriceTotal + taxTotal;
        document.getElementById("estimateTotal").innerHTML = estimateTotal; //伝票合計に入力   
        
        } 

      /* 商品入力 */
      function test(obj) {
        var productAbstract = "おいしいもも"; //商品名・摘要
        var unitCost = 200; //仕入単価
        var unitRetailPrice = 300; //売上単価

        //tableNo取得
        var tableNo_id = obj.id;
        var tableNo = tableNo_id.substr(11); //対象のtableNo：値を変更した列のtableNoを取得

        //商品名・摘要入力
        var productAbstract_id = document.getElementById('productAbstract' + tableNo);//対象のproductAbstractのidがあるタグ
        productAbstract_id.value = productAbstract; //対象のproductAbstractに仕入金額を入力 

        //仕入単価入力
        var unitRetailPrice_id = document.getElementById('unitRetailPrice' + tableNo);//対象のunitRetailPriceのidがあるタグ
        unitRetailPrice_id.value = unitRetailPrice; //対象のunitRetailPriceに仕入金額を入力

        //売上単価入力
        var unitCost_id = document.getElementById('unitCost' + tableNo);//対象のunitCostのidがあるタグ
        unitCost_id.value = unitCost; //対象のunitCostに仕入金額を入力
      }

      /* 顧客入力 */
      function test2() {
        var customerName = "仲村龍一郎"; //
        var customerRemarks = "パーティーやるならここ！"; //
        var customerComment = "小さいパーティーから大きいパーティーまで何でもお任せ！"; //
        var submitName = "仲村龍一郎"; //

        //顧客名入力
        var customerName_id = document.getElementById('customerName');//対象のcustomerNameのidがあるタグ
        customerName_id.value = customerName; //対象のcustomerNameに仕入金額を入力 

        //備考入力
        var customerRemarks_id = document.getElementById('customerRemarks');//対象のcustomerRemarksのidがあるタグ
        customerRemarks_id.value = customerRemarks; //対象のcustomerRemarksに仕入金額を入力 

        //コメント入力
        var customerComment_id = document.getElementById('customerComment');//対象のcustomerCommentのidがあるタグ
        customerComment_id.value = customerComment; //対象のcustomerCommentに仕入金額を入力 

        //提出先名入力
        var submitName_id = document.getElementById('submitName');//対象のsubmitNameのidがあるタグ
        submitName_id.value = submitName; //対象のsubmitNameに仕入金額を入力
      }

      /* 編集画面遷移 */
			function test3() {
				if(!confirm("すでに登録済みの見積番号です。編集画面に遷移しますか？")){
					return;
				}
				location.href = 'estimatemodify.html';
			}

  </script>
</html>
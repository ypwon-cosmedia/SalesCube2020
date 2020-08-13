<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html lang="en">
	
	<%@ include file="/common/_customerSearch.jsp" %>
	<%@ include file="/estimate/_userSearch.jsp" %>
	<%@ include file="/estimate/_estimateConfiguration.jsp" %>

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>SalesCube estimateSearch</title>
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
        .table tr td {
            background-color: white;
        }

        .table {
          white-space: nowrap;
        } 
        
        .cursor-pointer{
 		 	    cursor: pointer;
 		 	    color : blue;
		    }
      
        .clear-decoration {
                border: none;  /* 枠線を消す */
                outline: none; /* クリックしたときに表示される枠線を消す */
                background: transparent; /* 背景の灰色を消す */
            }

            
        .table_1{
          border-collapse: collapse;
          border-spacing: 0;
          height: 250px;
          display: block;
          overflow-x: scroll;
          overflow-y: scroll;
          white-space: nowrap;
        }

        .table_1 thead tr th{
            position: sticky;
            position: -webkit-sticky;
            top: 0;
            
            z-index: 1;
        }
      
      .table_2{
            
            border-collapse: collapse;
            border-spacing: 0;

            height: auto;
            display: block;
            overflow-x: scroll;
          
            white-space: nowrap;
            
        }
        .scrollnum{
            position: sticky;
            position: -webkit-sticky;
            top: 0;
            left: 0;
            z-index: 1;
        }
        
        .example3 li {
          display: inline-block;
          height:35px;line-height:35px;
          width:35px;text-align:center;
          border:1px #ccc solid;color:#000053;
          border-radius: 5px / 5px;
          }
          
        .sort.desc:after {
		  content:"▼";
		}
		.sort.asc:after {
		  content:"▲";
		}
	</style>
	
  </head>
    <body style="background-color: gainsboro;">
       <!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       
    <!--＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ここからメニューバー＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊-->
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
                <a class="dropdown-item" href="estimateSearch.jsp">見積検索</a>
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
          <h3 class="float-left">見積検索</h3>
      
        <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
          <div class="btn-group mr-2 " role="group" aria-label="First group">
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()">F1<br>初期化</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="estimateSearch()">F2<br>検索</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="excelOut()">F3<br>Excel出力</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" data-toggle="modal" data-target="#setSlipConfiguration" onclick="configGet()">F4<br>設定</button>
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

      <br><br>
      <div class="container panel panel-default" style="background-color: white;">
        <div class="panel-heading row mb-2 col-4">
          <h5><br>検索条件</h5>
        </div>
        <hr>
        <div class="panel-body">
          <form action="" method="post">
            <div class="row">
              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">estimateSheetId</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                      <div class="input-group-text">見積番号</div>
                  </div>
                  <input type="text"  class="form-control" id="estimateSheetId" name="estimateSheetId">
                </div>
              </div>
              <div class="col-7">
                <label class="sr-only" for="inlineFormInputGroup">estimateDate</label>
                <div style="display: flex;">
                <div class="input-group"  style="height: 38px;">
                  <div class="input-group-prepend">
                    <div class="input-group-text">見積日</div>
                  </div>
                  <input type="date" id="estimateDateStart" name="estimateDateStart" max="9999-12-31">&ensp; 
                  <div style="margin-top: 7px;">～</div>
                </div>

                <div class="input-group" style="height: 38px; right: 45px;">
                  <input type="date" id="estimateDateEnd" name="estimateDateEnd" max="9999-12-31">
                </div>
                </div>

              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-7">
                <label class="sr-only" for="inlineFormInputGroup">validDate</label>
                <div style="display: flex;">
                  <div class="input-group"  style="height: 38px;">
                    <div class="input-group-prepend">
                      <div class="input-group-text">有効期限</div>
                    </div>
                    <input type="date" id="validDateStart" name="validDateStart" max="9999-12-31"> &ensp; 
                    <div style="margin-top: 7px;">～</div>
                  </div>
  
                  <div class="input-group" style="height: 38px; right: 30px;">
                    <input type="date" id="validDateEnd" name="validDateEnd" max="9999-12-31">
                  </div>
                  </div>
  
              </div>
            </div>
            <br>

            <div class="row">
              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">userId</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">入力担当者コード</div>
                  </div>
                <input type="text"  class="form-control" id="UserModalUserId" name="UserModalUserId">
               <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#userSearch" onclick="initUser() ; getDeptCategory() ; getRoleCategory()"></button>
                </div>
              </div>

              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">userName</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">入力担当者名</div>
                  </div>
                <input type="text"  class="form-control" id="UserModalNameKnj" name="UserModalNameKnj">
                <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#userSearch" onclick="initUser() ; getDeptCategory() ; getRoleCategory()"></button>
                </div>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">title</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">件名</div>
                  </div>
                <input type="text"  class="form-control" id="title" name="title">
                </div>
              </div>

              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">摘要</div>
                  </div>
                <input type="text"  class="form-control" id="remarks" name="remarks">
                </div>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-8">
                <label class="sr-only" for="inlineFormInputGroup">submitName</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">提出先名</div>
                  </div>
                <input type="text"  class="form-control" id="submitName" name="submitName">
                </div>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">customerCode</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">顧客コード</div>
                  </div>
                <input type="text"  class="form-control" id="CustomerModalCustomerCode" name="CustomerModalCustomerCode">
                <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#customerSearch" onclick="initCustomer() ; getCutoffGroup()"></button>
                </div>
              </div>

              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">customerName</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">顧客名</div>
                  </div>
                <input type="text"  class="form-control" id="CustomerModalCustomerName" name="CustomerModalCustomerName">
                <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#customerSearch" onclick="initCustomer() ; getCutoffGroup()"></button>
                </div>
              </div>
            </div>

            <div class="rounded float-right">
              <button type="button" class="btn btn-primary" onclick="initForm()">初期化</button>
              <input type="button" value="検索" class="btn btn-primary" onclick="estimateSearch()">
            </div><br>
          </form><br>
        </div><br>
      </div><br>


      <div id="resultHidden" hidden>
        <div class="container">
            <div class="float-left" style="position:static; left: 0px;">
              検索結果件数：<span id="resultCount">0</span>件
            </div>
      
          
            <div id= "pageNo" class="text-center example3">             
              <li class="pre" >前へ</li>
              <li class="this">1</li>
              <li><a href="page-2.html">2</a></li>
              <li><a href="page-3.html">3</a></li>
              <li><a href="page-2.html" >次へ</a></li>         
            </div>
          </div>
      </div>

      <div class="container">
          <div class="rounded float-right">
            		ページあたりの表示件数
            <select id="rowCount" name="rowCount">
              <option value="10">10</option>
              <option value="50">50</option>
              <option value="100" selected="">100</option>
            </select>
          </div>
      </div>

      


    
      <br><br>
      <div class="container" style="background-color: rgb(255, 255, 255);" id="resultHidden2" hidden >
        <table id="order_detail_info" class="table table_2 table-bordered" style= "table-layout: auto; width: 1120px;  position:relative;right:15px"> 
          <thead class="thead-light">
            <tr>
              <th scope="col" class="th_back_black scrollnum" style="cursor: pointer; " onclick="sort('estimateSheetId');" >見積番号</th>
              <th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; " onclick="sort('validDate');">有効期限</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('estimateDate');">見積日</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('estimateTotal');">伝票合計</th>
              <th scope="col" class="th_back_black" >件名</th>
              <th scope="col" class="th_back_black" >提出先名</th>
              <th scope="col" class="th_back_black" >提出先敬称</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('customerCode');">顧客コード</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('customerName');">顧客名</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('product1');">粗利益</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('product1');">粗利益率</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('product1');">金額合計</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('product1');">消費税</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; ">納期または出荷日</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('userName');">入力担当者名</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('userId');">入力担当者コード</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; ">摘要</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; ">納入先</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; ">見積条件</th>
            </tr>
          </thead>
          
            <tr>
              <td style="text-align: left;" class="scrollnum"><a href="estimatemodify.html" class="cursor-pointer">1</a></td>
              <td style="text-align: left;">2015/08/12</td>
              <td style="text-align: left;">2015/07/21</td>
              <td style="text-align: left;">くまモン株式会社見積</td>
              <td style="text-align: left;">仲村龍一郎 パーティー制作部 仲村</td>
              <td style="text-align: left;">2</td>
              <td style="text-align: left;">3</td>
              <td style="text-align: left;">仲村龍一郎</td>
              <td style="text-align: left;">17080</td>
              <td style="text-align: left;">8.89%</td>
              <td style="text-align: left;">192080</td>
              <td style="text-align: left;">9604</td>
              <td style="text-align: left;">25から30営業日後出荷（ご注文時に確定）</td>
              <td style="text-align: left;">仲村</td>
              <td style="text-align: left;">a</td>
              <td style="text-align: left;"></td>
              <td style="text-align: left;">11212121212</td>
              <td style="text-align: left;">代引き</td>
              <td style="text-align: left;">201684</td>
			</tr>
          
        </table>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	  <script>
	  
	  function estimateSearch(){
		  $('#resultHidden').removeAttr('hidden');
		  $('#resultHidden2').removeAttr('hidden');
	}
	  
	  function a(){
		  var showResult = document.getElementById('showSearchResult');   //optionタグを入れる箇所の指定
		          for( var i = 0; i < showName.length ; i++ ){
		              var option = document.createElement('option');              //optionタグの生成
		              option.setAttribute('value', showID[i]);                    //value値の挿入
		              option.innerHTML = showName[i];                             //HTMLで表示する項目名
		              showResult.appendChild(option);                             //selectにoptionタグを挿入
		          }
		        }

		  //初期化処理
		  function initForm() {
		        if(!confirm("入力内容を初期化してよろしいですか？")){
		              return;
		        }
		        window.location.href = 'estimateSearch.jsp';
		      }
		  
		  function excelOut(){
				if(!confirm("検索結果をExcelファイルでダウンロードしますか？")){
		           	return;
		    	}
		  }
			
		  //顧客コード・顧客名の値をセット
	      	function selectCustomerCode(code, name){
          		document.getElementById('CustomerModalCustomerCode').value = code;
          		document.getElementById('CustomerModalCustomerName').value = name;
          	}
		  
	      //担当者コード・担当者名の値をセット
	     	function selectUserId(id, name){
	      		document.getElementById('UserModalUserId').value = id;
	      		document.getElementById('UserModalNameKnj').value = name;
	      	}
		  
		 </script>
	</body>
</html>
	
	
	
	
	
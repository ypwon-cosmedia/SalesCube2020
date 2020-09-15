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
	<link rel="import" href="C:/Users/cosmedia/Desktop/bootstrap-4.0.0-dist/menu.html">

    <title>見積検索</title>
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
		    
		.cursor-hand{
			cursor: hand;
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
		
		.example li {
		display:inline;
		}
		
	</style>
	
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
    
    <%@ include file= "../common/menubar.jsp" %>
	<br>
       

       <div class="container" id="main_function">
          <h3 class="float-left">見積検索</h3>
      
      
        <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
          <div class="btn-group mr-2 " role="group" aria-label="First group">
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()">F1<br>初期化</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" id="estimateFuncButton" >F2<br>検索</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" id="excelButton" onclick="excelOut()" disabled>F3<br>Excel出力</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" data-toggle="modal" data-target="#setSlipConfiguration" onclick="configGet() ; initButton()">F4<br>設定</button>
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
      
      
       <!-- 検索部エラーメッセージ表示 -->
       <div id="estimateSearchError"></div>

      	<br>
      </div>
      
    <form action="" method="post" id="estimate">
      <div class="container panel panel-default" style="background-color: white;">
        <div class="panel-heading row mb-2 col-4">
          <h5><br>検索条件</h5>
        </div>
        <hr>
        <div class="panel-body">         
            <div class="row">
              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">estimateSheetId</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                      <div class="input-group-text">見積番号</div>
                  </div>
                  <input type="text"  class="form-control" id="estimateSheetId" name="estimateSheetId" pattern="^[0-9A-Za-z]+$" title="半角英数字で入力してください" maxlength="32">
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
                <input type="text"  class="form-control" id="UserModalUserId" name="userId" pattern="^[0-9A-Za-z]+$" title="半角英数字で入力してください" maxlength="30">
               <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#userSearch" onclick="initUser() ; getDeptCategory() ; getRoleCategory()"></button>
                </div>
              </div>

              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">userName</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">入力担当者名</div>
                  </div>
                <input type="text"  class="form-control" id="UserModalNameKnj" name="userName" maxlength="60">
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
                <input type="text"  class="form-control" id="title" name="title" maxlength="100">
                </div>
              </div>

              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">摘要</div>
                  </div>
                <input type="text"  class="form-control" id="remarks" name="remarks" maxlength="120">
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
                <input type="text"  class="form-control" id="submitName" name="submitName" maxlength="60">
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
                <input type="text"  class="form-control" id="CustomerModalCustomerCode" name="customerCode" pattern="^[0-9A-Za-z]+$" title="半角英数字で入力してください" maxlength="15">
                <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#customerSearch" onclick="initCustomer() ; getCutoffGroup()"></button>
                </div>
              </div>

              <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">customerName</label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">顧客名</div>
                  </div>
                <input type="text"  class="form-control" id="CustomerModalCustomerName" name="customerName" maxlength="60">
                <button type="button" style="height: 32px; width: 32px;" class="clear-decoration"><img src="btn_search.png" data-toggle="modal" data-target="#customerSearch" onclick="initCustomer() ; getCutoffGroup()"></button>
                </div>
              </div>
            </div>

            <div class="rounded float-right">
              <button type="button" class="btn btn-primary" onclick="initForm()">初期化</button>
              <input type="button" value="検索" class="btn btn-primary" id="estimateButton"">
            </div><br>
          <br>
        </div><br>
      </div><br>


      <div id="resultCount" >
        <div class="container">
            <div class="float-left" style="position:static; left: 0px;">
            
            <!-- 検索結果件数 -->
              <span id="estimateSearchResultCount"></span>
            </div>
            
      		<!-- ページング -->
      		<div class="col-4" style="text-align:right;" id="paging">
			</div>
          </div>
      </div>

	<!-- ページあたりの表示件数 -->
      <div class="container">
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
     
    
      <br><br>
      
      
      <!-- 見積検索結果テーブル  -->      
  <!--    <div class="container" style="background-color: rgb(255, 255, 255);" id="resultEstimate" hidden="hidden">
        <table id="order_detail_info" class="table table_2 table-bordered" style= "table-layout: auto; width: 1120px;  position:relative;right:15px"> 
          <thead class="thead-light" id="AddHead">
  
             <tr>
              <th scope="col" class="th_back_black scrollnum" style="cursor: pointer; " onclick="sort('estimateSheetId');" >見積番号</th>
              <th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; " onclick="sort('validDate');">有効期限</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('estimateDate');">見積日</th>
              <th scope="col" class="th_back_black" style="cursor: pointer; " onclick="sort('estimateTotal');">伝票合計</th>
       
            </tr>
          </thead>
          
             <tbody class="scroll-table" id="estimateResult">
             <td style="text-align: left;" class="scrollnum"><a href="estimatemodify.html" class="cursor-pointer">1</a></td>
           </tbody>
            
        </table>
      </div>
      -->
      
      
    <!-- 検索結果表示 -->
      <div class="container" style="background-color: rgb(255, 255, 255);" id="resultEstimate" hidden="hidden">
    	<table id="order_detail_info" class="table table_2 table-bordered" style= "table-layout: auto; width: 1120px;  position:relative;right:15px"> 
			<thead class="thead-dark" id="resultHead">
			</thead>
			<tbody class="list" id="searchResult">
			</tbody>
		</table>
	</div>
	
	<form name="moveEstimateModify" action="/SalesCube2020/SalesCube?action=moveEstimateModify" method="post">
		<input type="hidden" name="estimateSheetId" id="moveEstMod">
	</form>
      
      
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>	  
	
	 var sortOrder = "";
	 var sort;  
     var upDown;
     var rowcount;
     var itemId = "";
     
     
   //入力欄が変更された時のパターンチェック
     var estimateElem = document.getElementById("estimate");	//formをidで取得
     estimateElem.addEventListener('change', function() {			//入力したときのEventを追加
    	 estimateElem.reportValidity();								//form(elem)のpatternの確認
     });
     //検索ボタンを押した際の入力チェック 
     var estimateFuncSearchButton = document.getElementById("estimateFuncButton");	//検索ボタンをidで取得
     var estimateSearchButton = document.getElementById("estimateButton");
     
     //target.addEventListener(type, listener, wantsUntrusted);
     //F3 検索ボタン
     estimateSearchButton.addEventListener("click", function() {		//検索ボタンを押したときのEventを追加
     	if( estimateElem.reportValidity() == true ){					//form(elem)のpatternの確認
     		 estimateSearch();								//入力チェックが通った場合、見積を検索を行う
     	}
     },false);
     
     //検索ボタン
     estimateFuncSearchButton.addEventListener("click", function() {		//検索ボタンを押したときのEventを追加
      	if( estimateElem.reportValidity() == true ){					//form(elem)のpatternの確認
      		 estimateSearch();								//入力チェックが通った場合、見積を検索を行う
      	}
      },false);
     
     
	  //初期化処理
	  window.onload = function(){
		  configGet(); 
		  initButton();
	  }
	  
	  function initForm(){
			if(!confirm("入力内容を初期化してよろしいですか？")){
	           	return;
	    	}
			location.href = '/SalesCube2020/SalesCube?action=moveEstimateSearch';
		}
	  
	
	  //Excel出力
	  function excelOut(){
			if(confirm("検索結果をExcelファイルでダウンロードしますか？")){
	           	
				var formString = $("form[id=estimate]").serialize();
				
	           	$.ajax({
					
					url:"/SalesCube2020/SalesCubeAJAX?action=estimateExcelOutput",
					type:'post',
					data:formString,
					dataType:'json',
					success:function(data){	
					
					}
				});
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
	     

	   	//見積検索結果（見出し部）
	    function estimateSearch1() {
	   	 var formString = $("form[id=estimate]").serialize();
			var tmp = "";
			$.ajax({
				
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateCreateTable',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){	
					document.getElementById("resultEstimate").removeAttribute('hidden'); //テーブルの表示
					$("#resultHead > tr").remove();
						var tableAdd = document.getElementById('resultHead');
						    		 																				
							var headcontents= '';
							headcontents += '<tr>';
							for(var i = 0; i<Object.keys(data).length; i++) {
								headcontents += '<th scope="col" class="th_back_black"  onclick="header(' + "'"+ data[i].itemId+"'"+')"> '+data[i].itemName;
							}
							headcontents += '</tr>';
							$('#resultHead').append(headcontents);								
					}
			});
	    }
		
	    var pageNum;
	    
	    //見積検索結果
	    function estimateSearch2() {
	   	 	    	
			$.ajax({
				
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateSearch',
				type:'post',
				data:{
					"estimateSheetId" : $("#estimateSheetId").val(),
					"estimateDateStart" : $("#estimateDateStart").val(),
					"estimateDateEnd" : $("#estimateDateEnd").val(),
					"validDateStart" : $("#validDateStart").val(),
					"validDateEnd" : $("#validDateEnd").val(),
					"userId" : $("#UserModalUserId").val(),
					"userName" : $("#UserModalNameKnj").val(),
					"title" : $("#title").val(),
					"remarks" : $("#remarks").val(),
					"submitName" : $("#submitName").val(),
					"customerCode" : $("#CustomerModalCustomerCode").val(),
					"customerName" : $("#CustomerModalCustomerName").val(),
					"sorting" : itemId,
					"updown" : upDown, 
					"rowCount" : $("#rowCount").val(),
					"pageNum" : pageNum
					},
					
				dataType:'json',
				success:function(data){
					
					
				     var MaxShowPage = 10;
				     var TotalPage;
				     var maxPageNo = (Math.floor(data.count.count)) / $("#rowCount").val() ;
				     if((Math.floor(data.count.count)) % $("#rowCount").val() != 0)
				    	 maxPageNo++;
				     maxPageNo = Math.floor(maxPageNo);

				     
					//ソート処理
					if(sortOrder == itemId){
						sortOrder = "";
					}else{
						sortOrder = itemId;
					}
					
		    //ページング処理
							

					//最小表示ページNo計算
					if(pageNum < 6){
						initPageNo = 1;
					} else if(pageNum > TotalPage - 6) {
						initPageNo = TotalPage - 9;
					} else { 
						initPageNo = pageNum - 4;
					}

				
					var page = [];

					
					//画面に表示するページ数
					for(i = 0; i < MaxShowPage; i++){
						page.push(initPageNo);
						initPageNo += 1;
					}
					
			
					$("#paging").empty();
					//前へ表示フラグ
					if(pageNum != 1){
						$('#paging').append('<a href="javascript:void(0);" onclick="paging(' + (pageNum-1) + ')">前へ</a>');
					}
					
					
					//ページ番号取得
					var showNum = pageNum;
					
					
					if(showNum % MaxShowPage){
						showNum = Math.floor(showNum / MaxShowPage);
					}
					
					for(var i = 0; i < MaxShowPage; i++){						
						if(showNum > maxPageNo) break;
						if(showNum<1){}
						else{
							if(showNum == pageNum){
								$('#paging').append('<a style="color:#DC143C">' + showNum + '</a>');
							}else{
							$('#paging').append('<a href="javascript:void(0);" onclick="paging(' + showNum + ')">' + showNum + '</a>');
							}
						}
						showNum++;
					}
					
					
					//次へ表示フラグ
					if(pageNum != maxPageNo){
						$('#paging').append('<a href="javascript:void(0);"  onclick="paging(' + (pageNum+1) +')">次へ</a>');
					}
					
					
					
					
					document.getElementById("resultCount").removeAttribute('hidden');//検索件数の表示
					document.getElementById("resultEstimate").removeAttribute('hidden');//テーブルの表示
					$("#searchResult > tr").remove();
						var tableAdd = document.getElementById('searchResult');
					
					if(Object.keys(data.result).length == 0){
						var message = '<p style="color: red;">該当する見積情報は存在しません</p>';
	    		 			$("#estimateSearchError").empty(); //エラーメッセージの削除
	    		 			$("#estimateSearchError").append(message);	//エラーメッセージの表示
	    		 			$("#paging").empty();
	    		 			document.getElementById("resultEstimate").setAttribute('hidden','hidden');
	    		 			document.getElementById("estimateSearchResultCount").setAttribute('hidden','hidden');
	    		 			
	    		 		//検索結果がある場合
	   		 		}else{
	   		 		//エラーメッセージ
	   		 			$("#estimateSearchError").empty();//エラーメッセージの削除
	   		 		
	   		 			$("#estimateSearchResultCount").empty(); //検索結果件数の設定の削除
	   		 			
	
	   		 			$('#estimateSearchResultCount').append('検索結果件数：' + data.count.count + '件');	 //検索結果件数の設定の表示
	   		 			
	   		 			document.getElementById("estimateSearchResultCount").removeAttribute('hidden');//検索結果件数の表示
	   		 			
	   		 			document.getElementById("excelButton").disabled = false;	//Excelボタンの表示
	   		 
						for(var i = 0; i < Object.keys(data.result).length; i++) {
							var headcontents= '';
							headcontents += '<tr>';
							
							var estId = Object.keys(data.result[i])[0];
		
							headcontents += '<td style="white-space: normal; text-align: left;" ><a href="javascript:void(0)" onclick="selectEstimateSheetId('+data.result[i][estId]+')">'+data.result[i][estId]+'</a></td>';
							
							for(var j = 1; j < document.getElementById("showSearchResult").options.length+1; j++) {
								headcontents += '<td style="white-space: normal; text-align: left;"> '
								var tmp = Object.keys(data.result[i])[j];
								headcontents += (data.result[i][tmp] == null ? "" : data.result[i][tmp]);
								headcontents += '</td>';  
							}
							headcontents += '</tr>';
							$('#searchResult').append(headcontents);				
										
						}
	    		 	}
	    		 
				}
			});
	    }
	    
	    function estimateSearch(){
	    	itemId = "estimateSheetId";
	    	upDown = "ASC";
	    	pageNum = 1;
	    	
	    	estimateSearch1();
	    	estimateSearch2();
	    }
	    
	    function header(item){
	       	if( sortOrder == item){
	    		upDown = "DESC";
	    		itemId = item;
	    	}else{
	    		upDown = "ASC";
	    		itemId = item;
	    	}	       	
	    	estimateSearch2();
	    }
	    
	    //ページング
	    function paging(selectPageNum){
	    	
	    	pageNum = selectPageNum;
			
	    	estimateSearch2();
	    }
	    
	    
	    //見積編集画面遷移
	    function selectEstimateSheetId(estId) {
			document.getElementById('moveEstMod').value = estId;
			
			document.moveEstimateModify.submit();
	    }
	   
	
			     			     		
</script>
	</body>
</html>
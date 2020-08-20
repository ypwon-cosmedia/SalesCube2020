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
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="estimateSearch1() ; estimateSearch2()">F2<br>検索</button>
            <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="excelOut()" id="csvDownloadButton">F3<br>Excel出力</button>
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
      </div>
      
       <!-- 検索部エラーメッセージ表示 -->
       <div id="estimateSearchError"></div>

      <br><br>
      
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
              <input type="button" value="検索" class="btn btn-primary" onclick="estimateSearch1() ; estimateSearch2()">
            </div><br>
          <br>
        </div><br>
      </div><br>


      <div id="resultCount" hidden="hidden">
        <div class="container">
            <div class="float-left" style="position:static; left: 0px;">
            <!-- 検索結果件数 -->
              <span id="estimateSearchResultCount"></span>
            </div>
            
      		<!-- ページング -->
      		<div class="col-4" id="paging"></div>
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
          
             <tbody class="scroll-table" id="estimateResult">
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
      
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<script>	  
		  //初期化処理
		  function initForm(){
				if(!confirm("入力内容を初期化してよろしいですか？")){
		           	return;
		    	}
				location.href = '/SalesCube2020/SalesCube?action=moveEstimateSearch';
			}
		
				  //Excel出力
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
			      
			      
			     //見積検索結果
			     function estimateSearch1() {
			    	 var formString = $("form[id=estimate]").serialize();
						var tmp = "";
						
						$.ajax({
							
							url:'/SalesCube2020/SalesCubeAJAX?action=estimateSearch',
							type:'post',
							data:formString,
							dataType:'json',
							success:function(data){	
								document.getElementById("resultCount").removeAttribute('hidden');//テーブルの表示
								document.getElementById("resultEstimate").removeAttribute('hidden');//テーブルの表示
								$("#searchResult > tr").remove();
									var tableAdd = document.getElementById('searchResult');
								
								if(Object.keys(data).length == 0){
									var message = '<p style="color: red;">該当する見積情報は存在しません</p>';
			     		 			$("#estimateSearchError").empty();//エラーメッセージの削除
			     		 			$("#estimateSearchError").append(message);	//エラーメッセージの表示
			     		 			document.getElementById("resultEstimate").setAttribute('hidden','hidden');
			     		 		//検索結果がある場合
			     		 		}else{
			     		 			alert("success");
			     		 		//エラーメッセージ
			     		 			$("#estimateSearchError").empty();//エラーメッセージの削除
			     		 		//検索結果件数の設定
			     		 			$("#estimateSearchResultCount").empty();
			     		 			$('#estimateSearchResultCount').append('検索結果件数：' + Object.keys(data).length + '件');	//検索結果件数の設定の表示
			     		 			
			     		 																	
									
										var headcontents= '';
										headcontents += '<tr>';
										for(var i = 0; i<Object.keys(data).length; i++) {
											switch(Object.keys(data).getItemId()){
												case "estimateSheetId" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].estimateSheetId+'</td>';
													break;
												case "estimateDate" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].estimateDate+'</td>';
													break;
												case "deliveryInfo" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].deliveryInfo+'</td>';
													break;
												case "validDate" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].validDate+'</td>';
													break;
												case "userId" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].userId+'</td>';
													break;
												case "userName" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].userName+'</td>';
													break;
												case "title" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].title+'</td>';
													break;
												case "remarks" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].remarks+'</td>';
													break;
												case "deliveryName" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].deliveryName+'</td>';
													break;
												case "estimateCondition" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].estimateCondition+'</td>';
													break;
												case "submitName" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].submitName+'</td>';
													break;
												case "submitPre" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].submitPre+'</td>';
													break;
												case "customerCode" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].customerCode+'</td>';
													break;
												case "customerName" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].customerName+'</td>';
													break;
												case "grossMargin" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].grossProfit+'</td>';
													break;
												case "grossMarginRate" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].grossProfitMargin+'</td>';
													break;
												case "retailPriceTotal" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].retailPriceTotal+'</td>';
													break;
												case "ctaxPriceTotal" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].ctaxPriceTotal+'</td>';
													break;
												case "estimateTotal" :
													headcontents += '<td style="white-space: normal; text-align: left;"> '+data[i].estimateTotal+'</td>';
													break;									
											}											
										}
										headcontents += '</tr>';
										$('#searchResult').append(headcontents);
								
									
								}
							}
						});
			     }
			     
			     function estimateSearch2() {
			    	 var formString = $("form[id=estimate]").serialize();
						var tmp = "";
						alert("success2");
						$.ajax({
							
							url:'/SalesCube2020/SalesCubeAJAX?action=estimateCreateTable',
							type:'post',
							data:formString,
							dataType:'json',
							success:function(data){	
								alert("success3");
								document.getElementById("resultEstimate").removeAttribute('hidden');//テーブルの表示
								$("#resultHead > tr").remove();
									var tableAdd = document.getElementById('resultHead');
								
			     		 																	
									
										var headcontents= '';
										headcontents += '<tr>';
										for(var i = 0; i<Object.keys(data).length; i++) {
											headcontents += '<th scope="col" class="th_back_black"> '+data[i].itemName+'</td>';
										}
										headcontents += '</tr>';
										$('#resultHead').append(headcontents);
									
									
								}
						});
			     }
		
</script>
	</body>
</html>
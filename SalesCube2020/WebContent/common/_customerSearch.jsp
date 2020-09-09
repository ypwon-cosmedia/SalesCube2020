<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- ここが顧客検索モダールボタン --> 
     <!--   <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#customerSearch" onclick="initCustomer() ; getCutoffGroup()">
        ↓
        </button>
        <input type="text" id="CustomerModalCustomerCode" name="CustomerModalCustomerCode" placeholder="顧客コード" value="">
        <input type="text" id="CustomerModalCustomerName" name="CustomerModalCustomerName" placeholder="顧客名" value="">    
	-->
		
		<div class="modal fade" id="customerSearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                
                <div class="modal-header">
                    <h5 class="modal-title" id="label1">顧客検索</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                <!-- 検索部エラーメッセージ表示 -->
                <div id="customerSearchError"></div>
                
               <form action="" id="cutoff">
               	<input type ="hidden" name="categoryId" value="11">
               </form>
               
                <form action="" method="post" id="customer" >
                    <div class="modal-body">
                      <div class="row">
                        <div class="col-4">
                          <label class="sr-only" for="inlineFormInputGroup">customerCode</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客コード</div>
                            </div>
                            <input type="text"  class="form-control" name="customerCode" id="customerCode" pattern="^[0-9A-Za-z]+$" title="半角英数字で入力してください" maxlength="15">
                          </div>
                        </div>
                      </div>
                    

                    
                      <div class="row">
                        <div class="col-5">
                          <label class="sr-only" for="inlineFormInputGroup">customerName</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客名</div>
                            </div>
                            <input type="text"  class="form-control" name="customerName" id="customerName" maxlength="60">
                          </div>
                        </div>&emsp;&emsp;&emsp;
                      

                        <div class="col-6">
                          <label class="sr-only" for="inlineFormInputGroup">customerKana</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客名カナ</div>
                            </div>
                            <input type="text"  class="form-control"  name="customerKana" pattern="[\u30A1-\u30F6]*" title="全角カナで入力してください" maxlength="60"> 
                          </div>
                        </div>
                      </div>
                    
                      
                    
                      <div class="row">
                        <div class="col-6">
                          <label class="sr-only" for="inlineFormInputGroup"></label>
                            <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                <div class="input-group-text">支払条件</div>
                              </div>
                              <select id="SelectCutoffGroup" name="cutoffGroup">
                                                                                              
                              </select>                              
                            </div>
                        </div>
                      </div>
                    </div>
                    
              
                    <div class="rounded float-right">
                      <button type="button" class="btn btn-primary" onclick="initCustomer()">初期化</button>&ensp;
                      <input type="button" value="検索" class="btn btn-primary" id="modalCustomerSearchButton" onclick="customerSearch1()">&ensp;&ensp;
                    </div>
                    <br>
                    <br>
                </form>

                  <div id="resultCustomer" hidden="hidden">
                    <div class="modal-body">
                      <div class="float-left" style="position:static; left: 0px;">
                        	  <span id="customerSearchResultCount"></span>
                      </div>
                    </div>
                    <br>
                  
                   
                  
                  <!--顧客検索結果テーブル-->
                  	<div class="modal-body scroll-table" style="background-color: rgb(255, 255, 255);" >
                    	<table id="order_detail_info" class="table table_1 table-bordered scrolltable" >
                      	<thead class="thead-light">
                        	<tr>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerCode');">顧客コード</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('costomerName');">顧客名</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerTEL');">TEL</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerPCName');">担当者</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('salesCmCategory');">取引区分</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('cutoffGroup');">支払条件</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerOfficeName');">事務所名</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerDeptName');">部署名</th>
                          	</tr>
                      	</thead>
                      	
                     	 <tbody class="modal-body scroll-table" id="customerResult" >
				  		</tbody>
				  			
                    	</table>
                    	<br>
                  	</div>
                  </div>
                  
	              <div class="modal-footer">
	                    <button type="button" class="btn btn-primary" data-dismiss="modal">閉じる</button>
	              </div>
	                
            	
          	</div>
        </div>
      </div> 
      
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
      <script>
     	//検索結果を表示する 
    //  	function customerSearch(){
    //	  $('#resultCustomer').removeAttr('hidden');
    //	}
      	
     	//入力欄が変更された時のパターンチェック
            var elemCheck = document.getElementById("customer");	//formをidで取得
            elemCheck.addEventListener('change', function() {			//入力したときのEventを追加
            	elemCheck.reportValidity();								//form(elem)のpatternの確認
            });
            //検索ボタンを押した際の入力チェック 
            var searchButtonCheck = document.getElementById("modalCustomerSearchButton");	//検索ボタンをidで取得
            //target.addEventListener(type, listener, wantsUntrusted);
            searchButtonCheck.addEventListener("click", function() {		//検索ボタンを押したときのEventを追加
            	if( elemCheck.reportValidity() == true ){					//form(elem)のpatternの確認
            		customerSearch1();								//入力チェックが通った場合、顧客を検索を行う
            	}
            },false);
     	
     	
     	//初期化処理
      	function initCustomer(){
            $("[name='customerCode']").val("");
            $("[name='customerName']").val("");
            $("[name='customerKana']").val("");
            $("[name='cutoffGroup']").val("");

            //テーブルの非表示
            document.getElementById("resultCustomer").setAttribute('hidden','hidden');
            
          //エラーメッセージの削除
            $("#customerSearchError").empty();
    	}
     	
     	
     	//支払条件コンボボックス
     	function getCutoffGroup(){
     		var formString = $("form[id=cutoff]").serialize();
			var tmp = "";
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateCategoryGet',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){
					$("#SelectCutoffGroup").empty();
					
					var headcontents = '<option value =""></option>';	
					$('#SelectCutoffGroup').append(headcontents);
					
					for(var i = 0; i<Object.keys(data).length; i++){
						var headcontents = '<option value ="'+data[i].categoryCode+'">'+data[i].categoryCodeName+'</option>';	
						$('#SelectCutoffGroup').append(headcontents);
					}
					
				}
			});
		}
     		
     	
     	//顧客検索結果
		function customerSearch1() {
			var formString = $("form[id=customer]").serialize();
			var tmp = "";
			
			$.ajax({
				
				url:'/SalesCube2020/SalesCubeAJAX?action=customerSearch',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){	
					document.getElementById("resultCustomer").removeAttribute('hidden');//テーブルの表示
					$("#customerResult > tr").remove();
						var tableAdd = document.getElementById('customerResult');
					
					if(Object.keys(data).length == 0){
						var message = '<p style="color: red;">該当する顧客情報は存在しません</p>';
     		 			$("#customerSearchError").empty();//エラーメッセージの削除
     		 			$("#customerSearchError").append(message);	//エラーメッセージの表示
     		 			document.getElementById("resultCustomer").setAttribute('hidden','hidden');
     		 		//検索結果がある場合
     		 		}else{
     		 		//エラーメッセージ
     		 			$("#customerSearchError").empty();//エラーメッセージの削除
     		 		//険悪結果件数の設定
     		 			$("#customerSearchResultCount").empty();
     		 			$('#customerSearchResultCount').append('検索結果件数：' + Object.keys(data).length + '件');	//検索結果件数の設定の表示
     		 			
     		 																	
						for(var i = 0; i<Object.keys(data).length; i++){
							var headcontents= '';
							headcontents += '<tr>';
							headcontents += '<td style="white-space: normal; text-align: left;" onclick="selectCustomerCode('+data[i].customerCode+",'"+data[i].customerName+"'"+');" data-dismiss="modal" ><a href="">'+data[i].customerCode+'</a></td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerName+'</td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerTEL+'</td>';  
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerPCName+'</td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].SalesCmCategory+'</td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].cutoffGroup+'</td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerOfficeName+'</td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerDeptName+'</td>';
							headcontents += '</tr>';
							$('#customerResult').append(headcontents);						
						}
						
					}
				}
			});
		}
     	

     	
      </script>  
      

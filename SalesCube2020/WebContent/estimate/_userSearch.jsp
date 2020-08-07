<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<title>userSearch</title>

	<style type="text/css">
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
    	</style>
	</head>
	
	<body style="background-color: gainsboro;">
       <!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       <br><br>

       
       <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#userSearch" onclick="initUser()" >
        ↓
        </button>
		
		<input type="text" id="UserModalUserId" name="UserModalUserId" placeholder="担当者コード" value="">
        <input type="text" id="UserModalNameKnj" name="UserModalNameKnj" placeholder="担当者名" value="">
        
		<div class="modal fade" id="userSearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                
                <div class="modal-header">
                    <h5 class="modal-title" id="label1">担当者検索</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                
                <!-- 検索部エラーメッセージ表示 -->
                <div id="userSearchError"></div>
                
                <form action="" id="dept">
               	<input type ="hidden" name="deptId" value="">
               </form>
               
               <form action="" id="role">
               	<input type ="hidden" name="roleId" value="">
               </form>
                
                <form action="" method="post" id="user">
                    <div class="modal-body">
                      <div class="row">
                        <div class="col-4">
                          <label class="sr-only" for="inlineFormInputGroup">userId</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">担当者コード</div>
                            </div>
                            <input type="text"  class="form-control" id="userId" name="userId" >
                          </div>
                        </div>
                      </div>
                   

                    
                      <div class="row">
                        <div class="col-5">
                          <label class="sr-only" for="inlineFormInputGroup">nameKnj</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">担当者名</div>
                            </div>
                            <input type="text"  class="form-control" id="nameKnj" name="nameKnj">
                          </div>
                        </div>
                      

                        <div class="col-6">
                          <label class="sr-only" for="inlineFormInputGroup">nameKana</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">担当者カナ</div>
                            </div>
                            <input type="text"  class="form-control" id="nameKana" name="nameKana">
                          </div>
                        </div>
                      </div>
                    
                      
                    
                      <div class="row">
                        <div class="col-5">
                            <label class="sr-only" for="inlineFormInputGroup">deptId</label>
                            <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                <div class="input-group-text">部門</div>
                              </div>
                              <select class="custom-select" name="deptId" id="SelectDeptId" >
                                
                              </select>
                            </div>
                        </div>

                        <div class="col-6">
                          <label class="sr-only" for="inlineFormInputGroup">roleId</label>
                            <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                <div class="input-group-text">権限</div>
                              </div>
                              <select class="custom-select" name="roleId" id="SelectRoleId">
                                
                              </select>
                            </div>
                        </div>
                      </div>
                    </div>
                  

                    <div class="rounded float-right">
                      <button type="button" class="btn btn-primary" onclick="initUser()">初期化</button>&ensp;
                      <input type="button" value="検索" class="btn btn-primary" onclick="userSearch1()">&ensp;
                    </div>
                    <br>
                    <br>
                </form>


                <div id="resultCustomer" hidden="hidden">
                    <div class="modal-body">
                      <div class="float-left" style="position:static; left: 0px;">
                        	  <span id="userSearchResultCount"></span>
                      </div>
                    <br>
                  </div>

				<!--担当者検索結果テーブル  -->
                  <div class="modal-body" style="background-color: rgb(255, 255, 255);">
                    <table id="order_detail_info" class="table table_1 table-bordered">
                      <thead class="thead-light">
                        <tr>
                          <th class="" style="cursor: pointer; height: 30px; " onclick="sort('userId');">担当者コード&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th>
                          <th class="" style="cursor: pointer; height: 30px; " onclick="sort('nameKnj');">担当者名&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th>
                          <th class="" style="cursor: pointer; height: 30px; " onclick="sort('deptId');">部門&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th> 
                        </tr>
                      </thead>
                      
                      	<tbody class="modal-body scroll-table" id="userResult" >
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
      
      //初期化処理
      	function initUser(){
      		 $("[name='userId']").val("");
             $("[name='nameKnj']").val("");
             $("[name='nameKana']").val("");
             $("[name='deptId']").val("");
             $("[name='roleId']").val("");	
             //テーブルの非表示
             document.getElementById("resultUser").setAttribute('hidden','hidden');
             
           //エラーメッセージの削除
             $("#userSearchError").empty();
     	}
      
      	//部門コンボボックス
     	function getCutoffGroup(){
     		var formString = $("form[id=dept]").serialize();
			var tmp = "";
			alert("call")
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateCategoryGet',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){
					$("#SelectDeptId").empty();
					
					var headcontents = '<option value =""></option>';	
					$('#SelectDeptId').append(headcontents);
					
					for(var i = 0; i<Object.keys(data).length; i++){
						var headcontents = '<option value ="'+data[i].deptId+'">'+data[i].name+'</option>';	
						$('#SelectDeptId').append(headcontents);
					}
					
				}
			});
		}
      	
     	//権限コンボボックス
     	function getCutoffGroup(){
     		var formString = $("form[id=role]").serialize();
			var tmp = "";
			alert("call")
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=estimateCategoryGet',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){
					$("#SelectRoleId").empty();
					
					var headcontents = '<option value =""></option>';	
					$('#SelectRoleId').append(headcontents);
					
					for(var i = 0; i<Object.keys(data).length; i++){
						var headcontents = '<option value ="'+data[i].roleId+'">'+data[i].name+'</option>';	
						$('#SelectRoleId').append(headcontents);
					}
					
				}
			});
		}
     	
     	
     	//担当者コード及び担当者名の値をセット。※親画面で書くコード
     	function selectCustomerCode(code, name){
      		document.getElementById('UserModalUserId').value = code;
      		document.getElementById('UserModalNameKnj').value = name;
      	}
      	    	
      
		function userSearch1() {
			var formString = $("form[id=user]").serialize();
			var tmp = "";
			
			$.ajax({
				
				url:'/SalesCube2020/SalesCubeAJAX?action=userSearch',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){	
					document.getElementById("resultUser").removeAttribute('hidden');//テーブルの表示
					$("#userResult > tr").remove();
						var tableAdd = document.getElementById('userResult');
					
					if(Object.keys(data).length == 0){
						var message = '<p style="color: red;">該当する担当者情報は存在しません</p>';
     		 			$("#userSearchError").empty();//エラーメッセージの削除
     		 			$("#userSearchError").append(message);	//エラーメッセージの表示
     		 			document.getElementById("resultUser").setAttribute('hidden','hidden');
     		 		//検索結果がある場合
     		 		}else{
     		 		//エラーメッセージ
     		 			$("#userSearchError").empty();//エラーメッセージの削除
     		 		//険悪結果件数の設定
     		 			$("#userSearchResultCount").empty();
     		 			$('#userSearchResultCount').append('検索結果件数：' + Object.keys(data).length + '件');	//検索結果件数の設定の表示
     		 			
     		 																	
						for(var i = 0; i<Object.keys(data).length; i++){
							var headcontents= '';
							headcontents += '<tr>';
							headcontents += '<td style="white-space: normal; text-align: left;" onclick="selectCustomerCode('+data[i].userId+",'"+data[i].nameKnj+"'"+')" data-dismiss="modal" ><a href="">'+data[i].userId+'</a></td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].nameKnj+'</td>';
							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].deptId+'</td>';  							
							headcontents += '</tr>';
							$('#customerResult').append(headcontents);						
						}
						
					}
				}
			});
		}
     	
      </script>  
      
	</body>
</html>
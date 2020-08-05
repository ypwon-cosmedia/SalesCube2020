<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>SalesCube modal_searchSupplier</title>
    <style type="text/css">
        .container {
            width: 1120px;
            max-width: none !important;
        }
        .cursor-pointer{
 		 	cursor: pointer;
 		 	color : blue;
		}

        table {
            border-collapse: collapse;
            border-spacing: 0;

            height: 250px;
            display: block;
            overflow-x: scroll;
            overflow-y: scroll;
            white-space: nowrap;
            
        }
        .table thead th{
            position: sticky;
            position: -webkit-sticky;
            top: 0;
            z-index: 1;
        }

        /*table{
            width: 100%;
        }
        .table thead tr th {
            white-space: nowrap;
            height: 50px;
            vertical-align: middle;
        }
        .table tr td {

            height: 50px;
            vertical-align: middle;
        }*/
    </style>
  </head>
    <body style="background-color: gainsboro;">
       <!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       <br><br>
       


       &emsp;&emsp;
    <!-- ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ ここから ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ -->

        <!-- ボタン（仕入れ先検索用）data-targetの変更必要 -->
        
        <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#openSearchSupplier">
            →
        </button>


            <div class="modal fade" id="openSearchSupplier" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="label1">仕入れ先検索</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                        </div>

                        <div class="modal-body">
                            <!-- 検索部 -->
                                <p style="color: red;"><!--EL式"$"該当する仕入れ先情報は存在しません--></p>
                                

                            <form action="" id="searchSupplier">
                                <div class="row">
                                    <div class="col-5">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">仕入れ先コード</div>
                                            </div>
                                        <input type="text" name="supplierCode" class="form-control" id="">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-5">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">仕入れ先名</div>
                                            </div>
                                        <input type="text" name="supplierName" class="form-control" id="">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">仕入れ先カナ</div>
                                            </div>
                                        <input type="text" name="supplierKana" class="form-control" id="" pattern="[\uFF66-\uFF9D]*">
                                        </div>
                                    </div>
                                </div>
                            
                                
                                <div class="row float-right">
                                    <input type="button" value="初期化" class="btn btn-primary" onclick="initSupplier()">&emsp;
                                    <input type="button" value="検索" class="btn btn-primary" onclick="existSerchResult(); this.form.reportValidity()">&emsp;
                                </div>
                            </form>
                                <br><br>
                                
                                <!-- テーブル部（検索結果） -->
                                <div id="serchResult" hidden="hidden">
                                
                                	検索結果件数：<br>

                                <table class="table table-bordered" id="supplierTable">
                                    <!-- ヘッダ部 -->
                                    <thead class="thead-light">
                                    <tr>
                                        <th class=".fixed01">仕入れ先コード</th>
                                        <th class=".fixed01">仕入れ先名</th>
                                        <th class=".fixed01">担当者</th>
                                        <th class=".fixed01">取引区分</th>
                                        <th class=".fixed01">備考</th>
                                    </tr>
                                    </thead>
                                    <!-- 内部 -->
                                    <tbody></tbody>
                                    <tr>
                                        <td class="cursor-pointer">1</td>
                                        <td>アンパンマン食品</td>
                                        <td>ジャムおじさん</td>
                                        <td>現金</td>
                                        <td>アンパンマンのことならお任せしたかったよ</td>
                                    </tr>
                                </table>
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
          		//初期化
                function initSupplier(){
          			//テキストボックス
                    $("[name='supplierCode']").val("");
                    $("[name='supplierName']").val("");
                    $("[name='supplierKana']").val("");

                    //テーブルの非表示
                    document.getElementById("serchResult").setAttribute('hidden','hidden');
                }
          		
                function existSerchResult(){
                    //if(resultCount <= 0){ 検索結果が0件
                        //テーブルの表示
                        document.getElementById("serchResult").removeAttribute('hidden');
                    //}
                }
                
                function searchSupplier() {
    				
    				var formString = $("form[id=searchSupplier]").serialize();//オブジェクトをバイト列に変換
    				var tmp = "";
    				
    				$.ajax({
    					url:'/SalesCube2020/SalesCubeAJAX?action=searchModalSupplier',//アクセス先のパス
    					type:'post',		//通信に利用するHTTPメソッド
    					data:formString,	//送信するデータ
    					dataType:'json',	//応答データの種類
    					
    					success:function(data){	//成功時
    						$("#supplierTable > tr").remove();//テーブルをクリア
               			 	
 	            		 		var tableAdd = document.getElementById('supplierTable');	//idがsupplierTableの要素を取得
 	            		 		for(var i = 0; i<Object.keys(data).length; i++){			//受け取ったdataの数だけ、繰り返す
 	            		 			var headcontents= '';
 	       							headcontents += '<tr>';
 	       							headcontents += '<td style="white-space: normal; text-align: left;" onclick="selectcustomerCode()" data-dismiss="modal" id="customerCode1"><a href="">'+data[i].supplierCode+'</a></td>';
 	       							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].supplierName+'</td>';
 	       							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].supplierPCName+'</td>';  
 	       							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].categoryCodeName+'</td>';
 	       							headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].remarks+'</td>';
 	       							headcontents += '</tr>';
 	       							$('#supplierTable').append(headcontents);					
 	            		    	}
    					}
    				});
    			}
            </script>
    </body>
</html>
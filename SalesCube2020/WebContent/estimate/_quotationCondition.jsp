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

    <title>SalesCube quotationConditions</title>
    <style type="text/css">
        .container {
            width: 1120px;
            max-width: none !important;
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
       
    <!-- ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ ここから ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊ -->

        <!-- ボタン（見積条件）data-targetの変更必要 
        <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setQuotationCondition" onclick="categoryShows()">
        ↓
        </button>
        <input type="text" id="estimateCondition">
        -->
        <form action="" id="quotationGet">
        	<input type="hidden" name="categoryId" value="35">
        </form>

            <div class="modal fade" id="setQuotationCondition" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        
                        <div class="modal-header">
                            <h5 class="modal-title" id="label1">区分情報</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                        </div>

                        <div class="modal-body" id="selectQuotation">
                            <!--  <input type="radio" name="quotationCondition" value="">10日締め翌月10日現金支払い<br>-->
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="writeShipdates()">反映</button>
                        </div>

                    </div>
                </div>
            </div>
            
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
			<script>

            		 function writeShipdates(){
            			 var radio = document.getElementsByName('radioQuotation');	//idがshipdateの要素を取得
            			 	// 選択状態の値を取得
							for ( var checkedShipdate="", i=radio.length; i--; ) {	//radioボタンの回数分繰り返す
								if ( radio[i].checked ) {							//選択されていたら
									var checkedShipdate = radio[i].value ;			//radioボタンのvalueを取得
									break ;
								}
							}
            			 document.getElementById('estimateCondition').value = checkedShipdate
            		 }
            		 
            		 function categoryShows() {
            				
            				var formString = $("form[id=quotationGet]").serialize();			//オブジェクトをバイト列に変換
            				var tmp = "";
            				
            				$.ajax({
            					url:'/SalesCube2020/SalesCubeAJAX?action=estimateCategoryGet',	//アクセス先のパス
            					type:'post',		//通信に利用するHTTPメソッド
            					data:formString,	//送信するデータ
            					dataType:'json',	//応答データの種類
            					
            					success:function(data){	//成功時
            						$("#selectQuotation").empty();//ラジオボタンをクリア
                       			 	
         	            		 		var radioAdd = document.getElementById('selectQuotation');	//idがselectQuotationの要素を取得
         	            		 		for(var i = 0; i<Object.keys(data).length; i++){			//受け取ったdataの数だけ、繰り返す
         	            		      		var radio = document.createElement('input');			//input要素を作成
         	            		      		var label = document.createElement('label');			//label要素を作成
         	            		      		var br = document.createElement('br');					//改行の要素を作成
         	            		      		var id = "radioQuotation";								//idを決める
         	            		      		var name = "radioQuotation";							//nameを決める
         	            		      		var value = data[i].categoryCodeName;					//valueをvaluesから取得
         	            		      
         	            		      		radio.setAttribute("type", "radio");					//input要素のtypeをradioにする
         	            		      		radio.setAttribute("value", value);						//valueを設定する
         	            		      		radio.setAttribute("id", id);							//idを設定する
         	            		      		radio.setAttribute("name", name);						//nameを設定する
         	            		      		label.setAttribute("for", id);							//labelを付ける要素を指定
         	            		      		label.innerHTML = value;								//innerHTMLにvalueを入れる
         	            		      
         	            		      		radioAdd.appendChild(radio);							//radioAddにラジオボタンを追加する
         	            		      		radioAdd.appendChild(label);							//radioAddにラベルを追加する
         	            		      		radioAdd.appendChild(br);								//radioAddに改行を追加する
         	            		    	}
            					}
            				});
            			}
            		 
			</script>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

            <div class="modal fade" id="setSlipConfiguration" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        
                        <div class="modal-header">
                            <h5 class="modal-title" id="label1">検索結果設定</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                        </div>

                        <div class="modal-body">
                            	検索対象：伝票<!--明細-->
                            <br><br>
                            	※見積番号は必ず表示されます
                            <br><br>
                            &emsp;非表示リスト&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;表示リスト
                            <br>
                            <div class="row container">
                            &emsp;
                            <select size="7" name="notShowSearchResult" id="notShowSearchResult" style="width: 160px;" onchange="rightLeft()">
                                
                                <!-- **********ここに非表示のoptionタグを挿入*********** 例 option value=itemId>itemName</option -->

                            </select>
                            &emsp;

                                <table>
                                <tr><td>&ensp;</td></tr>
                                <tr><td>&ensp;</td></tr>
                                <tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" id="rightButton" disabled onclick="moveSelected();  rightLeft(); updownButtonStyle()">→</button></td></tr>
                                <tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" id="leftButton" disabled onclick="moveUnselected(); rightLeft(); updownButtonStyle()">←</button></td></tr>
                                </table>
                            
                            &emsp;
                            <select size="7" name="showSearchResult" id="showSearchResult" style="width: 160px;" onchange="buttonStyle(this); rightLeft()">
                                <!-- **********ここに表示のoptionタグを挿入*********** 例 option value=itemId>itemName</option -->

                            </select>
                                &emsp;
                                <table>
                                    <tr><td>&ensp;</td></tr>
                                    <tr><td>&ensp;</td></tr>
                                    <tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" id="upButton" disabled onclick="moveVertical(-1)">↑</button></td></tr>
                                    <tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" id="downButton" disabled onclick="moveVertical(1)">↓</button></td></tr>
                                    </table>

                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="configGet(); initButton()">初期化</button>                            
                            <button type="button" class="btn btn-primary" onclick="updateShowItem()" data-dismiss="modal">更新</button>                            
                            <button type="button" class="btn btn-primary" data-dismiss="modal">閉じる</button>
                        </div>

                    </div>
                </div>
            </div>



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script>
    
	//表示・非表示リストの取得
    function configGet(){
    	
		//表示項目の取得
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=estimateShowCfgGet',  //アクセス先のパス
			type:'post',		//通信に利用するHTTPメソッド
			dataType:'json',	//応答データの種類
			
			success:function(data){	//成功時
        		
        		$('#showSearchResult option').remove();							//optionの項目の削除
				
        		/*見積番号を不可視の状態で挿入------------------------------
        		var hide = '<span><option value="'
        					+ data[0].itemId 
        					+ '">' 
        					+ data[0].itemName 
        					+'</option></span>';
        		$('#showSearchResult').append(hide);							//spanにoptionタグを挿入
        		-------------------------------------------------------*/
        		
        		//見積番号以外の表示項目を挿入
        		var showResult = document.getElementById('showSearchResult');   //optionタグを入れる箇所の指定
        		
        		for( var i = 0; i < Object.keys(data).length ; i++ ){			//0番目は、「見積番号」
        			if( data[i].itemId != "estimateSheetId" ){
	            		var option = document.createElement('option');          //optionタグの生成
	            		option.setAttribute('value', data[i].itemId );          //value値の挿入
	            		option.innerHTML = data[i].itemName;                    //HTMLで表示する項目名
	            		showResult.appendChild(option);                         //selectにoptionタグを挿入
        			}
        		}
			}
		});
		
		//非表示リストの取得
		
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=estimateNotShowCfgGet',  //アクセス先のパス
			type:'post',		//通信に利用するHTTPメソッド
			dataType:'json',	//応答データの種類
			
			success:function(data){	//成功時
        		
        		$('#notShowSearchResult option').remove();								//optionの項目の削除

        		var notShowResult = document.getElementById('notShowSearchResult');		//optionタグを入れる箇所の指定
        		for( var i = 0; i < Object.keys(data).length ; i++ ){
        			if( data[i].itemId != "estimateSheetId" ){
	            		var option = document.createElement('option');              	//optionタグの生成
	            		option.setAttribute('value', data[i].itemId );              	//value値の挿入
	            		option.innerHTML = data[i].itemName;                        	//HTMLで表示する項目名
	            		notShowResult.appendChild(option);                             	//selectにoptionタグを挿入
        			}
        		}
			}
		});
	}
	
    //表示項目の更新
    function updateShowItem(){
    	var opts = $("#showSearchResult option").map(function() {return $(this).val();}).get();
    	jQuery.ajaxSettings.traditional = true;		//これを true に設定すると、.serialize() メソッドでのシリアライズ化を行わない
    	$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=estimateCfgUpd',  //アクセス先のパス
			type:'post',				//通信に利用するHTTPメソッド
			data:{'showList' : opts},	//送信するデータ(「キー名: 値」)
			dataType:'json',			//応答データの種類
			
			success:function(data){	//成功時
				alert("success");
			}
    	});
    }
    
    //右への移動(非表示から表示)
    function moveSelected(){
		$('#notShowSearchResult option:selected').appendTo('#showSearchResult');
		$('#notShowSearchResult option:selected').remove();
		
	}

    //左への移動(表示から非表示)
	function moveUnselected(){
		$('#showSearchResult option:selected').appendTo('#notShowSearchResult');
		$('#showSearchResult option:selected').remove();
		
	}

    //上下ボタンの非活性化(「 Opt 」は、リストボックスで選択されている項目)
    function buttonStyle(Opt){
        var UpButton = document.getElementById('upButton');
        var DownButton = document.getElementById('downButton');
        for(var i=0;i<Opt.options.length;i++){
            if(Opt.options[i].selected){
                //上ボタンの位置の判断
                if(i!=0) UpButton.disabled = false;
                else UpButton.disabled = true;
                //下ボタンの位置の判断
                if(i!=(Opt.options.length-1)) DownButton.disabled = false;
                else DownButton.disabled = true;
            }
        }
    }
    function rightLeft(){
        //左ボタン
		var showOpt = document.getElementById('showSearchResult');
		var leftButton = document.getElementById('leftButton');
        if(showOpt.options.length != 0 && showOpt.selectedIndex != -1){
        	leftButton.disabled = false;
        }else{
        	leftButton.disabled = true;
        }
        //右ボタン
		var notOpt = document.getElementById('notShowSearchResult');
		var rightButton = document.getElementById('rightButton');
        if(notOpt.options.length != 0 && notOpt.selectedIndex != -1){
        	rightButton.disabled = false;
        }else{
        	rightButton.disabled = true;
        }
    }
    
    //上下の移動(「「mode = -1」なら上、「mode = 1」なら下へ移動)
    function moveVertical(mode){
        var Opt = document.getElementById('showSearchResult');
        for(var i=0;i<Opt.options.length;i++)
        if(Opt.options[i].selected) break;
        var tmpOption = Opt.removeChild(Opt.options[i]);
        Opt.insertBefore(tmpOption,Opt.options[i+mode]);

        buttonStyle(Opt);
    }
	
	//ボタンの初期化
	function initButton(){
		document.getElementById('rightButton').disabled = true;
		document.getElementById('leftButton').disabled  = true;
		document.getElementById('upButton').disabled 	= true;
		document.getElementById('downButton').disabled  = true;
	}
	
	//上下ボタンの非活性化()
    function updownButtonStyle(){
    	var Opt = document.getElementById('showSearchResult');
        var UpButton = document.getElementById('upButton');
        var DownButton = document.getElementById('downButton');
        for(var i=0;i<Opt.options.length;i++){
            if(Opt.options[i].selected){
                //上ボタンの位置の判断
                if(i!=0) UpButton.disabled = false;
                else UpButton.disabled = true;
                //下ボタンの位置の判断
                if(i!=(Opt.options.length-1)) DownButton.disabled = false;
                else DownButton.disabled = true;
            }else{
            	UpButton.disabled = true;
            	DownButton.disabled = true;
            }
        }
    }
    
    </script>

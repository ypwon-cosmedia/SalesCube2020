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

    <title>SalesCube configure</title>
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
       
       <!-- <div style="padding-left: 20px"> -->
       <!--
       <div style="width:100%; text-align:center; margin-bottom:20px;">
				 <span class="action_errors" style="color: red">ユーザーIDとパスワードの入力は必須です。<br></span>
       </div>
       -->


       &emsp;&emsp;
        <!-- ボタン（設定）data-targetの変更必要 -->
        <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#setSlipConfiguration" onclick="configGet()">
            	( ^_^ )/
        </button>


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
                            <select size="7" name="notShowSearchResult" id="notShowSearchResult" style="width: 160px;">
                                
                                <!-- **********見積番号は固定（非表示）*********** <option value="見積番号">見積番号</option>
                                <option value="見積日">見積日</option>
                                <option value="有効期限">有効期限</option>
                                <option value="伝票合計">伝票合計</option>
                                <option value="件名">件名</option>
                                <option value="提出先名">提出先名</option>
                                <option value="提出先敬称">提出先敬称</option>
                                <option value="顧客コード">顧客コード</option>
                                <option value="顧客名">顧客名</option>
                                -->

                            </select>
                            &emsp;

                                <table>
                                <tr><td>&ensp;</td></tr>
                                <tr><td>&ensp;</td></tr>
                                <tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" onclick="moveSelected()">→</button></td></tr>
                                <tr><td><button name="" class="btn btn-primary" style="width: 40px;height: 40px;" onclick="moveUnselected()">←</button></td></tr>
                                </table>
                            
                            &emsp;
                            <select size="7" name="showSearchResult" id="showSearchResult" style="width: 160px;" onchange="buttonStyle(this)">

                                <!--
                                <option value="粗利益">粗利益</option>
                                <option value="粗利益率">粗利益率</option>
                                <option value="金額合計">金額合計</option>
                                <option value="消費税">消費税</option>
                                <option value="納期または出荷日">納期または出荷日</option>
                                <option value="入力担当者名">入力担当者名</option>
                                <option value="入力担当者コード">入力担当者コード</option>
                                <option value="摘要">摘要</option>
                                <option value="納入先">納入先</option>
                                <option value="見積条件">見積条件</option>
                                -->

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
                            <button type="button" class="btn btn-primary" onclick="configGet()">初期化</button>                            
                            <button type="button" class="btn btn-primary" onclick="" >更新</button>                            
                            <button type="button" class="btn btn-primary" data-dismiss="modal">閉じる</button>
                        </div>

                    </div>
                </div>
            </div>



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script>
    
    //配列をスコープから取得
    function configGet(){
            
        //配列の作成
        let showName = [];
        let notShowName = [];
        let showID = [];
        let notShowID = [];

        //項目の消去
        showName.splice(0, showName.length);
        showID.splice(0, showID.length);
        notShowName.splice(0, notShowName.length);
        notShowID.splice(0, notShowID.length);
        
        //配列に追加
        for(var i = 0; i<6/**リストの項目の数を書く！**/; i++){
            showName.push( 'TRUE.' + (i+1) );
            showID.push( 'tester.' + i );
        }
        for(var i = 0; i<6/**リストの項目のの数を書く！**/; i++){
            notShowName.push( 'NOT.' + i+1 );
            notShowID.push( 'tester.' + i );
        }

         //optionの項目の削除
        $('#showSearchResult option').remove();
        $('#notShowSearchResult option').remove();

        var showResult = document.getElementById('showSearchResult');   //optionタグを入れる箇所の指定
        for( var i = 0; i < showName.length ; i++ ){
            var option = document.createElement('option');              //optionタグの生成
            option.setAttribute('value', showID[i]);                    //value値の挿入
            option.innerHTML = showName[i];                             //HTMLで表示する項目名
            showResult.appendChild(option);                             //selectにoptionタグを挿入
        }
        var notShowResult = document.getElementById('notShowSearchResult');     //optionタグを入れる箇所の指定
        for( var i = 0; i < notShowName.length ; i++ ){
            var option = document.createElement('option');                      //optionタグの生成
            option.setAttribute('value', notShowID[i]);                         //value値の挿入
            option.innerHTML = notShowName[i];                                  //HTMLで表示する項目名
            notShowResult.appendChild(option);                                  //selectにoptionタグを挿入
        }

    }

    /**
    //配列を更新
    function updCfg(){
        //「i」番目のものを配列に追加
        for(配列.length){
            showName.push(  );
            notShowName.push(  );
        }

        for(配列.length){
        showID.push(  );
        notShowID.push(  );
        }
    }
    **/

    
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
    //上下の移動(「「mode = -1」なら上、「mode = 1」なら下へ移動)
    function moveVertical(mode){
        var Opt = document.getElementById('showSearchResult');
        for(var i=0;i<Opt.options.length;i++)
        if(Opt.options[i].selected) break;
        var tmpOption = Opt.removeChild(Opt.options[i]);
        Opt.insertBefore(tmpOption,Opt.options[i+mode])

        buttonStyle(Opt);
    }

    </script>

    </body>
</html>
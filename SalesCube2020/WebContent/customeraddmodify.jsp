<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=	evice-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>SalesCube　顧客マスタ（管理・編集）</title>
    <style type="text/css">
        .container {
            width: 1120px;
            max-width: none !important;
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
        </ul>
        <span class="navbar-text">
          <svg class="bi bi-person-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
          </svg>
        	${userInfo.nameKNJ} &nbsp;     	
        </span>
        <form class="form-inline" action="/SalesCube2020/SalesCube?action=logout" method="post">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
    </nav>
	<br>
    <div class="container" id="main_function">
      <h3 class="float-left">顧客</h3>

      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()" >F1<br>初期化</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="backForm()">F2<br>戻る</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="registrationForm()" >F3<br>${status eq 'add' ? "登録" : "更新"}</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick= "deleteForm()" ${status eq 'add' ? "disabled" :''}>F4 <br>削除</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F5<br>初期値</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F6<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F7<br></button>
			<form action="/SalesCube2020/SalesCube? action=producthistoryoutput">
				<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick= "productHistoryOutPut()" disabled>F8<br>履歴出力</button>
			</form>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F9<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F10<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F11<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F12<br></button>
        </div>
      </div>
      
      <br><br><br>
      </div>
<!-- 顧客情報 -->
	<form ${status eq 'add' ? "action='/SalesCube2020/SalesCube?action=addCustomer'" :"action='/SalesCube2020/SalesCube?action=modifyCustomer'"} method="post" name="mainform">
      <div class="container" style="background-color: white;"><div class="panel panel-default" >
        <div class="panel-heading row mb-2 col-4">
            <h5><br>顧客情報</h5>
        </div>
        <hr>
        <div class="panel-body">
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup"></label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客コード</div>
                            </div>
                        <input type="number"  class="form-control" id="inlineFormInputGroup" name="customerCode" value="${customer.customerCode}" required ${status eq 'add' ? "" :'readonly'}>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup"></label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客名</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="customerName" value="${customer.customerName}" required>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup"></label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客カナ</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="customerKana" value="${customer.customerKana}" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup"></label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">事業所名</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="officeName" value="${customer.officeName}" required>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">officeNameKana</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">事業所カナ</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="officeNameKana" value="${customer.officeNameKana}" required>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">customerAbbr</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客略称</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="customerAbbr" value="${customer.customerAbbr}" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">zipCode</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">郵便番号</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="zipCode" value="${customer.zipCode}" required>                       
                        <!-- <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;"> -->
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">zipAddress1</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">住所1</div>
                            </div>
                            <input type="text"  class="form-control" id="inlineFormInputGroup" name="zipAddress1" value="${customer.zipAddress1}" required>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">zipAddress2</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">住所2</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="zipAddress2" value="${customer.zipAddress2}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">PCName</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">担当者</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="PCName" value="${customer.PCName}">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">PCNameKana</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">担当者カナ</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="PCNameKana" value="${customer.PCNameKana}">
                        </div>
                    </div>
                
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">PCPreCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">敬称</div>
                            </div>
                            <select id="PCPreCategory" class="custom-select" name="PCPreCategory">
                            	<option value=""></option>
                            	<option value="0">御中</option>
                                <option value="1">様</option>
                                <option value="2">殿</option>
                            </select>
                        </div>
　　　　　　    　　　		</div>
                </div>
                <div class="row">
                    <div class="col-5">
                        <label class="sr-only" for="inlineFormInputGroup">deptName</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">部署名</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="deptName" value="${customer.deptName}">
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">PCPost</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">役職</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="PCPost" value="${customer.PCPost}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-5">
                        <label class="sr-only" for="inlineFormInputGroup">TEL</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">TEL</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="tel" value="${customer.tel}">
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">FAX</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">FAX</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="fax" value="${customer.fax}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-5">
                        <label class="sr-only" for="inlineFormInputGroup">email</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">E-MAIL</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="email" value="${customer.email}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">rankCategory</label>
                        <div class="input-group mb-2 form-inline">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客ランク</div>
                            </div>
								<select class="custom-select" id="rankCategory" name="rankCategory" name="rankCategory">
								</select>
                        &emsp;<label><input type="checkbox" name="updateFlag"  value="{customer.updateFlag}" >&ensp;顧客ランク適用</label>
                        </div>
                    </div>
                    	<div class="col-3">
                        	<label class="sr-only" for="inlineFormInputGroup">ROCategory</label>
                        	<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">受注停止</div>
								</div>
                            	<select class="custom-select" name="ROCategory" id="ROCategory">
                                	<option value=""></option>
                            		<option value="1">取引停止</option>
                                	<option value="2">入金遅延</option>
                            	</select>
                        	</div>
                    	</div>
	                   	<div class="col-3">
	                        <label class="sr-only" for="inlineFormInputGroup">maxCreditLimit</label>
	                        <div class="input-group mb-2">
	                            <div class="input-group-prepend">
	                                <div class="input-group-text">与信限度額</div>
	                            </div>
	                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="maxCreditLimit" value="${customer.maxCreditLimit}">
	                        </div>
	                    </div>
	                </div>
 		               <div class="row">
	 	                   <div class="col-3">
 		                       <label class="sr-only" for="inlineFormInputGroup">businessCategory</label>
	 	                       <div class="input-group mb-2">
 		                           <div class="input-group-prepend">
 	                               <div class="input-group-text">業種</div>
 	                           </div>
 		                           <select class="custom-select" name="businessCategory" id="businessCategory">
							       		<option value=""></option>
                            			<option value="1">コンピュータ関連</option>	
                                		<option value="2">通信関連</option>
                                		<option value="3">重電</option>	
                                		<option value="4">家電・AV関連</option>
                                		<option value="5">その他の電気機器</option>
                                		<option value="6">OA・精密機器</option>	
                                		<option value="7">検査・計測機器</option>
                                		<option value="8">半導体関連</option>	
                                		<option value="9">電気・電子部品</option>
                                		<option value="10">自動車関連</option>	
                                		<option value="11">その他の輸送機器</option>
                                		<option value="12">工作機械関連</option>	
                                		<option value="13">その他の産業機器</option>
                                		<option value="14">印刷関連</option>	
                                		<option value="15">食品関連</option>
                                		<option value="16">化学関連</option>	
                                		<option value="17">繊維関連</option>
                                		<option value="18">住宅関連</option>	
                                		<option value="19">その他の製造業</option>
                                		<option value="20">その他の設計業</option>	
                                		<option value="21">商社・卸売り</option>
                                		<option value="22">医療・福祉関連</option>
                                		<option value="23">学校</option>	
                                		<option value="24">官公庁</option>
                                		<option value="25">その他</option>	
                                		<option value="26">個人事業</option>
								   </select>
 		                       </div>
 		                   </div>
 		                   <div class="col-4">
 		                       <label class="sr-only" for="inlineFormInputGroup">jobCategory</label>
		                        <div class="input-group mb-2">
		                            <div class="input-group-prepend">
		                                <div class="input-group-text">職種</div>
		                            </div>
		                            <select class="custom-select" name="jobCategory" id="jobCategory">
							       		<option value=""></option>
                            			<option value="1">製品設計・商品設計</option>	
                                		<option value="2">研究・開発</option>
                                		<option value="3">設備・金型・治工具設計</option>	
                                		<option value="4">生産技術・製造技術</option>
                                		<option value="5">製造・加工・生産</option>
                                		<option value="6">検査・品質管理</option>	
                                		<option value="7">資材・購買</option>
                                		<option value="8">営業</option>	
                                		<option value="9">企画・マーケティング	</option>
                                		<option value="10">管理・総務</option>	
                                		<option value="11">保守・メンテナンス</option>
                                		<option value="12">その他</option>	
 		                            </select>
 		                        </div>
	                       </div>
	                   </div>
 	                <div class="row">
  	                  <div class="col-3">
 	                       <label class="sr-only" for="inlineFormInputGroup">fractCategory</label>
 	                       <div class="input-group mb-2">
  	                          <div class="input-group-prepend">
	                                <div class="input-group-text" style="background-color: pink;"> 税端数処理</div>
  	                          </div>
  		                          <select class="custom-select" name="fractCategory" id="fractCategory">
										<option value="1">切り捨て</option>
										<option value="2">四捨五入</option>
										<option value="3">切り上げ</option>
  		                          </select>
 	                       </div>
 	                   </div>
 	                  <div class="col-3">
	                        <label class="sr-only" for="inlineFormInputGroup">shiftCategory</label>
    	                    <div class="input-group mb-2">
	                            <div class="input-group-prepend">
 	                               <div class="input-group-text" style="background-color: pink;">税転嫁</div>
  	                            </div>
		                            <select class="custom-select" name="shiftCategory" id="shiftCategory">
										<option value="1">外税締単位</option>
										<option value="2">外税伝票計</option>
 		                            </select>
 	                        </div>
	                  </div>
                      <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">lastCutoffDate</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">最終締処理日</div>
                            </div>
 	                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="lastCutoffDate" value="${customer.lastCutoffDate}" readonly>
                        </div>
                      </div>
                	</div>
                	<div class="row">
                    	<div class="col-4">
                        	<label class="sr-only" for="inlineFormInputGroup">salesCMCategory</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text" style="background-color: pink;">取引区分</div>
                            	</div>
                            	<select class="custom-select" name="salesCMCategory" id="salesCMCategory">
                                	<option value="1">掛売</option>
									<option value="2">現金</option>
									<option value="3">サンプル</option>
									<option value="4">代引き</option>
									<option value="5">クレジット</option>
									<option value="6">先入金</option>
									<option value="7">通販サイト1経由</option>
                            	</select>
                        	</div>
                    	</div>
                    	<div class="col-5">
                        	<label class="sr-only" for="inlineFormInputGroup">cutoffGroup</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text" style="background-color: pink;">支払い条件</div>
                            	</div>
                            	<select class="custom-select" name="cutoffGroup" id="cutoffGroup">
                                	<option value="1">10日締め翌月10日</option>
									<option value="2">20日締め翌月20日</option>
									<option value="3">25日締め翌月末</option>
									<option value="4">月末締め翌月末日</option>
									<option value="5">月末締め翌々月5日</option>
									<option value="6">その他</option>
                           		</select>
                        	</div>
                    	</div>
                    	<div class="col-3">
                        	<label class="sr-only" for="inlineFormInputGroup">paybackTypeCategory</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text" style="background-color: pink;">回収方法</div>
                            	</div>
                            	<select class="custom-select" name="paybackTypeCategory" id="paybackTypeCategory">
                                	<option value="1">現金</option>
									<option value="2">小切手</option>
									<option value="3">振込</option>
									<option value="4">手形</option>
									<option value="5">その他</option>
                            	</select>
                        	</div>
                    	</div>
                	</div>
                	<div class="row">
                    	<div class="col-4">
                        	<label class="sr-only" for="inlineFormInputGroup">billPrintUnit</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text" style="background-color: pink;">請求書発行単位</div>
                            	</div>
                            	<select class="custom-select" name="billPrintUnit" id="billPrintUnit">
                                	<option value="1">請求書なし</option>
									<option value="2">請求締め単位</option>
									<option value="3">売上伝票単位</option>
                            	</select>
                        	</div>
                    	</div>
                    	<div class="col-3">
                        	<label class="sr-only" for="inlineFormInputGroup">billDatePrint</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text" style="background-color: pink;">請求書日付有無</div>
                            	</div>
                            	<select class="custom-select" name="billDatePrint" id="billDatePrint">
                                	<option value="1">なし</option>
									<option value="2">あり</option>
                            	</select>
                        	</div>
                    	</div>
                    	<div class="col-3 form-inline">
                        	<label class="sr-only" for="inlineFormInputGroup">tempDeliverySlipFlag</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text">仮納品書出力不可</div>
                            	</div>
                        	&emsp;<label><input type="checkbox" name="tempDeliverySlipFlag"  value="{customer.tempDeliverySlipFlag}"></label>
                        	</div>
                    	</div>
                	</div>
                	<div class="row">
                    	<div class="col-8">
                        	<label class="sr-only" for="inlineFormInputGroup">paymentName</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text">振込名義</div>
                            	</div>
                        	<input type="text"  class="form-control" id="inlineFormInputGroup" name="paymentName" value="${customer.paymentName}">
                        	</div>
                    	</div>
                	</div>
                	<div class="row">
                    	<div class="col-8">
                        	<label class="sr-only" for="inlineFormInputGroup">remarks</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text">備考</div>
                            	</div>
                        	<input type="text"  class="form-control" id="inlineFormInputGroup" name="remarks" value="${customer.remarks}">
                        	</div>
                    	</div>
                	</div>
                	<div class="row">
                    	<div class="col-8">
                        	<label class="sr-only" for="inlineFormInputGroup">comment</label>
                        	<div class="input-group mb-2">
                            	<div class="input-group-prepend">
                                	<div class="input-group-text">コメント</div>
                            	</div>
                        	<input type="text"  class="form-control" id="inlineFormInputGroup" name="comment" value="${customer.comment}">
                        	</div>
                    	</div>
                	</div>   
 	            </div>
    	</div><br>
    </div></div><br>
    
<!-- 納入先情報 -->
<div class="container" style="background-color: white;"><div class="panel panel-default" >
    <div class="panel-heading row mb-2 col-4 form-inline">
        <h5><br>納入先情報</h5>
    </div>
    <hr>
    <div class="panel-body">

            <!--  <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">納入先</div>
                        </div>
                        <select class="custom-select" name="deliveryCode" onchange="setInitDelivery(this)">
                        			<option value=""></option>
                                <c:forEach items="${deliveryList}" var="delivery">
                                	<option value="${delivery.deliveryCode} }">${delivery.deliveryName}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
            </div> -->
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">納入先名</div>
                        </div>
                        <input type="hidden" name="deliveryCode" value="${deliveryList.get(0).deliveryCode}">
                    <input type="text"  class="form-control" id="inlineFormInputGroup deliveryName" name="deliveryName" value="${deliveryList.get(0).deliveryName}" required>
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">納入先名カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup deliveryKana" name="deliveryKana" value="${deliveryList.get(0).deliveryKana}" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delOfficeName" name="delOfficeName" value="${deliveryList.get(0).officeName}">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delOfficeKana" name="delOfficeKana" value="${deliveryList.get(0).officeKana}">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">部署名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delDeptName" name="delDeptName" value="${deliveryList.get(0).deptName}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">郵便番号</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delZipCode " name="delZipCode" value="${deliveryList.get(0).zipCode}" required>                       
                    <!-- <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;"> -->
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">住所1</div>
                        </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup delAddress1" name="delAddress1" value="${deliveryList.get(0).address1}" required>
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">住所2</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delAddress2" name="delAddress2" value="${deliveryList.get(0).address2}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">担当者</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delPCName" name="delPCName" value="${deliveryList.get(0).PCName}">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">担当者カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delPCNameKana" name="delPCKana" value="${deliveryList.get(0).PCKana}">
                    </div>
                </div>
            
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">敬称</div>
                        </div>
                        <select class="custom-select" name="delPCPreCategory" id="delPCPreCategory">
                                	<option value=""></option>
									<option value="1">御中</option>
									<option value="2">様</option>
									<option value="3">殿</option>
                        </select>
                    </div>
　　　　　　    　　　</div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">TEL</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delTel" name="delTel" value="${deliveryList.get(0).tel}">
                    </div>
                </div>
                <div class="col-3">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">FAX</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delFax" name="delFax" value="${deliveryList.get(0).fax}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">E-MAIL</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup delEmail" name="delEmail" value="${deliveryList.get(0).email}">
                    </div>
                </div>
            </div>            
        
        
    </div>
        
    
</div><br></div><br>

<!-- 請求先情報 -->
<div class="container" style="background-color: white;"><div class="panel panel-default" >
    <div class="panel-heading row mb-2 col-4">
        <h5><br>請求先情報</h5>
    </div>
    <hr>
    <div class="panel-body">
      
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">請求先名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="deliveryName2" value="${delivery2.deliveryName}" required>
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">請求先名カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="deliveryKana2" value="${delivery2.deliveryKana}" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delOfficeName2" value="${delivery2.officeName}">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delOfficeKana2" value="${delivery2.officeKana}">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">部署名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delDeptName2" value="${delivery2.deptName}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productStatusCategory</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">郵便番号</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delZipCode2" value="${delivery2.zipCode}" required>                       
                    <!--  <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;"> -->
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">住所1</div>
                        </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="delAddress1_2" value="${delivery2.address1}" required>
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">setTypeCategory</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">住所2</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delAddress2_2" value="${delivery2.address2}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">担当者</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delPCName2" value="${delivery2.PCName}">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">担当者カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delPCKana2" value="${delivery2.PCKana}">
                    </div>
                </div>
            
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">敬称</div>
                        </div>
                        <select class="custom-select" name="delPCPreCategory2" id="delPCPreCategory2">
                                	<option value=""></option>
									<option value="1">御中</option>
									<option value="2">様</option>
									<option value="3">殿</option>
                        </select>
                    </div>
　　　　　　    　　　	</div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">TEL</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delTel2" value="${delivery2.tel}">
                    </div>
                </div>
                <div class="col-3">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">FAX</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delFax2" value="${delivery2.fax}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-5">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">E-MAIL</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="delEmail2" value="${delivery2.email}">
                    </div>
                </div>
            </div>            
        
          
    </div>
        
    
</div><br></div><br>


<!-- ボタン -->
<div align="right" class="container">
    <input type="button" value="初期化" class="btn btn-outline-secondary" onclick="initForm()" >
    <input type="button" value="${status eq 'add' ? '登録' : '更新'}" class="btn btn-outline-secondary" onclick="registrationForm()">
    <input type="button" value="削除" class="btn btn-outline-secondary" onclick="deleteForm()" ${status eq 'add' ? "disabled" :''}>
</div>
</form> 
	<form action="/SalesCube2020/SalesCube?action=deleteCustomer" method="post" name="deleteform">
		<input type="hidden" name="customerCode" value="${customer.customerCode}">
	</form>
<br><br>    


<script>
	function initForm() {
		if(!confirm("入力内容を初期化してよろしいですか？")){
			return;
		}
		window.location.href = '/SalesCube2020/SalesCube?action=moveAddCustomer';
	}
    	
	function backForm() {
		if(!confirm("顧客検索画面に戻ります。よろしいですか？")) {
			return;
		}
		window.location.href = '/SalesCube2020/SalesCube?action=customer';
	}
    		
	function registrationForm() {
	 var status = "${status}";
	 	if(status=="add"){
			if(!confirm("入力内容を登録します。よろしいですか？")) {
				return;
			}
			var form = document.mainform;
			form.submit();
	 	}
	 	else {
			if(!confirm("入力内容を更新します。よろしいですか？")) {
				return;
			}
			var form = document.mainform;
			form.submit();
		}
	 }
 
 /*
 function confirmForm() {
	 var status = "${status}";
	 	if(status=="add"){
			if(!confirm("入力内容を登録します。よろしいですか？")) {
				return;
			}
	 	}
	 	else {
			if(!confirm("入力内容を更新します。よろしいですか？")) {
				return;
			}
			
		}
	 }
 */
 

    		
	function deleteForm() {
		if(!confirm("このデータを削除しますか？")) {
			return;
		}
		var form = document.deleteform;
		
		form.submit();
    			
	}
    		
	function customerHistoryOutPut() {
		if(!confirm("履歴をExcel出力しますか？")) {
			return;
		}		
	}
 
 	/*
 	var deliveryList = [];
		window.onload = function(){
			var loop=0;
		
			<c:forEach var="delivery" items="${deliveryList}" >
			  deliveryList[loop] = {
					 //listNo:""
					 deliveryCode:"${delivery.deliveryCode}",
					 deliveryName:"${delivery.deliveryName}",
					 deliveryKana:"${delivery.deliveryKana}",
					 delOfficeName:"${delivery.officeName}",
					 delOfficeKana:"${delivery.officeKana}",
					 delDeptName:"${delivery.deptName}",
					 delZipCode:"${delivery.zipCode}",
					 delAddress1:"${delivery.address1}",
					 delAddress2:"${delivery.address2}",
					 delPCName:"${delivery.PCName}",
					 delPCNameKana:"${delivery.PCKana}",
					 delPCPreCategory:"${delivery.PCPreCategory}",
					 delTel:"${delivery.tel}",
					 delFax:"${delivery.fax}",
					 delEmail:"${delivery.email}"	
					  };
		  			loop++;  	
			</c:forEach>
 
  	function setInitDelivery(del) {
 		
 		alert();
 		
 		var deliveryCode = del.value;
 		var index;
 		
 		
 		
 		for(var count in list){
 			if(list[count].deliveryCode == deliveryCode){
 				index == count;
 			}
 		document.getElementByID("deliveryCode").value = list[index].deliveryCode;
 		document.getElementByID("deliveryName").value = list[index].deliveryName;
 		document.getElementByID("deliveryKana").value = list[index].deliveryKana;
 		document.getElementByID("delOfficeName").value = list[index].delOfficeName;
 		document.getElementByID("delOfficeKana").value = list[index].delOfficeKana;
 		document.getElementByID("delDeptName").value = list[index].delDeptName;
 		document.getElementByID("delZipCode").value = list[index].delZipCode;
 		document.getElementByID("delAddress1").value = list[index].delAddress1;
 		document.getElementByID("delAddress2").value = list[index].delAddress2;
 		document.getElementByID("delPCName").value = list[index].delPCName;
 		document.getElementByID("delPCNameKana").value = list[index].delPCNameKana;
 		document.getElementByID("delPCPreCategory").value = list[index].delPCPreCategory;
 		document.getElementByID("delTel").value = list[index].delTel;
 		document.getElementByID("delFax").value = list[index].delFax;
 		document.getElementByID("delEmail").value = list[index].delEmail;
 		}

 	} */	
	
	function doSubmit(){
		var form = document.mainform;
		form.submit();
	}
 	
 	

</script>
<script>
$(document).ready(function() {

    $('select[id="PCPreCategory"]').find('option[value="${customer.PCPreCategory}"]').attr("selected",true);
    $('select[id="rankCategory"]').find('option[value="${customer.rankCategory}"]').attr("selected",true);
    $('select[id="ROCategory"]').find('option[value="${customer.ROCategory}"]').attr("selected",true);
    $('select[id="businessCategory"]').find('option[value="${customer.businessCategory}"]').attr("selected",true);
    $('select[id="jobCategory"]').find('option[value="${customer.jobCategory}"]').attr("selected",true);
    $('select[id="fractCategory"]').find('option[value="${customer.fractCategory}"]').attr("selected",true);
    $('select[id="shiftCategory"]').find('option[value="${customer.shiftCategory}"]').attr("selected",true);
    $('select[id="salesCMCategory"]').find('option[value="${customer.salesCMCategory}"]').attr("selected",true);
    $('select[id="cutoffGroup"]').find('option[value="${customer.cutoffGroup}"]').attr("selected",true);
    $('select[id="paybackTypeCategory"]').find('option[value="${customer.paybackTypeCategory}"]').attr("selected",true);
    $('select[id="billPrintUnit"]').find('option[value="${customer.billPrintUnit}"]').attr("selected",true);
    $('select[id="billDatePrint"]').find('option[value="${customer.billDatePrint}"]').attr("selected",true);
    $('select[id="delPCPreCategory"]').find('option[value="${deliveryList.get(0).PCPreCategory}"]').attr("selected",true);
    $('select[id="delPCPreCategory2"]').find('option[value="${delivery2.PCPreCategory}"]').attr("selected",true);
    
});
</script>

	</body>
</html>
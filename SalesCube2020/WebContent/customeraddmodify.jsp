<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
      <a class="navbar-brand" href="#">SalesCube2020</a>
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
              <a class="dropdown-item" href="#">商品</a>
              <a class="dropdown-item" href="#">セット商品</a>
              <a class="dropdown-item" href="#">顧客</a>
            </div>
          </li>
        </ul>
        <span class="navbar-text">
          <svg class="bi bi-person-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
          </svg>
          システム管理者　
        </span>
        <form class="form-inline">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
	</nav>
	<br>
    <div class="container" id="main_function">
      <h3 class="float-left">顧客</h3>
   <script>
   
   </script>
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
         <form action="/SalesCube2020/SalesCube?action=moveAddCustomer">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F1<br>初期化</button>
         </form>
         <form action="/SalesCube2020/SalesCube?action=customer">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F2<br>戻る</button>
         </form>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F3<br>登録</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F4<br>削除</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F5<br>初期値</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F6<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F7<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F8<br>履歴出力</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F9<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F10<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F11<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;">F12<br></button>
        </div>
      </div>
      
      <br><br><br>
      </div>
<!-- 顧客情報 -->
      <div class="container" style="background-color: white;"><div class="panel panel-default" >
        <div class="panel-heading row mb-2 col-4">
            <h5><br>顧客情報</h5>
        </div>
        <hr>
        <div class="panel-body">
<form action="" method="post">
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">productCode</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客コード</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="productCode" onchange="checkCusotomerCode(this)">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">productName</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客名</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="productName">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">productKana</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客カナ</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="productKana">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">officeName</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">事業所名</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="officeName">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">officeNameKana</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">事業所カナ</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="officeNameKana">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">customerAbbr</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">顧客略称</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">                       
                        <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">zipAddress1</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">住所1</div>
                            </div>
                            <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">zipAddress2</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">住所2</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">PCNameKana</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">担当者カナ</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">PCPreCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">敬称</div>
                            </div>
                            <select class="custom-select" name="PCPreCategory" name="">
                            	<option value="null"></option>
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">PCPost</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">役職</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">fax</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">FAX</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">rankCategory</label>
                        <div class="input-group mb-2 form-inline">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客ランク</div>
								<select class="custom-select" name="rankCategory" name="">
									<option selected></option>
									<c:forEach items="${rank}" var="rank">
										<option value="${rank.rankName}">${rank.rankName}</option>
									</c:forEach>
								</select>
                        &emsp;<label><input type="checkbox" name="updateFlag" value="1" >&ensp;顧客ランク適用</label>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">ROCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">受注停止</div>
                            </div>
                            <select class="custom-select" name="">
                                
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">maxCreditLimit</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">与信限度額</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">jobCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">職種</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">""</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">fractCategory</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">shiftCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">税転嫁</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">lastCutoffDate</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">最終締処理日</div>
                            </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">salesCMCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">取引区分</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">cutoffGroup</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">支払い条件</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">paybackTypeCategory</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">回収方法</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">billPrintUnit</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">請求書発行単位</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <label class="sr-only" for="inlineFormInputGroup">billDatePrint</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="background-color: pink;">請求書日付有無</div>
                            </div>
                            <select class="custom-select" name="">
                                <option selected></option>
                                <c:forEach items="${}" value="">
                                    <option value="${}">${}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3 form-inline">
                        <label class="sr-only" for="inlineFormInputGroup">tempDeliverySlipFlag</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">仮納品書出力負荷</div>
                            </div>
                        &emsp;<label><input type="checkbox" name="" value="1"></label>
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                        </div>
                    </div>
                </div>   
            </div>
            
        
    </div><br></div><br>
    
<!-- 納入先情報 -->
<div class="container" style="background-color: white;"><div class="panel panel-default" >
    <div class="panel-heading row mb-2 col-4 form-inline">
        <h5><br>納入先情報</h5>
    </div>
    <hr>
    <div class="panel-body">
        <form action="" method="post">
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productCode</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">納入先</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <button type="button" class="btn btn-outline-secondary btn-sm">追加</button>&emsp;
                <button type="button" class="btn btn-outline-secondary btn-sm">削除</button>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productName</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">納入先名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productKana</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">納入先名カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">supplierCode</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">supplierName</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productName</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">部署名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">                       
                    <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">住所1</div>
                        </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">setTypeCategory</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">住所2</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">担当者カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
            
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">""</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">敬称</div>
                        </div>
                        <select class="custom-select" name="">
                            <option selected></option>
                            <c:forEach items="${}" value="">
                                <option value="${}">${}</option>
                            </c:forEach>
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-3">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">FAX</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
            </div>            
        
        </form>    
    </div>
        
    
</div><br></div><br>

<!-- 請求先情報 -->
<div class="container" style="background-color: white;"><div class="panel panel-default" >
    <div class="panel-heading row mb-2 col-4">
        <h5><br>請求先情報</h5>
    </div>
    <hr>
    <div class="panel-body">
        <form action="" method="post">
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productName</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">請求先名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productKana</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">請求先名カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">supplierCode</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">supplierName</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">事業所カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productName</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">部署名</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">                       
                    <input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text" style="background-color: pink;">住所1</div>
                        </div>
                        <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">setTypeCategory</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">住所2</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup">
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">担当者カナ</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
            
                <div class="col-4">
                    <label class="sr-only" for="inlineFormInputGroup">""</label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">敬称</div>
                        </div>
                        <select class="custom-select" name="">
                            <option selected></option>
                            <c:forEach items="${}" value="">
                                <option value="${}">${}</option>
                            </c:forEach>
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
                <div class="col-3">
                    <label class="sr-only" for="inlineFormInputGroup"></label>
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">FAX</div>
                        </div>
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
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
                    <input type="text"  class="form-control" id="inlineFormInputGroup" name="">
                    </div>
                </div>
            </div>            
        
        </form>    
    </div>
        
    
</div><br></div><br>

<!-- ボタン -->
<div align="right" class="container">
    <input type="button" value="初期化" class="btn btn-outline-secondary">
    <input type="submit" value="更新" class="btn btn-outline-secondary">
    <input type="submit" value="削除" class="btn btn-outline-secondary">
</div>

<br><br>    


<script>



</script>
	
	</body>
</html>
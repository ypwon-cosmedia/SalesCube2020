<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>SalesCube 商品マスタ管理(登録・編集)</title>
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
	<br><br>
	<div class="container" id="main_function">
		<h3 class="float-left">商品</h3>
	 
		
		<div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
		  
		  <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm()" >F1<br>初期化</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="backForm()">F2<br>戻る</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="registrationForm()" >F3<br>${status eq 'add' ? "登録" : "更新"}</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick= "deleteForm()" ${status eq 'add' ? "disabled" :''}>F4 <br>削除</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;">F5<br>初期値</button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F6<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F7<br></button>
			<form action="/SalesCube2020/SalesCube? action=producthistoryoutput">
				<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick= "productHistoryOutPut()" ${status eq 'add' ? "disabled" :''}>F8<br>履歴出力</button>
			</form>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F9<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F10<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F11<br></button>
			<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F12<br></button>
		  </div>
		</div>
		<br><br><br>
		</div>
	<br>
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<div class="panel-heading row mb-2 col-4">
				<h5><br>商品情報</h5>
			</div>
			<hr>
			<div class="panel-body">
				<form action=/SalesCube2020/productSearch.jsp"  method="post">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productCode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text" style = "background-color: pink;">商品コード※</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
				
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productName</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text" style = "background-color: pink;">商品名※</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productKana</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">商品カナ</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">productPcode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">オンライン品番</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>

						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">janPcode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">JANコード</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">discardDate</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">廃番予定日</div>
								</div>
							<input type="date">
							</div>
						</div>
					</div>
				
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierCode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入先コード</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierName</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入先名</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierPcode</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入先品番</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierPriceYen</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text" style = "background-color: pink;">仕入れ単価(円)※</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">supplierPriceDol</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">仕入単価(外貨)</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">stockCtlCategory</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">在庫管理</div>
								</div>
							<select class="custom-select" name="stockCtlCategory">
								<option selected></option>
								<option value="0" selected="selected">しない</option>
								<option value="1">する</option>
							</select>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">packQuantity</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">入数</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">avgShipCount</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">月平均出荷数</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">warehouseName</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">倉庫名</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">rackName</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">棚番</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">leadTime</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">リードタイム</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">日
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">poNum</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">発注点</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">mineSafetvStock</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">安全在庫数</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">poLot</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">発注ロット</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">maxStockNum</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">最大保有数</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">maxPoNum</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">単位発注限度数</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">roMaxNum</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">受注限度数</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">salesPrice</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">売単価</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">quantityDiscount</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">数量割引</div>
								</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup">
							<input type="image" name="" src="btn_search.png" tabindex="101" onclick="" style="vertical-align: middle; cursor: pointer; width: 32px;">
							</div>
						</div>
					</div>
				
			</div>
		</div><br></div>
			<br><br>
		
			<div class="container" style="background-color: white;"><div class="panel panel-default" >
				<div class="panel-heading row mb-2 col-4">
					<h5><br>分類</h5>
				</div>
				<hr>
				<div class="panel-body">
					
						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">productStatusCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">状況</div>
									</div>
								<select class="custom-select" name="productStatusCategory">
									<option selected></option>
									<option value="1" selected="selected">販売中</option>
									<option value="2">販売中止</option>
									<option value="3">準備中</option>
								</select>
								</div>
							</div>
							<div class="col-4">	
								<label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">保管</div>
									</div>
								<select class="custom-select" name="productStockCategory">
									<option selected></option>
									<option value="1" selected="selected">自社在庫品</option>
									<option value="2">他社在庫品</option>
									<option value="3">取り寄せ品</option>
								</select>
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">productPurvayCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">調達</div>
									</div>
								<select class="custom-select" name="productPurvayCategory">
									<option selected></option>
									<option value="1" selected="selected">国内調達</option>
									<option value="2">海外調達</option>
								</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">productStandardCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">標準化</div>
									</div>
								<select class="custom-select" name="productStandardCategory">
									<option selected></option>
									<option value="0" selected="selected">標準品</option>
									<option value="1">特注品</option>
								</select>
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">soRate</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">特注計算掛率</div>
									</div>
								<input type="text"  class="form-control" id="inlineFormInputGroup">
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">setTypeCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">セット</div>
									</div>
								<select class="custom-select" name="setTypeCategory">
									<option selected></option>
									<option value="0" selected="selected">単品</option>
									<option value="1">セット品</option>
								</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-6">
								<label class="sr-only" for="inlineFormInputGroup">product1</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">カテゴリ（大）</div>
									</div>
									<select class="custom-select" name="product1">
										<option selected></option>
										<option value="1">食品</option>
										<option value="10">本</option>
										<option value="100">家</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-6">
								<label class="sr-only" for="inlineFormInputGroup">product2</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">カテゴリ（中）</div>
									</div>
									<select class="custom-select" name="product2">
										<option selected></option>
										
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-6">
								<label class="sr-only" for="inlineFormInputGroup">product3</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">カテゴリ（小）</div>
									</div>
									<select class="custom-select" name="product3">
										<option selected></option>
										
									</select>
								</div>
							</div>
						</div>
				</div>
			</div><br></div><br><br>
			<div class="container" style="background-color: white;"><div class="panel panel-default" >
				<div class="panel-heading row mb-2 col-4">
					<h5><br>特注分類</h5>
				</div>
				<hr>
				<div class="panel-body">
						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">unitCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">単位</div>
									</div>
								<select class="custom-select" name="unitCategory">
									<option selected></option>
									<option value="1">本</option>
									<option value="2">個</option>
									<option value="3" selected="selected">箱</option>
								</select>
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup"></label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">重量</div>
									</div>
								<input type="text"  class="form-control" id="inlineFormInputGroup">
								<select class="custom-select" name="wightCategory">
									<option selected></option>
									<option value="1">mg</option>
									<option value="2">g</option>
									<option value="3">kg</option>
									<option value="4">t</option>
								</select>
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">lengthUnitSizeCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">長さ</div>
									</div>
								<input type="text"  class="form-control" id="inlineFormInputGroup">
								<select class="custom-select" name="lengthUnitSizeCategory">
									<option selected></option>
									<option value="1">mm</option>
									<option value="2">cm</option>
									<option value="3">m</option>
								</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">widthUnitSizeCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">サイズ(幅)</div>
									</div>
								<input type="text"  class="form-control" id="inlineFormInputGroup">
								<select class="custom-select" name="widthUnitSizeCategory">
									<option selected></option>
									<option value="1">mm</option>
									<option value="2">cm</option>
									<option value="3">m</option>
								</select>
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">depthUnitSizeCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">サイズ(奥)</div>
									</div>
									<input type="text"  class="form-control" id="inlineFormInputGroup">
								<select class="custom-select" name="depthUnitSizeCategory">
									<option selected></option>
									<option value="1">mm</option>
									<option value="2">cm</option>
									<option value="3">m</option>
								</select>
								</div>
							</div>
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">heightUnitSizeCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">サイズ(高)</div>
									</div>
									<input type="text"  class="form-control" id="inlineFormInputGroup">
								<select class="custom-select" name="heightUnitSizeCategory">
									<option selected></option>
									<option value="1">mm</option>
									<option value="2">cm</option>
									<option value="3">m</option>
								</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">coreNum</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">芯数</div>
									</div>
									<input type="text"  class="form-control" id="inlineFormInputGroup">
								</div>
							</div>
						</div>	
				</div>
			</div><br></div>
			<br><br>
			<div class="container panel panel-default" style="background-color: white;">
				<div class="panel-heading row mb-2 col-4">
					<h5><br>備考欄</h5>
				</div>
				<hr>
	
				<div class="panel-body">
						<div class="row">
							<div class="col-8">
								<div class="input-group-prepend">
									<div class="input-group-text">備考</div>
									<textarea id="textarea1" class="form-control"></textarea>
								</div>
							</div>
						</div><br>
						<div class="row">
							<div class="col-8">
								<div class="input-group-prepend">
									<div class="input-group-text">ピッキング備考</div>
									<textarea id="textarea1" class="form-control"></textarea>
								</div>
							</div>
						</div><br>
						<div class="row">
							<div class="col-8">
								<div class="input-group-prepend">
									<div class="input-group-text">コメント</div>
									<textarea id="textarea1" class="form-control"></textarea>
								</div>
							</div>
						</div>
			</form>
				</div><br><br>
				
			</div>
			<br><br>
			<div align="right">
				<input type="submit"  value="初期化" class="btn btn-outline-secondary" onclick="initForm()" >&emsp;
				<input type="submit" value="登録" class="btn btn-outline-secondary" onclick="registrationForm()">&emsp;
				<input type="submit" value="削除" class="btn btn-outline-secondary" onclick= "deleteForm()">&emsp;
			</div>
			<br> 
			
		<script>
        	function initForm() {
    	   		if(!confirm("入力内容を初期化してよろしいですか？")){
           	   		return;
    	  		}
        		window.location.href = '/SalesCube2020/productaddmodify.jsp';
        	}
    	
    		function backForm() {
    			if(!confirm("商品検索画面に戻ります。よろしいですか？")) {
    				return;
    			}
    			window.location.href = '/SalesCube2020/productsearch.jsp';
    		}
    		
    		function registrationForm() {
    			if(!confirm("入力内容を登録します。よろしいですか？")) {
    				return;
    			}
    			
    		}
    		
    		function deleteForm() {
    			if(!confirm("このデータを削除しますか？")) {
    				return;
    			}
    			
    		}
    		
    		function productHistoryOutPut() {
    			if(!confirm("履歴をExcel出力しますか？")) {
    				return;
    			}
    			
    		}
    	</script>
	</body>
</html>
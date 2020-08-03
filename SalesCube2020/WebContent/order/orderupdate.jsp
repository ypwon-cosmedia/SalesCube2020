<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

		<title>受注編集</title>
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
			.table {
				text-align: center;
			}
		</style>
	</head>

	<body style="background-color: gainsboro;">
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<%@ include file= "../common/menubar.jsp" %>
		<br><br>

		<div class="container" id="main_function">
			<h3 class="float-left">受注編集</h3>
			<!-- FNキー -->
			<div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">  
				<div class="btn-group mr-2 " role="group" aria-label="First group">
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm();" >F1<br>初期化</button>
					<form>
						<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="deleteForm();">F2<br>削除</button>
					</form>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="returnForm();">F3<br>戻る</button>
					<form>
						<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="updateForm();">F4<br>更新</button>
					</form>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F5<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" data-toggle="modal" data-target="#openOrder">F6<br>伝票呼出</button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F7<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F8<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F9<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F10<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F11<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F12<br></button>
				</div>
			</div><br><br><br>
		</div><br>

		<form="" method="post">
			<!-- 受注伝票情報 -->
			<div class="container" style="background-color: white;"><div class="panel panel-default">
				<div class="panel-heading row mb-2 col-4">
					<h5><br>受注伝票情報</h5>
				</div>
				<hr>
				<div class="panel-body">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">受注番号</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">受注番号</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">受注日</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text" style = "background-color: pink;">受注日※</div>
								</div>
								<input type="date" value=""  class="form-control" required>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">出荷日</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">出荷日</div>
								</div>
								<input type="date" value=""  class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">納期指定日</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">納期指定日</div>
								</div>
								<input type="date" value=""  class="form-control">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">受付番号</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">受付番号</div>
								</div>
								<input type="text" value=""  class="form-control">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">客先伝票番号</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">客先伝票番号</div>
								</div>
								<input type="text" value=""  class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">入力担当</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">入力担当者</div>
								</div>
								<input type="text" value=""  class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">摘要</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">摘要</div>
								</div>
								<input type="text" value=""  class="form-control">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">配送業者</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">配送業者</div>
								</div>
								<select class="custom-select" name="">
									<option value=""></option>
									<c:forEach items="${}" var="">
										<option value="${}">${}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">配送時間帯</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">配送時間帯</div>
								</div>
								<select class="custom-select" name="">
									<option value=""></option>
									<c:forEach items="${}" var="">
										<option value="${}">${}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">消費税率</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">消費税率</div>
								</div>
								<select class="custom-select" name="">
									<option value=""></option>
									<c:forEach items="${}" var="">
										<option value="10.00" id="ctaxRate">${}</option>%
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</div><br>
			</div></div><br><br>

			<!-- 顧客情報 -->
			<div class="container" style="background-color: white;"><div class="panel panel-default">
				<div class="panel-heading row mb-2 col-4">
					<h5><br>顧客情報</h5>
				</div>
				<hr>
				<div class="panel-body">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">顧客コード</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text" style = "background-color: pink;">顧客コード</div>
								</div>
								<input type="text" value="" class="form-control" id="customerCodeInput" required>
								<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#customersearch" onclick="customerCodetoModal();">検索</button>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">顧客名</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客名</div>
								</div>
								<input type="text" value=""  class="form-control" id="customerNameInput" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">税転嫁</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">税転嫁</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">支払条件</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">支払条件</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">取引区分</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">取引区分</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">備考</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">備考</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">コメント</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">コメント</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
				</div><br>
			</div></div><br><br>

			<!-- 納入先情報 -->
			<div class="container" style="background-color: white;"><div class="panel panel-default">
				<div class="panel-heading row mb-2 col-4">
					<h5><br>納入先情報</h5>
				</div>
				<hr>
				<div class="panel-body">
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">顧客納入先</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客納入先</div>
								</div>
								<select class="custom-select" name="">
									<option value=""></option>
									<c:forEach items="" var="">
										<option value="">${}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">事務所名</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">事務所名</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">部署名</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">部署名</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">郵便番号</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">郵便番号</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">住所1</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">住所1</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">住所2</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">住所2</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">担当者</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">担当者</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">担当者カナ</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">担当者カナ</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">敬称</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">敬称</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">TEL</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">TEL</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">FAX</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">FAX</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">E-MAIL</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">E-MAIL</div>
								</div>
								<input type="text" value="" class="form-control" readonly>
							</div>
						</div>
					</div>
				</div><br>
			</div></div><br><br>
		</form>

		<!-- 受注明細テーブル -->
		<div class="container" style="background-color: rgb(255, 255, 255);">
			<div class="panel-heading row mb-2 col-4">
				<h5><br>受注明細</h5>
			</div>
			<hr>
			<table id="order" class="table table-bordered table-sm">
				<thead class="thead-dark">
					<tr>
						<th rowspan="6" class="align: middle">No</th>
						<th rowspan="6" class="align: middle">商品コード※</th>
						<th rowspan="3" class="align: middle">商品名</th>
						<th rowspan="3" class="align: middle">棚番</th>
						<th rowspan="3" class="align: middle">仕入単価※</th>
						<th rowspan="3" class="align: middle">売上単価※</th>
						<th rowspan="3" class="align: middle">備考</th>
						<th rowspan="6" class="align: middle">&nbsp;</th>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<th rowspan="3">商品備考</th>
						<th rowspan="3">数量※</th>
						<th rowspan="3">仕入金額※</th>
						<th rowspan="3">売価金額※</th>
						<th rowspan="3">ピッキング備考</th>
					</tr>
				</thead>
				<tbody id = "orderbody">
					<tr>
						<td rowspan="6"><span id="tableLineNo1">1</span></td>
						<td rowspan="6">
							<input type="text" value="" class="form-control" size="2" style="width:100%" id="productCodeInput1">
							<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" onclick="productCodetoModal(this);" id="setproductsearch1">検索</button>
						</td>
						<td rowspan="3"><span id="productName1"></span></td>
						<td rowspan="2">
							<input type="text" value="" class="form-control" size="2" id="rackCode1" readonly>
						</td>
						<td rowspan="3">
							<input type="text" value="" class="form-control" size="4" name="unitCost" id="unitCost1" readonly>
						</td>
						<td rowspan="3">
							<input type="text" value="" class="form-control" size="4" name="unitRetailPrice" id="unitRetailPrice1" onchange="quantityCalc2(this)">
						</td>
						<td rowspan="3">
							<textarea name="productRemarks" class="form-control" cols="10" id="inputProductRemarks1"></textarea>
						</td>
						<td rowspan="3" class="align: middle">
							<button type="button" class="btn btn-outline-secondary" onclick="deleteLineForm(this);" id="deleteLineForm1">削除</button>
						</td>
					</tr>
					<tr></tr>
					<tr>
						<td rowspan="2">
							<input type="text" value="" class="form-control" size="2" name="quantity" id="quantity1" onchange="quantityCalc1(this)">
						</td>
					</tr>
					<tr>
						<td rowspan="3">
							<textarea name="productRemarks" class="form-control" cols="10" id="productRemarks1" readonly></textarea>
						</td>
						<td rowspan="3">
							<input type="text" value="" class="form-control" size="4" name="cost" id="cost1" readonly>
						</td>
						<td rowspan="3">
							<input type="text" value="" class="form-control" size="4" name="retailPrice" id="retailPrice1" readonly>
						</td>
						<td rowspan="3">
							<textarea name="eadRemarks" class="form-control" cols="10" id="eadRemarks1"></textarea>
						</td>
						<td rowspan="3">
							<button type="button" value="" class="btn btn-outline-secondary" id="reprintForm" disabled>前行複写</button>
						</td>
					</tr>
					<tr>
						<td rowspan="2">
							<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchStock" id="openSearchStock1">在庫</button>
						</td>
					</tr>
					<tr></tr>
				</tbody>
			</table>

			<!-- 行追加 -->
			<table align="center">
				<tr>
					<td>
							<button type="button" class="btn btn-outline-secondary" onclick="addLineForm();" id="addLine">行追加</button>
					</td>
				</tr>
			</table>
			<br>
		</div>
		<br>

		<!-- 伝票計算 -->
		<div class="container" style="background-color: rgb(255, 255, 255);">
			<div class="panel-heading row mb-2 col-4">
				<h5><br>伝票計算</h5>
			</div>
			<hr>
			<table id="money_info" class="table table-bordered table-sm">
				<thead class="thead-dark">
					<tr>
						<th>粗利益</th>
						<th>粗利益率</th>
						<th>金額合計</th>
						<th>消費税</th>
						<th>伝票合計</th>
					</tr>
				</thead>
				<tbody>
					<td id="grossProfit">￥0</td>
					<td id="grossProfitRatio">0.00%</td>
					<td id="retailPriceTotal">￥0</td>
					<td id="ctaxPriceTotal">￥0</td>
					<td id="priceTotal">￥0</td>
				</tbody>
			</table>
			<br>
		</div>
		<br>

		<!-- 更新ボタン -->
		<div align="center">
			<form action="" method="post">
				<input type="submit" class="btn btn-outline-secondary w-auto" value="更新" onclick="updateForm();">
			</form>
		</div><br>

		<!-- Modal伝票呼出 -->
		<div class="modal fade" id="openOrder" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="label1">伝票呼出</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					<div class="modal-body">			
						見積伝票検索
						<form>
							<div class="row">
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup">UserId</label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">見積番号</div>
										</div>
										<input type="text"  class="form-control" id="inputEstimateSheetId">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">見積日</div>
										</div>
									<input type="date"  class="form-control" id="inputEstimateDate1" name="data1">
									</div>
								</div>
								~
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
			
									<input type="date"  class="form-control" id="inputEstimateDate2" name="data1">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-4">
									<label class="sr-only" for="inlineFormI4putGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											   <div class="input-group-text">提出先名</div>
										</div>
										<input type="text" class="form-control" id="inputSubmitName" name="data1">
									</div>
								</div>
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">件名</div>
										</div>
										<input type="text"  class="form-control" id="inputTitle" name="data1">
									</div>
								</div>                   
							</div>
							<div class="float-left" style="position:static; left: 0px;">検索結果件数：0件</div>
							<div align="right">
								<button type="button" class="btn btn-outline-secondary" onclick="initFormOrder();">初期化</button>&ensp;
								<input type="button" value="検索" class="btn btn-outline-secondary">
							</div>
						</form>
						<br>
						<table id="order_detail_info" class="table table-bordered">
							<thead class="thead-dark">
							  <tr>
								<th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productCode');">見積番号</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productName');">見積日</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">提出先名</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">件名</th>
								
							  </tr>
							</thead>
							<c:forEach items="${}" var="">
								<tr>
									<td style="white-space: normal; text-align: left;" data-dismiss="modal" id="estimateSheetId"><a href="orderinput.html">見積番号1</a></td>
									<td style="white-space: normal; text-align: left;" id="estimateDate">見積日1</td>
									<td style="white-space: normal; text-align: left;" id="submitName">提出先名1</td>
									<td style="white-space: normal; text-align: left;" id="title">件名1</td>
								</tr>
								<tr>
									<td style="white-space: normal; text-align: left;">見積番号2</td>
									<td style="white-space: normal; text-align: left;">見積日2</td>
									<td style="white-space: normal; text-align: left;">提出先名2</td>
									<td style="white-space: normal; text-align: left;">件名2</td>
		
								</tr>
								<tr>
									<td style="white-space: normal; text-align: left;">見積番号3</td>
									<td style="white-space: normal; text-align: left;">見積日3</td>
									<td style="white-space: normal; text-align: left;">提出先名3</td>
									<td style="white-space: normal; text-align: left;">件名3</td>
								</tr>
							</c:forEach>
						</table>
						<br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<!-- modal page (customersearch)-->
		<div class="modal fade" id="customersearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					
					<div class="modal-header">
						<h5 class="modal-title" id="label1">顧客検索</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					
					<form action="" method="post">
						<div class="modal-body">
						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="modalCustomerCodeFor">UserId</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">顧客コード</div>
									</div>
									<input type="text"  class="form-control" id="inputCustomerCode">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">UserName</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">顧客名</div>
									</div>
									<input type="text"  class="form-control" id="inputCustomerName">
								</div>
							</div>
						
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">UserKana</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">顧客名カナ</div>
									</div>
									<input type="text"  class="form-control" id="inputCustomerNameKana">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">productStatusCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">顧客ランク</div>
									</div>
									<select class="custom-select" name="productStatusCategory" id="initCustomerRank">
										<option selected></option>
										<c:forEach items="${}" value="">
											<option value="${}">${}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="col-5">
							<label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">支払条件</div>
									</div>
									<select class="custom-select" name="productStockCategory" id="inputCutoffGroup">
										<option selected></option>
										<c:forEach items="${}" value="">
											<option value="${}">${}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						</div>
						<br>

						<div class="rounded float-right">
							<button type="button" class="btn btn-outline-secondary" onclick="initFormCustomer();">初期化</button>&ensp;
							<input type="submit" value="検索" class="btn btn-outline-secondary">&ensp;
						</div><br>
					</form><br>

					<div class="modal-body">
						<div class="float-left" style="position:static; left: 0px;">
							検索結果件数：3件
						</div>
					</div>

					<div class="modal-body" style="background-color: rgb(255, 255, 255);">
						<table id="order_detail_info" class="table table-bordered">
							<thead class="thead-dark">
								<tr>
								<th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productCode');">顧客コード</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productName');">顧客名</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">TEL</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">担当者</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">取引区分</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">支払条件</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">事務所名</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">部署名</th>
								
								</tr>
							</thead>
							<c:forEach items="${}" var="">
								<tr>
									<td style="white-space: normal; text-align: left;" onclick="selectCustomerCode();" data-dismiss="modal" id="modalCustomerCode"><a href="">顧客コード1</a></td>
									<td style="white-space: normal; text-align: left;" onclick="selectCustomerCode();" data-dismiss="modal" id="modalCustomerName"><a href="">顧客名1</a></td>
									<td style="white-space: normal; text-align: left;" id="modalCustomerTEL">TEL1</td>
									<td style="white-space: normal; text-align: left;" id="modalCustomerPCName">担当者1</td>
									<td style="white-space: normal; text-align: left;" id="modalSalesCmCategory">取引区分1</td>
									<td style="white-space: normal; text-align: left;" id="modalCutoffGroup">支払条件1</td>
									<td style="white-space: normal; text-align: left;" id="modalCustomerOfficeName">事務所名1</td>
									<td style="white-space: normal; text-align: left;" id="modalCustomerDeftName">部署名1</td>
								</tr>
								<tr>
									<td style="white-space: normal; text-align: left;">顧客コード2</td>
									<td style="white-space: normal; text-align: left;">顧客名2</td>
									<td style="white-space: normal; text-align: left;">TEL2</td>
									<td style="white-space: normal; text-align: left;">担当者2</td>
									<td style="white-space: normal; text-align: left;">取引区分2</td>
									<td style="white-space: normal; text-align: left;">支払条件2</td>
									<td style="white-space: normal; text-align: left;">事務所名2</td>
									<td style="white-space: normal; text-align: left;">部署名2</td>
								</tr>
								<tr>
									<td style="white-space: normal; text-align: left;">顧客コード3</td>
									<td style="white-space: normal; text-align: left;">顧客名3</td>
									<td style="white-space: normal; text-align: left;">TEL3</td>
									<td style="white-space: normal; text-align: left;">担当者3</td>
									<td style="white-space: normal; text-align: left;">取引区分3</td>
									<td style="white-space: normal; text-align: left;">支払条件3</td>
									<td style="white-space: normal; text-align: left;">事務所名3</td>
									<td style="white-space: normal; text-align: left;">部署名3</td>
								</tr>
							</c:forEach>
						</table>
						<br>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- modal page (productsearch)-->
		<div class="modal fade" id="setproductsearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					
					<div class="modal-header">
						<h5 class="modal-title" id="label1">商品検索</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					
					<form action="" method="post">
						<div class="modal-body">
							<div class="row">
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">商品コード</div>
										</div>
										<input type="text" value="" class="form-control" id="inputProductCode">
									</div>
								</div>
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">仕入先商品コード</div>
										</div>
										<input type="text"  class="form-control" id="inputSupplierCode">
									</div>
								</div>
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">JANコード</div>
										</div>
										<input type="text"  class="form-control" id="inputJANPCode">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">セット分類</div>
										</div>
										<select class="custom-select" name="SetTypeCategory" id="inputSetTypeCategory">
											<option selected></option>
											<c:forEach items="${}" value="">
												<option value="${}">${}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="col-4">
								<label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
									<div class="input-group mb-2">
										<div class="input-group-prepend">
											<div class="input-group-text">標準化分類</div>
										</div>
										<select class="custom-select" name="ProductStandardCategory" id="inputProductStandardCategory">
											<option selected></option>
											<c:forEach items="${}" value="">
												<option value="${}">${}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="col-4">
									<label class="sr-only" for="inlineFormInputGroup"></label>
									<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">分類状況</div>
									</div>
									<input type="text"  class="form-control" id="inputProductStatusCategory">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-6">
								<label class="sr-only" for="inlineFormInputGroup"></label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">商品名</div>
									</div>
									<input type="text"  class="form-control" id="inputProductName">
								</div>
								</div>
								<div class="col-6">
								<label class="sr-only" for="inlineFormInputGroup"></label>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">商品名カナ</div>
									</div>
									<input type="text"  class="form-control" id="inputProductNameKana">
								</div>
								</div>
							</div>
						</div>
						<br>

						<div class="rounded float-right">
						<button type="button" class="btn btn-outline-secondary" onclick="initFormProductSearch();">初期化</button>&ensp;
						<input type="submit" value="検索" class="btn btn-outline-secondary">&ensp;
						</div>
					</form>

					<div class="modal-body">
						<div class="float-left" style="position:static; left: 0px;">
						検索結果件数：3件
						</div>
					</div>

					<div class="modal-body" style="background-color: rgb(255, 255, 255);">
						<table id="order_detail_info" class="table table-bordered">
						<thead class="thead-dark">
							<tr>
								<th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productCode');">商品コード</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('productName');">商品名</th>
								<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;" onclick="sort('supplierName');">仕入先名</th> 
							</tr>
						</thead>
						<c:forEach items="${}" var="">
							<tr>
								<td style="white-space: normal; text-align: left;" onclick="selectProductCode(this)" data-dismiss="modal" id="modalProductCode1"><a href="">商品コード1</a></td>
								<td style="white-space: normal; text-align: left;" onclick="selectProductCode(this)" data-dismiss="modal" id="modalProductName1"><a href="">商品名1</a></td>
								<td style="white-space: normal; text-align: left;" id="ModalSupplierName">仕入先名1</td>
							</tr>
							<tr>
								<td style="white-space: normal; text-align: left;">商品コード2</td>
								<td style="white-space: normal; text-align: left;">商品名2</td>
								<td style="white-space: normal; text-align: left;">仕入先名2</td>
							</tr>
							<tr>
								<td style="white-space: normal; text-align: left;">商品コード3</td>
								<td style="white-space: normal; text-align: left;">商品名3</td>
								<td style="white-space: normal; text-align: left;">仕入先名3</td>
							</tr>
						</c:forEach>
						</table>
						<br>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- modal page (suppliersearch)-->
		<div class="modal fade" id="openSearchSupplier" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="label1">仕入先検索</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<!-- 検索部 -->
						<div class="row">
							<div class="col-5">
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">仕入先コード</div>
									</div>
									<input type="text" class="form-control" id="">
								</div>
							</div>
						</div>
							
						<div class="row">
							<div class="col-5">
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">仕入先名</div>
									</div>
									<input type="text"  class="form-control" id="">
								</div>
							</div>
							<div class="col-6">
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">仕入先カナ</div>
									</div>
									<input type="text"  class="form-control" id="">
								</div>
							</div>
						</div>
							
						<div class="row float-right">
							<button class="btn btn-secondary">初期化</button>&emsp;
							<button class="btn btn-secondary">検索</button>&emsp;
						</div>
						<br><br>
						<!-- テーブル部（検索結果） -->
						検索結果件数：2件<br>

						<table class="table table-bordered">
							<!-- ヘッダ部 -->
							<thead class="thead-dark">
								<tr>
									<th>仕入先コード</th>
									<th>仕入先名</th>
									<th>担当者</th>
									<th>取引区分</th>
									<th>備考</th>
								</tr>
							</thead>
							<!-- 内部 -->
							<tr>
								<td class="cursor-pointer" id="supplierCode1" onclick="selectSupplierCode()" data-dismiss="modal"><a href="">1</a></td>
								<td id="supplierName1" onclick="selectSupplierCode()" data-dismiss="modal"><a href="">アンパンマン食品</a></td>
								<td>ジャムおじさん</td>
								<td>現金</td>
								<td>アンパンマンのことならお任せしたかったよ</td>
							</tr>
							<tr>
								<td class="cursor-pointer">10</td>
								<td>とことこ寝具</td>
								<td>寝巻</td>
								<td>サンプル</td>
								<td>ふかふかお布団</td>
							</tr>
						</table>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>

		<!-- modal page (stocksearch)-->
		<div class="modal fade" id="openSearchStock" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="label1">商品在庫情報</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">			
						<table class="table table-bordered">
							<tr>
								<th bgcolor="black"><font color="white" id="productCode">商品コード</font></th>
								<td>テストコード</td>
								<th bgcolor="black"><font color="white" id="productPCode">仕入先商品コード</font></th>
								<td>テストコード</td>
								<th bgcolor="black"><font color="white" id="setTypeCategory">セット分類</font></th>
								<td>テスト分類</td>
							</tr>
							<tr>
								<th bgcolor="black"><font color="white" id="productName">商品名</font></th>
								<td>テスト名</td>
								<th bgcolor="black"><font color="white" id="warehouseName">倉庫名</font></th>
								<td>テスト名</td>
								<th bgcolor="black"><font color="white" id="rackCode">棚番</font></th>
								<td>テスト棚番</td>
							</tr>
							<tr>
								<th bgcolor="black"><font color="white" id="productStatusCategory">分類-状態</font></th>
								<td>テスト分類</td>
								<th bgcolor="black"><font color="white" id="productStockCategory">分類-保管</font></th>
								<td>テスト分類</td>
							</tr>
						</table>
						<br>           
						<table class="table table-bordered">
							<tr>
								<th bgcolor="black"><font color="white" id="stockQuantity">現在庫総数</font></th>
								<th bgcolor="black"><font color="white" id="quantitySum">受注残数</font></th>
							</tr>
							<tr>
								<td>123</td>
								<td>123</td>
							</tr>
						</table>       
						
								受注残明細
								<table class="table table-bordered">
									<tr>
										<th bgcolor="black"><font color="white">受注番号-行</font></th>
										<th bgcolor="black"><font color="white">出荷日</font></th>
										<th bgcolor="black"><font color="white">受注残数</font></th>
									</tr>
									<tr>
										<form action=" " method="post" id="stockTable">
											<td id="roSlipLine"><a href="orderupdate.html" id="roSlipLine">123</a></td>
										</form>
										<td id="shipDate">123</td>
										<td id="quantity">123</td>
									</tr>
									<tr>
										<td><a href="#">123</a></td>
										<td>123</td>
										<td>123</td>
									</tr>
									<tr>
										<td><a href="#">123</a></td>
										<td>123</td>
										<td>123</td>
									</tr>
									<tr>
										<td><a href="#">123</a></td>
										<td>123</td>
										<td>123</td>
									</tr>
									<tr>
										<td><a href="#">123</a></td>
										<td>123</td>
										<td>123</td>
									</tr>
								</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<script>
			var globalTmp;

			/* 受注編集の初期化 */
			function initForm() {
				if(!confirm("入力内容を初期化してよろしいですか？")){
					return;
				}
				location.reload();
			}

			/* 伝票呼出の初期化 */
			function initFormOrder(){
				if(!confirm("入力内容を初期化してよろしいですか？")){
					return;
				}
				target1 = document.getElementById("inputEstimateSheetId");
				target1.value = null;
				target2 = document.getElementById("inputEstimateDate1");
				target2.value = null;
				target3 = document.getElementById("inputEstimateDate2");
				target3.value = null;
				target4 = document.getElementById("inputSubmitName");
				target4.value = null;
				target5 = document.getElementById("inputTitle");
				target5.value = null;
			}

			/* 顧客検索の初期化 */
			function initFormCustomer(){
				if(!confirm("入力内容を初期化してよろしいですか？")){
					return;
				}
				target1 = document.getElementById("inputCustomerCode");
				target1.value = null;
				target2 = document.getElementById("inputCustomerName");
				target2.value = null;
				target3 = document.getElementById("inputCustomerNameKana");
				target3.value = null;
				target4 = document.getElementById("initCustomerRank");
				target4.value = null;
				target5 = document.getElementById("inputCutoffGroup");
				target5.value = null;
			}

			/* 商品検索の初期化 */
			function initFormProductSearch(){
				if(!confirm("入力内容を初期化してよろしいですか？")){
					return;
				}
				target1 = document.getElementById("inputProductCode");
				target1.value = null;
				target2 = document.getElementById("inputSupplierCode");
				target2.value = null;
				target3 = document.getElementById("inputJANPCode");
				target3.value = null;
				target4 = document.getElementById("inputSetTypeCategory");
				target4.value = null;
				target5 = document.getElementById("inputProductStandardCategory");
				target5.value = null;
				target6 = document.getElementById("inputProductStatusCategory");
				target6.value = null;
				target7 = document.getElementById("inputProductName");
				target7.value = null;
				target8 = document.getElementById("inputProductNameKana");
				target8.value = null;
			}

			/* 戻る */
			function returnForm(){
				if(!confirm("受注新規登録画面に戻ってよろしいですか？")){
					return;
				}
				window.location.href = "file:///C:/Users/cosmedia/Desktop/%E5%85%B1%E6%9C%89/LINE%20WORKS%20Drive/.%20Shared_folder/2020%E5%B9%B4%E5%85%B1%E6%9C%89fileserver/SalesCube/SalesCube/%E5%8F%97%E6%B3%A8/HTML/orderinput.html";
			}

			/* 登録 */
			function updateForm() {
				var test = confirm("入力内容を更新します。よろしいですか？");
				test;
				if(test == false){
					return;
				} /* else
				window.location.href = '/SalesCube2020/SalesCube?action=orderinput'; */
				location.reload();
			}
	
			/* 伝票呼出 */
			function orderForm() {
				var test = confirm("未登録の入力内容を破棄し伝票呼出してもよろしいですか？");
				test;
				if(test == false){
					return;
				}
			}
	
			/* データ削除 */
			function deleteForm() {
				if(!confirm("このデータを削除しますか？")) {
					return;
				}
				var form = document.deleteform;
				form.submit();
			}
	
			/* 前行複写 */
			function reprintForm(obj) {
				var tmp = obj.id;
				var tableNo = tmp.substr(11);
				/* 商品コード */
				var productCodeInput = document.getElementById("productCodeInput" + (tableNo - 1)).value;
				target = document.getElementById("productCodeInput" + tableNo);
				target.value = productCodeInput;
				/* 商品名 */
				var productName = document.getElementById("productName" + (tableNo - 1)).innerHTML;
				target = document.getElementById("productName" + tableNo);
				if(productName != null && productName != ""){
					target.innerHTML = productName;
				}else{
					target.innerHTML = null;
				}
				/* 棚番 */
				var rackCode = document.getElementById("rackCode" + (tableNo - 1)).value;
				target = document.getElementById("rackCode" + tableNo);
				target.value = rackCode;
				/* 仕入単価 */
				var unitCost = document.getElementById("unitCost" + (tableNo - 1)).value;
				target = document.getElementById("unitCost" + tableNo);
				target.value = unitCost;
				/* 売上単価 */
				var unitRetailPrice = document.getElementById("unitRetailPrice" + (tableNo - 1)).value;
				target = document.getElementById("unitRetailPrice" + tableNo);
				target.value = unitRetailPrice;
				/* 商品備考 */
				var inputProductRemarks = document.getElementById("inputProductRemarks" + (tableNo - 1)).value;
				target = document.getElementById("inputProductRemarks" + tableNo);
				target.value = inputProductRemarks;
				/* 数量 */
				var quantity = document.getElementById("quantity" + (tableNo - 1)).value;
				target = document.getElementById("quantity" + tableNo);
				target.value = quantity;
				/* 備考 */
				var productRemarks = document.getElementById("productRemarks" + (tableNo - 1)).value;
				target = document.getElementById("productRemarks" + tableNo);
				target.innerHTML = productRemarks;
				/* 仕入金額 */
				var cost = document.getElementById("cost" + (tableNo - 1)).value;
				target = document.getElementById("cost" + tableNo);
				target.value = cost;
				/* 売価金額 */
				var retailPrice = document.getElementById("retailPrice" + (tableNo - 1)).value;
				target = document.getElementById("retailPrice" + tableNo);
				target.value = retailPrice;
				/* ピッキング備考 */
				var eadRemarks = document.getElementById("eadRemarks" + (tableNo - 1)).value;
				target = document.getElementById("eadRemarks" + tableNo);
				target.value = eadRemarks;

				calc();
			}

			/* 行追加 */
			$('#addLine').click(function() {
				var tableNo = (($("#order tr").length-4)/6)+1
				$('#order > tbody:last').append('<tr>'
					+ '<td rowspan="6"><span id="tableLineNo' + tableNo + '">' + tableNo + '</span></td>'
					+ '<td rowspan="6">'
						+ '<input type="text" value="" class="form-control" size="2" style="width:100%" id="productCodeInput' + tableNo + '">'
						+ '<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" onclick="productCodetoModal(this);" id="setproductsearch' + tableNo + '">検索</button>'
					+ '</td>'
					+ '<td rowspan="3"><span id="productName' + tableNo + '"></span></td>'
					+ '<td rowspan="2"><input type="text" value="" class="form-control" size="2" id="rackCode' + tableNo + '" readonly></td>'
					+ '<td rowspan="3"><input type="text" value="" class="form-control" size="4" name="unitCost" id="unitCost' + tableNo + '" readonly></td>'
					+ '<td rowspan="3">'
						+ '<input type="text" value="" class="form-control" size="4" name="unitRetailPrice" id="unitRetailPrice' + tableNo + '" onchange="quantityCalc2(this)"></td>'
					+ '<td rowspan="3"><textarea name="productRemarks" class="form-control" cols="10" id="inputProductRemarks' + tableNo + '"></textarea></td>'
					+ '<td rowspan="3" class="align: middle"><button type="button" class="btn btn-outline-secondary" onclick="deleteLineForm(this);" id="deleteLineForm' + tableNo + '">削除</button></td>'
					+ '</tr>'
					+ '<tr></tr>'
					+ '<tr>'
					+ '<td rowspan="2">'
						+ '<input type="text" value="" class="form-control" size="2" name="quantity" id="quantity' + tableNo + '" onchange="quantityCalc1(this)">'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td rowspan="3"><textarea name="productRemarks" class="form-control" cols="10" id="productRemarks' + tableNo + '" readonly></textarea></td>'
					+ '<td rowspan="3"><input type="text" value="" class="form-control" size="4" name="cost" id="cost' + tableNo + '" readonly></td>'
					+ '<td rowspan="3"><input type="text" value="" class="form-control" size="4" name="retailPrice" id="retailPrice' + tableNo + '" readonly></td>'
					+ '<td rowspan="3"><textarea name="eadRemarks" class="form-control" cols="10" id="eadRemarks' + tableNo + '" readonly></textarea></td>'
					+ '<td rowspan="3"><button type="button" value="" class="btn btn-outline-secondary" onclick="reprintForm(this);" id="reprintForm' + tableNo + '">前行複写</button></td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td rowspan="2"><button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchStock" id="openSearchStock' + tableNo + '">在庫</button></td>'
					+ '</tr>'
					+ '<tr></tr>');
			});

			/* 行削除 */
			function deleteLineForm(obj) {
				if(!confirm("この行を削除しますか？")) {
					return;
				}
				var rows = $(obj).parent().parent();
				rows.next().next().next().next().next().remove();
				rows.next().next().next().next().remove();
				rows.next().next().next().remove();
				rows.next().next().remove();
				rows.next().remove();
				rows.remove();
				/*  */
				for(let i = 0; i < (($("#order tr").length-4)/6); i++){
					var table = document.getElementById("orderbody");
					table.rows[(i*6)].cells[0].children[0].setAttribute("id", "tableLineNo"+(i+1));
					table.rows[(i*6)].cells[0].children[0].innerText= (i+1);
					table.rows[(i*6)].cells[1].children[0].setAttribute("id", "productCodeInput"+(i+1));
					table.rows[(i*6)].cells[1].children[1].setAttribute("id", "setproductsearch"+(i+1));
					table.rows[(i*6)].cells[2].children[0].setAttribute("id", "productName"+(i+1));
					table.rows[(i*6)].cells[3].children[0].setAttribute("id", "rackCode"+(i+1));
					table.rows[(i*6)].cells[4].children[0].setAttribute("id", "unitCost"+(i+1));
					table.rows[(i*6)].cells[5].children[0].setAttribute("id", "unitRetailPrice"+(i+1));
					table.rows[(i*6)].cells[6].children[0].setAttribute("id", "inputProductRemarks"+(i+1));
					table.rows[(i*6)].cells[7].children[0].setAttribute("id", "deleteLineForm"+(i+1));
					table.rows[(i*6)+2].cells[0].children[0].setAttribute("id", "quantity"+(i+1));
					table.rows[(i*6)+3].cells[0].children[0].setAttribute("id", "productRemarks"+(i+1));
					table.rows[(i*6)+3].cells[1].children[0].setAttribute("id", "cost"+(i+1));
					table.rows[(i*6)+3].cells[2].children[0].setAttribute("id", "retailPrice"+(i+1)); 
					table.rows[(i*6)+3].cells[3].children[0].setAttribute("id", "eadRemarks"+(i+1));
					table.rows[(i*6)+3].cells[4].children[0].setAttribute("id", "reprintForm"+(i+1));
					table.rows[(i*6)+4].cells[0].children[0].setAttribute("id", "openSearchStock"+(i+1));
				}
				calc();
			}

			/* 数量のonchange : 仕入金額・売価金額 数量*仕入単価、売上単価 */
			function quantityCalc1(obj){
				var tmp = obj.id;
				var tableNo = tmp.substr(8);
				var quantity = document.getElementById("quantity" + tableNo).value;
				var unitCost = document.getElementById("unitCost" + tableNo).value;
				var unitRetailPrice = document.getElementById("unitRetailPrice" + tableNo).value;
				var cost = quantity * unitCost;
				var retailPrice = quantity * unitRetailPrice;
				target1 = document.getElementById("cost" + tableNo);
				target2 = document.getElementById("retailPrice" + tableNo);
				target1.value = cost;
				target2.value = retailPrice;

				calc();
			}

			/* 売上単価のonchange : 仕入金額・売価金額 数量*仕入単価、売上単価 */
			function quantityCalc2(obj){
				var tmp = obj.id;
				var tableNo = tmp.substr(15);
				var quantity = document.getElementById("quantity" + tableNo).value;
				var unitCost = document.getElementById("unitCost" + tableNo).value;
				var unitRetailPrice = document.getElementById("unitRetailPrice" + tableNo).value;
				var cost = quantity * unitCost;
				var retailPrice = quantity * unitRetailPrice;
				target1 = document.getElementById("cost" + tableNo);
				target2 = document.getElementById("retailPrice" + tableNo);
				target1.value = cost;
				target2.value = retailPrice;

				calc();
			}

			/* 伝票 */
			function calc(){
				/* 金額合計 : 売価金額-仕入金額*/
				var hairetsu1 = document.getElementsByName("cost");
				var hairetsu2 = document.getElementsByName("retailPrice");
				var sum1 = 0;
				var sum2 = 0;
				sum1 = parseInt(sum1);
				sum2 = parseInt(sum2);
				for(var i in hairetsu1){
					if(hairetsu1[i].value != null && hairetsu1[i].value != ""){
						sum1 = parseInt(hairetsu1[i].value) + parseInt(sum1);
					}
				}
				for(var i in hairetsu2){
					if(hairetsu2[i].value != null && hairetsu2[i].value != ""){
						sum2 = parseInt(hairetsu2[i].value) + parseInt(sum2);
					}
				}
				target = document.getElementById("retailPriceTotal");
				target.innerHTML = '￥' + (sum2 - sum1);

				/* 粗利益 : 売上金額-仕入金額 */
				var hairetsu3 = document.getElementsByName("cost");
				var hairetsu4 = document.getElementsByName("retailPrice");
				var sum3 = 0;
				var sum4 = 0;
				sum3 = parseInt(sum3);
				sum4 = parseInt(sum4);
				for(var i in hairetsu3){
					if(hairetsu3[i].value != null && hairetsu3[i].value != ""){
						sum3 = parseInt(hairetsu3[i].value) + parseInt(sum3);
					}
				}
				for(var i in hairetsu4){
					if(hairetsu4[i].value != null && hairetsu4[i].value != ""){
						sum4 = parseInt(hairetsu4[i].value) + parseInt(sum4);
					}
				}
				target = document.getElementById("grossProfit");
				target.innerHTML = '￥' + (sum4 - sum3);

				/* 粗利益率 : (粗利益/金額合計)*100 */
				target = document.getElementById("grossProfitRatio");
				if((sum4 - sum3) != null && (sum4 - sum3) !="" && (sum2 - sum1) != null && (sum2 - sum1) != ""){
					target.innerHTML = ((sum4 - sum3) / (sum2 - sum1)) * 100 + '%';
				}

				/* 消費税 : 売上単価*(1+消費税率) */
				var ctaxRate = (parseInt(document.getElementById("ctaxRate").value)) /100;
				target = document.getElementById("ctaxPriceTotal");
				target.innerHTML = '￥' + parseInt(sum4 * ctaxRate);

				/* 伝票合計 : 金額合計+消費税 */
				target = document.getElementById("priceTotal");
				target.innerHTML = '￥' + parseInt((sum2 - sum1) + (sum4 * ctaxRate));
			}

			/* 顧客モーダルから親画面にリンク */
			function selectCustomerCode(){
				var customerCode = document.getElementById("modalCustomerCode").innerText;
				var customerName = document.getElementById("modalCustomerName").innerText;
				document.getElementById("customerCodeInput").value = customerCode;
				document.getElementById("customerNameInput").value = customerName;
			}

			/* 商品モーダルから親画面にリンク */
			function selectProductCode(obj){
				var tableNo = globalTmp.substr(16);
				var productCode = document.getElementById("modalProductCode1").innerText;
				var productName = document.getElementById("modalProductName1").innerText;
				document.getElementById("productCodeInput" + tableNo).value = productCode;
				document.getElementById("productName" + tableNo).innerHTML = productName;
			}

			/* 親画面から顧客モーダルに顧客コード渡す */
			function customerCodetoModal(obj){
				var customerCode = document.getElementById("customerCodeInput").value;
				document.getElementById("inputCustomerCode").value = customerCode;
			}

			/* 親画面から商品モーダルに商品コードを渡す */
			function productCodetoModal(obj){
				globalTmp = obj.id;
				var tableNo = globalTmp.substr(16);
				var productCode = document.getElementById("productCodeInput" + tableNo).value;
				document.getElementById("inputProductCode").value = productCode;
			}
			
			function roSlipLinetoParent(){
				var form = document.stockTable;
				form.submit();
			}
		</script>
	</body>
</html>
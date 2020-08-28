<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html lang="en">
	<head>
	
		<%@ include file="/common/productSearch.jsp" %>
		<%@ include file="/common/bill.jsp" %>
		<%@ include file="../common/_customerSearch.jsp" %>
		<%@ include file="/common/stock.jsp" %>
		
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
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script type="text/javascript" src="common/shotcuts.js"></script>
		<%@ include file= "../common/menubar.jsp" %>
		<br><br>

		<div class="container" id="main_function">
			<h3 class="float-left">受注編集</h3>
			<!-- FNキー -->
			<div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">  
				<div class="btn-group mr-2 " role="group" aria-label="First group">
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initForm();" >F1<br>初期化</button>
					<form action="/SalesCube2020/SalesCube?action=deleteOrder" method="post"  onsubmit="return confirm('このデータを削除しますか？')">
						<button type="submit" class="btn btn-secondary h-100" style="font-size: 12px;" id="deleteOrder">F2<br>削除</button>
						<input type="hidden" id="roSlipId" name="roSlipId" value="${order.roSlipId}">
					</form>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" id="returnForm" onclick="returnForm();">F3<br>戻る</button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="updateButton();">F4<br>更新</button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F5<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" data-toggle="modal" data-target="#openOrder" onclick="orderForm()" id="billopen">F6<br>伝票呼出</button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F7<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F8<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F9<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F10<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F11<br></button>
					<button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F12<br></button>
				</div>
			</div><br><br><br>
		</div><br>
		
		<!-- 登録・更新 完了/エラー メッセージ -->
		<div style="width:100%; text-align:center; margin-bottom:20px;">
				 <span class="action_errors" style="color: red">${inputErr}</span>
				 <span class="action_errors" style="color: red">${inputCmp}</span>
				 <span class="action_errors" style="color: red">${updateErr}</span>
				 <span class="action_errors" style="color: red">${updateCmp}</span>
       </div>

		<form action='/SalesCube2020/SalesCube?action=orderupdateCmp' method="post" name="orderUpdate"  onsubmit="return updateForm();">
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
								<input type="text" value="${order.roSlipId}" class="form-control" name="roSlipId" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">受注日</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text" style = "background-color: pink;">受注日※</div>
								</div>
								<input type="date" value="${order.roDate}"  class="form-control" name="roDate" required>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">出荷日</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">出荷日</div>
								</div>
								<input type="date" value="${order.shipDate}" name="shipDate" class="form-control">
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
								<input type="date" value="${order.deliveryDate}" name="deliveryDate" class="form-control">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">受付番号</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">受付番号</div>
								</div>
								<input type="text" value="${order.receptNo}" name="receptNo" class="form-control">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">客先伝票番号</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">客先伝票番号</div>
								</div>
								<input type="text" value="${order.customerSlipNo}" name="customerSlipNo" class="form-control">
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
								<input type="text" value="${order.userName}" name="userName" class="form-control" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">摘要</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">摘要</div>
								</div>
								<input type="text" value="${order.remarks}" name="remarks" class="form-control">
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">配送業者</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">配送業者</div>
								</div>
								<select class="custom-select" name="dcName">
								<option></option>
									<c:forEach items="${initDcName}" var="initDN">
										<option value="${initDN.categoryCode}" id="dcName" <c:if test="${order.dcName == initDN.categoryCodeName}">selected</c:if>>${initDN.categoryCodeName}</option>
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
								<select class="custom-select" name="dcTimeZone">
								<option></option>
									<c:forEach items="${initDcTimezone}" var="initDT">
										<option value="${initDT.categoryCode}" id="dcTimezone" <c:if test="${order.dcTimezone == initDT.categoryCodeName}">selected</c:if>>${initDT.categoryCodeName}</option>
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
								<select class="custom-select" name="ctaxRate" id="ctaxRate" onchange="calc();">
										<option></option>
									<c:forEach items="${initTaxRate}" var="initTR">
										<option value="${initTR.ctaxRate}"<c:if test="${order.ctaxRate == initTR.ctaxRate}">selected</c:if>>${initTR.ctaxRate}</option>
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
								<input type="text" value="${order.customerCode}" class="form-control" id="customerCodeInput" name="customerCodeInput" onchange="customerInfo()" required>
								<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#customerSearch" onclick="customerCodetoModal();getCutoffGroup();">検索</button>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">顧客名</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">顧客名</div>
								</div>
								<input type="text" value="${order.customerName}"  class="form-control" id="customerNameInput" name="customerNameInput" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">税転嫁</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">税転嫁</div>
								</div>
								<input type="text" value="${order.taxShiftCategory}" class="form-control" name="taxShiftCategory" id="taxShiftCategory" readonly>
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
								<input type="text" value="${order.cutoffGroup}" class="form-control" name="cutoffGroup" id="cutoffGroup" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">取引区分</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">取引区分</div>
								</div>
								<input type="text" value="${order.salesCmCategory}" class="form-control" name="salesCmCategory" id="salesCmCategory" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">備考</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">備考</div>
								</div>
								<input type="text" value="${order.customerRemarks}" class="form-control" name="customerRemarks" id="customerRemarks" readonly>
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
								<input type="text" value="${order.customerCommentData}" class="form-control" name="customerCommentData" id="customerCommentData" readonly>
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
								<select class="custom-select" name="deliveryName" id="deliveryName" onchange="deliverySelect()">
									<!--<c:forEach items="">-->
										<option value="">${order.deliveryName}</option>
									<!--</c:forEach>-->
								</select>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">事務所名</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">事務所名</div>
								</div>
								<input type="text" value="${order.deliveryOfficeName}" class="form-control" name="deliveryOfficeName" id="deliveryOfficeName" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">部署名</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">部署名</div>
								</div>
								<input type="text" value="${order.deliveryDeptName}" class="form-control" name="deliveryDeptName" id="deliveryDeptName" readonly>
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
								<input type="text" value="${order.deliveryZipCode}" class="form-control" name="deliveryZipCode" id="deliveryZipCode" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">住所1</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">住所1</div>
								</div>
								<input type="text" value="${order.deliveryAddress1}" class="form-control" name="deliveryAddress1" id="deliveryAddress1" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">住所2</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">住所2</div>
								</div>
								<input type="text" value="${order.deliveryAddress2}" class="form-control" name="deliveryAddress2" id="deliveryAddress2" readonly>
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
								<input type="text" value="${order.deliveryPcName}" class="form-control" name="deliveryPcName" id="deliveryPcName" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">担当者カナ</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">担当者カナ</div>
								</div>
								<input type="text" value="${order.deliveryPcKana}" class="form-control" name="deliveryPcKana" id="deliveryPcKana" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">敬称</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">敬称</div>
								</div>
								<input type="text" value="${order.deliveryPcPre}" class="form-control" name="deliveryPcPre" id="deliveryPcPre" readonly>
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
								<input type="text" value="${order.deliveryTel}" class="form-control" name="deliveryTel" id="deliveryTel" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">FAX</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">FAX</div>
								</div>
								<input type="text" value="${order.deliveryFax}" class="form-control" name="deliveryFax" id="deliveryFax" readonly>
							</div>
						</div>
						<div class="col-4">
							<label class="sr-only" for="inlineFormInputGroup">E-MAIL</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">E-MAIL</div>
								</div>
								<input type="text" value="${order.deliveryEmail}" class="form-control" name="deliveryEmail" id="deliveryEmail" readonly>
							</div>
						</div>
					</div>
				</div><br>
			</div></div><br><br>

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
				<c:forEach items="${orderlist}" var="list">
					<tr>
						<td rowspan="6"><span id="tableLineNo${list.lineNo}">${list.lineNo}</span></td>
						<td rowspan="6">
							<input type="text" value="${list.productCode}" class="form-control" size="2" style="width:100%" id="productCodeInput${list.lineNo}"  maxlength='20' name="productCodeInput" onchange="pCode(this)" required>
							<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" onclick="productCodetoModal(this);initProductModal();" id="setproductsearch${list.lineNo}">検索</button>
						</td>
						<td rowspan="3"><input type="text" id="productName${list.lineNo}" class="form-control" name="productName" value="${list.productName}" readonly></td>
						<td rowspan="2">
							<input type="text" value="${list.rackCode}" class="form-control" size="2" id="rackCode${list.lineNo}" name="rackCode" readonly>
						</td>
						<td rowspan="3">
							<input type="text" value="${list.unitCost}" class="form-control" size="4" name="unitCost" id="unitCost${list.lineNo}" name="unitCost" readonly>
						</td>
						<td rowspan="3">
							<input type="text" value="${list.unitRetailPrice}" class="form-control" size="4" name="unitRetailPrice" id="unitRetailPrice${list.lineNo}" name="unitRetailPrice" onchange="quantityCalc2(this)" required>
						</td>
						<td rowspan="3">
							<textarea name="productRemarks" class="form-control" cols="10" id="inputProductRemarks${list.lineNo}" name="inputProductRemarks">${list.inputProductRemarks}</textarea>
						</td>
						<td rowspan="3" class="align: middle">
							<button type="button" class="btn btn-outline-secondary" onclick="deleteLineForm(this);" id="deleteLineForm${list.lineNo}">削除</button>
						</td>
					</tr>
					<tr></tr>
					<tr>
						<td rowspan="2">
							<input type="text" value="${list.quantity}" class="form-control" size="2" name="quantity" id="quantity${list.lineNo}" name="quantity" onchange="quantityCalc1(this)" required>
						</td>
					</tr>
					<tr>
						<td rowspan="3">
							<textarea name="productRemarks" class="form-control" cols="10" id="productRemarks${list.lineNo}" name="productRemarks" readonly>${list.productRemarks}</textarea>
						</td>
						<td rowspan="3">
							<input type="text" value="${list.cost}" class="form-control" size="4" name="cost" id="cost${list.lineNo}" name="cost" readonly>
						</td>
						<td rowspan="3">
							<input type="text" value="${list.retailPrice}" class="form-control" size="4" name="retailPrice" id="retailPrice${list.lineNo}" name="retailPrice" readonly>
						</td>
						<td rowspan="3">
							<textarea name="eadRemarks" class="form-control" cols="10" id="eadRemarks${list.lineNo}" name="eadRemarks">${list.eadRemarks}</textarea>
						</td>
						<td rowspan="3">
							<button type="button" value="" class="btn btn-outline-secondary" id="reprintForm${list.lineNo}" ${list.lineNo > 1 ? '' :"disabled"} onclick='reprintForm(this);'>前行複写</button>
						</td>
					</tr>
					<tr>
						<td rowspan="2">
							<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchStock" id="openSearchStock${list.lineNo}" onclick="openStock(this)">在庫</button>
						</td>
					</tr>
					<tr></tr>
					</c:forEach>
				</tbody>
				
			</table>

			<!-- 行追加 -->
			<table align="center">
				<tr>
					<td>
							<button type="button" class="btn btn-outline-secondary" id="addLine">行追加</button>
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
				<input type="submit" class="btn btn-outline-secondary w-auto" value="更新" id="updateOrderButton">
		</div><br>
	</form>

		<script>
		
			window.onload = function() {
				calc();
				customerInfo();
			};
			
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
				window.location.href = "/SalesCube2020/SalesCube?action=orderinput";
			}

			/* 更新 */
			function updateForm() {
				if(!confirm("入力内容を登録します。よろしいですか？")){
			       	return false;
				}
			}
			
			function updateButton(){
				document.getElementById("updateOrderButton").click();
			}
	
			/* 伝票呼出 */
			function orderForm() {
				var modal = document.getElementById("billopen");
				var test = confirm("未登録の入力内容を破棄し伝票呼出してもよろしいですか？");
				if(test == false){					
					modal.removeAttribute("data-toggle");
					return;
				}else{
					modal.setAttribute("data-toggle","modal");
				}
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
				var productName = document.getElementById("productName" + (tableNo - 1)).value;
				target = document.getElementById("productName" + tableNo);
				if(productName != null && productName != ""){
					target.value = productName;
				}else{
					target.value = null;
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
						+ '<input type="text" value="" class="form-control" size="2" style="width:100%" name="productCodeInput" id="productCodeInput' + tableNo + '"  onchange="pCode(this)" required>'
						+ '<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#setproductsearch" onclick="productCodetoModal(this);initProductModal();" id="setproductsearch' + tableNo + '">検索</button>'
					+ '</td>'
					+ '<td rowspan="3"><input type="text" id="productName' + tableNo + '" class="form-control" name="productName" value="${list.productName}" readonly></td>'
					+ '<td rowspan="2"><input name="rackCode" type="text" value="" class="form-control" size="2" id="rackCode' + tableNo + '" readonly></td>'
					+ '<td rowspan="3"><input name="unitCost" type="text" value="" class="form-control" size="4" name="unitCost" id="unitCost' + tableNo + '" readonly></td>'
					+ '<td rowspan="3">'
						+ '<input type="text" value="" class="form-control" size="4" name="unitRetailPrice" name="unitRetailPrice" id="unitRetailPrice' + tableNo + '" onchange="quantityCalc2(this)" required></td>'
					+ '<td rowspan="3"><textarea name="productRemarks" class="form-control" cols="10" name="inputProductRemarks" id="inputProductRemarks' + tableNo + '"></textarea></td>'
					+ '<td rowspan="3" class="align: middle"><button type="button" class="btn btn-outline-secondary" onclick="deleteLineForm(this);" id="deleteLineForm' + tableNo + '">削除</button></td>'
					+ '</tr>'
					+ '<tr></tr>'
					+ '<tr>'
					+ '<td rowspan="2">'
						+ '<input type="text" value="" class="form-control" size="2" name="quantity" id="quantity' + tableNo + '" onchange="quantityCalc1(this)" required>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td rowspan="3"><textarea name="productRemarks" class="form-control" cols="10" name="productRemarks" id="productRemarks' + tableNo + '" readonly></textarea></td>'
					+ '<td rowspan="3"><input type="text" value="" class="form-control" size="4" name="cost" id="cost' + tableNo + '" readonly></td>'
					+ '<td rowspan="3"><input type="text" value="" class="form-control" size="4" name="retailPrice" id="retailPrice' + tableNo + '" readonly></td>'
					+ '<td rowspan="3"><textarea name="eadRemarks" class="form-control" cols="10" name="eadRemarks" id="eadRemarks' + tableNo + '" readonly></textarea></td>'
					+ '<td rowspan="3"><button type="button" value="" class="btn btn-outline-secondary" onclick="reprintForm(this);" id="reprintForm' + tableNo + '">前行複写</button></td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td rowspan="2"><button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#openSearchStock" id="openSearchStock' + tableNo + '" onclick="openStock(this)">在庫</button></td>'
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
				target.innerHTML = '￥' + sum2;

				///* 粗利益 : 売価金額-仕入金額 */
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
				if((sum4 - sum3) != null && (sum4 - sum3) !="" && sum2 != null && sum2 != ""){
					target.innerHTML = Math.floor( ((sum4 - sum3) / sum2) * 100 * 100) / 100 + '%';
				}

				/* 消費税 : 金額合計*消費税率 */
				target = document.getElementById("ctaxPriceTotal");
				var num = document.getElementById("ctaxRate");
				var rate = num.options[num.selectedIndex].value;
				if(rate == null || rate == ""){
					target.innerHTML = '￥0';
				}else{
					var ctaxRate = (parseInt(rate)) /100;
					target.innerHTML = '￥' + parseInt(sum2 * ctaxRate);
				}
				
				/* 伝票合計 : 金額合計+消費税 */
				target = document.getElementById("priceTotal");
				if(rate == null || rate == ""){
					target.innerHTML = '￥' + parseInt(sum2);
				}else{
					var ctaxRate = parseInt(rate) /100;
					target.innerHTML = '￥' + parseInt(sum2 * (ctaxRate+1));
				}
			}

			/* 商品モーダルから親画面にリンク */
			function selectProductModal(code, name){
				var tableNo = globalTmp.substr(16);
				document.getElementById("customerCodeInput").value = code;
				document.getElementById("customerNameInput").value = name;
				document.getElementById("productCodeInput" + tableNo).value = code;
				document.getElementById("productName" + tableNo).innerHTML = name;
				
				var tmp = document.getElementById("productCodeInput" + tableNo);
				
				pCode(tmp);
			}

			/* 親画面から顧客モーダルに顧客コード渡す */
			function customerCodetoModal(obj){
				var customerCode = document.getElementById("customerCodeInput").value;
				document.getElementById("inputCustomerCode").value = customerCode;
			}
			/* 顧客モーダルから親画面にリンク */
			function selectCustomerCode(code, name){
				document.getElementById("customerCodeInput").value = code;
				document.getElementById("customerNameInput").value = name;
				customerInfo(code);
			}
			/* 商品モーダルから親画面にリンク */
			function selectProductModal(code, name){
				var tableNo = globalTmp.substr(16);
				document.getElementById("productCodeInput" + tableNo).value = code;
				document.getElementById("productName" + tableNo).innerHTML = name;
				
				var tmp = document.getElementById("productCodeInput" + tableNo);
				
				pCode(tmp);
			}

			/* 親画面から商品モーダルに商品コードを渡す */
			function productCodetoModal(obj){
				globalTmp = obj.id;
				var tableNo = globalTmp.substr(16);
				var productCode = document.getElementById("productCodeInput" + tableNo).value;
				document.getElementById("productCode").value = productCode;
			}
			
			function roSlipLinetoParent(){
				var form = document.stockTable;
				form.submit();
			}
			
			/* 商品コードから明細表示 ajax */
			function pCode(obj){
				globalTmp = obj.id;
				var tableNo = globalTmp.substr(16);
				var inputProductCode = document.getElementById("productCodeInput" + tableNo).value;	
				document.getElementById("productName" + tableNo).innerHTML = "";
				document.getElementById("rackCode" + tableNo).value = "";
				document.getElementById("unitCost" + tableNo).value = "";
				document.getElementById("unitRetailPrice" + tableNo).value = "";
				document.getElementById("inputProductRemarks" + tableNo).innerText = "";
				document.getElementById("quantity" + tableNo).value = "";
				document.getElementById("productRemarks" + tableNo).innerText = "";
				document.getElementById("cost" + tableNo).value = "";
				document.getElementById("retailPrice" + tableNo).value = "";
				document.getElementById("eadRemarks" + tableNo).innerText = "";
				$.ajax({
					type: "post",
					url: '/SalesCube2020/SalesCubeAJAX?action=pcodetoinfo',
					data: {"productCode": inputProductCode },
					dataType: 'json',
					success: function(data){
						if(data.productName == null || data.productName == ""){
							alert("該当する商品情報は存在しません");
						} else {
						document.getElementById('productName' + tableNo).innerHTML = data.productName;
						}
						if(data.rackCode == null || data.rackCode == ""){
							data.rackCode = "";
						}else {
							document.getElementById('rackCode' + tableNo).value = data.rackCode;
						}
						if(data.unitCost == null || data.unitCost == ""){
							data.unitCost = "";
							
						}else {
							document.getElementById('unitCost' + tableNo).value = data.unitCost;
						}
						if(data.unitRetailPrice == null || data.unitRetailPrice == ""){
							data.unitRetailPrice = "";
						}else {
							document.getElementById('unitRetailPrice' + tableNo).value = data.unitRetailPrice;
						}
						if(data.inputProductRemarks == null || data.inputProductRemarks == ""){
							data.inputProductRemarks = "";
						}else {
							document.getElementById('inputProductRemarks' + tableNo).innerHTML = data.inputProductRemarks;
						}
						if(data.quantity == null || data.quantity == ""){
							data.quantity = "";
						}else {
							document.getElementById('quantity' + tableNo).value = data.quantity;
						}
						if(data.productRemarks == null || data.productRemarks == ""){
							data.productRemarks = "";
						}else {
							document.getElementById('productRemarks' + tableNo).innerHTML = data.productRemarks;
						}
						if(data.cost == null || data.cost == ""){
							data.cost = "";
						}else {
							document.getElementById('cost' + tableNo).value = data.cost;
						}
						if(data.retailPrice == null || data.retailPrice == ""){
							data.retailPrice = "";
						}else {
							document.getElementById('retailPrice' + tableNo).value = data.retailPrice;
						}
						if(data.eadRemarks == null || data.eadRemarks == ""){
							data.eadRemarks = "";
						}else {
							document.getElementById('eadRemarks' + tableNo).innerHTML = data.eadRemarks;
						}
						calc();
					}
				});
			}

			/* 顧客コードから顧客・納入先情報 ajax */
			function customerInfo() {
				var cCode = document.getElementById("customerCodeInput").value;
				$("#deliveryName > option").remove();
				document.getElementById("customerName").value = "";
				document.getElementById("taxShiftCategory").value = "";
				document.getElementById("cutoffGroup").value = "";
				document.getElementById("salesCmCategory").value = "";
				document.getElementById("customerRemarks").value = "";
				document.getElementById("customerCommentData").value = "";
				document.getElementById("deliveryOfficeName").value = "";
				document.getElementById("deliveryDeptName").value = "";
				document.getElementById("deliveryZipCode").value = "";
				document.getElementById("deliveryAddress1").value = "";
				document.getElementById("deliveryAddress2").value = "";
				document.getElementById("deliveryPcName").value = "";
				document.getElementById("deliveryPcKana").value = "";
				document.getElementById("deliveryPcPre").value = "";
				document.getElementById("deliveryTel").value = "";
				document.getElementById("deliveryFax").value = "";
				document.getElementById("deliveryEmail").value = "";
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=cuscodetoinfo',
				type:'post',
				data:{"customerCode": cCode },
				dataType:'json',
				success:function(data){
					var tmp = JSON.parse(data.bean);
					if(tmp['customerName'] == null || tmp['customerName'] == ""){
						tmp['customerName'] == "";
					} else {
						document.getElementById('customerNameInput').value = tmp['customerName'];
					}
					if(tmp['taxShiftCategory'] == null || tmp['taxShiftCategory'] == ""){
						tmp['taxShiftCategory'] == "";
					}else{
						document.getElementById('taxShiftCategory').value = tmp['taxShiftCategory'];
					}
					if(tmp['cutoffGroup'] == null || tmp['cutoffGroup'] == ""){
						tmp['cutoffGroup'] = "";
					}else{
						document.getElementById('cutoffGroup').value = tmp['cutoffGroup'];
					}
					if(tmp['salesCmCategory'] == null || tmp['salesCmCategory'] == ""){
						tmp['salesCmCategory'] = "";
					}else{
						document.getElementById('salesCmCategory').value = tmp['salesCmCategory'];
					}
					if(tmp['customerRemarks'] == null || tmp['customerRemarks'] == ""){
						tmp['customerRemarks'] = "";
					}else{
						document.getElementById('customerRemarks').value = tmp['customerRemarks'];
					}
					if(tmp['customerCommentData'] == null || tmp['customerCommentData'] == ""){
						tmp['customerCommentData'] = "";
					}else{ 
						document.getElementById('customerCommentData').value = tmp['customerCommentData'];
					}
					
					for(var i = 0; i<Object.keys(data.list).length; i++){
						$("#deliveryName").append("<option value = '" + data.list[i].deliveryCode + "'>"+data.list[i].deliveryName+"</option>");
					}
						if(data.list[0].deliveryOfficeName == null || data.list[0].deliveryOfficeName == ""){
							data.list[0].deliveryOfficeName = "";
						}else{
							document.getElementById('deliveryOfficeName').value = data.list[0].deliveryOfficeName;
						}
						if(data.list[0].deliveryDeptName == null || data.list[0].deliveryDeptName == ""){
							data.list[0].deliveryDeptName = "";
						}else{
							document.getElementById('deliveryDeptName').value = data.list[0].deliveryDeptName;
						}
						if(data.list[0].deliveryZipCode == null || data.list[0].deliveryZipCode == ""){
							data.list[0].deliveryZipCode = "";
						}else{
							document.getElementById('deliveryZipCode').value = data.list[0].deliveryZipCode;
						}
						if(data.list[0].deliveryAddress1 == null || data.list[0].deliveryAddress1 == ""){
							data.list[0].deliveryAddress1 = "";
						}else{
							document.getElementById('deliveryAddress1').value = data.list[0].deliveryAddress1;
						}
						if(data.list[0].deliveryAddress2 == null || data.list[0].deliveryAddress2 == ""){
							data.list[0].deliveryAddress2 = "";
						}else{
							document.getElementById('deliveryAddress2').value = data.list[0].deliveryAddress2;
						}
						if(data.list[0].deliveryPcName == null || data.list[0].deliveryPcName == ""){
							data.list[0].deliveryPcName = "";
						}else{
							document.getElementById('deliveryPcName').value = data.list[0].deliveryPcName;
						}
						if(data.list[0].deliveryPcKana == null || data.list[0].deliveryPcKana == ""){
							data.list[0].deliveryPcKana = "";
						}else{
							document.getElementById('deliveryPcKana').value = data.list[0].deliveryPcKana;
						}
						if(data.list[0].deliveryPcPre == null || data.list[0].deliveryPcPre == ""){
							data.list[0].deliveryPcPre = "";
						}else{
							document.getElementById('deliveryPcPre').value = data.list[0].deliveryPcPre;
						}
						if(data.list[0].deliveryTel == null || data.list[0].deliveryTel == ""){
							data.list[0].deliveryTel = "";
						}else{
							document.getElementById('deliveryTel').value = data.list[0].deliveryTel;
						}
						if(data.list[0].deliveryFax == null || data.list[0].deliveryFax == ""){
							data.list[0].deliveryFax = "";
						}else{
							document.getElementById('deliveryFax').value = data.list[0].deliveryFax;
						}
						if(data.list[0].deliveryEmail == null || data.list[0].deliveryEmail == ""){
							data.list[0].deliveryEmail = "";
						}else{
							document.getElementById('deliveryEmail').value = data.list[0].deliveryEmail;
						}
				}
			});
		}
			
		/* 納入先選択 */
		function deliverySelect(){
			var deliveryCode = document.getElementById("deliveryName").value;
			$("#deliveryName > option selected").remove();
			document.getElementById("deliveryOfficeName").value = "";
			document.getElementById("deliveryDeptName").value = "";
			document.getElementById("deliveryZipCode").value = "";
			document.getElementById("deliveryAddress1").value = "";
			document.getElementById("deliveryAddress2").value = "";
			document.getElementById("deliveryPcName").value = "";
			document.getElementById("deliveryPcKana").value = "";
			document.getElementById("deliveryPcPre").value = "";
			document.getElementById("deliveryTel").value = "";
			document.getElementById("deliveryFax").value = "";
			document.getElementById("deliveryEmail").value = "";
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=deliverytoinfo',
			type:'post',
			data:{"deliveryCode": deliveryCode },
			dataType:'json',
			success:function(data){
				for(var i = 0; i<Object.keys(data.list2).length; i++){
					$("#deliveryName").append("<option value = '" + data.list2[i].deliveryCode + "'>" + data.list2[i].deliveryName + "</option>");
				}
					if(data.list[0].deliveryOfficeName == null || data.list[0].deliveryOfficeName == ""){
						data.list[0].deliveryOfficeName = "";
					}else{
						document.getElementById('deliveryOfficeName').value = data.list[0].deliveryOfficeName;
					}
					if(data.list[0].deliveryDeptName == null || data.list[0].deliveryDeptName == ""){
						data.list[0].deliveryDeptName = "";
					}else{
						document.getElementById('deliveryDeptName').value = data.list[0].deliveryDeptName;
					}
					if(data.list[0].deliveryZipCode == null || data.list[0].deliveryZipCode == ""){
						data.list[0].deliveryZipCode = "";
					}else{
						document.getElementById('deliveryZipCode').value = data.list[0].deliveryZipCode;
					}
					if(data.list[0].deliveryAddress1 == null || data.list[0].deliveryAddress1 == ""){
						data.list[0].deliveryAddress1 = "";
					}else{
						document.getElementById('deliveryAddress1').value = data.list[0].deliveryAddress1;
					}
					if(data.list[0].deliveryAddress2 == null || data.list[0].deliveryAddress2 == ""){
						data.list[0].deliveryAddress2 = "";
					}else{
						document.getElementById('deliveryAddress2').value = data.list[0].deliveryAddress2;
					}
					if(data.list[0].deliveryPcName == null || data.list[0].deliveryPcName == ""){
						data.list[0].deliveryPcName = "";
					}else{
						document.getElementById('deliveryPcName').value = data.list[0].deliveryPcName;
					}
					if(data.list[0].deliveryPcKana == null || data.list[0].deliveryPcKana == ""){
						data.list[0].deliveryPcKana = "";
					}else{
						document.getElementById('deliveryPcKana').value = data.list[0].deliveryPcKana;
					}
					if(data.list[0].deliveryPcPre == null || data.list[0].deliveryPcPre == ""){
						data.list[0].deliveryPcPre = "";
					}else{
						document.getElementById('deliveryPcPre').value = data.list[0].deliveryPcPre;
					}
					if(data.list[0].deliveryTel == null || data.list[0].deliveryTel == ""){
						data.list[0].deliveryTel = "";
					}else{
						document.getElementById('deliveryTel').value = data.list[0].deliveryTel;
					}
					if(data.list[0].deliveryFax == null || data.list[0].deliveryFax == ""){
						data.list[0].deliveryFax = "";
					}else{
						document.getElementById('deliveryFax').value = data.list[0].deliveryFax;
					}
					if(data.list[0].deliveryEmail == null || data.list[0].deliveryEmail == ""){
						data.list[0].deliveryEmail = "";
					}else{
						document.getElementById('deliveryEmail').value = data.list[0].deliveryEmail;
					}
				}
			
			});
		}
		
		shortcut.add("F1", function(){
			initForm();
		});
		
		shortcut.add("F2", function(){
			document.getElementById("deleteOrder").click();
		});
		
		shortcut.add("F3", function(){
			document.getElementById("returnForm").click();
		});
		
		shortcut.add("F4", function(){
			document.getElementById("updateOrderButton").click();
		});
		
		shortcut.add("F6", function(){
			document.getElementById("billopen").click();
		});
			
		</script>
	</body>
</html>
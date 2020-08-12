<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form action=" " method="post">
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
					<!-- <c:forEach items="" > -->
						<tr>
							<form method="post" id="estimateTable">
								<td style="white-space: normal; text-align: left;" data-dismiss="modal" id="estimateSheetId"><a href="orderinput.html">見積番号1</a></td>
							</form>
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
					<!-- </c:forEach> -->
				</table>
				<br>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

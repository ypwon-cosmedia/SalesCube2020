<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
								<td>${stockLink.productCode}</td>
								<th bgcolor="black"><font color="white" id="productPCode">仕入先商品コード</font></th>
								<td>${stockLink.supplierPCode}</td>
								<th bgcolor="black"><font color="white" id="setTypeCategory">セット分類</font></th>
								<td>${stockLink.setTypeCategory}</td>
							</tr>
							<tr>
								<th bgcolor="black"><font color="white" id="productName">商品名</font></th>
								<td>${stockLink.productName}</td>
								<th bgcolor="black"><font color="white" id="warehouseName">倉庫名</font></th>
								<td>${stockLink.warehouseName}</td>
								<th bgcolor="black"><font color="white" id="rackCode">棚番</font></th>
								<td>${stockLink.rackCode}</td>
							</tr>
							<tr>
								<th bgcolor="black"><font color="white" id="productStatusCategory">分類-状態</font></th>
								<td>${stockLink.productStatusCategory}</td>
								<th bgcolor="black"><font color="white" id="productStockCategory">分類-保管</font></th>
								<td>${stockLink.productStockCategory}</td>
							</tr>
						</table>
						<br>           
						<table class="table table-bordered">
							<tr>
								<th bgcolor="black"><font color="white" id="stockQuantity">現在庫総数</font></th>
								<th bgcolor="black"><font color="white" id="quantitySum">受注残数</font></th>
							</tr>
							<tr>
								<td>${stockLink.stockQuantity}</td>
								<td>${stockLink.quantity}</td>
							</tr>
						</table>       
						
								受注残明細
								<table class="table table-bordered">
									<tr>
										<th bgcolor="black"><font color="white">受注番号-行</font></th>
										<th bgcolor="black"><font color="white">出荷日</font></th>
										<th bgcolor="black"><font color="white">受注残数</font></th>
									</tr>
									<c:forEach items="${stockLinkDetail}" var="detail">
										<tr>
											<form action=" " method="post" id="stockTable">
												<td id="roSlipLine"><a href="orderupdate.html" id="roSlipLine">${detail.roSlipId}-${detail.roLineId}</a></td>
											</form>
											<td id="shipDate">${detail.shipDate}</td>
											<td id="quantity">${detail.quantity}</td>
										</tr>
									</c:forEach>

								</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

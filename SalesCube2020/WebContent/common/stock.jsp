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
								<th bgcolor="black"><font color="white">商品コード</font></th>
								<td id="stockProductCode"></td>
								<th bgcolor="black"><font color="white">仕入先商品コード</font></th>
								<td id="stockProductPCode"></td>
								<th bgcolor="black"><font color="white">セット分類</font></th>
								<td id="stockSetTypeCategory"></td>
							</tr>
							<tr>
								<th bgcolor="black"><font color="white">商品名</font></th>
								<td id="stockProductName"></td>
								<th bgcolor="black"><font color="white">倉庫名</font></th>
								<td id="stockWarehouseName"></td>
								<th bgcolor="black"><font color="white">棚番</font></th>
								<td id="stockRackCode"></td>
							</tr>
							<tr>
								<th bgcolor="black"><font color="white">分類-状態</font></th>
								<td id="stockProductStatusCategory"></td>
								<th bgcolor="black"><font color="white">分類-保管</font></th>
								<td id="stockProductStockCategory"></td>
							</tr>
						</table>
						<br>           
						<table class="table table-bordered">
							<tr>
								<th bgcolor="black"><font color="white">現在庫総数</font></th>
								<th bgcolor="black"><font color="white">受注残数</font></th>
							</tr>
							<tr>
								<td id="stockQuantity"></td>
								<td id="stockQuantitySum"></td>
							</tr>
						</table>       
						
								受注残明細
								<table class="table table-bordered">
									<tr>
										<th bgcolor="black"><font color="white">受注番号-行</font></th>
										<th bgcolor="black"><font color="white">出荷日</font></th>
										<th bgcolor="black"><font color="white">受注残数</font></th>
									</tr>
									<tbody id= stockbody>
									</tbody>
								</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
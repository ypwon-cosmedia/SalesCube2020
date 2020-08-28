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
									<tbody id= "stockbody">
									</tbody>
								</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
		<script>
		
		/*商品在庫モーダル開く */
		function openStock(obj){
			globalTmp = obj.id;
			var tableNo = globalTmp.substr(15);
			var productCode = document.getElementById("productCodeInput" + tableNo).value;
			$("#stockbody > tr").remove();
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=stocksearch',
				data:{"productCode": productCode },
				dataType:'json',
				type:'post',
				success:function(data){
					var tmp = JSON.parse(data.bean);
					if(tmp['productCode'] == null || tmp['productCode'] == ""){
						document.getElementById('stockProductCode').innerHTML = "";
					}else{
						document.getElementById('stockProductCode').innerHTML = tmp['productCode'];
					}
					if(tmp['supplierPCode'] == null || tmp['supplierPCode'] == ""){
						document.getElementById('stockProductPCode').innerHTML = "";
					}else{
						document.getElementById('stockProductPCode').innerHTML = tmp['supplierPCode'];
					}
					if(tmp['setTypeCategory'] == null || tmp['setTypeCategory'] == ""){
						document.getElementById('stockSetTypeCategory').innerHTML = "";
					}else{
						document.getElementById('stockSetTypeCategory').innerHTML = tmp['setTypeCategory'];
					}
					if(tmp['productName'] == null || tmp['productName'] == ""){
						document.getElementById('stockProductName').innerHTML = "";
					}else{
						document.getElementById('stockProductName').innerHTML = tmp['productName'];
					}
					if(tmp['warehouseName'] == null || tmp['warehouseName'] == ""){
						document.getElementById('stockWarehouseName').innerHTML = "";
					}else{
						document.getElementById('stockWarehouseName').innerHTML = tmp['warehouseName'];
					}
					if(tmp['rackCode'] == null || tmp['rackCode'] == ""){
						document.getElementById('stockRackCode').innerHTML = "";
					}else{
						document.getElementById('stockRackCode').innerHTML = tmp['rackCode'];
					}
					if(tmp['productStatusCategory'] == null || tmp['productStatusCategory'] == ""){
						document.getElementById('stockProductStatusCategory').innerHTML = "";
					}else{
						document.getElementById('stockProductStatusCategory').innerHTML = tmp['productStatusCategory'];
					}
					if(tmp['productStockCategory'] == null || tmp['productStockCategory'] == ""){
						document.getElementById('stockProductStockCategory').innerHTML = "";
					}else{
						document.getElementById('stockProductStockCategory').innerHTML = tmp['productStockCategory'];
					}
					if(tmp['stockQuantity'] == null || tmp['stockQuantity'] == ""){
						document.getElementById('stockQuantity').innerHTML = "";
					}else{
						document.getElementById('stockQuantity').innerHTML = tmp['stockQuantity'].split('.')[0];
					}
					if(tmp['quantity'] == null || tmp['quantity'] == ""){
						document.getElementById('stockQuantitySum').innerHTML = "";
					}else{
						document.getElementById('stockQuantitySum').innerHTML = tmp['quantity'].split('.')[0];
					}
					
					for(var i = 0; i<Object.keys(data.list).length; i++){
						if(data.list[i].roSlipId == null || data.list[i].roSlipId == "" ){
							$("#stockbody").append("<tr><td><a href=''></a></td><td>"+data.list[i].shipDate+"</td><td>"+data.list[i].quantity+"</td></tr>");
						}else if(data.list[i].shipDate == null || data.list[i].shipDate == ""){
							$("#stockbody").append("<tr><td><a href='/SalesCube2020/SalesCube?action=orderupdate&roSlipId="+data.list[i].roSlipId.split('-')[0]+"'>"+data.list[i].roSlipId+"</a></td><td></td><td>"+data.list[i].quantity.split('.')[0]+"</td></tr>");
						}else if(data.list[i].quantity == null || data.list[i].quantity == "" ){
							$("#stockbody").append("<tr><td><a href='/SalesCube2020/SalesCube?action=orderupdate&roSlipId="+data.list[i].roSlipId.split('-')[0]+"'>"+data.list[i].roSlipId+"</a></td><td>"+data.list[i].shipDate+"</td><td></td></tr>");
						}else{
							$("#stockbody").append("<tr><td><a href='/SalesCube2020/SalesCube?action=orderupdate&roSlipId="+data.list[i].roSlipId.split('-')[0]+"'>"+data.list[i].roSlipId+"</a></td><td> "+data.list[i].shipDate+"</td><td> "+data.list[i].quantity.split('.')[0]+"</td></tr>");
						}
					}
				}
			});
		}
		
		</script>
		
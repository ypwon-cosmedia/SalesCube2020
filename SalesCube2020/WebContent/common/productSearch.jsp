<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="setproductsearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			
			<div class="modal-header">
				<h5 class="modal-title" id="label1">商品検索</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
			</div>
			 
			<form action="" method="post" id="product">
				<div class="modal-body">
				  <div class="row">
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">商品コード</div>
						</div>
						<input type="text"  class="form-control" id="productCode" name="productCode">
					  </div>
					</div>
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">仕入先商品コード</div>
						</div>
						<input type="text"  class="form-control" id="supllierPcode" name="supllierPcode">
					  </div>
					</div>
					<div class="col-4">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">JANコード</div>
						</div>
						<input type="text"  class="form-control" id="janPcode" name="janPcode">
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
						  <select class="custom-select" id="setTypeCategory" name="setTypeCategory">
							<option selected></option>
							<c:forEach var="options" items="${setProduct}">
								<option value = "${options.categoryCode}">${options.categoryCodeName}</option>
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
						  <select class="custom-select" id="productStandardCategory"name="productStandardCategory">
							<option selected></option> 
							<c:forEach var="options" items="${standard}">
							  <option value = "${options.categoryCode}">${options.categoryCodeName}</option>
							</c:forEach>
						  </select>
						</div>
					</div>

					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup">productStockCategory</label>
						  <div class="input-group mb-2">
							<div class="input-group-prepend">
							  <div class="input-group-text">分類状況</div>
							</div>
							<select class="custom-select" id="productStatusCategory" name="productStatusCategory">
							  <option selected></option>
							  <c:forEach var="options" items="${classStatus}">
							    <option value = "${options.categoryCode}">${options.categoryCodeName}</option>
							  </c:forEach>
							</select>
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
						<input type="text"  class="form-control" id="productName" name="productName">
					  </div>
					</div>
					<div class="col-6">
					  <label class="sr-only" for="inlineFormInputGroup"></label>
					  <div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">商品名カナ</div>
						</div>
						<input type="text"  class="form-control" id="productKana" name="productKana">
					  </div>
					</div>
				  </div>
				</div>
				<br>

				<div class="rounded float-right">
				  <button type="button" class="btn btn-outline-secondary" onclick="initproductModal();">初期化</button>&ensp;
				  <button type="button" class="btn btn-outline-secondary" onclick="productSearch();">検索</button>&ensp;
				</div>
			  </form>

			  <div class="modal-body">
				<div class="float-left" style="position:static; left: 0px;">
				  検索結果件数：<span id="productSearchResultCount">0</span>件
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
				  <tbody id="productResult">
				  </tbody>
				</table>
				<br>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>
</div>

<script>
function productSearch() {
			
			var formString = $("form[id=product]").serialize();
			var tmp = "";
			
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=productSearch',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){	
					$("#productResult > tr").remove();
					for(var i = 0; i<Object.keys(data).length; i++){
						var headcontents= '';
						headcontents += '<tr>';
						headcontents += '<td style="white-space: normal; text-align: left;" onclick="selectProductModal('+data[i].productCode+",'"+data[i].productName+"'"+')" data-dismiss="modal"><a href="">'+data[i].productCode+'</a></td>';
						headcontents += '<td style="white-space: normal; text-align: left;" onclick="selectProductModal('+data[i].productCode+",'"+data[i].productName+"'"+')" data-dismiss="modal"><a href="">'+data[i].productName+'</a></td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+(data[i].supplierName==null ? '' : data[i].supplierName)+'</td>';   
						headcontents += '</tr>';
						$('#productResult').append(headcontents);						
					}
					$('#productSearchResultCount').text(+Object.keys(data).length);
				}
			});
		}
		
	function initproductModal(){
		$("#productResult > tr").remove();
		$('#productSearchResultCount').text("0");
		$("#product")[0].reset(); 
	}
</script>
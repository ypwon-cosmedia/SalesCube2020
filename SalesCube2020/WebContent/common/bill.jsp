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
				<form action="" method="post" id="bill">
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
						<button type="button" class="btn btn-outline-secondary" onclick="billSearch()">検索</button>
					</div>
				</form>
				<br>
				<table id="order_detail_info" class="table table-bordered">
					<thead class="thead-dark">
					  <tr>
						<th scope="col" class="rd_top_left th_back_black" style="cursor: pointer; height: 30px;">見積番号</th>
						<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;">見積日</th>
						<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;">提出先名</th>
						<th scope="col" class="th_back_black" style="cursor: pointer; height: 30px;">件名</th>
								
					</tr>
					</thead>
					<tbody id="billBody">
					</tbody>
				</table>
				<br>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script>
	function billSearch() {	
		alert();
		var formString = $("form[id=bill]").serialize();
		var tmp = "";
		
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=billsearch',
			type:'post',
			data:formString,
			dataType:'json',
			success:function(data){	
				$("#billBody > tr").remove();
				for(var i = 0; i<Object.keys(data).length; i++){
					var headcontents= '';
					headcontents += '<tr>';
					headcontents += '<td style="white-space: normal; text-align: left;" onclick="estimateSheettoParent(' + "'" + data[i].estimateSheetId +"','"+data[i].estimateSheetId+"'"+')" data-dismiss="modal"><a href="">'+data[i].estimateSheetId+'</a></td>';
					headcontents += '<td style="white-space: normal; text-align: left;" onclick="estimateSheettoParent(' + "'" + data[i].estimateDate +"','"+data[i].estimateDate+"'"+')" data-dismiss="modal">'+data[i].estimateDate+'</td>';
					headcontents += '<td style="white-space: normal; text-align: left;">'+(data[i].submitName==null ? '' : data[i].submitName)+'</td>';   
					headcontents += '<td style="white-space: normal; text-align: left;">'+(data[i].title==null ? '' : data[i].title)+'</td>';   
					headcontents += '</tr>';
					$('#billBody').append(headcontents);						
				}
			}
		});
	}
	
	function initFormOrder() {	
		$("#billBody > tr").remove();
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=initBill',
			dataType:'json',
			type:'post',
			success:function(data){	
				for(var i = 0; i<Object.keys(data.list1).length; i++){
					$("#setTypeCategory").append("<option value = "+data.list1[i].categoryCode+">"+data.list1[i].categoryCodeName+"</option>");	
				}
				for(var i = 0; i<Object.keys(data.list2).length; i++){
					$("#productStandardCategory").append("<option value = "+data.list2[i].categoryCode+">"+data.list2[i].categoryCodeName+"</option>");
				}
				for(var i = 0; i<Object.keys(data.list3).length; i++){
					$("#productStockCategory").append("<option value = "+data.list3[i].categoryCode+">"+data.list3[i].categoryCodeName+"</option>");
					
				}
			}
		});
	}
	
</script>

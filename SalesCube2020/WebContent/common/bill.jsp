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

		var formString = $("form[id=bill]").serialize();
		var tmp = "";
		
		$.ajax({
			url:'/SalesCube2020/SalesCubeAJAX?action=billsearch',
			type:'post',
			data:formString,
			dataType:'json',
			success:function(data){	
				$("#billBody > tr").remove();
				var tableNo = ($("#billBody tr").length)+1
				alert(tableNo);
				for(var i = 0; i<Object.keys(data.list).length; i++){
					var headcontents= '';
					headcontents += '<tr>';
					headcontents += '<td style="white-space: normal; text-align: left;" onclick="billToOrder(this)" id="estimateSheetId' + tableNo +'" data-dismiss="modal"><a href="">'+data.list[i].estimateSheetId+'</a></td>';
					headcontents += '<td style="white-space: normal; text-align: left;">'+(data.list[i].estimateDate==null ? '' : data.list[i].estimateDate)+'</td>';
					headcontents += '<td style="white-space: normal; text-align: left;">'+(data.list[i].submitName==null ? '' : data.list[i].submitName)+'</td>';   
					headcontents += '<td style="white-space: normal; text-align: left;">'+(data.list[i].title==null ? '' : data.list[i].title)+'</td>';   
					headcontents += '</tr>';
					$('#billBody').append(headcontents);						
				}
			}
		});
	}
	
	function billToOrder(obj){
		var tableNo = obj.id.substr(15);
		alert(tableNo);
		var estimateSheetId = document.getElementById("estimateSheetId"+tableNo).innerText;
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "post");
		form.setAttribute("action", "/SalesCube2020/SalesCube?action=billlink");
		var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		input.setAttribute("name", "estimateSheetId");
		input.setAttribute("value", estimateSheetId);
		form.appendChild(input);
		document.body.appendChild(form);
		form.submit();
	}
	
	/* 伝票呼出の初期化 */
	function initFormOrder() {	
		$("#billBody > tr").remove();
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
	
</script>

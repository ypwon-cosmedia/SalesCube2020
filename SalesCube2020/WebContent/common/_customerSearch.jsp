<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<title>customerSearch</title>
		
		<style type="text/css">
        .container {
            width: 1120px;
            max-width: none !important;
        }
        .table tr td {
            background-color: white;
        }

        .table {
          white-space: nowrap;
        } 
        
        .cursor-pointer{
 		 	    cursor: pointer;
 		 	    color : blue;
		    }
      
        .clear-decoration {
                border: none;  /* 枠線を消す */
                outline: none; /* クリックしたときに表示される枠線を消す */
                background: transparent; /* 背景の灰色を消す */
            }

            
        .table_1{
          border-collapse: collapse;
          border-spacing: 0;
          height: 250px;
          display: block;
          overflow-x: scroll;
          overflow-y: scroll;
          white-space: nowrap;
        }

        .table_1 thead tr th{
            position: sticky;
            position: -webkit-sticky;
            top: 0;
            
            z-index: 1;
        }
      
      .table_2{
            
            border-collapse: collapse;
            border-spacing: 0;

            height: auto;
            display: block;
            overflow-x: scroll;
          
            white-space: nowrap;
            
        }
        .scrollnum{
            position: sticky;
            position: -webkit-sticky;
            top: 0;
            left: 0;
            z-index: 1;
        }
        
        .example3 li {
          display: inline-block;
          height:35px;line-height:35px;
          width:35px;text-align:center;
          border:1px #ccc solid;color:#000053;
          border-radius: 5px / 5px;
          }
    	</style>
    	
    	
	</head>

	<body style="background-color: gainsboro;">
       <!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       <br><br>

       
       <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#customerSearch">
        ↓
        </button>

		<div class="modal fade" id="customerSearch" tabindex="-1" role="dialog" aria-labelledby="label1" aria-hidden="true">
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
                          <label class="sr-only" for="inlineFormInputGroup">customerCode</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客コード</div>
                            </div>
                            <input type="text"  class="form-control" id="inlineFormInputGroup" name="customerCode">
                          </div>
                        </div>
                      </div>
                    

                    
                      <div class="row">
                        <div class="col-5">
                          <label class="sr-only" for="inlineFormInputGroup">customerName</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客名</div>
                            </div>
                            <input type="text"  class="form-control" id="inlineFormInputGroup" name="customerName">
                          </div>
                        </div>&emsp;&emsp;&emsp;
                      

                        <div class="col-6">
                          <label class="sr-only" for="inlineFormInputGroup">customerKana</label>
                          <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">顧客名カナ</div>
                            </div>
                            <input type="text"  class="form-control" id="inlineFormInputGroup" name="customerKana"> 
                          </div>
                        </div>
                      </div>
                    
                      
                    
                      <div class="row">
                        <div class="col-6">
                          <label class="sr-only" for="inlineFormInputGroup"></label>
                            <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                <div class="input-group-text">支払条件</div>
                              </div>
                              <select class="custom-select" name="cutoffGroup" id="cutoffGroup">
                                <option selected></option>
                                <c:forEach items="${cutoffGroup}" var="cutoffGroup">
                                  <option value="${cutoffGroup.categoryCode}">${cutoffGroup.categoryCodeName}</option>
                                </c:forEach> 
                                
                              </select>
                            </div>
                        </div>
                      </div>
                    </div>
                    
              
                    <div class="rounded float-right">
                      <button type="button" class="btn btn-primary" onclick="initCustomer()">初期化</button>&ensp;
                      <input type="button" value="検索" class="btn btn-primary" onclick="customerSearch()">&ensp;
                    </div>
                    <br>
                    <br>
                </form>

                  <div id="resultCustomer" >
                    <div class="modal-body">
                      <div class="float-left" style="position:static; left: 0px;">
                        	  検索結果件数： 
                      </div>
                    </div>
                    <br>
                  
                   
                  
                  <!--顧客検索結果テーブル-->
                  	<div class="modal-body scroll-table" style="background-color: rgb(255, 255, 255);" >
                    	<table id="order_detail_info" class="table table_1 table-bordered scrolltable">
                      	<thead class="thead-light">
                        	<tr>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerCode');">顧客コード</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('costomerName');">顧客名</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerTEL');">TEL</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerPCName');">担当者</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('salesCmCategory');">取引区分</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('cutoffGroup');">支払条件</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerOfficeName');">事務所名</th>
	                          <th scope="col" class="scrolltablehead" style="cursor: pointer; height: 30px;" onclick="sort('customerDeptName');">部署名</th>
                          	</tr>
                      	</thead>
                      	
                     		<tbody class="modal-body scroll-table">
                      		<c:forEach items="${customerSearch}" var="customer">
		                        <tr>
		                          <td style="text-align: left;" ><span class="cursor-pointer" onclick="test(this)" id="customerCode,customerName" data-dismiss="modal">${customer.customerCode}</span></td>
		                          <td class="customerName" style="text-align: left;">${customer.customerName}</td>
		                          <td class="customerTEL" style="text-align: left;">${customer.customerTEL}</td>
		                          <td class="customerPCName" style="text-align: left;">${customer.customerPCName}</td>
		                          <td class="salesCmCattegory" style="text-align: left;">${customer.salesCmCategory}</td>
		                          <td class="cutoffGroup" style="text-align: left;">${customer.cutoffGroup}</td>
		                          <td class="customerOfficeName" style="text-align: left;">${customer.customerOfficeName}</td>
		                          <td class="customerDeptName" style="text-align: left;">${customer.customerDeptName}</td>
		                        </tr>
                      		</c:forEach>
                      		
                    	</table>
                    	<br>
                  	</div>
                  	
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-primary" data-dismiss="modal">閉じる</button>
	                </div>
	                
            	</div>
          	</div>
        </div>
      </div> 
      
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
      <script>
     	//検索結果を表示する 
    //  	function customerSearch(){
    //	  $('#resultCustomer').removeAttr('hidden');
    //	}
      	
     	//初期化処理
      	function initCustomer(){
            $("[name='customerCode']").val("");
            $("[name='customerName']").val("");
            $("[name='customerKana']").val("");
            $("[name='cutoffGroup']").val("");

            //テーブルの非表示
            document.getElementById("serchResult").setAttribute('hidden','hidden');
    	}
     	
     	//顧客コード及び顧客名の値をセット
      	function test(obj) {
      	     var customer = obj.id ;
      	     var list = customer.split(",");

      	      document.getElementById("customerCode").value = list[0];
      	      document.getElementById("customerName").value = list[1];
      	 }
     	
      	function selectCustomerCode(){
    		var productCode = document.getElementById("customerCode1").innerText;
    		
    		document.getElementById("customerCodeInput").value = customerCode;
    	}
     	
		function customerSearch1() {
			
		//	$('#resultCustomer').removeAttr('hidden');	//検索結果表示表示
			
			var formString = $("form[id=customer]").serialize();
			var tmp = "";
			
			$.ajax({
				url:'/SalesCube2020/SalesCubeAJAX?action=customerSearch',
				type:'post',
				data:formString,
				dataType:'json',
				success:function(data){	
					$("#customerResult > tr").remove();
					alert(Object.keys(data).length);
					for(var i = 0; i<Object.keys(data).length; i++){
						var headcontents= '';
						headcontents += '<tr>';
						headcontents += '<td style="white-space: normal; text-align: left;" onclick="selectcustomerCode()" data-dismiss="modal" id="customerCode1"><a href="">'+data[i].customerCode+'</a></td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerName+'</td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerTEL+'</td>';  
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerPCName+'</td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].salesCmCategory+'</td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].cutoffGroup+'</td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerOfficeName+'</td>';
						headcontents += '<td style="white-space: normal; text-align: left;">'+data[i].customerDeptName+'</td>';
						headcontents += '</tr>';
						$('#customerResult').append(headcontents);						
					}
				}
			});
		}
     	
      </script>  
      
	</body>
</html>
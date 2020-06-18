<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>SalesBean 数量割引</title>
    
    <style type="text/css">
        .container {
            width: 1120px;
            max-width: none !important;
        }
    </style>
    
    <script type="text/javascript">
    	function initForm() {
   			if(!confirm("入力内容を初期化してよろしいですか？")){
   	   			return;
  			}
			window.location.href = '/SalesCube2020/quantitydiscount.jsp';
		}
    	
    	function CloseWindow() {
    		 <!--alert();-->
    		 window.close();
   	}
    </script>
    
  </head>
  <body style="background-color: gainsboro;">
   	<!-- Optional JavaScript -->
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       <br><br>
       

    <br>
    <div class="container" style="background-color: white;"><div class="panel panel-default" >
    <div class="form-group container">
    <br><h5>数量割引検索</h5>
    <hr>
    <form action="/SalesCube2020/SalesCube?action=quantitydiscountserch">
        <div class="row">
            <div class="col-4">
                <label class="sr-only" for="inlineFormInputGroup">discountCode</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text" >割引コード</div>
                    </div>
                <input type="text"  class="form-control" id="inlineFormInputGroup" name="discountCode" >
                </div>
            </div>
            <div class="col-6">
                <label class="sr-only" for="inlineFormInputGroup">useFlag</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text" >割引有効</div>
                    </div>
                    <select class="custom-select" name="useFlag">
                        <option selected></option>                        
                        <option value="0">無効</option>
                        <option value="1">有効</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="sr-only" for="inlineFormInputGroup">discountName</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text" >割引名</div>
                    </div>
                <input type="text"  class="form-control" id="inlineFormInputGroup" name="discountNmae">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="sr-only" for="inlineFormInputGroup">remarks</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text" >備考</div>
                    </div>
                <input type="text"  class="form-control" id="inlineFormInputGroup" name="remarks">
                </div>
            </div>
        </div>
        <div align="right">
        <button type="button" class="btn btn-outline-secondary" onclick="initForm()">初期化</button>&emsp;
        <input type="submit" value="検索" class="btn btn-outline-secondary">&emsp;
        </div>
    </form>
    </div>
    </div><br></div><br>


    <div class="container">
        <div class="float-left" style="position:static; left: 0px;">
            検索結果件数：${quantitydiscountserchresult.serchCount}件
        </div>
        <div class="rounded float-right">
            ページあたりの表示件数
            <select id="rowCount" name="rowCount">
                <option value="10">10</option>
                <option value="50">50</option>
                <option value="100" selected>100</option>
            </select>
        </div>
    </div><br><br>


    <div class="container" style="background-color: white;"><div class="panel panel-default" >
    <div style="background-color: rgb(255, 255, 255);">
        <table id="order_detail_info" class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col" class="rd_top_left th_back_black" >割引詳細</th>
                    <th scope="col" class="th_back_black"  >割引コード</th>
                    <th scope="col" class="th_back_black" >割引名</th>
                    <th scope="col" class="th_back_black"  >割引有効</th>
                </tr>
            </thead>
            <c:forEach items="${quantitydiscountserchresult}" var="discount">
                <tr>
                    <td style="white-space: normal; text-align: left;">
                    	<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#discountdetail">
                           	 割引詳細
                        </button>
                          <div class="modal fade" id="discountdetail" tabindex="-1"
                                role="dialog" aria-labelledby="label1" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="label1">割引詳細</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table thead-dark">
                                        <tr><th>No</th><th>数量範囲</th><th>掛率</th></tr>
                                        <c:forEach items="${quantitydiscountdetailserchresult}" var="discountdetail">
                                        <tr>
                                        	<td>${discountdetail.lineNo}</td>
                                        	<td>${discountdetail.dataFrom}</td>
                                        	<td>${discountdetail.dataTo}</td>
                                        	<td>${discountdetail.discountRate}</td>
                                        </tr>
                                        </c:forEach>
                                      </table>
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
                                </div>
                              </div>
                            </div>
                          </div>
                    </td>
                    <td style="white-space: normal; text-align: left;">${discount.discountID}</td>
                    <td style="white-space: normal; text-align: left;">${discount.discountName}</td>
                    <td style="white-space: normal; text-align: left;">${discount.useFrag}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    </div><br>
        <div align="right">
        <input type="button" value="閉じる" class="btn btn-outline-secondary" onClick="CloseWindow();">&emsp;
    	</div><br>
    </div><br>
  </body>
</html>
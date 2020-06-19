<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
        <title>郵便検索</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
    <body style="background-color: gainsboro;">
        <br><br>
        <div class="container panel panel-default" style="background-color: white;">
            <h5><br>郵便番号検索</h5>
			<hr>
	        <form action="/SalesCube2020/SalesCube?action=address" name="adrs" method="post">
				<div class="row">
					<div class="col-4">
						<label class="sr-only" for="inlineFormInputGroup">zipCode</label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">郵便番号</div>
							</div>
							<input type="text"  class="form-control" id="inlineFormInputGroup" value="${zipCode}">
						</div>
    				</div>
                    <div class="col-4">
                        <label class="sr-only" for="inlineFormInputGroup">zipAdress1</label>
						<div class="input-group mb-2">
	    					<div class="input-group-prepend">
		    					<div class="input-group-text">住所1</div>
							</div>
	    					<input type="text"  class="form-control" id="inlineFormInputGroup" value="${Address1}">
						</div>
    				</div>
				</div>
				<div class="rounded float-right">
                    <button type="button" class="btn btn-outline-secondary" onClick="initForm()">初期化</button>
                    <input type="submit" value="検索" class="btn btn-outline-secondary">
				</div><br>
			</form><br>
           </div><br>
        
        <!-- 検索結果の表示 -->
        <div class="container">
            <div class="float-left" style="position:static; left: 0px;">
		                検索結果件数：${fn.length()}件
            </div>
            <div class="float-right" style="position:static; right: 0px;">
                <c:if test="${fn.length() ge 100}">
                    <font color="red"><b>
			                        該当件数が100件以上あるため表示できません。
			                        検索条件を追加して絞り込んでください。
                    </b></font>
                </c:if>
            </div>
        </div>
        <br><br><br>

        <!--検索結果テーブル-->
        <div class="container" style="background-color: rgb(255, 255, 255);">
            <table id="order_detail_info" class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col" class="rd_top_left th_back_black" style="height: 30px;">郵便番号</th>
                        <th scope="col" class="th_back_black" style="height: 30px;">住所1</th>
                        <th scope="col" class="th_back_black" style="height: 30px;">住所2</th>
                    </tr>
                </thead>
                <c:forEach items="${customer}" var="cus">              
                    <tr>
                        <td style="white-space: normal; text-align: left; cursor: pointer;" id="inputData" onClick="clickData()">${cus.zipCode}</td>
                        <td style="white-space: normal; text-align: left;">${cus.address1}</td>
                        <td style="white-space: normal; text-align: left;">${cus.address2}</td>
                    </tr>
                </c:forEach>                
            </table>
        </div>
        <div class="container">
            <div class="rounded float-right">
                <input type="button" value="閉じる" class="btn btn-secondary" onClick="closeWindow();">
            </div>
        </div>
	
	</body>
	    <script>
        //入力値の初期化
        function initForm(){
            if(!confirm("入力内容を初期化してよろしいですか？")){
                return;
            }
    	   	document.adrs.reset();
        }

        //子窓を閉じる
        function closeWindow(){
            window.close();
        }

        //郵便番号をクリックしたとき親窓にデータを渡し、子窓を閉じる
        function clickData() {
            var parantExistanceFlag = true;
            // 親窓の存在チェック
            // 親窓が存在しない場合
            if (!window.opener || window.opener.closed){    
                window.alert('メインウィンドウが見当たりません。');
                parantExistanceFlag = false;
            }
            //親窓が存在する場合
            else{
                window.opener.document.getElementById("zipInput").value = document.getElementById("inputData").value;
                window.close();
            }
        }
    </script>
	
</html>
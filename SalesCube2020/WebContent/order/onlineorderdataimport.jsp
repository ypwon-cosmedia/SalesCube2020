<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>オンライン受注データ取込</title>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
    <style type="text/css">
    
      .menuGroup {
          -moz-border-bottom-colors: none;
          -moz-border-left-colors: none;
          -moz-border-right-colors: none;
          -moz-border-top-colors: none;
          background-color: #FFFFFF;
          border-color: #FFFFFF -moz-use-text-color #DDDDDD;
          border-image: none;
          border-left: medium none;
          border-radius: 5px;
          border-right: medium none;
          color: #BBBBBB;
          cursor: pointer;
          margin: 5px;
          padding: 5px;
      }
      .container {
	   width: 1120px;
	   max-width: none !important;
	   }

    </style>
</head>
<body style="background-color: gainsboro;">
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    
    <%@ include file= "../common/menubar.jsp" %>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.min.js"></script>    
	<script type="text/javascript" src="common/shotcuts.js"></script>
	<br>
    <div class="container" id="main_function">
      <h3 class="float-left">オンライン受注データ取込</h3>
      
      <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
        
        <div class="btn-group mr-2 " role="group" aria-label="First group">
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="initPage();">F1<br>初期化</button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F2<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" onclick="importData();">F3<br>取込<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F4<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F5<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F6<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F7<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F8<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F9<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F10<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F11<br></button>
          <button type="button" class="btn btn-secondary" style="font-size: 12px;" disabled>F12<br></button>
        </div>
      </div>
      <br><br><br><br>
      </div>
      <form action="/SalesCube2020/SalesCube?action=uploadcsv" method="post" name="mainform" id="mainform" enctype="multipart/form-data">
		<div class="container" style="background-color: white;"><div class="panel panel-default" >
			<div class="panel-heading row mb-2 col-4">
				<h5><br>検索条件</h5>
			</div>
			<hr>
			<div class="panel-body">
				<div class="row">
					<div class="col-8">
						<label class="sr-only" for="inlineFormInputGroup"></label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">受注データ※</div>
							</div>
						<input type="file" class="form-control" id="uploadcsv" name="uploadcsv" accept=".csv">
						</div>
					</div>
				</div>	
      </div>
            
			<div align="right">
				<input type="button" value="初期化" class="btn btn-outline-secondary" onclick="initPage();">
				<input type="submit" value="取込" class="btn btn-outline-secondary" id="importData">

			</div>
			<br>
		</div>
		</div>

		<br>
		<br>	
		
		<div class="container">
            <div class="float-left" style="position:static; left: 0px;">取込件数：${fn:length(result)}件</div>			
		</div>
    </form>
    
<br>
<br>

<div class="container" style="background-color: rgb(255, 255, 255);" id="setProductList">
    <table id="mytable" class="table table-bordered">
		<thead class="thead-dark">
    	<tr align="center">
				<th scope="col" class="sort rd_top_left th_back_black" style="cursor: pointer; height: 30px;">受注番号</th>
        <th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">顧客名</th>
        <th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">受注日</th>
      </tr>
		</thead>
		<tbody class="list">
		  <c:forEach var="doc" items="${result}" varStatus="status">
		    <tr>	      
              <td style="white-space: normal; text-align: left;">${doc.roSlipId}</td>
              <td style="white-space: normal; text-align: left;">${doc.customerName}</td>	
              <td style="white-space: normal; text-align: left;">${doc.roDate}</td>
		  	</tr>
		  </c:forEach>  
		</tbody>
	</table>
	<input type='hidden' id="checker" value="${checker}">
</div>
<script>

	window.onload = function(){
		if(document.getElementById("checker").value == "1"){
			alert("入力形式に合わないCSVファイルです。\nCSVファイルを確認してください。");
		} else if(document.getElementById("checker").value == "2"){
			alert("CSVファイルを登録してください。");
		} else if(document.getElementById("checker").value == "0"){
			alert("${fn:length(result)}件登録されました");
		}
	}

	function initPage(){
		if(!confirm("入力内容を初期化してよろしいですか？")){
	       	return;
		}
		location.href="/SalesCube2020/SalesCube?action=onlineorder";
	}
	
	function importData(){
		var form = document.getElementById("mainform");
		
		form.submit();
	}
	
	shortcut.add("F1", function() {
		initPage();
	});

	shortcut.add("F3", function() {
		document.getElementById("importData").click();
	});

   
</script>
</body>
</html>
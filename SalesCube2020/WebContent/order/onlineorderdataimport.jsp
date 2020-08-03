<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
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
      <br><br><br>
      </div>
      <form action="#" method="post" name="mainform" id="mainform">
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
						<input type="file"  class="form-control" id="inlineFormInputGroup" name="data1">
						</div>
					</div>
				</div>	
      </div>
            
			<div align="right">
				<input type="button" value="初期化" class="btn btn-outline-secondary" onclick="initPage();">
				<input type="button" value="取込" class="btn btn-outline-secondary" onclick="importData()">
			</div>
			<br>
		</div>
		</div>

		<br>
		<br>	
		
		<div class="container">
            <div class="float-left" style="position:static; left: 0px;">取込件数：0件</div>			
		</div>
    </form>
    
<br>

<br>

<div class="container" style="background-color: rgb(255, 255, 255);" id="setProductList">
    <table id="mytable" name="mytable" class="table table-bordered">
		<thead class="thead-dark">
    	<tr align="center">
				<th scope="col" class="sort rd_top_left th_back_black" style="cursor: pointer; height: 30px;">受注番号</th>
        <th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">顧客名</th>
        <th scope="col" class="sort th_back_black" style="cursor: pointer; height: 30px;">受注日</th>
      </tr>
		</thead>
		<tbody class="list">
			<c:forEach var="product" items="${searchData}" varStatus="status">   
			    <tr>	      
            <td class="productName" style="white-space: normal; text-align: left;">受注番号1</td>
            <td class="productName" style="white-space: normal; text-align: left;">顧客名1</td>	
            <td class="productName" style="white-space: normal; text-align: left;">2020/02/02</td>
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	function initPage(){
		if(!confirm("入力内容を初期化してよろしいですか？")){
        return;
    	}
      location.reload();
	}

	function importData(){
		if(!confirm("オンライン受注データファイルを取り込みますか？")){
        return;
      }
      document.getElementById('mainform').submit();
  }
   
</script>
</body>
</html>
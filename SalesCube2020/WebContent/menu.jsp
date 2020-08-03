<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
    <%@ include file= "common/menubar.jsp" %>
    <br><br><br>
	<div class="container">
    <div class = "row">
      <div class = "col-xs-1"></div>
      <div  class = "col-xs-5" >
        <div class="menuGroup">
          <table class="table borderless">
              <tr>
                  <td rowspan="3" style="width: 50%">マスタ機能</td>
                  <td><a href="/SalesCube2020/SalesCube?action=product">商品</a></td>
              </tr>
              <tr>
                  <td><a href="/SalesCube2020/SalesCube?action=setProduct">セット商品</a></td>
              </tr>
              <tr>
                  <td><a href="/SalesCube2020/SalesCube?action=customer">顧客</a></td>
              </tr>
          </table>
        </div>
      </div>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div  class = "col-xs-6" >
        <div class="menuGroup">
          <table class="table borderless">
              <tr>
                  <td rowspan="3">受注</td>
                  <td><a href="/SalesCube2020/SalesCube?action=orderinput">受注入力</a></td>
              </tr>
              <tr>
                  <td><a href="/SalesCube2020/SalesCube?action=ordersearch">受注検索</a></td>
              </tr>
              <tr>
                  <td><a href="/SalesCube2020/SalesCube?action=onlineorder">オンライン受注データ取込</a></td>
              </tr>
          </table>
        </div>
      </div>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div  class = "col-xs-4" >
        <div class="menuGroup">
          <table class="table borderless">
              <tr>
                  <td rowspan="3">見積</td>
                  <td><a href="/SalesCube2020/SalesCube?action=product">見積入力</a></td>
              </tr>
              <tr>
                  <td><a href="/SalesCube2020/SalesCube?action=setProduct">見積検索</a></td>
              </tr>
              <tr>
                  <td><a href="/SalesCube2020/SalesCube?action=customer">単価照会</a></td>
              </tr>
          </table>
        </div>
      </div>
   </div>
   </div>
   <br><br>   
  </body>

</html>
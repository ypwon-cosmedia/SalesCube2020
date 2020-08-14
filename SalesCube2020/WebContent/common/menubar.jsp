<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/SalesCube2020/SalesCube?action=menu">SalesCube2020</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              マスター
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=product">商品</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=setProduct">セット商品</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=customer">顧客</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              受注
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=orderinput">受注入力</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=ordersearch">受注検索</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=onlineorder">オンライン受注データ取込</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              見積
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=moveEstimateAdd">見積入力</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=moveEstimateSearch">見積検索</a>
              <a class="dropdown-item" href="/SalesCube2020/SalesCube?action=moveUnitPriceInquiry">単価照会</a>
            </div>
          </li>
        </ul>
        
        <span class="navbar-text">
          <svg class="bi bi-person-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
          </svg>
        	${userInfo.nameKNJ} &nbsp;     	
        </span>
        <form class="form-inline" action="/SalesCube2020/SalesCube?action=logout" method="post">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ログアウト</button>
        </form>
      </div>
    </nav>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<select class="custom-select" name="product1" id="pro1" onClick="selectPro1();">
	<option selected></option>
	<c:forEach var="cat" items="${category}">
		<c:if test="${!empty cat.product1 and empty cat.product2 }" >
		<option value="${cat.product1}">${cat.productName}</option>
		</c:if>
	</c:forEach>
</select>

<select class="custom-select" name="product1" id="pro1" onClick="selectPro1();">
	<option selected></option>
	<c:forEach var="cat" items="${category}">
		<c:if test="${!empty cat.product1 and !empty cat.product2 and empty cat.product3}" >
		<option value="${cat.product1}">${cat.productName}</option>
		</c:if>
	</c:forEach>
</select>

<select class="custom-select" name="product1" id="pro1" onClick="selectPro1();">
	<option selected></option>
	<c:forEach var="cat" items="${category}">
		<c:if test="${!empty cat.product1 and !empty cat.product2 and !empty cat.product3}" >
		<option value="${cat.product1}">${cat.productName}</option>
		</c:if>
	</c:forEach>
</select>
</body>
</html>
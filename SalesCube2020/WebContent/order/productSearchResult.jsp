<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:forEach var="product" items="${productSearchResult}">
<tr>
	<td style="white-space: normal; text-align: left;" onclick="selectProductCode()" data-dismiss="modal" id="productCode1"><a href="">${product.productCode}</a></td>
	<td style="white-space: normal; text-align: left;" onclick="selectProductCode()" data-dismiss="modal" id="productName1"><a href="">${product.productName}</a></td>
	<td style="white-space: normal; text-align: left;">${product.supplierName}</td>
</tr>
</c:forEach>

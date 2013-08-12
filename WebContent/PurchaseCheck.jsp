<%@ page import="moscowmule2240.java004.Product"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認</title>
</head>
<body>
	<center>
	<h1>購入確認</h1>
	<hr>
	<div>
		こんにちわ、<c:out value="${param.name}"/>
		<c:if test="${param.sex == 1}">くん。</c:if>
		<c:if test="${param.sex == 2}">さん。</c:if>
		<br>
		<fmt:formatNumber value="${param.money}" pattern="#,##0円" />
		、入ります！
	</div>
	</center>
	<br>
	<form action="PurchaseComplete" method="post">
		<input type="hidden"  name="name" value="<c:out value="${param.name}"/>">
		<input type="hidden"  name="sex" value="${param.sex}">
		<input type="hidden"  name="money" value="${param.money}">
		<input type="hidden"  name="total" value="${total}">
		<table border="4" align="center">
			<tr>
				<th>商品名</th>
				<th>料金</th>
			</tr>
			<c:forEach var="item" items="${purchase}">
				<tr>
					<th><c:out value="${item.getName()}" /></th>
					<th><fmt:formatNumber value="${item.getPrice()}" pattern="#,##0円" /></th>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=2>合計料金：<fmt:formatNumber value="${total}" pattern="#,##0円" /></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="button" value="戻る" onclick="history.back()">
					<input type="submit" value="購入" class="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
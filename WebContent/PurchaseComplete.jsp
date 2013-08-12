<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入完了</title>
</head>
<body>
	<center>
	<h1>購入完了</h1>
	<hr>
	<div>
		<c:out value="${param.name}"/>
		<c:if test="${param.sex == 1}">くん。</c:if>
		<c:if test="${param.sex == 2}">さん。</c:if>
		<br>
		ご購入、ありがとうございました。<br>
		<br>
		商品をお受け取りください。<br>
		おつりは <fmt:formatNumber value="${change}" pattern="#,##0円" />になります。<br>
		<br>
		またのご利用、お待ちしております。<br>
		<br>
		<form method="POST" action="./">
			<input type="submit" value="自動販売機へ戻る">
		</form>
	</div>
	</center>
</body>
</html>
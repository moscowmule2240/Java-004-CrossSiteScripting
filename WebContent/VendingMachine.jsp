<%@ page import="moscowmule2240.java004.Product"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品購入</title>
</head>
<body>
	<c:if test="${message != null}"><font color="red">${message}</font></c:if>
	<form action="PurchaseCheck" method="post">
		<% // １行の列数 %>
		<c:set var="count" value="7" />
		<% // 全体の商品から行数を取得 %>
		<c:set var="index" value="${products.size() / count}" />
		<c:if test="${products.size() % count != 0}">
			<c:set var="index" value="${index + 1}"/>
		</c:if>
		<table border=4 align=center>
			<caption><b>自動販売機</b></caption>
			<% // 行数分繰り返す %>
			<c:forEach var="i" begin="0" end="${index - 1}" step="1">
				<tr>
					<% // 現在行数から対象の商品インデックスを算出し商品名を出力 %>
					<c:forEach var="j" begin="${i * count}" end="${(i + 1) * count - 1}" step="1">
						<% // 商品数を超えるまで出力 %>
						<c:if test="${j < products.size()}">
							<th><c:out value="${products.get(j).getName()}" /></th>
						</c:if>
						<% // 一列目の最後の列に追加 %>
						<c:if test="${j == count - 1}">
							<th rowspan="${index * 3 + 1}">
								<label>お名前<br><input name="name" type=text value="<c:out value="${param.name}"/>"></label><br>
								<c:if test="${empty(param.sex) || param.sex == 1}">
									<label><input name="sex" type=radio value="1" checked="checked">男</label>
									<label><input name="sex" type=radio value="2">女</label><br>
								</c:if>
								<c:if test="${param.sex == 2}">
									<label><input name="sex" type=radio value="1">男</label>
									<label><input name="sex" type=radio value="2" checked="checked">女</label><br>
								</c:if>
								<br>
								<label>おかね<br>
									<select name="money">
										<c:forEach var="item" items="${money}">
											<c:if test="${param.money == item}">
												<c:set var="selected" value="selected='selected'"/>
												<option value="${item}" selected="selected">
													<fmt:formatNumber value="${item}" pattern="#,##0円" />
												</option>
											</c:if>
											<c:if test="${param.money != item}">
												<option value="${item}">
													<fmt:formatNumber value="${item}" pattern="#,##0円" />
												</option>
											</c:if>
										</c:forEach>
									</select>
								</label>
							</th>
						</c:if>
					</c:forEach>
				</tr>
				<tr>
					<% // 現在行数から対象の商品インデックスを算出し金額を出力 %>
					<c:forEach var="j" begin="${i * count}" end="${(i + 1) * count - 1}" step="1">
						<c:if test="${j < products.size()}">
							<td><c:out value="${products.get(j).getPrice()}" /></td>
						</c:if>
					</c:forEach>
				</tr>
				<tr>
					<% // 現在行数から対象の商品インデックスを算出しチェックボックスを出力 %>
					<c:forEach var="j" begin="${i * count}" end="${(i + 1) * count - 1}" step="1">
						<c:if test="${j < products.size()}">
							<% // name属性にインデックスを付与 %>
							<c:if test="${empty checked.get(j)}">
								<td><input name="select${j}" type="checkbox"></td>
							</c:if>
							<c:if test="${!empty checked.get(j)}">
								<td><input name="select${j}" type="checkbox" checked="checked"></td>
							</c:if>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="${count}">
					<center><input type="reset" value="取消">
					<input type="submit" value="確認"></center>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

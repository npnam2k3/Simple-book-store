<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ phía máy khách</title>
</head>
<body>
	<%
	if (session.getAttribute("loginedUser") != null) {
	%>
	Xin chào
	<b>${loginedUser.fullname}</b>
	<br>
	<%
	}
	%>
	<%
	if (session.getAttribute("loginedUser") == null) {
	%>
	<a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
	<br>
	<%
	}
	%>


	<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ phía admin</title>
</head>
<body>
	Xin chào
	<b>${loginedUser.fullname}</b>
	<br>
	<h3>Danh sách các cuốn sách</h3>
	<table border="1">
		<tr>
			<th>Tiêu đề</th>
			<th>Tác giả</th>
			<th>Giá tiền</th>
			<th colspan="2" width="120px">Thao tác</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td><fmt:formatNumber type="number" maxFractionDigits="0"
						value="${book.price }" /><sup>đ</sup></td>
				<td align="center"><button>Sửa</button></td>
				<td align="center"><button>Xóa</button></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>
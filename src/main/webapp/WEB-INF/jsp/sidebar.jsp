
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/fontawesome/css/all.min.css" />"
	rel="stylesheet">
<style>
.error {
	color: red;
	font-size: 12px;
}
</style>
</head>
<body>
	<div class="col-2 border-right bg-light">
		<div class="row border-bottom  d-flex justify-content-center">
			<form id="form-1" action="${pageContext.request.contextPath}/searchchitietsudung" method="get">
				<div class="form-group">
					<div class="input-group mt-3 ">
						<input type="text" class="form-control" id="user" name="tenkh"
							placeholder="Search..." style="width: 150px;"> 
								<button class="btn input-group-text bg-white" type="submit"><i
							class="fa-solid fa-magnifying-glass"></i></button>
					</div>
				</div>
			</form>
		</div>
		<div class="row border-bottom py-2">
			<a class="ml-3" href="listmay"><i class="fa-solid fa-list"></i> Danh sách máy</a>
		</div>
		<div class="row border-bottom py-2">
			<a class="ml-3" href="listdichvu"><i class="fa-solid fa-list"></i> Danh sách dịch vụ</a>
		</div>
		<div class="row border-bottom py-2">
			<a class="ml-3" href="listkhachhang"><i class="fa-solid fa-list"></i> Danh sách khách hàng</a>
		</div>
		<div class="row border-bottom py-2">
			<a class="ml-3" href="listchitietsudung"><i class="fa-solid fa-list"></i> Chi tiết sử dụng</a>
		</div>
	</div>
</body>
</html>
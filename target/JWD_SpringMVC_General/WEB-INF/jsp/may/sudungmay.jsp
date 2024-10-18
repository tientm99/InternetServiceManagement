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
<link href="<c:url value="/resources/bootstrap/css/all.min.css" />"
	rel="stylesheet">
<style>
.error{
	color: red;
	font-size: 12px;
}
</style>
</head>
<body>
	<c:if test="${not empty sudung}">
		<jsp:include page="${sudung}.jsp" />
	</c:if>
	<div class="container mt-5" style="width: 600px;">
		<div class="card shadow-lg">
			<h5 class="card-header text-center">Đăng Ký Sử Dụng Máy</h5>
			<div class="card-body">
				<form:form action="${pageContext.request.contextPath}/dangkysdmay" method="post" modelAttribute="sudungmay"> 
					<div class="form-group">
						<label for="exampleInputEmail1">Mã khách hàng</label> 
						<form:input path="id.maKH" name="maKH"
							type="text" class="form-control" placeholder="Mã khách hàng" />
						<form:errors path="id.maKH" class="error"></form:errors>
						<span class="error">${errorKhachHang}</span>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Mã máy</label> 
						<form:input path="id.maMay" type="text" name="maMay"
							class="form-control" placeholder="Mã máy" />
						<form:errors path="id.maMay" class="error"></form:errors>
						<span class="error">${errorMay}</span>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Ngày bắt đầu sử dụng</label> 
						<form:input path="id.ngayBatDauSD"
							type="date" class="form-control" />
						<form:errors path="id.ngayBatDauSD" class="error"></form:errors>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Giờ bắt đầu sử dụng</label> 
						<form:input path="id.gioBatDauSD"
							type="time" class="form-control" />
						<form:errors path="id.gioBatDauSD" class="error"></form:errors>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Thời gian sử dụng</label> 
						<form:input path="thoiGianSD"
							id="duration" type="text" class="form-control"
							placeholder="Thời gian sử dụng" />
						<form:errors path="thoiGianSD" class="error"></form:errors>
					</div>
					<button type="submit" class="btn btn-secondary btn-block">Tạo
						mới</button>
				</form:form>
			</div>
		</div>
	</div>
	<script src="/resources/bootstrap/js/jquery-3.7.1.min.js"></script>
	<script src="/resources/bootstrap/validate/Validate.js"></script>
</body>
</html>
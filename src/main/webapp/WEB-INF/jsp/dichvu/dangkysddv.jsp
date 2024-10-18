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
<style type="text/css">
.error {
	color: red;
	font-size: 12px;
}
</style>
</head>
<body>
	<jsp:include page="../wellcome.jsp" />
	<div class="container-fluid">
		<div class="row border-bottom">
			<jsp:include page="../sidebar.jsp" />
			<div class="col-10 d-flex justify-content-center p-4">
				<div class="card shadow-lg" style="width: 600px;">
					<h5 class="card-header text-center">Đang Ký Sử Dụng Dịch Vụ</h5>
					<div class="card-body">
						<form:form
							action="${pageContext.request.contextPath}/sudungdichvu"
							method="post" modelAttribute="sudungDV">
							<div class="form-group">
								<label for="exampleInputEmail1">Mã khách hàng</label>
								<form:input path="id.maKH" type="text" class="form-control"
									placeholder="Mã khách hàng" />
								<form:errors path="id.maKH" class="error"></form:errors>
								<span class="error">${errorKhachHang}</span>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Mã dịch vụ</label>
								<form:input path="id.maDV" type="text" class="form-control"
									placeholder="Mã dịch vụ" />
								<form:errors path="id.maDV" class="error"></form:errors>
								<span class="error">${errorDichVu}</span>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Ngày sử dụng</label>
								<form:input path="id.ngaySD" type="date" class="form-control"
									placeholder="Ngày sử dụng" />
								<form:errors path="id.ngaySD" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Giờ sử dụng</label>
								<form:input path="id.gioSD" type="time" class="form-control"
									placeholder="Giờ sử dụng" />
								<form:errors path="id.gioSD" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số lượng</label>
								<form:input path="soLuong" id="quantity" type="text"
									class="form-control" placeholder="Số lượng" />
								<form:errors path="soLuong" class="error"></form:errors>
							</div>
							<button type="submit" class="btn btn-secondary btn-block">Tạo
								mới</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
	<script src="/resources/bootstrap/js/jquery-3.7.1.min.js"></script>
	<script src="resources/bootstrap/validate/Validate.js"></script>
</body>
</html>
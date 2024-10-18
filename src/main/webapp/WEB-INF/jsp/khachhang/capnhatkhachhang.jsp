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
	<jsp:include page="../wellcome.jsp" />
	<div class="container-fluid">
		<div class="row border-bottom">
			<jsp:include page="../sidebar.jsp" />
			<div class="col-10 d-flex justify-content-center p-4">
				<div class="card shadow-lg" style="width: 600px;">
					<h5 class="card-header text-center">Cập Nhật Khách Hàng</h5>
					<div class="card-body">
						<form:form
							action="${pageContext.request.contextPath}/capnhatkhachhang"
							method="post" modelAttribute="updateKH">
							<div class="form-group">
								<label for="exampleInputEmail1">Mã khách hàng</label>
								<form:input path="maKH" type="text" class="form-control"
									placeholder="Mã khách hàng" readonly="true" />
								<form:errors path="maKH" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Tên khách hàng</label>
								<form:input path="tenKH" type="text" class="form-control"
									placeholder="Họ và tên" />
								<form:errors path="tenKH" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Địa chỉ</label>
								<form:input path="diaChi" type="text" class="form-control"
									placeholder="Địa chỉ" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số điện thoại</label>
								<form:input path="sdt" id="phone" type="text"
									class="form-control" placeholder="Số điện thoại" />
								<form:errors path="sdt" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Địa chỉ Email</label>
								<form:input path="email" id="email" type="text"
									class="form-control" placeholder="Email" />
								<form:errors path="email" class="error"></form:errors>
							</div>
							<button type="submit" class="btn btn-secondary btn-block">Cập
								Nhật</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
	<script src="resources/bootstrap/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/popper.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
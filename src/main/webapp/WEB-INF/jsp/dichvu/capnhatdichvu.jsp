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
					<h5 class="card-header text-center">Cập Nhật Dịch Vụ</h5>
					<div class="card-body">
						<form:form
							action="${pageContext.request.contextPath}/capnhatdichvu"
							method="post" modelAttribute="updateDV">
							<div class="form-group">
								<label for="exampleInputEmail1">Mã dịch vụ</label>
								<form:input path="maDV" type="text" class="form-control"
									placeholder="Mã dịch vụ" readonly="true" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Tên dịch vụ</label>
								<form:input path="tenDV" type="text" class="form-control"
									placeholder="Tên dịch vụ" />
								<form:errors path="tenDV" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Đơn vị tính</label>
								<form:input path="donViTinh" type="text" class="form-control"
									placeholder="Đơn vị tính" />
								<form:errors path="donViTinh" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Đơn giá</label>
								<form:input path="donGia" id="price" type="text"
									class="form-control" placeholder="Đơn giá" />
								<form:errors path="donGia" class="error"></form:errors>
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
</body>
</html>
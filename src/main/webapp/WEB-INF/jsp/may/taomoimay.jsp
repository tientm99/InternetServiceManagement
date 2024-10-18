
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
			<div class="col-10  d-flex justify-content-center p-4">
				<div class="card shadow-lg"
					style="width: 600px;">
					<h5 class="card-header text-center">Tạo Mới Máy</h5>
					<div class="card-body">
						<form:form action="${pageContext.request.contextPath}/taomoimay"
							method="post" modelAttribute="may">
							<div class="form-group">
								<label for="exampleInputEmail1">Mã máy</label>
								<form:input path="" type="text" class="form-control"
									placeholder="Mã Máy" />
								<form:errors path="maMay" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Vị trí</label>
								<form:input path="viTri" type="text" class="form-control"
									placeholder="Vị trí" />
								<form:errors path="viTri" class="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Trạng thái</label>
								<form:input path="trangThai" type="text" class="form-control"
									placeholder="Trạng thái" />
								<form:errors path="trangThai" class="error"></form:errors>
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
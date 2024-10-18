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
	.error {
    color: red;
    font-size: 12px;
}
</style>
</head>
<body>
	<c:if test="${not empty taomay}">
		<jsp:include page="${taomay}.jsp" />
	</c:if>
	<div class="container mt-5" style="width: 600px;">
		<div class="card shadow-lg">
			<h5 class="card-header text-center">Cập Nhật Máy</h5>
			<div class="card-body">
				<form:form action="${pageContext.request.contextPath}/capnhatmay" method="post" modelAttribute="updateM">
					<div class="form-group">
						<label for="exampleInputEmail1">Mã máy</label> 
						<form:input path="maMay" type="text"
							class="form-control" placeholder="Mã Máy" />
						<form:errors path="maMay" class="error"></form:errors>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Vị trí</label> 
						<form:input path="viTri" type="text"
							class="form-control" placeholder="Vị trí" />
						<form:errors path="viTri" class="error"></form:errors>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Trạng thái</label> 
						<form:input path="trangThai"
							type="text" class="form-control" placeholder="Trạng thái" />
						<form:errors path="trangThai" class="error"></form:errors>
					</div>
					<button type="submit" class="btn btn-secondary btn-block">Tạo
						mới</button>
				</form:form>
			</div>
		</div>
	</div>
	<!-- <script src="../jquery-3.7.1.min.js"></script>
	<script src="Validate.js"></script> -->
</body>
</html>
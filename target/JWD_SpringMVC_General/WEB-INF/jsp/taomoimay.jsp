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
</style>
</head>
<body>
	<div class="container mt-5" style="width: 600px;">
		<div class="card shadow-lg">
			<h5 class="card-header text-center">Tạo Mới Máy</h5>
			<div class="card-body">
				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">Mã máy</label> <input type="text"
							class="form-control" placeholder="Mã Máy">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Vị trí</label> <input type="text"
							class="form-control" placeholder="Vị trí">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Trạng thái</label> <input
							type="text" class="form-control" placeholder="Trạng thái">
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check
							me out</label>
					</div>
					<button type="submit" class="btn btn-secondary btn-block">Tạo
						mới</button>
				</form>
			</div>
		</div>
	</div>
	<script src="../jquery-3.7.1.min.js"></script>
	<script src="Validate.js"></script>
</body>
</html>
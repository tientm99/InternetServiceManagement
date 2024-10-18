<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dịch vụ internet</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<%-- <link
	href="<c:url value="/resources/bootstrap/fontawesome/css/all.min.css" />"
	rel="stylesheet"> --%>

</head>

<body>
	<div class="container-flui">
		<div class="footer">
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<!-- Thay đổi màu nav -->
				<a class="navbar-brand" href="#">Dịch vụ internet</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown1"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Máy </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown1">
								<a class="dropdown-item" href="formtaomoimay">Tạo máy
									mới</a> 
									<a class="dropdown-item" href="listmay">Danh
									sách máy</a> 
									<a class="dropdown-item" href="formsudungmay">Đăng
									ký sử dụng máy</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Dịch vụ </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown2">
								<a class="dropdown-item" href="formTaoMoiDV">Tạo dịch vụ</a> <a
									class="dropdown-item" href="listdichvu">Danh sách
									dịch vụ</a> <a class="dropdown-item" href="formDangkySDDV">Đăng
									ký sử dụng dịch vụ</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown3"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Khách hàng </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown3">
								<a class="dropdown-item" href="formtaomoiKH">Tạo khách
									hàng</a> <a class="dropdown-item" href="listkhachhang">Danh
									sách khách hàng</a> <a class="dropdown-item"
									href="listchitietsudung">Thông tin khách hàng
									đang sử dụng dịch vụ</a>
							</div></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	
	

	<!--   <script src="/jquery-3.7.1.min.js"></script> -->
	<!-- <script src="/resources/bootstrap/css/bootstrap.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/fontawesome/css/all.min.css" />"
	rel="stylesheet">
<style>
</style>
<body>
	<jsp:include page="../wellcome.jsp" />
	<div class="container-fluid">
		<div class="row border-bottom">
			<jsp:include page="../sidebar.jsp" />
			<div class="col-10 p-4">
				<div class="card shadow" style="width: 100%;">
					<div class="card-header">
						<h4 class="">Danh sách Khách hàng</h4>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<thead class="bg-info text-white">
								<tr>
									<th scope="col">Mã khách hàng</th>
									<th scope="col">Tên khách hàng</th>
									<th scope="col">Mã máy</th>
									<th scope="col">Vị trí</th>
									<th scope="col">Trạng thái</th>
									<th scope="col">Ngày bắt đầu sử dụng máy</th>
									<th scope="col">Giờ bắt đầu sử dụng máy</th>
									<th scope="col">Thời gian sử dụng máy</th>
									<th scope="col">Mã dịch vụ</th>
									<th scope="col">Ngày sử dụng dịch vụ</th>
									<th scope="col">Giờ sử dụng dịch vụ</th>
									<th scope="col">Số lượng</th>
									<th scope="col">Tổng tiền</th>
								</tr>
							</thead>
							<tbody class="bg-light">
								<c:forEach var="ctsd" items="${listCTSD}" varStatus="count">
									<tr>
										<td>${ctsd.maKH}</td>
										<td>${ctsd.tenKH}</td>
										<td>${ctsd.maMay}</td>
										<td>${ctsd.viTri}</td>
										<td>${ctsd.trangThai}</td>
										<td>${ctsd.ngayBatDauSD}</td>
										<td>${ctsd.gioBatDauSD}</td>
										<td>${ctsd.thoiGianSD}</td>
										<td>${ctsd.maDV}</td>
										<td>${ctsd.ngaySD}</td>
										<td>${ctsd.gioSD}</td>
										<td>${ctsd.soLuong}</td>
										<td>${ctsd.tongTien}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="btn pagination mt-4 d-block col-12"
						aria-label="Basic example">
						<c:if test="${currentPage > 1}">
							<a href="searchchitietsudung?tenkh=${tenKH }&page=${currentPage-1}">
								<button type="button" class="btn btn-primary border ">
									<i class="fa-solid fa-arrow-left"></i> Previous
								</button>
							</a>
						</c:if>
						<c:if test="${currentPage == 1}">
							<button type="button" class="btn border ">
								<i class="fa-solid fa-arrow-left"></i> Previous
							</button>
						</c:if>
						<c:forEach begin="1" end="${totalPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<a class="active">
										<button type="button" class="btn btn-primary border ">${i}</button>
									</a>
								</c:when>
								<c:otherwise>
									<a href="searchchitietsudung?tenkh=${tenKH }&page=${i}">
										<button type="button" class="btn border ">${i}</button>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${currentPage < totalPages}">
							<a href="searchchitietsudung?tenkh=${tenKH }&page=${currentPage+1}">
								<button type="button" class="btn btn-primary border ">
									Next <i class="fa-solid fa-arrow-right"></i>
								</button>
							</a>
						</c:if>
						<c:if test="${currentPage == totalPages}">
							<button type="button" class="btn border ">
								Next <i class="fa-solid fa-arrow-right"></i>
							</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
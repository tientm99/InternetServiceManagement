
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
				<div class="card shadow">
					<div class="card-header">
						<div class="row">
							<div class="col-8">
								<h2 class="text-center mt-2">Danh sách dịch vụ</h2>
							</div>
							<div class="col-4">
								<form class="form-inline mt-3 mb-3"
									action="${pageContext.request.contextPath}/searchdichvu"
									method="get">
									<input class="form-control mr-sm-2" name="tendichvu"
										type="text" placeholder="Search">
									<button class="btn btn-outline-dark my-2 my-sm-0" type="submit">
										<i class="fas fa-search"></i> Search
									</button>
								</form>
							</div>
						</div>
					</div>

					<div class="card-body">
						<table class="table table-bordered">
							<thead class="bg-info text-white">
								<tr>
									<th scope="col" class="col-2">Mã dịch vụ</th>
									<th scope="col" class="col-3">Tên dịch vụ</th>
									<th scope="col" class="col-2">Đơn vị tính</th>
									<th scope="col" class="col-2">Đơn giá</th>
									<th scope="col" class="col-3">Hoạt động</th>

								</tr>
							</thead>
							<tbody class="bg-light">
								<c:forEach var="dichvu" items="${listDV}" varStatus="count">
									<tr>
										<td>${dichvu.maDV}</td>
										<td>${dichvu.tenDV}</td>
										<td>${dichvu.donViTinh}</td>
										<td>${dichvu.donGia	}vnđ</td>
										<td><a href="updatedichvu/${dichvu.maDV}">
												<button class="btn btn-primary mr-3">
													<i class="fa-regular fa-pen-to-square"></i> Cập nhật
												</button>
										</a> <a class="text-danger" href="" data-toggle="modal"
											data-target="#exampleModal">
												<button class="btn btn-danger">
													<i class="fa-solid fa-trash"></i> Xóa
												</button>
										</a>
											<div class="modal fade" id="exampleModal" tabindex="-1"
												aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Xóa
																dịch vụ</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Bạn có chắc chắn muốn xóa?</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															<a href="deletedichvu?id=${dichvu.maDV}">
																<button type="button" class="btn btn-primary">Xóa</button>
															</a>
														</div>
													</div>
												</div>
											</div></td>
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
							<a href="searchdichvu?tendichvu=${tenDV }&page=${currentPage-1}">
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
									<a href="searchdichvu?tendichvu=${tenDV }&page=${i}">
										<button type="button" class="btn border ">${i}</button>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${currentPage < totalPages}">
							<a href="searchdichvu?tendichvu=${tenDV }&page=${currentPage+1}">
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
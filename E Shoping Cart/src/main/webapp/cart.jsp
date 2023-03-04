<%@page import="test.UserBean"%>
<%@page import="test.DBConnenction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
UserBean admin = (UserBean) request.getSession().getAttribute("admin");
if (admin != null) {
	request.setAttribute("admin", admin);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Cart Page</title>
<%@include file="include_Jsp_file/head.jsp"%>
<style type="text/css">
.table tbody td{
vertical-align middle;
}
.btn-incre, btn-decre{
box-shadow:none;
font-size:25px;
}
</style>

</head>
<body>
	<%@include file="include_Jsp_file/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: Rs 542</h3>
			<a class="mx-3 btn btn-primary" href="">Check Out</a>
		</div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Women Shoes</td>
					<td>Shoes</td>
					<td>500Rs</td>
					<td>
						<form action="" method="post" class="form-inline">
							<input type="hidden" name="id" value="1" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn btn-sm btn-incre" href=""><i
									class="fas fa-minus-square"></i></a> <input type="text"
									name="quantity" class="form-control" value="1" readonly>
								<a class="btn btn-sm btn-incre" href=""><i
									class="fas fa-plus-square"></i></a>
							</div>
						</form>
					</td>
					<td> <a class="btn btn btn-sm btn-danger "href="">Remove</a> </td>
				<tr>
			</tbody>
		</table>

	</div>


	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>
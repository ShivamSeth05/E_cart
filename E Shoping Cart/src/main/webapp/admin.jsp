<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="test.*"%>
<%@page import="test.UserBean"%>
<%@page import="test.DBConnenction"%>
<%
UserBean admin = (UserBean) request.getSession().getAttribute("admin");
if (admin != null) {
	request.setAttribute("admin", admin);
}

List<ProductBean> ls = new ProductDAO().getproduct();

ArrayList<CartBean> c_L = (ArrayList<CartBean>) session.getAttribute("cart-list");
if (c_L != null) {

	request.setAttribute("cart_list", c_L);
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="admin.jsp">Admin Page</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="admin.jsp">Dashboard</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Products</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Customers</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Settings</a>
				</li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="alogout">Log
						out</a></li>

			</ul>
		</div>
	</nav>
	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-3">
				<div class="card">
					<div class="card-header bg-primary text-white">Quick Links</div>
					<div class="card-body">
						<ul class="list-unstyled">
							<li><a href="addproduct.html">Add Product</a></li>
							<li><a href="#">View Orders</a></li>
							<li><a href="#">View Customers</a></li>
							<li><a href="alogout">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="container card">
					<div class="card-header my-3">All Products</div>
					<div class="row">

						<%
						if (!ls.isEmpty()) {
							for (ProductBean p : ls) {
						%>
						<div class="col-md-3 my-3 ">
							<div class="card " style="width: 18rem;">
								<img src="productImage/<%=p.getImage()%>" class="card-img-top"
									alt="...">
								<div class="card-body">
									<h6 class="card-title"><%=p.getName()%></h6>
									<h6 class="price">
										Price:Rs
										<%=p.getPrice()%></h6>
									<h6 class="category">
										"Category:
										<%=p.getCategory()%></h6>
									<div class="mt-3 d-flex justify-content-between">
										<a href="remove-from-pro?id=<%=p.getId()%>" class="btn btn-dark">
										Delete</a> 
									</div>
								</div>
							</div>
						</div>
						<%
						}
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

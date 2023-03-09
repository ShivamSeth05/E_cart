<%@page import="java.util.*"%>
<%@page import="test.*"%>
<%@page import="test.UserBean"%>
<%@page import="test.DBConnenction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<html>
<head>
<title>Welcome to Shopping Cart</title>
<%@include file="include_Jsp_file/head.jsp"%>
<style>
@import
	url('https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css')
	;

.btn:hover {
	color: var(- -bs-btn-hover-color);
	background-color: #e70016;
}

.btn-primary { -
	    --bs-btn-color: #fff;
    --bs-btn-bg: #005930;
}
</style>

</head>
<body>
	<%@include file="include_Jsp_file/navbar.jsp"%>
		<div class="container card p-1 my-1 bg-danger ">
			<!-- Carousel -->
			<div id="demo" class="carousel slide" data-bs-ride="carousel">

				<!-- Indicators/dots -->
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
						class="active"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
				</div>

				<!-- The slideshow/carousel -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="productImage/Slide1.jpg" alt="Los Angeles"
							class="d-block" style="width: 100%;height:300px">
						<div class="carousel-caption">
							<h3>Los Angeles</h3>
							<p>We had such a great time in LA!</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="productImage/Slide2.jpg" alt="Chicago" class="d-block"
							style="width: 100%;height:300px">
						<div class="carousel-caption">
							<h3>Chicago</h3>
							<p>Thank you, Chicago!</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="productImage/Slide3.jpg" alt="New York" class="d-block"
							style="width: 100% ;height:300px">
						<div class="carousel-caption">
							<h3>New York</h3>
							<p>We love the Big Apple!</p>
						</div>
					</div>
				</div>

				<!-- Left and right controls/icons -->
				<button class="carousel-control-prev" type="button"
					data-bs-target="#demo" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#demo" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
		</div>
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
							<a href="add-to-cart?id=<%=p.getId()%>" class="btn btn-dark">Add
								to cart</a> <a href="order-now?quantity=1&id=<%=p.getId()%>"
								class="btn btn-primary">Buy Now</a>
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

	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>
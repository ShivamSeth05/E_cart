<%@page import="java.util.List"%>
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
%>
<!DOCTYPE html>
<html>  
<head>
<title>Welcome to Shopping Cart</title>
<%@include file="include_Jsp_file/head.jsp"%>
</head>
<body>
	<%@include file="include_Jsp_file/navbar.jsp"%>
	<div class="container card">
		<div class="card-header my-3">All Products</div>
		<div class="row">
		
		<%
			if(!ls.isEmpty()){
				for(ProductBean p:ls){%>
					<div class="col-md-3 my-3">
					<div class="card" style="width: 18rem;">
						<img src="productImage/<%=p.getImage() %>" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h6 class="card-title"><%=p.getName() %></h6>
							<h6 class="price">Price:Rs <%=p.getPrice() %></h6>
							<h6 class="category">"Category: <%=p.getCategory() %></h6>
							<div class="mt-3 d-flex justify-content-between">
								<a href="#" class="btn btn-dark">Add to cart</a> <a href="#"
									class="btn btn-primary">Buy Now</a>
							</div>
						</div>
					</div>
				</div>
				<%}
			}
		
		%>
		
		

		</div>
	</div>

	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>
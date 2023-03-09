<%@page import="java.text.DecimalFormat"%>
<%@page import="test.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="test.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.UserBean"%>
<%@page import="test.DBConnenction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

UserBean admin = (UserBean) request.getSession().getAttribute("admin");
if (admin != null) {
	request.setAttribute("admin", admin);
}

ArrayList<CartBean> c_L = (ArrayList<CartBean>) session.getAttribute("cart-list");
List<CartBean> cb = null;
if (c_L != null) {
	cb = new ProductDAO().getCartProducts(c_L);
	double total = new ProductDAO().getTotalCartPrice(c_L);
	request.setAttribute("cart_list", c_L);
	request.setAttribute("total", total);
}

int p = 0;
%>
<!DOCTYPE html>
<html>
<head>
<title>Cart Page</title>
<%@include file="include_Jsp_file/head.jsp"%>
<style type="text/css">
.table tbody td {vertical-align middle;
	
}

.btn-incre, btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>

</head>
<body>
	<%@include file="include_Jsp_file/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price &#8377; : ${ (total>0)?dcf.format(total):0 }</h3>

		</div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (c_L != null) {
					for (CartBean c : cb) {
						p = c.getId();
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%=dcf.format(c.getPrice())%>&#8377;</td>
					<td>
						<form action="order-now" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=c.getId()%>"
								class="form-input">
							<div class="form-group d-flex justify-content-between w-50">
								<a class="btn btn-sm btn-incre"
									href="quantity-Incr-Decr?action=dec&id=<%=c.getId()%>"> <i
									class="fas fa-minus-square"></i>
								</a> <input type="text" name="quantity" class="form-control"
									value="<%=c.getQuantity()%>" readonly> <a
									class="btn btn-sm btn-incre"
									href="quantity-Incr-Decr?action=inc&id=<%=c.getId()%>"> <i
									class="fas fa-plus-square"></i>
								</a>
								<button type="submit" class="btn btn-primary btn-sm">Buy</button>
							</div>
							<div></div>

						</form>

					</td>
					<td><a class="btn btn btn-sm btn-danger "
						href="remove-from-cart?id=<%=c.getId()%>">Remove</a></td>
				<tr>
					<%
					}
					}
					%>
				
			</tbody>
		</table>

	</div>
	<div class="container mx-10">

		<form  action="order-details?p=<%=p%>" method="post">
			<div class="form-group">
				<label for="exampleFormControlInput1">Name</label> <input
					type="text" class="form-control" name="name" placeholder="FullName">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Email</label> <input
					type="email" class="form-control" name="email" placeholder="Email"
					required>
			</div>

			<div class="form-group">
				<label for="exampleFormControlSelect1">Payment</label> <select
					class="form-control " name="cpayment">
					<option>COD</option>
					<option>UPI</option>
					<option>CARD</option>
					<option>EMI</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Address</label>
				<textarea class="form-control" rows="3" name="caddress" required></textarea>
			</div>
			<br>
			<div class="text-center">

				<div>
					<button class="btn btn-info text-white">Sumbit	Address</button>
				</div>
			</div>
			<br>
		</form>

	</div>

	<script>
		
	</script>

	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>
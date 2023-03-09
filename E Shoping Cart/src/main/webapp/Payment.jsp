<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="test.CartBean"%>
<%@page import="test.UserBean"%>
<%@page import="java.util.*"%>
<%@page import="test.ProductDAO"%>
<%@page import="java.text.DecimalFormat"%>

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

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<div class="container py-5">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<div class="card">
					<div class="card-header">
						<h4 class="mb-0">Payment Details</h4>
						<h3>Total Price &#8377; : ${ (total>0)?dcf.format(total):0 }</h3>
					</div>
					<div class="card-body">
						<form action="orders.jsp" method="post">
							<div class="form-group">
								<label for="cardNumber">Card number</label> <input type="text"
									class="form-control" id="cardNumber"
									placeholder="Enter card number">
							</div>
							<div class="form-group">
								<label for="cardName">Name on card</label> <input type="text"
									class="form-control" id="cardName"
									placeholder="Enter name on card">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="expiryDate">Expiry date</label> <input type="text"
										class="form-control" id="expiryDate" placeholder="MM/YY">
								</div>
								<div class="form-group col-md-6">
									<label for="cvv">CVV</label> <input type="text"
										class="form-control" id="cvv" placeholder="Enter CVV" required>
								</div>
							</div>
							<div class="form-group">
								<label for="amount">Amount</label> 									
									<input type="text" name="quantity" class="form-control"
									value="${ (total>0)?dcf.format(total):0 }" readonly> 
							</div>
							<div class="text-center">
								<a class="mx-3 btn btn-primary" href="cart-check-out">Check
									Out</a>

							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
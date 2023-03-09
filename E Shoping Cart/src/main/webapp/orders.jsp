<%@page import="admin.AdminBean"%>
<%@page import="test.OrderBean"%>
<%@page import="test.OrderDAO"%>
<%@page import="test.UserBean"%>
<%@page import="test.DBConnenction" import="test.CartBean"
	import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.text.DecimalFormat"%>
<%
DecimalFormat dcf=new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
List<OrderBean> orderL=null;

UserBean admin = (UserBean) request.getSession().getAttribute("admin");
AdminBean admins = (AdminBean) request.getSession().getAttribute("admins");
if (admin != null||admins!=null) {
	request.setAttribute("admin", admin);
	 orderL=new OrderDAO().userOrders(admin.getId());
	
} else {
	response.sendRedirect("login.jsp");
}
ArrayList<CartBean> c_L = (ArrayList<CartBean>) session.getAttribute("cart-list");
if (c_L != null) {

	request.setAttribute("cart_list", c_L);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<%@include file="include_Jsp_file/head.jsp"%>
</head>
<body>
	<%@include file="include_Jsp_file/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			<%
			
			if(orderL!=null){
				for(OrderBean o:orderL){%>
				<tr>
					<td><%=o.getDate() %> </td>
					<td><%=o.getName() %> </td>
					<td><%=o.getCategory() %> </td>
					<td><%=o.getQuantity() %> </td>
					<td><%= dcf.format(o.getPrice()) %> </td>
					<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>"> Cancel </a>
					</td>
				</tr>
				<%  }
			}
			%>
			</tbody>
		</table>

	</div>


	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>
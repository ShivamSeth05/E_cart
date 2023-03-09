<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="test.UserBean"
	import="test.CartBean"
	import="java.util.*"%>
	
	<%
UserBean admin = (UserBean) request.getSession().getAttribute("admin");
if (admin != null) {
	response.sendRedirect("index.jsp");
}

%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<%@include file="include_Jsp_file/head.jsp"%>
</head>
<body>
<%@include file="include_Jsp_file/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User SignIn</div>
			<div class="card-body ">

				<form action="user-sign" method="post">

					<div class="form-group">
					<label>Full Name</label> <input type="text"
							class="form-control" name="uname"
							placeholder="Enter your Full Name" required>
					</div>
					<div class="form-group">
						<label>Email address</label> <input type="email"
							class="form-control" name="ulogin-email"
							placeholder="Enter your Email" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="ulogin-pass" placeholder="***********"
							required>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="ulogin-pass" placeholder="Re-Enter Password"
							required>
					</div>

					<div class="text-center">
					<br>
						<button type="submit" class="btn btn-primary">SignIn</button>
						<a href="login.jsp"  class="btn btn-primary">LogIn</a> 
					</div>
				</form>

			</div>
		</div>
	</div>

	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>
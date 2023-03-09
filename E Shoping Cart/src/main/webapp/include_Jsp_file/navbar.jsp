<style>
@import
	url('https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css')
	;

#head {
	background: #000000;
}

* {
	font-family: Arial, Helvetica, sans-serif;
}


</style>


<nav class="navbar navbar-expand-sm navbar-dark " id="head">
	<div class="container-fluid">
	 <a class="navbar-brand" href="#">
	 
    <img src="productImage/logo.png" width="60" height="30" alt="eCart Logo">
  </a>
		<a class="navbar-brand" href="index.jsp"> E-Shopping </a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#mynavbar"></button>
		<div class="collapse navbar-collapse " id="mynavbar">
			<ul class="navbar-nav me-auto ">

				<li class="nav-item"><a class="nav-link " href="index.jsp">
						Home </a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">
						Cart <span class=" badge rounded-pill bg-danger px-1">${cart_list.size()}
					</span>
					
				</a></li>
				
				<%
				if (admin != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp">LogIn</a></li>
				<li class="nav-item"><a class="nav-link" href="signUp.jsp">SignIn</a></li>
				<li class="nav-item"><a class="nav-link" href="adminLogin.jsp">Admin LogIn</a></li>
				<%
				}
				%>
				<li class="nav-item"><a class="nav-link" href="contact.html">Contact Us</a></li>
				<li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>

			</ul>
			<form action="https://www.google.com/search" method="get">
				<div class="input-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search Google">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</nav>
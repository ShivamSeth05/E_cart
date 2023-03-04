<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> E-Shopping </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#mynavbar">
				
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link"
						href="cart.jsp">Cart</a></li>
						<%
						if(admin!=null){%>
							<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
							<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
						<%}else{%>
							<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
						<%}
						%>
					
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="text" placeholder="Search">
					<button class="btn btn-primary" type="button">Search</button>
				</form>
			</div>
		</div>
	</nav>
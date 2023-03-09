
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<%@include file="include_Jsp_file/head.jsp"%>
<style>
nav {
  background-color: #333;
  display: flex;
  justify-content: center;
}

ul {
  list-style: none;
  display: flex;
}

li {
  margin: 0 10px;
}

a {
  color: #fff;
  text-decoration: none;
  padding: 10px;
  display: block;
}


</style>
</head>
<body>
	<nav>
  <ul>
    <li><a href="index.jsp">Home</a></li>
    <li><a href="about.jsp">About Us</a></li>
    <li><a href="#">Services</a></li>
    <li><a href="contact.html">Contact Us</a></li>
  </ul>
</nav>
	

  <div class="container my-5">
    <h1>About E Cart</h1>
    <p class="lead">E Cart is a leading manufacturer of electric vehicles, founded in 2010 with the goal of making electric cars more accessible to the general public. Our mission is to create high-quality, affordable electric cars that are better for the environment and more convenient for our customers.</p>
    <h2>Our History</h2>
    <p>E Cart was founded by a group of engineers who were passionate about sustainable transportation. They believed that electric cars were the future of transportation and wanted to make them accessible to everyone. Since then, E Cart has grown into a global company with over 1,000 employees and a presence in over 20 countries.</p>
    <h2>Our Technology</h2>
    <p>At E Cart, we use the latest technology to create electric cars that are efficient, reliable, and fun to drive. Our vehicles are powered by advanced lithium-ion batteries that provide long-range driving capabilities and fast charging times. We also use regenerative braking technology to capture energy that would otherwise be lost during braking, further improving the efficiency of our vehicles.</p>
    <h2>Our Team</h2>
    <p>Our team is made up of passionate individuals who are dedicated to creating the best electric cars in the world. From our engineers to our sales staff, everyone at E Cart is committed to making sustainable transportation a reality for everyone.</p>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



	<%@include file="include_Jsp_file/footer.jsp"%>
</body>
</html>

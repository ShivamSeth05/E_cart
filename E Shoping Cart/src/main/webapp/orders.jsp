<%@page import="test.UserBean"%>
<%@page import="test.DBConnenction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
UserBean admin = (UserBean) request.getSession().getAttribute("admin");
if (admin != null) {
	request.setAttribute("admin", admin);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<%@include file="include_Jsp_file/head.jsp" %>
</head>
<body>
<%@include file="include_Jsp_file/navbar.jsp"%>

<%@include file="include_Jsp_file/footer.jsp" %>
</body>
</html>
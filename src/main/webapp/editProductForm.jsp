<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.project.dao.ProductDaoImpl"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Edit Form</title>
</head>
<body>
<c:import url="menu.jsp"></c:import>
<%
String id=request.getParameter("id");
ProductDao service = new ProductDaoImpl();
Product p=service.getProductById(Integer.parseInt(id));
%>
<%=p %>

<h1>Edit Product Form</h1>
<form action="editproduct.jsp" method="post">
<input type="hidden" name="id" value="<%=p.getId() %>"/>
<table>

<tr>
	<td>Product Name:</td>
	<td><input type="text" name="productName" value="<%= p.getProductName()%>"/></td>
</tr>
<tr>
	<td>Price:</td>
	<td><input type="text" name="price"  value="<%= p.getPrice()%>"/></td>
</tr>
<tr>
	<td>Stock Quantity:</td>
	<td><input type="text" name="quantityInStock" value="<%=  p.getQuantityInStock()%>"/></td>
</tr>
<tr>
	<td>Vendor:</td>
	<td><input type="text" name="vendor" value="<%=  p.getVendor()%>"/></td>
</tr>
<tr>
	<td>Warranty:</td>
	<td><input type="text" name="waranty" value="<%=p.getWaranty()%>"/></td>
</tr>
<tr>
	<td>Country:</td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Edit Product"/></td>
</tr>
</table>
</form>

</body>
</html>
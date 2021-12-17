<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="menu.jsp"></c:import>
<form action="addProduct.jsp" method="post">
<table>

<tr>
	<td>Product Name:</td>
	<td><input type="text" name="productName" placeholder="Product Name"/></td>
</tr>
<tr>
	<td>Price:</td>
	<td><input type="text" name="price" placeholder="Price"/></td>
</tr>
<tr>
	<td>Stock Quantity:</td>
	<td><input type="text" name="quantityInStock" placeholder="Quantity In Stock"/></td>
</tr>
<tr>
	<td>Vendor:</td>
	<td><input type="text" name="vendor" placeholder="Vendor"/></td>
</tr>
<tr>
	<td>Warranty:</td>
	<td><input type="text" name="waranty" placeholder="Warranty"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Add Product"/></td>
</tr>
</table>
</form>
</body>
</html>
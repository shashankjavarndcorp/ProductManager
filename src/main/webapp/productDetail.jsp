<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.project.dao.ProductDaoImpl"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>
<c:import url="menu.jsp"></c:import>

<h1>Product Details</h1>

<h3>Welcome ${sessionScope.user.firstName}</h3>


<%
ProductDao service = new ProductDaoImpl();
List<Product> list=service.getAllProducts();
request.setAttribute("list",list);
%>
<table border="1">
<tr>
<td>id</td>
<td>Product Name</td>
<td>Price</td>
<td>Quantity In Stock</td>
<td>Vendor</td>
<td>Warranty</td>
<td>EditAction</td>
<td>DeleteAction</td>
</tr>


<c:forEach items="${list}" var="product">
    <tr>      
        <td>${product.getId()}</td>
        <td>${product.getProductName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getQuantityInStock()}</td>
        <td>${product.getVendor()}</td>  
        <td>${product.getWaranty()}</td> 
       	<td><a href="editProductForm.jsp?id=${product.getId()}">Edit</a></td>
       	<td><a href="deleteproduct.jsp?id=${product.getId()}">Delete</a></td>
    </tr>
</c:forEach>

</table>
</body>
</html>
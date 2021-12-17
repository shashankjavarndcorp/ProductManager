<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.dao.ProductDaoImpl"%>
<jsp:useBean id="p" class="com.project.model.Product"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
ProductDao product = new ProductDaoImpl();
product.delete(p.getId());
response.sendRedirect("productDetail.jsp");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.project.dao.ProductDaoImpl"%>
<%@page import="com.project.dao.ProductDao"%>
<%@page import="com.project.model.Product"%>
<%@page import="java.util.*"%>

<jsp:useBean id="p" class="com.project.model.Product"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
ProductDao service = new ProductDaoImpl();
service.save(p);
response.sendRedirect("productDetail.jsp");
%>
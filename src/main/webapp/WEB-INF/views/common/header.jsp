<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<head>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<div class="topmenu-container">
    <a onclick="location.href='/loginForm'"><img src="/resources/images/home/logout.png" class="menu" alt="menu"></a>
    <a onclick="location.href='/main'"><img src="/resources/images/home/meari-logo.png" class="meari-logo" alt="meari-logo"></a>
   
</div>
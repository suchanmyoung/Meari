<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--<title>명수찬 바보</title>  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title><tiles:insertAttribute name="title" /></title>
</head>

<body>
<div id="container">
      <div id="content">
          <tiles:insertAttribute name="body" ignore="true"/>
      </div>
    </div>
</body>
</html>


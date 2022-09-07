<%@page import="DB.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	%>
</body>
<script>
	navigator.geolocation.getCurrentPosition(function(pos) {
	    	var latitude = pos.coords.latitude;
	    	var longitude = pos.coords.longitude;
	    	alert("현재 위치는 : " + latitude + ", "+ longitude);
	});

</script>
</html> 
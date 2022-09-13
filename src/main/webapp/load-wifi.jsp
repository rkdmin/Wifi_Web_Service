<%@page import="DB.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/index.css">
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
		OpenApi.openWifiApi(1, 1);
		int cnt = DB.getTotalCnt();
	%>
	
	<h2><%=cnt %>개의 WIFI 정보를 정상적으로 저장하였습니다.</h2>
	<a href="index.jsp">홈으로 가기</a>
</body>
</html>
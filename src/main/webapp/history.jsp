<%@page import="DB.*, java.util.*, java.util.Date, java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/rs.css">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<h2>와이파이 정보 구하기</h2>
	<a href = "index.jsp">홈</a> |
	<a href="history.jsp">위치 히스토리 목록</a> |
	<a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
	</br></br>
	
	
	<%
		// 만약에 삭제할 id 값이 있다면 삭제 
		if(request.getParameter("id") != null){
			ArrayList mapList = new ArrayList();
			int id = Integer.parseInt(request.getParameter("id"));
			
			// db에서 delete
			DB.deleteHistory(id);
		}
		
		// 가져오기
		ArrayList<History> historys;
		historys = DB.getHistoryList();
	%>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>조회일자</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			
			<%
				for(History history: historys){
			%>	<tr>
					<td><%=history.getHistoryId()%></td>
					<td><%=history.getLat()%></td>
					<td><%=history.getLnt()%></td>
					<td><%=history.getInqueryDate()%></td>
					<form action="history.jsp">
						<input type="hidden" value="<%=history.getHistoryId()%>" name="id">
						<td><input type="submit" value="삭제"></td>
					</form>
					
				</tr>
			<%
				}
			%>
			
		</tbody>
	</table>
</body>
<script>
</script>
</html>
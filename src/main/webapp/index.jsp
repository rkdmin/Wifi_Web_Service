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
		double lat = 0.0;
		double lnt = 0.0;
		String date = null;
		
		
		// 만약에 lat, lnt, date 값이 들어있다면 내 위치 history db에 넣어줌 
		if(request.getParameter("lat") != null && request.getParameter("lnt") != null && request.getParameter("date") != null){
			lat = Double.parseDouble(request.getParameter("lat"));
			lnt = Double.parseDouble(request.getParameter("lnt"));
			date = request.getParameter("date");
			
			// history 객체 생성
			History history = new History(lat, lnt, date);
		
			// db에 insert
			DB.insertHistory(history);
		}
	
		
	%>
	<form action="index.jsp" method="get" name="locationForm">
		LAT: <input type="text" value="<%=lat%>" id="lat" name="lat">,
		LNT: <input type="text" value="<%=lnt%>" id="lnt" name="lnt">
		<input type="hidden" value="<%=date%>" id="date" name="date">
		<input type="button" value="내 위치 가져오기" onClick="askForCoords()">
	</form>
	
	<button>근처 WIPI정보 보기</button>
	</br></br>
	
	<table>
		<thead>
			<tr>
				<th>거리(Km)</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외구분</th>
				<th>WIFI접속환경</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
		</thead>
		<tbody>
			<td colspan='17'>위치 정보를 입력한 후에 조회해 주세요.</td>
		</tbody>
	</table>
</body>
<script>
function askForCoords() {
	  navigator.geolocation.getCurrentPosition(getLocation, handleGeoError);
}
	
function handleGeoError() {
	  console.log("Can't access geo location");
}
function getLocation(position) {
	
    const latElement = document.getElementById('lat');
    const lntElement = document.getElementById('lnt');
    const dateElement = document.getElementById('date');
    const locationForm = document.locationForm;
    
    const lat = position.coords.latitude;
    const lnt = position.coords.longitude;
    
    // 위치 정보 value 변경
    latElement.value = lat;
    lntElement.value = lnt;
    
    // 현재 시간 value 변경
    <%
    	Date now = new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String nowStr = formatter.format(now);
    	System.out.println(nowStr);
    %>
    dateElement.value = "<%=nowStr%>";
	
    // submit(나중에 submit을 해야 데이터가 잘 넘어가짐)
    locationForm.submit();
    
}
</script>
</html>
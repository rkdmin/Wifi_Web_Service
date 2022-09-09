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
	<a>위치 히스토리 목록</a> |
	<a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
	</br></br>
	
	
	LAT: <input type="text" value="0.0" id="lat">,
	LNT: <input type="text" value="0.0" id="lnt">
	<button onClick="askForCoords()">내 위치 가져오기</button>
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
    
    const lat = position.coords.latitude;
    const lnt = position.coords.longitude;
    
    // 위치 정보 value 변경
    latElement.value = lat;
    lntElement.value = lnt;
    
    // 위치 정보 히스토리 삽입
    <%
    	
    %>
}
</script>
</html>
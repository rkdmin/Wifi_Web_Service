# Wifi_Web_Service

### 서울시 공공 와이파이 API를 사용하여 자신과 가까운 거리의 와이파이를 찾는 서비스

### -DB폴더-    
DB.java -> DB와 연결시키고, 쿼리를 동작하는 메소드들이 담겨있음    
OpenApi.java -> API를 가져오기 위한 메소드들이 담겨있음   
History.java -> 내 위치를 가져올 때 필요한 객체   
WifiDistance.java -> 거리가 포함 된 Wifi 객체   
나머지 클래스 파일들은 API를 불러오기 위한 객체    

### -jsp파일-   
index.jsp 기본 화면    
load-wifi.jsp wifi를 불러오고 난 후의 화면   
history.jsp 위치를 가져올 때 저장된 history를 보여주는 화면    

package DB;

public class Wifi {
	public String X_SWIFI_MGR_NO;// 관리번호
	public String X_SWIFI_WRDOFC;// 자치구
	public String X_SWIFI_MAIN_NM;// 와이파이명
	public String X_SWIFI_ADRES1;// 도로명 주소
	public String X_SWIFI_ADRES2;// 상세주소
	public String X_SWIFI_INSTL_FLOOR;// 설치위치(층)
	public String X_SWIFI_INSTL_TY;// 설치유형
	public String X_SWIFI_INSTL_MBY;// 설치기관
	public String X_SWIFI_SVC_SE;// 서비스구분
	public String X_SWIFI_CMCWR;// 망종류
	public int X_SWIFI_CNSTC_YEAR;// 설치년도
	public String X_SWIFI_INOUT_DOOR;// 실내외구분
	public String X_SWIFI_REMARS3;// WIFI접속환경
	public Double LAT;// x좌표
	public Double LNT;// y좌표
	public String WORK_DTTM;// 작업일자
	
	@Override
	public String toString() {
		return "Wifi [X_SWIFI_MGR_NO=" + X_SWIFI_MGR_NO + ", X_SWIFI_WRDOFC=" + X_SWIFI_WRDOFC + ", X_SWIFI_MAIN_NM="
				+ X_SWIFI_MAIN_NM + ", X_SWIFI_ADRES1=" + X_SWIFI_ADRES1 + ", X_SWIFI_ADRES2=" + X_SWIFI_ADRES2
				+ ", X_SWIFI_INSTL_FLOOR=" + X_SWIFI_INSTL_FLOOR + ", X_SWIFI_INSTL_TY=" + X_SWIFI_INSTL_TY
				+ ", X_SWIFI_INSTL_MBY=" + X_SWIFI_INSTL_MBY + ", X_SWIFI_SVC_SE=" + X_SWIFI_SVC_SE + ", X_SWIFI_CMCWR="
				+ X_SWIFI_CMCWR + ", X_SWIFI_CNSTC_YEAR=" + X_SWIFI_CNSTC_YEAR + ", X_SWIFI_INOUT_DOOR="
				+ X_SWIFI_INOUT_DOOR + ", X_SWIFI_REMARS3=" + X_SWIFI_REMARS3 + ", LAT=" + LAT + ", LNT=" + LNT
				+ ", WORK_DTTM=" + WORK_DTTM + "]";
	}
	
}
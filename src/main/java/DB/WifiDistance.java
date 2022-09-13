package DB;

public class WifiDistance {
	private double distance;// 거리
	private String X_SWIFI_MGR_NO;// 관리번호
	private String X_SWIFI_WRDOFC;// 자치구
	private String X_SWIFI_MAIN_NM;// 와이파이명
	private String X_SWIFI_ADRES1;// 도로명 주소
	private String X_SWIFI_ADRES2;// 상세주소
	private String X_SWIFI_INSTL_FLOOR;// 설치위치(층)
	private String X_SWIFI_INSTL_TY;// 설치유형
	private String X_SWIFI_INSTL_MBY;// 설치기관
	private String X_SWIFI_SVC_SE;// 서비스구분
	private String X_SWIFI_CMCWR;// 망종류
	private String X_SWIFI_CNSTC_YEAR;// 설치년도
	private String X_SWIFI_INOUT_DOOR;// 실내외구분
	private String X_SWIFI_REMARS3;// WIFI접속환경
	private Double LAT;// x좌표
	private Double LNT;// y좌표
	private String WORK_DTTM;// 작업일자
	
	
	public WifiDistance(double distance, String x_SWIFI_MGR_NO, String x_SWIFI_WRDOFC, String x_SWIFI_MAIN_NM, String x_SWIFI_ADRES1,
			String x_SWIFI_ADRES2, String x_SWIFI_INSTL_FLOOR, String x_SWIFI_INSTL_TY, String x_SWIFI_INSTL_MBY,
			String x_SWIFI_SVC_SE, String x_SWIFI_CMCWR, String x_SWIFI_CNSTC_YEAR, String x_SWIFI_INOUT_DOOR,
			String x_SWIFI_REMARS3, Double lAT, Double lNT, String wORK_DTTM) {
		super();
		this.distance = distance;
		X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
		X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
		X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
		X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
		X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
		X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
		X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
		X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
		X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
		X_SWIFI_CMCWR = x_SWIFI_CMCWR;
		X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
		X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
		X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
		LAT = lAT;
		LNT = lNT;
		WORK_DTTM = wORK_DTTM;
	}


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
	
	
	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public String getX_SWIFI_MGR_NO() {
		return X_SWIFI_MGR_NO;
	}

	public void setX_SWIFI_MGR_NO(String x_SWIFI_MGR_NO) {
		X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
	}

	public String getX_SWIFI_WRDOFC() {
		return X_SWIFI_WRDOFC;
	}

	public void setX_SWIFI_WRDOFC(String x_SWIFI_WRDOFC) {
		X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
	}

	public String getX_SWIFI_MAIN_NM() {
		return X_SWIFI_MAIN_NM;
	}

	public void setX_SWIFI_MAIN_NM(String x_SWIFI_MAIN_NM) {
		X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
	}

	public String getX_SWIFI_ADRES1() {
		return X_SWIFI_ADRES1;
	}

	public void setX_SWIFI_ADRES1(String x_SWIFI_ADRES1) {
		X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
	}

	public String getX_SWIFI_ADRES2() {
		return X_SWIFI_ADRES2;
	}

	public void setX_SWIFI_ADRES2(String x_SWIFI_ADRES2) {
		X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
	}

	public String getX_SWIFI_INSTL_FLOOR() {
		return X_SWIFI_INSTL_FLOOR;
	}

	public void setX_SWIFI_INSTL_FLOOR(String x_SWIFI_INSTL_FLOOR) {
		X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
	}

	public String getX_SWIFI_INSTL_TY() {
		return X_SWIFI_INSTL_TY;
	}

	public void setX_SWIFI_INSTL_TY(String x_SWIFI_INSTL_TY) {
		X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
	}

	public String getX_SWIFI_INSTL_MBY() {
		return X_SWIFI_INSTL_MBY;
	}

	public void setX_SWIFI_INSTL_MBY(String x_SWIFI_INSTL_MBY) {
		X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
	}

	public String getX_SWIFI_SVC_SE() {
		return X_SWIFI_SVC_SE;
	}

	public void setX_SWIFI_SVC_SE(String x_SWIFI_SVC_SE) {
		X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
	}

	public String getX_SWIFI_CMCWR() {
		return X_SWIFI_CMCWR;
	}

	public void setX_SWIFI_CMCWR(String x_SWIFI_CMCWR) {
		X_SWIFI_CMCWR = x_SWIFI_CMCWR;
	}

	public String getX_SWIFI_CNSTC_YEAR() {
		return X_SWIFI_CNSTC_YEAR;
	}

	public void setX_SWIFI_CNSTC_YEAR(String x_SWIFI_CNSTC_YEAR) {
		X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
	}

	public String getX_SWIFI_INOUT_DOOR() {
		return X_SWIFI_INOUT_DOOR;
	}

	public void setX_SWIFI_INOUT_DOOR(String x_SWIFI_INOUT_DOOR) {
		X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
	}

	public String getX_SWIFI_REMARS3() {
		return X_SWIFI_REMARS3;
	}

	public void setX_SWIFI_REMARS3(String x_SWIFI_REMARS3) {
		X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
	}

	public Double getLAT() {
		return LAT;
	}

	public void setLAT(Double lAT) {
		LAT = lAT;
	}

	public Double getLNT() {
		return LNT;
	}

	public void setLNT(Double lNT) {
		LNT = lNT;
	}

	public String getWORK_DTTM() {
		return WORK_DTTM;
	}

	public void setWORK_DTTM(String wORK_DTTM) {
		WORK_DTTM = wORK_DTTM;
	}
}
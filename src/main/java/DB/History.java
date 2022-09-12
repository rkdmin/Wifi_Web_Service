package DB;

public class History {
	private int historyId;
	private double lat;
	private double lnt;
	private String inqueryDate;
	
	public History(int id, double lat, double lnt, String inqueryDate) {
		super();
		this.historyId = id;
		this.lat = lat;
		this.lnt = lnt;
		this.inqueryDate = inqueryDate;
	}
	
	public History(double lat, double lnt, String inqueryDate) {
		super();
		this.lat = lat;
		this.lnt = lnt;
		this.inqueryDate = inqueryDate;
	}


	public int getHistoryId() {
		return historyId;
	}


	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLnt() {
		return lnt;
	}


	public void setLnt(double lnt) {
		this.lnt = lnt;
	}


	public String getInqueryDate() {
		return inqueryDate;
	}


	public void setInqueryDate(String inqueryDate) {
		this.inqueryDate = inqueryDate;
	}
	
	
}

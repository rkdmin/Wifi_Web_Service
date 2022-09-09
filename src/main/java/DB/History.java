package DB;

import java.sql.Date;

public class History {
	private int historyId;
	private double lat;
	private double lnt;
	Date inqueryDate;
	
	
	public History(int historyId, double lat, double lnt, Date inqueryDate) {
		super();
		this.historyId = historyId;
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


	public Date getInqueryDate() {
		return inqueryDate;
	}


	public void setInqueryDate(Date inqueryDate) {
		this.inqueryDate = inqueryDate;
	}
	
	
}

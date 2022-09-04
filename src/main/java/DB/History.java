package DB;

import java.time.LocalDate;

public class History {
	private int historyId;
	private double lat;
	private double lnt;
	private LocalDate inqueryDate;
	
	
	public History(int historyId, double lat, double lnt, LocalDate inqueryDate) {
		super();
		this.historyId = historyId;
		this.lat = lat;
		this.lnt = lnt;
		this.inqueryDate = inqueryDate;
	}
	
	
}

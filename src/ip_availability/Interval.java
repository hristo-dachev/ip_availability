package ip_availability;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Interval {
	
	private Date from, to;
	private static final String FORMAT = "yyyy-­MM-dd'T'HH'_'mm'_'ss.SSSZ";
	
	public Interval(Date input) {
		this.from = input;
	}
	
	public void setOut(Date input) {
		this.to = input;
	}
	
	public String from() {
		return new SimpleDateFormat(FORMAT).format(from);
	}
	
	public String to() {
		if (this.to != null) return new SimpleDateFormat(FORMAT).format(this.to);
		else return null;
	}
}

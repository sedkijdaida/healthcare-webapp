package tn.rnu.healthcare.web.data.binder;


public class MailData {
	private int index, size;
	private String subject, date;
	
	public MailData(int index, String subject, String date, int size) {
		this.index = index;
		this.subject = subject;
		this.date = date;
		this.size = size;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}

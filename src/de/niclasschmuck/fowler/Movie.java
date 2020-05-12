package de.niclasschmuck.fowler;

public class Movie {
	private String title;
	private int priceCode;

	public Movie(String newtitle, int newpriceCode) {
		this.title = newtitle;
		this.priceCode = newpriceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		this.priceCode = arg;
	}

	public String getTitle() {
		return title;
	};
}
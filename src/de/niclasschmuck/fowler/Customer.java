package de.niclasschmuck.fowler;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

public class Customer {

	private HashMap<Status, Integer> priceCodes = new HashMap<Status, Integer>();
	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();

	public Customer(String newname) {
		this.name = newname;
		priceCodes.put(Status.REGULAR, 0);
		priceCodes.put(Status.CHILDRENS, 2);
		priceCodes.put(Status.NEW_RELEASE, 1);
	};

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	};

	public String getName() {
		return name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> enum_rentals = rentals.elements();

		StringBuilder result = new StringBuilder();

		result.append("Rental Record for " + this.getName() + "\n\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount"
				+ "\n");

		while (enum_rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) enum_rentals.nextElement();
			thisAmount = amountFor(each);
			frequentRenterPoints++;
			if ((each.getMovie().getPriceCode() == priceCodes.get(Status.NEW_RELEASE)) && each.getDaysRented() > 1)
				frequentRenterPoints++;
			result.append("\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n");
			totalAmount += thisAmount;
		}
		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n You earned "
				+ String.valueOf(frequentRenterPoints) + " frequent renter points");
		return result.toString();
	}

	private double amountFor(Rental each) {
		double thisAmount = 0;
		int moviePriceCode = each.getMovie().getPriceCode();
		switch (moviePriceCode) {
		case 0:
			thisAmount += 2;
			if (each.getDaysRented() > 2)
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			break;
		case 1:
			thisAmount += each.getDaysRented() * 3;
			break;
		case 2:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

}

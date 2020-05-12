package de.niclasschmuck.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import de.niclasschmuck.fowler.Customer;
import de.niclasschmuck.fowler.Movie;
import de.niclasschmuck.fowler.Rental;

class CustomerTest {

	@Test
	void test() {
		Customer cust = new Customer("Johnny");
		assertTrue(cust.getName() == "Johnny");
		cust.addRental(new Rental(new Movie("John Wick III", 1), 1));
		assertTrue(cust.statement().contains("John"));
	}

}

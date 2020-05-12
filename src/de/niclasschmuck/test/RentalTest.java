package de.niclasschmuck.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import de.niclasschmuck.fowler.Movie;
import de.niclasschmuck.fowler.Rental;

class RentalTest {

	@Test
	void test() {
		Rental rent = new Rental(new Movie("Another Test Movie",1), 1);
		assertTrue(rent.getDaysRented() == 1);
		assertTrue(rent.getMovie().getTitle().equals("Another Test Movie"));
	}

}

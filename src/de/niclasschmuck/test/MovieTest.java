package de.niclasschmuck.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.niclasschmuck.fowler.Movie;

class MovieTest {
	
	@Test
	void test() {
		Movie test = new Movie("Test", 1);
		assertTrue(test.getTitle() == "Test");
		assertTrue(test.getPriceCode() == 1);
	}

}

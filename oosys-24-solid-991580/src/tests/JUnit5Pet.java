package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ljmu.vets.*;

class JUnit5Pet {
	
	private Pet pet;

	@BeforeEach
	void setUp() {
		LocalDate date = LocalDate.parse("03-Oct-23", DateTimeFormatter.ofPattern("dd-MMM-yy"));
		pet = new Fish("fish2", date, WaterType.FRESH);
	}

	@Test
	void testGetNextBookingExists() {
		Booking booking = new Booking("R002", pet, LocalDateTime.now().plusDays(30), 60);
		pet.makeBooking(booking);
		Booking nextBooking = pet.getNextBooking();
		
		assertTrue(nextBooking != null, "This pet should have a next booking.");
	}
		
	@Test
	void testGetNextBookingNotExist() {
		Booking booking = new Booking("R002", pet, LocalDateTime.now().minusDays(30), 60);
		pet.makeBooking(booking);
		Booking nextBooking = pet.getNextBooking();
		
		assertFalse(nextBooking != null, "This pet should not have a next booking.");
	}

}

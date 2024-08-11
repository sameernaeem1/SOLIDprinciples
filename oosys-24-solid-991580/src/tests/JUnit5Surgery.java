package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ljmu.vets.*;

class JUnit5Surgery {

	private Surgery surgery;
	private Pet pet;

	@BeforeEach
	void setUp() {
		surgery = new Surgery("surgeryA", DayOfWeek.THURSDAY);
		LocalDate date = LocalDate.parse("03-Oct-23", DateTimeFormatter.ofPattern("dd-MMM-yy"));
		pet = new Fish("fish1", date, WaterType.FRESH);
		surgery.makePet(pet);
	}

	@Test
	void testMakeBookingEmbargoDayException() {
		//Arrange
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
		String ldt = "24-Oct-24 09:30";		//This date would be a Thursday, meaning surgery is closed.
		LocalDateTime when = LocalDateTime.parse(ldt, formatter);
		Booking booking = new Booking("R001", pet, when, 60);
		
		// Act & Assert
	    assertThrows(Exception.class, () -> {
	    	surgery.makeBooking(booking);
	    });
	}
	
	@Test
	void testMakeBookingIncrementsCollection() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
		String ldt = "01-Oct-24 09:30";		//This date would be a Tuesday, meaning surgery is open.
		LocalDateTime when = LocalDateTime.parse(ldt, formatter);
		Booking booking = new Booking("R000", pet, when, 60);
		
		try {
		surgery.makeBooking(booking);
		} catch (Exception e) {
			fail("Exception shouldn't be thrown here.");
		}
		
		assertEquals(1, surgery.getBookings().size());
	}

	@Test
	void testGetPetByNameFound() {
		Pet expectedPet = surgery.getPetByName("fish1");
		assertSame(expectedPet, pet);
	}
	
	@Test
	void testGetPetByNameNotFound() {
		Pet expectedPet = surgery.getPetByName("Monkey6000");
		assertNull(expectedPet);
	}

}

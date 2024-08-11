package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import ljmu.vets.Booking;
import ljmu.vets.Fish;
import ljmu.vets.Pet;
import ljmu.vets.WaterType;

class JUnit5Booking {

	@Test
	void testAllBookingGetMethods() {
		LocalDate date = LocalDate.parse("03-Oct-23", DateTimeFormatter.ofPattern("dd-MMM-yy"));
		Pet fish = new Fish("fish4", date, WaterType.FRESH);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
		String ldt = "01-Oct-24 09:30";
		LocalDateTime appointment = LocalDateTime.parse(ldt, formatter);
		Booking booking = new Booking("R004", fish, appointment, 60);
		
		assertAll("Booking details",
				() -> assertEquals("R004", booking.getRef()),
				() -> assertEquals(fish, booking.getPet()),
				() -> assertEquals(appointment, booking.getWhen()),
				() -> assertEquals(60, booking.getDuration())
				
				);
	}

}

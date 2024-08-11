package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ljmu.vets.*;

class JUnit5Invoice {


	@ParameterizedTest
	@ValueSource(ints = {5, 15, 30, 45, 60})
	void testCalculateAmountDurations(int duration) {
		List<SurgeryPayable> surgeryPayables = new ArrayList<SurgeryPayable>();
		List<PublicPayable> publicPayables = new ArrayList<PublicPayable>();
		List<Booking> bookings = new ArrayList<Booking>();
		LocalDate date = LocalDate.parse("03-Oct-23", DateTimeFormatter.ofPattern("dd-MMM-yy"));
		Pet fish = new Fish("fish3", date, WaterType.FRESH);
		Booking booking = new Booking("R003", fish, LocalDateTime.now(), duration);
		bookings.add(booking);
		Invoice invoice = new Invoice(1, LocalDateTime.now(), 0.0, bookings, surgeryPayables, publicPayables);
		
		Double amount = invoice.getCalculateAmountForTesting(bookings);
		
		assertEquals(duration * fish.getRate(), amount);
	}

}

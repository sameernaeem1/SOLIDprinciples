package ljmu.vets;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Surgery implements Serializable {
	private String surgery;
	private List<Pet> pets = new ArrayList<Pet>();
	private List<Booking> bookings = Collections.synchronizedList(new ArrayList<Booking>());
	private DayOfWeek embargoDay;

	public Surgery(String surgery, DayOfWeek embargoDay) {
		this.surgery = surgery;
		this.embargoDay = embargoDay;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " >> " + this.surgery;
	}

	// ToDo : get / set Methods ?

	public void makePet(Pet pet) {
		// ToDo : Validate ?
		this.pets.add(pet);
	}

	/*
	public void makePet(String name, LocalDate regDate) {
		// ToDo : Validate ?
	}
	*/

	public Pet getPetByName(String name) {
		// NOTE : Java SE 7 Code !
		for (Pet p : this.pets) {
			if (p.getName().equals(name)) {
				return p;
			}
		}

		/* NOTE : Java SE 8 Code !
		Optional<Pet> p = this.pets.stream().filter(o -> o.getName().equals(name)).findAny();
		if (p.isPresent()) {
			return p.get();
		}
		*/

		// NOTE : No Match !
		return null;
	}

	public  void makeBooking(Booking booking) throws Exception {
		// NOTE : Validate ?
		if (booking.getWhen().getDayOfWeek() != this.embargoDay) {
			this.bookings.add(booking);
		}
		else {
			throw new Exception("makeBooking :(");
		}

		// NOTE : Two-Way Linking ?
		booking.getPet().makeBooking(booking);
	}
	
	// Method created for JUnit testing.
	public List<Booking> getBookings() {
		
		return this.bookings;
	}

	/*
	public void makeBooking(String ref, Pet pet, LocalDateTime when) {
		// ToDo : Validate ?
	}
	*/

	// ToDo : getBookingByRef() ?
}

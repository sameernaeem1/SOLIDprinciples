package ljmu.vets;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Pet implements Serializable {
	protected String name;
	protected LocalDate regDate;

	// ToDo : Private ?
	protected List<Booking> bookings = new ArrayList<Booking>();

	public Pet(String name, LocalDate regDate) {
		this.name = name;
		this.regDate = regDate;
	}

	public void makeBooking(Booking when) {
		this.bookings.add(when);
	}

	public Booking getNextBooking() {
		return this.bookings.stream()
			.filter(o -> o.getWhen().isAfter(LocalDateTime.now()))
				.sorted(Comparator.comparing(o -> o.getWhen()))
					.findFirst()
					.orElse(null); //Added this to return null if there is no next booking.
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getRegDate() {
		return this.regDate;
	}
/**
 * <p> Abstract method used by each Pet subclass. </p>
 * <p> Allows there to be a set rate based on the animal, without having to enter a rate for every new pet. </p>
 * @return The set rate for the specific animal that the pet is.
 */
	public abstract Double getRate();
	
	// ToDo : get / set Methods ?
}

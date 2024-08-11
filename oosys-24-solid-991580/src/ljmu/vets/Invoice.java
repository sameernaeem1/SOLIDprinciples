package ljmu.vets;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
/**
 * Class used to calculate costs and can be saved to different file types.
 * @author Sameer Naeem
 */
public class Invoice implements Serializable, Saveable {
	private Integer no;
	private LocalDateTime when;
	private Double amount;
	private List<Booking> bookings;
	private List<SurgeryPayable> surgeryPayables;
	private List<PublicPayable> publicPayables;

	public Invoice(Integer no, LocalDateTime when, Double amount, List<Booking> bookings, List<SurgeryPayable> surgeryPayables, List<PublicPayable> publicPayables) {
		this.no = no;
		this.when = when;
		// this.amount = amount;
		this.amount = calculateAmount(bookings);

		this.bookings = bookings;
		this.surgeryPayables = surgeryPayables;
		this.publicPayables = publicPayables;
	}
/**
 * Method adds up the cost of all bookings based on duration and the specific rate for each pet based on the type of animal.
 * @param bookings List of all bookings so all their costs can be added together.
 * @return The total amount from all bookings added together.
 */
	private Double calculateAmount(List<Booking> bookings) {
		Double tt = 0.0;
		for (Booking o : bookings) {			
			tt += o.getDuration() * o.getPet().getRate();
		}

		return Double.parseDouble(new DecimalFormat("#.##").format(tt));
	}

	@Override
	public String toSaveFileString() {
		// Use StringBuilder for each attribute and return as a String.
		return null;
	}
	
	//This method was necessary for the parameterized testing of Invoice.
	public Double getCalculateAmountForTesting(List<Booking> bookings) {
		return calculateAmount(bookings);
	}

	// ToDo : get / set Methods ?
}
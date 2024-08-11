package ljmu.vets;

import java.io.Serializable;

public class PublicMedicine extends SurgeryOnlyMedicine implements PublicPayable, Serializable {
	
	private Double publicCost;
	
	public PublicMedicine(String name, Integer stock, Integer lowest, Double surgeryCost, Double publicCost) {
		super(name, stock, lowest, surgeryCost);
		this.publicCost = publicCost;
	}

	@Override
	public Double getPublicCost() {
		return this.publicCost;
	}
	
}

package ljmu.vets;
/**
 * <p> Interface used by PublicMedicine to return the publicCost. </p>
 * <p> Avoids SurgeryOnlyMedicine being forced to use this method as it doesn't need it.</p>
 */
public interface PublicPayable {
	public Double getPublicCost();
}

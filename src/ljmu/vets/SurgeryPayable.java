package ljmu.vets;
/**
 * <p> Interface used by both SurgeryOnlyMedicine and PublicMedicine. </p>
 * <p> Split from PublicPayable to avoid forcing the use of unneeded methods. </p>
 */
public interface SurgeryPayable {
	public Double getSurgeryCost();
}

package ljmu.vets;

import java.util.List;
/**
 * This interface allows different options to be used for data storage (e.g. GSON, Serializable).
 */
public interface DataStorage {
	/**
	 * Used at the beginning to obtain all previously stored data.
	 * @return A list of all the surgeries previously stored.
	 */
	public List<Surgery> getSurgeries();
	/**
	 * Used before program is closed to store all of data back to where it was obtained from.
	 * @param surgeries Pass in the list of surgeries that are to be stored.
	 */
	public void setSurgeries(List<Surgery> surgeries);

}

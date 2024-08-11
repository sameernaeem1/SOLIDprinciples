import ljmu.vets.*;

/**
 * Entry class controls what happens on program startup.
 * @author Sameer Naeem
 */
public class Entry {
	
	/**
	 * <p> The main method creates an instance of the system and advances to its initial menu. </p>
	 * <p> A new DataStorage object is passed in based on the format in which the data is to be stored and obtained. </p>
	 * <p> The path is also passed in here, making it easy to change or removed if an option was used that doesn't require one. </p>
	 * 
	 * @param args Normal main method parameter.
	 * @throws Exception Due to makeBooking validating DayOfWeek so each class that leads to it must throw exception.
	 */
	public static void main(String[] args) throws Exception  {
		
		new Sys(new SerializableDS("M:\\data\\OOSyS\\surgeries.ser")).entryMenu();
		//new Sys(new GsonDS(M:\\data\\OOSyS\\surgeries.json)).entryMenu();
		
		// Change storage mechanism here e.g. GSON or Java Serializable.
	}
}

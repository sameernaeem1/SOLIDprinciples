package ljmu.vets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
/**
 * Used to retrieve and store data using Java's Serializable interface.
 */
public class SerializableDS implements DataStorage {
	
	private String path;
	
	public SerializableDS(String path) {	
		this.path = path;
	}
	
	@Override
	public List<Surgery> getSurgeries() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {		
			return (List<Surgery>)ois.readObject();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return Collections.emptyList();
			// Return type of method is List<surgery> so return empty if any problems.
		}
	}
	
	@Override
	public void setSurgeries(List<Surgery> surgeries) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {		
			oos.writeObject(surgeries);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

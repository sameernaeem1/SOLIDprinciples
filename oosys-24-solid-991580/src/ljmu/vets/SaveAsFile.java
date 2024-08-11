package ljmu.vets;
/**
 * Interface used by each different file format class so they can store the same data in their specific way.
 */
public interface SaveAsFile {
	
	public void saveFile(Saveable s, String path);
	// Method can be used for new file types added in the future.

}

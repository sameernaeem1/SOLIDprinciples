package ljmu.vets;
/**
 * Interface can be used to convert a class' attributes to one String, so save as methods can have a single parameter for this.
 */
public interface Saveable {	
	public String toSaveFileString();
}

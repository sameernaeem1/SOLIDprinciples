package ljmu.vets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
/**
 * Used to retrieve and store data using Google's GSON library.
 */
public class GsonDS implements DataStorage {
	
	private String path;
	/**
	 * Constructor used to declare where data is being retrieved from / stored.
	 * @param path Location on computer where file is stored.
	 */
	public GsonDS(String path) {
		this.path = path;
	}

	@Override
	public List<Surgery> getSurgeries() {
		try {
			String s = Files.readString(Path.of(path));
			Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
			return gson.fromJson(s, new TypeToken<List<Surgery>>() {}.getType());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return Collections.emptyList();
		}
	}

	@Override
	public void setSurgeries(List<Surgery> surgeries) {
		try {
			Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
			String s = gson.toJson(surgeries, new TypeToken<List<Surgery>>() {}.getType());
			Files.writeString(Path.of(path), s);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Used to allow LocalDate data type to be retrieved and stored as GSON on its own can't.
	 */
	private static class LocalDateAdapter extends TypeAdapter<LocalDate> {

		@Override
		public LocalDate read(JsonReader jsonReader) throws IOException {
			return LocalDate.parse(jsonReader.nextString());
		}

		@Override
		public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
			jsonWriter.value(localDate.toString());		
		}
		
	}
}

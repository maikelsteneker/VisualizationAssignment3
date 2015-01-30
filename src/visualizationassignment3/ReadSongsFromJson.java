package visualizationassignment3;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Reads a list of songs from json input.
 *
 * @author maikel
 */
public class ReadSongsFromJson {

    final private static Gson GSON = new Gson();

    public static List<Song> readSongsFromFile(String filename)
            throws FileNotFoundException {
        return readSongsFromFile(new File(filename));
    }

    public static List<Song> readSongsFromFile(File file)
            throws FileNotFoundException {
        try {return readSongsFromString(new Scanner(file).useDelimiter("\\A").next());}
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("File is empty", e);
        }
    }

    public static List<Song> readSongsFromString(String json) {
        json = json.replace("nan", "NaN");
        final List<Song> songs = GSON.fromJson(json, List.class);
        return songs;
    }
}

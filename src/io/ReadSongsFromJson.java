package io;

import model.Song;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Reads a list of songs from json input.
 *
 * @author maikel
 */
public class ReadSongsFromJson {

    final private static Gson GSON = new Gson();

    public static List<Song> readSongsFromFile(String filename)
            throws FileNotFoundException, IOException {
        return readSongsFromFile(new File(filename));
    }

    public static List<Song> readSongsFromFile(File file)
            throws FileNotFoundException, IOException {
        try {
            return readSongsFromStream(new FileInputStream(file));
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("File is empty", e);
        }
    }

    public static List<Song> readSongsFromString(String json)
            throws IOException {
        return readSongsFromStream(new ByteArrayInputStream(json.getBytes()));
    }

    public static List<Song> readSongsFromStream(InputStream in)
            throws IOException {
        List<Song> songs = new ArrayList<>();
        try (JsonReader reader = new JsonReader(new InputStreamReader(in))) {
            reader.beginArray();
            while (reader.hasNext()) {
                Song s = GSON.fromJson(reader, Song.class);
                songs.add(s);
            }
            reader.endArray();
        }
        return songs;
    }
}

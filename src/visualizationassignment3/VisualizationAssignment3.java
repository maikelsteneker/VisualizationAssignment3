package visualizationassignment3;

import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author maikel
 */
public class VisualizationAssignment3 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        List<Song> songs = ReadSongsFromJson.readSongsFromFile("songs.json");
        System.out.println(songs.size());
        System.out.println(songs.get(0));
    }

}

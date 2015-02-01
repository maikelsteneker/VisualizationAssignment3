package filtering;

import model.Song;

/**
 *
 * @author maikel
 */
public abstract class Filter {

    public abstract boolean accept(Song s);
}

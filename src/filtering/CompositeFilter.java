package filtering;

import model.Song;

/**
 *
 * @author maikel
 */
public class CompositeFilter extends Filter {

    Filter[] filters;

    public CompositeFilter(Filter... filters) {
        this.filters = filters;
    }

    @Override
    public boolean accept(Song s) {
        for (Filter f : filters) {
            if (!f.accept(s)) {
                return false;
            }
        }
        return true;
    }

}

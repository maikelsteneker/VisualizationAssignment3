package filtering;

import java.util.List;
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

    public CompositeFilter(List<Filter> filters) {
        this(filters.toArray(new Filter[0]));
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

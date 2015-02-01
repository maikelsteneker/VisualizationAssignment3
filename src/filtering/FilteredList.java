package filtering;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Song;

/**
 *
 * @author maikel
 */
public class FilteredList extends AbstractList<Song> {

    final private List<Song> filteredList;

    public FilteredList(Iterable<Song> originalList, Filter... filters) {
        this(originalList, new CompositeFilter(filters));
    }

    public FilteredList(Iterable<Song> originalList, Filter filter) {
        filteredList = new ArrayList<>();
        applyFilters(originalList, filter);
    }

    private void applyFilters(Iterable<Song> originalList, Filter filter) {
        for (Song s : originalList) {
            if (filter.accept(s)) {
                filteredList.add(s);
            }
        }
    }

    @Deprecated // TODO: test
    public void addFilter(Filter filter) {
        for (Iterator<Song> it = filteredList.iterator(); it.hasNext();) {
            Song s = it.next();
            if (!filter.accept(s)) {
                it.remove();
            }
        }
    }
    
    @Deprecated // TODO: test
    public void addFilters(Filter... filters) {
        addFilter(new CompositeFilter(filters));
    }

    public static FilteredList filter(Iterable<Song> originalList,
            Filter... filters) {
        return new FilteredList(originalList, filters);
    }

    @Override
    public Song get(int i) {
        return filteredList.get(i);
    }

    @Override
    public int size() {
        return filteredList.size();
    }

}

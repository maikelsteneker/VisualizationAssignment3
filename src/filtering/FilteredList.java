package filtering;

import java.util.AbstractList;
import java.util.ArrayList;
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
        for (Song s : originalList) {
            if (filter.accept(s)) {
                filteredList.add(s);
            }
        }
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

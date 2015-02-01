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

    final private List<Song> originalList;
    final private List<Song> filteredList;
    final private List<Filter> filters;

    public FilteredList(List<Song> originalList, Filter... filters) {
        this(originalList, new CompositeFilter(filters));
    }

    public FilteredList(List<Song> originalList, Filter filter) {
        this.originalList = originalList;
        this.filteredList = new ArrayList<>(originalList);
        this.filters = new ArrayList<>(1);
        this.filters.add(filter);
        applyFilters();
    }

    private void applyFilter(Filter filter) {
        for (Iterator<Song> it = filteredList.iterator(); it.hasNext();) {
            Song s = it.next();
            if (!filter.accept(s)) {
                it.remove();
            }
        }
    }

    private void applyFilters() {
        applyFilter(new CompositeFilter(filters));
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
        applyFilter(filter);
    }

    public boolean removeFilter(Filter filter) {
        final int index = filters.indexOf(filter);
        if (index != -1) {
            removeFilter(index);
            return true;
        } else {
            return false;
        }
    }

    public Filter removeFilter(int index) {
        final Filter result = filters.remove(index);
        filteredList.clear();
        filteredList.addAll(originalList);
        applyFilters();
        return result;
    }

    public void updateFilter(int index, String field, Number min, Number max) {
        updateFilter(filters.get(index), field, min, max);
    }

    public void updateFilter(Filter filter, String field, Number min, Number max) {
        //TODO: optimize
        removeFilter(filter);
        addFilter(new RangeFilter(field, min, max));
    }

    @Deprecated
    public static FilteredList filter(List<Song> originalList,
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

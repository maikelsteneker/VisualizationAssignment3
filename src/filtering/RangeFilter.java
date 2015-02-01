package filtering;

import model.Song;

/**
 *
 * @author maikel
 */
public class RangeFilter extends Filter {
    private final String field;
    private final Number min;
    private final Number max;

    public RangeFilter(String field, Number min, Number max) {
        this.field = field;
        this.min = min == null ? Double.NEGATIVE_INFINITY : min;
        this.max = max == null ? Double.POSITIVE_INFINITY : max;
    }
    
    @Override
    public boolean accept(Song s) {
        return min.doubleValue() <= s.getValue(field).doubleValue()
                && s.getValue(field).doubleValue() <= max.doubleValue();
    }
}

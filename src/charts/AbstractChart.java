package charts;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.JFreeChart;
import model.Song;

/**
 *
 * @author maikel
 */
public abstract class AbstractChart {

    final protected List<Song> songs;
    protected List<String> selectedValues = new ArrayList<>(0);

    public AbstractChart(List<Song> songs) {
        this.songs = songs;
    }

    public abstract JFreeChart createChart();

    public void setSelectedValues(List<String> selectedValues) {
        this.selectedValues = selectedValues;
    }

    public abstract int getSelectionMode();

    protected String getTitle() {
        return getTitle(selectedValues.size());
    }

    protected String getTitle(int limit) {
        return joinString(selectedValues.subList(0, Math.min(limit, selectedValues.size())));
    }

    private String joinString(List<String> strings) {
        String result = "";
        for (String s : strings) {
            result += s;
            result += " vs ";
        }
        result = result.substring(0, Math.max(result.length() - 4, 0));
        return result;
    }

}

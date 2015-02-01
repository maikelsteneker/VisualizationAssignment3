
package visualizationassignment3.charts;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.JFreeChart;
import visualizationassignment3.Song;

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
    
}

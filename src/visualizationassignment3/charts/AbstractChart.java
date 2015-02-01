
package visualizationassignment3.charts;

import java.util.List;
import org.jfree.chart.JFreeChart;
import visualizationassignment3.Song;

/**
 *
 * @author maikel
 */
public abstract class AbstractChart {
    final protected List<Song> songs;
    
    public AbstractChart(List<Song> songs) {
        this.songs = songs;
    }
    
    public abstract JFreeChart createChart();
    
}

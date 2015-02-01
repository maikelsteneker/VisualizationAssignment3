package visualizationassignment3.charts;

import java.util.List;
import org.jfree.chart.JFreeChart;
import visualizationassignment3.Song;

/**
 *
 * @author maikel
 */
public class BarChart extends AbstractChart {

    public BarChart(List<Song> songs) {
        super(songs);
    }

    @Override
    public JFreeChart createChart() {
        visualizationassignment3.BarChart.songs = this.songs;
        return visualizationassignment3.BarChart.createChart();
    }

    @Override
    public String toString() {
        return "BarChart";
    }
}

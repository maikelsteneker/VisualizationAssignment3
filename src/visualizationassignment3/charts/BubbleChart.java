package visualizationassignment3.charts;

import java.util.List;
import org.jfree.chart.JFreeChart;
import visualizationassignment3.Song;

/**
 *
 * @author Coen
 */
public class BubbleChart extends AbstractChart {

    public BubbleChart(List<Song> songs) {
        super(songs);
    }

    @Override
    public JFreeChart createChart() {
        visualizationassignment3.BubbleChart.songs = this.songs;
        return visualizationassignment3.BubbleChart.createChart();
    }

    @Override
    public String toString() {
        return "PieChart";
    }
}

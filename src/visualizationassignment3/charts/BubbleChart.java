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
        visualizationassignment3.TempBubbleChart.songs = this.songs;
        return visualizationassignment3.TempBubbleChart.createChart();
    }

    @Override
    public String toString() {
        return "BubbleChart";
    }
    
    @Override
    public int getSelectionMode() {
        return javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
    }
}

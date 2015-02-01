/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizationassignment3.charts;

import java.util.List;
import org.jfree.chart.JFreeChart;
import visualizationassignment3.Song;

/**
 *
 * @author maikel
 */
public class PieChart extends AbstractChart {

    public PieChart(List<Song> songs) {
        super(songs);
    }

    @Override
    public JFreeChart createChart() {
        visualizationassignment3.PieChart.songs = this.songs;
        return visualizationassignment3.PieChart.createChart();
    }

    @Override
    public String toString() {
        return "PieChart";
    }
}

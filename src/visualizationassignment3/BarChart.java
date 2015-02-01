package visualizationassignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import static visualizationassignment3.PieChart.songs;

/**
 *
 * @author Coen
 */
public class BarChart extends ApplicationFrame {

    public static List<Song> songs = null;
    static String chartTitle;

    public BarChart(String appTitle, String chartTitle) {

        super(appTitle);
        BarChart.chartTitle = chartTitle;
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 25; i < 50; i++) {
            dataset.addValue(songs.get(i).getSong_hotttnesss() * 100, songs.get(i).getTitle(), "hotness");
            dataset.addValue(songs.get(i).getDuration(), songs.get(i).getTitle(), "Duration");
        }

        return dataset;
    }
    
    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        return barChart;
    }
    
    public static JFreeChart createChart() {
        return createChart(createDataset());
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        songs = ReadSongsFromJson.readSongsFromFile("songs.json");
        BarChart chart = new BarChart("Song Statistics", "Duration versus Hotness");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

}

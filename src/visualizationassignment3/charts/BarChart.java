package visualizationassignment3.charts;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
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
        return this.createChart(createDataset());
    }

    @Override
    public String toString() {
        return "BarChart";
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 25; i < 50; i++) {
            for (String s : selectedValues) {
                dataset.addValue(songs.get(i).getValue(s), songs.get(i).getTitle(), s);
            }
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                getTitle(),
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        return barChart;
    }

    private String getTitle() {
        String result = "";
        for (String s : selectedValues) {
            result += s;
            result += " vs ";
        }
        result = result.substring(0, Math.max(result.length() - 4, 0));
        return result;
    }

    @Override
    public int getSelectionMode() {
        return javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
    }
}

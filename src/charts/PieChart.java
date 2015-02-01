package charts;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import model.Song;

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
        return createChart(createDataset());
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (selectedValues.size() > 0) {
            for (int i = 0; i < 20; i++) {
                dataset.setValue(songs.get(i).getTitle(), songs.get(i).getValue(selectedValues.get(0)));
            }
        }

        return dataset;
    }

    private JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                this.getTitle(1), // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );
        return chart;
    }

    @Override
    public String toString() {
        return "PieChart";
    }

    @Override
    public int getSelectionMode() {
        return javax.swing.ListSelectionModel.SINGLE_SELECTION;
    }
}

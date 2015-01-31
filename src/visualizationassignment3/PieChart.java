package visualizationassignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Coen
 */
public class PieChart extends ApplicationFrame {

    static List<Song> songs = null;
    
    public PieChart(String title) {
        super(title);
        setContentPane(createDemoPanel());

    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(int i =0; i < 20; i++) {
            dataset.setValue(songs.get(i).getTitle(), songs.get(i).getDuration());
        }
        
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Energy Levels", // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );
        return chart;
    }
    
    public static JFreeChart createChart() {
        return createChart(createDataset());
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }
    
    public static JPanel createDemoPanel(List<Song> songs) {
        PieChart.songs = songs;
        return createDemoPanel();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        songs = ReadSongsFromJson.readSongsFromFile("songs.json");
        PieChart demo = new PieChart("Energy Levels");
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}


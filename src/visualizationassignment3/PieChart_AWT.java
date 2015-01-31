package visualizationassignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
public class PieChart_AWT extends ApplicationFrame {

    static List<Song> songs = new ArrayList<>();
    
    public PieChart_AWT(String title) {
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

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        songs = ReadSongsFromJson.readSongsFromFile("songs.json");
        PieChart_AWT demo = new PieChart_AWT("Energy Levels");
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}


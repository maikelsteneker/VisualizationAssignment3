package visualizationassignment3.charts;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
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
        return createChart(createDataset());
    }

    @Override
    public String toString() {
        return "BubbleChart";
    }
    
    @Override
    public int getSelectionMode() {
        return javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
    }
    
    private JFreeChart createChart(XYZDataset xyzdataset) {
        JFreeChart jfreechart = ChartFactory.createBubbleChart(
                "Duration vs Tempo vs Hotttnesss",
                "Tempo",
                "Duration",
                xyzdataset,
                PlotOrientation.HORIZONTAL,
                true, true, false);

        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setForegroundAlpha(0.65F);
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesPaint(0, Color.blue);
        NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
        numberaxis.setLowerMargin(0.2);
        numberaxis.setUpperMargin(0.5);
        NumberAxis numberaxis1 = (NumberAxis) xyplot.getRangeAxis();
        numberaxis1.setLowerMargin(0.8);
        numberaxis1.setUpperMargin(0.9);

        return jfreechart;
    }

    

    public XYZDataset createDataset() {
        DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();

        ArrayList<Double> values1 = new ArrayList<>();
        ArrayList<Double> values2 = new ArrayList<>();
        ArrayList<Double> values3 = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            if (s.getSong_hotttnesss() > 0) {
                values1.add(s.getDuration());
                values2.add(s.getTempo());
                values3.add(s.getSong_hotttnesss() * 100);

            }
        }

        double values4[] = new double[values1.size()];
        double values5[] = new double[values2.size()];
        double values6[] = new double[values3.size()];
        for (int i = 0; i < values1.size(); i++) {
            values4[i] = values1.get(i);
            values5[i] = values2.get(i);
            values6[i] = values3.get(i);
        }
        double values7[][] = {values4, values5, values6};
        defaultxyzdataset.addSeries("Series 1", values7);

        return defaultxyzdataset;
    }
}

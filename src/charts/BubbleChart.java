package charts;

import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import model.Song;

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
                this.getTitle(3),
                selectedValues.size() >= 2 ? selectedValues.get(1) : "",
                selectedValues.size() >= 1 ? selectedValues.get(0) : "",
                xyzdataset,
                PlotOrientation.HORIZONTAL,
                false, true, false);

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
        xyitemrenderer.setSeriesToolTipGenerator(0, new XYToolTipGenerator() {
            public String generateToolTip(XYDataset xyzdataset, int series, int item) {
                
                return "Title: " + songs.get(item).getTitle() + "\n" + " Artist: " + songs.get(item).getArtist_name() + "\n " + selectedValues.get(selectedValues.size() - 1) + ": " + songs.get(item).getValue(selectedValues.get(selectedValues.size() - 1));
            }
        });

        return jfreechart;
    }

    public XYZDataset createDataset() {
        DefaultXYZDataset result = new DefaultXYZDataset();
        if (selectedValues.size() >= 3) {
            double[][] values = new double[3][songs.size()];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < songs.size(); j++) {
                    values[i][j] = songs.get(j).getValue(selectedValues.get(i)).doubleValue();
                }
            }
            result.addSeries("Series 1", values);
        }
        return result;
    }
}

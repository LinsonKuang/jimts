package com.midou.jimts;

import org.icepear.echarts.Line;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.series.SeriesLabel;
import org.icepear.echarts.render.Engine;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JimtsApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(JimtsApplication.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] xData = new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        int[] yData = new int[] { 820, 932, 901, 934, 1290, 1330, 1320 };
        int average = average(xData, yData);
        int maximum = maximum(xData, yData);
        int minimum = minimum(xData, yData);

        String title = String.format("Week data avg: %d, max: %d, min: %d", average, maximum, minimum);
        renderChart(xData, yData, title);
    }

    /**
     * calculate the average value
     * @param xData
     * @param yData
     * @return
     */
    private int average(String[] xData, int[] yData) {
        return 0;
    }

    /**
     * calculate the maximum value
     * @param xData
     * @param yData
     * @return
     */
    private int maximum(String[] xData, int[] yData) {
        return 0;
    }

    /**
     * calculate the minimum value
     * @param xData
     * @param yData
     * @return
     */
    private int minimum(String[] xData, int[] yData) {
        return 0;
    }

    /**
     * Render line chart
     * @param xData
     * @param yData
     */
    private static void renderChart(String[] xData, int[] yData, String title) {
        Line line = new Line()
                .addXAxis(new CategoryAxis().setData(xData).setBoundaryGap(false))
                .addYAxis()
                .addSeries(new LineSeries().setData(yData).setLabel(new SeriesLabel().setShow(true)))
                .setTitle(title);

        Engine engine = new Engine();
        engine.render("test2.html", line, "600px", "600px", true);
    }
}

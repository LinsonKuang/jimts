package com.midou.jimts;

import org.icepear.echarts.Line;
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

//    public static class Point {
//        public String time; // 时间
//
//        public float value; // 数值
//
//        /**
//         * 构建一个Point对象
//         * @param time
//         * @param value
//         * @return
//         */
//        public static Point build(String time, float value) {
//            Point point = new Point();
//            point.time = time;
//            point.value = value;
//            return point;
//        }
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Line line = new Line()
                .addXAxis(new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" })
                .addYAxis()
                .addSeries(new Number[] { 150, 230, 224, 218, 135, 147, 260 });
        Engine engine = new Engine();
        engine.render("test2.html", line, "600px", "600px", true);
    }
}

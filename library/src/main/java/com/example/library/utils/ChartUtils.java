package com.zihehealth.zihehealth.ZiheHealth.utils;

import android.graphics.Color;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.Calendar;
import java.util.List;

/**
 * 图表工具
 * Created by yangle on 2016/11/29.
 */
public class ChartUtils {

    public static int dayValue = 0;
    public static int weekValue = 1;
    public static int monthValue = 2;

    public static int mMax;

    /**
     * 初始化图表
     *
     * @param chart 原始图表
     * @return 初始化后的图表
     */
    public static LineChart initChart(LineChart chart, float min, float max) {
        // 不显示数据描述
        chart.getDescription().setEnabled(false);
        // 没有数据的时候，显示“暂无数据”
        chart.setNoDataText("暂无数据");
        // 不显示表格颜色
        chart.setDrawGridBackground(false);
        // 不可以缩放
        chart.setScaleEnabled(true);
        // 不显示y轴右边的值
        chart.getAxisRight().setEnabled(false);
        // 不显示图例
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        // 向左偏移15dp，抵消y轴向右偏移的30dp
        chart.setExtraLeftOffset(-15);

        XAxis xAxis = chart.getXAxis();
        // 不显示x轴
        xAxis.setDrawAxisLine(true);
        // 设置x轴数据的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setTextSize(12);
        xAxis.setGridColor(Color.parseColor("#30FFFFFF"));
        // 设置x轴数据偏移量
        xAxis.setYOffset(15);
        xAxis.setAxisLineColor(Color.parseColor("#7f000000"));
        xAxis.setAxisLineWidth(1);
        xAxis.setLabelCount(7);


        YAxis yAxis = chart.getAxisLeft();
        // 不显示y轴
        yAxis.setDrawAxisLine(true);
        // 设置y轴数据的位置
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        // 不从y轴发出横向直线
        yAxis.setDrawGridLines(false);
        yAxis.setTextColor(Color.BLACK);
        yAxis.setTextSize(12);
        // 设置y轴数据偏移量
        yAxis.setXOffset(15);
        yAxis.setYOffset(-3);

        yAxis.setAxisMinimum(min);
        yAxis.setAxisMaximum(max);
        yAxis.setAxisLineColor(Color.parseColor("#7f000000"));
        yAxis.setAxisLineWidth(1);
        //Matrix matrix = new Matrix();
        // x轴缩放1.5倍
        //matrix.postScale(1.5f, 1f);
        // 在图表动画显示之前进行缩放
        //chart.getViewPortHandler().refresh(matrix, chart, false);
        // x轴执行动画
        //chart.animateX(2000);
        chart.invalidate();
        return chart;
    }

    /**
     * 设置图表数据
     *
     * @param chart  图表
     * @param values 数据
     */
    public static void setChartData(LineChart chart, List<Entry> values, String color) {
        LineDataSet lineDataSet;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {

            lineDataSet = new LineDataSet(values, "");
            // 设置曲线颜色
            lineDataSet.setColor(Color.parseColor("#FFFFFF"));
            // 设置平滑曲线
            //  lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(true);
            lineDataSet.setCircleRadius(3);
            lineDataSet.setDrawCircleHole(false);
            lineDataSet.setCircleColor(Color.parseColor(color));

            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false);
            // 不显示定位线
            lineDataSet.setHighlightEnabled(false);

            LineData data = new LineData(lineDataSet);
            chart.setData(data);
            chart.invalidate();
        }
    }

    public static void setDoubleChartData(LineChart chart, List<Entry> values1, List<Entry> values2) {
        // ArrayList<LineDataSet> allLinesList = new ArrayList<LineDataSet>();
        //LineDataSet可以看做是一条线
        LineDataSet dataSet1 = new LineDataSet(values1, "舒张压");
        LineDataSet dataSet2 = new LineDataSet(values2, "收缩压");


        //allLinesList.add(dataSet1);
        //  allLinesList.add(dataSet2);
        // 设置曲线颜色
        dataSet1.setColor(Color.parseColor("#FFFFFF"));
        // 设置平滑曲线
        //  lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        // 不显示坐标点的小圆点
        dataSet1.setDrawCircles(true);
        dataSet1.setCircleRadius(3);
        dataSet1.setDrawCircleHole(false);
        dataSet1.setCircleColor(Color.parseColor("#aa0096ff"));
        // 不显示坐标点的数据
        dataSet1.setDrawValues(false);
        // 不显示定位线
        dataSet1.setHighlightEnabled(false);


        dataSet2.setColor(Color.parseColor("#FFFFFF"));
        // 设置平滑曲线
        //  lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        // 不显示坐标点的小圆点
        dataSet2.setDrawCircles(true);
        dataSet2.setCircleRadius(3);
        dataSet2.setDrawCircleHole(false);
        dataSet2.setCircleColor(Color.parseColor("#0096ff"));
        // 不显示坐标点的数据
        dataSet2.setDrawValues(false);
        // 不显示定位线
        dataSet2.setHighlightEnabled(false);
        LineData data = new LineData(dataSet1, dataSet2);
        chart.setData(data);
        chart.invalidate();

    }

    /**
     * 更新图表
     *
     * @param chart  图表
     * @param values 数据
     */
    public static void notifyDataSetChanged(LineChart chart, List<Entry> values,
                                            int max, String color) {
        mMax = max;
        chart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValuesProcess(monthValue, mMax)[(int) value];
            }
        });

        chart.invalidate();
        setChartData(chart, values, color);
    }


    public static void notifyDoubleDataSetChanged(LineChart chart, List<Entry> values1, List<Entry> values2,
                                                  int max) {
        mMax = max;
        chart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValuesProcess(monthValue, mMax)[(int) value];
            }
        });

        chart.invalidate();
        setDoubleChartData(chart, values1, values2);
    }

    /**
     * x轴数据处理
     *
     * @param valueType 数据类型
     * @return x轴数据
     */
    private static String[] xValuesProcess(int valueType, int max) {
        String[] week = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

        if (valueType == dayValue) { // 今日
            String[] dayValues = new String[7];
            long currentTime = System.currentTimeMillis();
            for (int i = 6; i >= 0; i--) {
                dayValues[i] = TimeUtils.dateToString(currentTime, TimeUtils.dateFormat_day);
                currentTime -= (3 * 60 * 60 * 1000);
            }
            return dayValues;

        } else if (valueType == weekValue) { // 本周
            String[] weekValues = new String[7 * max];
            Log.e("xx", "weekValues:" + weekValues.length);

            Calendar calendar = Calendar.getInstance();
            int currentWeek = calendar.get(Calendar.DAY_OF_WEEK);

            for (int i = 7 * mMax - 1; i >= 0; i--) {
                weekValues[i] = week[currentWeek - 1];
                if (currentWeek == 1) {
                    currentWeek = 7;
                } else {
                    currentWeek -= 1;
                }
            }
            return weekValues;

        } else if (valueType == monthValue) { // 本月
            String[] monthValues = new String[7 * max];
            long currentTime = System.currentTimeMillis();
            for (int i = 6; i >= 0; i--) {
                for (int j = 0; j < max; j++) {
                    monthValues[i*max+j] = TimeUtils.dateToString(currentTime, TimeUtils.dateFormat_month);
                }

                currentTime -= (24 * 60 * 60 * 1000);
            }
            return monthValues;
        }
        return new String[]{};
    }


}

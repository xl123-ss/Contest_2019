package com.example.contest_2019_1.fragment_pro3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contest_2019_1.R;
import com.example.contest_2019_1.programme3;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fra_pro3_line6 extends Myfragment {

    private View view;
    private LineChart lineChart;
    private LineDataSet dataSet;
    private LineData lineData;
    private List<Entry> list;
    private Random random = new Random();
    private Handler handler = new Handler();
    programme3 programme3;


    Runnable runnable = new Runnable() {
        int i,j = 6;

        @Override
        public void run() {
            i = random.nextInt(100);


            //添加单个数据（多个数据也同理）
            list.add(new Entry(list.size()+1, i));

            dataSet = new LineDataSet(list, "道路状态");
            lineData = new LineData(dataSet);
            init2();
            lineChart.setData(lineData);

            lineChart.notifyDataSetChanged();//对图表数据进行更新
            lineChart.invalidate();          //对图表的显示更新

            try {
                if (j++<20){
                    handler.postDelayed(this,3000);
                }else {
                    Toast.makeText(getActivity(), "更新结束", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pro3_line6, container, false);
        this.view = view;
        programme3 = (com.example.contest_2019_1.programme3) getActivity();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lineChart = view.findViewById(R.id.lineChart6);
        init();
    }


    private  void  init2(){

//        //设置折线的式样   这个是圆滑的曲线（有好几种自己试试）     默认是直线
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setColor(Color.GRAY);  //折线的颜色
//        lineDataSet.setLineWidth(2);        //折线的粗细
//        //是否画折线点上的空心圆  false表示直接画成实心圆
        dataSet.setDrawCircleHole(false);
//        lineDataSet.setCircleHoleRadius(3);  //空心圆的圆心半径
//        //圆点的颜色     可以实现超过某个值定义成某个颜色的功能   这里先不讲 后面单独写一篇
//        lineDataSet.setCircleColor(Color.RED);
//        lineDataSet.setCircleRadius(3);      //圆点的半径
//        //定义折线上的数据显示    可以实现加单位    以及显示整数（默认是显示小数）
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
//                Log.e("wwww", "v= "+v+",entry"+entry+",i ="+i+",viewPortHandler = "+viewPortHandler );
                if (entry.getY()==v){
                    return (int)v+"℃";
                }
                return "";
            }
        });

    }

    private void init() {

        list = new ArrayList<>();
        list.add(new Entry(1,22));
        list.add(new Entry(2,100));
        list.add(new Entry(3,20));
        list.add(new Entry(4,1));
        list.add(new Entry(5,55));
        list.add(new Entry(6,66));

        dataSet = new LineDataSet(list,"道路状态");

        lineData = new LineData(dataSet);
//        lineChart.getXAxis().setCenterAxisLabels(true);   //设置柱子（柱子组）居中对齐X轴上的点
        lineChart.setData(lineData);


        //右下角的描述文字
        Description description = lineChart.getDescription();
        description.setEnabled(false);  //默认为true
        description.setText("修改文字的方法");
        description.setTextSize(20);
        description.setTextColor(Color.RED);


        //图例
        Legend legend = lineChart.getLegend();
        legend.setEnabled(true);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        legend.setTextSize(12);

        //X轴
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setDrawGridLines(true);  //是否绘制X轴上的网格线（背景里面的竖线）
        xAxis.setAxisLineColor(Color.RED);   //X轴颜色
        xAxis.setAxisLineWidth(2);           //X轴粗细
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);        //X轴所在位置   默认为上面

        xAxis.setAxisMaximum(20);   //X轴最大数值
        xAxis.setAxisMinimum(0);   //X轴最小数值
        //X轴坐标的个数    第二个参数一般填false     true表示强制设置标签数 可能会导致X轴坐标与数据显示不全等问题
        xAxis.setLabelCount(21,false);
        xAxis.setLabelRotationAngle(90);



        //Y轴
        YAxis AxisLeft=lineChart.getAxisLeft();
        AxisLeft.setDrawGridLines(true);  //是否绘制Y轴上的网格线（背景里面的横线）
        AxisLeft.setAxisLineColor(Color.BLUE);  //Y轴颜色
        AxisLeft.setAxisLineWidth(2);           //Y轴粗细

        AxisLeft.setValueFormatter(new IAxisValueFormatter() {  //Y轴自定义坐标
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
//                Log.e("wwww", "v= "+v+",axisBase"+axisBase.toString());

                for (int a=10;a<=100;a = a+10){     //用个for循环方便

                    if (v ==10){
                        return "10℃";
                    }
                    if (a==v){
                        return a+"";
                    }
                }

                return "";
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

        AxisLeft.setAxisMaximum(100);   //Y轴最大数值
        AxisLeft.setAxisMinimum(0);   //Y轴最小数值
        //Y轴坐标的个数    第二个参数一般填false     true表示强制设置标签数 可能会导致X轴坐标显示不全等问题
        AxisLeft.setLabelCount(10,false);

        //是否隐藏右边的Y轴（不设置的话有两条Y轴 同理可以隐藏左边的Y轴）
        lineChart.getAxisRight().setEnabled(false);


//        //折线
//        //设置折线的式样   这个是圆滑的曲线（有好几种自己试试）     默认是直线
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setColor(Color.GRAY);  //折线的颜色
//        lineDataSet.setLineWidth(2);        //折线的粗细
//        //是否画折线点上的空心圆  false表示直接画成实心圆
        dataSet.setDrawCircleHole(false);
//        lineDataSet.setCircleHoleRadius(3);  //空心圆的圆心半径
//        //圆点的颜色     可以实现超过某个值定义成某个颜色的功能   这里先不讲 后面单独写一篇
//        lineDataSet.setCircleColor(Color.RED);
//        lineDataSet.setCircleRadius(3);      //圆点的半径
//        //定义折线上的数据显示    可以实现加单位    以及显示整数（默认是显示小数）
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
//                Log.e("wwww", "v= "+v+",entry"+entry+",i ="+i+",viewPortHandler = "+viewPortHandler );
                if (entry.getY()==v){
                    return (int)v+"℃";
                }
                return "";
            }
        });

        lineChart.animateXY(3000,3000);//XY两轴混合动画
        handler.postDelayed(runnable,3000);

    }

    public void changeright(){
        Toast.makeText(getActivity(), "往右滑动", Toast.LENGTH_SHORT).show();
        programme3.change1();
    }

    public void changeleft(){
        Toast.makeText(getActivity(), "往左滑动", Toast.LENGTH_SHORT).show();
        programme3.change5();
    }

}

package com.example.contest_2019_1.fragment_pro5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contest_2019_1.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class Fra_pro5_temperature extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pro5_air,container,false);
        this.view = view;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBar();
    }

    private void initBar() {

        BarChart barChart1 = view.findViewById(R.id.pro5_barchart1);
        BarDataSet barDataSet;
        BarData barData;

        List<BarEntry> list = new ArrayList<>();
        list.add(new BarEntry(1,77));
        list.add(new BarEntry(2,87));
        list.add(new BarEntry(3,70));
        list.add(new BarEntry(4,85));
        list.add(new BarEntry(5,74));

        barDataSet = new BarDataSet(list, "temperature");
        barData = new BarData(barDataSet);
        barChart1.setData(barData);

        Description description = barChart1.getDescription();
        description.setEnabled(false);
        description.setText("这是修改的方法，记住啊");
        description.setTextColor(Color.RED);

        Legend legend = barChart1.getLegend();
        legend.setEnabled(true);
        legend.setTextSize(22);
        legend.setTextColor(Color.GREEN);

        XAxis xAxis = barChart1.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setAxisLineColor(Color.RED);

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMaximum(20);
        xAxis.setAxisMinimum(0);
        xAxis.setLabelCount(21,true);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return (int)value*3+"";


            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

        YAxis axisLeft = barChart1.getAxisLeft();
        axisLeft.setEnabled(true);
        barChart1.getAxisRight().setEnabled(false);

        axisLeft.setAxisMaximum(108);
        axisLeft.setAxisMinimum(0);
        axisLeft.setLabelCount(7,true);

//        axisLeft.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return value*3+"";
//            }
//
//            @Override
//            public int getDecimalDigits() {
//                return 0;
//            }
//        });


    }
}

package com.example.contest_2019_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contest_2019_1.fragment_pro5.Fra_pro5_CQ2;
import com.example.contest_2019_1.fragment_pro5.Fra_pro5_air;
import com.example.contest_2019_1.fragment_pro5.Fra_pro5_humidity;
import com.example.contest_2019_1.fragment_pro5.Fra_pro5_temperature;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Programme5 extends AppCompatActivity {

    private LineChart lineChart1;
    private LineDataSet lineDataSet;
    private LineData lineData;
    private LineDataSet lineDataSet1;

    //文本控件
    private TextView pro5_txt_show1;
    private TextView pro5_txt_show2;
    private TextView pro5_txt_show3;
    private TextView pro5_txt_show4;
    private TextView pro5_txt_show5;

    private TextView pro5_txt_show1_down;
    private TextView pro5_txt_show2_down;
    private TextView pro5_txt_show3_down;
    private TextView pro5_txt_show4_down;
    private TextView pro5_txt_show5_down;

   //
   private TextView pro5_txt_air;
    private TextView pro5_txt_temperature;
    private TextView pro5_txt_humidity;
    private TextView pro5_txt_CQ2;

    Fra_pro5_air pro5_air;
    Fra_pro5_temperature pro5_temperature;
    Fra_pro5_humidity pro5_humidity;
    Fra_pro5_CQ2 pro5_cq2;





    private TextView pro5_txt_test;
    String string;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:

                    pro5_txt_test.setText(string);
                    break;

                default:
                    Toast.makeText(Programme5.this, "网络异常", Toast.LENGTH_SHORT).show();
                    break;



            }
        }
    };








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.programme5);

        lineChart1 = findViewById(R.id.pro5_linechart1);

        initchart();
        initLine();

        initTextView();
        initNetwork();
        initFragment();
        changeFragment(pro5_air);



    }

    private void initFragment() {
        pro5_air = new Fra_pro5_air();
        pro5_temperature = new Fra_pro5_temperature();
        pro5_humidity = new Fra_pro5_humidity();
        pro5_cq2 = new Fra_pro5_CQ2();
    }

    public  void dosubmit2(View view){

        switch (view.getId()){
            case R.id.pro5_txt_air:
                changeFragment(pro5_air);
                break;

            case R.id.pro5_txt_temperature:
                changeFragment(pro5_temperature);
                break;

            case R.id.pro5_txt_humidity:
                changeFragment(pro5_humidity);
                break;

            case R.id.pro5_txt_CQ2:
                changeFragment(pro5_cq2);
                break;
        }
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.pro5_framelout,fragment).commit();
    }

    private void initNetwork() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://wthrcdn.etouch.cn/weather_mini?city=徐州市")
                            .build();

                    Call call = client.newCall(request);

                    call.enqueue(new Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        Message message = new Message();
                        message.what = 0;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        Message message = handler.obtainMessage();
                        message.what = 1;
                        string = res;

                        handler.sendMessage(message);
                    }
                    });








//                    Response response = client.newCall(request).execute();
//                    String responseDara = response.body().string();
//                    string = responseDara;
//
//                    Message message = new Message();
//                    message.what = 1;
//                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();
                }




            }
        }).start();

    }

    private void initTextView() {
        pro5_txt_show1 = findViewById(R.id.pro5_txt_show1);
        pro5_txt_show2 = findViewById(R.id.pro5_txt_show2);
        pro5_txt_show3 = findViewById(R.id.pro5_txt_show3);
        pro5_txt_show4 = findViewById(R.id.pro5_txt_show4);
        pro5_txt_show5 = findViewById(R.id.pro5_txt_show5);

        pro5_txt_show1_down = findViewById(R.id.pro5_txt_show1_down);
        pro5_txt_show2_down = findViewById(R.id.pro5_txt_show2_down);
        pro5_txt_show3_down = findViewById(R.id.pro5_txt_show3_down);
        pro5_txt_show4_down = findViewById(R.id.pro5_txt_show4_down);
        pro5_txt_show5_down = findViewById(R.id.pro5_txt_show5_down);

        pro5_txt_test = findViewById(R.id.pro5_txt_test);

        pro5_txt_air = findViewById(R.id.pro5_txt_air);
        pro5_txt_temperature = findViewById(R.id.pro5_txt_temperature);
        pro5_txt_humidity = findViewById(R.id.pro5_txt_humidity);
        pro5_txt_CQ2 = findViewById(R.id.pro5_txt_CQ2);




    }



    private void initchart() {
        ImageView pro5_ima_flesh = findViewById(R.id.pro5_ima_flesh);

        pro5_ima_flesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Programme5.this, "ssss", Toast.LENGTH_SHORT).show();

                lineData.removeDataSet(1);
                lineData.removeDataSet(lineDataSet);

                List<Entry> list = new ArrayList<>();
                list.add(new Entry(1,44));
                list.add(new Entry(2,60));
                list.add(new Entry(3,66));
                list.add(new Entry(4,55));
                list.add(new Entry(5,44));

                LineDataSet barDataSet = new LineDataSet(list, "");
                LineData lineData = new LineData(barDataSet);
                lineChart1.setData(lineData);

                XAxis xAxis = lineChart1.getXAxis();
                xAxis.setAxisMaximum(5);
                xAxis.setAxisMinimum(0);
                xAxis.setLabelCount(6,true);

                xAxis.setValueFormatter(new IAxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        if (value ==1){
                            return "紫外线指数";
                        }
                        if (value ==2){
                            return "感冒指数";
                        }
                        if (value ==3){
                            return "穿衣指数";
                        }
                        if (value ==4){
                            return "运动指数";
                        }
                        if (value ==5){
                            return "空气污染物扩散指数";
                        }



                        return "";
                    }

                    @Override
                    public int getDecimalDigits() {
                        return 0;
                    }
                });


                lineChart1.notifyDataSetChanged();
                lineChart1.invalidate();

            }
        });
    }



    private void initLine() {

        List<Entry> list = new ArrayList<>();
        List<Entry> list1 = new ArrayList<>();
        list.add(new Entry(1,22));
        list.add(new Entry(2,24));
        list.add(new Entry(3,25));
        list.add(new Entry(4,25));
        list.add(new Entry(5,25));
        list.add(new Entry(6,22));

        list1.add(new Entry(1,14));
        list1.add(new Entry(2,15));
        list1.add(new Entry(3,16));
        list1.add(new Entry(4,17));
        list1.add(new Entry(5,16));
        list1.add(new Entry(6,16));
        lineDataSet = new LineDataSet(list, "");
        lineDataSet1 = new LineDataSet(list1, "");

        lineData = new LineData(lineDataSet);
        lineData.addDataSet(lineDataSet1);
        lineChart1.setData(lineData);

        //说明文字
        Description description = lineChart1.getDescription();
        description.setEnabled(false);
        description.setText("这是修改说明文字的方法");
        description.setTextSize(22);
        description.setTextColor(Color.GREEN);

        //图例
        Legend legend = lineChart1.getLegend();
        legend.setEnabled(false);
        legend.setTextSize(22);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);


        XAxis xAxis = lineChart1.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setAxisLineColor(Color.RED);
        xAxis.setAxisLineWidth(2);
        xAxis.setPosition(XAxis.XAxisPosition.TOP);

        xAxis.setAxisMaximum(6);
        xAxis.setAxisMinimum(0);

        xAxis.setLabelCount(6,false);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("sss", value+"" );
                switch ((int)value){

                    case 1:
                        return "昨天";
                    case 2:
                        return "今天";
                    case 3:
                        return "明天";
                    case 4:
                        return "周五";
                    case 5:
                        return "周六";
                    case 6:
                        return "周日";



                }

                return "";
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

        YAxis axisLeft = lineChart1.getAxisLeft();
        axisLeft.setAxisLineColor(Color.BLUE);

//
//        axisLeft.setAxisMaximum(100);
//        axisLeft.setAxisMinimum(0);
//        axisLeft.setLabelCount(10,false);
//
//        axisLeft.setValueFormatter(new IAxisValueFormatter() {
//                @Override
//                public String getFormattedValue(float value, AxisBase axis) {
//                    switch ((int)value){
//
//                        case
//                    }
//                    return null;
//                }
//
//            @Override
//            public int getDecimalDigits() {
//                return 0;
//            }
//        });


        lineChart1.getAxisRight().setEnabled(false);

        lineDataSet.setColor(Color.RED);
        lineDataSet1.setColor(Color.BLUE);

        lineDataSet.setDrawCircleHole(false);//false表示实心圆
        lineDataSet1.setDrawCircleHole(false);

        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet1.setMode(LineDataSet.Mode.LINEAR);

        lineDataSet.setCircleColor(Color.RED);//圆点的颜色
        lineDataSet1.setCircleColor(Color.BLUE);

        lineChart1.animateXY(3000,3000);




    }
}

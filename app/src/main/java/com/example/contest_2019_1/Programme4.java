package com.example.contest_2019_1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Programme4 extends AppCompatActivity {


    private TextView pro4_txt_time;
    private TextView pro4_txt_judge;
    private Switch pro4_switch1;
    private Switch pro4_switch2;
    private Switch pro4_switch3;

    private TextView pro4_txt_switch1;
    private TextView pro4_txt_switch2;
    private TextView pro4_txt_switch3;

    private ImageView pro4_ima1;
    private ImageView pro4_ima2;
    private ImageView pro4_ima3;

    private int judge;
    private int judgeTime = 1;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what){

                case 1:
                    pro4_ima1.setImageDrawable(getResources().getDrawable(R.drawable.shape_red));
                    pro4_ima2.setImageDrawable(getResources().getDrawable(R.drawable.shape_yellow));
                    pro4_ima3.setImageDrawable(getResources().getDrawable(R.drawable.shape_green));
                    break;

                case 2:
                    pro4_ima1.setImageDrawable(getResources().getDrawable(R.drawable.shape_yellow));
                    pro4_ima2.setImageDrawable(getResources().getDrawable(R.drawable.shape_green));
                    pro4_ima3.setImageDrawable(getResources().getDrawable(R.drawable.shape_red));
                    break;

                case 3:
                    pro4_ima1.setImageDrawable(getResources().getDrawable(R.drawable.shape_green));
                    pro4_ima2.setImageDrawable(getResources().getDrawable(R.drawable.shape_red));
                    pro4_ima3.setImageDrawable(getResources().getDrawable(R.drawable.shape_yellow));
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.programme4);
        innit();
        setswitch();
        setdate();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();

                switch (judgeTime){
                    case 1:
                        message.what = 1;
                        judgeTime = 2;
                        break;

                    case 2:
                        message.what = 2;
                        judgeTime = 3;
                        break;

                    case 3:
                        message.what = 3;
                        judgeTime = 1;
                        break;

                }

                handler.sendMessage(message);
            }
        },0,2000);





    }

    private void innit() {

        pro4_txt_time = findViewById(R.id.pro4_txt_time);
        pro4_txt_judge = findViewById(R.id.pro4_txt_judge);
        pro4_txt_switch1 = findViewById(R.id.pro4_txt_switch1);
        pro4_txt_switch2 = findViewById(R.id.pro4_txt_switch2);
        pro4_txt_switch3 = findViewById(R.id.pro4_txt_switch3);

        pro4_switch1 = findViewById(R.id.pro4_switch1);
        pro4_switch2 = findViewById(R.id.pro4_switch2);
        pro4_switch3 = findViewById(R.id.pro4_switch3);

        pro4_ima1 = findViewById(R.id.pro4_ima1);
        pro4_ima2 = findViewById(R.id.pro4_ima2);
        pro4_ima3 = findViewById(R.id.pro4_ima3);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        pro4_txt_time.setText(year+"年"+month+"月"+day+"日");

        if (day%2==0){
            pro4_txt_judge.setText("双号出行车辆：2号");
            judge = 2;
        }else {
            pro4_txt_judge.setText("单号出行车辆：1 3号");
            judge = 1;
        }
    }
    private void setswitch(){
        if (judge ==1){
            pro4_switch1.setClickable(true);
            pro4_switch2.setClickable(false);
            pro4_switch3.setClickable(true);
        }else {
            pro4_switch1.setClickable(false);
            pro4_switch2.setClickable(true);
            pro4_switch3.setClickable(false);

        }
        pro4_switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    pro4_txt_switch1.setText("开");

                }else{

                    pro4_txt_switch1.setText("关");
                }
            }
        });

        pro4_switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    pro4_txt_switch2.setText("开");

                }else{

                    pro4_txt_switch2.setText("关");
                }

            }
        });
        pro4_switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    pro4_txt_switch3.setText("开");
                }else{

                    pro4_txt_switch3.setText("关");
                }
            }
        });
    }

   private void setdate(){
        pro4_txt_time.setOnClickListener(new View.OnClickListener() {
            Calendar calendar;
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                View view = LayoutInflater.from(Programme4.this).inflate(R.layout.pro4_alert1, null);
                final DatePicker pro4_datepicker = view.findViewById(R.id.pro4_datepicker);
                final AlertDialog dialog = new AlertDialog.Builder(Programme4.this)
                        .setTitle("请指定日期")
                        .setView(view)
                        .show();
                pro4_datepicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        pro4_txt_time.setText(year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日");

                        if (dayOfMonth%2==0){
                            pro4_txt_judge.setText("双号出行车辆：2号");
                            judge = 2;
                        }else {
                            pro4_txt_judge.setText("单号出行车辆：1 3号");
                            judge = 1;
                        }
                        setswitch();
                        dialog.dismiss();
                    }
                });
            }
        });
   }

}

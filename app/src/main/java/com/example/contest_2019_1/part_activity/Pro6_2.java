package com.example.contest_2019_1.part_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.autonavi.amap.mapcore.interfaces.INavigateArrow;
import com.example.contest_2019_1.R;

import java.util.Calendar;

public class Pro6_2 extends AppCompatActivity {

    String date = "";
    Boolean isFirst = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.pro6_2);
        DatePicker pro6_dataprcker = findViewById(R.id.pro6_dataprcker);
        final TextView txt_pro6_2_date = findViewById(R.id.txt_pro6_2_date);
        Button btn_pro6_next2 = findViewById(R.id.btn_pro6_next2);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        btn_pro6_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pro6_2.this, Pro6_3.class);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });


        pro6_dataprcker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if (isFirst){
                    date = year+"-"+monthOfYear+"-"+dayOfMonth;
                    isFirst = false;
                }else {
                    date = date+"\n"+year+"-"+monthOfYear+"-"+dayOfMonth;
                }
                txt_pro6_2_date.setText(date);
            }

        });


    }
}

package com.example.contest_2019_1.part_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contest_2019_1.R;
import com.example.contest_2019_1.db.OutMesssage;

import org.litepal.LitePal;

public class Pro6_4 extends AppCompatActivity {

    private TextView txt_pro6_4_name;
    private TextView txt_pro6_4_phone;
    private TextView txt_pro6_4_place;
    private TextView txt_pro6_4_date;

    String name;
    String phone;
    String place;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.pro6_4);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        phone = intent.getStringExtra("phone");
        place = intent.getStringExtra("place");
        date = intent.getStringExtra("date");
        setdate();

        Button btn_pro6_4_commit = findViewById(R.id.btn_pro6_4_commit);
        btn_pro6_4_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMessage();
            }


        });

    }

    private void saveMessage() {
        LitePal.getDatabase();
        OutMesssage outMesssage = new OutMesssage();
        outMesssage.setName(name);
        outMesssage.setPhone(phone);
        outMesssage.setPlace(place);
        outMesssage.setDate(date);
        try {
            outMesssage.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "数据保存完成", Toast.LENGTH_SHORT).show();
    }
    private void setdate() {

        txt_pro6_4_name = findViewById(R.id.txt_pro6_4_name);
        txt_pro6_4_phone = findViewById(R.id.txt_pro6_4_phone);
        txt_pro6_4_place = findViewById(R.id.txt_pro6_4_place);
        txt_pro6_4_date = findViewById(R.id.txt_pro6_4_date);

        txt_pro6_4_name.setText(name);
        txt_pro6_4_phone.setText(phone);
        txt_pro6_4_place.setText(place);
        txt_pro6_4_date.setText(date);


    }
}

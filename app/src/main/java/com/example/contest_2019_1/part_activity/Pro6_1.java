package com.example.contest_2019_1.part_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contest_2019_1.R;

public class Pro6_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.pro6_1);

        Button btn_pro6_next1 = findViewById(R.id.btn_pro6_next1);
        btn_pro6_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pro6_1.this, Pro6_2.class);
                startActivity(intent);
            }
        });


    }
}

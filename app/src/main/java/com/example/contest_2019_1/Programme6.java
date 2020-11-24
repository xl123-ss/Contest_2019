package com.example.contest_2019_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.contest_2019_1.part_activity.Pro6_1;

public class Programme6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.programme6);

        LinearLayout pro6_ll_1 = findViewById(R.id.pro6_ll_1);
        pro6_ll_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Programme6.this, Pro6_1.class);
                startActivity(intent);
            }
        });
    }
}

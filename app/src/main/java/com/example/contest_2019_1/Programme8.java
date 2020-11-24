package com.example.contest_2019_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.contest_2019_1.fragment_pro8.Fra_pro8_myRoad;
import com.example.contest_2019_1.fragment_pro8.Fra_pro8_roadEnviroment;

public class Programme8 extends AppCompatActivity {

    Fra_pro8_myRoad fra_pro8_myRoad;
    Fra_pro8_roadEnviroment fra_pro8_roadEnviroment;
    TextView txt_pro8_myRoad;
    TextView txt_pro8_roadEnvironment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.programme8);

        init();
        changeFragment(fra_pro8_myRoad);




    }

    private void init() {
        fra_pro8_myRoad = new Fra_pro8_myRoad();
        fra_pro8_roadEnviroment = new Fra_pro8_roadEnviroment();
        txt_pro8_myRoad = findViewById(R.id.txt_pro8_myRoad);
        txt_pro8_roadEnvironment = findViewById(R.id.txt_pro8_roadEnvironment);

        txt_pro8_myRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(fra_pro8_myRoad);
                txt_pro8_myRoad.setTypeface(Typeface.DEFAULT_BOLD);
                txt_pro8_roadEnvironment.setTypeface(Typeface.DEFAULT);
            }
        });

        txt_pro8_roadEnvironment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(fra_pro8_roadEnviroment);
                txt_pro8_myRoad.setTypeface(Typeface.DEFAULT);
                txt_pro8_roadEnvironment.setTypeface(Typeface.DEFAULT_BOLD);
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_pro8_show,fragment).commit();
    }
}

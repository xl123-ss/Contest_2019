package com.example.contest_2019_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.contest_2019_1.fragment_pro7.Fra_pro7_chargeRecord;
import com.example.contest_2019_1.fragment_pro7.Fra_pro7_control;
import com.example.contest_2019_1.fragment_pro7.Fra_pro7_myBalance;

public class Programme7 extends AppCompatActivity {
    Fra_pro7_myBalance fra_pro7_myBalance;
    Fra_pro7_control fra_pro7_control;
    Fra_pro7_chargeRecord fra_pro7_charge;

    TextView txt_pro7_mybalance;
    TextView txt_pro7_control;
    TextView txt_pro7_charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programme7);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        init();
        changeFragment(fra_pro7_myBalance);
    }

    private void init() {
        fra_pro7_myBalance = new Fra_pro7_myBalance();
        fra_pro7_control = new Fra_pro7_control();
        fra_pro7_charge = new Fra_pro7_chargeRecord();

        txt_pro7_mybalance = findViewById(R.id.txt_pro7_mybalance);
        txt_pro7_control = findViewById(R.id.txt_pro7_control);
        txt_pro7_charge = findViewById(R.id.txt_pro7_charge);
    }


    public void dosubmit3(View view){

        String carNo;
        switch (view.getId()){

            case R.id.txt_pro7_mybalance:
                changeFragment(fra_pro7_myBalance);
                txt_pro7_control.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                txt_pro7_mybalance.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
                txt_pro7_charge.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                break;

            case R.id.txt_pro7_control:
                changeFragment(fra_pro7_control);
                txt_pro7_control.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
                txt_pro7_mybalance.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                txt_pro7_charge.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                break;

            case R.id.txt_pro7_charge:
                changeFragment(fra_pro7_charge);
                txt_pro7_control.setTypeface(Typeface.DEFAULT);
                txt_pro7_mybalance.setTypeface(Typeface.DEFAULT);
                txt_pro7_charge.setTypeface(Typeface.DEFAULT_BOLD);
                break;

        }
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_pro7_show,fragment).commit();
    }






}

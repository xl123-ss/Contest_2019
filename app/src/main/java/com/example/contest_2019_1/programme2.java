package com.example.contest_2019_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

import static com.example.contest_2019_1.R.color.colorAccent;

public class programme2 extends AppCompatActivity {

    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;
    private LinearLayout l6;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;



    private Handler handler = new Handler();
    private Random random = new Random();
    int a;

    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            for (int i = 0;i<6; i++){
                a = random.nextInt(100);
                change(a,i+1);
            }

            handler.postDelayed(this,1000*3);

        }


        private void change(int a, int i){
            try {

                switch (i){

                    case 1:
                        if (a>70){
                            l1.setBackgroundResource(colorAccent);
                            btn1.setText(a+"");
                        }else {
                            l1.setBackgroundResource(R.color.colorPrimary);
                            btn1.setText(a+"");
                        }
                        break;

                    case 2:
                        if (a>70){
                            l2.setBackgroundResource(colorAccent);
                            btn2.setText(a+"");
                        }else {
                            l2.setBackgroundResource(R.color.colorPrimary);
                            btn2.setText(a+"");
                        }
                        break;

                    case 3:
                        if (a>70){
                            l3.setBackgroundResource(colorAccent);
                            btn3.setText(a+"");
                        }else {
                            l3.setBackgroundResource(R.color.colorPrimary);
                            btn3.setText(a+"");
                        }
                        break;

                    case 4:
                        if (a>70){
                            l4.setBackgroundResource(colorAccent);
                            btn4.setText(a+"");
                        }else {
                            l4.setBackgroundResource(R.color.colorPrimary);
                            btn4.setText(a+"");
                        }
                        break;


                    case 5:
                        if (a>70){
                            l5.setBackgroundResource(colorAccent);
                            btn5.setText(a+"");
                        }else {
                            l5.setBackgroundResource(R.color.colorPrimary);
                            btn5.setText(a+"");
                        }
                        break;


                    case 6:
                        if (a>70){
                            l6.setBackgroundResource(colorAccent);
                            btn6.setText(a+"");
                        }else {
                            l6.setBackgroundResource(R.color.colorPrimary);
                            btn6.setText(a+"");
                        }
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.programme2);

        init();
        handler.postDelayed(runnable,1000*3);




    }

    private void init(){

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}

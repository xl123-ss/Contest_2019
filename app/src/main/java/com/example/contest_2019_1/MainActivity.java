package com.example.contest_2019_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.contest_2019_1.helper.Helper;

public class MainActivity extends AppCompatActivity {

    Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new Helper(this);

//        Toolbar tooler= findViewById(R.id.tooler);
//        setSupportActionBar(tooler);
    }


    public void dosubmit(View view){

        switch (view.getId()){

            case R.id.btn_error1:
                error1();
                break;
            case R.id.btn_error2:
                error2();
                break;

//            case R.id.btn_error3:
//                error3();
//                break;
//            case R.id.btn_programme:
//                programme();
//                break;
        }
    }


    private void error1(){
        helper.error1();
    }

    private void error2(){
        helper.error2();
    }

//    private void error3(){
//        Intent intent = new Intent(this, error3.class);
//        startActivity(intent);
//    }

//    private void programme(){
//        Intent intent = new Intent(this, programme.class);
//        startActivity(intent);
//    }

}

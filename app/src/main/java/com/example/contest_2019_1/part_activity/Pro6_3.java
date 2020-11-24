package com.example.contest_2019_1.part_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contest_2019_1.R;

public class Pro6_3 extends AppCompatActivity {

    String name;
    String phone;
    String place;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.pro6_3);

        Intent intent = getIntent();
        date = intent.getStringExtra("date");

        Button btn_pro6_next3 = findViewById(R.id.btn_pro6_next3);
        btn_pro6_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
                Intent intent = new Intent(Pro6_3.this, Pro6_4.class);
                intent.putExtra("name",name);
                intent.putExtra("phone",phone);
                intent.putExtra("place",place);
                intent.putExtra("date",date);
                startActivity(intent);

            }


        });
    }

    private void data(){

        EditText edt_pro6_3_name = findViewById(R.id.edt_pro6_3_name);
        EditText edt_pro6_3_phone = findViewById(R.id.edt_pro6_3_phone);
        EditText edt_pro6_3_place = findViewById(R.id.edt_pro6_3_place);

        name = edt_pro6_3_name.getText().toString();
        phone = edt_pro6_3_phone.getText().toString();
        place = edt_pro6_3_place.getText().toString();

    }
}

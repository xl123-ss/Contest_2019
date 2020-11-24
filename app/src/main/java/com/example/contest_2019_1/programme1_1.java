package com.example.contest_2019_1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contest_2019_1.helper.Helper;

public class programme1_1 extends AppCompatActivity {

    Spinner spi_pro1_car;
    Helper helper;
    int position;
    TextView txt_pro1_balance;
    TextView txt_pro1_charge;
    String charge ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programme1_1);
        Log.e("www", "onCreate: ");
        helper = new Helper(this);
        txt_pro1_balance = findViewById(R.id.txt_pro1_blance);
        txt_pro1_charge = findViewById(R.id.txt_pro1_charge);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

       spi_pro1_car = findViewById(R.id.spi_pro1_car);
        final String[] data ={"1","2","3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.pro1_item_selected,data);



        spi_pro1_car.setAdapter(adapter);

        spi_pro1_car.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                programme1_1.this.position = position+1;

                String query = helper.query(position+1);
                txt_pro1_balance.setText(query+"元");
                Log.e("www", "wwwww："+position );


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Log.e("www", "初始化："+position );

    }







    public void dosubmit1(View view){

        switch (view.getId()){

            case R.id.btn_pro1_query:
                String query = helper.query(position);
                txt_pro1_balance.setText(query+"元");

                break;

            case R.id.btn_pro1_charge:
                charge();
                break;
        }
    }



    private  void charge() {

        final String[] charge = new String[1];



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.pro1_view, null);
        Button btn_pro1_confire = inflate.findViewById(R.id.btn_pro1_confire);
        Button btn_pro1_cancle = inflate.findViewById(R.id.btn_pro1_cancle);

        final EditText edt_pro_input = inflate.findViewById(R.id.edt_pro_input);
        final AlertDialog dialog = builder.setTitle("充值")
                .setView(inflate)
                .show();
        dialog.setCanceledOnTouchOutside(false);

        btn_pro1_confire.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                charge[0] = edt_pro_input.getText().toString();
                if (edt_pro_input.getText().toString().equals("")) {
                    Toast.makeText(programme1_1.this, "请输入金额", Toast.LENGTH_SHORT).show();
                    
                } else {
                    Toast.makeText(programme1_1.this,"您充值了"+ charge[0], Toast.LENGTH_SHORT).show();
                    txt_pro1_charge.setText(charge[0] + "元");
                    
                    if (!charge[0].equals("")){
                        

                        helper.add(position, charge[0]);
                        String query1 = helper.query(position);
                        txt_pro1_balance.setText(query1 + "元");
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Message message = new Message();
//                                message.what = 1;
//                                handler.sendMessage(message);
//                            }
//                        });

                    }
                    charge[0] ="";
                    dialog.dismiss();
                    
                }

              

            }
        });
        btn_pro1_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(programme1_1.this, "您取消了充值", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

//        Toast.makeText(this, "wwww", Toast.LENGTH_SHORT).show();
        
    }

    

}

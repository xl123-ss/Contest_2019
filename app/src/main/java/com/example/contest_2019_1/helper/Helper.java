package com.example.contest_2019_1.helper;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contest_2019_1.R;

public class Helper extends AppCompatActivity {

    AppCompatActivity activity;

    public Helper(AppCompatActivity activity) {
        this.activity = activity;

    }

    MyDbHelp dbHelp;
    SQLiteDatabase db;


    public void error1(){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View inflate_title = LayoutInflater.from(activity).inflate(R.layout.error1_head,null);
        View inflate_view = LayoutInflater.from(activity).inflate(R.layout.error1_view,null);
        Button btn_error1_login = inflate_view.findViewById(R.id.btn_error1_login);
        Button btn_error1_register = inflate_view.findViewById(R.id.btn_error1_register);

        final AlertDialog dialog = builder.setCustomTitle(inflate_title)
                .setView(inflate_view)
                .show();

        dialog.setCanceledOnTouchOutside(false);
        btn_error1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btn_error1_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "开始注册", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }

    public void error2() {

        View inflate_view = LayoutInflater.from(activity).inflate(R.layout.error2_view, null);
        View inflate_title = LayoutInflater.from(activity).inflate(R.layout.error2_title, null);
        Button btn_error2_cancle = inflate_view.findViewById(R.id.btn_error2_cancle);
        Button btn_error2_confire = inflate_view.findViewById(R.id.btn_error2_confire);
        final EditText edt_error2_porn = inflate_view.findViewById(R.id.edt_error2_porn);
        final EditText edt_error2_ip = inflate_view.findViewById(R.id.edt_error2_ip);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog dialog = builder.setTitle("Setting")
                .setView(inflate_view)
                .setCustomTitle(inflate_title)
                .show();

        dialog.setCanceledOnTouchOutside(false);

        btn_error2_confire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ip = edt_error2_ip.getText().toString();
                String porn = edt_error2_porn.getText().toString();


                if (!(ip.equals("") || porn.equals(""))){

                    Integer porn2 = Integer.valueOf(porn);
                    if (porn2>=0 && porn2 <=65535){
                        Toast.makeText(activity, "输入正确", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else {
                        Toast.makeText(activity, "输入有误，请重新输入！", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(activity, "请输入数据", Toast.LENGTH_SHORT).show();
                }




            }
        });

        btn_error2_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "取消", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });




    }

    public void create() {
        dbHelp = new MyDbHelp(activity, "MyAccount.db", null, 1);
        db = dbHelp.getWritableDatabase();

    }

    public void add(int position, String charge){
        create();
        //初始化
//        String sql = "insert into account(balance,charge) values(55,0)";
//        String sql2 = "insert into account(balance,charge) values(0,0)";
//        String sql3 = "insert into account(balance,charge) values(0,0)";

        String sql = "update account set balance = ? where carNo = ?";
        String query = query(position);
        int account;
        if (query.equals("")){
            account = 0;
        }else {
            account = Integer.valueOf(query);
        }
        account = account +Integer.valueOf(charge);


        try {
            db.execSQL(sql,new String[]{""+account,""+position});
        }catch (Exception e){
            e.printStackTrace();
        }






//        Toast.makeText(activity, "初始化成功", Toast.LENGTH_SHORT).show();

    }
    public String query(int position){

        create();

        String sql ="select * from account where carNo = ?";
        String po =""+position;

        Cursor cursor = db.rawQuery(sql, new String[]{po});
        if (cursor.moveToNext()){
            String blance = cursor.getString(cursor.getColumnIndex("balance"));
            return blance;
        }


        return "";
    }

}

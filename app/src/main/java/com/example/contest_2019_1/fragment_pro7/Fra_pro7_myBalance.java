package com.example.contest_2019_1.fragment_pro7;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.contest_2019_1.Programme7;
import com.example.contest_2019_1.R;
import com.example.contest_2019_1.db.ChargeRecord;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Fra_pro7_myBalance extends Fragment {

    View view;
    private LinearLayout ll_pro7_balance_show1;
    private LinearLayout ll_pro7_balance_show2;
    private LinearLayout ll_pro7_balance_show3;
    private LinearLayout ll_pro7_balance_show4;

    private TextView txt_pro7_balance_show1;
    private TextView txt_pro7_balance_show2;
    private TextView txt_pro7_balance_show3;
    private TextView txt_pro7_balance_show4;

    private TextView txt_pro7_balance_write1;
    private TextView txt_pro7_balance_write2;
    private TextView txt_pro7_balance_write3;
    private TextView txt_pro7_balance_write4;

    Handler handler = new Handler();
    Runnable runnable;

    int i = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pro7_mybalance, container, false);
        this.view = view;
        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();

        final Random random = new Random();
        runnable = new Runnable() {
            @Override
            public void run() {
                int a = 0, i;
                for (i = 1; i <= 4; i++) {
                    a = random.nextInt(300);
                    change(a, i);
                }
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable,3000);

        setAlert();

    }

    private void setAlert() {
        ll_pro7_balance_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show("1");
            }
        });


        ll_pro7_balance_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show("2");
            }
        });

        ll_pro7_balance_show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show("3");
            }
        });


        ll_pro7_balance_show4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show("4");
            }
        });



    }

    private void show(final String carNo){

        View pro7_mybalance_alert1_head = LayoutInflater.from(getActivity()).inflate(R.layout.pro7_mybalance_alert1_head, null);
        View pro7_mybalance_alert1_view = LayoutInflater.from(getActivity()).inflate(R.layout.pro7_mybalance_alert1_view, null);

        final androidx.appcompat.app.AlertDialog dialog = new AlertDialog.Builder(getActivity()).setCustomTitle(pro7_mybalance_alert1_head)
                .setView(pro7_mybalance_alert1_view)
                .show();

        final EditText edt_pro7_charge = pro7_mybalance_alert1_view.findViewById(R.id.edt_pro7_charge);
        Button btn_pro7_confirm = pro7_mybalance_alert1_view.findViewById(R.id.btn_pro7_confirm);
        Button btn_pro7_cancle = pro7_mybalance_alert1_view.findViewById(R.id.btn_pro7_cancle);

        edt_pro7_charge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("rrrr", "onTextChanged: "+s);
                if (!s.toString().isEmpty()){
                    int value = Integer.valueOf(s.toString());
                    if (value > 50) {
                        edt_pro7_charge.setText(50 + "");
                    }
                } else {
                    edt_pro7_charge.setText(0+" ");
                }

                edt_pro7_charge.setSelection(edt_pro7_charge.getText().length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn_pro7_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String charge = edt_pro7_charge.getText().toString();
                Toast.makeText(getActivity(), carNo+"号小车充值"+charge+"元成功", Toast.LENGTH_SHORT).show();
                save(carNo,charge);
                dialog.dismiss();

            }


        });

        btn_pro7_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), carNo+"号小车失败", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    private void save(String carNo, String charge) {

        LitePal.getDatabase();
        ChargeRecord last = DataSupport.findLast(ChargeRecord.class);
        int id = last.getId();
        ChargeRecord chargeRecord = new ChargeRecord();


        chargeRecord.setId(id+1);
        chargeRecord.setCarNO(carNo);
        chargeRecord.setCharge(charge);
        String date = date();
        chargeRecord.setDate(date);
        chargeRecord.save();
        Log.e("wwww", "save sucessful");

    }

    private String date(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTine= dateFormat.format(date);
        return dateTine;
    }


    private void change(int a,int i) {

        switch (i){

            case 1:
                if (a>=100){
                    ll_pro7_balance_show1.setBackgroundResource(R.color.colorPrimary);
                    txt_pro7_balance_show1.setText("正常");
                    txt_pro7_balance_write1.setText(a+"");
                }else {
                    ll_pro7_balance_show1.setBackgroundResource(R.color.colorAccent);
                    txt_pro7_balance_show1.setText("预警");
                    txt_pro7_balance_write1.setText(a+"");
                }
                break;

            case 2:
                if (a>=100){
                    ll_pro7_balance_show2.setBackgroundResource(R.color.colorPrimary);
                    txt_pro7_balance_show2.setText("正常");
                    txt_pro7_balance_write2.setText(a+"");
                }else {
                    ll_pro7_balance_show2.setBackgroundResource(R.color.colorAccent);
                    txt_pro7_balance_show2.setText("预警");
                    txt_pro7_balance_write2.setText(a+"");
                }
                break;

            case 3:
                if (a>=100){
                    ll_pro7_balance_show3.setBackgroundResource(R.color.colorPrimary);
                    txt_pro7_balance_show3.setText("正常");
                    txt_pro7_balance_write3.setText(a+"");
                }else {
                    ll_pro7_balance_show3.setBackgroundResource(R.color.colorAccent);
                    txt_pro7_balance_show3.setText("预警");
                    txt_pro7_balance_write3.setText(a+"");
                }
                break;

            case 4:
                if (a>=100){
                    ll_pro7_balance_show4.setBackgroundResource(R.color.colorPrimary);
                    txt_pro7_balance_show4.setText("正常");
                    txt_pro7_balance_write4.setText(a+"");
                }else {
                    ll_pro7_balance_show4.setBackgroundResource(R.color.colorAccent);
                    txt_pro7_balance_show4.setText("预警");
                    txt_pro7_balance_write4.setText(a+"");
                }
                break;
        }
    }

    private void init() {
        ll_pro7_balance_show1 = view.findViewById(R.id.ll_pro7_balance_show1);
        ll_pro7_balance_show2 = view.findViewById(R.id.ll_pro7_balance_show2);
        ll_pro7_balance_show3 = view.findViewById(R.id.ll_pro7_balance_show3);
        ll_pro7_balance_show4 = view.findViewById(R.id.ll_pro7_balance_show4);

        txt_pro7_balance_show1 = view.findViewById(R.id.txt_pro7_balance_show1);
        txt_pro7_balance_show2 = view.findViewById(R.id.txt_pro7_balance_show2);
        txt_pro7_balance_show3 = view.findViewById(R.id.txt_pro7_balance_show3);
        txt_pro7_balance_show4 = view.findViewById(R.id.txt_pro7_balance_show4);

        txt_pro7_balance_write1 = view.findViewById(R.id.txt_pro7_balance_write1);
        txt_pro7_balance_write2 = view.findViewById(R.id.txt_pro7_balance_write2);
        txt_pro7_balance_write3 = view.findViewById(R.id.txt_pro7_balance_write3);
        txt_pro7_balance_write4 = view.findViewById(R.id.txt_pro7_balance_write4);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

}

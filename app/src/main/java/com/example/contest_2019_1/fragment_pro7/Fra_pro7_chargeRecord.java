package com.example.contest_2019_1.fragment_pro7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contest_2019_1.R;
import com.example.contest_2019_1.db.ChargeRecord;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class Fra_pro7_chargeRecord extends Fragment {
    private View view;

    private TextView txt_pro7_charge_show1;
    private ListView lv_pro7_charge_1;

    private String[] data;
    private StringBuilder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pro7_charge, container,false);
        this.view = view;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_pro7_charge_show1 = view.findViewById(R.id.txt_pro7_charge_show1);
        lv_pro7_charge_1 = view.findViewById(R.id.lv_pro7_charge_1);
        read();


    }

    private void read(){
        List<ChargeRecord> records = DataSupport.findAll(ChargeRecord.class);

        if (records.size() != 0){
//            Toast.makeText(getContext(), "数据为空", Toast.LENGTH_SHORT).show();
            builder = new StringBuilder();
            txt_pro7_charge_show1.setVisibility(View.GONE);
            for (ChargeRecord record:records){

                int id = record.getId();
                String carNO = record.getCarNO();
                String charge = record.getCharge();
                String date = record.getDate();

                String s1 = "           "+id+"                       "+carNO+
                        "               "+charge+"                          "+date+"&";

                builder.append(s1);


            }

            setList();
        }

    }

    private void setList() {
        data = builder.toString().split("&");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,data);
        lv_pro7_charge_1.setAdapter(adapter);
    }
}

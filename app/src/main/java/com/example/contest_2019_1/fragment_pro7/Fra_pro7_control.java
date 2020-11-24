package com.example.contest_2019_1.fragment_pro7;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contest_2019_1.R;

public class Fra_pro7_control extends Fragment{

    View view;
    Button btn_pro7_control_1;
    Button btn_pro7_control_2;

    Button btn_pro7_contro2_1;
    Button btn_pro7_contro2_2;

    Button btn_pro7_contro3_1;
    Button btn_pro7_contro3_2;

    Button btn_pro7_contro4_1;
    Button btn_pro7_contro4_2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pro7_control, container,false);
        this.view = view;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initButton();
        setButton();

    }

    private void setButton() {

        btn_pro7_control_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_control_1.setBackgroundColor(Color.GREEN);
                btn_pro7_control_2.setBackgroundColor(Color.WHITE);
            }
        });
        btn_pro7_control_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_control_1.setBackgroundColor(Color.WHITE);
                btn_pro7_control_2.setBackgroundColor(Color.GREEN);
            }
        });


        btn_pro7_contro2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_contro2_1.setBackgroundColor(Color.GREEN);
                btn_pro7_contro2_2.setBackgroundColor(Color.WHITE);
            }
        });
        btn_pro7_contro2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_contro2_1.setBackgroundColor(Color.WHITE);
                btn_pro7_contro2_2.setBackgroundColor(Color.GREEN);
            }
        });


        btn_pro7_contro3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_contro3_1.setBackgroundColor(Color.GREEN);
                btn_pro7_contro3_2.setBackgroundColor(Color.WHITE);
            }
        });
        btn_pro7_contro3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_contro3_1.setBackgroundColor(Color.WHITE);
                btn_pro7_contro3_2.setBackgroundColor(Color.GREEN);
            }
        });


        btn_pro7_contro4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_contro4_1.setBackgroundColor(Color.GREEN);
                btn_pro7_contro4_2.setBackgroundColor(Color.WHITE);
            }
        });
        btn_pro7_contro4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_pro7_contro4_1.setBackgroundColor(Color.WHITE);
                btn_pro7_contro4_2.setBackgroundColor(Color.GREEN);
            }
        });



    }

    private void initButton() {
        btn_pro7_control_1 = view.findViewById(R.id.btn_pro7_control_1);
        btn_pro7_control_2 = view.findViewById(R.id.btn_pro7_control_2);
        btn_pro7_control_1.setBackgroundColor(Color.WHITE);
        btn_pro7_control_2.setBackgroundColor(Color.GREEN);


        btn_pro7_contro2_1 = view.findViewById(R.id.btn_pro7_contro2_1);
        btn_pro7_contro2_2 = view.findViewById(R.id.btn_pro7_contro2_2);
        btn_pro7_contro2_1.setBackgroundColor(Color.WHITE);
        btn_pro7_contro2_2.setBackgroundColor(Color.GREEN);


        btn_pro7_contro3_1 = view.findViewById(R.id.btn_pro7_contro3_1);
        btn_pro7_contro3_2 = view.findViewById(R.id.btn_pro7_contro3_2);
        btn_pro7_contro3_1.setBackgroundColor(Color.WHITE);
        btn_pro7_contro3_2.setBackgroundColor(Color.GREEN);


        btn_pro7_contro4_1 = view.findViewById(R.id.btn_pro7_contro4_1);
        btn_pro7_contro4_2 = view.findViewById(R.id.btn_pro7_contro4_2);
        btn_pro7_contro4_1.setBackgroundColor(Color.WHITE);
        btn_pro7_contro4_2.setBackgroundColor(Color.GREEN);

    }




}

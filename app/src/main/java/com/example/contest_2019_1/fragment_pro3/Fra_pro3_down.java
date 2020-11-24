package com.example.contest_2019_1.fragment_pro3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contest_2019_1.R;
import com.example.contest_2019_1.programme3;

public class Fra_pro3_down extends Fragment {

    View view;
    RadioGroup radgoup;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pro3_fradown, container, false);
        this.view = view;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        innit();

    }
    public RadioGroup get(){


        return radgoup;
    }

    private void innit() {
        final programme3 activity = (programme3) getActivity();


        radgoup = view.findViewById(R.id.radgroup);


        radgoup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

//                Toast.makeText(activity, checkedId+"---"+R.id.btn2, Toast.LENGTH_SHORT).show();

                  switch (checkedId){
                      case R.id.rad1:
//                          Toast.makeText(activity, "www", Toast.LENGTH_SHORT).show();
                          activity.change1();
                          break;
                      case R.id.rad2:
                          activity.change2();
//                          Toast.makeText(activity, "ssss", Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.rad3:
                          activity.change3();
//                          Toast.makeText(activity, "ssss", Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.rad4:
                          activity.change4();
//                          Toast.makeText(activity, "ssss", Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.rad5:
                          activity.change5();
//                          Toast.makeText(activity, "ssss", Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.rad6:
                          activity.change6();
//                          Toast.makeText(activity, "ssss", Toast.LENGTH_SHORT).show();
                          break;

                  }
            }
        });
    }
}

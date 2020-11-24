package com.example.contest_2019_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.contest_2019_1.fragment_pro3.Fra_pro3_down;
import com.example.contest_2019_1.fragment_pro3.Fra_pro3_line1;
import com.example.contest_2019_1.fragment_pro3.Fra_pro3_line2;
import com.example.contest_2019_1.fragment_pro3.Fra_pro3_line3;
import com.example.contest_2019_1.fragment_pro3.Fra_pro3_line4;
import com.example.contest_2019_1.fragment_pro3.Fra_pro3_line5;
import com.example.contest_2019_1.fragment_pro3.Fra_pro3_line6;
import com.example.contest_2019_1.fragment_pro3.Myfragment;

public class programme3 extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;
    private Fra_pro3_line1 fra_pro3_line1;
    private Fra_pro3_line2 fra_pro3_line2;
    private Fra_pro3_line3 fra_pro3_line3;
    private Fra_pro3_line4 fra_pro3_line4;
    private Fra_pro3_line5 fra_pro3_line5;
    private Fra_pro3_line6 fra_pro3_line6;
    RadioGroup group;
    private Fra_pro3_down fra_pro3_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programme3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 隐藏状态栏


        fra_pro3_line1 = new Fra_pro3_line1();
        fra_pro3_line2 = new Fra_pro3_line2();
        fra_pro3_line3 = new Fra_pro3_line3();
        fra_pro3_line4 = new Fra_pro3_line4();
        fra_pro3_line5 = new Fra_pro3_line5();
        fra_pro3_line6 = new Fra_pro3_line6();
        fra_pro3_down = new Fra_pro3_down();

        View inflate1 = getLayoutInflater().inflate(R.layout.pro3_fradown, null);
        group = inflate1.findViewById(R.id.radgroup);
//        int id = group.getId();
//        Log.e("eee", id+"" );
//        group = fra_pro3_down.get();




        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line1).commit();


         gestureDetector = new GestureDetector(this);

    }



    public void change1(){
        group.clearCheck();
        group.check(R.id.rad1);
        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line1).commit();

    }

    public void change2(){
        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line2).commit();

        group.clearCheck();
        group.check(R.id.rad2);

    }
    public void change3(){
        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line3).commit();
        group.clearCheck();
        group.check(R.id.rad3);
    }

    public void change4(){
        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line4).commit();
        group.clearCheck();
        group.check(R.id.rad4);
    }
    public void change5(){
        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line5).commit();
        group.clearCheck();
        group.check(R.id.rad5);
    }

    public void change6(){
        getSupportFragmentManager().beginTransaction().replace(R.id.pro3_llup,fra_pro3_line6).commit();
        group.clearCheck();
        group.check(R.id.rad6);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent e) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        Myfragment ff = (Myfragment) getSupportFragmentManager().findFragmentById(R.id.pro3_llup);
        if (e2.getX() - e1.getX() > 20) {//往右滑动
            ff.changeright();
            return true;
        } else if (e2.getX() - e1.getX() < -20) {//往左滑动
            ff.changeleft();
            return true;
        }

        return false;
    }
}

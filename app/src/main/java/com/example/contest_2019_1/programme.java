package com.example.contest_2019_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.Window;

import com.example.contest_2019_1.helper.Helper;
import com.google.android.material.navigation.NavigationView;

public class programme extends AppCompatActivity {


    Helper helper = new Helper(this);

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programme);
        init();
        initLogin();
    }

    private void initLogin() {
        helper.error2();//在后面的反而先先弹出来
        helper.error1();

    }

    private void init() {

        Toolbar tooler= findViewById(R.id.tooler);
        setSupportActionBar(tooler);
        drawerLayout = findViewById(R.id.pro1_draw);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        NavigationView navigationView = findViewById(R.id.pro1_nav_view);
        navigationView.setCheckedItem(R.id.pro_menu_account);//默认我的账户被选中状态

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.pro_menu_account:
                        programme1();
                        break;

                    case R.id.pro_menu_enviroment:
                        programme2();
                        break;

                    case R.id.pro_menu_enviroment2:
                        programme3();
                        break;

                    case R.id.pro_menu_out:
                        programme4();
                        break;

                    case R.id.pro_menu_lifehelp:
                        programme5();
                        break;

                    case R.id.pro_menu_ordercar:
                        programme6();
                        break;

                    case R.id.pro_menu_myCar:
                        programme7();
                        break;

                    case R.id.pro_menu_myTraffic:
                        programme8();
                        break;

                }
                return true;
            }


        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;



        }
        return super.onOptionsItemSelected(item);
    }

    private void programme1(){
        Intent intent = new Intent(this, programme1_1.class);
        startActivity(intent);
    }

    private void programme2(){
        Intent intent = new Intent(this, programme2.class);
        startActivity(intent);
    }

    private void programme3(){
        Intent intent = new Intent(this, programme3.class);
        startActivity(intent);
    }

    private void programme4(){
        Intent intent = new Intent(this, Programme4.class);
        startActivity(intent);
    }

    private void programme5(){
        Intent intent = new Intent(this, Programme5.class);
        startActivity(intent);
    }

    private void programme6(){
        Intent intent = new Intent(this, Programme6.class);
        startActivity(intent);
    }

    private void programme7(){
        Intent intent = new Intent(this, Programme7.class);
        startActivity(intent);
    }

    private void programme8(){
        Intent intent = new Intent(this, Programme8.class);
        startActivity(intent);
    }
}

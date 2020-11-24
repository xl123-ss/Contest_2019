package com.example.contest_2019_1.fragment_pro8;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.contest_2019_1.R;
import com.example.contest_2019_1.error3;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Fra_pro8_myRoad extends Fragment {

    private View view;
    private Handler handler;
    private Boolean isSetting = false;

    private TextView txt_pro8_myraod_config_1;
    private TextView txt_pro8_myraod_config_2;
    private TextView txt_pro8_myraod_config_3;
    private TextView txt_pro8_myraod_config_4;
    private TextView txt_pro8_myraod_config_5;

    private EditText edt_pro8_myroad_red;
    private EditText edt_pro8_myroad_green;
    private EditText edt_pro8_myroad_yellow;

    private Button btn_pro8_myroad_left;
    private Button btn_pro8_myroad_right;
    private TextView txt_pro8_myroad_show1;
    private TextView txt_pro8_myroad_show1_2;
    private Button btn_pro8_crosswise1;
    private Button btn_pro8_lengthwayes1;

    private int red;
    private int green;
    private int yellow;
    private int green2 = 30;

    private Boolean isFirst = true;

    Timer timer;
    TimerTask timerTask;

    Timer timer1 = null;
    TimerTask timerTask1 = null;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pro8_myroad, container, false);
        this.view = view;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setTextConfig();
        handler();

        setTime();
        setCrosswise();



    }

    private void setCrosswise() {

    }

    private void setTime() {

        timer1 = new Timer();
        timerTask1 = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
        timer1.schedule(timerTask1,1000,1000);


            //纵向的改变
            btn_pro8_crosswise1.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    if (green2 ==30){

                        timer1.cancel();
                        timer1 = null;
                        timerTask1.cancel();
                        timerTask1 = null;
                        setTime2();
                        setNotifiction();

                    }

                }
            });


    }

    private void setNotifiction() {


        //1.建立NotificationManager，由于本案例是在fragment里写的，如果
        // 是在activity里,则应该为：NotificationManager manager = getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);



        //2.     8.0以后建立通道  8.0以前则不需要
        String id = "1";
        String name ="通道1";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {// 8.0以后建立通道
            //建立通道，第三个参数是优先级的意思
            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
            //需要让通知管理器manager与通道之间建立联系；
            manager.createNotificationChannel(channel);
            /**建立通知，
             * getContext():上下文
             *
             * id：这里是通道的id,即 String id = "1";
             */
            Notification notification = new Notification.Builder(getContext(), id)
                    //设置小图标
                    .setSmallIcon(R.drawable.ic_access_alarms_black_24dp)
                    /*
                        设置大图表，BitmapFactory.decodeResource(getResources(), R.drawable.football)
                        BitmapFactory.decodeResource()方法可得一个Bitmap对象
                     */
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.football))
                    //标题
                    .setContentTitle("通知")
                    //内容
                    .setContentText("绿灯已开启，完成任务")
                    //通知时间
                    .setWhen(System.currentTimeMillis())
                    //设置大图片或大图标
                    .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(
                            getResources(),R.drawable.football)))
                    .setDefaults(Notification.DEFAULT_ALL)
                    //触摸就小时
                    .setAutoCancel(true)
                    //跳转到其他界面
                    .setContentIntent(PendingIntent.getActivity(getContext(),0,new Intent(getActivity(),error3.class),
                            0))
                    .build();
                    //发送通知
            manager.notify(1,notification);

        }else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {//8.0以前则不需要通道
            //这里并不需要要通道的id
            Notification notification = new Notification.Builder(getContext())
                    .setSmallIcon(R.drawable.ic_access_alarms_black_24dp)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.football))
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle("通知1")
                    .setContentText("绿灯已开启，完成任务")
//                    .setContentIntent(PendingIntent.getActivity(getContext(),1,
//                            new Intent(getActivity(), error3.class),0)) //跳转到另外一个页面
                    .setAutoCancel(true)  //点击消失

                    .setDefaults(Notification.DEFAULT_ALL)  //系统默认模式：震动与闪光
                    .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(
                            getResources(),R.drawable.football)))//大图标或大文字
                    .setPriority(Notification.PRIORITY_MAX)  //优先级
                    .build();

            manager.notify(1,notification);
        }

        /*
            通知需要手动设置权限，才可有通知显示，当然，也可以引导用户设置权限
         */
        setPerssion();


    }

    private void setPerssion() {

        //首先要判断当前App的通知是否已经打开了：
        NotificationManagerCompat notification = NotificationManagerCompat.from(getContext());
        boolean isEnabled = notification.areNotificationsEnabled();
        //最后返回一个boolean值，true表示权限已经打开，false未打开。
        // 接下来就是，当未打开权限的情况下，怎么跳转到设置界面引导用户打开通知：
        if (!isEnabled) {
            //未打开通知
            AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                    .setTitle("提示")
                    .setMessage("请在“通知”中打开通知权限")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            Intent intent = new Intent();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                                intent.putExtra("android.provider.extra.APP_PACKAGE", getActivity().getPackageName());
                            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  //5.0
                                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                                intent.putExtra("app_package", getActivity().getPackageName());
                                intent.putExtra("app_uid", getActivity().getApplicationInfo().uid);
                            } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {  //4.4
                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                intent.addCategory(Intent.CATEGORY_DEFAULT);
                                intent.setData(Uri.parse("package:" +getActivity().getPackageName()));
                            } else if (Build.VERSION.SDK_INT >= 15) {
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package",getActivity().getPackageName(), null));
                            }
                            startActivity(intent);

                        }
                    })
                    .show();

//            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
//            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
        }
        //这样就可以跳转到设置界面了,然后此应用的全部屏蔽选项
    }

    private void setTime2() {

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 2;
                handler.sendMessage(message);
            }
        };

        setNotifiction();
        timer.schedule(timerTask,1000,1000);
    }

    private void setTextConfig() {
        txt_pro8_myraod_config_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("pppp", "onClick: ");
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View title = LayoutInflater.from(getContext()).inflate(R.layout.pro8_myroad_alert_title,null);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pro8_myroad_alert_view, null);

        Button btn_pro8_myroad_confire = view.findViewById(R.id.btn_pro8_myroad_confire);
        Button btn_pro8_myroad_cancle = view.findViewById(R.id.btn_pro8_myroad_cancle);
        ImageView ima_pro8_myroad_alert_title_close = title.findViewById(R.id.ima_pro8_myroad_alert_title_close);

        edt_pro8_myroad_red = view.findViewById(R.id.edt_pro8_myroad_red);
        edt_pro8_myroad_yellow = view.findViewById(R.id.edt_pro8_myroad_yellow);
        edt_pro8_myroad_green = view.findViewById(R.id.edt_pro8_myroad_green);

        edt_pro8_myroad_red.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")){
                    Integer value = Integer.valueOf(s.toString());
                    if (value > 30){
                        edt_pro8_myroad_red.setText(30+"");
                    }else if (value == 0){
                        edt_pro8_myroad_red.setText(1+"");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edt_pro8_myroad_yellow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")){
                    Integer value = Integer.valueOf(s.toString());
                    if (value > 30){
                        edt_pro8_myroad_red.setText(30+"");
                    }else if (value == 0){
                        edt_pro8_myroad_red.setText(1+"");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edt_pro8_myroad_green.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")){
                    Integer value = Integer.valueOf(s.toString());
                    if (value > 30){
                        edt_pro8_myroad_red.setText(30+"");
                    }else if (value == 0){
                        edt_pro8_myroad_red.setText(1+"");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        final AlertDialog dialog = builder.setCustomTitle(title)
                .setView(view)
                .setCancelable(false)
                .show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        btn_pro8_myroad_confire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isEmpy = isEmpty();
                if (isEmpy){
                    Toast.makeText(getActivity(), "配置失败，请重新提交", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), "1号路口的红绿灯信息配置成功", Toast.LENGTH_SHORT).show();
                    String configIn = getConfigInfo();
                    String[] split = configIn.split("&");
                    txt_pro8_myraod_config_1.setText("配置信息      绿灯"+split[2]+
                            "秒 黄灯"+split[1]+"秒 红灯"+split[0]+"秒   ");




                    dialog.dismiss();
                }
            }
        });

        btn_pro8_myroad_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ima_pro8_myroad_alert_title_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private String getConfigInfo() {
        String red = edt_pro8_myroad_red.getText().toString();
        String green = edt_pro8_myroad_green.getText().toString();
        String yellow = edt_pro8_myroad_yellow.getText().toString();
        return red+"&"+yellow+"&"+green;
    }

    private Boolean isEmpty() {

        String red = edt_pro8_myroad_red.getText().toString();
        String green = edt_pro8_myroad_green.getText().toString();
        String yellow = edt_pro8_myroad_yellow.getText().toString();
        if (red.equals("") || green.equals("")||yellow.equals("")){
            return true;
        }
        isSetting = true;
        isFirst = true;
        return false;
    }

    private void init() {

        txt_pro8_myraod_config_1 = view.findViewById(R.id.txt_pro8_myroad_config_1);
        txt_pro8_myraod_config_2 = view.findViewById(R.id.txt_pro8_myroad_config_2);
        txt_pro8_myraod_config_3 = view.findViewById(R.id.txt_pro8_myroad_config_3);
        txt_pro8_myraod_config_4 = view.findViewById(R.id.txt_pro8_myroad_config_4);
        txt_pro8_myraod_config_5 = view.findViewById(R.id.txt_pro8_myroad_config_5);


        btn_pro8_myroad_left = view.findViewById(R.id.btn_pro8_myroad_left);
        btn_pro8_myroad_right = view.findViewById(R.id.btn_pro8_myroad_right);
        txt_pro8_myroad_show1 = view.findViewById(R.id.txt_pro8_myroad_show1);
        txt_pro8_myroad_show1_2 = view.findViewById(R.id.txt_pro8_myroad_show1_2);
        btn_pro8_crosswise1 = view.findViewById(R.id.btn_pro8_crosswise1);
        btn_pro8_lengthwayes1 = view.findViewById(R.id.btn_pro8_lengthwayes1);


        
    }

    private void handler() {

        final int[] red1 = new int[1];
        final int[] green1 = new int[1];
        final int[] yellow1 = new int[1];


        handler = new Handler(){




            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what ==1){

                    if (isFirst) {
                        String info;

                        if(isSetting){
                            info = getConfigInfo();//红黄绿

                        }else {
                            info = "5&5&5";
                        }

                        String[] split = info.split("&");
                        red = Integer.valueOf(split[0]);
                        yellow = Integer.valueOf(split[1]);
                        green = Integer.valueOf(split[2]);

                        red1[0] = red;
                        yellow1[0] = yellow;
                        green1[0] = green;
                        isFirst = false;

                    }
                }


                super.handleMessage(msg);
                switch (msg.what){


                    case 1:
                        Log.e("dddd", "handleMessage: ");

                        if (red>0){
                            txt_pro8_myroad_show1.setText("横向状态  红灯"+red+"秒");
                            btn_pro8_myroad_left.setBackgroundResource(R.drawable.shape_red);
                            btn_pro8_myroad_left.setText(red+"");
                            red--;
                        }else if (yellow>0){
                            txt_pro8_myroad_show1.setText("横向状态  黄灯"+ yellow +"秒");
                            btn_pro8_myroad_left.setText(yellow+"");
                            btn_pro8_myroad_left.setBackgroundResource(R.drawable.shape_yellow);

                            yellow--;
                        }else if (green >0){
                            txt_pro8_myroad_show1.setText("横向状态  绿灯"+green +"秒");
                            btn_pro8_myroad_left.setText(green+"");
                            btn_pro8_myroad_left.setBackgroundResource(R.drawable.shape_green);
                            green--;
                        }else {
                            red = red1[0];
                            yellow = yellow1[0];
                            green = green1[0];
                        }
                        break;

                    case 2:
                        if (green2>0){
                            txt_pro8_myroad_show1.setText("横向状态  绿灯"+green2+"秒");
                            btn_pro8_myroad_left.setBackgroundResource(R.drawable.shape_green);
                            btn_pro8_myroad_left.setText(green2+"");
                            green2--;
                        }else {
                            green2 = 30;
                            timer.cancel();
                            timer =null;
                            timerTask.cancel();
                            timerTask = null;
                            setTime();
                        }

                        break;

                }
            }
        };

    }



}

package com.example.asus.notification;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends Activity implements View.OnClickListener {

    Button btnShow, btnClear;
    NotificationManager manager;
    Notification myNotication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = (Button) findViewById(R.id.send_notice);
        btnShow.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.clear_notice);


        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }


            @Override
            public void onClick(View v) {
            switch (v.getId()){
                case R.id.send_notice:
                //API level 11
                Intent intent = new Intent(this,NotificationActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);

                builder.setAutoCancel(false);
                builder.setTicker("this is ticker text");
                builder.setContentTitle("WhatsApp Notification");
                builder.setContentText("You have a new message");
                builder.setSmallIcon(R.drawable.cat);
                builder.setContentIntent(pendingIntent);
                builder.setOngoing(true);
               // builder.setSubText("This is subtext...");//API level 16
                builder.setNumber(100);
               // builder.build();

                myNotication = builder.getNotification();
                manager.notify(1, myNotication);

                /*
                //API level 8
                Notification myNotification8 = new Notification(R.drawable.ic_launcher, "this is ticker text 8", System.currentTimeMillis());

                Intent intent2 = new Intent(MainActivity.this, SecActivity.class);
                PendingIntent pendingIntent2 = PendingIntent.getActivity(getApplicationContext(), 2, intent2, 0);
                myNotification8.setLatestEventInfo(getApplicationContext(), "API level 8", "this is api 8 msg", pendingIntent2);
                manager.notify(11, myNotification8);
                */

            }
       // });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                manager.cancel(11);
            }
        });
    }




}
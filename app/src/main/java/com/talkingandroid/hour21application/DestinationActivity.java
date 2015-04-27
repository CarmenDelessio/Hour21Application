package com.talkingandroid.hour21application;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class DestinationActivity extends Activity {
    public static String ID = "com.talkingandroid.hour21application.notificationId";
    public static String MESSAGE = "com.talkingandroid.hour21application.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        Intent intent = getIntent();
        if (intent.hasExtra(ID)){
            int notificationId = intent.getIntExtra(ID,0);
            NotificationManager  notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationId==2){
                Notification.Builder builder =
                        new Notification.Builder(this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setAutoCancel(true)
                                .setContentTitle("Updated Notification")
                                .setContentText("Updated from Destination Activity");
                notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(notificationId, builder.build());
            } else{
                notificationManager.cancel(notificationId);
            }
        }
        if (intent.hasExtra(MESSAGE)){
            TextView textView = (TextView)findViewById(R.id.textView);
            String message = intent.getStringExtra(MESSAGE);
            textView.setText(message);
        }
    }

}

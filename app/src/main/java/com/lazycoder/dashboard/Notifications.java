package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class Notifications extends AppCompatActivity {

    public static final int NOTIFICATION_ID = 1;
    //there can be multiple notifications so it can be used as notification identity
    private static final String CHANNEL_ID = "channel_id01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Button showNotificattionBtn = findViewById(R.id.button);
        showNotificattionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click button to show notification
                showNotification();
            }
        });
    }

    private void showNotification() {
        createNotificationChannel();

        //inflating the views (custom_normal.xml and custom_expanded.xml)
        RemoteViews remoteCollapsedViews = new RemoteViews(getPackageName(), R.layout.normal_notifications);
        RemoteViews remoteExpandedViews = new RemoteViews(getPackageName(), R.layout.expand_notifications);

        //start this(MainActivity) on by Tapping notification
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent mainPIntent = PendingIntent.getActivity(this, 0,
                mainIntent, PendingIntent.FLAG_ONE_SHOT);

        //creating notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        //icon
        builder.setSmallIcon(R.drawable.ic_notifications);
        //set priority
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        //dismiss on tap
        builder.setAutoCancel(true);
        //start intent on notification tap (MainActivity)
        builder.setContentIntent(mainPIntent);
        //custom style
        builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        builder.setCustomContentView(remoteCollapsedViews);
        builder.setCustomBigContentView(remoteExpandedViews);

        //notification manager
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "My Notification";
            String description = "My notification description";
            //importance of your notification
            int importance = NotificationManager.IMPORTANCE_DEFAULT;


            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}


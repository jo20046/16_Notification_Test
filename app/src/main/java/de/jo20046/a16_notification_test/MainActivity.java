package de.jo20046.a16_notification_test;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Notification channels
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel1 = new NotificationChannel("channel1", "Channel 1", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel1);
        NotificationChannel notificationChannel2 = new NotificationChannel("channel2", "Channel 2", NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(notificationChannel2);
        NotificationChannel notificationChannel3 = new NotificationChannel("channel3", "Channel 3", NotificationManager.IMPORTANCE_LOW);
        notificationManager.createNotificationChannel(notificationChannel3);

        // Create notifications in button listeners
        findViewById(R.id.btnNotif1).setOnClickListener(v -> {
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), "channel1")
                    .setSmallIcon(R.drawable.ic_stat_check)
                    .setContentTitle("Test")
                    .setContentText("Default");
            Notification notification = builder.build();
            notificationManager.notify(1, notification);
        });
        findViewById(R.id.btnNotif2).setOnClickListener(v -> {
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), "channel2")
                    .setSmallIcon(R.drawable.ic_stat_check)
                    .setContentTitle("Test")
                    .setContentText("HIGH");
            Notification notification = builder.build();
            notificationManager.notify(2, notification);
        });
        findViewById(R.id.btnNotif3).setOnClickListener(v -> {
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), "channel3")
                    .setSmallIcon(R.drawable.ic_stat_check)
                    .setContentTitle("Test")
                    .setContentText("LOW");
            Notification notification = builder.build();
            notificationManager.notify(3, notification);
        });
    }

}
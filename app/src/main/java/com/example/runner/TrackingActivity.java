package com.example.runner;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TrackingActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";
    private Chronometer chronometer;
    private Button btnStartStop;
    private boolean isRunning = false;
    private double distanceKm = 0.0;
    private TextView tvDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        chronometer = findViewById(R.id.chronometer);
        btnStartStop = findViewById(R.id.btnStartStop);

        btnStartStop.setOnClickListener(v -> {
            if (!isRunning) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                btnStartStop.setText("Стоп");
            } else {
                chronometer.stop();
                btnStartStop.setText("Старт");
                findRunInBackground();
            }
            isRunning = !isRunning;
        });
    }

    private void findRunInBackground(){
        new Thread(()->{
            double avgPace = calculateAveragePace(distanceKm, 25.0);

            runOnUiThread(() -> {
                run run = new run(0, "04.08.2026", distanceKm, "25:00");
                Intent intent = new Intent(TrackingActivity.this, ResultActivity.class);
                intent.putExtra("run", run);
                startActivity(intent);
            });
        }).start();
    }

    private double calculateAveragePace(double distanceKm, double durationMinutes) {
        if (distanceKm == 0) return 0;
        return durationMinutes / distanceKm;
    }

}
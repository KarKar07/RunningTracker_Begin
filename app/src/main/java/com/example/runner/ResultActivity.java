package com.example.runner;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        run run = (run) getIntent().getSerializableExtra("run");

        TextView tvResult = findViewById(R.id.tvResult);
        if (run != null) {
            tvResult.setText(String.format("Дистанция: %.2f км\nВремя: %s", run.distanceKm, run.duration));
        }
    }
}
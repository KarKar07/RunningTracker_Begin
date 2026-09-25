package com.example.runner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean useMiles = false;

    private final ActivityResultLauncher<Intent> settingsLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    useMiles = result.getData().getBooleanExtra("useMiles", false);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartStop).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TrackingActivity.class)));

        findViewById(R.id.btnHistory).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, HistoryActivity.class)));

        findViewById(R.id.btnStats).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, StatsActivity.class)));

        findViewById(R.id.btnSettings).setOnClickListener(v ->
                settingsLauncher.launch(new Intent(MainActivity.this, SettingsActivity.class)));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            settingsLauncher.launch(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.runner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starts);

        showFragment(StatsFragment.newInstance("week"));

        findViewById(R.id.btnWeek).setOnClickListener(v -> showFragment(StatsFragment.newInstance("week")));
        findViewById(R.id.btnMonth).setOnClickListener(v -> showFragment(StatsFragment.newInstance("month")));
        findViewById(R.id.btnYear).setOnClickListener(v -> showFragment(StatsFragment.newInstance("year")));
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.statsContainer, fragment)
                .commit();
    }
}
package com.example.runner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        RecyclerView recyclerView = findViewById(R.id.recyclerHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<run> testRuns = new ArrayList<>();
        testRuns.add(new run(1, "30.07.2026", 5.2, "28:14"));
        testRuns.add(new run(2, "28.07.2026", 3.8, "21:02"));

        recyclerView.setAdapter(new RunAdapter(testRuns));
    }
}

package com.example.runner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RadioGroup rgUnits = findViewById(R.id.rgUnits);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            int checkedId = rgUnits.getCheckedRadioButtonId();
            RadioButton selected = findViewById(checkedId);
            boolean useMiles = selected.getText().toString().equals("Мили");

            Intent resultIntent = new Intent();
            resultIntent.putExtra("useMiles", useMiles);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
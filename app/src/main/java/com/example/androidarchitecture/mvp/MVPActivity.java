package com.example.androidarchitecture.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidarchitecture.R;
import com.example.androidarchitecture.activities.MainActivity;

public class MVPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        updateUI();
    }

    private void updateUI() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        ListView listView = findViewById(R.id.mvp);
        setTitle(message);

    }
}
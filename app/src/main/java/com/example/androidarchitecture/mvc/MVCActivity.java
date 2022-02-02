package com.example.androidarchitecture.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidarchitecture.R;
import com.example.androidarchitecture.activities.MainActivity;
import com.example.androidarchitecture.mvvm.MVVMActivity;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        updateUI();
    }

    private void updateUI() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        setTitle(message);

        listView = findViewById(R.id.mvc);
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVCActivity.this, list.get(i) + " clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> countries = new ArrayList<>();
        countries.add("Turkey");
        countries.add("Usa");
        countries.add("Norway");
        setValues(countries);
    }

    private void setValues(List<String> values){
        list.clear();
        list.addAll(values);
        adapter.notifyDataSetChanged();
    }
}
package com.example.androidarchitecture.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidarchitecture.R;
import com.example.androidarchitecture.activities.MainActivity;
import com.example.androidarchitecture.adapter.CustomListViewAdapter;
import com.example.androidarchitecture.model.Model;
import com.example.androidarchitecture.mvp.CountriesPresenter;
import com.example.androidarchitecture.mvp.MVPActivity;
import com.example.androidarchitecture.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MVVMActivity extends AppCompatActivity {

    private ArrayList<Model> list = new ArrayList<>();
    private CustomListViewAdapter adapter;
    private ListView listView;
    private CountriesViewModel countriesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);

        updateUI();
    }

    private void updateUI() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        setTitle(message);

        countriesViewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);
        listView = findViewById(R.id.mvvm);
        adapter = new CustomListViewAdapter(this, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVVMActivity.this, list.get(i) + " clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        observeViewModel();
    }

    private void observeViewModel() {
        countriesViewModel.getCountries().observe(this, countries ->{
            if (countries!=null){
                list.clear();
                list.addAll(countries);
                adapter.notifyDataSetChanged();
            }else{
                Toast.makeText(this, "Countries are empty", Toast.LENGTH_SHORT).show();
            }
        });

        countriesViewModel.getCountryErrors().observe(this, error -> {
            if (error){
                Toast.makeText(this,"Error Occurred",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
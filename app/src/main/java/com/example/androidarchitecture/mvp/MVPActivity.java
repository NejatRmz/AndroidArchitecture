package com.example.androidarchitecture.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidarchitecture.R;
import com.example.androidarchitecture.activities.MainActivity;
import com.example.androidarchitecture.adapter.CustomListViewAdapter;
import com.example.androidarchitecture.model.Model;
import com.example.androidarchitecture.mvc.MVCActivity;
import com.example.androidarchitecture.mvc.MVCController;
import com.example.androidarchitecture.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MVPActivity extends AppCompatActivity implements MVPPresenter.View {

    private ArrayList<Model> list = new ArrayList<>();
    private CustomListViewAdapter adapter;
    private ListView listView;
    private MVPPresenter mvpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        updateUI();
    }

    private void updateUI() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        setTitle(message);

        mvpPresenter = new MVPPresenter(this);
        listView = findViewById(R.id.mvp);
        adapter = new CustomListViewAdapter(this, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVPActivity.this, list.get(i) + " clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        List<Model> countries = new ArrayList<>();

        if (Constants.getInstance(this).isNetworkAvailable()) {

            Toast.makeText(this,"You are online!!!!",Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this,"You are not online!!!!",Toast.LENGTH_SHORT).show();
            Log.v("Home", "############################You are not online!!!!");
        }
    }

    @Override
    public void setValues(List<Model> values) {
        list.clear();
        list.addAll(values);
        adapter.notifyDataSetChanged();
    }
}
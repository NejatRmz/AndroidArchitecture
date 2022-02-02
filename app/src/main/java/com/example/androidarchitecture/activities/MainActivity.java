package com.example.androidarchitecture.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidarchitecture.R;
import com.example.androidarchitecture.mvc.MVCActivity;
import com.example.androidarchitecture.mvp.MVPActivity;
import com.example.androidarchitecture.mvvm.MVVMActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "arch_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        Button mvc = findViewById(R.id.mvc);
        Button mvp = findViewById(R.id.mvp);
        Button mvvm = findViewById(R.id.mvvm);

        mvc.setOnClickListener(buttonClickListener);
        mvp.setOnClickListener(buttonClickListener);
        mvvm.setOnClickListener(buttonClickListener);
    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.mvc: {
                    redirectToMVC();
                    break;
                }
                case R.id.mvp: {
                    redirectToMVP();
                    break;
                }
                case R.id.mvvm: {
                    redirectToMVVM();
                    break;
                }
            }
        }
    };

    private void redirectToMVC() {
        Intent intent = new Intent(this, MVCActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "MVC");
        startActivity(intent);
    }

    private void redirectToMVP() {
        Intent intent = new Intent(this, MVPActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "MVP");
        startActivity(intent);
    }

    private void redirectToMVVM() {
        Intent intent = new Intent(this, MVVMActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "MVVM");
        startActivity(intent);
    }
}
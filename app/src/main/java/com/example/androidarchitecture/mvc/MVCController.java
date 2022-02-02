package com.example.androidarchitecture.mvc;

import android.util.Log;
import android.view.View;

import com.example.androidarchitecture.model.DataService;
import com.example.androidarchitecture.model.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-02
 */
public class MVCController {
    private static final String TAG = "MVCCONTROLLER";

    private MVCActivity view;
    private DataService service;

    public MVCController(MVCActivity view){
        this.view = view;
        service = new DataService();
        fetchData();
    }

    private void fetchData() {
        Call<List<Model>> call = service.getCountries();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success");

                    view.setValues(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
            }

        });


    }
}

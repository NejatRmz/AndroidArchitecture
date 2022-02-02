package com.example.androidarchitecture.mvp;

import android.util.Log;

import com.example.androidarchitecture.model.DataService;
import com.example.androidarchitecture.model.Model;
import com.example.androidarchitecture.mvc.MVCActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-02
 */
public class MVPPresenter {
    private static final String TAG = "MVPCONTROLLER";

    private View view;
    private DataService service;

    public MVPPresenter(View view){
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
                view.onErrorMessage();
            }

        });
    }

    public interface View{
        void setValues(List<Model> values);
        void onErrorMessage();
    }
}

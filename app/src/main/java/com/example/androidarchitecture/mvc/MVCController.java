package com.example.androidarchitecture.mvc;

import android.util.Log;
import android.view.View;

import com.example.androidarchitecture.model.DataService;
import com.example.androidarchitecture.model.Model;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
        service.getCountries().
            subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableSingleObserver<List<Model>>() {
                @Override
                public void onSuccess(List<Model> value) {
                    List<Model> countries = value;
                    //view.setValues(countries);
                    Log.e(TAG, countries.toString());
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, "Error Occurred");
                }
            });
    }
}

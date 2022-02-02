package com.example.androidarchitecture.mvvm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidarchitecture.model.DataService;
import com.example.androidarchitecture.model.Model;
import com.example.androidarchitecture.mvc.MVCActivity;

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
public class CountriesViewModel extends ViewModel {
    private static final String TAG = "MVVMCONTROLLER";

    private final MutableLiveData<List<Model>> countries = new MutableLiveData<>();
    private final MutableLiveData<Boolean> countryErrors = new MutableLiveData<>();
    private DataService service;

    public CountriesViewModel(){
        service = new DataService();
        fetchData();
    }

    public LiveData<List<Model>> getCountries(){
        return countries;
    }

    public LiveData<Boolean> getCountryErrors(){
        return countryErrors;
    }

    private void fetchData() {
        Call<List<Model>> call = service.getCountries();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success");
                    countries.setValue(response.body());
                    countryErrors.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
                countryErrors.setValue(true);
            }
        });
    }
}

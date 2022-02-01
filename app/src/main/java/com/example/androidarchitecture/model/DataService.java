package com.example.androidarchitecture.model;

import com.example.androidarchitecture.network.GetData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-01
 */
public class DataService {
    public static final String BASE_URL = "https://restcountries.com/v3.1/";

    private GetData api;

    public DataService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
}

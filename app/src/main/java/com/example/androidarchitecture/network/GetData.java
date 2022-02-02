package com.example.androidarchitecture.network;

import com.example.androidarchitecture.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-01
 */
public interface GetData {
    @GET("all")
    Call<List<Model>> getCountries();
}

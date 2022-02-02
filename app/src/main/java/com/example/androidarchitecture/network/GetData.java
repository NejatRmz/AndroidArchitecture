package com.example.androidarchitecture.network;

import android.telecom.Call;

import com.example.androidarchitecture.model.Model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-01
 */
public interface GetData {
    @GET("all")
    Single<List<Model>> getCountries();
}

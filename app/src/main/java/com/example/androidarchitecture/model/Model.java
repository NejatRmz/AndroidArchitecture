package com.example.androidarchitecture.model;

import com.google.gson.annotations.SerializedName;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-01
 */
public class Model {
    @SerializedName("country")
    public String countryName;
    @SerializedName("region")
    public String region;
}

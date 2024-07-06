package com.example.api;

import com.example.api.model.FoodRequest;
import com.example.api.model.FoodResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/food/nutrition")
    Call<FoodResponse> trackFood(@Body FoodRequest foodRequest);
}

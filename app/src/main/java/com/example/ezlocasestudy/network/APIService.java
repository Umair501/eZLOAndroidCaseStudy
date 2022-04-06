package com.example.ezlocasestudy.network;

import com.example.ezlocasestudy.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("items.test")
    Call<DataModel> getDataList();
}

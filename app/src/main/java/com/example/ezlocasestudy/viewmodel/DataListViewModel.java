package com.example.ezlocasestudy.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ezlocasestudy.model.DataArray;
import com.example.ezlocasestudy.model.DataModel;
import com.example.ezlocasestudy.network.APIService;
import com.example.ezlocasestudy.network.RetroInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataListViewModel extends ViewModel {

    private MutableLiveData<List<DataArray>> dataList;

    public static ArrayList<String> nameClassArrayList = new ArrayList<>();

    public DataListViewModel(){
        dataList = new MutableLiveData<>();
        nameClassArrayList = new ArrayList<>();
    }

    public MutableLiveData<List<DataArray>> getDataListObserver() {
        return dataList;

    }

    public void makeApiCall() {


        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<DataModel> call = apiService.getDataList();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {


                dataList.postValue(response.body().getDataArray());

                for (int i = 0; i < response.body().getDataArray().size(); i++) {
                    nameClassArrayList.add("Home Number " + (i+1));
                }

                Log.d("000147","Size: " +nameClassArrayList.size());
                Log.d("000147","DATA: " +nameClassArrayList.toString());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d("000147","Error: " + t.getMessage());
                dataList.postValue(null);
            }
        });
    }
}

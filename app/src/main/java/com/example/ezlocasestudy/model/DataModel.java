package com.example.ezlocasestudy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {

    @SerializedName("Devices")
    @Expose
    private List<DataArray> dataArray = null;

    public List<DataArray> getDataArray() {
        return dataArray;
    }

    public void setDataArray(List<DataArray> dataArray) {
        this.dataArray = dataArray;
    }
}

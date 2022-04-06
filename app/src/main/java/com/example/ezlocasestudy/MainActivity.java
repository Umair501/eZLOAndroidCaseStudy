package com.example.ezlocasestudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.ezlocasestudy.adapter.DataListAdapter;
import com.example.ezlocasestudy.model.DataArray;
import com.example.ezlocasestudy.viewmodel.DataListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataListAdapter.ItemClickListener {

    private List<DataArray> dataModelList;
    public static DataListAdapter adapter;
    private DataListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final TextView noresult = findViewById(R.id.tvNoResult);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =  new DataListAdapter(this, dataModelList, this);
        recyclerView.setAdapter(adapter);

        //Set Divider
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(this, R.drawable.horizontal_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        recyclerView.addItemDecoration(horizontalDecoration);



        viewModel = ViewModelProviders.of(this).get(DataListViewModel.class);
        viewModel.getDataListObserver().observe(this, new Observer<List<DataArray>>() {
            @Override
            public void onChanged(List<DataArray> dataModels) {
                if(dataModels != null) {
                    dataModelList = dataModels;
                    adapter.setDataList(dataModels);
                    noresult.setVisibility(View.GONE);
                } else {
                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCall();
    }

    @Override
    public void onDataClick(DataArray data, int position) {

        Log.d("000147","NAME: " + DataListViewModel.nameClassArrayList.get(position));

        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("home_name",DataListViewModel.nameClassArrayList.get(position));
        intent.putExtra("pk_device",data.getPk_device());
        intent.putExtra("mac_address",data.getMac_address());
        intent.putExtra("firmware",data.getFirmware());
        intent.putExtra("platform",data.getPlatform());
        intent.putExtra("position",position);
        startActivity(intent);


    }


}
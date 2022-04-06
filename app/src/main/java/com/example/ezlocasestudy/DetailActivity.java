package com.example.ezlocasestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezlocasestudy.viewmodel.DataListViewModel;

public class DetailActivity extends AppCompatActivity {

    EditText editTitle;
    ImageView image,iv_edit;
    TextView tvSNData, tvMAC,tvFirmware,tvModel;

    String home_name,pk_device,platform,mac_address,firmware;
    int position;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        pk_device = String.valueOf(getIntent().getExtras().getInt("pk_device"));
        Log.d("000147","pk_device: "+pk_device);

        home_name = getIntent().getExtras().getString("home_name");
        mac_address = getIntent().getExtras().getString("mac_address");
        firmware = getIntent().getExtras().getString("firmware");
        platform = getIntent().getExtras().getString("platform");
        position = getIntent().getExtras().getInt("position");

        editTitle = findViewById(R.id.editTitle);
        tvSNData = findViewById(R.id.tvSNData);
        tvMAC = findViewById(R.id.tvMAC);
        tvFirmware = findViewById(R.id.tvFirmware);
        tvModel = findViewById(R.id.tvModel);

        image = findViewById(R.id.image);
        iv_edit = findViewById(R.id.iv_edit);


        //Set Data
        editTitle.setText(home_name);
        editTitle.setEnabled(false);

        tvSNData.setText("SN: " +pk_device);
        tvMAC.setText("MAC Address: " +mac_address);
        tvFirmware.setText("Firmware: " +firmware);
        tvModel.setText("Model: " +platform);

        iv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "EditText enable !!!", Toast.LENGTH_SHORT).show();

                editTitle.setEnabled(true);
                editTitle.setCursorVisible(true);
            }
        });


        // Set Image
        if (platform.equals("Sercomm NA301")){
            image.setImageResource(R.drawable.ic_vera_edge_big);
        }
        else if (platform.equals("Sercomm G450")){
            image.setImageResource(R.drawable.ic_vera_plus_big);
        }
        else{
            image.setImageResource(R.drawable.ic_vera_edge_big);
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBackPressed() {
        DataListViewModel.nameClassArrayList.set(position,editTitle.getText().toString());
        MainActivity.adapter.notifyDataSetChanged();

        finish();

        super.onBackPressed();
    }
}
package com.example.ezlocasestudy.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ezlocasestudy.R;
import com.example.ezlocasestudy.model.DataArray;
import com.example.ezlocasestudy.viewmodel.DataListViewModel;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.MyViewHolder> {
    private Context context;
    private List<DataArray> dataList;
    private ItemClickListener clickListener;


    public DataListAdapter(Context context, List<DataArray> dataList, ItemClickListener clickListener) {
        this.context = context;
        this.dataList = dataList;
        this.clickListener = clickListener;

    }

    public void setDataList(List<DataArray> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvHomeNumber.setText(DataListViewModel.nameClassArrayList.get(position));
        holder.tvSN.setText("SN: " +this.dataList.get(position).getPk_device());

        switch (this.dataList.get(position).getPlatform())
        {
            case "Sercomm NA301":
                holder.image.setImageResource(R.drawable.ic_vera_edge_big);
                break;
            case "Sercomm G450":
                holder.image.setImageResource(R.drawable.ic_vera_plus_big);
                break;

            default:

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onDataClick(dataList.get(position),position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Remove_Dialog(position);

                return false;
            }
        });



    }

    public void Remove_Dialog(int position) {
        AlertDialog alertDialog ;
                 alertDialog = new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure to delete this item?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       dataList.remove(position);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    @Override
    public int getItemCount() {
        if(this.dataList != null) {
            return this.dataList.size();
        }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvHomeNumber,tvSN;
       ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvHomeNumber = (TextView)itemView.findViewById(R.id.tvHomeNumber);
            tvSN = (TextView)itemView.findViewById(R.id.tvSN);
            image = (ImageView)itemView.findViewById(R.id.image);

        }
    }


    public interface ItemClickListener{
        public void onDataClick(DataArray data, int position);
    }
}

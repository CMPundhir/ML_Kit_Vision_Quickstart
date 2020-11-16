package com.google.mlkit.vision.demo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.mlkit.vision.demo.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FormRecyclerAdapter extends RecyclerView.Adapter<FormRecyclerAdapter.ViewHolder> {
    private List<String> validTextList;
    private List<String> validQRCodeList;
    private Context context;

    public FormRecyclerAdapter( Context context, List<String> validTextList, List<String> validQRCodeList) {
        this.validTextList = validTextList;
        this.validQRCodeList = validQRCodeList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        String sno = validTextList.get(position);
        String qr = validQRCodeList.get(position);
        holder.t1.setText((position+1)+". ");
        holder.t2.setText(sno);
        holder.t3.setText(qr);
    }

    @Override
    public int getItemCount() {
        return Math.min(validTextList.size(), validQRCodeList.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
        }
    }
}

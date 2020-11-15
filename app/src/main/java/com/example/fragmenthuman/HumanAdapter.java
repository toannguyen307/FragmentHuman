package com.example.fragmenthuman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HumanAdapter extends RecyclerView.Adapter<HumanAdapter.ViewHolder> {
    ArrayList<Human> listHuman;

    private OnItemClickListener mOnItemClickListener;

    public HumanAdapter(ArrayList<Human> listHuman, OnItemClickListener mOnItemClickListener) {
        this.listHuman = listHuman;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gán dữ liêu
        holder.txtName.setText("Tên: "+ listHuman.get(position).getName());
        holder.txtAge.setText("Tuổi : "+ listHuman.get(position).getAge());
        holder.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener !=null) {
                    mOnItemClickListener.sendPositionItem(position);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return listHuman.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAge;
        LinearLayout line;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            txtName= itemView.findViewById(R.id.textView_name);
            txtAge = itemView.findViewById(R.id.textView_age);
            line = itemView.findViewById(R.id.line);

        }
    }
}

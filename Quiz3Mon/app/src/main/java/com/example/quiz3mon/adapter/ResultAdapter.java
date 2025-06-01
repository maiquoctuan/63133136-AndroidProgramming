package com.example.quiz3mon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz3mon.R;
import com.example.quiz3mon.model.Result;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    private List<Result> resultList;

    public ResultAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubject, tvScore, tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            tvScore = itemView.findViewById(R.id.tvScore);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }

    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultAdapter.ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.tvSubject.setText("Môn: " + result.getSubject());
        holder.tvScore.setText("Điểm: " + result.getScore());
        holder.tvDate.setText("Ngày: " + result.getDate());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}

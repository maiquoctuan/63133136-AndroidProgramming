package com.example.quiz3mon.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz3mon.R;
import com.example.quiz3mon.model.QuestionResult;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    private List<QuestionResult> resultList;

    public ResultAdapter(List<QuestionResult> resultList) {
        this.resultList = resultList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion, tvCorrect, tvSelected, tvResult;

        public ViewHolder(View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            tvCorrect = itemView.findViewById(R.id.tvCorrectAnswer);
            tvSelected = itemView.findViewById(R.id.tvSelectedAnswer);
            tvResult = itemView.findViewById(R.id.tvIsCorrect);
        }
    }

    @NonNull
    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ViewHolder holder, int position) {
        QuestionResult item = resultList.get(position);
        holder.tvQuestion.setText("Câu: " + item.getQuestion());
        holder.tvCorrect.setText("Đáp án đúng: " + item.getCorrectAnswer());
        holder.tvSelected.setText("Bạn chọn: " + item.getSelectedAnswer());
        holder.tvResult.setText(item.isCorrect() ? "✅ Đúng" : "❌ Sai");
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}

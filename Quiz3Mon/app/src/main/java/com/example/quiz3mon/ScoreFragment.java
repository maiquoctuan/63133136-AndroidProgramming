package com.example.quiz3mon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz3mon.adapter.ResultAdapter;
import com.example.quiz3mon.model.QuestionResult;

import java.util.ArrayList;
import java.util.List;

public class ScoreFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView tvScoreSummary;
    private List<QuestionResult> resultList = new ArrayList<>();

    // Bạn sẽ lấy dữ liệu từ đâu đó (có thể từ SharedPreferences, database hoặc Bundle)
    // Giả sử ở đây bạn lấy từ lớp tĩnh hoặc Bundle tạm thời
    public static List<QuestionResult> results = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewResults);
        tvScoreSummary = view.findViewById(R.id.tvScoreSummary);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ResultAdapter(results));

        int correct = 0;
        for (QuestionResult r : results) {
            if (r.isCorrect()) correct++;
        }

        tvScoreSummary.setText("Số câu đúng: " + correct + "/" + results.size());

        return view;
    }
}

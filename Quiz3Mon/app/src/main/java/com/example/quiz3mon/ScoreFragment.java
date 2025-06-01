package com.example.quiz3mon;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz3mon.adapter.ResultAdapter;
import com.example.quiz3mon.model.Result;

import java.util.List;

public class ScoreFragment extends Fragment {

    RecyclerView recyclerView;
    ResultAdapter adapter;
    List<Result> resultList;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewScores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SharedPreferences prefs = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = prefs.getString("username", "");

        db = new DatabaseHelper(getContext());
        resultList = db.getUserResults(username);

        adapter = new ResultAdapter(resultList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}


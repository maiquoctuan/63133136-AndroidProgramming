package com.example.quiz3mon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {

    public Button btnEnglish, btnIT, btnLiterature;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        // Ánh xạ các nút
        btnEnglish = view.findViewById(R.id.btnEnglish);
        btnIT = view.findViewById(R.id.btnIT);
        btnLiterature = view.findViewById(R.id.btnLiterature);

        // Xử lý khi người dùng chọn môn
        btnEnglish.setOnClickListener(v -> startQuiz("English"));
        btnIT.setOnClickListener(v -> startQuiz("Tin học"));
        btnLiterature.setOnClickListener(v -> startQuiz("Ngữ Văn"));
        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            SharedPreferences preferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            preferences.edit().clear().apply();

            Intent intent = new Intent(requireActivity(), LoginActivity.class);
            startActivity(intent);
            requireActivity().finish(); // Kết thúc MainActivity
        });


        return view;
    }


    // Phương thức mở QuizActivity và truyền tên môn học
    public void startQuiz(String subject) {
        Intent intent = new Intent(getActivity(), QuizActivity.class);
        intent.putExtra("subject", subject);
        startActivity(intent);
    }
}
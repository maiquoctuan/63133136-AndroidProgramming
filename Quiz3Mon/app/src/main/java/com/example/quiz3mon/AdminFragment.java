package com.example.quiz3mon;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import java.util.List;

public class AdminFragment extends Fragment {

    Spinner spinnerSubject;
    EditText edtQuestion, edtA, edtB, edtC, edtD, edtCorrect;
    Button btnAdd, btnView;
    DatabaseHelper dbHelper;

    public AdminFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        // Ánh xạ giao diện
        spinnerSubject = view.findViewById(R.id.spinnerSubject);
        edtQuestion = view.findViewById(R.id.edtQuestion);
        edtA = view.findViewById(R.id.edtA);
        edtB = view.findViewById(R.id.edtB);
        edtC = view.findViewById(R.id.edtC);
        edtD = view.findViewById(R.id.edtD);
        edtCorrect = view.findViewById(R.id.edtCorrect);
        btnAdd = view.findViewById(R.id.btnAddQuestion);
        btnView = view.findViewById(R.id.btnViewQuestions);

        dbHelper = new DatabaseHelper(getContext());

        // Gán danh sách môn học cho Spinner
        String[] subjects = {"English", "IT", "Literature"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(adapter);

        // Xử lý thêm câu hỏi
        btnAdd.setOnClickListener(v -> {
            String subject = spinnerSubject.getSelectedItem().toString();
            String question = edtQuestion.getText().toString().trim();
            String a = edtA.getText().toString().trim();
            String b = edtB.getText().toString().trim();
            String c = edtC.getText().toString().trim();
            String d = edtD.getText().toString().trim();
            String correct = edtCorrect.getText().toString().trim().toUpperCase();

            if (question.isEmpty() || a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || correct.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!correct.matches("[ABCD]")) {
                Toast.makeText(getContext(), "Đáp án đúng phải là A, B, C hoặc D", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean inserted = dbHelper.addQuestion(subject, question, a, b, c, d, correct);
            if (inserted) {
                Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                edtQuestion.setText(""); edtA.setText(""); edtB.setText(""); edtC.setText("");
                edtD.setText(""); edtCorrect.setText("");
            } else {
                Toast.makeText(getContext(), "Lỗi khi thêm", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý xem danh sách câu hỏi theo môn
        btnView.setOnClickListener(v -> {
            String subject = spinnerSubject.getSelectedItem().toString();
            List<Question> questions = dbHelper.getQuestionsBySubject(subject);
            if (questions.isEmpty()) {
                Toast.makeText(getContext(), "Chưa có câu hỏi cho môn " + subject, Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (Question q : questions) {
                sb.append("Q: ").append(q.getQuestion()).append("\n");
                sb.append("A. ").append(q.getOptionA()).append("\n");
                sb.append("B. ").append(q.getOptionB()).append("\n");
                sb.append("C. ").append(q.getOptionC()).append("\n");
                sb.append("D. ").append(q.getOptionD()).append("\n");
                sb.append("Đúng: ").append(q.getAnswer()).append("\n\n");
            }

            new AlertDialog.Builder(getContext())
                    .setTitle("Danh sách câu hỏi: " + subject)
                    .setMessage(sb.toString())
                    .setPositiveButton("OK", null)
                    .show();
        });

        return view;
    }
}

package com.example.quiz3mon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
        Button btnBackToHome = findViewById(R.id.btnBackToHome);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        txtResult.setText("Bạn trả lời đúng " + score + "/" + total + " câu");
    }
}

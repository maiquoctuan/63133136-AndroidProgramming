package com.example.quiz3mon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    TextView txtQuestion, txtTitle;
    RadioGroup radioGroup;
    RadioButton rbA, rbB, rbC, rbD;
    Button btnNext;

    ArrayList<Question> questionList;
    int currentQuestionIndex = 0;
    int score = 0;
    String subject;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtTitle = findViewById(R.id.txtSubjectTitle);
        txtQuestion = findViewById(R.id.txtQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        rbA = findViewById(R.id.rbA);
        rbB = findViewById(R.id.rbB);
        rbC = findViewById(R.id.rbC);
        rbD = findViewById(R.id.rbD);
        btnNext = findViewById(R.id.btnNext);

        // Nhận môn học từ Intent
        subject = getIntent().getStringExtra("subject");
        txtTitle.setText("Môn: " + subject);

        loadQuestionsFromDB();

        if (questionList.size() > 0) {
            showQuestion();
        }

        btnNext.setOnClickListener(v -> {
            if (!checkAnswer()) {
                return; // Nếu chưa chọn đáp án thì dừng lại
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questionList.size()) {
                showQuestion();
            } else {
                // Lưu kết quả vào bảng Results
                DatabaseHelper db = new DatabaseHelper(QuizActivity.this);
                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String username = prefs.getString("username", "");
                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

                db.insertResult(subject, score, date, username);

                // Chuyển sang màn hình kết quả
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questionList.size());
                startActivity(intent);
                finish();
            }
        });
    }

    public void loadQuestionsFromDB() {
        questionList = new ArrayList<>();
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM questions WHERE subject = ?", new String[]{subject});
        if (cursor.moveToFirst()) {
            do {
                Question q = new Question(
                        cursor.getString(cursor.getColumnIndexOrThrow("question")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionA")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionB")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionC")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionD")),
                        cursor.getString(cursor.getColumnIndexOrThrow("answer"))
                );
                questionList.add(q);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    @SuppressLint("SetTextI18n")
    public void showQuestion() {
        radioGroup.clearCheck();
        Question q = questionList.get(currentQuestionIndex);
        txtQuestion.setText((currentQuestionIndex + 1) + ". " + q.getQuestion());
        rbA.setText(q.getOptionA());
        rbB.setText(q.getOptionB());
        rbC.setText(q.getOptionC());
        rbD.setText(q.getOptionD());
    }

    public boolean checkAnswer() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Vui lòng chọn một đáp án", Toast.LENGTH_SHORT).show();
            return false;
        }

        RadioButton selectedRadio = findViewById(selectedId);
        String selectedAnswer = selectedRadio.getText().toString();
        String correctAnswer = questionList.get(currentQuestionIndex).getAnswer();

        if (selectedAnswer.equalsIgnoreCase(correctAnswer)) {
            score++;
        }
        return true;
    }
}
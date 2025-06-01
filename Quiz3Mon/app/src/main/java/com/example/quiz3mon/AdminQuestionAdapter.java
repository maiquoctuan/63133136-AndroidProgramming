package com.example.quiz3mon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdminQuestionAdapter extends RecyclerView.Adapter<AdminQuestionAdapter.ViewHolder> {

    private Context context;
    private List<Question> questionList;
    private DatabaseHelper dbHelper;

    public AdminQuestionAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
        this.dbHelper = new DatabaseHelper(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuestion, txtOptions, txtAnswer;
        Button btnEdit, btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            txtQuestion = itemView.findViewById(R.id.txtQuestion);
            txtOptions = itemView.findViewById(R.id.txtOptions);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_question_admin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question q = questionList.get(position);
        holder.txtQuestion.setText("Câu hỏi: " + q.getQuestion());
        holder.txtOptions.setText("A: " + q.getOptionA() + " | B: " + q.getOptionB() + " | C: " + q.getOptionC() + " | D: " + q.getOptionD());
        holder.txtAnswer.setText("Đáp án đúng: " + q.getAnswer());

        // XÓA
        holder.btnDelete.setOnClickListener(v -> {
            dbHelper.deleteQuestion(q.getId());
            questionList.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(context, "Đã xóa câu hỏi", Toast.LENGTH_SHORT).show();
        });

        // SỬA
        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditQuestionActivity.class);
            intent.putExtra("question_id", q.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}

package com.example.quiz3mon.model;

import java.io.Serializable;

public class QuestionResult implements Serializable {
    private String question;
    private String selectedAnswer;
    private String correctAnswer;

    public QuestionResult(String question, String selectedAnswer, String correctAnswer) {
        this.question = question;
        this.selectedAnswer = selectedAnswer;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }



}

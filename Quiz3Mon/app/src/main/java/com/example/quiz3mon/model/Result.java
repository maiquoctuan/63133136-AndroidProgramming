package com.example.quiz3mon.model;

public class Result {
    private String subject;
    private int score;
    private String date;

    public Result(String subject, int score, String date) {
        this.subject = subject;
        this.score = score;
        this.date = date;
    }

    // Getter nếu cần
    public String getSubject() { return subject; }
    public int getScore() { return score; }
    public String getDate() { return date; }
}


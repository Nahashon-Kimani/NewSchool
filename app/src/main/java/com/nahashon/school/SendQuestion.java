package com.nahashon.school;

public class SendQuestion {
    public String question, date;

    public SendQuestion() {
    }

    public SendQuestion(String question, String date) {
        this.question = question;
        this.date = date;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.hibernate.map;

import jakarta.persistence.*;

@Entity
public class Question{

    @Id
    @Column(name = "question_id")
    private int question_id;

    @Column(name = "question")
    private String question;

    @OneToOne
    @JoinColumn(name = "f_ans_id") //in Database : foreign key name
    private Answer answer;

    public Question() {
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
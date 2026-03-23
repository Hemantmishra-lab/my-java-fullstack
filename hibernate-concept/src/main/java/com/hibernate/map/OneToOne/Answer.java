package com.hibernate.map.OneToOne;

import jakarta.persistence.*;

@Entity
public class Answer{
    @Id
    @Column(name = "answer_id")
    private int answer_id;

    @Column(name = "answer")
    private String answer;

    public Answer() {
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
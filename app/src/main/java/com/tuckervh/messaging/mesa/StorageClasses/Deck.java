package com.tuckervh.messaging.mesa.StorageClasses;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Deck implements Serializable{
    private List<QuestionData> questionList;
    private String name;

    public Deck(List<QuestionData> questionList, String name) {
        this.questionList = questionList;
        this.name = name;
    }

    public Deck(String name) {
        this(new LinkedList<QuestionData>(), name);
    }

    public void addQuestion(QuestionData question) {
        questionList.add(question);
    }

    public String getName() {
        return name;
    }

    public List<QuestionData> getQuestionList() {
        return questionList;
    }
}

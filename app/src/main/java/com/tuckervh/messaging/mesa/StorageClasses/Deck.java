package com.tuckervh.messaging.mesa.StorageClasses;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<QuestionData> questionList;
    private String name;

    public Deck(List<QuestionData> questionList, String name) {
        this.questionList = questionList;
        this.name = name;
    }

    public void createQuestionList(String name) {
        this.name = name;
        questionList = new ArrayList<>();
    }

    public void createQuestionList(String name, QuestionData question) {
        createQuestionList(name);
        questionList.add(question);
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

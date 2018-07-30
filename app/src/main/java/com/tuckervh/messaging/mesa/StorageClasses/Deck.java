package com.tuckervh.messaging.mesa.StorageClasses;


import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;


public class Deck implements Serializable{
    private Collection<QuestionData> questionList;
    private String name;

    public Deck(LinkedHashSet<QuestionData> questionList, String name) {
        this.questionList = questionList;
        this.name = name;
    }

    public Deck(String name) {
        this(new LinkedHashSet<QuestionData>(), name);
    }

    public void addQuestion(QuestionData question) {
        questionList.add(question);
    }

    public String getName() {
        return name;
    }

    public Collection<QuestionData> getQuestionCollection() {
        return questionList;
    }
}

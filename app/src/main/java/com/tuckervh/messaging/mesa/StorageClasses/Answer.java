package com.tuckervh.messaging.mesa.StorageClasses;

public class Answer {
    private String strAnswer;

    public Answer(String strAnswer) {
        this.strAnswer = strAnswer;
    }

    @Override
    public String toString() {
        return strAnswer;
    }

    @Override
    public int hashCode() {
        return strAnswer.toLowerCase().hashCode();
    }

    public boolean check(String input) {
        return input.toLowerCase().equals(strAnswer.toLowerCase());
    }
}

package com.tuckervh.messaging.mesa.StorageClasses;

import java.io.Serializable;

public class QuestionData implements Serializable {
     private String question;
     private Answer answer;
     private int numRight;
     private int numWrong;

     //constructor that loads questiondata
     public QuestionData(String question, Answer answer, int numRight, int numWrong) {
          this.question = question;
          this.answer = answer;
          this.numRight = numRight;
          this.numWrong = numWrong;
     }

     //constructor that initializes questiondata
     public QuestionData(String question, String answer) {
          this.question = question;
          this.answer = new Answer(answer);
          numRight = 0;
          numWrong = 0;
     }

     //increment number of times the question has been answered correctly
     public void incRight() {
          numRight++;
     }

     //increment number of times the question has been answered incorrectly
     public void incWrong() {
          numWrong++;
     }

     //change answer field
     public void changeAnswer(String answer) {
          this.answer = new Answer(answer);
     }

     //check input answer with valid(stored) answer
     public boolean checkAnswer(String answer) {
          return this.answer.check(answer);
     }


     //getters
     public String getQuestion() {
          return question;
     }

     public Answer getAnswer() {
          return answer;
     }

     public String getStringAnswer() {
          return answer.toString();
     }

     public int getNumRight() {
          return numRight;
     }

     public int getNumWrong() {
          return numWrong;
     }
}

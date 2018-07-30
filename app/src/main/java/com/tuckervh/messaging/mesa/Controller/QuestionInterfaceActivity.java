package com.tuckervh.messaging.mesa.Controller;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tuckervh.messaging.mesa.R;
import com.tuckervh.messaging.mesa.StorageClasses.Deck;
import com.tuckervh.messaging.mesa.StorageClasses.QuestionData;
import com.tuckervh.messaging.mesa.Utils.DeckStorageMethods;

import java.util.Collection;
import java.util.Iterator;

import static android.content.ContentValues.TAG;


import static com.tuckervh.messaging.mesa.Utils.TransferMethods.goToList;

public class QuestionInterfaceActivity extends AppCompatActivity {

    TextView questionScreen;
    EditText answer_editText;
    Button enterAnswer_btn;

    QuestionData currentQuestion;
    Iterator<QuestionData> lhsIterator;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_interface);

        questionScreen = findViewById(R.id.questionScreen_txtView);
        answer_editText = findViewById(R.id.inputAnswerQuestionInterface_editText);
        enterAnswer_btn = findViewById(R.id.enterAnswer_btn);


    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_question_interface);

        String deckName = getIntent().getStringExtra("String");
        Deck currentDeck = DeckStorageMethods.recallDeck(this, deckName);

        lhsIterator = currentDeck.getQuestionCollection().iterator();
        if(lhsIterator.hasNext()) {
            currentQuestion = lhsIterator.next();
        } else {
            Log.d(TAG, "No Question Data");
            goToList(context);
        }

        questionScreen.setText(currentQuestion.getQuestion());

        enterAnswer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.checkAnswer(answer_editText.getText().toString())) {
                    AlertDialog.Builder correctDialog = new AlertDialog.Builder(context);
                    correctDialog.setMessage("Correct!");
                    correctDialog.setTitle("Your answer was: ");
                } else {
                    AlertDialog.Builder falseDialog = new AlertDialog.Builder(context);
                    falseDialog.setMessage("False");
                    falseDialog.setTitle("Your answer was: ");
                }
                if(lhsIterator.hasNext()) {
                    currentQuestion = lhsIterator.next();
                } else {
                    Log.v(TAG, "No more questions");
                    goToList(context);
                }
            }
        });
    }
}

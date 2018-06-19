package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tuckervh.messaging.mesa.R;
import com.tuckervh.messaging.mesa.StorageClasses.Deck;
import com.tuckervh.messaging.mesa.StorageClasses.QuestionData;

import static com.tuckervh.messaging.mesa.Utils.DeckStorage.saveDeck;

public class CreateQuestionActivity extends AppCompatActivity {


    Deck deck = (Deck) getIntent().getSerializableExtra("serialize_data");
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_create_question);

        final EditText questionEditText = findViewById(R.id.txt_question);
        final EditText answerEditText = findViewById(R.id.txt_answer);

        Button addQuestionButton = findViewById(R.id.btn_addQuestion);
        addQuestionButton.setEnabled(false);
        Button finalizeButton = findViewById(R.id.btn_finalize);

        if ((!(TextUtils.isEmpty(answerEditText.getText().toString())))
                    && ((!(TextUtils.isEmpty(questionEditText.getText().toString()))))) {
            addQuestionButton.setClickable(true);
        }

        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.addQuestion(new QuestionData(
                        questionEditText.getText().toString(),
                        answerEditText.getText().toString())
                );
                questionEditText.getText().clear();
                answerEditText.getText().clear();
                Toast.makeText(context, "Question added",
                        Toast.LENGTH_SHORT).show();
            }
        });

        finalizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDeck(context, deck);
            }
        });

    }
}

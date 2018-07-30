package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tuckervh.messaging.mesa.R;
import com.tuckervh.messaging.mesa.StorageClasses.Deck;
import com.tuckervh.messaging.mesa.StorageClasses.QuestionData;

import static com.tuckervh.messaging.mesa.Utils.DeckStorageMethods.saveDeck;
import static com.tuckervh.messaging.mesa.Utils.TransferMethods.goToList;

public class CreateQuestionActivity extends AppCompatActivity {

    Deck deck;

    EditText questionEditText;
    EditText answerEditText;
    Button addQuestionButton;
    Button finalizeButton;

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_create_question);

        //TODO: turn serializable deck methods into parcelable
        deck = (Deck) getIntent().getSerializableExtra("DeckName");

        questionEditText = findViewById(R.id.txt_question);
        answerEditText = findViewById(R.id.txt_answer);

        addQuestionButton = findViewById(R.id.btn_addQuestion);
        addQuestionButton.setEnabled(false);
        finalizeButton = findViewById(R.id.btn_finalize);

        questionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //void
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((!(TextUtils.isEmpty(s.toString().trim())))
                        && (answerEditText.getText().toString().length()!=0)) {
                    addQuestionButton.setEnabled(true);
                } else {
                    addQuestionButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //void
            }
        });

        answerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //void
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((!(TextUtils.isEmpty(s.toString().trim())))
                        && (questionEditText.getText().toString().length()!=0)) {
                    addQuestionButton.setEnabled(true);
                } else {
                    addQuestionButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //void
            }
        });



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
                goToList(context);
            }
        });

    }
}

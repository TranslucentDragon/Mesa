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
import com.tuckervh.messaging.mesa.Utils.TransferMethods;

public class CreateDeckActivity extends AppCompatActivity {

    //set context and initialize views and String
    private final Context context = this;
    Button createEmptyDeck;
    EditText deckNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deck);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_create_deck);

        //define views
        deckNameEditText = findViewById(R.id.txt_deckName);
        createEmptyDeck = findViewById(R.id.btn_createEmptyDeck);

        //initially set button to disabled
        createEmptyDeck.setEnabled(false);

        deckNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //void
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(TextUtils.isEmpty(s.toString().trim()))) {
                    createEmptyDeck.setEnabled(true);
                } else {
                    createEmptyDeck.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //void
            }
        });



        createEmptyDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define string by edit text
                String deckNameString = deckNameEditText.getText().toString();
                Toast.makeText(context, "String: " + deckNameString, Toast.LENGTH_SHORT);
                TransferMethods.goToCreateQuestion(context, deckNameString);
            }
        });
    }
}

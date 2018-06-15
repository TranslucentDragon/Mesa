package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tuckervh.messaging.mesa.R;
import com.tuckervh.messaging.mesa.Utils.TransferMethods;

public class CreateDeckActivity extends AppCompatActivity {

    private final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deck);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_create_deck);

        EditText deckNameEditText = findViewById(R.id.txt_deckName);

        Button createEmptyDeck = findViewById(R.id.btn_addQuestion);
        createEmptyDeck.setClickable(false);

        //might need an onfocus listener
        if (!(TextUtils.isEmpty(deckNameEditText.getText().toString()))) {
            createEmptyDeck.setClickable(true);
        }

        final String deckNameString = deckNameEditText.getText().toString();

        createEmptyDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransferMethods.goToCreateQuestion(context, deckNameString);
            }
        });
    }
}

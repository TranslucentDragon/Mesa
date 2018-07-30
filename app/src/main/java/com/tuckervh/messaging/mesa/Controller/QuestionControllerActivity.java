package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuckervh.messaging.mesa.StorageClasses.Deck;
import com.tuckervh.messaging.mesa.Utils.DeckStorageMethods;

public class QuestionControllerActivity extends AppCompatActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        String deckName = getIntent().getStringExtra("String");
        Deck currentDeck = DeckStorageMethods.recallDeck(this, deckName);

    }
}

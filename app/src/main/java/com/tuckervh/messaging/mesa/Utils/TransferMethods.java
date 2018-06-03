package com.tuckervh.messaging.mesa.Utils;

import android.content.Context;
import android.content.Intent;

import com.tuckervh.messaging.mesa.Controller.*;
import com.tuckervh.messaging.mesa.StorageClasses.Deck;

public class TransferMethods {

    /**
     * Opens StartActivity context
     * @param context the current context
     */
    public static void goToStart(Context context) {
        Intent intent = new Intent(context, StartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * Opens CreateDeckActivity context
     * @param context the current context
     */
    public static void goToCreateDeck(Context context) {
        Intent intent = new Intent(context, CreateDeckActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * Opens CreateDeckActivity context
     * @param context the current context
     */
    public static void goToCreateQuestion(Context context, String deckName) {
        Intent intent = new Intent(context, CreateQuestionActivity.class);
        intent.putExtra("serialize_data", new Deck(deckName));
        context.startActivity(intent);
    }

//    /**
//     * Opens CreateDeckActivity context
//     * @param context the current context
//     */
//    public static void goToCreateDeck(Context context) {
//        Intent intent = new Intent(context, CreateQuestionActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        context.startActivity(new Intent(context, CreateQuestionActivity.class));
//    }
}

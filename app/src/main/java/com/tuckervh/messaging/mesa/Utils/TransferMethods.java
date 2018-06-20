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
     * Opens ListActivity context
     * @param context the current context
     */
    public static void goToList(Context context) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * Opens CreateDeckActivity context
     * @param context the current context
     * @param deckName the deck to add questions to
     */
    public static void goToCreateQuestion(Context context, String deckName) {
        Intent intent = new Intent(context, CreateQuestionActivity.class);
        intent.putExtra("DeckName", new Deck(deckName));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

        /**
         * Opens QuestionInterfaceActivity context
         * @param context the current context
         * @param deckName the deck to call
         */
        public static void goToQuestionInterface(Context context, String deckName) {
            Intent intent = new Intent(context, ListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("String", deckName);
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

package com.tuckervh.messaging.mesa.Utils;

import android.content.Context;
import android.util.Log;

import com.tuckervh.messaging.mesa.StorageClasses.Deck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DeckStorage {

    private final static String DECK_NAMES = "LIST_OF_ALL_DECKS";

    /**
     * Saves the deck name to a list of all deck names
     * @param context the current context
     * @param deck the deck name to save
     */
    private static void addDeckNameToList(Context context, Deck deck) {
        try {
            File deckNameList = new File(context.getFilesDir(), DECK_NAMES);
            //deckNameList.createNewFile();
            FileWriter deckNameListFR = new FileWriter(deckNameList, true);
            deckNameListFR.write(deck.getName() + '\n');
            deckNameListFR.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: ",e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: ", e);
        }
    }

    /**
     * Checks if the deck is in the list (if the deck has been created)
     * @param context the current context
     * @param deckName the deck to check
     */
    public static boolean checkIfDeckExists(Context context, String deckName) {
        boolean exists = false;
        String line;
        try {
            //get list of names from file
            FileReader deckFR = new FileReader(new File(context.getFilesDir(), DECK_NAMES));
            BufferedReader deckBR = new BufferedReader(deckFR);
            //check if deckName is in list
            while((line = deckBR.readLine()) != null) {
                if (line.equals(deckName)) {
                    exists = true;
                    Log.i(TAG, "Deck found in list!");
                }
            }
            deckBR.close();
            deckFR.close();
            Log.v(TAG, "Successful IO closes");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: ",e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: ", e);
        }
        return exists;
    }

    /**
     * Converts the deck list into a string array (typically for the list activity)
     * @param context the current context
     */
    public static List<String> deckListToArrayList(Context context) {
        String line;
        List<String> deckList = new ArrayList<>();
        try {
            //get list of names from file
            FileReader deckFR = new FileReader(new File(context.getFilesDir(), DECK_NAMES));
            BufferedReader deckBR = new BufferedReader(deckFR);
            //check if deckName is in list
            while((line = deckBR.readLine()) != null) {
                deckList.add(line);
                Log.v(TAG, line + " added to ArrayList");
            }
            deckBR.close();
            deckFR.close();
            Log.v(TAG, "Successful IO closes");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: ",e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: ", e);
        }
        return deckList;
    }

    /**
     * Saves the current deck
     * @param context the current context
     * @param deck the deck to save
     */
    public static void saveDeck(Context context, Deck deck) {
        try {
            //add deck name to list
            if (!(checkIfDeckExists(context, deck.getName()))) {
                addDeckNameToList(context, deck);
            }
            //add deck to app
            FileOutputStream fileOutputStream = context.openFileOutput(deck.getName(), Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(deck);
            oos.close();
            fileOutputStream.close();
            Log.i(TAG, "Successful Save");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: ",e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: ", e);
        }
    }

    /**
     * Passes the input deck from name back up
     * @param context the current context
     * @param deck the deck to return
     */
    public static Deck recallDeck(Context context, String deck) {
        Deck recalledDeck = null;
        try {
            FileInputStream fis = context.openFileInput(deck);
            ObjectInputStream ois = new ObjectInputStream(fis);
            recalledDeck = (Deck) ois.readObject();
            ois.close();
            fis.close();
            Log.i(TAG, "Successful Save");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException: ",e);
        } catch (IOException e) {
            Log.e(TAG, "IOException: ", e);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "ClassNotFoundException: ", e);
        }
        if (recalledDeck == null) {
            Log.i(TAG, "Deck not found");
        }
        return recalledDeck;
    }


}

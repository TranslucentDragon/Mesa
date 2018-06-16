package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.tuckervh.messaging.mesa.R;
import com.tuckervh.messaging.mesa.Utils.DeckStorage;

import java.util.List;

import static com.tuckervh.messaging.mesa.Utils.TransferMethods.goToQuestionInterface;

public class ListActivity extends AppCompatActivity {

    private final Context context = this;
    private EditText searchBar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_list);

        final List<String> deckList = DeckStorage.getDeckList(context);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (
                context,
                R.layout.listview_element,
                R.id.linearLayout_textView,
                deckList
        );
        listView = findViewById(R.id.listViewXML);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToQuestionInterface(context, deckList.get(position));
            }
        });
    }
}

package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.tuckervh.messaging.mesa.R;

public class ListActivity extends AppCompatActivity {

    private final Context context = this;
    private EditText searchBar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}

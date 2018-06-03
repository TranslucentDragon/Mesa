package com.tuckervh.messaging.mesa.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuckervh.messaging.mesa.R;
import com.tuckervh.messaging.mesa.Utils.TransferMethods;

public class StartActivity extends AppCompatActivity {
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_start);

        Button createDeckBtn = findViewById(R.id.btn_createDeck);
        Button previousBtn = findViewById(R.id.btn_previousDeck);
        Button newDeckBtn = findViewById(R.id.btn_newDeck);

        createDeckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransferMethods.goToCreateDeck(context);
            }
        });
    }
}

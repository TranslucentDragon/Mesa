package com.tuckervh.messaging.mesa.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tuckervh.messaging.mesa.R;

public class QuestionInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_interface);

        TextView questionScreen = findViewById(R.id.questionScreen_txtView);
        EditText answer_editText = findViewById(R.id.inputAnswerQuestionInterface_editText);
        Button enterAnswer_btn = findViewById(R.id.enterAnswer_btn);



    }
}

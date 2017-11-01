package com.example.berta.phoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Berta on 01/11/2017.
 */

public class CallingActivity extends AppCompatActivity {

    private TextView text_calling;
    private String new_number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

        text_calling = (TextView) findViewById(R.id.text_calling);

        //PART 2
        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        String message = String.format("%s %s", getString(R.string.calling), number);
        text_calling.setText(message);
    }

    public void EndCall(View view){
        //PART 3
        new_number = "";
        Intent data = new Intent();
        data.putExtra("number", new_number);
        setResult(RESULT_OK, data);
        finish();
    }
}

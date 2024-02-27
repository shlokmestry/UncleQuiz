package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameText;
    private Button lets_go;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.enter_your_name);
        lets_go = findViewById(R.id.lets_go);
        lets_go.setEnabled(false);

        // Disable Button
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (nameText.toString().trim().length()==0){
                    lets_go.setEnabled(false);
                }else {
                    lets_go.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //On Click Send Data

        lets_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }
    //

    //Send Data

    public void sendData()
    {
        name = nameText.getText().toString().trim();

        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        i.putExtra(MainActivity2.NAME,name);

        startActivity(i);

    }

    @Override
    public void onClick(View v) {

    }
}
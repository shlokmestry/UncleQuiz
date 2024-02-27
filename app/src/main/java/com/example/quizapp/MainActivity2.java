package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    public static final String NAME = "NAME";

    private TextView nameText;
    private String name;

    Button type1, type2, type3, type4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameText = findViewById(R.id.hey_text);

        Intent i = getIntent();
        name = i.getStringExtra(NAME);

        nameText.setText("Hey, " + name);


        // Click for General Knowledge - Buttons //

        type1 = (Button) findViewById(R.id.type1);
        type2 = (Button) findViewById(R.id.type2);
        type3 = (Button) findViewById(R.id.type3);
        type4 = (Button) findViewById(R.id.type4);

        // On CLICK LISTENERS//

        type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
                Intent intent = new Intent(MainActivity2.this, GeneralKnowledgeActivity.class);
                startActivity(intent);
            }
        });

        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
                Intent intent1 = new Intent(MainActivity2.this, GeographyActivity.class);
                startActivity(intent1);
            }
        });

        type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
                Intent intent2 = new Intent(MainActivity2.this, FoodActivity.class);
                startActivity(intent2);

            }
        });

        type4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
                Intent intent3 = new Intent(MainActivity2.this,AnimalsActivity.class);
                startActivity(intent3);
            }
        });
    }



    public void openNewActivity() {


    }


    @Override
    public void onClick(View v) {

    }
}

package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnimalsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitButton;


    int totalQuestion = QuestionAnswer4.question.length;
    int score = 0;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowledge);

        //Buttons//
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans1);
        ansB = findViewById(R.id.ans2);
        ansC = findViewById(R.id.ans3);
        ansD = findViewById(R.id.ans4);
        submitButton = findViewById(R.id.submitButton);


        // On Click Listeners//
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        loadNewQuestion();
    }


    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);


        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submitButton) {

            if (selectedAnswer.equals(QuestionAnswer4.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        } else {
            //choices button clicked//
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GRAY);
        }
    }

    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            loadResult();
            return;
        }


        questionTextView.setText(QuestionAnswer4.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer4.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer4.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer4.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer4.choices[currentQuestionIndex][3]);

    }
    void loadResult(){

        String passStatus;
        if (score > totalQuestion * 0.60) {
            passStatus = "Successful!";
        } else {
            passStatus = "Failed!";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score+" out of " + totalQuestion)
                .setPositiveButton("Try Another Quiz", ((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;

        Intent intent = new Intent(AnimalsActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}

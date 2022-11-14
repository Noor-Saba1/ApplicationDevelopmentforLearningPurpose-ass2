package com.example.appforlearningprocess_ass2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String question[] ={
            "What is capital of Pakistan?",
            "What is national animal of Pakistan?",
            "How many provinces are in Pakistan?",
            "Which of the following is river?",
            "Which from the following countries is not bordered with Pakistan?"
    };
    String choices[][] = {
            {"Mutlan","Islamabad","Karachi","Lahore"},
            {"Markhor","Tiger","Zebra","Elephant"},
            {"Two","Four","Six","Five"},
            {"Tarbela","Saif-ul-Malook","Indus","Mangla"},
            {"India","Afghanistan", "China","Bangladesh"}
    };
    String correctAnswers[] = {
            "Islamabad",
            "Markhor",
            "Four",
            "Indus",
            "Bangladesh"
    };


    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansA.setOnClickListener(this);
        ansB = findViewById(R.id.ans_B);
        ansB.setOnClickListener(this);
        ansC = findViewById(R.id.ans_C);
        ansC.setOnClickListener(this);
        ansD = findViewById(R.id.ans_D);
        ansD.setOnClickListener(this);
        submitBtn = findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.BLUE);
        ansB.setBackgroundColor(Color.BLUE);
        ansC.setBackgroundColor(Color.BLUE);
        ansD.setBackgroundColor(Color.BLUE);
        ansA.setTextColor(Color.WHITE);
        ansB.setTextColor(Color.WHITE);
        ansC.setTextColor(Color.WHITE);
        ansD.setTextColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.LTGRAY);
            clickedButton.setTextColor(Color.BLACK);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(question[currentQuestionIndex]);
        ansA.setText(choices[currentQuestionIndex][0]);
        ansB.setText(choices[currentQuestionIndex][1]);
        ansC.setText(choices[currentQuestionIndex][2]);
        ansD.setText(choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}


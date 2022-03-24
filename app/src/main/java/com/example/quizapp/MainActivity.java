package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.model.Question;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final Question[] questions = new Question[] {
            new Question(R.string.question_nintendo, true),
            new Question(R.string.question_apollo, false),
            new Question(R.string.question_lincoln, true)
    };

    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.textViewQuestion.setText(questions[0].getAnswerResId());

        binding.buttonTrue.setOnClickListener(view -> {
            if (questions[questionIndex].isAnswerTrue()) {
                Toast.makeText(MainActivity.this, R.string.answer_correct_feedback, Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, R.string.answer_incorrect_feedback, Toast.LENGTH_SHORT).show();
            }
        });

        binding.buttonFalse.setOnClickListener(view -> {
            if (!questions[questionIndex].isAnswerTrue()) {
                Toast.makeText(MainActivity.this, R.string.answer_correct_feedback, Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, R.string.answer_incorrect_feedback, Toast.LENGTH_SHORT).show();
            }
        });

        binding.buttonPrev.setOnClickListener(view -> {
            if (questionIndex > 0) {
                questionIndex--;
                binding.textViewQuestion.setText(questions[questionIndex].getAnswerResId());
            }
        });

        binding.buttonNext.setOnClickListener(view -> {
            if (questionIndex < questions.length - 1) {
                questionIndex++;
                binding.textViewQuestion.setText(questions[questionIndex].getAnswerResId());
            }
        });
    }
}
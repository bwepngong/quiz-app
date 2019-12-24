package com.farms.hp.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int answerOne = 0;
    private int answerTwo = 0;
    private int answerThree = 0;
    private int answerFour = 0;
    private int totalScore = 0;
    private int answerFive = 0;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void setAnswerOne(View v) {
        Boolean a11 = ((RadioButton) findViewById(R.id.a11)).isChecked();
        Boolean a12 = ((RadioButton) findViewById(R.id.a12)).isChecked();
        if (a11) { //correct answer 3 selected
            answerOne = 1;
        } else if (a12) {
            answerOne = 0;
        }
    }

    public void setAnswerTwo() {
        try {
            int ans = Integer.parseInt(((TextView) findViewById(R.id.answer_two_text)).getText().toString());

            if (ans == 10) { //ten years make a decade
                answerTwo = 1;
            } else {
                answerTwo = 0;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            answerTwo = 0;
        }

    }

    public void setAnswerThree(View v) {
        Switch yesNoSwitch = findViewById(R.id.answer_three);
        if (yesNoSwitch.isChecked()) { // Donald J Trump is 45th president of USA
            answerThree = 1;
        } else {
            answerThree = 0;
        }
    }

    public void setAnswerFour(View v) {
        if (v.getId() == findViewById(R.id.answerFourRadio2).getId()) { //correct answer selected
            answerFour = 1;
        } else {
            answerFour = 0;
        }
    }

    private void setAnswerFive() {
        Boolean optionOneIsChecked, optionTwoIsChecked, optionThreeIsChecked;
        optionOneIsChecked = ((CheckBox) findViewById(R.id.ans5_one)).isChecked();
        optionTwoIsChecked = ((CheckBox) findViewById(R.id.ans5_two)).isChecked();
        optionThreeIsChecked = ((CheckBox) findViewById(R.id.ans5_three)).isChecked();
        if (optionOneIsChecked & optionTwoIsChecked & !optionThreeIsChecked) { //first two are correct since dynamite is an example of explosives
            answerFive = 1;
        } else {
            answerFive = 0;
        }
    }

    private void displayScore() {
        totalScore = answerOne + answerTwo + answerThree + answerFour + answerFive;
        int scorePercentage = (totalScore / 4) * 100;
    }

    public void showToast(View v) {
        setAnswerTwo();
        setAnswerFive();
        displayScore();
        Toast toast = makeToast("Your total score is : " + totalScore + " / 5");
        toast.show();
    }

    private Toast makeToast(CharSequence cs) {
        Toast toast = Toast.makeText(this, cs, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }
}

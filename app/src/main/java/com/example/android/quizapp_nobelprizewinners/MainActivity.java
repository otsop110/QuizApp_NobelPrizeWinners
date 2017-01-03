package com.example.android.quizapp_nobelprizewinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {

    /*Defining global variables*/

    int score;
    int answer_three;
    int answer_five;
    int answer_six;

    private RadioGroup radioGroup_3;
    private RadioGroup radioGroup_5;
    private RadioGroup radioGroup_6;

    private CheckBox correct_A;
    private CheckBox incorrect_B;
    private CheckBox incorrect_C;
    private CheckBox correct_D;
    private CheckBox correct_E;

    private EditText answerOne;
    private EditText answerFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize Radio Group and attach click handler */
        radioGroup_3 = (RadioGroup) findViewById(R.id.q3_radioGroup);
        radioGroup_3.clearCheck();
        radioGroup_5 = (RadioGroup) findViewById(R.id.q5_radioGroup);
        radioGroup_5.clearCheck();
        radioGroup_6 = (RadioGroup) findViewById(R.id.q6_radioGroup);
        radioGroup_6.clearCheck();

        /* Initialize Checkboxes*/
        correct_A = (CheckBox) findViewById(R.id.checkbox_chemistry);
        incorrect_B = (CheckBox) findViewById(R.id.checkbox_fineArts);
        incorrect_C = (CheckBox) findViewById(R.id.checkbox_mathematics);
        correct_D = (CheckBox) findViewById(R.id.checkbox_physics);
        correct_E = (CheckBox) findViewById(R.id.checkbox_medicine);

        /* Initialize Edit Text Views*/
        answerOne = (EditText) findViewById(R.id.edit_answer_one);
        answerFour = (EditText) findViewById(R.id.edit_answer_four);
    }


    public void onRadioButtonClicked_answerThree(View view) {
        /* Checks if the radio button is checked. Only one button checked at once possible.*/
        boolean checked = ((RadioButton) view).isChecked();
        // Checks which choice was clicked on question number 3.
        switch (view.getId()) {
            // Wrong answer is selected.
            case R.id.radio_q3tooFew:
                if (checked)
                    answer_three = 0;
                break;
            // Right answer is selected.
            case R.id.radio_q3tooGood:
                if (checked)
                    answer_three = 1;
                break;
            // Another wrong answer is selected.
            case R.id.radio_q3tooMany:
                if (checked)
                    answer_three = 0;
                break;
        }

    }

    public void onRadioButtonClicked_answerFive(View view) {
        /* Checks if the radio button is checked. Only one button checked at once possible.*/
        boolean checked = ((RadioButton) view).isChecked();
        // Checks which choice was clicked on question number 5.
        switch (view.getId()) {
            // Wrong answer is selected.
            case R.id.radio_tooFewWomen:
                if (checked)
                    answer_five = 0;
                break;
            // Right answer is selected.
            case R.id.radio_goodAmountWomen:
                if (checked)
                    answer_five = 1;
                break;
            // Another wrong answer is selected.
            case R.id.radio_tooManyWomen:
                if (checked)
                    answer_five = 0;
                break;
        }

    }

    public void onRadioButtonClicked_answerSix(View view) {
        /* Checks if the radio button is checked. Only one button checked at once possible.*/
        boolean checked = ((RadioButton) view).isChecked();
        // Checks which choice was clicked on question number 6.
        switch (view.getId()) {
            // Wrong answer is selected.
            case R.id.radio_forbesOneHundred:
                if (checked)
                    answer_six = 0;
                break;
            // Right answer is selected.
            case R.id.radio_greatestBenefit:
                if (checked)
                    answer_six = 1;
                break;
            // Another wrong answer is selected.
            case R.id.radio_missionToMars:
                if (checked)
                    answer_six = 0;
                break;
        }
    }

    /*Calculate the score and set the toast message accordingly.*/
    public void allDone(View view) {

        // Checking and giving score to Edited text of answer One.

        String answer_one = answerOne.getText().toString();

        if (answer_one.equalsIgnoreCase("Stockholm")) {
            score += 1;
        } else {
            score += 0;
        }

        // Giving score to answer Two.

        if ((correct_A.isChecked()) && (correct_D.isChecked()) && (correct_E.isChecked()) && (!incorrect_B.isChecked()) && (!incorrect_C.isChecked())) {
            score += 1;
        } else {
            score += 0;
        }

        // Giving score to answer Three.
        if (answer_three >= 1) {
            score += 1;
        } else {
            score += 0;
        }

        // Checking and giving score to Edited text of answer Four.
        String answer_four = answerFour.getText().toString();

        if (answer_four.equalsIgnoreCase("Malala")) {
            score += 1;
        } else {
            score += 0;
        }

        // Giving score to answer Five.
        if (answer_five >= 1) {
            score += 1;
        } else {
            score += 0;
        }
        // Giving score to answer Six.
        if (answer_six >= 1) {
            score += 1;
        } else {
            score += 0;
        }

        if (score == 6) {
            //Toast if all answers are correct.
            Toast.makeText(this, "Score : " + score + "/6" + " " + "Congratulations! You are a Nobel Prize Laureate.", Toast.LENGTH_LONG).show();
        } else {
            //Toast if all answers are not correct.
            Toast.makeText(this, "Score : " + score + "/6" + " " + "Nothing to be ashamed of. You are a Nobel Prize Nominee.", Toast.LENGTH_LONG).show();
        }

        score = 0;
    }

    /*Reset quiz*/
    public void resetQuiz(View view) {
        radioGroup_3.clearCheck();
        radioGroup_5.clearCheck();
        radioGroup_6.clearCheck();
        correct_A.setChecked(false);
        correct_D.setChecked(false);
        correct_E.setChecked(false);
        incorrect_B.setChecked(false);
        incorrect_C.setChecked(false);
        answerOne.setText("");
        answerFour.setText("");
    }
}

package com.example.android.quizforgit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText usernameEditText = null;

    RadioGroup q1RadioGroup = null;
    CheckBox cb1 = null;
    CheckBox cb2 = null;
    CheckBox cb3 = null;
    EditText q3EditText = null;
    RadioGroup q4RadioGroup = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = (EditText)findViewById(R.id.user_name);
        q1RadioGroup = (RadioGroup) findViewById(R.id.question1_radiogroup);
        cb1 = (CheckBox) findViewById(R.id.q2_checkbox1);
        cb2 = (CheckBox) findViewById(R.id.q2_checkbox2);
        cb3 = (CheckBox) findViewById(R.id.q2_checkbox3);
        q3EditText =(EditText)findViewById(R.id.q3_edittext);
        q4RadioGroup = (RadioGroup) findViewById(R.id.question4_radiogroup);
    }

    public void submit(View view) {

        String username = usernameEditText.getText().toString();

        int q1Selected  = getAnsForRadioGroup(q1RadioGroup);

        boolean ans2 = false;

        if (cb1.isChecked() && cb2.isChecked() && (!cb3.isChecked()))
            ans2 = true;

        String ans3 = q3EditText.getText().toString();

        int q4Selected  = getAnsForRadioGroup(q4RadioGroup);

        displayMessage(getDisplayMessage(username,
                q1Selected,
                ans2,
                ans3,
                q4Selected));
    }

    private int getAnsForRadioGroup(RadioGroup radioGroup){
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);
        return idx;
    }

    private String getDisplayMessage(String username, int ans1, boolean ans2, String ans3,int ans4){
        String message = "Name: " + username;
        int score = 0;
        if(ans1 == 2) {
            message += "\nQuestion 1: True";
            score += 25;
        } else {
            message += "\nQuestion 1: False";
        }
        if(ans2) {
            message += "\nQuestion 2: True";
            score += 25;
        } else {
            message += "\nQuestion 2: False";
        }
        if (ans3.trim().equals("git log --oneline")) {
            message += "\nQuestion 3: True";
            score += 25;
        } else {
            message += "\nQuestion 3: False";
        }
        if(ans4 == 1) {
            message += "\nQuestion 4: True";
            score += 25;
        } else {
            message += "\nQuestion 4: False";
        }

        message += "\nYour Score: " + score;
        return message;
    }

    private void displayMessage(String message){
        TextView result = findViewById(R.id.result);
        result.setText(message);
    }


}

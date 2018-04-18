package com.example.android.quizforgit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        EditText usernameEditText =(EditText)findViewById(R.id.user_name);
        String username = usernameEditText.getText().toString();
        int q1Selected  = getAnsForRadioGroup(R.id.question1_radiogroup);
        CheckBox cb1 = (CheckBox) findViewById(R.id.q2_checkbox1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.q2_checkbox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.q2_checkbox3);
        boolean ans2 = false;
        if (cb1.isChecked() && cb2.isChecked() && (!cb3.isChecked()))
            ans2 = true;
        EditText q3EditText =(EditText)findViewById(R.id.q3_edittext);
        String ans3 = q3EditText.getText().toString();
        int q4Selected  = getAnsForRadioGroup(R.id.question4_radiogroup);
        displayMessage(getDisplayMessage(username,
                q1Selected,
                ans2,
                ans3,
                q4Selected));
    }

    private int getAnsForRadioGroup(int id){
        RadioGroup radioGroup = (RadioGroup) findViewById(id);
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

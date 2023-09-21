package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numField1;
    EditText numField2;
    int num1;
    int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numField1 = (EditText) findViewById(R.id.number1);
        numField2 = (EditText) findViewById(R.id.number2);
    }

    public void addFunction(View view) {
        parseStringToIntegers();
        goToResultActivity("+",num1+num2);
    }

    public void subtractFunction(View view) {
        parseStringToIntegers();
        goToResultActivity("-",num1-num2);
    }

    public void multiplyFunction(View view) {
        parseStringToIntegers();
        goToResultActivity("*", num1*num2);
    }

    public void divideFunction(View view) {
        parseStringToIntegers();
        if (num2 == 0) {
            Toast.makeText(MainActivity.this, "Cannot divide by 0.", Toast.LENGTH_LONG).show();
        } else {
            goToResultActivity("/", num1/num2);
        }
    }

    private void goToResultActivity(String operation, int result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("operation", operation);
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    private void parseStringToIntegers() {
        String numString1 = numField1.getText().toString();
        String numString2 = numField2.getText().toString();
        if (!numString1.isEmpty() && !numString2.isEmpty()) {
            num1 = Integer.parseInt(numString1);
            num2 = Integer.parseInt(numString2);
        } else {
            Toast.makeText(MainActivity.this, "Please fill out both fields.", Toast.LENGTH_LONG).show();
        }
    }
}
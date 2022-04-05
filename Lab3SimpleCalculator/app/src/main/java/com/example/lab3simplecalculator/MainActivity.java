package com.example.lab3simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    String op="+";
    String oldNum,newNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=findViewById(R.id.myNumber);
    }


    public void clearEvent(View view) {
        ed.getText().clear();
    }

    public void assEvent(View view) {
        newNum= ed.getText().toString();
        Double result=0.0;

        switch (op){
            case "+":result=Double.parseDouble(oldNum)+Double.parseDouble(newNum);break;
            case "-":result=Double.parseDouble(oldNum)-Double.parseDouble(newNum);break;
            case "*":result=Double.parseDouble(oldNum)*Double.parseDouble(newNum);break;
            case "/":result=Double.parseDouble(oldNum)/Double.parseDouble(newNum);break;
        }
        ed.setText(result+"");

    }

    public void operatorEvent(View view) {
        oldNum= ed.getText().toString();
        switch (view.getId()){
            case R.id.add:op="+";break;
            case R.id.sub:op="-";break;
            case R.id.mul:op="*";break;
            case R.id.div:op="/";break;
        }
        ed.getText().clear();

    }
    public void numberEvent(View view) {
        String num=ed.getText().toString();
        switch (view.getId()){
            case R.id.b0: num+=0; break;
            case R.id.b1: num+=1; break;
            case R.id.b2: num+=2; break;
            case R.id.b3: num+=3; break;
            case R.id.b4: num+=4; break;
            case R.id.b5: num+=5; break;
            case R.id.b6: num+=6; break;
            case R.id.b7: num+=7; break;
            case R.id.b8: num+=8; break;
            case R.id.b9: num+=9; break;
        }
        ed.setText(num);

    }
}
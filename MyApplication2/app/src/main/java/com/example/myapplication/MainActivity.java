package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.myName);
        btn=findViewById(R.id.myButton);


        btn.setOnClickListener(view -> {
            String name=editText.getText().toString();
            Toast.makeText(getApplicationContext(),"Hello "+name,Toast.LENGTH_LONG).show();

        });
    }
}
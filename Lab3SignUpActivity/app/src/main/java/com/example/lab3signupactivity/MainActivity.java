package com.example.lab3signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=findViewById(R.id.signUpText);
        password=findViewById(R.id.signUpPass);
    }

    public void signUp(View view) {
        String uname=userName.getText().toString();
        String pwd=password.getText().toString();

        if(!isValidPassword(pwd))
        {
            Toast.makeText(getApplicationContext(),"Password is not valid",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent= new Intent(MainActivity.this,LoginActivity.class);
        intent.putExtra("un",uname);
        intent.putExtra("pass",pwd);

        startActivity(intent);

    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern special=Pattern.compile("^.*[^a-z A-Z 0-9].*$");

    private boolean isValidPassword(String pwd) {
        if(pwd.length()<8 )
        {
            return false;
        }
        else if(!lowercase.matcher(pwd).matches())
        {
            return false;
        }
        else if(!uppercase.matcher(pwd).matches())
        {
            return false;
        }
        else if(!number.matcher(pwd).matches())
        {
            return false;
        }
        else if(!special.matcher(pwd).matches())
        {
            return false;
        }
        else {
            return true;
        }
    }


}
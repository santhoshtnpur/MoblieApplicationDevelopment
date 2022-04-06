package com.example.lab5startstop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int i=0;
    Handler handler= new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.text);
    }

    public void startEvent(View view) {
        handler.postDelayed(updateThread,0);
    }

    public void stopEvent(View view) {
        handler.removeCallbacks(updateThread);

    }

    private final Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            txt.setText(""+i);
            handler.postDelayed(this,1000);
            i++;
        }
    };
}
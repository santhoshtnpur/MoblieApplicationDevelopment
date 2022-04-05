package com.example.lab2wallpaperactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Timer myTimer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTimer= new Timer();
        wpm=WallpaperManager.getInstance(this);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMyWallpaper();
            }
        });
    }

    private void setMyWallpaper(){
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev == 1){
                    drawable=getResources().getDrawable(R.drawable.img4);
                    prev=2;
                }
                else if(prev==2){
                    drawable=getResources().getDrawable(R.drawable.img1);
                    prev=3;
                }
                else if(prev==3){
                    drawable=getResources().getDrawable(R.drawable.img2);
                    prev=4;
                }
                else if(prev==4){
                    drawable=getResources().getDrawable(R.drawable.img3);
                    prev=1;
                }
                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();
                try{
                    wpm.setBitmap(wallpaper);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }
}
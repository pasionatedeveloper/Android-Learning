package com.ajssoftwares.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //main thread or UI thread

        //thread class is used to make custom thread

        //(ANR application not responding)

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();

                try{
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent =  new Intent(getApplicationContext(), RegistrationActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
}
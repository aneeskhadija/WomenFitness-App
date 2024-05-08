package com.newappzone.Femaleworkout2020.womenworkoutathome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.newappzone.Femaleworkout2020.womenworkoutathome.R;

public class SplashScreen extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent= new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);

    }

    @Override
    public void onBackPressed() {
        handler.removeCallbacks((Runnable) handler);
        super.onBackPressed();
    }
}

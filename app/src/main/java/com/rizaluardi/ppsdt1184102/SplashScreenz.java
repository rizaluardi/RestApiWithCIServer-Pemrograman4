package com.rizaluardi.ppsdt1184102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenz extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    private final int loading_splash=4000;

    private static final String DROPSPLASH="drop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefsd = this.getSharedPreferences(DROPSPLASH, Context.MODE_PRIVATE);
        if (prefsd.getBoolean("isDrop", false)) {
            Intent mainIntent = new Intent(SplashScreenz.this, LoginAct.class);
            startActivity(mainIntent);
        }
        else
            setContentView(R.layout.activity_splash_screenz);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                prefsd.edit().putBoolean("isDrop", true).apply();
                Intent mainIntent = new Intent(SplashScreenz.this,LoginAct.class);
                SplashScreenz.this.startActivity(mainIntent);
                SplashScreenz.this.finish();
            }
        }, loading_splash);
    }
}
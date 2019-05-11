package com.fwahyudianto.rossoneri;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final Handler oHandler = new Handler();
        oHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
/*                Intent oIntentHome = new Intent(MainActivity.this, HomeActivity.class);*/
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        }, 3000);
    }
}
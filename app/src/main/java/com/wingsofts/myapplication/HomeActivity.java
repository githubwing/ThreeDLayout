package com.wingsofts.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by wing on 2016/10/16.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }


    public void startWeatherActivity(View view){
        startActivity(new Intent(this,WeatherActivity.class));
    }

    public void startUserCenterActivity(View view){
        startActivity(new Intent(this,UserCenterActivity.class));
    }
}

package com.wingsofts.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wingsofts.threedlayout.ThreeDLayout;

public class UserCenterActivity extends AppCompatActivity {
    ThreeDLayout tdAvatar;
    ThreeDLayout tdRoot;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);

        tdAvatar = (ThreeDLayout) findViewById(R.id.td_avatar);
        tdAvatar.setTouchMode(ThreeDLayout.MODE_BOTH_X_Y);
        tdAvatar.setMaxRotateDegree(30);

        tdRoot = (ThreeDLayout) findViewById(R.id.td_root);

        dialog =new  AlertDialog.Builder(this).setMessage("refreshing....").create();


    }


    public void refresh(View view) {
        dialog.show();
        tdRoot.startHorizontalAnimate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        tdRoot.stopAnimate();
                    }
                });
            }
        }).start();


    }
}

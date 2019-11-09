package com.bawei.weidumovie.view.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.weidumovie.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.weidumovie.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.guideclick)
    RelativeLayout mGuideclick;
    @BindView(R.id.time)
    TextView mTime;

    private int variabel = 4;
    private Timer timer;

    @Override
    protected void initView(Bundle savedInstanceState) {
        delay();

        mGuideclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
                timer.cancel();
            }
        });

    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    private void delay() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (variabel != 0) {
                            variabel--;
                            mTime.setText(variabel + "s");
                            return;
                        } else {
                            timer.cancel();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            finish();
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }
}


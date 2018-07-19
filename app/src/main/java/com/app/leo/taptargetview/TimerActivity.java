package com.app.leo.taptargetview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {

    TextView remTimeTV,setTimeTV;
    Button startTimebtn;
    private int seconds=30;
    private boolean stopTimer=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        init();
        startTimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!stopTimer)
                {
                    timer();

                }
            }
        });

    }
    public void timer()
    {
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(seconds>0)
                {
                    seconds--;
                    stopTimer=true;
                    setTimeTV.setText(String.valueOf(seconds)+" seconds");
                    handler.postDelayed(this,1000);
                }
                else {
                    //Timer Complite..
                    stopTimer=false;
                    seconds=30;
                    setTimeTV.setText(String.valueOf(seconds)+" seconds");
                    Toast.makeText(TimerActivity.this, "Time Already Finished!!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void init() {
        remTimeTV=findViewById(R.id.timeRem);
        setTimeTV=findViewById(R.id.timeSet);
        startTimebtn=findViewById(R.id.startBtn);
    }
}

package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    SeekBar simpleSeekBar;
    public static final int delta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

//        final ProgressBar simppleSeekBar = (ProgressBar) findViewById(R.id.simpleSeekBar);

            simpleSeekBar = (SeekBar)findViewById (R.id.simpleSeekBar);

            simpleSeekBar.setMax(10*100);
            simpleSeekBar.setProgress(2*100);
//
            simpleSeekBar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener () {

            int progressChangedValue = 0;
//            private int smoothnessFactor = 10;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                progressChangedValue = progress+delta ;
//                progress = Math.round (progress / smoothnessFactor);

//               progressChangedValue = progress;

                if (fromUser) {
                    seekBar.setProgress(Math.round((float)progress / 100) * 100);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

//                seekBar.setProgress(Math.round((seekBar.getProgress() + (smoothnessFactor / 2)) / smoothnessFactor) * smoothnessFactor);

                Toast.makeText(MainActivity.this, "Dent Value :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();

            }

                public void animateSeekbar(int toProgress) {
                    ObjectAnimator animation = ObjectAnimator.ofInt(simpleSeekBar, "progress", toProgress*100);
                    animation.setDuration(1000);
                    animation.start();
                }

        });


    }
}

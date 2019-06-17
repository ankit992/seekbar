package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class SmoothSeekbar extends android.support.v7.widget.AppCompatSeekBar {


    public SmoothSeekbar(Context context) {
        super(context);
    }

    public SmoothSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmoothSeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        super.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = getProgress();

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    this.progress = seekBar.getProgress();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (progress > 700) {
                    ObjectAnimator.ofInt(seekBar, "progress", 1000).setDuration(500).start();
                } else if (progress < 300) {
                    ObjectAnimator.ofInt(seekBar, "progress", 0).setDuration(500).start();
                } else {
                    ObjectAnimator.ofInt(seekBar, "progress", 500).setDuration(500).start();
                }
            }
        });
    }

}

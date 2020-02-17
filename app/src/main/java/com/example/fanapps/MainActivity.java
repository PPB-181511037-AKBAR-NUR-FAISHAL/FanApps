package com.example.fanapps;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggeButton;
    ImageView imageView2;
    ObjectAnimator rotateAnimator;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0, 750, 500, 250};
    GradientDrawable gd = new GradientDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        toggeButton = (ToggleButton) findViewById(R.id.toggleButton);
        switchButton = (Switch)findViewById(R.id.switch1);
        seekBar = (SeekBar)findViewById(R.id.seekBar2);

        rotateAnimator=ObjectAnimator.ofFloat(imageView2, "rotation", 0,360);
        rotateAnimator.setDuration(1000);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setInterpolator(new LinearInterpolator());

        toggeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggeButton.isChecked()==true){
                    rotateAnimator.setDuration(SPEED[3]);
                    rotateAnimator.start();
                }else{
                    rotateAnimator.end();
                }
            }
        });
        seekBar.setMax(3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 3 && toggeButton.isChecked()==true){
                    rotateAnimator.setDuration(SPEED[3]);
                    rotateAnimator.start();
                }else if(progress == 2 && toggeButton.isChecked()==true){
                    rotateAnimator.setDuration(SPEED[2]);
                    rotateAnimator.start();
                }else if(progress == 1 && toggeButton.isChecked()==true){
                    rotateAnimator.setDuration(SPEED[1]);
                    rotateAnimator.start();
                }else if (progress == 0 && toggeButton.isChecked()==true){
                    rotateAnimator.setDuration(SPEED[0]);
                    rotateAnimator.start();
                } else {
                    rotateAnimator.end();
                }
                switchButton.callOnClick();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gd.setGradientRadius(330);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchButton.isChecked()){
                    gd.setColors(new int[]{Color.YELLOW, Color.TRANSPARENT});
                    imageView2.setBackground(gd);
                }else {
                    imageView2.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
    }
}

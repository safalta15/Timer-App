
package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.timer.R;


public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    SeekBar timeSeekBar;
    Boolean counterIsActive = false;
    Button goButton;
    CountDownTimer countDownTimer;
    public void resetTimer()
    {
        timerTextView.setText("0:30");
        timeSeekBar.setProgress(30);
        timeSeekBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("GO!");
        counterIsActive=false;
    }
    public void buttonClicked(View view){

        if(counterIsActive){
            resetTimer();
        } else{

        counterIsActive=true;
        timeSeekBar.setEnabled(false);
        goButton.setText("STOP");
        countDownTimer = new CountDownTimer(timeSeekBar.getProgress()*1000 + 100,1000) {
            @Override
            public void onTick(long l) {
updateTimer((int) l/1000);
            }

            @Override
            public void onFinish() {
                MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.taronksahar);
                mplayer.start();
                resetTimer();
            }
        }.start();
}
        }
    public void updateTimer(int secondLeft) {
        int minute = secondLeft/60;
        int second = secondLeft-(minute*60);
        String secondString = Integer.toString(second);
        if(second<=9) {
            secondString= "0" + secondString;
        }
        timerTextView.setText(Integer.toString(minute) + ":" + secondString);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeSeekBar = findViewById(R.id.seekBar2);
        timerTextView = findViewById(R.id.textView);
        goButton=findViewById(R.id.button2);
        timeSeekBar.setMax(600);
    timeSeekBar.setProgress(30);
    timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
    }
}
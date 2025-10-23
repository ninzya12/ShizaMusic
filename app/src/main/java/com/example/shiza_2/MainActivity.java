package com.example.shiza_2;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button playButton, pauseButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.music);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    private void stopPlay() {
            mPlayer.stop();
            mPlayer.seekTo(0);
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(false);
        }

    public void play(View view) {
            mPlayer.start();
            playButton.setEnabled(false);
            pauseButton.setEnabled(true);
            stopButton.setEnabled(true);
    }

    public void pause(View view) {
            mPlayer.pause();
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(true);
    }

    public void stop(View view) {
        stopPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}

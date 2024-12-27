package com.example.macplayer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;



public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private Button btnPlay, btnPause, btnNext, btnPrev;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_player);

        videoView = findViewById(R.id.videoView);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrevious);
        mediaController = new MediaController(this);

        Intent intent = getIntent();
        String videoUriString = intent.getStringExtra("videoUri");
        Uri videoUri = Uri.parse(videoUriString);

        videoView.setVideoURI(videoUri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        // Play Button
        btnPlay.setOnClickListener(v -> videoView.start());

        // Pause Button
        btnPause.setOnClickListener(v -> videoView.pause());

        // Next and Previous - Example functionality (dummy implementation)
        btnNext.setOnClickListener(v -> videoView.seekTo(videoView.getCurrentPosition() + 5000));
        btnPrev.setOnClickListener(v -> videoView.seekTo(videoView.getCurrentPosition() - 5000));
    }

}

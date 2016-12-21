package com.vinu.epoise.ePoiseRecruiter.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.vinu.epoise.ePoiseRecruiter.R;

public class VideoStreamingActivity extends AppCompatActivity {

    ProgressDialog pDialog;
    VideoView videoview;

//    String VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
        videoview = (VideoView) findViewById(R.id.video_response_url);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Video");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String VideoURL= bundle.getString("selectedVideoResponseUrl");

        // Execute StreamVideo AsyncTask
        pDialog = new ProgressDialog(VideoStreamingActivity.this);
        pDialog.setTitle("Android Video Streaming Tutorial");
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(VideoStreamingActivity.this);
            mediacontroller.setAnchorView(videoview);

            // Get the URL from String VideoURL
            if(VideoURL==null){
                Toast.makeText(getApplicationContext(),"No url",Toast.LENGTH_SHORT).show();
            }
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

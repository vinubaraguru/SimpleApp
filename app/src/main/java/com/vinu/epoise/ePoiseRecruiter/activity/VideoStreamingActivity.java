package com.vinu.epoise.ePoiseRecruiter.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.vinu.epoise.ePoiseRecruiter.R;

public class VideoStreamingActivity extends AppCompatActivity {

//    ProgressDialog pDialog;
    VideoView videoview;
    private ProgressBar mProgressBar;

//    String VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
        videoview = (VideoView) findViewById(R.id.video_response_url);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Video Response");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = (ProgressBar) findViewById(R.id.video_response_url_progressBar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String VideoURL= bundle.getString("selectedVideoResponseUrl");

        // Execute StreamVideo AsyncTask

//        pDialog = new ProgressDialog(VideoStreamingActivity.this);
//        pDialog.setTitle("Android Video Streaming Tutorial");
//        pDialog.setMessage("Buffering...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();

        mProgressBar.setVisibility(ProgressBar.VISIBLE);
        if(isNetworkAvailable()){

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
//                pDialog.dismiss();
                        mProgressBar.setVisibility(ProgressBar.INVISIBLE);
                        videoview.start();
                }
            });
        }else{
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
            AlertDialog.Builder builder = new AlertDialog.Builder(VideoStreamingActivity.this);
            builder.setTitle("Network error");
            builder.setMessage("No Internet connection. Please connect to internet and try again");
            builder.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            Toast.makeText(getApplicationContext(),"Thank you",Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.show();
        }


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

    //Checking network status
    private boolean isNetworkAvailable(){

        ConnectivityManager manager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=manager.getActiveNetworkInfo();
        boolean isAvailable=false;

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;
    }

}

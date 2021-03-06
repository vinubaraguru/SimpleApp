package com.vinu.epoise.ePoiseRecruiter.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.HiringCandidateResponseRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse;

import java.util.ArrayList;

public class HiringCandidateResponseActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<HiringCandidateResponse> mHiringCandidateResponseArrayList = new ArrayList<>();

    private HiringCandidateResponseRecyclerViewAdapter mHiringCandidateResponseRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private Button rejectButton,shortListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_candidate_response);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("Evaluation");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transperent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(255,255,255));


        rejectButton=(Button) findViewById(R.id.reject);
        shortListButton=(Button)findViewById(R.id.shortlist);

        rejectButton.setOnClickListener(this);
        shortListButton.setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.hiring_candidate_response_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mHiringCandidateResponseRecyclerViewAdapter = new HiringCandidateResponseRecyclerViewAdapter(this.getApplicationContext() , mHiringCandidateResponseArrayList);
        mRecyclerView.setAdapter(mHiringCandidateResponseRecyclerViewAdapter);

        prepareListData();

    }

    private void prepareListData() {


        HiringCandidateResponse hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.VIDEO_TYPE,"Do you believe on Luck and do you depend on it?","https://s3-ap-southeast-1.amazonaws.com/epoise-prod-whitelabel-hpjobs-videos/Compressed_Response_58243ab578818f242f148749_58182e8b4a83447f64721ae6_1a1af7ed8dd8dda8cbdf0815.mp4");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

        hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.MULTI_TYPE,"Please respond to the following question in Hindi.Do you believe on Luck and do you depend on it?","B");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

        hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.SINGLE_TYPE,"Do you believe on Luck and do you depend on it?","C");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

        hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.VIDEO_TYPE,"Then scroll back up and start reading the text. like this easy to bear","https://s3-ap-southeast-1.amazonaws.com/epoise-prod-whitelabel-hpjobs-videos/Compressed_Response_58243ab578818f242f148749_58182e8b4a83447f64721ae6_1a1af7ed8dd8dda8cbdf0815.mp4");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

        hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.SINGLE_TYPE,"Your audio and video will both get recorded.After a winter in the south of France one don't find arctic weather","E");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

        hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.SINGLE_TYPE,"Do you believe on Luck and do you depend on it?","F");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

        hiringCandidateResponse=new HiringCandidateResponse(HiringCandidateResponse.SINGLE_TYPE,"Your audio and video will both get recorded.After a winter in the south of France one don't find arctic weather","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(hiringCandidateResponse);

    }

    @Override
    public void onClick(View view) {
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Reject",Toast.LENGTH_SHORT).show();
            }
        });

        shortListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Shortlist",Toast.LENGTH_LONG).show();
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

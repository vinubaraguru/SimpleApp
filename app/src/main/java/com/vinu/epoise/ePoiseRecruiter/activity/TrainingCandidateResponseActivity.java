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
import com.vinu.epoise.ePoiseRecruiter.adapter.TrainingCandidateResponseRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.model.TrainingCandidateResponse;

import java.util.ArrayList;

/**
 * Created by ImVB9 on 12/21/2016.
 */

public class TrainingCandidateResponseActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<TrainingCandidateResponse> mHiringCandidateResponseArrayList = new ArrayList<>();

    private TrainingCandidateResponseRecyclerViewAdapter mTrainingCandidateResponseRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private Button evaluateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_candidate_response);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("Evaluation");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transperent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(255,255,255));

        evaluateButton=(Button) findViewById(R.id.evaluate);

        evaluateButton.setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.training_candidate_response_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTrainingCandidateResponseRecyclerViewAdapter = new TrainingCandidateResponseRecyclerViewAdapter(this.getApplicationContext() , mHiringCandidateResponseArrayList);
        mRecyclerView.setAdapter(mTrainingCandidateResponseRecyclerViewAdapter);

        prepareListData();

    }

    private void prepareListData() {


        TrainingCandidateResponse trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_VIDEO_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_SINGLE_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_MULTI_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_VIDEO_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_SINGLE_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_VIDEO_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_MULTI_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_VIDEO_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_SINGLE_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_MULTI_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

        trainingCandidateResponse=new TrainingCandidateResponse(TrainingCandidateResponse.TRAINING_FEEDBACK_TYPE,"Do you believe on Luck and do you depend on it?","http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        mHiringCandidateResponseArrayList.add(trainingCandidateResponse);

    }

    @Override
    public void onClick(View view) {
        evaluateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Evaluated", Toast.LENGTH_SHORT).show();
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

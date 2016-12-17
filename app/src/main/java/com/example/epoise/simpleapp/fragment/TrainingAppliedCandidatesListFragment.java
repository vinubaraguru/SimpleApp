package com.example.epoise.simpleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epoise.simpleapp.R;
import com.example.epoise.simpleapp.adapter.TrainingAppliedCandidatesRecyclerViewAdapter;
import com.example.epoise.simpleapp.helper.DividerItemDecoration;
import com.example.epoise.simpleapp.model.TrainingAppliedCandidateList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/15/2016.
 */

public class TrainingAppliedCandidatesListFragment extends Fragment {

    private TrainingAppliedCandidatesRecyclerViewAdapter mTrainingAppliedCandidatesRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_training_applied_candidates_list, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.training_candidate_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mTrainingAppliedCandidatesRecyclerViewAdapter = new TrainingAppliedCandidatesRecyclerViewAdapter(this.getActivity(),trainingCandidateListView());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mTrainingAppliedCandidatesRecyclerViewAdapter);

        return view;
    }

    private ArrayList<TrainingAppliedCandidateList> trainingCandidateListView() {

        final ArrayList<TrainingAppliedCandidateList> trainingAppliedCandidateListArrayList = new ArrayList<>();

        TrainingAppliedCandidateList trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        trainingAppliedCandidateList=new TrainingAppliedCandidateList("Vinu","vinu@epoise.com");
        trainingAppliedCandidateListArrayList.add(trainingAppliedCandidateList);

        return trainingAppliedCandidateListArrayList;
    }
}


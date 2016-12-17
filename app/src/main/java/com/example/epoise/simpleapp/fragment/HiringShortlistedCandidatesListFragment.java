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
import com.example.epoise.simpleapp.adapter.HiringAppliedCandidateRecyclerViewAdapter;
import com.example.epoise.simpleapp.helper.DividerItemDecoration;
import com.example.epoise.simpleapp.model.HiringAppliedCandidateList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/15/2016.
 */

public class HiringShortlistedCandidatesListFragment extends Fragment {

    private HiringAppliedCandidateRecyclerViewAdapter mHiringAppliedCandidateRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hiring_applied_candidates, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.hiring_applied_candidate_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mHiringAppliedCandidateRecyclerViewAdapter = new HiringAppliedCandidateRecyclerViewAdapter(this.getActivity(),invitedCandidateListView());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mHiringAppliedCandidateRecyclerViewAdapter);

        return view;
    }

    private ArrayList<HiringAppliedCandidateList> invitedCandidateListView() {

        final ArrayList<HiringAppliedCandidateList> hiringAppliedCandidateListArrayList = new ArrayList<>();

        HiringAppliedCandidateList hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);

        hiringAppliedCandidateList=new HiringAppliedCandidateList("Vinu","vinu@epoise.com");
        hiringAppliedCandidateListArrayList.add(hiringAppliedCandidateList);


        return hiringAppliedCandidateListArrayList;
    }
}

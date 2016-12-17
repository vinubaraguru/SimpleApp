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
import com.example.epoise.simpleapp.adapter.InvitedCandidateListRecyclerViewAdapter;
import com.example.epoise.simpleapp.helper.DividerItemDecoration;
import com.example.epoise.simpleapp.model.InvitedCandidateList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InviteShortlistedCandidateListFragment extends Fragment {

    private InvitedCandidateListRecyclerViewAdapter mInvitedCandidateListRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_invited_candidates_list, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.invited_cand_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mInvitedCandidateListRecyclerViewAdapter = new InvitedCandidateListRecyclerViewAdapter(this.getActivity(),invitedCandidateListView());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mInvitedCandidateListRecyclerViewAdapter);

        return view;
    }

    private ArrayList<InvitedCandidateList> invitedCandidateListView() {

        final ArrayList<InvitedCandidateList> invitedCandidateListArrayList = new ArrayList<>();

        InvitedCandidateList invitedCandidateList=new InvitedCandidateList("Vinu","vinu@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        invitedCandidateList=new InvitedCandidateList("Raju","vinu@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        invitedCandidateList=new InvitedCandidateList("Raju","raju@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        invitedCandidateList=new InvitedCandidateList("Amogh","manu@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        invitedCandidateList=new InvitedCandidateList("epoise","vinu@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        invitedCandidateList=new InvitedCandidateList("Noor","vinu@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        invitedCandidateList=new InvitedCandidateList("Manish","vinu@epoise.com");
        invitedCandidateListArrayList.add(invitedCandidateList);

        return invitedCandidateListArrayList;
    }
}


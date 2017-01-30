package com.vinu.epoise.ePoiseRecruiter.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.InvitedCandidateListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.controller.UserAPIRestManager;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.InvitedCandidateList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InviteRejectedCandidateListFragment extends Fragment {

    private InvitedCandidateListRecyclerViewAdapter mInvitedCandidateListRecyclerViewAdapter;
    private UserAPIRestManager userAPIRestManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_invited_candidates_list, null);

        mProgressBar = (ProgressBar) view.findViewById(R.id.invited_cand_list_progressBar);
        textView= (TextView) view.findViewById(R.id.swipe_text_inviteCandidateList);
        textView.setVisibility(View.INVISIBLE);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.invited_cand_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mInvitedCandidateListRecyclerViewAdapter = new InvitedCandidateListRecyclerViewAdapter(getContext());
        recyclerView.setAdapter(mInvitedCandidateListRecyclerViewAdapter);

        inviteRejectedCandidateListView();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_inviteCandidateList);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.pink, R.color.indigo, R.color.lime, R.color.sky_blue, R.color.maroon);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshInviteRejectedCandidateListView();
            }
        });


        return view;
    }

    private void inviteRejectedCandidateListView() {

        mProgressBar.setVisibility(View.VISIBLE);

        if(isNetworkAvailable()){

            userAPIRestManager = new UserAPIRestManager();
            Call<List<InvitedCandidateList>> invitedCandidateListCall = userAPIRestManager.getRequestInterface().getInvitedCandidates();
            invitedCandidateListCall.enqueue(new Callback<List<InvitedCandidateList>>() {
                @Override
                public void onResponse(Call<List<InvitedCandidateList>> call, Response<List<InvitedCandidateList>> response) {

                    mProgressBar.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);

                    if(response.isSuccess()){

                        List<InvitedCandidateList> invitedCandidateLists = response.body();

                        for (int i = 0; i < invitedCandidateLists.size(); i++) {
                            InvitedCandidateList invitedCandidate = invitedCandidateLists.get(i);
                            mInvitedCandidateListRecyclerViewAdapter.addInvitedCandidate(invitedCandidate);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<InvitedCandidateList>> call, Throwable t) {

                    mProgressBar.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Error");
                    builder.setMessage("Oops..! Looks like there is some problem, Please try again after sometime");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Toast.makeText(getContext(),"Thank you",Toast.LENGTH_SHORT).show();
                                }
                            });
                    builder.show();
                }
            });
        }else{

            mProgressBar.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);

            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            inviteRejectedCandidateListView();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();

        }
    }

    //Checking network status
    private boolean isNetworkAvailable(){

        ConnectivityManager manager=(ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=manager.getActiveNetworkInfo();
        boolean isAvailable=false;

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;
    }

    private void swipeRefreshInviteRejectedCandidateListView(){
        if(isNetworkAvailable()){

            userAPIRestManager = new UserAPIRestManager();
            Call<List<InvitedCandidateList>> invitedCandidateListCall = userAPIRestManager.getRequestInterface().getInvitedCandidates();
            invitedCandidateListCall.enqueue(new Callback<List<InvitedCandidateList>>() {
                @Override
                public void onResponse(Call<List<InvitedCandidateList>> call, Response<List<InvitedCandidateList>> response) {

                    textView.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);

                    if(response.isSuccess()){

                        List<InvitedCandidateList> invitedCandidateLists = response.body();

                        for (int i = 0; i < invitedCandidateLists.size(); i++) {
                            InvitedCandidateList invitedCandidate = invitedCandidateLists.get(i);
                            mInvitedCandidateListRecyclerViewAdapter.addInvitedCandidate(invitedCandidate);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<InvitedCandidateList>> call, Throwable t) {

                    textView.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Error");
                    builder.setMessage("Oops..! Looks like there is some problem, Please try again after sometime");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Toast.makeText(getContext(),"Thank you",Toast.LENGTH_SHORT).show();
                                }
                            });
                    builder.show();
                }
            });
        }else{
            swipeRefreshLayout.setRefreshing(false);
            textView.setVisibility(View.VISIBLE);

            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            inviteRejectedCandidateListView();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();

        }
    }
}


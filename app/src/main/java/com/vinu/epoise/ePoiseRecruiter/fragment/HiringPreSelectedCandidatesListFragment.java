package com.vinu.epoise.ePoiseRecruiter.fragment;

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
import com.vinu.epoise.ePoiseRecruiter.adapter.HiringAppliedCandidateRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.controller.ContactAPIManager;
import com.vinu.epoise.ePoiseRecruiter.controller.UserAPIRestManager;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.HiringAppliedCandidateList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ePoise on 12/15/2016.
 */

public class HiringPreSelectedCandidatesListFragment extends Fragment {

    private HiringAppliedCandidateRecyclerViewAdapter mHiringAppliedCandidateRecyclerViewAdapter;
    private ContactAPIManager contactAPIManager;
    private ArrayList<HiringAppliedCandidateList.Contact> hiringAppliedCandidateList;
    private ProgressBar mProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hiring_applied_candidates, null);

        mProgressBar = (ProgressBar) view.findViewById(R.id.hiring_candidate_applied_list_progressBar);
        textView= (TextView) view.findViewById(R.id.swipe_text_hiring_candidate_applied_list);
        textView.setVisibility(View.INVISIBLE);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.hiring_applied_candidate_list_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mHiringAppliedCandidateRecyclerViewAdapter = new HiringAppliedCandidateRecyclerViewAdapter(getContext());
        recyclerView.setAdapter(mHiringAppliedCandidateRecyclerViewAdapter);

        hiringPreSelectedCandidateListView();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_hiring_candidate_applied_list);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.pink, R.color.indigo, R.color.lime, R.color.sky_blue, R.color.maroon);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshHiringPreSelectedCandidateListView();
            }
        });

        return view;
    }

    private void hiringPreSelectedCandidateListView() {

        mProgressBar.setVisibility(View.VISIBLE);

        if(isNetworkAvailable()) {
            contactAPIManager =new ContactAPIManager();
            Call<HiringAppliedCandidateList> hiringOppListCall = contactAPIManager.getRequestInterface().getHiringAppliedCandidates();
            hiringOppListCall.enqueue(new Callback<HiringAppliedCandidateList>() {
                @Override
                public void onResponse(Call <HiringAppliedCandidateList> call, Response<HiringAppliedCandidateList> response) {

                    mProgressBar.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                    if(response.isSuccess()){
                        hiringAppliedCandidateList = response.body().getContacts();
                        for (int i = 0; i < hiringAppliedCandidateList.size(); i++) {
                            HiringAppliedCandidateList.Contact contact = hiringAppliedCandidateList.get(i);
                            mHiringAppliedCandidateRecyclerViewAdapter.addContact(contact);
                        }
                    }
                }

                @Override
                public void onFailure(Call<HiringAppliedCandidateList> call, Throwable t) {

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
            textView.setVisibility(View.INVISIBLE);

            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            hiringPreSelectedCandidateListView();
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

    private void swipeRefreshHiringPreSelectedCandidateListView(){

        if(isNetworkAvailable()) {
            contactAPIManager =new ContactAPIManager();
            Call<HiringAppliedCandidateList> hiringOppListCall = contactAPIManager.getRequestInterface().getHiringAppliedCandidates();
            hiringOppListCall.enqueue(new Callback<HiringAppliedCandidateList>() {
                @Override
                public void onResponse(Call <HiringAppliedCandidateList> call, Response<HiringAppliedCandidateList> response) {

                    swipeRefreshLayout.setRefreshing(false);
                    textView.setVisibility(View.INVISIBLE);

                    if(response.isSuccess()){
                        hiringAppliedCandidateList = response.body().getContacts();
                        for (int i = 0; i < hiringAppliedCandidateList.size(); i++) {
                            HiringAppliedCandidateList.Contact contact = hiringAppliedCandidateList.get(i);
                            mHiringAppliedCandidateRecyclerViewAdapter.addContact(contact);
                        }
                    }
                }

                @Override
                public void onFailure(Call<HiringAppliedCandidateList> call, Throwable t) {

                    swipeRefreshLayout.setRefreshing(false);
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

            swipeRefreshLayout.setRefreshing(false);
            textView.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            hiringPreSelectedCandidateListView();
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

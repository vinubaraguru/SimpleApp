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
import com.vinu.epoise.ePoiseRecruiter.adapter.TrainingOppListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.controller.APIRestManager;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.TrainingOppList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ePoise on 12/15/2016.
 */

public class TrainingOppListFragment  extends Fragment {

    private TrainingOppListRecyclerViewAdapter mTrainingOppListRecyclerViewAdapter;
    private APIRestManager apiRestManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar mProgressBar;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_training_opp_list, null);

        mProgressBar = (ProgressBar) view.findViewById(R.id.training_opp_list_progressBar);
        textView= (TextView) view.findViewById(R.id.swipe_text_training_opp_list);
        textView.setVisibility(View.INVISIBLE);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.training_opp_list_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mTrainingOppListRecyclerViewAdapter = new TrainingOppListRecyclerViewAdapter(getContext());
        recyclerView.setAdapter(mTrainingOppListRecyclerViewAdapter);

        trainingOppListView();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_training_opp_list);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.pink, R.color.indigo, R.color.lime, R.color.sky_blue, R.color.maroon);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshTrainingOppListView();
            }
        });
        return view;
    }

    private void trainingOppListView() {

        mProgressBar.setVisibility(View.VISIBLE);

        if(isNetworkAvailable()){

            apiRestManager =new APIRestManager();
            Call<List<TrainingOppList>> trainingOppListCall = apiRestManager.getRequestInterface().getTrainingOppList();
            trainingOppListCall.enqueue(new Callback<List<TrainingOppList>>() {
                @Override
                public void onResponse(Call<List<TrainingOppList>> call, Response<List<TrainingOppList>> response) {

                    mProgressBar.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);

                    if(response.isSuccess()){
                        List<TrainingOppList> trainingOppLists = response.body();

                        for (int i = 0; i < trainingOppLists.size(); i++) {
                            TrainingOppList inviteOpp = trainingOppLists.get(i);
                            mTrainingOppListRecyclerViewAdapter.addTraingOppList(inviteOpp);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<TrainingOppList>> call, Throwable t) {
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
                            trainingOppListView();
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

    private void swipeRefreshTrainingOppListView(){

        if(isNetworkAvailable()){

            apiRestManager =new APIRestManager();
            Call<List<TrainingOppList>> trainingOppListCall = apiRestManager.getRequestInterface().getTrainingOppList();
            trainingOppListCall.enqueue(new Callback<List<TrainingOppList>>() {
                @Override
                public void onResponse(Call<List<TrainingOppList>> call, Response<List<TrainingOppList>> response) {

                    textView.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);

                    if(response.isSuccess()){
                        List<TrainingOppList> trainingOppLists = response.body();

                        for (int i = 0; i < trainingOppLists.size(); i++) {
                            TrainingOppList inviteOpp = trainingOppLists.get(i);
                            mTrainingOppListRecyclerViewAdapter.addTraingOppList(inviteOpp);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<TrainingOppList>> call, Throwable t) {
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
                            trainingOppListView();
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

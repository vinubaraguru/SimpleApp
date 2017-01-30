package com.vinu.epoise.ePoiseRecruiter.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.OrgListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.controller.APIRestManager;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.OrganizationList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

/**
 * Created by ePoise on 12/14/2016.
 */

public class OrganizationListActivity extends AppCompatActivity {

    private ArrayList<OrganizationList> mOrganizationListArrayList = new ArrayList<>();

    private APIRestManager apiRestManager;
    private RecyclerView recyclerView;
    private OrgListRecyclerViewAdapter mOrgListRecyclerViewAdapter;
    private ProgressBar mProgressBar;
    private CoordinatorLayout coordinatorLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;

    public static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Select Organisation");

        recyclerView = (RecyclerView) findViewById(R.id.org_list_recycler_view);
        mProgressBar = (ProgressBar) findViewById(R.id.orgList_progressBar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.org_coordinatorlayout);

        textView= (TextView) findViewById(R.id.swipe_text_org_list);
        textView.setVisibility(TextView.INVISIBLE);

//        mOrgListRecyclerViewAdapter = new OrgListRecyclerViewAdapter(this.getApplicationContext() , mOrganizationListArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mOrgListRecyclerViewAdapter = new OrgListRecyclerViewAdapter(this);
        recyclerView.setAdapter(mOrgListRecyclerViewAdapter);

        organizationListView();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_orgList_layout);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.pink, R.color.indigo, R.color.lime, R.color.sky_blue, R.color.maroon);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshOrganizationList();
            }
        });
    }
    private void organizationListView() {

        mProgressBar.setVisibility(ProgressBar.VISIBLE);
        if(isNetworkAvailable()){

            apiRestManager =new APIRestManager();
            Call<List<OrganizationList>> organizationListCall = apiRestManager.getRequestInterface().getAllOrganization();
            organizationListCall.enqueue(new Callback<List<OrganizationList>>() {
                @Override
                public void onResponse(Call<List<OrganizationList>> call, Response<List<OrganizationList>> response) {

                    mProgressBar.setVisibility(ProgressBar.INVISIBLE);
                    textView.setVisibility(TextView.INVISIBLE);

                    if(response.isSuccess()){
                        List<OrganizationList> organizationList = response.body();

                        for (int i = 0; i < organizationList.size(); i++) {
                            OrganizationList organization = organizationList.get(i);

                            mOrgListRecyclerViewAdapter.addOrganization(organization);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<OrganizationList>> call, Throwable t) {
                    mProgressBar.setVisibility(ProgressBar.INVISIBLE);
                    textView.setVisibility(TextView.INVISIBLE);

                    AlertDialog.Builder builder = new AlertDialog.Builder(OrganizationListActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("Oops..! Looks like there is some problem, Please try again after sometime");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Toast.makeText(getApplicationContext(),"Thank you",Toast.LENGTH_SHORT).show();
                                }
                            });
                    builder.show();
                }
            });
        }else{
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
            textView.setVisibility(TextView.VISIBLE);

            Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            organizationListView();
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

        ConnectivityManager manager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=manager.getActiveNetworkInfo();
        boolean isAvailable=false;

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;
    }

    //For swipe refresh call
    private void swipeRefreshOrganizationList() {
        if(isNetworkAvailable()){

            apiRestManager =new APIRestManager();
            Call<List<OrganizationList>> organizationListCall = apiRestManager.getRequestInterface().getAllOrganization();
            organizationListCall.enqueue(new Callback<List<OrganizationList>>() {
                @Override
                public void onResponse(Call<List<OrganizationList>> call, Response<List<OrganizationList>> response) {

                    textView.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);
                    if(response.isSuccess()){
                        List<OrganizationList> organizationList = response.body();

                        for (int i = 0; i < organizationList.size(); i++) {
                            OrganizationList organization = organizationList.get(i);

                            mOrgListRecyclerViewAdapter.addOrganization(organization);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<OrganizationList>> call, Throwable t) {

                    textView.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);
                    AlertDialog.Builder builder = new AlertDialog.Builder(OrganizationListActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("Oops..! Looks like there is some problem, Please try again after sometime");
                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Toast.makeText(getApplicationContext(),"Thank you",Toast.LENGTH_SHORT).show();
                                }
                            });
                    builder.show();
                }
            });
        }else{
            swipeRefreshLayout.setRefreshing(false);
            textView.setVisibility(View.VISIBLE);

            Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            organizationListView();
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

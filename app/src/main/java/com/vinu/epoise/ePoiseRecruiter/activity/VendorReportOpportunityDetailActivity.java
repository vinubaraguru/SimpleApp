package com.vinu.epoise.ePoiseRecruiter.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.vinu.epoise.ePoiseRecruiter.adapter.VendorReportOppListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse;
import com.vinu.epoise.ePoiseRecruiter.model.VendorReportOppList;

import java.util.ArrayList;

/**
 * Created by ImVB9 on 12/25/2016.
 */

public class VendorReportOpportunityDetailActivity extends AppCompatActivity {

    private ArrayList<VendorReportOppList> mVendorReportOppListArrayList = new ArrayList<>();

    private VendorReportOppListRecyclerViewAdapter mVendorReportOppListRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_report_opp_wise_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String VendorUserName= bundle.getString("VendorUserName");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(VendorUserName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.vendor_report_opp_wise_detail_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mVendorReportOppListRecyclerViewAdapter = new VendorReportOppListRecyclerViewAdapter(this.getApplicationContext() , mVendorReportOppListArrayList);
        mRecyclerView.setAdapter(mVendorReportOppListRecyclerViewAdapter);

        prepareListData();

    }

    private void prepareListData() {


        VendorReportOppList vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

        vendorReportOppList=new VendorReportOppList("L1 India - Softskill Assessment","120","12","13","16","19");
        mVendorReportOppListArrayList.add(vendorReportOppList);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

package com.vinu.epoise.ePoiseRecruiter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.OrgListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.OrganizationList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class OrganizationListActivity extends AppCompatActivity {

    private ArrayList<OrganizationList> mOrganizationListArrayList = new ArrayList<>();

    private RecyclerView recyclerView;
    private OrgListRecyclerViewAdapter mOrgListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Select Organisation");

        recyclerView = (RecyclerView) findViewById(R.id.org_list_recycler_view);

        mOrgListRecyclerViewAdapter = new OrgListRecyclerViewAdapter(this.getApplicationContext() , mOrganizationListArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mOrgListRecyclerViewAdapter);

        organizationList();

    }
    private void organizationList() {

        OrganizationList organization=new OrganizationList("ePoise systems","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("Career Connect","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("TalentSprint","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("ePoise systems","B2B");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("EXimius","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("Testing","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("ePoise systems","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("ePoise systems","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("ePoise systems","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("ePoise systems","B2C");
        mOrganizationListArrayList.add(organization);

        organization=new OrganizationList("ePoise systems","B2C");
        mOrganizationListArrayList.add(organization);

    }
}

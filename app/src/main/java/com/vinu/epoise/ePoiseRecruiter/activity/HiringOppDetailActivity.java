package com.vinu.epoise.ePoiseRecruiter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.fragment.HiringAppliedCandidatesListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.HiringNotEvaluatedCandidatesListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.HiringPreSelectedCandidatesListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.HiringRejectedCandidatesListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.HiringShortlistedCandidatesListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ePoise on 12/15/2016.
 */

public class HiringOppDetailActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_opp_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String hiringOppTitle= bundle.getString("hiringOppTitle");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(hiringOppTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hiring_opp_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        InviteOppDetailActivity.Adapter adapter = new InviteOppDetailActivity.Adapter(getSupportFragmentManager());
        adapter.addFragment(new HiringAppliedCandidatesListFragment(), "Applied");
        adapter.addFragment(new HiringNotEvaluatedCandidatesListFragment(), "Not Evaluated");
        adapter.addFragment(new HiringShortlistedCandidatesListFragment(), "Shortlisted");
        adapter.addFragment(new HiringPreSelectedCandidatesListFragment(), "Pre Selected");
        adapter.addFragment(new HiringRejectedCandidatesListFragment(), "Rejected");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

package com.vinu.epoise.ePoiseRecruiter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.fragment.DashBoardFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.EvaluatorReportFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.HiringOppListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.InviteListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.ManageUsersListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.MyOrganizationFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.SettingsFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.TrainingOppListFragment;
import com.vinu.epoise.ePoiseRecruiter.fragment.VendorReportFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String orgName= bundle.getString("orgName");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(orgName);

        if (savedInstanceState == null) {
            DashBoardFragment f1 = new DashBoardFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_frame, f1);
            fragmentTransaction.commit();

        }


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            fragment = new DashBoardFragment();
            title = getString(R.string.dash_board);

        } else if (id == R.id.nav_invites) {
            fragment = new InviteListFragment();
            title = getString(R.string.invites);

        } else if (id == R.id.nav_hiring) {
            fragment = new HiringOppListFragment();
            title = getString(R.string.hiring);

        } else if (id == R.id.nav_training) {
            fragment = new TrainingOppListFragment();
            title = getString(R.string.training);

        } else if (id == R.id.nav_my_organization) {
            fragment = new MyOrganizationFragment();
            title = getString(R.string.my_organization);

        } else if (id == R.id.nav_manage_users) {
            fragment = new ManageUsersListFragment();
            title = getString(R.string.manage_users);

        }else if (id == R.id.nav_vendor_report) {
            fragment = new VendorReportFragment();
            title = getString(R.string.vendor_report);

        } else if (id == R.id.nav_evaluators_report) {
            fragment = new EvaluatorReportFragment();
            title = getString(R.string.evaluators_report);

//        } else if (id == R.id.nav_candidates_report) {
//            fragment = new DashBoardFragment();
//            title = getString(R.string.candidiate_report);
//
//        } else if (id == R.id.nav_position_based_report) {
//            fragment = new DashBoardFragment();
//            title = getString(R.string.position_based_report);

        } else if (id == R.id.nav_settings) {

            fragment = new SettingsFragment();
            title = getString(R.string.settings);

        }
//        else if (id == R.id.logout) {
//
//            Intent intent = new Intent(MainActivity.this,SignupActivity.class);
//
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            startActivity(intent);
//        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_frame, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

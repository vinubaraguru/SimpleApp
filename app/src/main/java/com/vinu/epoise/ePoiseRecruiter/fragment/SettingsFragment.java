package com.vinu.epoise.ePoiseRecruiter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.SettingsRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.SettingsList;

import java.util.ArrayList;

/**
 * Created by ePoise on 1/9/2017.
 */

public class SettingsFragment  extends Fragment {

    SettingsRecyclerViewAdapter mSettingsRecyclerAdapter;

    public SettingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.settings_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mSettingsRecyclerAdapter = new SettingsRecyclerViewAdapter(this.getActivity(),settingsView());
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mSettingsRecyclerAdapter);

        return view;

    }

    private ArrayList<SettingsList> settingsView() {

        final ArrayList<SettingsList> settingsLists = new ArrayList<>();

        SettingsList settingsList=new SettingsList("Change Password");
        settingsLists.add(settingsList);

        settingsList=new SettingsList("Feedback");
        settingsLists.add(settingsList);

        settingsList=new SettingsList("Call support");
        settingsLists.add(settingsList);

        settingsList=new SettingsList("Terms and Conditions");
        settingsLists.add(settingsList);

        settingsList=new SettingsList("Privacy Policy");
        settingsLists.add(settingsList);


        return settingsLists;
    }

}

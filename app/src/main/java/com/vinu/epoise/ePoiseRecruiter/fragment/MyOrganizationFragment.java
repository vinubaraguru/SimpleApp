package com.vinu.epoise.ePoiseRecruiter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinu.epoise.ePoiseRecruiter.R;

/**
 * Created by ePoise on 1/9/2017.
 */

public class MyOrganizationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_organization, null);

        return view;
    }
}

package com.vinu.epoise.ePoiseRecruiter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.VendorReportUserListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.model.VendorReportList;

import java.util.ArrayList;

/**
 * Created by ImVB9 on 12/24/2016.
 */

public class VendorReportFragment extends Fragment {

    private VendorReportUserListRecyclerViewAdapter mVendorReportUserListRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vendor_report_list, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.vendor_report_user_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mVendorReportUserListRecyclerViewAdapter = new VendorReportUserListRecyclerViewAdapter(this.getActivity(),trainingOppListView());

//        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mVendorReportUserListRecyclerViewAdapter);

        return view;
    }

    private ArrayList<VendorReportList> trainingOppListView() {

        final ArrayList<VendorReportList> vendorReportListArrayList = new ArrayList<>();

        VendorReportList vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","16","23","78");
        vendorReportListArrayList.add(vendorReportList);

        vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","16","23","78");
        vendorReportListArrayList.add(vendorReportList);

        vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","16","23","78");
        vendorReportListArrayList.add(vendorReportList);

        vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","161","23","78");
        vendorReportListArrayList.add(vendorReportList);

        vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","161","23","78");
        vendorReportListArrayList.add(vendorReportList);

        vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","161","23","78");
        vendorReportListArrayList.add(vendorReportList);

        vendorReportList=new VendorReportList("Vinu","vinu@gmail.com","9880941079","12","13","161","23","78");
        vendorReportListArrayList.add(vendorReportList);

        return vendorReportListArrayList;
    }
}

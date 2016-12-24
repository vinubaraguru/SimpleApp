package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.model.VendorReportOppList;

import java.util.ArrayList;

/**
 * Created by ImVB9 on 12/25/2016.
 */

public class VendorReportOppListRecyclerViewAdapter extends RecyclerView.Adapter<VendorReportOppListRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<VendorReportOppList> mVendorReportOppListArrayList;

    public VendorReportOppListRecyclerViewAdapter(Context context, ArrayList<VendorReportOppList> vendorReportOppListArrayList) {
        mContext = context;
        mVendorReportOppListArrayList = vendorReportOppListArrayList;
    }

    @Override
    public VendorReportOppListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_report_opp_wise_details,null);

        return new VendorReportOppListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VendorReportOppListRecyclerViewAdapter.ViewHolder holder, int position) {

        VendorReportOppList vendorReportOppList=mVendorReportOppListArrayList.get(position);

        holder.vendorOppTitle.setText(vendorReportOppList.getVendorOppTitle());
        holder.vendorOppInvites.setText(vendorReportOppList.getVendorOppInvites());
        holder.vendorOppResponses.setText(vendorReportOppList.getVendorOppResponses());
        holder.vendorOppShortlists.setText(vendorReportOppList.getVendorOppShortlists());
        holder.vendorOppPreselects.setText(vendorReportOppList.getVendorOppPreselects());
        holder.vendorOppRejects.setText(vendorReportOppList.getVendorOppRejects());

    }

    @Override
    public int getItemCount() {
        return mVendorReportOppListArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView vendorOppTitle;
        public final TextView vendorOppInvites;
        public final TextView vendorOppResponses;
        public final TextView vendorOppShortlists;
        public final TextView vendorOppPreselects;
        public final TextView vendorOppRejects;


        public ViewHolder(View itemView) {
            super(itemView);

            vendorOppTitle = (TextView) itemView.findViewById(R.id.vendor_report_opp_title);
            vendorOppInvites = (TextView) itemView.findViewById(R.id.vendor_opp_invite);
            vendorOppResponses = (TextView) itemView.findViewById(R.id.vendor_opp_response);
            vendorOppShortlists = (TextView) itemView.findViewById(R.id.vendor_opp_shortlist);
            vendorOppPreselects = (TextView) itemView.findViewById(R.id.vendor_opp_preslects);
            vendorOppRejects = (TextView) itemView.findViewById(R.id.vendor_opp_rejects);
        }

    }
}

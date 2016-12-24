package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.VendorReportList;

import java.util.ArrayList;

/**
 * Created by ImVB9 on 12/24/2016.
 */

public class VendorReportUserListRecyclerViewAdapter extends RecyclerView.Adapter<VendorReportUserListRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<VendorReportList> mVendorReportListArrayList;

    public VendorReportUserListRecyclerViewAdapter(Context mContext, ArrayList<VendorReportList> mVendorReportListArrayList) {
        this.mContext = mContext;
        this.mVendorReportListArrayList = mVendorReportListArrayList;
    }

    @Override
    public VendorReportUserListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_report_users_list, null);

        return new VendorReportUserListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VendorReportList vendorReportList = mVendorReportListArrayList.get(position);

        holder.vendorUserName.setText(vendorReportList.getVendorUserName());
        holder.vendorUserEmail.setText(vendorReportList.getVendorUserEmail());
        holder.vendorPhoneNumber.setText(vendorReportList.getVendorPhoneNumber());
        holder.vendorTotalInvites.setText(vendorReportList.getVendorTotalInvites());
        holder.vendorTotalResponses.setText(vendorReportList.getVendorTotalResponses());
        holder.vendorTotalShortlists.setText(vendorReportList.getVendorTotalShortlists());
        holder.vendorTotalPreselects.setText(vendorReportList.getVendorTotalPreselects());
        holder.vendorTotalRejects.setText(vendorReportList.getVendorTotalRejects());

//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(View view, int Position) {
//
//                TrainingOppList trainingOppList=mTrainingOppListArrayList.get(Position);
//
//                TrainingOppList selectedTrainingOppList= getSelectedTrainingOppListArrayList(Position);
//
//                Intent intent=new Intent(mContext, TrainingOppDetailActivity.class);
//                intent.putExtra("trainingOppTitle",selectedTrainingOppList.getTrainingOppTitle());
//
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mVendorReportListArrayList.size();
    }

    public VendorReportList getSelectedTrainingOppListArrayList(int position) {
        return mVendorReportListArrayList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView vendorUserName;
        public final TextView vendorUserEmail;
        public final TextView vendorPhoneNumber;
        public final TextView vendorTotalInvites;
        public final TextView vendorTotalResponses;
        public final TextView vendorTotalShortlists;
        public final TextView vendorTotalPreselects;
        public final TextView vendorTotalRejects;


        private ItemClickListener mItemClickListener;


        public ViewHolder(View itemView) {
            super(itemView);

            vendorUserName = (TextView) itemView.findViewById(R.id.vendor_user_name);
            vendorUserEmail = (TextView) itemView.findViewById(R.id.vendor_user_email);
            vendorPhoneNumber = (TextView) itemView.findViewById(R.id.vendor_user_phone);
            vendorTotalInvites = (TextView) itemView.findViewById(R.id.vendor_total_invites);
            vendorTotalResponses = (TextView) itemView.findViewById(R.id.vendor_total_responses);
            vendorTotalShortlists = (TextView) itemView.findViewById(R.id.vendor_total_shortlist);
            vendorTotalPreselects = (TextView) itemView.findViewById(R.id.vendor_total_preselects);
            vendorTotalRejects = (TextView) itemView.findViewById(R.id.vendor_total_rejects);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.mItemClickListener = itemClickListener;
        }
    }
}

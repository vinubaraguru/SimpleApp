package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.activity.HiringCandidateResponseActivity;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.HiringAppliedCandidateList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/15/2016.
 */

public class HiringAppliedCandidateRecyclerViewAdapter extends RecyclerView.Adapter<HiringAppliedCandidateRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<HiringAppliedCandidateList> mHiringAppliedCandidateListArrayList;

    public HiringAppliedCandidateRecyclerViewAdapter(Context mContext, ArrayList<HiringAppliedCandidateList> mHiringAppliedCandidateListArrayList) {
        this.mContext = mContext;
        this.mHiringAppliedCandidateListArrayList = mHiringAppliedCandidateListArrayList;
    }

    @Override
    public HiringAppliedCandidateRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hiring_applied_candidates_list, null);

        return new HiringAppliedCandidateRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HiringAppliedCandidateRecyclerViewAdapter.ViewHolder holder, int position) {

        HiringAppliedCandidateList hiringAppliedCandidateList = mHiringAppliedCandidateListArrayList.get(position);

        holder.appliedCandidateName.setText(hiringAppliedCandidateList.getAppliedCandidateName());
        holder.appliedCandidateEmail.setText(hiringAppliedCandidateList.getAppliedCandidateEmail());

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.messi)
                .into(holder.appliedCandidateImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                HiringAppliedCandidateList hiringAppliedCandidateList = mHiringAppliedCandidateListArrayList.get(Position);

                HiringAppliedCandidateList selectedHiringAppliedCandidateList = getSelectedHiringAppliedCandidateList(Position);

                Toast.makeText(mContext, selectedHiringAppliedCandidateList.getAppliedCandidateName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext,HiringCandidateResponseActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHiringAppliedCandidateListArrayList.size();
    }

    public HiringAppliedCandidateList getSelectedHiringAppliedCandidateList(int position) {
        return mHiringAppliedCandidateListArrayList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView appliedCandidateName;
        public final TextView appliedCandidateEmail;
        public final ImageView appliedCandidateImage;

        private ItemClickListener mItemClickListener;

        public ViewHolder(View view) {
            super(view);

            appliedCandidateName = (TextView) view.findViewById(R.id.applied_cand_name);
            appliedCandidateEmail = (TextView) view.findViewById(R.id.applied_cand_email);
            appliedCandidateImage = (ImageView) view.findViewById(R.id.applied_cand_image);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.mItemClickListener = itemClickListener;
        }


//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContext.getText() + "'";
//        }
    }
}
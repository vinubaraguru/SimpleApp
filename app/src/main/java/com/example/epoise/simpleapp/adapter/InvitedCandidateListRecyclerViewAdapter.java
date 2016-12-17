package com.example.epoise.simpleapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.epoise.simpleapp.R;
import com.example.epoise.simpleapp.helper.ItemClickListener;
import com.example.epoise.simpleapp.model.InvitedCandidateList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InvitedCandidateListRecyclerViewAdapter extends
        RecyclerView.Adapter<InvitedCandidateListRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<InvitedCandidateList> mInvitedCandidateListArrayList;

    public InvitedCandidateListRecyclerViewAdapter(Context context, ArrayList<InvitedCandidateList> invitedCandidateListArrayList) {
        mContext = context;
        mInvitedCandidateListArrayList = invitedCandidateListArrayList;
    }

    @Override
    public InvitedCandidateListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.invited_candidates_list,null);

        return new InvitedCandidateListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InvitedCandidateListRecyclerViewAdapter.ViewHolder holder, final int position) {
        InvitedCandidateList invitedCandidateList = mInvitedCandidateListArrayList.get(position);

        holder.invitedCandidateName.setText(invitedCandidateList.getCandidateName());
        holder.invitedCandidateEmail.setText(invitedCandidateList.getCandidateEmailID());

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.messi)
                .into(holder.invitedCandidateImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                InvitedCandidateList invitedCandidateList=mInvitedCandidateListArrayList.get(Position);

                InvitedCandidateList selectedInvitedCandidateList= getSelectedInvitedCandidateListArrayList(Position);

                Toast.makeText(mContext,invitedCandidateList.getCandidateName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mInvitedCandidateListArrayList.size();
    }


    public InvitedCandidateList getSelectedInvitedCandidateListArrayList(int position) {
        return mInvitedCandidateListArrayList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView invitedCandidateName;
        public final TextView invitedCandidateEmail;
        public final ImageView invitedCandidateImage;

        private ItemClickListener mItemClickListener;

        public ViewHolder(View view) {
            super(view);

            invitedCandidateName = (TextView) view.findViewById(R.id.invited_cand_name);
            invitedCandidateEmail = (TextView) view.findViewById(R.id.invited_cand_email);
            invitedCandidateImage=(ImageView) view.findViewById(R.id.invited_cand_image);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(view,getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.mItemClickListener=itemClickListener;
        }


//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContext.getText() + "'";
//        }
    }
}

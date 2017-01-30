package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.InvitedCandidateList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InvitedCandidateListRecyclerViewAdapter extends
        RecyclerView.Adapter<InvitedCandidateListRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<InvitedCandidateList> mInvitedCandidateListArrayList;

//    public InvitedCandidateListRecyclerViewAdapter(Context context, ArrayList<InvitedCandidateList> invitedCandidateListArrayList) {
//        mContext = context;
//        mInvitedCandidateListArrayList = invitedCandidateListArrayList;
//    }

    public InvitedCandidateListRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mInvitedCandidateListArrayList = new ArrayList<>();
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

//        holder.invitedCandidateName.setText(invitedCandidateList.getCandidateName());
//        holder.invitedCandidateEmail.setText(invitedCandidateList.getCandidateEmailID());

        holder.invitedCandidateName.setText(invitedCandidateList.getLogin());
        holder.invitedCandidateEmail.setText(invitedCandidateList.getType());


        if(invitedCandidateList.getAvatar_url()==null){
            String firstLetter = String.valueOf(invitedCandidateList.getLogin().charAt(0));
            ColorGenerator generator = ColorGenerator.MATERIAL;
            int color = generator.getRandomColor();
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(firstLetter, color); // radius in px

            holder.invitedCandidateImage.setImageDrawable(drawable);

        }else{
            Picasso.with(holder.itemView.getContext())
                    .load(invitedCandidateList.getAvatar_url())
                    .into(holder.invitedCandidateImage);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                InvitedCandidateList invitedCandidateList=mInvitedCandidateListArrayList.get(Position);

                InvitedCandidateList selectedInvitedCandidateList= getSelectedInvitedCandidateListArrayList(Position);

                Toast.makeText(mContext,invitedCandidateList.getLogin(),Toast.LENGTH_SHORT).show();
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

    public void addInvitedCandidate(InvitedCandidateList invitedCandidateList) {
        mInvitedCandidateListArrayList.add(invitedCandidateList);
        notifyDataSetChanged();
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

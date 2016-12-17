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
import com.example.epoise.simpleapp.model.TrainingAppliedCandidateList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/15/2016.
 */

public class TrainingAppliedCandidatesRecyclerViewAdapter extends RecyclerView.Adapter<TrainingAppliedCandidatesRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<TrainingAppliedCandidateList> mTrainingAppliedCandidateList;

    public TrainingAppliedCandidatesRecyclerViewAdapter(Context mContext, ArrayList<TrainingAppliedCandidateList> mTrainingAppliedCandidateList) {
        this.mContext = mContext;
        this.mTrainingAppliedCandidateList = mTrainingAppliedCandidateList;
    }

    @Override
    public TrainingAppliedCandidatesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.training_applied_candidates_list,null);

        return new TrainingAppliedCandidatesRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainingAppliedCandidatesRecyclerViewAdapter.ViewHolder holder, int position) {

        TrainingAppliedCandidateList trainingAppliedCandidateList = mTrainingAppliedCandidateList.get(position);

        holder.trainingCandidateName.setText(trainingAppliedCandidateList.getTrainingCandidateName());
        holder.trainingCandidateEmail.setText(trainingAppliedCandidateList.getTrainingCandidateEmail());

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.messi)
                .into(holder.trainingCandidateImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                TrainingAppliedCandidateList trainingAppliedCandidateList=mTrainingAppliedCandidateList.get(Position);

                TrainingAppliedCandidateList selectedTrainingAppliedCandidateList= getSelectedTrainingAppliedCandidateList(Position);

                Toast.makeText(mContext,selectedTrainingAppliedCandidateList.getTrainingCandidateName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTrainingAppliedCandidateList.size();
    }

    public TrainingAppliedCandidateList getSelectedTrainingAppliedCandidateList(int position) {
        return mTrainingAppliedCandidateList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView trainingCandidateName;
        public final TextView trainingCandidateEmail;
        public final ImageView trainingCandidateImage;

        private ItemClickListener mItemClickListener;

        public ViewHolder(View view) {
            super(view);

            trainingCandidateName = (TextView) view.findViewById(R.id.training_cand_name);
            trainingCandidateEmail = (TextView) view.findViewById(R.id.training_cand_email);
            trainingCandidateImage=(ImageView) view.findViewById(R.id.training_cand_image);

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

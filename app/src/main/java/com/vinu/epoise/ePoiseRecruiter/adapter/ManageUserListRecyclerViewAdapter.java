package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.ManageUsersList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/22/2016.
 */

public class ManageUserListRecyclerViewAdapter extends RecyclerView.Adapter<ManageUserListRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<ManageUsersList> mManageUsersList;

    public ManageUserListRecyclerViewAdapter(Context mContext, ArrayList<ManageUsersList> mManageUsersList) {
        this.mContext = mContext;
        this.mManageUsersList = mManageUsersList;
    }

    @Override
    public ManageUserListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_users_list,null);

        return new ManageUserListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ManageUsersList manageUsersList = mManageUsersList.get(position);

        holder.manageUserDisplayName.setText(manageUsersList.getManageUserDisplayName());
        holder.manageUserEmail.setText(manageUsersList.getManageUserEmail());

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.messi)
                .into(holder.manageUserAvatar);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                ManageUsersList manageUsersList = mManageUsersList.get(Position);

                ManageUsersList selectedManageUsersList= getSelectedManageUsersList(Position);

//                Intent intent=new Intent(mContext, TrainingOppDetailActivity.class);
//                intent.putExtra("trainingOppTitle",selectedTrainingOppList.getTrainingOppTitle());
//
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mManageUsersList.size();
    }

    public ManageUsersList getSelectedManageUsersList(int position) {
        return mManageUsersList.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView manageUserEmail;
        public final TextView manageUserDisplayName;

//        public final TextView manageUserLoginID;
//        public final TextView manageUserContactNo;
//        public final TextView manageUserRole;
//        public final TextView manageUserStatus;

        public final ImageView manageUserAvatar;


        private ItemClickListener mItemClickListener;



        public ViewHolder(View itemView) {
            super(itemView);

            manageUserDisplayName = (TextView) itemView.findViewById(R.id.manage_user_display_name);
            manageUserEmail = (TextView) itemView.findViewById(R.id.manage_user_email);
            manageUserAvatar=(ImageView) itemView.findViewById(R.id.manage_user_avatar);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(view,getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.mItemClickListener=itemClickListener;
        }
    }
}


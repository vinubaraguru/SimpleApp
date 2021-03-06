package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.vinu.epoise.ePoiseRecruiter.R;
//import com.example.epoise.simpleapp.activity.InviteOppDetailActivity;
import com.vinu.epoise.ePoiseRecruiter.activity.InviteOppDetailActivity;
import com.vinu.epoise.ePoiseRecruiter.fragment.InviteListFragment;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.InviteOppList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InviteListRecyclerViewAdapter  extends RecyclerView.Adapter<InviteListRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<InviteOppList> mInviteOppListArrayList;

//    public InviteListRecyclerViewAdapter(Context context, ArrayList<InviteOppList> inviteOppListArrayList) {
//        mContext = context;
//        mInviteOppListArrayList = inviteOppListArrayList;
//    }

//    public InviteListRecyclerViewAdapter(Context mContext) {
//        this.mContext = mContext;
//        mInviteOppListArrayList = new ArrayList<>();
//    }

    public InviteListRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mInviteOppListArrayList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.invite_opp_list,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        InviteOppList inviteOppList=mInviteOppListArrayList.get(position);

//        holder.inviteOppTitle.setText(inviteOppList.getOppTitle());
//        holder.inviteOppPublishedDate.setText(inviteOppList.getOppPublishedDate());

        holder.inviteOppTitle.setText(inviteOppList.getName());
        holder.inviteOppPublishedDate.setText(inviteOppList.getCategory());

        String firstLetter = String.valueOf(inviteOppList.getName().charAt(0));
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstLetter, color); // radius in px

        holder.inviteOppImage.setImageDrawable(drawable);

//        Picasso.with(holder.itemView.getContext())
//                .load(R.drawable.messi)
//                .into(holder.inviteOppImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                InviteOppList inviteOppList=mInviteOppListArrayList.get(Position);

                InviteOppList selectedInviteOppList= getSelectedInviteOppList(Position);

                Intent intent=new Intent(mContext, InviteOppDetailActivity.class);
                intent.putExtra("oppTitle",inviteOppList.getName());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mInviteOppListArrayList.size();
    }

    public InviteOppList getSelectedInviteOppList(int position) {
        return mInviteOppListArrayList.get(position);
    }

    public void addInviteOpp(InviteOppList inviteOppList) {
        mInviteOppListArrayList.add(inviteOppList);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView inviteOppTitle;
        public final TextView inviteOppPublishedDate;
        public final ImageView inviteOppImage;

        private ItemClickListener mItemClickListener;

        public ViewHolder(View view) {
            super(view);

            inviteOppTitle = (TextView) view.findViewById(R.id.opp_title);
            inviteOppPublishedDate = (TextView) view.findViewById(R.id.opp_published_date);
            inviteOppImage=(ImageView) view.findViewById(R.id.opp_image);

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

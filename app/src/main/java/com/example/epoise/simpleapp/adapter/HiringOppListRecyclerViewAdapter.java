package com.example.epoise.simpleapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.epoise.simpleapp.R;
import com.example.epoise.simpleapp.activity.HiringOppDetailActivity;
import com.example.epoise.simpleapp.helper.ItemClickListener;
import com.example.epoise.simpleapp.model.HiringOppList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class HiringOppListRecyclerViewAdapter extends RecyclerView.Adapter<HiringOppListRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<HiringOppList> mHiringOppListArrayList;

    public HiringOppListRecyclerViewAdapter(Context mContext, ArrayList<HiringOppList> mHiringOppListArrayList) {
        this.mContext = mContext;
        this.mHiringOppListArrayList = mHiringOppListArrayList;
    }

    @Override
    public HiringOppListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hiring_opp_list,null);

        return new HiringOppListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HiringOppListRecyclerViewAdapter.ViewHolder holder, int position) {

        HiringOppList hiringOppList = mHiringOppListArrayList.get(position);

        holder.hiringOppName.setText(hiringOppList.getOppTitle());

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.messi)
                .into(holder.hiringOppImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                HiringOppList hiringOppList=mHiringOppListArrayList.get(Position);

                HiringOppList selectedHiringOppList= getSelectedHiringOppListArrayList(Position);

                Intent intent=new Intent(mContext, HiringOppDetailActivity.class);
                intent.putExtra("hiringOppTitle",selectedHiringOppList.getOppTitle());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHiringOppListArrayList.size();
    }

    public HiringOppList getSelectedHiringOppListArrayList(int position) {
        return mHiringOppListArrayList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView hiringOppName;
        public final ImageView hiringOppImage;

        private ItemClickListener mItemClickListener;



        public ViewHolder(View itemView) {
            super(itemView);

            hiringOppName = (TextView) itemView.findViewById(R.id.hiring_opp_name);
            hiringOppImage=(ImageView) itemView.findViewById(R.id.hiring_opp_image);

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

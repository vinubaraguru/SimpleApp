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

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.activity.MainActivity;
import com.vinu.epoise.ePoiseRecruiter.activity.OrganizationListActivity;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.OrganizationList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/14/2016.
 */

public class OrgListRecyclerViewAdapter extends RecyclerView.Adapter<OrgListRecyclerViewAdapter.OrgListViewHolder> {

    private Context mContext;
    private ArrayList<OrganizationList> mOrganizationListArrayList;

    public OrgListRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mOrganizationListArrayList = new ArrayList<>();
    }

//    public OrgListRecyclerViewAdapter(Context context, ArrayList<OrganizationList> organizationListArrayList) {
//        mContext = context;
//        mOrganizationListArrayList = organizationListArrayList;
//    }

    @Override
    public OrgListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.organization_list,null);

        OrgListViewHolder mOrgListViewHolder =new OrgListViewHolder(view);

        return mOrgListViewHolder;
    }

    @Override
    public void onBindViewHolder(OrgListViewHolder holder, int position) {

        OrganizationList organizationList=mOrganizationListArrayList.get(position);

//        holder.orgName.setText(organizationList.getOrgName());
//        holder.orgType.setText(organizationList.getOrgType());

        holder.orgName.setText(organizationList.getName());
        holder.orgType.setText(organizationList.getCategory());

        String firstLetter = String.valueOf(organizationList.getName().charAt(0));
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstLetter, color); // radius in px

        holder.orgImage.setImageDrawable(drawable);

//        Picasso.with(holder.itemView.getContext())
//                .load(R.drawable.messi)
//                .into(holder.orgImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {

                OrganizationList organization= mOrganizationListArrayList.get(Position);

                OrganizationList selectedOrganization= getSelectedOrganization(Position);

                Intent intent=new Intent(mContext, MainActivity.class);
                intent.putExtra("orgName",selectedOrganization.getName());

                Toast.makeText(mContext,selectedOrganization.getName(),Toast.LENGTH_SHORT).show();

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mOrganizationListArrayList.size();
    }

    public OrganizationList getSelectedOrganization(int position) {
        return mOrganizationListArrayList.get(position);
    }

    public void addOrganization(OrganizationList organizationList) {
        mOrganizationListArrayList.add(organizationList);
        notifyDataSetChanged();
    }

    public class OrgListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView orgName, orgType;
        ImageView orgImage;

        private ItemClickListener mItemClickListener;

        public OrgListViewHolder(View itemView) {
            super(itemView);

            orgImage = (ImageView) itemView.findViewById(R.id.org_image);
            orgName = (TextView) itemView.findViewById(R.id.org_name);
            orgType = (TextView) itemView.findViewById(R.id.org_type);

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

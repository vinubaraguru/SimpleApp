package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.ManageUsersList;

import java.util.ArrayList;

import static com.vinu.epoise.ePoiseRecruiter.model.ManageUsersList.ACTIVE_TYPE;
import static com.vinu.epoise.ePoiseRecruiter.model.ManageUsersList.DEACTIVE_TYPE;

/**
 * Created by ePoise on 12/22/2016.
 */

public class ManageUserListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<ManageUsersList> mManageUsersListArrayList;

    public ManageUserListRecyclerViewAdapter(Context context, ArrayList<ManageUsersList> manageUsersListArrayList) {
        mContext = context;
        mManageUsersListArrayList = manageUsersListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        switch (viewType) {

            case ACTIVE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_active_users_list, parent, false);
                return new ActiveResponseViewHolder(view);

            case DEACTIVE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_deactive_user_list, parent, false);
                return new DeActiveResponseViewHolder(view);
        }
        return null;
    }


@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    ManageUsersList manageUsersList = mManageUsersListArrayList.get(position);

    if (manageUsersList != null) {
        switch (manageUsersList.getManageUserResponseType()) {
            case ACTIVE_TYPE:
                ((ActiveResponseViewHolder) holder).manageActiveUserDisplayName.setText(manageUsersList.getManageUserDisplayName());
                ((ActiveResponseViewHolder) holder).manageActiveUserEmail.setText(manageUsersList.getManageUserEmail());
                ((ActiveResponseViewHolder) holder).manageActiveUserStatus.setText(manageUsersList.getManageUserStatus());
                ((ActiveResponseViewHolder) holder).manageActiveUserRole.setText(manageUsersList.getManageUserRole());

                Picasso.with(((ActiveResponseViewHolder) holder).itemView.getContext())
                        .load(R.drawable.messi)
                        .into(((ActiveResponseViewHolder) holder).manageActiveUserAvatar);

                break;

            case DEACTIVE_TYPE:

                ((DeActiveResponseViewHolder) holder).manageDeActiveUserDisplayName.setText(manageUsersList.getManageUserDisplayName());
                ((DeActiveResponseViewHolder) holder).manageDeActiveUserEmail.setText(manageUsersList.getManageUserEmail());
                ((DeActiveResponseViewHolder) holder).manageDeActiveUserStatus.setText(manageUsersList.getManageUserStatus());
                ((DeActiveResponseViewHolder) holder).manageDeActiveUserRole.setText(manageUsersList.getManageUserRole());

                Picasso.with(((DeActiveResponseViewHolder) holder).itemView.getContext())
                        .load(R.drawable.messi)
                        .into(((DeActiveResponseViewHolder) holder).manageDeActiveUserAvatar);

                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if(mManageUsersListArrayList==null)
            return 0;
        return mManageUsersListArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mManageUsersListArrayList != null) {
            ManageUsersList manageUsersList = mManageUsersListArrayList.get(position);
            if (manageUsersList != null) {
                return manageUsersList.getManageUserResponseType();
            }
        }
        return 0;
    }

    public static class ActiveResponseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView manageActiveUserDisplayName;
        private TextView manageActiveUserEmail;
        private TextView manageActiveUserStatus;
        private TextView manageActiveUserRole;
        private ImageView manageActiveUserAvatar;

        private Button manageDeActiveUserButton;

        private ItemClickListener mItemClickListener;


        public ActiveResponseViewHolder(View itemView) {

            super(itemView);
            manageActiveUserDisplayName= (TextView) itemView.findViewById(R.id.manage_active_user_display_name);
            manageActiveUserEmail = (TextView) itemView.findViewById(R.id.manage_active_user_email);
            manageActiveUserStatus= (TextView) itemView.findViewById(R.id.manage_active_user_status);
            manageActiveUserRole = (TextView) itemView.findViewById(R.id.manage_active_user_role);
            manageActiveUserAvatar =(ImageView) itemView.findViewById(R.id.manage_active_user_avatar);

            manageDeActiveUserButton =(Button) itemView.findViewById(R.id.manage_user_deactivate_button);

            manageDeActiveUserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"USER ACTIVATED",Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.mItemClickListener = itemClickListener;
        }
    }

    public static class DeActiveResponseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView manageDeActiveUserDisplayName;
        private TextView manageDeActiveUserEmail;
        private TextView manageDeActiveUserStatus;
        private TextView manageDeActiveUserRole;
        private ImageView manageDeActiveUserAvatar;

        private Button manageActiveUserButton;

         private ItemClickListener mItemClickListener;

        public DeActiveResponseViewHolder(View itemView) {

            super(itemView);
            manageDeActiveUserDisplayName= (TextView) itemView.findViewById(R.id.manage_deactive_user_display_name);
            manageDeActiveUserEmail = (TextView) itemView.findViewById(R.id.manage_deactive_user_email);
            manageDeActiveUserStatus= (TextView) itemView.findViewById(R.id.manage_deactive_user_status);
            manageDeActiveUserRole = (TextView) itemView.findViewById(R.id.manage_deactive_user_role);
            manageDeActiveUserAvatar =(ImageView) itemView.findViewById(R.id.manage_deactive_user_avatar);

            manageActiveUserButton =(Button) itemView.findViewById(R.id.manage_user_activate_button);

            manageActiveUserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"USER DEACTIVATED",Toast.LENGTH_SHORT).show();
                }
            });

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

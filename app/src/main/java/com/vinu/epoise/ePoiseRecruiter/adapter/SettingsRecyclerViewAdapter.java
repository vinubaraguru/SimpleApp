package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.activity.ChangePasswordActivity;
import com.vinu.epoise.ePoiseRecruiter.activity.WebviewActivity;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.SettingsList;

import java.util.ArrayList;

/**
 * Created by ePoise on 1/9/2017.
 */

public class SettingsRecyclerViewAdapter extends RecyclerView.Adapter<SettingsRecyclerViewAdapter.SettingsViewHolder> {

    Context mContext;
    ArrayList<SettingsList> mSettingsListArrayList;

    public SettingsRecyclerViewAdapter(Context context, ArrayList<SettingsList> settingsListArrayList) {
        mContext = context;
        mSettingsListArrayList = settingsListArrayList;
    }

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_list,null);

        SettingsViewHolder settingsViewHolder =new SettingsViewHolder(view);

        return settingsViewHolder;
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, final int position) {

        SettingsList settingsList=mSettingsListArrayList.get(position);

        holder.settingsTitle.setText(settingsList.getSettingsTitle());

        Picasso.with(holder.itemView.getContext())
                .load(R.drawable.ic_email)
                .into(holder.settingsImage);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {
                SettingsList settingsList = mSettingsListArrayList.get(Position);

                SettingsList selectedSettingsList = getSelectedSettingsList(Position);
                if (Position == 0) {

                    Intent intent = new Intent(mContext, ChangePasswordActivity.class);
                    mContext.startActivity(intent);

                } else if (Position == 1) {

                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setType("plain/text");
                    sendIntent.setData(Uri.parse("support@skyore.com"));
                    sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@skyore.com"});
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Feed back for skyore app");

                    sendIntent.putExtra(Intent.EXTRA_TEXT, getDeviceDetails());
                    mContext.startActivity(sendIntent);
                } else if (Position == 2) {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:9880941079"));

                    if (ActivityCompat.checkSelfPermission(mContext,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    mContext.startActivity(callIntent);
                }
                else if (Position == 3) {

                    Intent intent = new Intent(mContext, WebviewActivity.class);
                    intent.putExtra("pageTitle","Terms and Conditions");
                    intent.putExtra("pageUrl","https://developer.android.com/reference/android/webkit/WebView.html");
                    mContext.startActivity(intent);

                } else if (Position == 4) {

                    Intent intent = new Intent(mContext, WebviewActivity.class);
                    intent.putExtra("pageTitle","Privacy Policy");
                    intent.putExtra("pageUrl","https://developer.android.com/guide/webapps/webview.html");
                    mContext.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSettingsListArrayList.size();
    }

    public SettingsList getSelectedSettingsList(int position) {
        return mSettingsListArrayList.get(position);
    }

    private String getDeviceDetails(){
        String deviceName = Build.MODEL;
        String deviceMan = Build.MANUFACTURER;
        String deviceOsVersion = android.os.Build.VERSION.RELEASE;


        return  "\n"+
                "\n"+
                "\n"+
                "\n"+
                "\n"+
                "Device Name: "+deviceMan + "\n"+
                "Device Model: "+deviceName+"\n"+
                "Device OS version: "+deviceOsVersion+"\n";
    }


    public class SettingsViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView settingsTitle;
        ImageView settingsImage;

        private ItemClickListener mItemClickListener;

        public SettingsViewHolder(View itemView) {
            super(itemView);

            settingsTitle=(TextView)itemView.findViewById(R.id.settings_row_title);
            settingsImage=(ImageView) itemView.findViewById(R.id.settings_row_icon);

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

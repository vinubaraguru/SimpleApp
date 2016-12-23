package com.vinu.epoise.ePoiseRecruiter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.ManageUserListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.adapter.TrainingOppListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.helper.DividerItemDecoration;
import com.vinu.epoise.ePoiseRecruiter.model.ManageUsersList;
import com.vinu.epoise.ePoiseRecruiter.model.TrainingOppList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/22/2016.
 */

public class ManageUsersListFragment extends Fragment {

    private ManageUserListRecyclerViewAdapter mManageUserListRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_manage_users_list, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.manage_users_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mManageUserListRecyclerViewAdapter = new ManageUserListRecyclerViewAdapter(this.getActivity(),manageUserListView());

//        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mManageUserListRecyclerViewAdapter);

        return view;
    }

    private ArrayList<ManageUsersList> manageUserListView() {

        final ArrayList<ManageUsersList> manageUsersListArrayList = new ArrayList<>();

        ManageUsersList manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.ACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","Active");
        manageUsersListArrayList.add(manageUsersList);

        manageUsersList=new ManageUsersList(ManageUsersList.DEACTIVE_TYPE,"vinu@epoise.com","vinu@epoise.com","Vinu Baraguru","9880941079","OrgAdmin","DeActive");
        manageUsersListArrayList.add(manageUsersList);

        return manageUsersListArrayList;
    }
}


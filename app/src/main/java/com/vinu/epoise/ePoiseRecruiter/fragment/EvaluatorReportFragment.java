package com.vinu.epoise.ePoiseRecruiter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.adapter.EvaluatorReportOppListRecyclerViewAdapter;
import com.vinu.epoise.ePoiseRecruiter.model.EvaluatorReportList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/27/2016.
 */

public class EvaluatorReportFragment extends Fragment {

    private EvaluatorReportOppListRecyclerViewAdapter mEvaluatorReportOppListRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_evaluator_report_list, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.evaluator_report_user_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mEvaluatorReportOppListRecyclerViewAdapter = new EvaluatorReportOppListRecyclerViewAdapter(this.getActivity(),evaluatorReportOppListView());
        recyclerView.setAdapter(mEvaluatorReportOppListRecyclerViewAdapter);

        return view;
    }

    private ArrayList<EvaluatorReportList> evaluatorReportOppListView() {

        final ArrayList<EvaluatorReportList> evaluatorReportListArrayList = new ArrayList<>();

        EvaluatorReportList evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","112","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","123","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","11","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","16","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","12","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","56","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","67","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);

        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","45","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);


        evaluatorReportList=new EvaluatorReportList("Vinu","vinu@gmail.com","90","12","13","161","23","78");
        evaluatorReportListArrayList.add(evaluatorReportList);


        return evaluatorReportListArrayList;
    }
}


package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.model.EvaluatorReportList;

import java.util.ArrayList;

/**
 * Created by ePoise on 12/27/2016.
 */

public class EvaluatorReportOppListRecyclerViewAdapter extends RecyclerView.Adapter<EvaluatorReportOppListRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<EvaluatorReportList> mEvaluatorReportListArrayList;

    public EvaluatorReportOppListRecyclerViewAdapter(Context mContext, ArrayList<EvaluatorReportList> mEvaluatorReportListArrayList) {
        this.mContext = mContext;
        this.mEvaluatorReportListArrayList = mEvaluatorReportListArrayList;
    }

    @Override
    public EvaluatorReportOppListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluators_report_list,null);

            return new EvaluatorReportOppListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EvaluatorReportOppListRecyclerViewAdapter.ViewHolder holder, int position) {

        EvaluatorReportList evaluatorReportList = mEvaluatorReportListArrayList.get(position);

            holder.evaluatorUserName.setText(evaluatorReportList.getEvaluatorUserName());
            holder.evaluatorUserEmail.setText(evaluatorReportList.getEvaluatorUserEmail());
            holder.evaluatorTotalReceived.setText(evaluatorReportList.getEvaluatorTotalReceived());
            holder.evaluatorTotalEvaluated.setText(evaluatorReportList.getEvaluatorTotalEvaluated());
            holder.evaluatorTotalPending.setText(evaluatorReportList.getEvaluatorTotalPending());
            holder.evaluatorTotalShortlists.setText(evaluatorReportList.getEvaluatorTotalShortlists());
            holder.evaluatorTotalPreselects.setText(evaluatorReportList.getEvaluatorTotalPreselects());
            holder.evaluatorTotalRejects.setText(evaluatorReportList.getEvaluatorTotalRejects());
    }

    @Override
    public int getItemCount() {
            return mEvaluatorReportListArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView evaluatorUserName;
        public final TextView evaluatorUserEmail;
        public final TextView evaluatorTotalReceived;
        public final TextView evaluatorTotalEvaluated;
        public final TextView evaluatorTotalPending;
        public final TextView evaluatorTotalShortlists;
        public final TextView evaluatorTotalPreselects;
        public final TextView evaluatorTotalRejects;


        public ViewHolder(View itemView) {
            super(itemView);

            evaluatorUserName = (TextView) itemView.findViewById(R.id.evaluator_user_name);
            evaluatorUserEmail = (TextView) itemView.findViewById(R.id.evaluator_email);
            evaluatorTotalReceived = (TextView) itemView.findViewById(R.id.evaluator_report_total_received);
            evaluatorTotalEvaluated = (TextView) itemView.findViewById(R.id.evaluator_report_total_evaluated);
            evaluatorTotalPending = (TextView) itemView.findViewById(R.id.evaluator_report_total_pending);
            evaluatorTotalShortlists = (TextView) itemView.findViewById(R.id.evaluator_report_total_shortlist);
            evaluatorTotalPreselects = (TextView) itemView.findViewById(R.id.evaluator_report_total_preselect);
            evaluatorTotalRejects = (TextView) itemView.findViewById(R.id.evaluator_report_total_reject);
        }

    }
}

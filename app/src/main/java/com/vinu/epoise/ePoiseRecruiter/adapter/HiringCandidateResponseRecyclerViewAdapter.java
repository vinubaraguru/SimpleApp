package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.activity.VideoStreamingActivity;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse;

import java.util.ArrayList;

import static com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse.MULTI_TYPE;
import static com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse.SINGLE_TYPE;
import static com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse.VIDEO_TYPE;

/**
 * Created by ImVB9 on 12/18/2016.
 */

public class HiringCandidateResponseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<HiringCandidateResponse> mHiringCandidateResponseArrayList;
    private static final int buttons=3;

    public HiringCandidateResponseRecyclerViewAdapter(Context context, ArrayList<HiringCandidateResponse> hiringCandidateResponseArrayList) {
        mContext = context;
        mHiringCandidateResponseArrayList = hiringCandidateResponseArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {

            case VIDEO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_response_list, parent, false);
                return new VideoResponseViewHolder(view);

            case SINGLE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_choice_response_list, parent, false);
                return new SingleChoiceResponseViewHolder(view);

            case MULTI_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multiple_choice_response_list, parent, false);
                return new SingleChoiceResponseViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        HiringCandidateResponse hiringCandidateResponse = mHiringCandidateResponseArrayList.get(position);

        if (hiringCandidateResponse != null) {
            switch (hiringCandidateResponse.getResponseType()) {
                case VIDEO_TYPE:
                    ((VideoResponseViewHolder) holder).videoTypeQuestionNo.setText("Question 1 of 1");
                    ((VideoResponseViewHolder) holder).videoTypeQuestionName.setText(hiringCandidateResponse.getQuestionName());

                    Picasso.with(((VideoResponseViewHolder) holder).itemView.getContext())
                            .load(R.drawable.videoplaybutton)
                            .into(((VideoResponseViewHolder) holder).videoTypeImageView);

                    ((VideoResponseViewHolder) holder).setItemClickListener(new ItemClickListener() {
                        @Override
                        public void onItemClick(View view, int Position) {

                            HiringCandidateResponse hiringCandidateResponse = mHiringCandidateResponseArrayList.get(Position);

                            HiringCandidateResponse selectedVideoResponse = getSelectedVideoResponse(Position);

//                            Toast.makeText(mContext, selectedVideoResponse.getQuestionUrl(), Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(mContext, VideoStreamingActivity.class);
                            intent.putExtra("selectedVideoResponseUrl",selectedVideoResponse.getQuestionUrl());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);
                        }
                    });

                    break;
                case SINGLE_TYPE:
                    ((SingleChoiceResponseViewHolder) holder).singleTypeQuestionNo.setText("Question 1 of 1");
                    ((SingleChoiceResponseViewHolder) holder).singleTypeQuestionName.setText(hiringCandidateResponse.getQuestionName());


                    for (int i = 1; i <= buttons ; i++) {
                        RadioButton rbn = new RadioButton(mContext.getApplicationContext());
                        rbn.setId(1 + 1000);
                        rbn.setText("RadioButton" + i);
                        rbn.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
                        ((SingleChoiceResponseViewHolder) holder).singleTypeQuestionOptions.addView(rbn);

                    }

                    break;

                case MULTI_TYPE:
                    ((MultipleChoiceResponseViewHolder) holder).multiTypeQuestionNo.setText("Question 1 of 1");
                    ((MultipleChoiceResponseViewHolder) holder).multiTypeQuestionName.setText(hiringCandidateResponse.getQuestionName());
                    break;

            }
        }

    }

    public HiringCandidateResponse getSelectedVideoResponse(int position) {
        return mHiringCandidateResponseArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        if(mHiringCandidateResponseArrayList==null)
            return 0;
        return mHiringCandidateResponseArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mHiringCandidateResponseArrayList != null) {
            HiringCandidateResponse hiringCandidateResponse = mHiringCandidateResponseArrayList.get(position);
            if (hiringCandidateResponse != null) {
                return hiringCandidateResponse.getResponseType();
            }
        }
        return 0;
    }

    public static class VideoResponseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView videoTypeQuestionNo;
        private TextView videoTypeQuestionName;
        private ImageView videoTypeImageView;

        private ItemClickListener mItemClickListener;



        public VideoResponseViewHolder(View itemView) {
            super(itemView);
            videoTypeQuestionNo= (TextView) itemView.findViewById(R.id.video_question_no);
            videoTypeQuestionName = (TextView) itemView.findViewById(R.id.video_question_description);
            videoTypeImageView =(ImageView) itemView.findViewById(R.id.video_question_video_image);

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

    public static class SingleChoiceResponseViewHolder extends RecyclerView.ViewHolder {

        private TextView singleTypeQuestionNo;
        private TextView singleTypeQuestionName;
        private RadioGroup singleTypeQuestionOptions;

        public SingleChoiceResponseViewHolder(View itemView) {
            super(itemView);
            singleTypeQuestionNo = (TextView) itemView.findViewById(R.id.single_choice_question_no);
            singleTypeQuestionName = (TextView) itemView.findViewById(R.id.single_choice_question_description);
            singleTypeQuestionOptions = (RadioGroup) itemView.findViewById(R.id.radioGroup);

        }
    }

    public static class MultipleChoiceResponseViewHolder extends RecyclerView.ViewHolder {

        private TextView multiTypeQuestionNo;
        private TextView multiTypeQuestionName;

        public MultipleChoiceResponseViewHolder(View itemView) {
            super(itemView);

            multiTypeQuestionNo = (TextView) itemView.findViewById(R.id.multiple_choice_question_no);
            multiTypeQuestionName = (TextView) itemView.findViewById(R.id.multiple_choice_question_description);

        }
    }
}

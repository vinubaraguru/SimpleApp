package com.vinu.epoise.ePoiseRecruiter.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vinu.epoise.ePoiseRecruiter.R;
import com.vinu.epoise.ePoiseRecruiter.activity.VideoStreamingActivity;
import com.vinu.epoise.ePoiseRecruiter.helper.ItemClickListener;
import com.vinu.epoise.ePoiseRecruiter.model.HiringCandidateResponse;
import com.vinu.epoise.ePoiseRecruiter.model.TrainingCandidateResponse;

import java.util.ArrayList;

import static com.vinu.epoise.ePoiseRecruiter.model.TrainingCandidateResponse.TRAINING_MULTI_TYPE;
import static com.vinu.epoise.ePoiseRecruiter.model.TrainingCandidateResponse.TRAINING_SINGLE_TYPE;
import static com.vinu.epoise.ePoiseRecruiter.model.TrainingCandidateResponse.TRAINING_VIDEO_TYPE;

/**
 * Created by ImVB9 on 12/21/2016.
 */

public class TrainingCandidateResponseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<TrainingCandidateResponse> mTrainingCandidateResponseArrayList;
    private static final int buttons=3;

    public TrainingCandidateResponseRecyclerViewAdapter(Context mContext, ArrayList<TrainingCandidateResponse> mTrainingCandidateResponseArrayList) {
        this.mContext = mContext;
        this.mTrainingCandidateResponseArrayList = mTrainingCandidateResponseArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {

            case TRAINING_VIDEO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_video_response_list, parent, false);
                return new TrainingVideoResponseViewHolder(view);

            case TRAINING_SINGLE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_single_choice_response_list, parent, false);
                return new TrainingSingleChoiceResponseViewHolder(view);

            case TRAINING_MULTI_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_multiple_choice_response_list, parent, false);
                return new TrainingMultipleChoiceResponseViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TrainingCandidateResponse trainingCandidateResponse = mTrainingCandidateResponseArrayList.get(position);

        if (trainingCandidateResponse != null) {
            switch (trainingCandidateResponse.getTrainingResponseType()) {
                case TRAINING_VIDEO_TYPE:
                    ((TrainingVideoResponseViewHolder) holder).videoTypeQuestionNo.setText("Question 1 of 1");
                    ((TrainingVideoResponseViewHolder) holder).videoTypeQuestionName.setText(trainingCandidateResponse.getTrainingQuestionName());

                    Picasso.with(((TrainingVideoResponseViewHolder) holder).itemView.getContext())
                            .load(R.drawable.videoplaybutton)
                            .into(((TrainingVideoResponseViewHolder) holder).videoTypeImageView);

                    ((TrainingVideoResponseViewHolder) holder).setItemClickListener(new ItemClickListener() {
                        @Override
                        public void onItemClick(View view, int Position) {

                            TrainingCandidateResponse trainingCandidateResponse = mTrainingCandidateResponseArrayList.get(Position);

                            TrainingCandidateResponse selectedVideoResponse = getSelectedVideoResponse(Position);

//                            Toast.makeText(mContext, selectedVideoResponse.getQuestionUrl(), Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(mContext, VideoStreamingActivity.class);
                            intent.putExtra("selectedVideoResponseUrl",selectedVideoResponse.getTrainingQuestionUrl());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);
                        }
                    });

                    break;
                case TRAINING_SINGLE_TYPE:
                    ((TrainingSingleChoiceResponseViewHolder) holder).singleTypeQuestionNo.setText("Question 1 of 1");
                    ((TrainingSingleChoiceResponseViewHolder) holder).singleTypeQuestionName.setText(trainingCandidateResponse.getTrainingQuestionName());


                    for (int i = 1; i <= buttons ; i++) {
                        RadioButton rbn = new RadioButton(mContext.getApplicationContext());
                        rbn.setId(1 + 1000);
                        rbn.setText("RadioButton" + i);
//                        rbn.setBackgroundColor(Color.BLUE);
                        rbn.setButtonDrawable(R.drawable.ic_radio_button_checked);
                        rbn.setTextColor(Color.RED);
                        rbn.setHighlightColor(Color.GREEN);
                        ((TrainingSingleChoiceResponseViewHolder) holder).singleTypeQuestionOptions.addView(rbn);

                    }

                    break;

                case TRAINING_MULTI_TYPE:
                    ((TrainingMultipleChoiceResponseViewHolder) holder).multiTypeQuestionNo.setText("Question 1 of 1");
                    ((TrainingMultipleChoiceResponseViewHolder) holder).multiTypeQuestionName.setText(trainingCandidateResponse.getTrainingQuestionName());

                    for(int i=0;i<3;i++){

                        CheckBox checkBox = new CheckBox(mContext.getApplicationContext());
                        checkBox.setText("Checkbox");
//                        checkBox.setBackgroundColor(Color.BLUE);
                        checkBox.setButtonDrawable(R.drawable.ic_check_box_unchecked);
                        checkBox.setTextColor(Color.RED);
                        checkBox.setHighlightColor(Color.GREEN);
                        ((TrainingMultipleChoiceResponseViewHolder) holder).multiTypeOptionLayout.addView(checkBox);

                    }
                    break;

            }
        }

    }


    public TrainingCandidateResponse getSelectedVideoResponse(int position) {
        return mTrainingCandidateResponseArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        if(mTrainingCandidateResponseArrayList==null)
            return 0;
        return mTrainingCandidateResponseArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mTrainingCandidateResponseArrayList != null) {
            TrainingCandidateResponse trainingCandidateResponse = mTrainingCandidateResponseArrayList.get(position);
            if (trainingCandidateResponse != null) {
                return trainingCandidateResponse.getTrainingResponseType();
            }
        }
        return 0;
    }

    public static class TrainingVideoResponseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView videoTypeQuestionNo;
        private TextView videoTypeQuestionName;
        private ImageView videoTypeImageView;

        private ItemClickListener mItemClickListener;



        public TrainingVideoResponseViewHolder(View itemView) {
            super(itemView);
            videoTypeQuestionNo= (TextView) itemView.findViewById(R.id.training_video_question_no);
            videoTypeQuestionName = (TextView) itemView.findViewById(R.id.training_video_question_description);
            videoTypeImageView =(ImageView) itemView.findViewById(R.id.training_video_question_video_image);

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

    public static class TrainingSingleChoiceResponseViewHolder extends RecyclerView.ViewHolder {

        private TextView singleTypeQuestionNo;
        private TextView singleTypeQuestionName;
        private RadioGroup singleTypeQuestionOptions;

        public TrainingSingleChoiceResponseViewHolder(View itemView) {
            super(itemView);
            singleTypeQuestionNo = (TextView) itemView.findViewById(R.id.training_single_choice_question_no);
            singleTypeQuestionName = (TextView) itemView.findViewById(R.id.training_single_choice_question_description);
            singleTypeQuestionOptions = (RadioGroup) itemView.findViewById(R.id.training_radio_group);

        }
    }

    public static class TrainingMultipleChoiceResponseViewHolder extends RecyclerView.ViewHolder {

        private TextView multiTypeQuestionNo;
        private TextView multiTypeQuestionName;
        private LinearLayout multiTypeOptionLayout;

        public TrainingMultipleChoiceResponseViewHolder(View itemView) {
            super(itemView);

            multiTypeQuestionNo = (TextView) itemView.findViewById(R.id.training_multiple_choice_question_no);
            multiTypeQuestionName = (TextView) itemView.findViewById(R.id.training_multiple_choice_question_description);
            multiTypeOptionLayout= (LinearLayout) itemView.findViewById(R.id.training_multiple_choice_options_layout);

        }
    }
}


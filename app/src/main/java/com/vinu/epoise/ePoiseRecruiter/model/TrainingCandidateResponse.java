package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ImVB9 on 12/21/2016.
 */

public class TrainingCandidateResponse implements Serializable {

    public static final int TRAINING_VIDEO_TYPE = 0;
    public static final int TRAINING_SINGLE_TYPE = 1;
    public static final int TRAINING_MULTI_TYPE = 2;
    public static final int TRAINING_WRITTEN_TYPE = 3;


    private int trainingResponseType;
    private String trainingQuestionName;
    private String trainingQuestionUrl;

    public TrainingCandidateResponse(int trainingResponseType, String trainingQuestionName, String trainingQuestionUrl) {
        this.trainingResponseType = trainingResponseType;
        this.trainingQuestionName = trainingQuestionName;
        this.trainingQuestionUrl = trainingQuestionUrl;
    }

    public int getTrainingResponseType() {
        return trainingResponseType;
    }

    public void setTrainingResponseType(int trainingResponseType) {
        this.trainingResponseType = trainingResponseType;
    }

    public String getTrainingQuestionName() {
        return trainingQuestionName;
    }

    public void setTrainingQuestionName(String trainingQuestionName) {
        this.trainingQuestionName = trainingQuestionName;
    }

    public String getTrainingQuestionUrl() {
        return trainingQuestionUrl;
    }

    public void setTrainingQuestionUrl(String trainingQuestionUrl) {
        this.trainingQuestionUrl = trainingQuestionUrl;
    }
}
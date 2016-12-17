package com.example.epoise.simpleapp.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/15/2016.
 */

public class TrainingAppliedCandidateList implements Serializable {

    private String trainingCandidateName;
    private String trainingCandidateEmail;
    private String trainingCandidateImage;

    public TrainingAppliedCandidateList(String trainingCandidateName, String trainingCandidateEmail) {
        this.trainingCandidateName = trainingCandidateName;
        this.trainingCandidateEmail = trainingCandidateEmail;
    }

    public String getTrainingCandidateName() {
        return trainingCandidateName;
    }

    public void setTrainingCandidateName(String trainingCandidateName) {
        this.trainingCandidateName = trainingCandidateName;
    }

    public String getTrainingCandidateEmail() {
        return trainingCandidateEmail;
    }

    public void setTrainingCandidateEmail(String trainingCandidateEmail) {
        this.trainingCandidateEmail = trainingCandidateEmail;
    }

    public String getTrainingCandidateImage() {
        return trainingCandidateImage;
    }

    public void setTrainingCandidateImage(String trainingCandidateImage) {
        this.trainingCandidateImage = trainingCandidateImage;
    }
}

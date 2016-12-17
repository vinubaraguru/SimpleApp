package com.example.epoise.simpleapp.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/15/2016.
 */

public class TrainingOppList implements Serializable {

    private String trainingOppImage;
    private String trainingOppTitle;

    public TrainingOppList(String trainingOppTitle) {
        this.trainingOppTitle = trainingOppTitle;
    }

    public String getTrainingOppImage() {
        return trainingOppImage;
    }

    public void setTrainingOppImage(String trainingOppImage) {
        this.trainingOppImage = trainingOppImage;
    }

    public String getTrainingOppTitle() {
        return trainingOppTitle;
    }

    public void setTrainingOppTitle(String trainingOppTitle) {
        this.trainingOppTitle = trainingOppTitle;
    }
}
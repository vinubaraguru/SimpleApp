package com.example.epoise.simpleapp.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/15/2016.
 */

public class HiringAppliedCandidateList implements Serializable {

    private String appliedCandidateName;
    private String appliedCandidateEmail;
    private String appliedCandidateImage;

    public HiringAppliedCandidateList(String appliedCandidateName, String appliedCandidateEmail) {
        this.appliedCandidateName = appliedCandidateName;
        this.appliedCandidateEmail = appliedCandidateEmail;
    }

    public String getAppliedCandidateName() {
        return appliedCandidateName;
    }

    public void setAppliedCandidateName(String appliedCandidateName) {
        this.appliedCandidateName = appliedCandidateName;
    }

    public String getAppliedCandidateEmail() {
        return appliedCandidateEmail;
    }

    public void setAppliedCandidateEmail(String appliedCandidateEmail) {
        this.appliedCandidateEmail = appliedCandidateEmail;
    }

    public String getAppliedCandidateImage() {
        return appliedCandidateImage;
    }

    public void setAppliedCandidateImage(String appliedCandidateImage) {
        this.appliedCandidateImage = appliedCandidateImage;
    }
}

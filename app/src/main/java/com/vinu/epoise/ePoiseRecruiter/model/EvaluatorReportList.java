package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/27/2016.
 */

public class EvaluatorReportList implements Serializable {

    private String evaluatorUserName;
    private String evaluatorUserEmail;
    private String evaluatorTotalReceived;
    private String evaluatorTotalEvaluated;
    private String evaluatorTotalPending;
    private String evaluatorTotalShortlists;
    private String evaluatorTotalPreselects;
    private String evaluatorTotalRejects;

    public EvaluatorReportList(String evaluatorUserName, String evaluatorUserEmail, String evaluatorTotalReceived, String evaluatorTotalEvaluated, String evaluatorTotalPending, String evaluatorTotalShortlists, String evaluatorTotalPreselects, String evaluatorTotalRejects) {
        this.evaluatorUserName = evaluatorUserName;
        this.evaluatorUserEmail = evaluatorUserEmail;
        this.evaluatorTotalReceived = evaluatorTotalReceived;
        this.evaluatorTotalEvaluated = evaluatorTotalEvaluated;
        this.evaluatorTotalPending = evaluatorTotalPending;
        this.evaluatorTotalShortlists = evaluatorTotalShortlists;
        this.evaluatorTotalPreselects = evaluatorTotalPreselects;
        this.evaluatorTotalRejects = evaluatorTotalRejects;
    }

    public String getEvaluatorUserName() {
        return evaluatorUserName;
    }

    public void setEvaluatorUserName(String evaluatorUserName) {
        this.evaluatorUserName = evaluatorUserName;
    }

    public String getEvaluatorUserEmail() {
        return evaluatorUserEmail;
    }

    public void setEvaluatorUserEmail(String evaluatorUserEmail) {
        this.evaluatorUserEmail = evaluatorUserEmail;
    }

    public String getEvaluatorTotalReceived() {
        return evaluatorTotalReceived;
    }

    public void setEvaluatorTotalReceived(String evaluatorTotalReceived) {
        this.evaluatorTotalReceived = evaluatorTotalReceived;
    }

    public String getEvaluatorTotalEvaluated() {
        return evaluatorTotalEvaluated;
    }

    public void setEvaluatorTotalEvaluated(String evaluatorTotalEvaluated) {
        this.evaluatorTotalEvaluated = evaluatorTotalEvaluated;
    }

    public String getEvaluatorTotalPending() {
        return evaluatorTotalPending;
    }

    public void setEvaluatorTotalPending(String evaluatorTotalPending) {
        this.evaluatorTotalPending = evaluatorTotalPending;
    }

    public String getEvaluatorTotalShortlists() {
        return evaluatorTotalShortlists;
    }

    public void setEvaluatorTotalShortlists(String evaluatorTotalShortlists) {
        this.evaluatorTotalShortlists = evaluatorTotalShortlists;
    }

    public String getEvaluatorTotalPreselects() {
        return evaluatorTotalPreselects;
    }

    public void setEvaluatorTotalPreselects(String evaluatorTotalPreselects) {
        this.evaluatorTotalPreselects = evaluatorTotalPreselects;
    }

    public String getEvaluatorTotalRejects() {
        return evaluatorTotalRejects;
    }

    public void setEvaluatorTotalRejects(String evaluatorTotalRejects) {
        this.evaluatorTotalRejects = evaluatorTotalRejects;
    }
}

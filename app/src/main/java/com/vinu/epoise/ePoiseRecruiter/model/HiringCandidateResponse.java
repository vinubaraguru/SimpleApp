package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ImVB9 on 12/18/2016.
 */

public class HiringCandidateResponse implements Serializable {

    public static final int VIDEO_TYPE = 0;
    public static final int SINGLE_TYPE = 1;
    public static final int MULTI_TYPE = 2;
    public static final int WRITTEN_TYPE = 3;


    private int responseType;
    private String questionName;
    private String questionUrl;

    public HiringCandidateResponse(int responseType, String questionName, String questionUrl) {
        this.responseType = responseType;
        this.questionName = questionName;
        this.questionUrl = questionUrl;
    }

    public int getResponseType() {
        return responseType;
    }

    public void setResponseType(int responseType) {
        this.responseType = responseType;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }
}

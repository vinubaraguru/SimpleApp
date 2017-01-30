package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InvitedCandidateList implements Serializable {

//    private String candidateName;
//    private String candidateEmailID;
//
//    public InvitedCandidateList(String candidateName, String candidateEmailID) {
//        this.candidateName = candidateName;
//        this.candidateEmailID = candidateEmailID;
//    }
//
//    public String getCandidateName() {
//        return candidateName;
//    }
//
//    public void setCandidateName(String candidateName) {
//        this.candidateName = candidateName;
//    }
//
//    public String getCandidateEmailID() {
//        return candidateEmailID;
//    }
//
//    public void setCandidateEmailID(String candidateEmailID) {
//        this.candidateEmailID = candidateEmailID;
//    }

    private String login;
    private String avatar_url;
    private String type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


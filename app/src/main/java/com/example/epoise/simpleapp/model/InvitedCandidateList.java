package com.example.epoise.simpleapp.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InvitedCandidateList implements Serializable {

    private String candidateName;
    private String candidateEmailID;

    public InvitedCandidateList(String candidateName, String candidateEmailID) {
        this.candidateName = candidateName;
        this.candidateEmailID = candidateEmailID;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateEmailID() {
        return candidateEmailID;
    }

    public void setCandidateEmailID(String candidateEmailID) {
        this.candidateEmailID = candidateEmailID;
    }
}


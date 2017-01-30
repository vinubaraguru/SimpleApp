package com.vinu.epoise.ePoiseRecruiter.controller;

import com.vinu.epoise.ePoiseRecruiter.model.HiringAppliedCandidateList;
import com.vinu.epoise.ePoiseRecruiter.model.HiringOppList;
import com.vinu.epoise.ePoiseRecruiter.model.InviteOppList;
import com.vinu.epoise.ePoiseRecruiter.model.InvitedCandidateList;
import com.vinu.epoise.ePoiseRecruiter.model.OrganizationList;
import com.vinu.epoise.ePoiseRecruiter.model.TrainingAppliedCandidateList;
import com.vinu.epoise.ePoiseRecruiter.model.TrainingOppList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ePoise on 1/14/2017.
 */

public interface RequestInterface {

    @GET("feeds/flowers.json")
    Call<List<OrganizationList>> getAllOrganization();

    @GET("feeds/flowers.json")
    Call<List<InviteOppList>> getInviteOppList();

    @GET("users")
    Call<List<InvitedCandidateList>> getInvitedCandidates();

    @GET("feeds/flowers.json")
    Call<List<HiringOppList>> getHiringOppList();

    @GET("/json_data.json")
    Call<HiringAppliedCandidateList> getHiringAppliedCandidates();

    @GET("feeds/flowers.json")
    Call<List<TrainingOppList>> getTrainingOppList();

    @GET("/json_data.json")
    Call<TrainingAppliedCandidateList> getTrainingAppliedCandidates();
}


package com.vinu.epoise.ePoiseRecruiter.controller;

import com.vinu.epoise.ePoiseRecruiter.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ePoise on 1/15/2017.
 */

public class ContactAPIManager {

    private RequestInterface requestInterface;

    public RequestInterface getRequestInterface(){

        if(requestInterface==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.CONTACT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            requestInterface =retrofit.create(RequestInterface.class);
        }
        return requestInterface;
    }
}


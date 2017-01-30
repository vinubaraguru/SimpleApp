package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/14/2016.
 */

public class InviteOppList implements Serializable {

//    private String oppImage;
//    private String oppTitle;
//    private String oppPublishedDate;
//
//    public InviteOppList(String oppTitle, String oppPublishedDate) {
//        this.oppTitle = oppTitle;
//        this.oppPublishedDate = oppPublishedDate;
//    }
//
//    public String getOppImage() {
//        return oppImage;
//    }
//
//    public void setOppImage(String oppImage) {
//        this.oppImage = oppImage;
//    }
//
//    public String getOppTitle() {
//        return oppTitle;
//    }
//
//    public void setOppTitle(String oppTitle) {
//        this.oppTitle = oppTitle;
//    }
//
//    public String getOppPublishedDate() {
//        return oppPublishedDate;
//    }
//
//    public void setOppPublishedDate(String oppPublishedDate) {
//        this.oppPublishedDate = oppPublishedDate;
//    }

    private String name;
    private String category;

    public InviteOppList(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

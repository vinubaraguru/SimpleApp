package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/14/2016.
 */

public class  HiringOppList implements Serializable {

//    private String oppImage;
//    private String oppTitle;
//
//    public HiringOppList(String oppTitle) {
//        this.oppTitle = oppTitle;
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


    private String name;
    private String category;

    public HiringOppList(String name, String category) {
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

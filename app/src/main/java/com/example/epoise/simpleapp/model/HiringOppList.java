package com.example.epoise.simpleapp.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/14/2016.
 */

public class  HiringOppList implements Serializable {

    private String oppImage;
    private String oppTitle;

    public HiringOppList(String oppTitle) {
        this.oppTitle = oppTitle;
    }

    public String getOppImage() {
        return oppImage;
    }

    public void setOppImage(String oppImage) {
        this.oppImage = oppImage;
    }

    public String getOppTitle() {
        return oppTitle;
    }

    public void setOppTitle(String oppTitle) {
        this.oppTitle = oppTitle;
    }
}

package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ImVB9 on 12/25/2016.
 */

public class VendorReportOppList implements Serializable {

    private String vendorOppTitle;
    private String vendorOppInvites;
    private String vendorOppResponses;
    private String vendorOppShortlists;
    private String vendorOppPreselects;
    private String vendorOppRejects;

    public VendorReportOppList(String vendorOppTitle, String vendorOppInvites, String vendorOppResponses, String vendorOppShortlists, String vendorOppPreselects, String vendorOppRejects) {
        this.vendorOppTitle = vendorOppTitle;
        this.vendorOppInvites = vendorOppInvites;
        this.vendorOppResponses = vendorOppResponses;
        this.vendorOppShortlists = vendorOppShortlists;
        this.vendorOppPreselects = vendorOppPreselects;
        this.vendorOppRejects = vendorOppRejects;
    }

    public String getVendorOppTitle() {
        return vendorOppTitle;
    }

    public void setVendorOppTitle(String vendorOppTitle) {
        this.vendorOppTitle = vendorOppTitle;
    }

    public String getVendorOppInvites() {
        return vendorOppInvites;
    }

    public void setVendorOppInvites(String vendorOppInvites) {
        this.vendorOppInvites = vendorOppInvites;
    }

    public String getVendorOppResponses() {
        return vendorOppResponses;
    }

    public void setVendorOppResponses(String vendorOppResponses) {
        this.vendorOppResponses = vendorOppResponses;
    }

    public String getVendorOppShortlists() {
        return vendorOppShortlists;
    }

    public void setVendorOppShortlists(String vendorOppShortlists) {
        this.vendorOppShortlists = vendorOppShortlists;
    }

    public String getVendorOppPreselects() {
        return vendorOppPreselects;
    }

    public void setVendorOppPreselects(String vendorOppPreselects) {
        this.vendorOppPreselects = vendorOppPreselects;
    }

    public String getVendorOppRejects() {
        return vendorOppRejects;
    }

    public void setVendorOppRejects(String vendorOppRejects) {
        this.vendorOppRejects = vendorOppRejects;
    }
}

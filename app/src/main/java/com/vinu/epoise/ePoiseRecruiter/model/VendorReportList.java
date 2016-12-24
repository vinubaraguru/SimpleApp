package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/24/2016.
 */

public class VendorReportList implements Serializable {

    private String vendorUserName;
    private String vendorUserEmail;
    private String vendorPhoneNumber;
    private String vendorTotalInvites;
    private String vendorTotalResponses;
    private String vendorTotalShortlists;
    private String vendorTotalPreselects;
    private String vendorTotalRejects;

    public VendorReportList(String vendorUserName, String vendorUserEmail, String vendorPhoneNumber, String vendorTotalInvites, String vendorTotalResponses, String vendorTotalShortlists, String vendorTotalPreselects, String vendorTotalRejects) {
        this.vendorUserName = vendorUserName;
        this.vendorUserEmail = vendorUserEmail;
        this.vendorPhoneNumber = vendorPhoneNumber;
        this.vendorTotalInvites = vendorTotalInvites;
        this.vendorTotalResponses = vendorTotalResponses;
        this.vendorTotalShortlists = vendorTotalShortlists;
        this.vendorTotalPreselects = vendorTotalPreselects;
        this.vendorTotalRejects = vendorTotalRejects;
    }

    public String getVendorUserName() {
        return vendorUserName;
    }

    public void setVendorUserName(String vendorUserName) {
        this.vendorUserName = vendorUserName;
    }

    public String getVendorUserEmail() {
        return vendorUserEmail;
    }

    public void setVendorUserEmail(String vendorUserEmail) {
        this.vendorUserEmail = vendorUserEmail;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorTotalInvites() {
        return vendorTotalInvites;
    }

    public void setVendorTotalInvites(String vendorTotalInvites) {
        this.vendorTotalInvites = vendorTotalInvites;
    }

    public String getVendorTotalResponses() {
        return vendorTotalResponses;
    }

    public void setVendorTotalResponses(String vendorTotalResponses) {
        this.vendorTotalResponses = vendorTotalResponses;
    }

    public String getVendorTotalShortlists() {
        return vendorTotalShortlists;
    }

    public void setVendorTotalShortlists(String vendorTotalShortlists) {
        this.vendorTotalShortlists = vendorTotalShortlists;
    }

    public String getVendorTotalPreselects() {
        return vendorTotalPreselects;
    }

    public void setVendorTotalPreselects(String vendorTotalPreselects) {
        this.vendorTotalPreselects = vendorTotalPreselects;
    }

    public String getVendorTotalRejects() {
        return vendorTotalRejects;
    }

    public void setVendorTotalRejects(String vendorTotalRejects) {
        this.vendorTotalRejects = vendorTotalRejects;
    }
}

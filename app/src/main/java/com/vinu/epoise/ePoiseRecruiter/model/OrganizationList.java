package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/14/2016.
 */

public class OrganizationList implements Serializable {

//    private String orgImg;
//    private String orgName;
//    private String orgType;
//
//    public OrganizationList(String orgName, String orgType) {
//        this.orgName = orgName;
//        this.orgType = orgType;
//    }
//
//    public String getOrgImg() {
//        return orgImg;
//    }
//
//    public void setOrgImg(String orgImg) {
//        this.orgImg = orgImg;
//    }
//
//    public String getOrgName() {
//        return orgName;
//    }
//
//    public void setOrgName(String orgName) {
//        this.orgName = orgName;
//    }
//
//    public String getOrgType() {
//        return orgType;
//    }
//
//    public void setOrgType(String orgType) {
//        this.orgType = orgType;
//    }

    private String name;
    private String category;

    public OrganizationList(String name, String category) {
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

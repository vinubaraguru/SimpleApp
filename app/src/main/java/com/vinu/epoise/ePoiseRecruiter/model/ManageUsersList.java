package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 12/22/2016.
 */

public class ManageUsersList implements Serializable {

    public static final int ACTIVE_TYPE = 0;
    public static final int DEACTIVE_TYPE = 1;

    private int manageUserResponseType;
    private String manageUserEmail;
    private String manageUserLoginID;
    private String manageUserDisplayName;
    private String manageUserContactNo;
    private String manageUserRole;
    private String manageUserStatus;

    public ManageUsersList(int manageUserResponseType, String manageUserEmail, String manageUserLoginID, String manageUserDisplayName, String manageUserContactNo, String manageUserRole, String manageUserStatus) {
        this.manageUserResponseType = manageUserResponseType;
        this.manageUserEmail = manageUserEmail;
        this.manageUserLoginID = manageUserLoginID;
        this.manageUserDisplayName = manageUserDisplayName;
        this.manageUserContactNo = manageUserContactNo;
        this.manageUserRole = manageUserRole;
        this.manageUserStatus = manageUserStatus;
    }

    public int getManageUserResponseType() {
        return manageUserResponseType;
    }

    public void setManageUserResponseType(int manageUserResponseType) {
        this.manageUserResponseType = manageUserResponseType;
    }

    public String getManageUserEmail() {
        return manageUserEmail;
    }

    public void setManageUserEmail(String manageUserEmail) {
        this.manageUserEmail = manageUserEmail;
    }

    public String getManageUserLoginID() {
        return manageUserLoginID;
    }

    public void setManageUserLoginID(String manageUserLoginID) {
        this.manageUserLoginID = manageUserLoginID;
    }

    public String getManageUserDisplayName() {
        return manageUserDisplayName;
    }

    public void setManageUserDisplayName(String manageUserDisplayName) {
        this.manageUserDisplayName = manageUserDisplayName;
    }

    public String getManageUserContactNo() {
        return manageUserContactNo;
    }

    public void setManageUserContactNo(String manageUserContactNo) {
        this.manageUserContactNo = manageUserContactNo;
    }

    public String getManageUserRole() {
        return manageUserRole;
    }

    public void setManageUserRole(String manageUserRole) {
        this.manageUserRole = manageUserRole;
    }

    public String getManageUserStatus() {
        return manageUserStatus;
    }

    public void setManageUserStatus(String manageUserStatus) {
        this.manageUserStatus = manageUserStatus;
    }
}

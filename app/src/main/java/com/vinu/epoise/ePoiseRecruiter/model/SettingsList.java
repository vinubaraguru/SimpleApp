package com.vinu.epoise.ePoiseRecruiter.model;

import java.io.Serializable;

/**
 * Created by ePoise on 1/9/2017.
 */

public class SettingsList implements Serializable {

    String settingsTitle;

    public SettingsList(String settingsTitle) {
        this.settingsTitle = settingsTitle;
    }

    public String getSettingsTitle() {
        return settingsTitle;
    }

    public void setSettingsTitle(String settingsTitle) {
        this.settingsTitle = settingsTitle;
    }
}

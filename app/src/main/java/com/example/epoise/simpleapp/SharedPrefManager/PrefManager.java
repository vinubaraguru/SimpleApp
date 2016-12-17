package com.example.epoise.simpleapp.SharedPrefManager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ePoise on 12/14/2016.
 */

public class PrefManager {

    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;
    Context mContext;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Skyore-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this.mContext = context;
        mPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        mEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        mEditor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return mPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}

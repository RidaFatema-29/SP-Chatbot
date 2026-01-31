package com.example.collegeappandchatbot.fragment;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    // Sharedpref file name
    private static final String PREF_NAME = "SharedPref_Name";
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int MODE_MULTI_PROCESS = 0;

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, MODE_MULTI_PROCESS);
        editor = pref.edit();
    }

    private SharedPreferences getPref() {
        return _context.getSharedPreferences(PREF_NAME, Context.MODE_MULTI_PROCESS);
    }

    /**
     * Set the String data in the preferences.
     */
    public void putStringData(String keyname, String value) {
        editor.putString(keyname, value);
        editor.commit();
    }

    /**
     * @return the string data from the prefs
     */
    public String getStringData(String keyName) {
        return pref.getString(keyName, "");
    }

    /**
     * Set the int data in the preferences.
     */
    public void putIntData(String keyname, int value) {
        editor.putInt(keyname, value);
        editor.commit();
    }

    /**
     * @return the boolean data from the prefs
     */
    public int getIntData(String keyName) {
        return pref.getInt(keyName, 0);
    }

    /**
     * Set the boolean data in the preferences.
     */
    public void putBooleanData(String keyname, boolean value) {
        editor.putBoolean(keyname, value);
        editor.commit();
    }

    /**
     * @return the boolean data from the prefs
     */
    public boolean getBooleanData(String keyName) {
        return pref.getBoolean(keyName, false);
    }

    /**
     * Set the long data in the preferences.
     */
    public void putLongData(String keyname, long value) {
        editor.putLong(keyname, value);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean("isLoggedIn", false);
    }

    public void setLoggedIn(boolean isLoggedIn) {
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }

    public void logout() {
        editor.remove("isLoggedIn");  // Remove the login status
        // Clear other user-related preferences if needed
        // editor.remove("keyName");
        editor.apply();
    }

    /**
     * @return the long data from the prefs
     */
    public long getLongData(String keyName) {
        return pref.getLong(keyName, 99);
    }

    /**
     * remove data from pref
     *
     * @param keyName
     */
    public void removeData(String keyName) {
        editor.remove(keyName);
        editor.commit();
    }


    public void logoutUser() {
        // Clear the session data
        editor.clear();
        editor.apply();

    }
}
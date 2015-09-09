package ng.lyf.lyflisting.utils.genericHelpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import ng.lyf.lyflisting.LyfListingApplication;

public class SharedPreferencesHelper {

	private final static String DEFAULT_PREFERENCES = "lyfListing";

    public static SharedPreferences getSharedPreferences() {
		return LyfListingApplication.getContext().getSharedPreferences(DEFAULT_PREFERENCES, Context.MODE_PRIVATE);
	}
	
	public static Editor getSharedPreferencesEditor() {
		return getSharedPreferences().edit();
	}

    // boolean preferences
    public static void saveBooleanPreference(String key, boolean value) {
        getSharedPreferencesEditor().putBoolean(key, value).commit();
    }

    public static boolean getBooleanPreference(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

	// int preferences
	public static void saveIntPreference(String key, int value) {
		getSharedPreferencesEditor().putInt(key, value).commit();
	}
	
	public static int getIntPreference(String key) {
		return getSharedPreferences().getInt(key, -1);
	}
		
	// long preferences
	public static void saveLongPreference(String key, long value) {
		getSharedPreferencesEditor().putLong(key, value).commit();
	}
	
	public static long getLongPreference(String key) {
		return getSharedPreferences().getLong(key, -1);
	}
	
	// string preferences
	public static void saveStringPreference(String key, String value) {
		getSharedPreferencesEditor().putString(key, value).commit();
	}
	
	public static String getStringPreference(String key) {
		return getSharedPreferences().getString(key, Strings.EMPTY);
	}
	// remove shared preferences
	public static void removeSharedPreference(String key) {
		getSharedPreferencesEditor().remove(key).commit();
	}
}

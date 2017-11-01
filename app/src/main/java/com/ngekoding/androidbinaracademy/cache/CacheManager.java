package com.ngekoding.androidbinaracademy.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheManager {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String preferenceName;

    public CacheManager(Context context) {
        this.context = context;
        this.preferenceName = "Global-Cache";
        this.preferences = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        this.editor = preferences.edit();
    }

    public void save(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String get(String key) {
        String value = preferences.getString(key, "");
        return value;
    }

    public void clear() {
        editor.clear();
        editor.apply();
    }
} 
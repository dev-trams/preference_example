package com.student.kppc.preference_report03;

import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;

public class SettingPreference extends android.preference.PreferenceActivity implements Preference.OnPreferenceClickListener {
    EditTextPreference textPref;
    ListPreference strColorPref;
    CheckBoxPreference boldTextPref;
    ListPreference screenColorPref;
    Intent intent;

    String strName, textVal, screenVal, textBold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_preference);
        intent = new Intent(getApplicationContext(), MainActivity.class);
        textPref = (EditTextPreference) findPreference("nameStr");
        strColorPref = (ListPreference) findPreference("colorText");
        boldTextPref = (CheckBoxPreference) findPreference("boldText");
        screenColorPref = (ListPreference) findPreference("screenColor");
        //각 요소 클릭 이벤트
        textPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                strName = o.toString();
                return true;
            }
        });
        strColorPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                textVal = o.toString();
                return true;
            }
        });
        screenColorPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                screenVal = o.toString();
                return true;
            }
        });
        boldTextPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                textBold = o.toString();
                return true;
            }
        });

    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    //뒤로가기 버튼 클릭시 데이터 전송과 동시에 MainActivity.class 로 이돟
    @Override
    public void onBackPressed() {
        intent.putExtra("strName", strName);
        intent.putExtra("valColor", textVal);
        intent.putExtra("valScreen", screenVal);
        intent.putExtra("valBold", textBold);
        super.startActivity(intent);
    }
}
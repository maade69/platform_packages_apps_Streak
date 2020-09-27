package com.streak.settings.fragments;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.content.Context;
import android.os.Bundle;
import android.os.UserHandle;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.SwitchPreference;
import android.provider.Settings;

import com.android.settings.R;

import com.android.settings.SettingsPreferenceFragment;

import com.streak.settings.preferences.CustomSeekBarPreference;

import com.android.internal.logging.nano.MetricsProto;

public class Buttons extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener{

    //Keys
    private static final String KEY_BUTTON_BRIGHTNESS = "button_brightness";
    private static final String KEY_BUTTON_BRIGHTNESS_SW = "button_brightness_sw";
    private static final String KEY_BACKLIGHT_TIMEOUT = "backlight_timeout";

    // category keys
    private static final String CATEGORY_HWKEY = "hardware_keys";

    private ListPreference mBacklightTimeout;
    private CustomSeekBarPreference mButtonBrightness;
    private SwitchPreference mButtonBrightness_sw;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.streak_settings_buttons);

        final PreferenceScreen prefScreen = getPreferenceScreen();

        final boolean variableBrightness = getResources().getBoolean(
                com.android.internal.R.bool.config_deviceHasVariableButtonBrightness);

        mBacklightTimeout =
                (ListPreference) findPreference(KEY_BACKLIGHT_TIMEOUT);
        mButtonBrightness =
                (CustomSeekBarPreference) findPreference(KEY_BUTTON_BRIGHTNESS);
        mButtonBrightness_sw =
                (SwitchPreference) findPreference(KEY_BUTTON_BRIGHTNESS_SW);

        if (mBacklightTimeout != null) {
            mBacklightTimeout.setOnPreferenceChangeListener(this);
            int BacklightTimeout = Settings.System.getInt(getContentResolver(),
                    Settings.System.BUTTON_BACKLIGHT_TIMEOUT, 5000);
            mBacklightTimeout.setValue(Integer.toString(BacklightTimeout));
            mBacklightTimeout.setSummary(mBacklightTimeout.getEntry());
        }

        if (variableBrightness) {
            prefScreen.removePreference(mButtonBrightness_sw);
            if (mButtonBrightness != null) {
                float ButtonBrightness = Settings.System.getFloat(getContentResolver(),
                        Settings.System.BUTTON_BRIGHTNESS, 1.0f);
                mButtonBrightness.setValue((int)ButtonBrightness * 100.0f);
                mButtonBrightness.setOnPreferenceChangeListener(this);
            }
        } else {
            prefScreen.removePreference(mButtonBrightness);
            if (mButtonBrightness_sw != null) {
                mButtonBrightness_sw.setChecked((Settings.System.getFloat(getContentResolver(),
                        Settings.System.BUTTON_BRIGHTNESS, 1.0f) == 1));
                mButtonBrightness_sw.setOnPreferenceChangeListener(this);
            }
        }

    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        ContentResolver resolver = getActivity().getContentResolver();
        if (preference == mBacklightTimeout) {
            String BacklightTimeout = (String) newValue;
            int BacklightTimeoutValue = Integer.parseInt(BacklightTimeout);
            Settings.System.putInt(getActivity().getContentResolver(),
                    Settings.System.BUTTON_BACKLIGHT_TIMEOUT, BacklightTimeoutValue);
            int BacklightTimeoutIndex = mBacklightTimeout
                    .findIndexOfValue(BacklightTimeout);
            mBacklightTimeout
                    .setSummary(mBacklightTimeout.getEntries()[BacklightTimeoutIndex]);
            return true;
        } else if (preference == mButtonBrightness) {
            float value = (Integer) newValue;
            Settings.System.putFloat(getActivity().getContentResolver(),
                    Settings.System.BUTTON_BRIGHTNESS, value / 100.0f);
            return true;
        } else if (preference == mButtonBrightness_sw) {
            boolean value = (Boolean) newValue;
            Settings.System.putFloat(getActivity().getContentResolver(),
                    Settings.System.BUTTON_BRIGHTNESS, value ? 1.0f : -1.0f);
            return true;
        }
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.STREAK_SETTINGS;
    }

}

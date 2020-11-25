/*
 * Copyright (C) 2020 The Pure Nexus Project
 * used for Project Streak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.streak.settings;

import com.android.internal.logging.nano.MetricsProto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.preference.Preference;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.ComponentName;
import com.google.android.material.card.MaterialCardView;

import com.android.settings.R;
import com.streak.settings.fragments.StreakThemes;
import com.streak.settings.fragments.Statusbar;
import com.streak.settings.fragments.Lockscreen;
import com.streak.settings.fragments.Powermenu;
import com.streak.settings.fragments.Gesture;
import com.streak.settings.fragments.Notification;
import com.streak.settings.fragments.Buttons;
import com.streak.settings.fragments.About;


import com.android.settings.SettingsPreferenceFragment;

public class StreakSettings extends SettingsPreferenceFragment implements View.OnClickListener {

    MaterialCardView mStreakThemesCard;
    MaterialCardView mStatusbarCard;
    MaterialCardView mLockscreenCard;
    MaterialCardView mPowerMenuCard;
    MaterialCardView mGestureCard;
    MaterialCardView mNotificationCard;
    MaterialCardView mButtonCard;
    MaterialCardView mAboutCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.streak_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
		    getActivity().getActionBar().hide();

        mStreakThemesCard = (MaterialCardView) view.findViewById(R.id.streakthemes_card);
        mStreakThemesCard.setOnClickListener(this);

        mStatusbarCard = (MaterialCardView) view.findViewById(R.id.statusbar_card);
        mStatusbarCard.setOnClickListener(this);

        mLockscreenCard = (MaterialCardView) view.findViewById(R.id.lockscreen_card);
        mLockscreenCard.setOnClickListener(this);

        mPowerMenuCard = (MaterialCardView) view.findViewById(R.id.powermenu_card);
        mPowerMenuCard.setOnClickListener(this);

        mGestureCard = (MaterialCardView) view.findViewById(R.id.gesture_card);
        mGestureCard.setOnClickListener(this);

        mNotificationCard = (MaterialCardView) view.findViewById(R.id.notification_card);
        mNotificationCard.setOnClickListener(this);

        mButtonCard = (MaterialCardView) view.findViewById(R.id.button_card);
        mButtonCard.setOnClickListener(this);

        mAboutCard = (MaterialCardView) view.findViewById(R.id.about_card);
        mAboutCard.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {
        int id = view.getId();
            if (id == R.id.streakthemes_card)
              {
                StreakThemes streakthemesfragment = new StreakThemes();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.replace(this.getId(), streakthemesfragment);
                transaction.addToBackStack(null);
                transaction.commit();
               }
            if (id == R.id.statusbar_card)
              {
                Statusbar statusbarfragment = new Statusbar();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction1.replace(this.getId(), statusbarfragment);
                transaction1.addToBackStack(null);
                transaction1.commit();
              }
            if (id == R.id.lockscreen_card)
              {
               Lockscreen lockscreenfragment = new Lockscreen();
                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                transaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction2.replace(this.getId(), lockscreenfragment);
                transaction2.addToBackStack(null);
                transaction2.commit();
               }
            if (id == R.id.powermenu_card)
              {
                Powermenu powermenufragment = new Powermenu();
                FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
                transaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction3.replace(this.getId(), powermenufragment);
                transaction3.addToBackStack(null);
                transaction3.commit();
               }
            if (id == R.id.gesture_card)
              {
                Gesture gesturefragment = new Gesture();
                FragmentTransaction transaction4 = getFragmentManager().beginTransaction();
                transaction4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction4.replace(this.getId(), gesturefragment);
                transaction4.addToBackStack(null);
                transaction4.commit();
              }
            if (id == R.id.notification_card)
              {
                Notification notificationfragment = new Notification();
                FragmentTransaction transaction5 = getFragmentManager().beginTransaction();
                transaction5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction5.replace(this.getId(), notificationfragment);
                transaction5.addToBackStack(null);
                transaction5.commit();
               }
            if (id == R.id.button_card)
              {
                Buttons buttonfragment = new Buttons();
                FragmentTransaction transaction6 = getFragmentManager().beginTransaction();
                transaction6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction6.replace(this.getId(), buttonfragment);
                transaction6.addToBackStack(null);
                transaction6.commit();
               }
            if (id == R.id.about_card)
              {
                About aboutfragment = new About();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), aboutfragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               }
        }
        
    @Override           
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.STREAK_SETTINGS;
    }

    public static void lockCurrentOrientation(Activity activity) {
        int currentRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int orientation = activity.getResources().getConfiguration().orientation;
        int frozenRotation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
        switch (currentRotation) {
            case Surface.ROTATION_0:
                frozenRotation = orientation == Configuration.ORIENTATION_LANDSCAPE
                        ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                        : ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                break;
            case Surface.ROTATION_90:
                frozenRotation = orientation == Configuration.ORIENTATION_PORTRAIT
                        ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
                        : ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                break;
            case Surface.ROTATION_180:
                frozenRotation = orientation == Configuration.ORIENTATION_LANDSCAPE
                        ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
                        : ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                break;
            case Surface.ROTATION_270:
                frozenRotation = orientation == Configuration.ORIENTATION_PORTRAIT
                        ? ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                        : ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                break;
        }
        activity.setRequestedOrientation(frozenRotation);
    }
}

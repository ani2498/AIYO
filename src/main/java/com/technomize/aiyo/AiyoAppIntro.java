package com.technomize.aiyo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.technomize.aiyo.Dashboard.UserDashboardActivity;
import com.technomize.aiyo.Fragments.AppIntroFragment;

/**
 * Created by rishi on 9/4/2018.
 */


public class AiyoAppIntro extends AppIntro  {
    // Please DO NOT override onCreate. Use init
    @Override
    public void init(Bundle savedInstanceState) {

        //adding the three slides for introduction app you can ad as many you needed
        addSlide(AppIntroFragment.newInstance(R.layout.app_intro1));
        addSlide(AppIntroFragment.newInstance(R.layout.app_intro2));
        addSlide(AppIntroFragment.newInstance(R.layout.app_intro3));


        showStatusBar(true);
        showSkipButton(true);

        setVibrate(true);
        setVibrateIntensity(30);

        //Add animation to the intro slider
        setDepthAnimation();
    }

    @Override
    public void onSkipPressed() {
        // Do something here when users click or tap on Skip button.
        Toast.makeText(getApplicationContext(),
                getString(R.string.app_intro_skip), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), UserDashboardActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onNextPressed() {
        // Do something here when users click or tap on Next button.
    }

    @Override
    public void onDonePressed() {
        // Do something here when users click or tap tap on Done button.
        finish();
    }

    @Override
    public void onSlideChanged() {
        // Do something here when slide is changed
    }
}
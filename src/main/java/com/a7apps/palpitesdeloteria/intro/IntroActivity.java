package com.a7apps.palpitesdeloteria.intro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.a7apps.palpitesdeloteria.R;
import com.a7apps.palpitesdeloteria.views.MainMenu;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import org.jetbrains.annotations.Nullable;

public class IntroActivity extends AppIntro {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String strKey = "checkState";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance(getString(R.string.tIntro1), getString(R.string.dIntro1),
                R.drawable.dezenasmaissorteadas, ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));

        addSlide(AppIntroFragment.newInstance(getString(R.string.tIntro2), getString(R.string.dIntro2),
                R.drawable.assetemaisprint, ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));

        addSlide(AppIntroFragment.newInstance(getString(R.string.tIntro2), getString(R.string.dIntro3),
                R.drawable.btnestatisticaprint, ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));

        addSlide(AppIntroFragment.newInstance(getString(R.string.tIntro4), "", R.drawable.logo5,
                ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));

        sharedPreferences = getApplicationContext().getSharedPreferences("My preferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences != null){
            boolean checkShared = sharedPreferences.getBoolean(strKey, false);

            if (checkShared){
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                finish();
            }
        }
    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        startActivity(new Intent(getApplicationContext(), MainMenu.class));
        editor.putBoolean(strKey, false).commit();
        finish();
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        startActivity(new Intent(getApplicationContext(), MainMenu.class));
        editor.putBoolean(strKey, true).commit();
        finish();
    }
}
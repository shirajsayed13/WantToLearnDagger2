package com.shirajsayed.wanttolearndagger2.di.main;

import com.shirajsayed.wanttolearndagger2.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Shiraj Sayed
 */
@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();
}

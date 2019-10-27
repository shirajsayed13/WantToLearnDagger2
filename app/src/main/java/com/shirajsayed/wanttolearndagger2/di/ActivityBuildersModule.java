package com.shirajsayed.wanttolearndagger2.di;

import com.shirajsayed.wanttolearndagger2.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Shiraj Sayed
 */
@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

}

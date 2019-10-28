package com.shirajsayed.wanttolearndagger2.di;

import com.shirajsayed.wanttolearndagger2.di.auth.AuthModule;
import com.shirajsayed.wanttolearndagger2.di.auth.AuthViewModelsModule;
import com.shirajsayed.wanttolearndagger2.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Shiraj Sayed
 */
@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

}

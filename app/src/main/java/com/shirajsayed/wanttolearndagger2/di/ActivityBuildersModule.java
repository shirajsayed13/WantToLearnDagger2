package com.shirajsayed.wanttolearndagger2.di;

import com.shirajsayed.wanttolearndagger2.di.auth.AuthModule;
import com.shirajsayed.wanttolearndagger2.di.auth.AuthViewModelsModule;
import com.shirajsayed.wanttolearndagger2.di.main.MainFragmentBuildersModule;
import com.shirajsayed.wanttolearndagger2.di.main.MainViewModelsModule;
import com.shirajsayed.wanttolearndagger2.ui.auth.AuthActivity;
import com.shirajsayed.wanttolearndagger2.ui.main.MainActivity;

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

    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();

}

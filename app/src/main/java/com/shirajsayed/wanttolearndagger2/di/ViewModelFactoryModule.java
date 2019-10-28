package com.shirajsayed.wanttolearndagger2.di;

import androidx.lifecycle.ViewModelProvider;

import com.shirajsayed.wanttolearndagger2.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

/**
 * @author Shiraj Sayed
 */
@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}

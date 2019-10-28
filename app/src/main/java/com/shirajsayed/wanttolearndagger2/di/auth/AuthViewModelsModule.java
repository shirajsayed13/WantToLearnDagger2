package com.shirajsayed.wanttolearndagger2.di.auth;

import androidx.lifecycle.ViewModel;

import com.shirajsayed.wanttolearndagger2.di.ViewModelKey;
import com.shirajsayed.wanttolearndagger2.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Shiraj Sayed
 */
@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}

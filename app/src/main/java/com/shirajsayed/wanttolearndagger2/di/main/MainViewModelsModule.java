package com.shirajsayed.wanttolearndagger2.di.main;

import androidx.lifecycle.ViewModel;

import com.shirajsayed.wanttolearndagger2.di.ViewModelKey;
import com.shirajsayed.wanttolearndagger2.ui.main.posts.PostsViewModel;
import com.shirajsayed.wanttolearndagger2.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Shiraj Sayed
 */
@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel profileViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostViewModel(PostsViewModel postsViewModel);
}

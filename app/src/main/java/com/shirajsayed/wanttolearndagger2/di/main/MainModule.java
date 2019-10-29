package com.shirajsayed.wanttolearndagger2.di.main;

import com.shirajsayed.wanttolearndagger2.network.MainApi;
import com.shirajsayed.wanttolearndagger2.ui.main.posts.PostsAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Shiraj Sayed
 */
@Module
public class MainModule {

    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }

    @Provides
    static PostsAdapter provideAdapter() {
        return new PostsAdapter();
    }
}

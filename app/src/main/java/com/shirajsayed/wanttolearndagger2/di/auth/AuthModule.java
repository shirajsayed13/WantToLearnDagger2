package com.shirajsayed.wanttolearndagger2.di.auth;

import com.shirajsayed.wanttolearndagger2.network.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Shiraj Sayed
 */
@Module
public class AuthModule {

    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}

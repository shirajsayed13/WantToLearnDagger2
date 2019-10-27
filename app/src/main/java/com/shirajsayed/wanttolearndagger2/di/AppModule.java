package com.shirajsayed.wanttolearndagger2.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.shirajsayed.wanttolearndagger2.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Shiraj Sayed
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideAppDrawable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.ic_placeholder);
    }

}

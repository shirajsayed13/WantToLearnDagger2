package com.shirajsayed.wanttolearndagger2.di;

import android.app.Application;

import com.shirajsayed.wanttolearndagger2.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author Shiraj Sayed
 */

@Component(
        modules = {
                AndroidSupportInjectionModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}

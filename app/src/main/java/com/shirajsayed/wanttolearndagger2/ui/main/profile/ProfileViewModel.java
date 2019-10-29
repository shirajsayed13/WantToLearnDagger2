package com.shirajsayed.wanttolearndagger2.ui.main.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.shirajsayed.wanttolearndagger2.SessionManager;
import com.shirajsayed.wanttolearndagger2.models.User;
import com.shirajsayed.wanttolearndagger2.ui.auth.AuthResource;

import javax.inject.Inject;

/**
 * @author Shiraj Sayed
 */
public class ProfileViewModel extends ViewModel {

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser() {
        return sessionManager.getAuthUser();
    }
}

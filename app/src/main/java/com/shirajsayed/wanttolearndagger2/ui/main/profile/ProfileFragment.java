package com.shirajsayed.wanttolearndagger2.ui.main.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.shirajsayed.wanttolearndagger2.R;
import com.shirajsayed.wanttolearndagger2.models.User;
import com.shirajsayed.wanttolearndagger2.ui.auth.AuthResource;
import com.shirajsayed.wanttolearndagger2.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * @author Shiraj Sayed
 */
public class ProfileFragment extends DaggerFragment {

    private ProfileViewModel viewModel;
    private TextView mEmail;
    private TextView mUserName;
    private TextView mWebsite;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Profile Fragment Inflated", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, providerFactory).get(ProfileViewModel.class);
        mEmail = view.findViewById(R.id.email);
        mUserName = view.findViewById(R.id.username);
        mWebsite = view.findViewById(R.id.website);
        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case AUTHENTICATED:
                            if (userAuthResource.data != null)
                                setUpUserDetail(userAuthResource.data);
                            break;
                        case ERROR:
                            setUpErrorMessage(userAuthResource.message);
                            break;
                    }
                }
            }
        });

    }

    private void setUpUserDetail(User userDetail) {
        mEmail.setText(userDetail.getEmail());
        mUserName.setText(userDetail.getUsername());
        mWebsite.setText(userDetail.getWebsite());
    }

    private void setUpErrorMessage(String message) {
        mEmail.setText(message);
        mUserName.setText("Error");
        mWebsite.setText("Error");
    }
}

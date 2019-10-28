package com.shirajsayed.wanttolearndagger2.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.shirajsayed.wanttolearndagger2.R;
import com.shirajsayed.wanttolearndagger2.models.User;
import com.shirajsayed.wanttolearndagger2.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AuthActivity";

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    private AuthViewModel viewModel;
    private EditText mUserIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);
        mUserIdEditText = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);
        setLogo();
        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.observeUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    Log.e(TAG, "onChanged: User " + user.toString());
                }
            }
        });
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                attemptLogin();
                break;
        }
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(mUserIdEditText.getText().toString())) {
            return;
        }
        viewModel.authenticWithId(Integer.parseInt(mUserIdEditText.getText().toString()));
    }
}

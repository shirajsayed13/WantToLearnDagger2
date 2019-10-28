package com.shirajsayed.wanttolearndagger2.ui.main.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.shirajsayed.wanttolearndagger2.R;

import dagger.android.support.DaggerFragment;

/**
 * @author Shiraj Sayed
 */
public class ProfileFragment extends DaggerFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Profile Fragment Inflated", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }
}

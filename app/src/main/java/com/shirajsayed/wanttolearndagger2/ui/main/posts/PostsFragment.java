package com.shirajsayed.wanttolearndagger2.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shirajsayed.wanttolearndagger2.R;
import com.shirajsayed.wanttolearndagger2.models.Post;
import com.shirajsayed.wanttolearndagger2.ui.main.Resource;
import com.shirajsayed.wanttolearndagger2.util.VerticalSpaceItemDecoration;
import com.shirajsayed.wanttolearndagger2.viewmodel.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * @author Shiraj Sayed
 */
public class PostsFragment extends DaggerFragment {
    private static final String TAG = "PostsFragment";

    private PostsViewModel viewModel;
    private RecyclerView mRecyclerView;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    PostsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        viewModel = ViewModelProviders.of(this, providerFactory).get(PostsViewModel.class);
        initRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.observePosts().removeObservers(getViewLifecycleOwner());
        viewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if (listResource != null) {
                    switch (listResource.status) {
                        case ERROR:
                            Log.e(TAG, "onChanged: ERROR " + listResource.message);
                            break;
                        case LOADING:
                            Log.e(TAG, "onChanged: LOADING");
                            break;
                        case SUCCESS:
                            Log.e(TAG, "onChanged: SUCCESS");
                            adapter.setPosts(listResource.data);
                            break;
                    }
                }
            }
        });

    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        VerticalSpaceItemDecoration verticalSpaceItemDecoration = new VerticalSpaceItemDecoration(15);
        mRecyclerView.addItemDecoration(verticalSpaceItemDecoration);
        mRecyclerView.setAdapter(adapter);
    }
}

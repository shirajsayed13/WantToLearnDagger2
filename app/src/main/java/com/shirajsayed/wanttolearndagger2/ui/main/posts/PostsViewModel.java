package com.shirajsayed.wanttolearndagger2.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.shirajsayed.wanttolearndagger2.SessionManager;
import com.shirajsayed.wanttolearndagger2.models.Post;
import com.shirajsayed.wanttolearndagger2.network.MainApi;
import com.shirajsayed.wanttolearndagger2.ui.main.Resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Shiraj Sayed
 */
public class PostsViewModel extends ViewModel {
    private static final String TAG = "PostsViewModel";

    private final SessionManager sessionManager;
    private final MainApi mainApi;
    private MediatorLiveData<Resource<List<Post>>> posts;

    @Inject

    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
    }

    public LiveData<Resource<List<Post>>> observePosts() {
        if (posts == null) {
            posts = new MediatorLiveData<>();
            posts.setValue(Resource.loading((List<Post>) null));

            final LiveData<Resource<List<Post>>> source = LiveDataReactiveStreams.fromPublisher(
                    mainApi.getPostFromUser(sessionManager.getAuthUser().getValue().data.getId())

                            .onErrorReturn(new Function<Throwable, List<Post>>() {
                                @Override
                                public List<Post> apply(Throwable throwable) throws Exception {
                                    Log.e(TAG, "apply: ERROR " + throwable);
                                    Post post = new Post();
                                    post.setId(-1);
                                    ArrayList<Post> posts = new ArrayList<>();
                                    posts.add(post);
                                    return posts;
                                }
                            })
                            .map(new Function<List<Post>, Resource<List<Post>>>() {
                                @Override
                                public Resource<List<Post>> apply(List<Post> posts) throws Exception {
                                    if (posts.size() > 0) {
                                        if (posts.get(0).getId() == -1) {
                                            return Resource.error("SomeThing Went Wrong", null);
                                        }
                                    }
                                    return Resource.success(posts);
                                }
                            })
                            .subscribeOn(Schedulers.io())


            );
        }
        return posts;
    }
}

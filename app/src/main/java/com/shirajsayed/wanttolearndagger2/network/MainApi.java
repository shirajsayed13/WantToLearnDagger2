package com.shirajsayed.wanttolearndagger2.network;

import com.shirajsayed.wanttolearndagger2.models.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Shiraj Sayed
 */
public interface MainApi {

    @GET("posts")
    Flowable<List<Post>> getPostFromUser(@Query("userId") int id);
}

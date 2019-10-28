package com.shirajsayed.wanttolearndagger2.network;

import com.shirajsayed.wanttolearndagger2.models.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Shiraj Sayed
 */
public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(@Path("id") int id);
}

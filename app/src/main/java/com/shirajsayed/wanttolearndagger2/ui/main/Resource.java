package com.shirajsayed.wanttolearndagger2.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Shiraj Sayed
 */
public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null);
    }

    public static <T> Resource<T> error(@Nullable String message, @Nullable T data) {
        return new Resource<>(Status.ERROR, data, message);
    }

    public enum Status {SUCCESS, ERROR, LOADING}
}

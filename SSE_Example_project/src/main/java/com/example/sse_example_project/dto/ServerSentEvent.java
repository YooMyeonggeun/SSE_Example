package com.example.sse_example_project.dto;

import com.fasterxml.jackson.core.JsonToken;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;

public final class ServerSentEvent<T>{

    @Nullable
    private final String id;

    @Nullable
    private final String event;

    @Nullable
    private final Duration retry;

    @Nullable
    private final String comment;

    @Nullable
    private final T data;

    public ServerSentEvent(@Nullable String id,@Nullable String event,@Nullable Duration retry,@Nullable String comment, T data) {
        this.id = id;
        this.event = event;
        this.retry = retry;
        this.comment = comment;
        this.data = data;
    }
}

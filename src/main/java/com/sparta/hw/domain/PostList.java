package com.sparta.hw.domain;
import java.time.LocalDateTime;

public interface PostList {
    String getHeadline();
    String getUsername();
    LocalDateTime getCreatedAt();
}

package com.sparta.hw.domain;

import java.time.LocalDateTime;

public interface GetPost {
    String getHeadline();
    String getUsername();
    LocalDateTime getCreatedAt();
    String getContents();
}

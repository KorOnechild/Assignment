package com.sparta.hw.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String headline;
    private String username;
    private String contents;
    private String password;
}

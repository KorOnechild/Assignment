package com.sparta.hw.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor  //기본생성자는 필수(JPA가 엔티티 객체 생성시 기본 생성자를 사용)
@Getter
@Entity             //@Entity가 붙은 클래스는 JPA가 관리하는 것으로, 엔티티라고 불림/ 테이블과의 매핑
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String headline;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

    public Post(PostRequestDto requestDto) {
        this.headline = requestDto.getHeadline();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.headline = requestDto.getHeadline();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}

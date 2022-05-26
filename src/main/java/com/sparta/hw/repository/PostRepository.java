package com.sparta.hw.repository;

import com.sparta.hw.domain.GetPost;
import com.sparta.hw.domain.Post;
import com.sparta.hw.domain.PostList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<GetPost> findAllById(Long id);  //해당 id를 가진 게시물 조회
    List<PostList> findAllByOrderByCreatedAtDesc();    //전체 목록 조회 생성시간 기준으로 내림차순
}

package com.sparta.hw.controller;

import com.sparta.hw.domain.*;
import com.sparta.hw.repository.PostRepository;
import com.sparta.hw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/posts")      //게시글 작성
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")  //게시글 목록 조회
    public List<PostList> getPostlist() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/posts/{id}")  //게시글 목록 조회
    public List<GetPost> getPost(@PathVariable Long id) {
        return postRepository.findAllById(id);
    }

    @PutMapping("/api/posts/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.delete(id, requestDto);
        return id;
    }
}

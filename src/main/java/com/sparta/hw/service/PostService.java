package com.sparta.hw.service;

import com.sparta.hw.domain.Post;
import com.sparta.hw.repository.PostRepository;
import com.sparta.hw.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );

        if(Objects.equals(post.getPassword(), requestDto.getPassword())){
            post.update(requestDto);
            System.out.println("게시글이 수정되었습니다..");
            return post.getId();    //수정되면 해당 포스트의 아이디를 리턴
        }else{
            System.out.println("비밀번호가 틀립니다.");
            return 0L;
        }
    }

    @Transactional //transactional 붙이는 기준
    public Long delete(Long id,PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 없습니다.")
        );
        if(Objects.equals(post.getPassword(), requestDto.getPassword())){
            postRepository.deleteById(id);
            System.out.println("게시글이 삭제되었습니다.");
            return id;
        }else{
            System.out.println("비밀번호가 틀립니다.");
            return 0L;
        }
    }
}

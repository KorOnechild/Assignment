package com.sparta.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //생성시간,수정시간이 바뀌었을때 자동으로 업데이트
@SpringBootApplication
public class HwApplication {
    public static void main(String[] args) {
        SpringApplication.run(HwApplication.class, args);
    }
}

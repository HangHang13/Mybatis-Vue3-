package com.example.mybatis.service;

import com.example.mybatis.dto.req.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;



    @Test
    @DisplayName("유저는 회원가입 되어야 한다.")
    void create(){
        UserRequest res = UserRequest.builder()
                .userPassword("1234")
                .userEmail("rla@naver.com")
                .userName("김행의")
                .build();

        Assertions.assertEquals( "rla@naver.com",userService.create(res));

    }
}
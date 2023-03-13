package com.example.mybatis.dto.res;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private String userId;

    private String userEmail;

    private String userPassWord;

    private String userName;

    private String userRole;

    private LocalDateTime userRegDate;
}

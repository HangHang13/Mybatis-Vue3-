package com.example.mybatis.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String userId;

    private String userEmail;

    private String userPassWord;

    private String userName;

    private String userRole;

    private LocalDateTime userRegDate;
}

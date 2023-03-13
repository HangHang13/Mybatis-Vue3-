package com.example.mybatis.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserRequest {
    private String userEmail;

    private String userPassWord;

    private String userName;

    private String userRole;

    private LocalDateTime userRegDate;


}

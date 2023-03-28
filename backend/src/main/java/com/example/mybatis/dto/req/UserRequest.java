package com.example.mybatis.dto.req;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userId;
    private String userEmail;

    private String userPassword;

    private String userName;

    private String userRole;

    private LocalDateTime userRegDate;

}

package com.example.mybatis.dto.res;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LoginResponseDTO {

    private String userEmail;

    private String userName;

    private String userRole;

    private String userRegdate;
    private String token;   // 인증 토큰

    private String message; // 응답 메세지

    public LoginResponseDTO(UserResponse userResponse, String token){
        this.userEmail = userResponse.getUserEmail();
        this.userName = userResponse.getUserName();
        this.userRegdate = userResponse.getUserRole();
        this.userRole = userResponse.getUserRole();
        this.token = token;
    }

}

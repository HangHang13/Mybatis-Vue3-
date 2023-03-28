package com.example.mybatis.dto.req;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LoginRequestDTO {


    private String userEmail;

    private String userPassword;
}

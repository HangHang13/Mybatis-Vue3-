package com.example.mybatis.service;

import com.example.mybatis.config.security.TokenProvider;
import com.example.mybatis.dto.req.UserRequest;
import com.example.mybatis.dto.res.LoginResponseDTO;
import com.example.mybatis.dto.res.UserResponse;
import com.example.mybatis.mapper.PostUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final PostUserMapper postUserMapper;

    //회원정보 조회
    private UserResponse retrieve(String email) {
        UserResponse user = postUserMapper.findByUserEmail(email);
        return user;
    }
    //회원 가입
    public UserResponse create(final UserRequest userRequest){
        if (userRequest ==null){
            throw new RuntimeException("가입정보가 없습니다");
        }
        UUID one = UUID.randomUUID();
        final String email = userRequest.getUserEmail();
        String rawPassword = userRequest.getUserPassword();
        String encodePassword = passwordEncoder.encode(rawPassword);    // 암호화 처리
//        userRequest.setUserPassword(encodePassword);

        UserRequest res = UserRequest.builder()
                .userId(one.toString())
                .userEmail(userRequest.getUserEmail())
                .userName(userRequest.getUserName())
                .userRegDate(LocalDateTime.now())
                .userPassword(encodePassword)
                .build();
        postUserMapper.save(res);
        return retrieve(userRequest.getUserEmail());
    }

    // 로그인 처리 및 검증
    public LoginResponseDTO getByCredentials(
            final String email,
            final String rawPassword) {

        // 입력한 이메일을 통해 회원정보 조회
        UserResponse byUserEmail = postUserMapper.findByUserEmail(email);
        System.out.println(byUserEmail);
        if (byUserEmail == null) {
            throw new RuntimeException("가입된 회원이 아닙니다.");
        }
        // 패스워드 검증 (입력 비번, DB에 저장된 비번)
        if (!passwordEncoder.matches(rawPassword, byUserEmail.getUserPassWord())) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        log.info("{}님 로그인 성공!", byUserEmail.getUserName());

        // 토큰 발급
        String token = tokenProvider.createToken(byUserEmail);
        log.info("{}님의 토큰 : {}",byUserEmail.getUserName(), token);
        return new LoginResponseDTO(byUserEmail, token);

    }
}

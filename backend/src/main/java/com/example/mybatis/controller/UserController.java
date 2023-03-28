package com.example.mybatis.controller;

import com.example.mybatis.dto.req.LoginRequestDTO;
import com.example.mybatis.dto.res.LoginResponseDTO;
import com.example.mybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인 요청 처리
    @PostMapping("/user/join")
    public ResponseEntity<?> join(
            @Validated @RequestBody
            LoginRequestDTO requestDTO, BindingResult result) {

        log.info("/user/join POST! - {}", requestDTO);

        if (result.hasErrors()) {
            log.warn(result.toString());
            return ResponseEntity
                    .badRequest()
                    .body(LoginResponseDTO.builder()
                            .message("아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.\n" +
                                    "입력하신 내용을 다시 확인해주세요.")
                            .build()
                    );
        }

        try {
            LoginResponseDTO userInfo = userService.getByCredentials(
                    requestDTO.getUserEmail(),
                    requestDTO.getUserPassword()
            );

            return ResponseEntity
                    .ok()
                    .body(userInfo);

        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(LoginResponseDTO.builder()
                            .message(e.getMessage())
                            .build()
                    );
        }

    } // join()
}

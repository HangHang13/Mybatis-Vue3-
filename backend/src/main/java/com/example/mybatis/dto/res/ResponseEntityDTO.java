package com.example.mybatis.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ResponseEntityDTO<T> {
    private Integer code; //1정상, -1실패
    private String msg; // 통신에 대한 결과 메시지 담기
    private T body; // body가 메서드마다 다르므로 제네릭 사용

}

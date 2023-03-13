package com.example.mybatis.dto.req;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class boardRequest {

    private Long boardId;
    private String boardTitle;

    private String boardType;

    private String boardContent;

    private String boardWriter;

    private String isComment;

    private LocalDateTime createDate;

    private Long userId;
}

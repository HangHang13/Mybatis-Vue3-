package com.example.mybatis.dto.res;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private Long boardId;
    private String boardTitle;

    private String boardType;

    private String boardContent;

    private String boardWriter;

    private String isComment;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Long userId;
}

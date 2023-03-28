package com.example.mybatis.dto.req;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {

    private Long boardId;
    private String boardTitle;

    private String boardType;

    private String boardContent;

    private String boardWriter;

    private String boardIsComment;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String userId;
}

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

    public BoardResponse(Long boardId, String boardTitle, String boardType, String boardContent, String boardWriter, String isComment, LocalDateTime createDate, LocalDateTime updateDate, Long userId) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardType = boardType;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
        this.isComment = isComment;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
    }
}

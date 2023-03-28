package com.example.mybatis.dto.res;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {

    private Long boardId;
    private String boardTitle;

    private String boardType;

    private String boardContent;

    private String boardWriter;

    private String boardIscomment;

    private LocalDateTime boardCreateDate;

    private LocalDateTime boardUpdateDate;

    private String userId;

//    public BoardResponse(HashMap t) {
//        this.boardId = (Long) t.get(boardId);
//        this.boardTitle = (String) t.get(boardTitle);
//        this.boardType = (String) t.get(boardType);
//        this.boardContent = (String) t.get(boardContent);
//        this.boardWriter = (String) t.get(boardWriter);
//        this.iscomment = (String) t.get(iscomment);
//        this.createDate = (LocalDateTime) t.get(createDate);
//        this.updateDate = (LocalDateTime) t.get(updateDate);
//        this.userId = (Long) t.get(userId);
//    }

//    public BoardResponse(Long boardId, String boardTitle, String boardType, String boardContent, String boardWriter, String isComment, LocalDateTime createDate, LocalDateTime updateDate, Long userId) {
//        this.boardId = boardId;
//        this.boardTitle = boardTitle;
//        this.boardType = boardType;
//        this.boardContent = boardContent;
//        this.boardWriter = boardWriter;
//        this.isComment = isComment;
//        this.createDate = createDate;
//        this.updateDate = updateDate;
//        this.userId = userId;
//    }
}

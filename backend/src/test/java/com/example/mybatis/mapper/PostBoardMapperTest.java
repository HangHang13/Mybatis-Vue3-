package com.example.mybatis.mapper;

import com.example.mybatis.dto.req.BoardRequest;
import com.example.mybatis.dto.res.BoardResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PostBoardMapperTest {

    @Autowired
    PostBoardMapper postBoardMapper;

    @Test
    @DisplayName("게시글을 생성해야 한다.")
    void postBoard(){
        BoardRequest res = BoardRequest.builder()
                .boardContent("김진행입니다.")
                .boardTitle("안녕하세요")
                .boardWriter("김진행")
                .boardType("NOTICE")
                .userId(1L)
                .build();

        postBoardMapper.save(res);

        List<BoardResponse> posts = postBoardMapper.findAll();

    }

    @Test
    @DisplayName("게시글을 상세 조회해야 한다.")
    void getBoard(){
        BoardResponse res = postBoardMapper.findById(2L);
        Assertions.assertEquals(res.getBoardId(), 2L);
        Assertions.assertEquals(res.getBoardContent(),"김진행입니다.");
    }

    @Test
    @DisplayName("게시글을 수정해야 한다.")
    void updateBoard(){

        BoardRequest req = BoardRequest.builder()
                .boardId(1L)
                .boardTitle("김활")
                .boardWriter("김진행")
                .boardType("NOTICE")
                .boardIsComment("OFF")
                .boardContent("김진행")
                .userId(1L)
                .build();
        postBoardMapper.update(req);

        BoardResponse res = postBoardMapper.findById(1L);
        Assertions.assertEquals(res.getBoardContent(),"김진행");
    }

    @Test
    @DisplayName("게시글을 삭제해야 한다.")
    void deleteBoard(){



        BoardResponse res = postBoardMapper.findById(1L);
        postBoardMapper.deleteById(1L);
        Assertions.assertNull(res);
    }

}
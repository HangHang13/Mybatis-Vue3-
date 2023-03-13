package com.example.mybatis.mapper;

import com.example.mybatis.dto.req.BoardRequest;
import com.example.mybatis.dto.res.BoardResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        for (int i=0; i<posts.size();i++){
            System.out.println(posts.get(i).getBoardContent());
        }
    }

}
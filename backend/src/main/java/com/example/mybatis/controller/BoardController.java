package com.example.mybatis.controller;

import com.example.mybatis.dto.req.BoardRequest;
import com.example.mybatis.dto.res.BoardResponse;
import com.example.mybatis.dto.res.ResponseEntityDTO;
import com.example.mybatis.mapper.PostBoardMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BoardController {

    @Autowired
    private PostBoardMapper postBoardMapper;



//    @GetMapping("/board")
//    public ResponseEntityDTO<?> getList(){
////        List<HashMap> list = postBoardMapper.findAll();
////        list.stream().map(BoardResponse::new);
//        List<BoardResponse> list = postBoardMapper.findAll();
//        return new ResponseEntityDTO(200,"게시물 조회 성공",list);
//    }
    //게시글 전체조회
    @GetMapping("/board")
    public PageInfo<BoardResponse> findPage(HttpServletRequest request){
        PageHelper.startPage(request);
        return PageInfo.of(postBoardMapper.findAll());
    }

    //게시글 상세조회
    @GetMapping("/board/{board_id}")
    public ResponseEntityDTO<?> getBoard(@PathVariable("board_id") Long boardId){
        BoardResponse res = postBoardMapper.findById(boardId);
        if (res == null){
            return new ResponseEntityDTO(400,"해당 게시글이 없습니다.",res);
        }
        return new ResponseEntityDTO(200,"게시물 상세조회 성공",res);
    }
    //게시글 작성
    @PostMapping("/board")
    public ResponseEntityDTO<?> postBoard(
            @AuthenticationPrincipal String userId,
            @Validated @RequestBody BoardRequest requestDTO, BindingResult res){
        if (res.hasErrors()){
            log.info("DTO 검증 에러 발생: {}", res.getFieldError());
            return new ResponseEntityDTO(400,"게시물 작성에 실패했습니다.", res.getFieldError());
        }

        BoardRequest result = BoardRequest.builder()
                .boardContent(requestDTO.getBoardContent())
                .boardTitle(requestDTO.getBoardTitle())
                .boardWriter(requestDTO.getBoardWriter())
                .boardType(requestDTO.getBoardType())
                .createDate(LocalDateTime.now())
                .boardIsComment("OFF")
                .userId(userId)
                .build();
        System.out.println(userId);
        postBoardMapper.save(result);
        return new ResponseEntityDTO(200,"게시물 작성에 성공했습니다.",null);
    }

    @DeleteMapping("/board/{board_id}")
    public ResponseEntityDTO<?> deleteBoard(
            @AuthenticationPrincipal String userId,
            @PathVariable("board_id") Long boardId

    ){
        BoardResponse res = postBoardMapper.findById(boardId);
        System.out.println("res " + res.getUserId());
        System.out.println("userId " + userId);

        if (res.getUserId().equals(userId)){
            System.out.println("맞음");
        }
        else {
            System.out.println("틀림");
        }
        if (res == null){
            return new ResponseEntityDTO(400, "해당 게시글이 없습니다", null);
        }
        try {
            if (res.getUserId().equals(userId)){
            postBoardMapper.deleteById(boardId);
            return new ResponseEntityDTO(200, "해당 게시글이 삭제되었습니다", null);
        }else {
                return new ResponseEntityDTO(400, "본인이 작성한 글이 아닙니다.", null);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

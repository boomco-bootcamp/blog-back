package com.lecture.blog.biz.controller.comment;

import com.lecture.blog.biz.service.comment.CommentService;
import com.lecture.blog.biz.service.comment.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/comment", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 게시글 댓글 목록 조회
     * @param reqVO
     * @return
     */
    @GetMapping("/post/list")
    public ResponseEntity searchPostCommentList(CommentReqVO reqVO) {
        try {
            PagingListVO<CommentResVO> resultList = commentService.searchPostCommentList(reqVO);
            return ResponseEntity.ok().body(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

package com.lecture.blog.biz.controller.comment;

import com.lecture.blog.biz.service.comment.CommentService;
import com.lecture.blog.biz.service.comment.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

    /**
     * 게시글 댓글 작성
     * @param saveReqVO
     * @return
     */
    @PostMapping("/post/save")
    public ResponseEntity savePostComment(@RequestBody CommentSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setRgsnUserId(user.getUsername());
            saveReqVO.setAmnnUserId(user.getUsername());
            int result = commentService.savePostComment(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 게시글 댓글 삭제
     * @param saveReqVO
     * @return
     */
    @PostMapping("/post/delete")
    public ResponseEntity deletePostComment(@RequestBody CommentSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setRgsnUserId(user.getUsername());
            saveReqVO.setAmnnUserId(user.getUsername());
            int result = commentService.deletePostComment(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}

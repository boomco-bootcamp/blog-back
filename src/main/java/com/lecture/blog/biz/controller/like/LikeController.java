package com.lecture.blog.biz.controller.like;

import com.lecture.blog.biz.service.like.LikeService;
import com.lecture.blog.biz.service.like.vo.LikeSaveReqVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/like", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }


    /**
     * 게시글 좋아요 추가 또는 삭제
     * @param saveReqVO
     * @return
     */
    @PostMapping("/post/save")
    public ResponseEntity savePostLike(@RequestBody LikeSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setRgsnUserId(user.getUsername());
            int result = likeService.savePostLike(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 게시글 좋아요 체크
     * @param saveReqVO
     * @return
     */
    @PostMapping("/post/check")
    public ResponseEntity savePostCheck(@RequestBody LikeSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            saveReqVO.setRgsnUserId(user.getUsername());
            boolean result = likeService.checkPostLike(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

package com.lecture.blog.biz.controller.post;

import com.lecture.blog.biz.service.post.PostService;
import com.lecture.blog.biz.service.post.vo.PostReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/post", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * 게시글 목록 조회
     * @param reqVO
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity searchPostInfoList(PostReqVO reqVO) {
        try {
            PagingListVO<PostResVO> resultList = postService.searchPostInfoList(reqVO);
            return ResponseEntity.ok().body(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 게시글 상세 정보 조회
     * @param reqVO
     * @return
     */
    @GetMapping("/detail")
    public ResponseEntity searchPostInfo(PostReqVO reqVO) {
        try {
            PostResVO result = postService.searchPostInfo(reqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

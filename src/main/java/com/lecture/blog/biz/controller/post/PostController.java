package com.lecture.blog.biz.controller.post;

import com.lecture.blog.biz.service.post.PostService;
import com.lecture.blog.biz.service.post.vo.PostReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.post.vo.PostSaveReqVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

    /**
     * 게시글 작성 및 수정
     * @param saveReqVO
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity savePostInfo(@RequestBody PostSaveReqVO saveReqVO) {
        try {
            //임시 등록사용자 및 수정 사용자 이름
            saveReqVO.setRgsnUserId("de04a114-b0f0-4ccb-c1ee-93559e6bde10");
            saveReqVO.setAmnnUserId("de04a114-b0f0-4ccb-c1ee-93559e6bde10");
            int result = postService.savePostInfo(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 게시글 삭제
     * @param saveReqVO
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity deleteStudyInfo(@RequestBody PostSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            //임시 등록사용자 및 수정 사용자 이름
            saveReqVO.setRgsnUserId("de04a114-b0f0-4ccb-c1ee-93559e6bde10");
            saveReqVO.setAmnnUserId("de04a114-b0f0-4ccb-c1ee-93559e6bde10");
            int result = postService.deletePostInfo(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }





}

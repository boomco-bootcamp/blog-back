package com.lecture.blog.biz.controller.post;

import com.lecture.blog.biz.service.post.PostService;
import com.lecture.blog.biz.service.post.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity searchPostInfoList(PostReqVO reqVO, @AuthenticationPrincipal User user) {
        try {
            if (user != null) {
                reqVO.setUserId(user.getUsername());
            }
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
    public ResponseEntity searchPostInfo(PostReqVO reqVO, @AuthenticationPrincipal User user) {
        try {
            if (user != null) {
                reqVO.setUserId(user.getUsername());
            }
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
    public ResponseEntity savePostInfo(@RequestBody PostSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setRgsnUserId(user.getUsername());
            saveReqVO.setAmnnUserId(user.getUsername());
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
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setRgsnUserId(user.getUsername());
            saveReqVO.setAmnnUserId(user.getUsername());
            int result = postService.deletePostInfo(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 블로그 조회
     * @param reqVO
     * @return
     */
    @GetMapping("/blog")
    public ResponseEntity searchBlog(PostReqVO reqVO, @AuthenticationPrincipal User user) {
        try {
            if (user != null) {
                reqVO.setUserId(user.getUsername());
            }
            PostResVO result = postService.searchPostInfo(reqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 블로그 게시글 방문자 수 통계
     * @param blogPostId
     * @return
     */
    @GetMapping("view/list")
    public ResponseEntity searchPostViewList(@RequestParam("blogPostId") String blogPostId) {
        try {
            List<PostViewResVO> resultList = postService.searchPostViewList(blogPostId);
            return ResponseEntity.ok().body(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 블로그 게시글 좋아요 수 통계
     * @param blogPostId
     * @return
     */
    @GetMapping("/like/list")
    public ResponseEntity searchPostLikeList(@RequestParam("blogPostId") String blogPostId) {
        try {
            List<PostLikeResVO> resultList = postService.searchPostLikeList(blogPostId);
            return ResponseEntity.ok().body(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



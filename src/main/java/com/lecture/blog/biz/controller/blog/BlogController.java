package com.lecture.blog.biz.controller.blog;

import com.lecture.blog.biz.service.blog.vo.*;
import com.lecture.blog.biz.service.blog.BlogService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/blog", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 블로그 조회
     * @param reqVO
     * @return
     */
    @GetMapping("/info")
    public ResponseEntity searchBlogInfo(BlogReqVO reqVO, @AuthenticationPrincipal User user) {
        try {
            if (user != null) {
                reqVO.setUserId(user.getUsername());
            }
            BlogInfoVO result = blogService.searchBlogInfo(reqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 블로그 정보 수정
     * @param saveReqVO
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity updateBlogInfo(@RequestBody BlogSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setUserId(user.getUsername());
            int result = blogService.updateBlogInfo(saveReqVO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 블로그 방문자수 통계
     * @param blogId
     * @return
     */
    @GetMapping("/view/list")
    public ResponseEntity searchBlogViewList(@RequestParam("blogId") String blogId) {
        try {
            List<BlogViewResVO> resultList = blogService.searchBlogViewList(blogId);
            return ResponseEntity.ok().body(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}



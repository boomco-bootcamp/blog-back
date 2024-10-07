package com.lecture.blog.biz.controller.blog;

import com.lecture.blog.biz.service.blog.vo.BlogInfoVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.blog.BlogService;
import com.lecture.blog.biz.service.blog.vo.BlogReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogResVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;

import com.lecture.blog.biz.service.post.vo.PostReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

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
}



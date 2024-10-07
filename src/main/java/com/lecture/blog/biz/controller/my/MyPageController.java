package com.lecture.blog.biz.controller.my;

import com.lecture.blog.biz.service.category.CategoryService;
import com.lecture.blog.biz.service.category.vo.CategoryVO;
import com.lecture.blog.biz.service.category.vo.MyCategoryReqVO;
import com.lecture.blog.biz.service.category.vo.MyCategorySaveReqVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.like.LikeService;
import com.lecture.blog.biz.service.like.vo.LikeReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.tag.TagService;
import com.lecture.blog.biz.service.tag.vo.MyTagSaveReqVO;
import com.lecture.blog.biz.service.tag.vo.MyTagVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/my", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MyPageController {

    private final LikeService likeService;
    private final TagService tagService;
    private final CategoryService categoryService;

    public MyPageController(LikeService likeService, TagService tagService, CategoryService categoryService) {
        this.likeService = likeService;
        this.tagService = tagService;
        this.categoryService = categoryService;
    }


    /**
     * 관심 카테고리 목록 조회
     * @param user
     * @return
     */
    @GetMapping("/category/list")
    public ResponseEntity seachMyCategoryList(@AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            MyCategoryReqVO reqVO = new MyCategoryReqVO();
            reqVO.setUserId(user.getUsername());
            List<CategoryVO> resultList = categoryService.seachMyCategoryList(reqVO);
            return ResponseEntity.ok(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 관심 카테고리 추가 / 삭제
     * @param saveReqVO
     * @param user
     * @return
     */
    @PostMapping("/category/save")
    public ResponseEntity saveMyCategory(@RequestBody MyCategorySaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setUserId(user.getUsername());
            saveReqVO.setRgsnUserId(user.getUsername());
            int result = categoryService.saveMyCategory(saveReqVO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 관심 태그 목록 조회
     * @param user
     * @return
     */
    @GetMapping("/tag/list")
    public ResponseEntity searchMyTagList(@AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            List<MyTagVO> resultList = tagService.searchMyTagList(user.getUsername());
            return ResponseEntity.ok(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 관심 태그 추가
     * @param saveReqVO
     * @param user
     * @return
     */
    @PostMapping("/tag/add")
    public ResponseEntity addMyTag(@RequestBody MyTagSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setUserId(user.getUsername());
            saveReqVO.setRgsnUserId(user.getUsername());
            int result = tagService.addMyTag(saveReqVO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 관심 태그 삭제
     * @param saveReqVO
     * @param user
     * @return
     */
    @PostMapping("/tag/delete")
    public ResponseEntity deleteMyTag(@RequestBody MyTagSaveReqVO saveReqVO, @AuthenticationPrincipal User user) {
        try {
            if(user == null) throw new Exception("로그인이 필요한 서비스 입니다.");
            saveReqVO.setUserId(user.getUsername());
            int result = tagService.deleteMyTag(saveReqVO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 관심 게시글 목록 조회
     * @param reqVO
     * @param user
     * @return
     */
    @GetMapping("/post/like/list")
    public ResponseEntity searchMyPostLikeList(LikeReqVO reqVO, @AuthenticationPrincipal User user) {
        try {
            if (user != null) {
                reqVO.setUserId(user.getUsername());
            }
            PagingListVO<PostResVO> resultList = likeService.searchMyPostLikeList(reqVO);
            return ResponseEntity.ok(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

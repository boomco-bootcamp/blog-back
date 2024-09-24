package com.lecture.blog.biz.controller.category;

import com.lecture.blog.biz.service.category.CategoryService;
import com.lecture.blog.biz.service.category.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/category", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 게시글 카테고리 전체 목록 조회
     * @return
     */
    @GetMapping("/list/all")
    public ResponseEntity searchAllCategoryList() {
        try {
            List<CategoryVO> resultList = categoryService.searchAllCategoryList();
            return ResponseEntity.ok().body(resultList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

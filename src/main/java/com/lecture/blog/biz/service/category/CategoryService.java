package com.lecture.blog.biz.service.category;


import com.lecture.blog.biz.service.category.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    /**
     * 스터디 카테고리 전체 목록 조회
     * @return
     */
    List<CategoryVO> searchAllCategoryList();

}

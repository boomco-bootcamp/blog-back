package com.lecture.blog.biz.service.category;

import com.lecture.blog.biz.service.category.repo.CategoryRepository;
import com.lecture.blog.biz.service.category.vo.CategoryVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * 스터디 카테고리 전체 목록 조회
     * @return
     */
    @Override
    public List<CategoryVO> searchAllCategoryList() {
        try {
            List<CategoryVO> resultList = categoryRepository.selectAllCategoryList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}

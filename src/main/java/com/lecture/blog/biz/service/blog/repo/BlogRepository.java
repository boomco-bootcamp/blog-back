package com.lecture.blog.biz.service.blog.repo;

import com.lecture.blog.biz.service.blog.vo.BlogReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogInfoVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogRepository {

    /**************************************************
     * 블로그 정보
     **************************************************/

    // 블로그 정보 조회
    BlogInfoVO selectBlogInfo(BlogReqVO reqVO);

    // 블로그 정보 변경
    int updateBlogInfo(BlogSaveReqVO saveReqVO);

}

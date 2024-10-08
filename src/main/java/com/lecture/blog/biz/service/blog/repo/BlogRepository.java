package com.lecture.blog.biz.service.blog.repo;

import com.lecture.blog.biz.service.blog.vo.BlogReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogInfoVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;

import com.lecture.blog.biz.service.blog.vo.BlogViewResVO;
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

    // 블로그 방문자 체크
    boolean checkBlogViewed(BlogReqVO saveReqVO);

    // 블로그 방문자 추가
    int insertBlogView(BlogReqVO saveReqVO);

    // 블로그 방문자 통계
    List<BlogViewResVO> selectBlogViewList(@Param("blogId")String blogId);

}

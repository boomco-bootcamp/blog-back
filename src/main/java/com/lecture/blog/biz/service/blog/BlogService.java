package com.lecture.blog.biz.service.blog;

import com.lecture.blog.biz.service.blog.vo.*;

import java.util.List;


/**
 * 블로그 관련 서비스
 */
public interface BlogService {

    /**
     * 블로그 정보 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    BlogInfoVO searchBlogInfo(BlogReqVO reqVO) throws Exception;

    /**
     * 블로그 정보 변경
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    int updateBlogInfo(BlogSaveReqVO saveReqVO) throws Exception;

    /**
     * 블로그 방문자수 통계
     * @param blogId
     * @return
     * @throws Exception
     */
    List<BlogViewResVO> searchBlogViewList(String blogId) throws Exception;




}
